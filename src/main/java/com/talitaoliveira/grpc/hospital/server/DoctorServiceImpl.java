package com.talitaoliveira.grpc.hospital.server;

import com.proto.doctor.*;
import io.grpc.stub.StreamObserver;


public class DoctorServiceImpl extends DoctorServiceGrpc.DoctorServiceImplBase {

    @Override
    public void doctor(DoctorRequest request, StreamObserver<DoctorResponse> responseObserver) {
        String specialty = request.getDoctorId().getSpecialty();

        try {
                //list of available doctors
                String[] arr = {"Jon Smith", "Alan Del Rio", "Anna Valour", "Samuel Needles"};

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

    }

}