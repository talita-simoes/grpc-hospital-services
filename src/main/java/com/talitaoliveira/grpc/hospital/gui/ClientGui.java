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


public class ClientGui implements ActionListener, PropertyChangeListener {


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

    private JTextField entry2a, entry2aa, entry2aaa;
    private JTextArea reply2a;

    private JTextArea entry4;
    private JTextArea reply4;

    private JPanel getService1JPanel() {

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JLabel label = new JLabel("Enter New Patient");
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        entry1 = new JTextField("pps number", 10);
        panel.add(entry1);
        entry1b = new JTextField("first name", 10);
        panel.add(entry1b);
        entry1c = new JTextField("last name", 10);
        panel.add(entry1c);
        panel.add(Box.createRigidArea(new Dimension(8, 4)));

        panel.add(new JPanel());
        panel.add(new JSeparator(JSeparator.VERTICAL),
                BorderLayout.LINE_START);


        JButton button = new JButton("Register Patient");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply1 = new JTextField("", 40);
        reply1.setEditable(false);
        panel.add(reply1);

        panel.setLayout(boxlayout);

        return panel;

    }

    private JPanel getService2JPanel() {

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JLabel label = new JLabel("Enter Specialty");
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry2 = new JTextField("", 10);
        panel.add(entry2);
        panel.add(Box.createRigidArea(new Dimension(10, 10)));

        JButton button = new JButton("Find Doctors");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply2 = new JTextArea(20, 20);
        reply2.setEditable(true);
        panel.add(reply2);

        panel.setLayout(boxlayout);

        return panel;

    }

    private JPanel getService2aJPanel() {
        JPanel panel = new JPanel();
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JLabel label = new JLabel("Register Doctor");
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        entry2a = new JTextField("First Name", 10);
        panel.add(entry2a);
        panel.add(Box.createRigidArea(new Dimension(10, 10)));
        entry2aa = new JTextField("Last Name", 10);
        panel.add(entry2aa);
        panel.add(Box.createRigidArea(new Dimension(10, 10)));
        entry2aaa = new JTextField("Specialty", 10);
        panel.add(entry2aaa);
        panel.add(Box.createRigidArea(new Dimension(10, 10)));

        JButton button = new JButton("Register Doctor");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply2a = new JTextArea(10, 10);
        reply2a.setEditable(true);
        panel.add(reply2a);

        panel.setLayout(boxlayout);
        return panel;
    }

    private JPanel getService3JPanel() {

        JPanel panel = new JPanel();

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

        panel.add(Box.createRigidArea(new Dimension(10, 10)));

        JButton button = new JButton("Calculate Average");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 10)));

        reply3 = new JFormattedTextField();
        entry3e.setColumns(4);
        reply3.setEditable(false);
        panel.add(reply3);

        panel.setLayout(boxlayout);

        return panel;

    }

    private JPanel getService4JPanel() {

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JLabel label = new JLabel("Enter value");
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("Invoke Service 4");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        entry4 = new JTextArea(20, 20);
        entry4.setEditable(true);
        panel.add(entry4);

        reply4 = new JTextArea(20, 20);
        reply4.setEditable(true);
        panel.add(reply4);

        panel.setLayout(boxlayout);

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
        panel.add(getService2JPanel());
        panel.add(getService2aJPanel());
        panel.add(getService3JPanel());
        panel.add(getService4JPanel());

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
            //ds.service1.RequestMessage request = ds.service1.RequestMessage.newBuilder().setText(entry1.getText()).build();
            PatientResponse patientResponse = patientClient.patient(patientRequest);

            System.out.println(patientResponse.getResult());
            //retrieving reply from service

            reply1.setText(String.valueOf(patientResponse.getResult()));

        } else if (label.equals("Find Doctors")) {
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
                    reply2.append("Specialty Requested: "+entry2.getText()+"\n");
                    doctorClient.doctor(doctorRequest)

                            .forEachRemaining(doctorResponse -> {
                                reply2.append(" is Available\n");
                                reply2.append(doctorResponse.getResult()+"\n");

                            });
                    reply2.append("----No More Doctors Available----");
                    button.setDefaultCapable(false);
                } catch (InterruptedException ea) {
                    ea.printStackTrace();
                }catch (StatusRuntimeException eb){
                    JOptionPane.showConfirmDialog(null , "Server Not running");
                }
            }).start();

        } else if (label.equals("Register Doctor")){
            System.out.println("Register Doctor to be invoked ...");

            ManagedChannel channelA = ManagedChannelBuilder.forAddress("localhost", 50052)
                    .usePlaintext()
                    .build();
            DoctorServiceGrpc.DoctorServiceBlockingStub registerDoctorClient = DoctorServiceGrpc.newBlockingStub
                    (channelA);

            // sets the fields to be entered by the user
            DoctorId doctorId = DoctorId.newBuilder()
                    .setFirstName(entry2a.getText())
                    .setLastName(entry2aa.getText())
                    .setSpecialty(entry2aaa.getText())
                    .build();

            RegisterDoctorRequest registerDoctorRequest = RegisterDoctorRequest.newBuilder()
                    .setDoctorId(doctorId)
                    .build();

            RegisterDoctorResponse registerDoctorResponse = registerDoctorClient.registerDoctor(registerDoctorRequest);

            System.out.println(registerDoctorResponse.getResult());

            reply2a.append(String.valueOf(registerDoctorResponse.getResult()));


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
//            ds.service3.RequestMessage request = ds.service3.RequestMessage.newBuilder().setText(entry3.getText()).build();
//
//            //retrieving reply from service
//            ds.service3.ResponseMessage response = blockingStub.service3Do(request);
             //reply3.setText(Double.valueOf());
//           reply3.setText( String.valueOf( response.getLength()) );

        }else if (label.equals("Invoke Service 4")) {
//            System.out.println("service 4 to be invoked ...");
//           /*
//            *
//            */
           ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053)
                   .usePlaintext()
                   .build();

           BedsServiceGrpc.BedsServiceStub asyncClient = BedsServiceGrpc.newStub(channel);

           StreamObserver<BedsAvailableRequest>  requestObserver  = asyncClient.bedsAvailable(new StreamObserver<BedsAvailableResponse>() {

               @Override
               public void onNext(BedsAvailableResponse value) {
                   System.out.println("Total of Beds Available Now:" + value.getNumberBack());
                   reply4.append("Beds Available: "+ String.valueOf(value.getNumberBack())+"\n");
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

            entry4.setText("Beds Requested/Returned...\n");

            Arrays.asList(43,-1,-5,-3,-1,2,-2,-2).forEach(
                   number -> {
                        System.out.println("Requested/Returned Beds: " + number);

                        entry4.append(String.valueOf(number)+"\n");

                        requestObserver.onNext(BedsAvailableRequest.newBuilder()
                                .setNumberGo(number)
                                .build());
                        try {
                            Thread.sleep(2000L);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }

            );



            requestObserver.onCompleted();



}
}

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
