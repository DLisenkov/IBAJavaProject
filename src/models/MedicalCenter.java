package models;

import java.util.ArrayList;
import java.util.Collections;

public class MedicalCenter {
    private String doctorsName;
    private final int INSURANCE = 100;
    ArrayList<Visitor> queue = new ArrayList<>();

    public MedicalCenter(String doctorsName) {
        this.doctorsName = doctorsName;
    }

    public String getDoctorsName() {
        return doctorsName;
    }

    public void setDoctorsName(String doctorsName) {
        this.doctorsName = doctorsName;
    }

    public ArrayList<Visitor> getQueue() {
        return queue;
    }

    public double calculateCostOfInsurance(Visitor visitor) {
        return visitor.discountCalculation() * INSURANCE;
    }

    public void initialQueue(ArrayList<Visitor> visitors) {
        Collections.sort(visitors);
        for (int i = 0; i < visitors.size(); i++) {
            therapistTraffic(visitors.get(i));
        }
    }

    public void therapistTraffic(Visitor visitor) {
        boolean flag = false;

        if (visitor.isHasTicket()) {
            for (int i = 0; i < queue.size(); i++) {
                if (!queue.get(i).isHasTicket()) {
                    if (i <= 2) {
                        queue.add(i, visitor);
                        flag = true;
                        break;
                    } else {
                        if (queue.get(i - 1).isHasTicket() && queue.get(i - 2).isHasTicket() && queue.get(i - 3).isHasTicket()) {
                            continue;
                        } else {
                            queue.add(i, visitor);
                            flag = true;
                            break;
                        }
                    }
                }
            }
            if (!flag) {
                queue.add(visitor);
            }
        } else {
            queue.add(visitor);
        }
    }

    public int getLastArrivalTime() {
        if (this.queue.size() == 0) {
            return 0;
        } else {
            ArrayList<Visitor> visitors = new ArrayList<>(queue);
            Collections.sort(visitors);
            return visitors.get(visitors.size() - 1).getTimeArrived();
        }
    }

    public int getCountOfVisitors() {
        return queue.size();
    }
}
