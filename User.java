public class User extends Person {
    private String email;

    public User(int id, String name, String email) {
        super(id, name);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void displayInfo() {
        System.out.println("User: " + getName() + " | Email: " + email);
    }
}
