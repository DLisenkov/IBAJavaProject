package threads;

import models.MedicalCenter;
import models.Visitor;

import java.util.ArrayList;
import java.util.Random;

public class PatientThread extends Thread{

    private MedicalCenter medicalCenter;
    public PatientThread(String name, MedicalCenter medicalCenter) {
        super(name);
        this.medicalCenter = medicalCenter;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " started...\n");

        long beginTime = System.nanoTime();
        final long MINUTE = 60000000000L;
        long endTime = beginTime + MINUTE;
        while(System.nanoTime() <= endTime) {
            int time = (int)(( Math.random() * (10 - 0 + 1) + 0));

            try {
                Thread.sleep(time*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Random random = new Random();
            Visitor visitor = new Visitor("Patient" + (medicalCenter.getCountOfVisitors() + 1),
                    "LastName" + (medicalCenter.getCountOfVisitors() + 1),
                    random.nextBoolean(),
                    this.medicalCenter.getLastArrivalTime() + time);
            System.out.println(visitor.getFirstName() + " " + visitor.ticketAvailability()
                    + " arrived to " + visitor.getTimeArrived() + "\n");
            medicalCenter.therapistTraffic(visitor);

            System.out.println("Doctor " + medicalCenter.getDoctorsName() + " is there");
            ArrayList<Visitor> queue = medicalCenter.getQueue();
            for (int i = 0; i < queue.size(); i++) {
                System.out.println(queue.get(i));
            }
            System.out.println();
        }
        System.out.println(Thread.currentThread().getName() + " finished...");
    }
}
