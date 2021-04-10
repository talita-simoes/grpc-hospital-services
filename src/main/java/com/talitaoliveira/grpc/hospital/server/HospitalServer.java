package com.talitaoliveira.grpc.hospital.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

public class HospitalServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Server started");

        Server server = ServerBuilder.forPort(50051)
                .addService(new PatientServiceImpl())//Taking the Service from
        .build();

        server.start();
        Runtime.getRuntime().addShutdownHook(new Thread( () -> {
            System.out.println("Received Shutdown Request");
            server.shutdown();
            System.out.println("Successfully stopped the server");
        } ));
        server.awaitTermination();
    }

}
