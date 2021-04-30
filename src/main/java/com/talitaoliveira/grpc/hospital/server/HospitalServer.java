package com.talitaoliveira.grpc.hospital.server;

import com.talitaoliveira.grpc.hospital.jmDNS.HospitalServiceRegistration;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

public class HospitalServer {

    public static void main(String[] args) throws InterruptedException, IOException {

        // jmDNS REGISTER SERVICE ---------------------------------------------------
        System.out.println("Registering Service...");
        int port = 50051;
        String service_type = "_patient._tcp.local.";
        String service_name = "patient_service";
        HospitalServiceRegistration psr = new HospitalServiceRegistration();
        psr.run(port, service_type, service_name);

        // STARTS THE SERVER ---------------------------------------------------------

        System.out.println("\nHospital Server started");

        Server server = ServerBuilder.forPort(port)
                .addService(new PatientServiceImpl())
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