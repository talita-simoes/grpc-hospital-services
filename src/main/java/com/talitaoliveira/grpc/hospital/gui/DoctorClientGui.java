package com.talitaoliveira.grpc.hospital.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.proto.doctor.*;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class DoctorClientGui implements ActionListener {

    //DOCTOR SERVICE VARIABLES----------------------------------------------

    private final JLabel registerDLabel = new JLabel("---- Register Doctor ----");

    private final JLabel entry1Label = new JLabel("First Name:");
    private final JTextField entry1 = new JTextField("", 15);

    private final JLabel entry1bLabel = new JLabel("Last Name:");
    private final JTextField entry1b = new JTextField("", 15);

    private final JLabel entry1cLabel = new JLabel("Specialty:");
    private final JTextField entry1c = new JTextField("", 15);

    private final JButton doctorBtn = new JButton("Register Doctor");
    private final JTextArea reply1 = new JTextArea(4, 40);

    private final JLabel findDLabel = new JLabel("---- Find Doctors ----");

    private final JLabel entry2Label = new JLabel("Search by Specialty");
    private final JTextField entry2 = new JTextField("0", 5);

    private final JButton findBtn = new JButton("Find Doctors");
    private final JTextArea reply2 = new JTextArea(15, 40);


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
        patientPanel2.add(registerDLabel, gridBagConstraints1A);

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
        doctorBtn.addActionListener(this);
        patientPanel2.add(doctorBtn, gridBagConstraints1A);

        gridBagConstraints1A.gridx = 0;
        gridBagConstraints1A.gridy = 7;
        patientPanel2.add(reply1, gridBagConstraints1A);

        gridBagConstraints1A.anchor = GridBagConstraints.WEST;
        gridBagConstraints1A.gridx = 0;
        gridBagConstraints1A.gridy = 8;
        patientPanel2.add(findDLabel, gridBagConstraints1A);

        gridBagConstraints1A.anchor = GridBagConstraints.WEST;
        gridBagConstraints1A.gridx = 0;
        gridBagConstraints1A.gridy = 9;
        patientPanel2.add(entry2Label,gridBagConstraints1A);

        gridBagConstraints1A.anchor = GridBagConstraints.WEST;
        gridBagConstraints1A.gridx = 0;
        gridBagConstraints1A.gridy = 10;
        patientPanel2.add(entry2, gridBagConstraints1A);

        gridBagConstraints1A.gridx = 0;
        gridBagConstraints1A.gridy = 13;
        gridBagConstraints1A.gridwidth = 2;
        gridBagConstraints1A.anchor = GridBagConstraints.CENTER;
        findBtn.addActionListener(this);
        patientPanel2.add(findBtn, gridBagConstraints1A);

        gridBagConstraints1A.gridx = 0;
        gridBagConstraints1A.gridy = 14;
        patientPanel2.add(reply2, gridBagConstraints1A);



        // set border for the panel
        patientPanel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Hospital Panel2"));

        panel2.add("Hospital Panel2", patientPanel2);

        return panel2;

    }

    // MAIN METHOD TO RUN---------------------------------------------------
    public static void main(String[] args) {

        DoctorClientGui gui = new DoctorClientGui();

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
        if (label.equals("Register Doctor")) {
            System.out.println("Register doctor to be invoked ...");


            /*
             *
             */
            ManagedChannel channelA = ManagedChannelBuilder.forAddress("localhost", 50052)
                    .usePlaintext()
                    .build();
            DoctorServiceGrpc.DoctorServiceBlockingStub registerDoctorClient = DoctorServiceGrpc.newBlockingStub
                    (channelA);

            // sets the fields to be entered by the user
            DoctorId doctorId = DoctorId.newBuilder()
                    .setFirstName(entry1.getText())
                    .setLastName(entry1b.getText())
                    .setSpecialty(entry1c.getText())
                    .build();

            RegisterDoctorRequest registerDoctorRequest = RegisterDoctorRequest.newBuilder()
                    .setDoctorId(doctorId)
                    .build();

            RegisterDoctorResponse registerDoctorResponse = registerDoctorClient.registerDoctor(registerDoctorRequest);

            System.out.println(registerDoctorResponse.getResult());

            reply1.append(String.valueOf(registerDoctorResponse.getResult()));

        } else if (label.equals("Find Doctors")) {
            System.out.println("service find doctors to be invoked ...");

            System.out.println("Find Doctors to be invoked ...");
            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052)
                    .usePlaintext()
                    .build();
            DoctorServiceGrpc.DoctorServiceBlockingStub doctorClient = DoctorServiceGrpc.newBlockingStub(channel);


            DoctorRequest doctorRequest =
                    DoctorRequest.newBuilder()
                            .setDoctorId(DoctorId.newBuilder().setSpecialty(entry2.getText()))
                            .build();

            // preparing message to send

            new Thread(() -> {


                try {
                    reply2.setText("Searching for Available Doctors...\n");
                    Thread.sleep(2000L);
                    //find a method to clear in swing
                    reply2.append("Specialty Requested: " + entry2.getText() + "\n");
                    doctorClient.doctor(doctorRequest)

                            .forEachRemaining(doctorResponse -> {
                                reply2.append(" is Available\n");
                                reply2.append(doctorResponse.getResult() + "\n");

                            });
                    reply2.append("----No More Doctors Available----");
                    button.setDefaultCapable(false);
                } catch (InterruptedException ea) {
                    ea.printStackTrace();
                } catch (StatusRuntimeException eb) {
                    JOptionPane.showConfirmDialog(null, "Server Not running");
                }
            }).start();
        }

    }

}
