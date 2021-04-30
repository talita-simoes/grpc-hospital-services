package com.talitaoliveira.grpc.hospital.server;

import com.talitaoliveira.grpc.hospital.jmDNS.HospitalServiceRegistration;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class BedsServer {
    public static void main(String[] args) throws InterruptedException, IOException {

        // jmDNS REGISTER SERVICE ---------------------------------------------------
        System.out.println("Registering Service...");
        int port = 50053;
        String service_type = "_beds._tcp.local.";
        String service_name = "beds_service";
        HospitalServiceRegistration bsr = new HospitalServiceRegistration();
        bsr.run(port, service_type, service_name);


        System.out.println("Beds Server Started");

        //set the port and add the services implemented
        Server server = ServerBuilder.forPort(port)
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
