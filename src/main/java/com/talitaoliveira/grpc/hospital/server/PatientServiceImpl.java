package com.talitaoliveira.grpc.hospital.server;

import com.proto.patient.PatientId;
import com.proto.patient.PatientRequest;
import com.proto.patient.PatientResponse;
import com.proto.patient.PatientServiceGrpc;
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
        String result = "New Patient: " + pps_no + " Name: "+ firstName+ " " + lastName;

        PatientResponse response = PatientResponse.newBuilder()
                .setResult(result)//we can set many fields as we want | but on this proto, PatientResponse only has 1 field
                .build();

        // Send response back to the client
        responseObserver.onNext(response);

        // Complete the RPC call
        responseObserver.onCompleted();

        //super.patient(request, responseObserver);
    }
}
