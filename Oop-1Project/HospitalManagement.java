interface Billable {
    double calculateBill();
}

abstract class Patient {
    protected String name;
    protected int patientId;

    public Patient(String name, int patientId) {
        this.name = name;
        this.patientId = patientId;
    }

    public abstract void showInfo();
}

class IndoorPatient extends Patient implements Billable {

    public IndoorPatient(String name, int patientId) {
        super(name, patientId);
    }

    @Override
    public void showInfo() {
        System.out.println("Indoor Patient: " + name + " (ID: " + patientId + ")");
    }

    @Override
    public double calculateBill() {
        return 1500;
    }
}

class OutdoorPatient extends Patient implements Billable {

    public OutdoorPatient(String name, int patientId) {
        super(name, patientId);
    }

    @Override
    public void showInfo() {
        System.out.println("Outdoor Patient: " + name + " (ID: " + patientId + ")");
    }

    @Override
    public double calculateBill() {
        return 500;
    }
}

class Hospital {

    public void processBill(Patient p, Billable b) {
        p.showInfo();
        System.out.println("Total Bill: " + b.calculateBill());
        System.out.println();
    }
}

public class HospitalManagement {
    public static void main(String[] args) {

        Patient p1 = new IndoorPatient("Rahim", 501);
        Patient p2 = new OutdoorPatient("Karim", 502);

        Hospital h = new Hospital();

        h.processBill(p1, (Billable) p1);
        h.processBill(p2, (Billable) p2);
    }
}
