package com.talitaoliveira.grpc.hospital.server;

import com.proto.beds.*;
import io.grpc.stub.StreamObserver;

public class BedsServiceImpl extends BedsServiceGrpc.BedsServiceImplBase {

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

    @Override
    public StreamObserver<BedsAvailableRequest> bedsAvailable(StreamObserver<BedsAvailableResponse> responseObserver) {

        final int[] bedsAvailable = {40};

        return new StreamObserver<BedsAvailableRequest>() {
            @Override
            public void onNext(BedsAvailableRequest value) {

                int currentNumber = value.getNumberGo();

                if (currentNumber > bedsAvailable[0]) {
                    System.out.println(" No more beds available" + bedsAvailable[0]);
                    responseObserver.onNext(
                            BedsAvailableResponse.newBuilder()
                                    .setNumberBack(bedsAvailable[0])
                                    .build()
                    );

                } else if (currentNumber < bedsAvailable[0]) {

                    System.out.println(" Beds available" + bedsAvailable[0]);
                    bedsAvailable[0] = bedsAvailable[0] + currentNumber;
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
}
