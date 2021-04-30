package com.talitaoliveira.grpc.hospital.server;

import com.talitaoliveira.grpc.hospital.jmDNS.HospitalServiceRegistration;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class DoctorServer {
    public static void main(String[] args) throws InterruptedException, IOException {

        // jmDNS REGISTER SERVICE ---------------------------------------------------
        System.out.println("Registering Service...");
        int port = 50052;
        String service_type = "_doctor._tcp.local.";
        String service_name = "doctor_service";
        HospitalServiceRegistration dsr = new HospitalServiceRegistration();
        dsr.run(port, service_type, service_name);


        System.out.println("\nDoctor Server started");
        //set the port and add the services implemented
        Server server = ServerBuilder.forPort(port)
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
