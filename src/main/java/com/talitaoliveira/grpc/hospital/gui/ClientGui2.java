package com.talitaoliveira.grpc.hospital.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.proto.beds.BedsAvailableRequest;
import com.proto.beds.BedsAvailableResponse;
import com.proto.beds.BedsServiceGrpc;
import com.proto.doctor.*;
import com.proto.patient.*;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;


public class ClientGui2 implements ActionListener, PropertyChangeListener {


    //private JTextField entry1, entry1b, entry1c, reply1;------------------
    private final JLabel entry1Label = new JLabel("PPS Number:");
    private final JTextField entry1 = new JTextField("", 10);

    private final JLabel entry1bLabel = new JLabel("First Name");
    private final JTextField entry1b = new JTextField("", 10);

    private final JLabel entry1cLabel = new JLabel("Last Name:");
    private final JTextField entry1c = new JTextField("", 10);

    private final JButton patientBtn = new JButton("Register Patient");
    private final JTextArea reply1 = new JTextArea(10, 30);

    //----------------------------------------------------------------------

    private JPanel getService1JPanel() {

        JPanel panel = new JPanel();

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5, 5, 5, 5);

        JPanel patientPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
        gridBagConstraints1.anchor = GridBagConstraints.WEST;
        gridBagConstraints1.insets = new Insets(10, 10, 10, 10);

        // add components to the panel
        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.gridy = 0;
        patientPanel.add(entry1Label, gridBagConstraints1);



        gridBagConstraints1.gridx = 1;
        patientPanel.add(entry1, gridBagConstraints1);

        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.gridy = 1;
        patientPanel.add(entry1bLabel, gridBagConstraints1);

        gridBagConstraints1.gridx = 1;
        patientPanel.add(entry1b, gridBagConstraints1);


        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.gridy = 5;
        gridBagConstraints1.gridwidth = 2;
        gridBagConstraints1.anchor = GridBagConstraints.CENTER;
        patientBtn.addActionListener(this);
        patientPanel.add(patientBtn, gridBagConstraints1);

        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.gridy = 6;
        patientPanel.add(reply1, gridBagConstraints1);


        // set border for the panel
        patientPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Patient Service"));
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        return panel;

    }


    public static void main(String[] args) {

        ClientGui gui = new ClientGui();

        gui.build();
    }

    private void build() {

        JFrame frame = new JFrame("Hospital-GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the panel to add buttons
        JPanel panel = new JPanel();

        // Set the BoxLayout to be X_AXIS: from left to right
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

        panel.setLayout(boxlayout);

        // Set border for the panel
        panel.setBorder(new EmptyBorder(new Insets(50, 100, 50, 100)));

        panel.add(getService1JPanel());

        // Set size for the frame
        frame.setSize(300, 300);

        // Set the window to be visible as the default to be false
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String label = button.getActionCommand();

        // THIS ACTIVATES THE METHOD  - Invoke service 1
        if (label.equals("Register Patient")) {
            System.out.println("Register patient to be invoked ...");


            /*
             *
             */
            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                    .usePlaintext()
                    .build();
            PatientServiceGrpc.PatientServiceBlockingStub patientClient = PatientServiceGrpc.newBlockingStub(channel);


            PatientId patientId = PatientId.newBuilder()
                    .setPpsNo(entry1.getText())
                    .setFirstName(entry1b.getText())
                    .setLastName(entry1c.getText())
                    .build();

            PatientRequest patientRequest = PatientRequest.newBuilder()
                    .setPatientId(patientId)
                    .build();

            //preparing message to send
            PatientResponse patientResponse = patientClient.patient(patientRequest);

            System.out.println(patientResponse.getResult());
            //retrieving reply from service

            reply1.setText(String.valueOf(patientResponse.getResult()));

        }

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
