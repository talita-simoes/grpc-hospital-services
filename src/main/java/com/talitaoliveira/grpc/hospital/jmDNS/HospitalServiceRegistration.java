package com.talitaoliveira.grpc.hospital.jmDNS;


import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class HospitalServiceRegistration {

    public void run(int port, String service_type, String service_name) {

        //get a jMDNS instance
        try {
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            /*
             * service information
             */

            int service_port = port;
            String service_desc = "Integration of jmDNS with gRPC";


            //Create ServiceInfo -
            //use the factory method to create the object
            ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_desc);

            /*
             * register the service
             */

            jmdns.registerService(serviceInfo);

            System.out.printf("Registering Service with type: %s and name: %s on port %d ",
                    service_type, service_name, service_port);

            //sleep for 1 second
            Thread.sleep(1000);
            System.out.println("\nService Registered");

            //unregister the services
            //jmdns.unregisterAllServices();   //you could also unregister a single service


        } catch (UnknownHostException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        } catch (InterruptedException e) {

            e.printStackTrace();
        }

    }
}
