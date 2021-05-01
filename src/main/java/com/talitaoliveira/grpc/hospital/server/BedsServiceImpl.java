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

    @Override
    public void roomsAvailable(RoomsAvailableRequest request,
                               StreamObserver<RoomsAvailableResponse> responseObserver) {
        String floor = request.getFloor();

        if (floor.equals("1")) {
            try {
                String[] arr = {"101", "103", "105", "109"};
                for (String s : arr) {
                    String result = "Single Room: " + s +" on the " + floor + "st floor.";
                    RoomsAvailableResponse response = RoomsAvailableResponse.newBuilder()
                            .setResult(result)
                            .build();
                    responseObserver.onNext(response);
                    Thread.sleep(1000L);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                responseObserver.onCompleted();
            }

        } if (floor.equals("2")) {
            try {
                String[] arr = {"202", "204", "205", "208"};
                for (String s : arr) {
                    String result = "Single Room: " + s +" on the " + floor + "nd floor.";
                    RoomsAvailableResponse response = RoomsAvailableResponse.newBuilder()
                            .setResult(result)
                            .build();
                    responseObserver.onNext(response);
                    Thread.sleep(1000L);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                responseObserver.onCompleted();
            }
        }  if (floor.equals("3")) {
            try {
                String[] arr = {"313", "315", "302"};
                for (String s : arr) {
                    String result = "Single Room: " + s +" on the " + floor + "rd floor.";
                    RoomsAvailableResponse response = RoomsAvailableResponse.newBuilder()
                            .setResult(result)
                            .build();
                    responseObserver.onNext(response);
                    Thread.sleep(1000L);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                responseObserver.onCompleted();
            }
        } if (floor.equals("4")) {
            try {
                String[] arr = {"400", "401", "402", "404"};
                for (String s : arr) {
                    String result = "\nSingle Room: " + s +" on the " + floor + "th floor.";
                    RoomsAvailableResponse response = RoomsAvailableResponse.newBuilder()
                            .setResult(result)
                            .build();
                    responseObserver.onNext(response);
                    Thread.sleep(1000L);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                responseObserver.onCompleted();
            }
        } else {
            String result = "No rooms on the " + floor + " floor.";
            RoomsAvailableResponse response = RoomsAvailableResponse.newBuilder()
                    .setResult(result)
                    .build();
            responseObserver.onNext(response);

            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}//end of class
