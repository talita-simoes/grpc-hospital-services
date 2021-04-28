package com.talitaoliveira.grpc.hospital.client;
/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */


/*
 * TabbedPaneDemo.java requires one additional file:
 *   images/middle.gif.
 */

import com.proto.patient.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class HospitalClientTable extends JPanel {


    private JTextField entry1, entry1b, entry1c, reply1;
    private JTextField entry2;
    private JTextArea reply2;

    private JTextField entry3;
    private JTextField entry3a;
    private JTextField entry3b;
    private JTextField entry3c;
    private JTextField entry3d;
    private JTextField entry3e;
    private JTextField reply3;


    public HospitalClientTable() {
        super(new GridLayout(1, 1));

        JTabbedPane tabbedPane = new JTabbedPane();
        ImageIcon icon = createImageIcon("images/middle.gif");

        JComponent panel1 = makeTextPanel("Panel #1");

        tabbedPane.addTab("Patient", icon, panel1,
                "Does nothing");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

        JComponent panel2 = makeTextPanel("Panel #2");
        tabbedPane.addTab("Tab 2", icon, panel2,
                "Does twice as much nothing");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

        JComponent panel3 = makeTextPanel("Panel #3");
        tabbedPane.addTab("Tab 3", icon, panel3,
                "Still does nothing");
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);


        //Add the tabbed pane to this panel.
        add(tabbedPane);

        //The following line enables to use scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }

    //HERE THE COMPONENTS OF THE TAB ARE INSERTED
    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        entry1 = new JTextField("pps number", 10);
        panel.add(entry1);
        entry1b = new JTextField("first name", 10);
        panel.add(entry1b);
        entry1c = new JTextField("last name", 10);
        panel.add(entry1c);
        panel.add(Box.createRigidArea(new Dimension(8, 4)));

        JButton button = new JButton("Register Patient");
        button.addActionListener(this::actionPerformed);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        reply1 = new JTextField("", 10);
        reply1.setEditable(false);
        panel.add(reply1);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JLabel label = new JLabel("Enter value");
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        entry3 = new JTextField();
        entry3.setColumns(2);
        panel.add(entry3);
        entry3a = new JTextField();
        entry3a.setColumns(2);
        panel.add(entry3a);
        entry3b = new JTextField();
        entry3b.setColumns(2);
        panel.add(entry3b);
        entry3c = new JTextField();
        entry3c.setColumns(2);
        panel.add(entry3c);
        entry3d = new JTextField();
        entry3d.setColumns(2);
        panel.add(entry3d);
        entry3e = new JTextField();
        entry3e.setColumns(2);
        panel.add(entry3e);

        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button2 = new JButton("Calculate Average");
        button2.addActionListener(this::actionPerformed);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply3 = new JFormattedTextField();
        entry3e.setColumns(4);
        reply3.setEditable(false);
        panel.add(reply3);

        panel.setLayout(boxlayout);


        return panel;
    }


    /**
     * Returns an ImageIcon, or null if the path was invalid.
     */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = HospitalClientTable.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from
     * the event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("TabbedPaneDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add content to the window.
        frame.add(new HospitalClientTable(), BorderLayout.CENTER);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                createAndShowGUI();
            }
        });
    }

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
            //Service1Grpc.Service1BlockingStub blockingStub = Service1Grpc.newBlockingStub(channel);

            PatientId patientId = PatientId.newBuilder()
                    .setPpsNo(entry1.getText())
                    .setFirstName(entry1b.getText())
                    .setLastName(entry1c.getText())
                    .build();

            PatientRequest patientRequest = PatientRequest.newBuilder()
                    .setPatientId(patientId)
                    .build();

            //preparing message to send
            //ds.service1.RequestMessage request = ds.service1.RequestMessage.newBuilder().setText(entry1.getText()).build();
            PatientResponse patientResponse = patientClient.patient(patientRequest);

            System.out.println(patientResponse.getResult());
            //retrieving reply from service

            reply1.setText(String.valueOf(patientResponse.getResult()));

        } else if (label.equals("Calculate Average")) {
            System.out.println("service 3 to be invoked ...");

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
                    reply3.setText("Average patients/hour:\n " + value.getPatientAverage());
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

            int num1 = Integer.parseInt(entry3.getText());
            int num2 = Integer.parseInt(entry3a.getText());
            int num3 = Integer.parseInt(entry3b.getText());
            int num4 = Integer.parseInt(entry3c.getText());
            int num5 = Integer.parseInt(entry3d.getText());
            int num6 = Integer.parseInt(entry3e.getText());

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
}