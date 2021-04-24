package com.talitaoliveira.grpc.hospital.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class BedsServer {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("Beds Server started");

        //set the port and add the services implemented
        Server server = ServerBuilder.forPort(50053)
                .addService(new BedsServiceImpl())
                .build();

        server.start();

        Runtime.getRuntime().addShutdownHook(new Thread( () -> {
            System.out.println("Received Shutdown Request");
            server.shutdown();
            System.out.println("Successfully stopped the doctor server");
        } ));
        server.awaitTermination();
    }
}
