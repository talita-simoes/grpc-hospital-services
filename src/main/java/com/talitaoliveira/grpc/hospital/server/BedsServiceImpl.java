package com.talitaoliveira.grpc.hospital.server;

import com.proto.beds.*;
import io.grpc.stub.StreamObserver;

public class BedsServiceImpl extends BedsServiceGrpc.BedsServiceImplBase {

    @Override
    public StreamObserver<BedsAvailableRequest> bedsAvailable
            (StreamObserver<BedsAvailableResponse> responseObserver) {

        //sets the total number of beds available in the hospital
        final int[] bedsAvailable = {40};

        return new StreamObserver<BedsAvailableRequest>() {
            @Override
            public void onNext(BedsAvailableRequest value) {

                // the current number is the number get from the client
                int currentNumber = value.getNumberGo();

                if (currentNumber > bedsAvailable[0]) {
                    System.out.println(" No more beds available" + bedsAvailable[0]);
                    // if the number is greater than the beds available, no calculations are made
                    responseObserver.onNext(
                            BedsAvailableResponse.newBuilder()
                                    .setNumberBack(bedsAvailable[0])
                                    .build()
                    );

                } else if (currentNumber < bedsAvailable[0]) {

                    System.out.println(" Beds available" + bedsAvailable[0]);
                    bedsAvailable[0] = bedsAvailable[0] + currentNumber;
                    // on next response the server will set the calculated answer
                    responseObserver.onNext(
                            BedsAvailableResponse.newBuilder()
                                    .setNumberBack(bedsAvailable[0])
                                    .build()
                    );

                }
            }

            @Override
            public void onError(Throwable t) {

                responseObserver.onCompleted();
            }

            @Override
            public void onCompleted() {
                responseObserver.onNext(
                        BedsAvailableResponse.newBuilder()
                                .setNumberBack(bedsAvailable[0])
                                .build()
                );
                responseObserver.onCompleted();
            }

        };
    }
    //Bidirectional call for testing strings
//    @Override
//    public StreamObserver<BedsMessageRequest> bedsMessage(StreamObserver<BedsMessageResponse> responseObserver) {
//
//        StreamObserver<BedsMessageRequest> requestObserver =
//                new StreamObserver<BedsMessageRequest>() {
//                    @Override
//                    public void onNext(BedsMessageRequest value) {
//                        String result = "FirstMessageSent: " + value.getBedsMessage().getMessage1();
//                        BedsMessageResponse bedsMessageResponse = BedsMessageResponse.newBuilder()
//                                .setMessageToReturn(result)
//                                .build();
//
//                        //send this message back on the response observer
//                        responseObserver.onNext(bedsMessageResponse);
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//
//                    }
//
//                    @Override
//                    public void onCompleted() {
//                        responseObserver.onCompleted();
//                    }
//                };
//        return requestObserver;
//    }

}
