//import java.io.FileWriter;
//import java.io.IOException;
//
//public static void saveAppointmentsToFile() {
//    try {
//        FileWriter writer = new FileWriter("appointments.txt");
//
//        for (Appointment appt : appointments) {
//            writer.write(
//                    appt.getId() + "," +
//                            appt.getUserId() + "," +
//                            appt.getSpecialistId() + "," +
//                            appt.getDate() + "\n"
//            );
//        }
//
//        writer.close();
//        System.out.println("Saved to file!");
//
//    } catch (IOException e) {
//        System.out.println("Error saving file!");
//    }
//}
