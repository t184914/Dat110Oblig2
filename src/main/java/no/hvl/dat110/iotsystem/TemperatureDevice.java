package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.common.TODO;

import java.util.Collections;

public class TemperatureDevice {

	private static final int COUNT = 10;

	public static void main(String[] args) {

		// simulated / virtual temperature sensor
		TemperatureSensor sn = new TemperatureSensor();

	    Client client = new Client("sensor", "localhost", 8080);
        client.connect();

        String topic = "temperature";

        for(int i= 0; i < COUNT; i++){

            double temp = sn.read();

            client.publish(topic, String.valueOf(temp));
            System.out.println("READING" + temp);

            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        client.disconnect();

		System.out.println("Temperature device stopping ... ");

	}
}
