import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataStorage ds = new DataStorage();

        List<Doctor> doctors = ds.loadDoctors();
        List<Patient> patients = ds.loadPatients();
        List<Exam> exam = ds.LoadExam(doctors);
        List<Appointment> appointments = ds.loadAppointments(patients, exam);
        
        Menu m = new Menu(doctors, patients, exam, appointments);
        m.start();
    }
}
