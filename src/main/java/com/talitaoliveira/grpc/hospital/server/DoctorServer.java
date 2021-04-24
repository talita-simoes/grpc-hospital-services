package com.talitaoliveira.grpc.hospital.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class DoctorServer {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("Doctor Server started");

        //set the port and add the services implemented
        Server server = ServerBuilder.forPort(50052)
                .addService(new DoctorServiceImpl())
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
