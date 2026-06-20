public class Doctor {
    private int doctorID;
    private String doctorName;
    private int doctorPhone;
    private String speciality;
    private int yearsOfExp;

    Doctor(int doctorID, String doctorName, int doctorPhone, String speciality, int yearsOfExp){
        setDoctorID(doctorID);
        setDoctorName(doctorName);
        setDoctorPhone(doctorPhone);
        setSpeciality(speciality);
        setYearsOfExp(yearsOfExp);
    }

    // --------------- Setters --------------------- //

    public void setDoctorID(int doctorID){
        this.doctorID = doctorID;
    }

    public void setDoctorName(String doctorName){
        this.doctorName = doctorName;
    }

    public void setDoctorPhone(int doctorPhone){
        this.doctorPhone = doctorPhone;
    }

    public void setSpeciality(String speciality){
        this.speciality = speciality;
    }

    public void setYearsOfExp(int yearsOfExp){
        this.yearsOfExp = yearsOfExp;
    }

    // ------------- Getters -------------- //

    public int getDoctorID(){
        return doctorID;
    }

    public String getDoctorName(){
        return doctorName;
    }

    public int getDoctorPhone(){
        return doctorPhone;
    }

    public String getSpeciality(){
        return speciality;
    }

    public int getYearsOfExp(){
        return yearsOfExp;
    }


}
