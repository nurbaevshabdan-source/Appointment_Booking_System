public class Specialist extends Person {
    private String specialization;

    public Specialist(int id, String name, String specialization) {
        super(id, name);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public void displayInfo() {
        System.out.println("Specialist: " + getName() + " | Field: " + specialization);
    }
}
