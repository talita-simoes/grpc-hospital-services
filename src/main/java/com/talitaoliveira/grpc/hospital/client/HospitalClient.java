package com.talitaoliveira.grpc.hospital.client;

import com.proto.HospitalTest.HospitalServiceGrpc;
import com.proto.patient.PatientId;
import com.proto.patient.PatientRequest;
import com.proto.patient.PatientResponse;
import com.proto.patient.PatientServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import javafx.beans.property.adapter.JavaBeanBooleanPropertyBuilder;

public class HospitalClient {

    public static void main(String[] args) {
        System.out.println("Hospital Client");

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",50051)
        .usePlaintext()
        .build();

        System.out.println("Creating Stub...");
        //synchronous client
        //HospitalServiceGrpc.HospitalServiceBlockingStub syncClient = HospitalServiceGrpc.newBlockingStub(channel);


        // created a patient service client (blocking syncrounous)
        PatientServiceGrpc.PatientServiceBlockingStub patientClient = PatientServiceGrpc.newBlockingStub(channel);

        // created a protocol buffer patient message
        PatientId patientId = PatientId.newBuilder()
                .setPpsNo("PJ454002")
                .setFirstName("John")
                .setLastName("Williams")
                .build();

        PatientRequest patientRequest = PatientRequest.newBuilder()
                .setPatientId(patientId)
                .build();

        //calls the function implemented on the PatientServerImpl
        //call the rpc and get back a response
        PatientResponse patientResponse = patientClient.patient(patientRequest);

        System.out.println(patientResponse.getResult());

        // to create an asynchronous client
        //HospitalServiceGrpc.HospitalServiceFutureStub asyncClient = HospitalServiceGrpc.newFutureStub(channel);



        System.out.println("Shutting down channel");
        channel.shutdown();
    }

}
