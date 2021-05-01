package com.talitaoliveira.grpc.hospital.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.proto.beds.*;
import com.proto.doctor.*;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class BedsClientGui implements ActionListener {

    // BEDS SERVICE VARIABLES-------------------------------------------
    private final JLabel streamingLabel = new JLabel("---- Streaming Beds ----");

    private final JButton bedsBtn = new JButton("Beds Available");

    private final JLabel entry1Label = new JLabel("Client Streaming");

    private final JTextArea entry1 = new JTextArea(10, 40);

    private final JLabel reply1Label = new JLabel("Server Streaming ");

    private final JTextArea reply1 = new JTextArea(10, 40);

    private final JLabel roomLabel = new JLabel("---- Available Single Rooms ----");

    private final JLabel entry2Label = new JLabel("Enter the floor:");

    private  final JTextField entry2 = new JTextField("1",5);

    private final JButton roomsBtn = new JButton("Find Rooms");

    private final JTextArea reply2 = new JTextArea(12, 40);



    // BEDS SERVICE FIELDS-----------------------------------------------
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
        patientPanel2.add(streamingLabel, gridBagConstraints1A);

        gridBagConstraints1A.gridx = 0;
        gridBagConstraints1A.gridy = 2;
        gridBagConstraints1A.gridwidth = 2;
        gridBagConstraints1A.anchor = GridBagConstraints.CENTER;//ses the button to the center
        bedsBtn.addActionListener(this);
        patientPanel2.add(bedsBtn, gridBagConstraints1A);

        gridBagConstraints1A.anchor = GridBagConstraints.WEST;
        gridBagConstraints1A.gridx = 0;
        gridBagConstraints1A.gridy = 3;
        patientPanel2.add(entry1Label, gridBagConstraints1A);

        gridBagConstraints1A.gridx = 0;
        gridBagConstraints1A.gridy = 4;
        patientPanel2.add(entry1, gridBagConstraints1A);

        gridBagConstraints2A.gridx = 0;
        gridBagConstraints2A.gridy = 5;
        patientPanel2.add(reply1Label, gridBagConstraints2A);

        gridBagConstraints1A.gridx = 0;
        gridBagConstraints1A.gridy = 6;
        patientPanel2.add(reply1, gridBagConstraints1A);

        gridBagConstraints1A.gridx = 0;
        gridBagConstraints1A.gridy = 7;
        patientPanel2.add(roomLabel, gridBagConstraints1A);

        gridBagConstraints1A.anchor = GridBagConstraints.WEST;
        gridBagConstraints1A.gridx = 0;
        gridBagConstraints1A.gridy = 8;
        patientPanel2.add(entry2Label, gridBagConstraints1A);

        gridBagConstraints1A.gridx = 1;
        gridBagConstraints1A.gridy = 8;
        patientPanel2.add(entry2, gridBagConstraints1A);

        gridBagConstraints1A.gridx = 0;
        gridBagConstraints1A.gridy = 9;
        gridBagConstraints1A.gridwidth = 2;
        gridBagConstraints1A.anchor = GridBagConstraints.CENTER;//ses the button to the center
        roomsBtn.addActionListener(this);
        patientPanel2.add(roomsBtn, gridBagConstraints1A);

        gridBagConstraints1A.gridx = 0;
        gridBagConstraints1A.gridy = 10;
        patientPanel2.add(reply2, gridBagConstraints1A);

        // set border for the panel
        patientPanel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Beds Panel"));

        panel2.add("Beds Panel", patientPanel2);

        return panel2;

    }

    // MAIN METHOD TO RUN---------------------------------------------------
    public static void main(String[] args) {

        BedsClientGui gui = new BedsClientGui();

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

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String label = button.getActionCommand();

        // THIS ACTIVATES THE METHOD  - Invoke service 1
        if (label.equals("Beds Available")) {
            System.out.println("Beds Available to be invoked ...");

            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053)
                    .usePlaintext()
                    .build();

            BedsServiceGrpc.BedsServiceStub asyncClient = BedsServiceGrpc.newStub(channel);

            StreamObserver<BedsAvailableRequest> requestObserver  = asyncClient.bedsAvailable(new StreamObserver<BedsAvailableResponse>() {

                @Override
                public void onNext(BedsAvailableResponse value) {
                    System.out.println("Total of Beds Available Now:" + value.getNumberBack());
                    reply1.append("Beds Available: "+ String.valueOf(value.getNumberBack())+"\n");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                @Override
                public void onError(Throwable t) {
                }
                @Override
                public void onCompleted() {
                }
            });

            entry1.setText("Beds Requested/Returned...\n");

            Arrays.asList(43,-1,-5,-3,-1,2,-2,-2).forEach(
                    number -> {
                        System.out.println("Requested/Returned Beds: " + number);

                        entry1.append(String.valueOf(number)+"\n");

                        requestObserver.onNext(BedsAvailableRequest.newBuilder()
                                .setNumberGo(number)
                                .build());
                        try {
                            Thread.sleep(3000L);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }

            );

            requestObserver.onCompleted();

        } else if(label.equals("Find Rooms")) {
            System.out.println("service find rooms to be invoked ...");

            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053)
                    .usePlaintext()
                    .build();

            BedsServiceGrpc.BedsServiceBlockingStub roomsClient = BedsServiceGrpc.newBlockingStub(channel);

            RoomsAvailableRequest roomsAvailableRequest =
                    RoomsAvailableRequest.newBuilder()
                            .setFloor(entry2.getText())
                            .build();
                        new Thread(() -> {


                try {
                    reply2.setText("Searching for Available Rooms...\n");
                    Thread.sleep(2000L);

                    roomsClient.roomsAvailable(roomsAvailableRequest).forEachRemaining(roomsAvailableResponse -> {
                        reply2.append(roomsAvailableResponse.getResult()+"\n");
                    });

                    reply2.append("----End of Searching----");
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


