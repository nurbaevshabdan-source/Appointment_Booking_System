public class Appointment {
    private int id;
    private int userId;
    private int specialistId;
    private String date;

    public Appointment(int id, int userId, int specialistId, String date) {
        this.id = id;
        this.userId = userId;
        this.specialistId = specialistId;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public int getSpecialistId() {
        return specialistId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
