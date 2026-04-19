import java.util.ArrayList;
import java.util.Scanner;

import java.io.FileWriter;
import java.io.IOException;

import java.io.File;

public class Main {

    static ArrayList<User> users = new ArrayList<>();
    static ArrayList<Specialist> specialists = new ArrayList<>();
    static ArrayList<Appointment> appointments = new ArrayList<>();

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        loadAppointmentsFromFile();

//        Person p1 = new User(2, "Ali", "ali@mail.com");
//        Person p2 = new Specialist(2, "Dr. Smith", "Barber");
//
//        p1.displayInfo();
//        p2.displayInfo();  <-----Полиморфизм


        while (true) {
            System.out.println("\n1. Add appointment");
            System.out.println("2. View appointments");
            System.out.println("3. Update appointment");
            System.out.println("4. Delete appointment");
            System.out.println("5. Exit");
            System.out.println("6. Export to CSV");

            int choice = scanner.nextInt();

            if (choice == 1) {
                addAppointment();
            } else if (choice == 2) {
                viewAppointments();
            } else if (choice == 3) {
                updateAppointment();
            } else if (choice == 4) {
                deleteAppointment();
            } else if (choice == 5) {
                break;
            } else if (choice == 6) {
                exportToCSV();
            }
        }
    }

    public static void addAppointment() {
        try {
            System.out.println("Enter appointment id:");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter user id:");
            int userId = Integer.parseInt(scanner.nextLine());

            if (!userExists(userId)) {
                System.out.println("User does not exist!");
                return;
            }

            System.out.println("Enter specialist id:");
            int specId = Integer.parseInt(scanner.nextLine());

            if (!specialistExists(specId)) {
                System.out.println("Specialist does not exist!");
                return;
            }

            System.out.println("Enter date:");
            String date = scanner.nextLine();

            if (date.isEmpty()) {
                System.out.println("Date cannot be empty!");
                return;
            }

            Appointment appt = new Appointment(id, userId, specId, date);
            appointments.add(appt);

            saveAppointmentsToFile();

            System.out.println("Appointment added!");

        } catch (Exception e) {
            System.out.println("Invalid input!");
        }
    }

    public static void viewAppointments() {
        for (Appointment appt : appointments) {
            System.out.println("ID: " + appt.getId()
                    + " | User ID: " + appt.getUserId()
                    + " | Specialist ID: " + appt.getSpecialistId()
                    + " | Date: " + appt.getDate());
        }
    }

    public static void updateAppointment() {
        scanner.nextLine();

        System.out.println("Enter appointment id to update:");
        int id = Integer.parseInt(scanner.nextLine());

        for (Appointment appt : appointments) {
            if (appt.getId() == id) {
                System.out.println("Enter new date:");
                String newDate = scanner.nextLine();

                appt.setDate(newDate);

                saveAppointmentsToFile();

                System.out.println("Updated!");
                return;
            }
        }

        System.out.println("Appointment not found.");
    }

    public static void deleteAppointment() {
        scanner.nextLine();

        System.out.println("Enter appointment id to delete:");
        int id = Integer.parseInt(scanner.nextLine());

        for (Appointment appt : appointments) {
            if (appt.getId() == id) {
                appointments.remove(appt);
                System.out.println("Deleted!");

                saveAppointmentsToFile();

                return;
            }
        }

        System.out.println("Appointment not found.");
    }


    public static void saveAppointmentsToFile() {
        try {
            FileWriter writer = new FileWriter("appointments.txt");

            for (Appointment appt : appointments) {
                writer.write(
                        appt.getId() + "," +
                                appt.getUserId() + "," +
                                appt.getSpecialistId() + "," +
                                appt.getDate() + "\n"
                );
            }

            writer.close();
            System.out.println("Saved to file!");

        } catch (IOException e) {
            System.out.println("Error saving file!");
        }
    }



    public static void loadAppointmentsFromFile() {
        try {
            File file = new File("appointments.txt");

            if (!file.exists()) return;

            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0]);
                int userId = Integer.parseInt(parts[1]);
                int specId = Integer.parseInt(parts[2]);
                String date = parts[3];

                appointments.add(new Appointment(id, userId, specId, date));
            }

            fileScanner.close();

        } catch (Exception e) {
            System.out.println("Error loading file!");
        }
    }


    public static boolean userExists(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public static boolean specialistExists(int id) {
        for (Specialist spec : specialists) {
            if (spec.getId() == id) {
                return true;
            }
        }
        return false;
    }



    public static void exportToCSV() {
        try {
            FileWriter writer = new FileWriter("appointments.csv");

            writer.write("ID,UserID,SpecialistID,Date\n");

            for (Appointment appt : appointments) {
                writer.write(
                        appt.getId() + "," +
                                appt.getUserId() + "," +
                                appt.getSpecialistId() + "," +
                                appt.getDate() + "\n"
                );
            }

            writer.close();
            System.out.println("Exported to CSV!");

        } catch (IOException e) {
            System.out.println("Error exporting!");
        }
    }
}