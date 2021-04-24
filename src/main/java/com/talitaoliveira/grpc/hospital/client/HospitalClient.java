package com.talitaoliveira.grpc.hospital.client;

import com.proto.beds.*;
import com.proto.doctor.*;
import com.proto.patient.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class HospitalClient {

    public static void main(String[] args) {
        System.out.println("Hospital Client");
        System.out.println("Creating Stub...");

        HospitalClient main = new HospitalClient();
        main.run();

        //synchronous client
        //HospitalServiceGrpc.HospitalServiceBlockingStub syncClient = HospitalServiceGrpc.newBlockingStub(channel);

        // to create an asynchronous client
        //HospitalServiceGrpc.HospitalServiceFutureStub asyncClient = HospitalServiceGrpc.newFutureStub(channel);

    }

    public void run(){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",50051)
                .usePlaintext()
                .build();

        ManagedChannel channel2 = ManagedChannelBuilder.forAddress("localhost",50052)
                    .usePlaintext()
                    .build();

        ManagedChannel channel3 = ManagedChannelBuilder.forAddress("localhost",50053)
                .usePlaintext()
                .build();


    // CALLING THE FUNCTIONS (comment out to not call)------------------------------------------
        doUnaryCall(channel);

        doClientStreamingCall(channel);

        doServerStreamingCall(channel2);

        doBidirectionalCall(channel3);

        //doBidirectionalCall2(channel);


        System.out.println("Shutting down channel");
        channel.shutdown();
    }

    //call the patient
    private void doUnaryCall(ManagedChannel channel){
        // A.created a patient service client (blocking synchronous)
        PatientServiceGrpc.PatientServiceBlockingStub patientClient = PatientServiceGrpc.newBlockingStub(channel);

        // A.created a protocol buffer patient message
        PatientId patientId = PatientId.newBuilder()
                .setPpsNo("PJ454002")
                .setFirstName("John")
                .setLastName("Williams")
                .build();

        PatientRequest patientRequest = PatientRequest.newBuilder()
                .setPatientId(patientId)
                .build();

        //A.calls the function implemented on the PatientServerImpl
        //A.call the rpc and get back a response
        PatientResponse patientResponse = patientClient.patient(patientRequest);

        System.out.println(patientResponse.getResult());
    }

    //call the patientAverage
    private void doClientStreamingCall(ManagedChannel channel){
        PatientServiceGrpc.PatientServiceStub asyncClient = PatientServiceGrpc.newStub(channel);

        CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<PatientAverageRequest> requestObserver = asyncClient.patientAverage(new StreamObserver<PatientAverageResponse>() {
            @Override
            public void onNext(PatientAverageResponse value) {
                System.out.println("Received response from Server");
                System.out.println("Average patients/hour: " + value.getPatientAverage());
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

        requestObserver.onNext(PatientAverageRequest.newBuilder()
                .setNumberPatients(8)
                .build());

        requestObserver.onNext(PatientAverageRequest.newBuilder()
                .setNumberPatients(6)
                .build());

        requestObserver.onNext(PatientAverageRequest.newBuilder()
                .setNumberPatients(7)
                .build());

        requestObserver.onNext(PatientAverageRequest.newBuilder()
                .setNumberPatients(12)
                .build());

        requestObserver.onNext(PatientAverageRequest.newBuilder()
                .setNumberPatients(13)
                .build());

        requestObserver.onNext(PatientAverageRequest.newBuilder()
                .setNumberPatients(10)
                .build());

        requestObserver.onCompleted();

        try {
            latch.await(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    //call the doctor
    private void doServerStreamingCall(ManagedChannel channel2){
        // B.created a doctor service client (streaming)
        DoctorServiceGrpc.DoctorServiceBlockingStub doctorClient = DoctorServiceGrpc.newBlockingStub(channel2);

        // B.created a protocol buffer doctor message | prepare the request
        DoctorRequest doctorRequest =
                DoctorRequest.newBuilder()
                        .setDoctorId(DoctorId.newBuilder().setSpecialty("Surgery"))
                        .build();

        // stream the responses in a block manner
        doctorClient.doctor(doctorRequest)
                .forEachRemaining(doctorResponse -> System.out.println(doctorResponse.getResult()));
    }

    //call the bedsAvailable
    private void doBidirectionalCall(ManagedChannel channel3){
        BedsServiceGrpc.BedsServiceStub asyncClient = BedsServiceGrpc.newStub(channel3);

        CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<BedsAvailableRequest>  requestObserver  = asyncClient.bedsAvailable(new StreamObserver<BedsAvailableResponse>() {

            @Override
            public void onNext(BedsAvailableResponse value) {

                    System.out.println("Total of Beds Available Now:" + value.getNumberBack());

            }

            @Override
            public void onError(Throwable t) {
                latch.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println("Server is not sending messages now.");
            }
        });

        //if the number is positive, patients were discharged
        //if the numbers is negative, patients were admitted
        Arrays.asList(43,-1,-5,-3,-1,2,-2,-2).forEach(
                number -> {
                        System.out.println("Requested/Returned Beds: " + number);
                        requestObserver.onNext(BedsAvailableRequest.newBuilder()
                                .setNumberGo(number)
                                .build());
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );

        requestObserver.onCompleted();

        try {
            latch.await(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void doBidirectionalCall2(ManagedChannel channel3){

        BedsServiceGrpc.BedsServiceStub asyncClient = BedsServiceGrpc.newStub(channel3);

        CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<BedsMessageRequest> requestObserver = asyncClient.bedsMessage(new StreamObserver<BedsMessageResponse>() {
            @Override
            public void onNext(BedsMessageResponse value) {
                System.out.println("Response from server: " + value.getMessageToReturn());
            }

            @Override
            public void onError(Throwable t) {
            latch.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println("Server is done sending data");
                latch.countDown();
            }
        });

        Arrays.asList("John", "Anna", "Scarlet", "Adriana").forEach(
                name -> {
                    System.out.println("Sending: "+ name); //log that we are sending a message
                    requestObserver.onNext(BedsMessageRequest.newBuilder()
                            .setBedsMessage(BedsMessage.newBuilder().setMessage1(name))
                            .build());

                    //allow to show the timing of the streaming
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
        );
        requestObserver.onCompleted();

        try {
            latch.await(3,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }

    }

}//end of class
