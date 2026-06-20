import java.time.LocalDate;

public class Appointment {
    private int appointmentID;
    private Patient patient;
    private Exam exam;
    private boolean fastResults;
    private LocalDate examDate;

    Appointment(int appointmentID, Patient patient, Exam exam, boolean fastResults, LocalDate examDate){
        setAppointmentID(appointmentID);
        setPatient(patient);
        setExam(exam);
        setFastResults(fastResults);
        setExamDate(examDate);
    }

    // ------------- Setters --------------- //
    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public void setFastResults(boolean fastResults) {
        this.fastResults = fastResults;
    }

    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }

    // ---------- Getters ----------- //

    public int getAppointmentID() {
        return appointmentID;
    }

    public Patient getPatient() {
        return patient;
    }

    public Exam getExam() {
        return exam;
    }

    public LocalDate getExamDate() {
        return examDate;
    }
    
    public boolean getFastResults(){
        return fastResults;
    }

    


}
