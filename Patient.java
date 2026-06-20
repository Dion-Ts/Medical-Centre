import java.util.ArrayList;
import java.util.List;

public class Patient {
    private int patientID;
    private String patientName;
    private int patientPhone;
    private String email;

    private List<Appointment> appointments = new ArrayList<>();
    Patient(int patientID, String patientName, int patientPhone, String email){
        setPatientID(patientID);
        setPatientName(patientName);
        setPatientPhone(patientPhone);
        setEmail(email);
    }

    // --------------- Setters ------------- //
    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setPatientPhone(int patientPhone) {
        this.patientPhone = patientPhone;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    // -------------- Getters --------------- //

    public int getPatientID() {
        return patientID;
    }

    public String getPatientName() {
        return patientName;
    }

    public int getPatientPhone() {
        return patientPhone;
    }

    public String getEmail() {
        return email;
    }

    public List<Appointment> getAppointments(){
        return appointments;
    }
}
