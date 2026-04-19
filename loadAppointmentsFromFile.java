//import java.io.File;
//import java.util.Scanner;
//
//public static void loadAppointmentsFromFile() {
//    try {
//        File file = new File("appointments.txt");
//
//        if (!file.exists()) return;
//
//        Scanner fileScanner = new Scanner(file);
//
//        while (fileScanner.hasNextLine()) {
//            String line = fileScanner.nextLine();
//            String[] parts = line.split(",");
//
//            int id = Integer.parseInt(parts[0]);
//            int userId = Integer.parseInt(parts[1]);
//            int specId = Integer.parseInt(parts[2]);
//            String date = parts[3];
//
//            appointments.add(new Appointment(id, userId, specId, date));
//        }
//
//        fileScanner.close();
//
//    } catch (Exception e) {
//        System.out.println("Error loading file!");
//    }
//}
