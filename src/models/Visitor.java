package models;

public class Visitor extends Person implements Comparable<Visitor>{
    //private String firstName;
    private boolean hasTicket;
    private int timeArrived;

    public Visitor(String firstName, String lastName, boolean hasTicket, int timeArrived) {
        super(firstName, lastName);
        this.hasTicket = hasTicket;
        this.timeArrived = timeArrived;
    }

    public boolean isHasTicket() {
        return hasTicket;
    }

    public void setHasTicket(boolean hasTicket) {
        this.hasTicket = hasTicket;
    }

    public int getTimeArrived() {
        return timeArrived;
    }

    public void setTimeArrived(int timeArrived) {
        this.timeArrived = timeArrived;
    }

    public double discountCalculation() {
        double discount = 1;
        Company company = new Company();
        if (company.checkAnEmployeeInCompany(super.getFirstName())) {
            discount = 0.75;
        }
        return discount;
    }

    //if (this.person instanceof Employee && ((Employee) this.person).getCompany() != null)

    public String ticketAvailability() {
        if (this.hasTicket) {
            return "with ticket";
        } else {
            return "without ticket";
        }
    }

    @Override
    public String toString() {
        /*
        return "First Name: " + super.getFirstName() +
                " Has Ticket: " + this.hasTicket +
                " TimeArrived: " + this.timeArrived;
        */
        return super.getFirstName() + " " + this.hasTicket + " " + this.timeArrived;
    }

    @Override
    public int compareTo(Visitor visitor) {
        return this.timeArrived - visitor.timeArrived;
    }
}
