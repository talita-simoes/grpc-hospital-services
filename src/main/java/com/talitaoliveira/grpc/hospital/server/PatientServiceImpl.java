package com.talitaoliveira.grpc.hospital.server;

import com.proto.patient.*;
import io.grpc.stub.StreamObserver;

public class PatientServiceImpl extends PatientServiceGrpc.PatientServiceImplBase {

    @Override
    public void patient(PatientRequest request, StreamObserver<PatientResponse> responseObserver) {
        // Extract the fields needed from the proto
        PatientId patientId = request.getPatientId();
        String pps_no = patientId.getPpsNo();
        String firstName = patientId.getFirstName();
        String lastName = patientId.getLastName();

        // Create the response
        String result = "New Patient: " + pps_no + " Name: "+ firstName + " " + lastName;

        PatientResponse response = PatientResponse.newBuilder()
                .setResult(result)//we can set many fields as we want | but on this proto, PatientResponse only has 1 field
                .build();

        // Send response back to the client
        responseObserver.onNext(response);

        // Complete the RPC call
        responseObserver.onCompleted();

    }

    @Override
    public StreamObserver<PatientAverageRequest> patientAverage(StreamObserver<PatientAverageResponse> responseObserver) {
       StreamObserver<PatientAverageRequest> requestObserver = new StreamObserver<PatientAverageRequest>() {
           int sum = 0;
           int count = 0;

           @Override
           public void onNext(PatientAverageRequest value) {
                sum += value.getNumberPatients();
                count += 1;
           }

           @Override
           public void onError(Throwable t) {

           }

           @Override
           public void onCompleted() {
               System.out.print("The average number of patients per hour is: ");
                double average = (double) sum/count;

                responseObserver.onNext(
                        PatientAverageResponse.newBuilder()
                                .setPatientAverage(average)
                                .build()
                );
                responseObserver.onCompleted();

           }
       };
        return requestObserver;
    }

}
