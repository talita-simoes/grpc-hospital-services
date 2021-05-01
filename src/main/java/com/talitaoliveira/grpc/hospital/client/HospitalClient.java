package com.talitaoliveira.grpc.hospital.client;

import com.proto.beds.*;
import com.proto.doctor.*;
import com.proto.patient.*;
import com.talitaoliveira.grpc.hospital.jmDNS.HospitalServiceDiscovery;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import javax.jmdns.ServiceInfo;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class HospitalClient {

    public static void main(String[] args) {
        System.out.println("Hospital Client");
        System.out.println("Creating Stub...");

        HospitalClient main = new HospitalClient();
        main.run();

    }

    public void run(){

        //Discovery all the information from the service and pass the parameters to the channel
        //CHANNEL
        ServiceInfo serviceInfo;
        String service_type = "_patient._tcp.local.";
        //Now retrieve the service info - all we are supplying is the service type
        serviceInfo = HospitalServiceDiscovery.run(service_type);
        //Use the serviceInfo to retrieve the port
        int port = serviceInfo.getPort();
        String host = "localhost";
        //int port = 50051;

        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
    //------------------------------------------------------------------------------------------
        //CHANNEL2
        //Discovery for channel2
        ServiceInfo serviceInfo2;
        String service_type2 = "_doctor._tcp.local.";
        serviceInfo2 = HospitalServiceDiscovery.run(service_type2);
        int port2 = serviceInfo2.getPort();
        String host2 = "localhost";

        ManagedChannel channel2 = ManagedChannelBuilder.forAddress(host2,port2)
                    .usePlaintext()
                    .build();
    //------------------------------------------------------------------------------------------
        //CHANNEL3
        //Discovery for channel3
        ServiceInfo serviceInfo3;
        String service_type3 = "_beds._tcp.local.";
        serviceInfo3 = HospitalServiceDiscovery.run(service_type3);
        int port3 = serviceInfo3.getPort();
        String host3 = "localhost";

        ManagedChannel channel3 = ManagedChannelBuilder.forAddress(host3, port3)
                .usePlaintext()
                .build();


    // CALLING THE FUNCTIONS (comment out to not call)------------------------------------------
        // SERVICE PATIENT
        doUnaryCallPatient(channel);
        doClientStreamingCallPatientAverage(channel);

        //SERVICE DOCTOR
        doServerStreamingCallDoctor(channel2);
        doUnaryCallRegisterDoctor(channel2);

        //SERVICE BEDS
        doBidirectionalCallBeds(channel3);

        doServerStreamingCallRoomsAvailable(channel3);

        System.out.println("Shutting down channel");
        channel.shutdown();
    }

    //call the patient
    private void doUnaryCallPatient(ManagedChannel channel){
        // creating a patient service client (blocking synchronous)
        PatientServiceGrpc.PatientServiceBlockingStub patientClient = PatientServiceGrpc.newBlockingStub
                (channel);

        // creating a protocol buffer patient message
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
    private void doClientStreamingCallPatientAverage(ManagedChannel channel){
        PatientServiceGrpc.PatientServiceStub asyncClient = PatientServiceGrpc.newStub(channel);

        CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<PatientAverageRequest> requestObserver = asyncClient.patientAverage
                (new StreamObserver<PatientAverageResponse>() {
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
    private void doServerStreamingCallDoctor(ManagedChannel channel2){
        // B.created a doctor service client streaming
        DoctorServiceGrpc.DoctorServiceBlockingStub doctorClient = DoctorServiceGrpc.newBlockingStub(channel2);

        // B.created a protocol buffer doctor message | prepare the request
        DoctorRequest doctorRequest =
                DoctorRequest.newBuilder()
                        .setDoctorId(DoctorId.newBuilder().setSpecialty("GP"))
                        .build();

        // stream the responses in a block manner
        doctorClient.doctor(doctorRequest)
                .forEachRemaining(doctorResponse -> System.out.println(doctorResponse.getResult()));
    }

    //call register doctor
    private void doUnaryCallRegisterDoctor(ManagedChannel channel2){

        DoctorServiceGrpc.DoctorServiceBlockingStub registerDoctorClient = DoctorServiceGrpc.newBlockingStub
                (channel2);
        // creates a protocol buffer message
        DoctorId doctorId = DoctorId.newBuilder()
                .setFirstName("Marie")
                .setLastName("Curie")
                .setSpecialty("Surgery")
                .build();

        RegisterDoctorRequest registerDoctorRequest = RegisterDoctorRequest.newBuilder()
                .setDoctorId(doctorId)
                .build();

        RegisterDoctorResponse registerDoctorResponse = registerDoctorClient.registerDoctor
                (registerDoctorRequest);

        System.out.println(registerDoctorResponse.getResult());

    }

    //call the bedsAvailable
    private void doBidirectionalCallBeds(ManagedChannel channel3){
        BedsServiceGrpc.BedsServiceStub asyncClient = BedsServiceGrpc.newStub(channel3);

        CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<BedsAvailableRequest>  requestObserver  = asyncClient.bedsAvailable
                (new StreamObserver<BedsAvailableResponse>() {

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

    //call the roomsAvailable
    private void doServerStreamingCallRoomsAvailable(ManagedChannel channel3){

        BedsServiceGrpc.BedsServiceBlockingStub roomsClient = BedsServiceGrpc.newBlockingStub(channel3);

        RoomsAvailableRequest roomsAvailableRequest =
                RoomsAvailableRequest.newBuilder()
                        .setFloor("2")
                        .build();
        // stream the responses in a block manner
        roomsClient.roomsAvailable(roomsAvailableRequest).forEachRemaining
                (roomsAvailableResponse -> System.out.println(roomsAvailableResponse.getResult()));
    }

}//end of class
