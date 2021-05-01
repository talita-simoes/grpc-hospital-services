package com.talitaoliveira.grpc.hospital.gui;
/*
 This class implements the GUI to run Patient Service
 */


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.proto.patient.*;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;


public class PatientClientGui implements ActionListener, PropertyChangeListener {


    //PATIENT SERVICE VARIABLES----------------------------------------------

    private final JLabel registerLabel = new JLabel("---- Register Patient ----");

    private final JLabel entry1Label = new JLabel(" PPS Number:");
    private final JTextField entry1 = new JTextField("", 15);

    private final JLabel entry1bLabel = new JLabel(" First Name:");
    private final JTextField entry1b = new JTextField("", 15);

    private final JLabel entry1cLabel = new JLabel("Last Name:");
    private final JTextField entry1c = new JTextField("", 15);

    private final JButton patientBtn = new JButton("Register Patient");
    private final JTextArea reply1 = new JTextArea(3, 40);

    private final JLabel averageLabel = new JLabel("---- Average Patients ----");

    private final JLabel entry2Label = new JLabel("Average Patients/h:");
    private final JTextField entry2 = new JTextField("0", 5);
    private final JTextField entry2a = new JTextField("0", 5);
    private final JTextField entry2b = new JTextField("0", 5);
    private final JTextField entry2c = new JTextField("0", 5);
    private final JTextField entry2d = new JTextField("0", 5);
    private final JTextField entry2e = new JTextField("0", 5);

    private final JButton averageBtn = new JButton("Calculate!");
    private final JTextArea reply2 = new JTextArea(3, 40);


    // PATIENT SERVICE FIELDS-----------------------------------------------
    private JPanel getHospitalJPanel() {

        JPanel panel2 = new JPanel();

        GridBagConstraints constraintsA = new GridBagConstraints();
        constraintsA.anchor = GridBagConstraints.WEST;
        constraintsA.insets = new Insets(10, 10, 10, 10);

        JPanel patientPanel2 = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints1A = new GridBagConstraints();
        gridBagConstraints1A.anchor = GridBagConstraints.WEST;
        gridBagConstraints1A.insets = new Insets(5, 5, 5, 5);

        GridBagConstraints gridBagConstraints2A = new GridBagConstraints();
        gridBagConstraints2A.anchor = GridBagConstraints.WEST;
        gridBagConstraints2A.insets = new Insets(10, 10, 10, 10);

        // add components to the panel

        gridBagConstraints1A.gridx = 0;
        gridBagConstraints1A.gridy = 0;
        patientPanel2.add(registerLabel, gridBagConstraints1A);

        gridBagConstraints1A.gridx = 0;
        gridBagConstraints1A.gridy = 1;
        patientPanel2.add(entry1Label, gridBagConstraints1A);

        gridBagConstraints1A.gridx = 1;
        patientPanel2.add(entry1, gridBagConstraints1A);

        gridBagConstraints1A.gridx = 0;
        gridBagConstraints1A.gridy = 2;
        patientPanel2.add(entry1bLabel, gridBagConstraints1A);

        gridBagConstraints1A.gridx = 1;
        patientPanel2.add(entry1b, gridBagConstraints1A);

        gridBagConstraints2A.gridx = 0;
        gridBagConstraints2A.gridy = 3;
        patientPanel2.add(entry1cLabel, gridBagConstraints2A);

        gridBagConstraints2A.gridx = 1;
        patientPanel2.add(entry1c, gridBagConstraints2A);

        gridBagConstraints1A.gridx = 0;
        gridBagConstraints1A.gridy = 6;
        gridBagConstraints1A.gridwidth = 2;
        gridBagConstraints1A.anchor = GridBagConstraints.CENTER;//ses the button to the center
        patientBtn.addActionListener(this);
        patientPanel2.add(patientBtn, gridBagConstraints1A);

        gridBagConstraints1A.gridx = 0;
        gridBagConstraints1A.gridy = 7;
        patientPanel2.add(reply1, gridBagConstraints1A);

        gridBagConstraints1A.anchor = GridBagConstraints.WEST;
        gridBagConstraints1A.gridx = 0;
        gridBagConstraints1A.gridy = 8;
        patientPanel2.add(averageLabel, gridBagConstraints1A);

        gridBagConstraints1A.anchor = GridBagConstraints.WEST;
        gridBagConstraints1A.gridx = 0;
        gridBagConstraints1A.gridy = 9;
        patientPanel2.add(entry2Label,gridBagConstraints1A);

        gridBagConstraints1A.anchor = GridBagConstraints.WEST;
        gridBagConstraints1A.gridx = 0;
        gridBagConstraints1A.gridy = 10;
        patientPanel2.add(entry2, gridBagConstraints1A);

        gridBagConstraints1A.gridx = 1;
        gridBagConstraints1A.gridy = 10;
        patientPanel2.add(entry2a, gridBagConstraints1A);

        gridBagConstraints1A.gridx = 0;
        gridBagConstraints1A.gridy = 11;
        patientPanel2.add(entry2b, gridBagConstraints1A);

        gridBagConstraints1A.gridx = 1;
        gridBagConstraints1A.gridy = 11;
        patientPanel2.add(entry2c, gridBagConstraints1A);

        gridBagConstraints1A.gridx = 0;
        gridBagConstraints1A.gridy = 12;
        patientPanel2.add(entry2d, gridBagConstraints1A);

        gridBagConstraints1A.gridx = 1;
        gridBagConstraints1A.gridy = 12;
        patientPanel2.add(entry2e, gridBagConstraints1A);

        gridBagConstraints1A.gridx = 0;
        gridBagConstraints1A.gridy = 13;
        gridBagConstraints1A.gridwidth = 2;
        gridBagConstraints1A.anchor = GridBagConstraints.CENTER;
        averageBtn.addActionListener(this);
        patientPanel2.add(averageBtn, gridBagConstraints1A);

        gridBagConstraints1A.gridx = 0;
        gridBagConstraints1A.gridy = 14;
        patientPanel2.add(reply2, gridBagConstraints1A);



        // set border for the panel
        patientPanel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Patient Panel"));

        panel2.add("Patient Panel", patientPanel2);

        return panel2;

    }

    // MAIN METHOD TO RUN---------------------------------------------------
    public static void main(String[] args) {

        PatientClientGui gui = new PatientClientGui();

        gui.build();
    }

    private void build() {

        JFrame frame = new JFrame("Hospital Services");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the panel to add buttons
        JPanel panel = new JPanel();

        // Set the BoxLayout to be X_AXIS: from left to right
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.PAGE_AXIS);

        panel.setLayout(boxlayout);

        // Sets an empty border around the panel
        panel.setBorder(new EmptyBorder(new Insets(20, 20, 20, 20)));

        panel.add(getHospitalJPanel());

        // Set size for the frame
        frame.setSize(2000, 2000);

        // Set the window to be visible as the default to be false
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    //ACTIONS TO BE PERFORMED-----------------------------------------------
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

        } else if (label.equals("Calculate!")) {
            System.out.println("service patient-average to be invoked ...");

            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                    .usePlaintext()
                    .build();
            //Service3Grpc.Service3BlockingStub blockingStub = Service3Grpc.newBlockingStub(channel);
            PatientServiceGrpc.PatientServiceStub asyncClient = PatientServiceGrpc.newStub(channel);
            //preparing message to send
            CountDownLatch latch = new CountDownLatch(1);

            StreamObserver<PatientAverageRequest> requestObserver = asyncClient.patientAverage(new StreamObserver<PatientAverageResponse>() {
                @Override
                public void onNext(PatientAverageResponse value) {
                    System.out.println("Received response from Server");
                    System.out.println("Average patients/hour:\n " + value.getPatientAverage());
                    reply2.setText("Average patients/hour:\n " + value.getPatientAverage());
                }

                @Override
                public void onError(Throwable t) {

                }

                @Override
                public void onCompleted() {
                    System.out.println("Server has completed sending data");
                    latch.countDown();
                }
            });

            int num1 = Integer.parseInt(entry2.getText());
            int num2 = Integer.parseInt(entry2a.getText());
            int num3 = Integer.parseInt(entry2b.getText());
            int num4 = Integer.parseInt(entry2c.getText());
            int num5 = Integer.parseInt(entry2d.getText());
            int num6 = Integer.parseInt(entry2e.getText());

            requestObserver.onNext(PatientAverageRequest.newBuilder()
                    .setNumberPatients(num1)
                    .build());

            requestObserver.onNext(PatientAverageRequest.newBuilder()
                    .setNumberPatients(num2)
                    .build());

            requestObserver.onNext(PatientAverageRequest.newBuilder()
                    .setNumberPatients(num3)
                    .build());

            requestObserver.onNext(PatientAverageRequest.newBuilder()
                    .setNumberPatients(num4)
                    .build());

            requestObserver.onNext(PatientAverageRequest.newBuilder()
                    .setNumberPatients(num5)
                    .build());

            requestObserver.onNext(PatientAverageRequest.newBuilder()
                    .setNumberPatients(num6)
                    .build());

            requestObserver.onCompleted();

            try {
                latch.await(3, TimeUnit.SECONDS);
            } catch (InterruptedException ec) {
                ec.printStackTrace();
            }

        }

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}

