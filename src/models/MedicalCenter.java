package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedicalCenter {
    private String doctorsName;
    private final int INSURANCE = 100;
    List<Appointment> queue = new ArrayList<>();

    public MedicalCenter(String doctorsName) {
        this.doctorsName = doctorsName;
    }

    public String getDoctorsName() {
        return doctorsName;
    }

    public void setDoctorsName(String doctorsName) {
        this.doctorsName = doctorsName;
    }

    public List<Appointment> getQueue() {
        return queue;
    }

    public double calculateCostOfInsurance(Person person) {
        return Appointment.discountCalculation(person) * INSURANCE;
    }

    public void initialQueue(List<Appointment> queue) {
        Collections.sort(queue);
        for (Appointment record : queue) {
            therapistTraffic(record);
        }
    }

    public void therapistTraffic(Appointment record) {
        boolean flag = false;

        if (record.isHasTicket()) {
            for (int i = 0; i < queue.size(); i++) {
                if (!queue.get(i).isHasTicket()) {
                    if (i <= 2) {
                        queue.add(i, record);
                        flag = true;
                        break;
                    } else {
                        if (queue.get(i - 1).isHasTicket() && queue.get(i - 2).isHasTicket() && queue.get(i - 3).isHasTicket()) {
                            continue;
                        } else {
                            queue.add(i, record);
                            flag = true;
                            break;
                        }
                    }
                }
            }
            if (!flag) {
                queue.add(record);
            }
        } else {
            queue.add(record);
        }
    }

    public int getLastArrivalTime() {
        if (this.queue.size() == 0) {
            return 0;
        } else {
            List<Appointment> queue = new ArrayList<>(this.queue);
            Collections.sort(queue);
            return queue.get(queue.size() - 1).getTimeArrived();
        }
    }

    public int getCountOfRecords() {
        return queue.size();
    }
}
