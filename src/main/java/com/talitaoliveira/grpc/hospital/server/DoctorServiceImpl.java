package com.talitaoliveira.grpc.hospital.server;

import com.proto.doctor.*;
import io.grpc.stub.StreamObserver;

import java.util.Locale;


public class DoctorServiceImpl extends DoctorServiceGrpc.DoctorServiceImplBase {

    @Override
    public void doctor(DoctorRequest request, StreamObserver<DoctorResponse> responseObserver) {
        // gets the input from the client
        String specialty = request.getDoctorId().getSpecialty();

        if (specialty.toLowerCase(Locale.ROOT).equals("surgery")) {
            try {
                //list of available doctors
                String[] arr = {"Jon Smith", "Alan Del Rio", "Anna Valour", "Samuel Needles"};
                // FOr each doctor from the list one result is set
                for (String s : arr) {
                    String result = " Dr. " + s;
                    DoctorResponse response = DoctorResponse.newBuilder()
                            .setResult(result)
                            .build();

                    responseObserver.onNext(response);//response get sent back to the client
                    Thread.sleep(1000L);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                responseObserver.onCompleted();
            }

        } if (specialty.toLowerCase(Locale.ROOT).equals("gp")) {
            try {
                //list of available doctors
                String[] arr2 = {"Franz Ferdinand", "Juliette Lewis", "Joan Jett", "Billy Joel", "Edgar Winter"};

                for (String s : arr2) {
                    String result = " Dr. " + s;
                    DoctorResponse response = DoctorResponse.newBuilder()
                            .setResult(result)
                            .build();

                    responseObserver.onNext(response);//response get sent back to the client
                    Thread.sleep(1000L);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                responseObserver.onCompleted();
            }

        } else {
            // if the input is something else...
            String result = " Specialty Not Available";
            DoctorResponse response = DoctorResponse.newBuilder()
                    .setResult(result)
                    .build();

            responseObserver.onNext(response);//response get sent back to the client
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//--------------------------------------------
    }

}