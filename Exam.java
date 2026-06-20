
public abstract class Exam {
    private int examID;
    private String examName;
    private String categoryName;
    private int maxSlotsPerDay;
    private double cost;
    private Doctor doctor; // Για να μην αλλάζει final, ξανα δες το αυτο!


    public abstract double getCost(boolean fastResults);


    Exam(int examID, String examName, String categoryName, int maxSlotsPerDay,double cost, Doctor doctor){
        setExamID(examID);
        setExamName(examName);
        setCategoryName(categoryName);
        setMaxSlotsPerDay(maxSlotsPerDay);
        setCost(cost);
    }

    // -------------- Setters -----------------//

    public void setExamID(int examID) {
        this.examID = examID;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setMaxSlotsPerDay(int maxSlotsPerDay) {
        this.maxSlotsPerDay = maxSlotsPerDay;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    // ------------ Getters ----------------//

    public int getExamID() {
        return examID;
    }

    public String getExamName() {
        return examName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getMaxSlotsPerDay() {
        return maxSlotsPerDay;
    }

    public double getCost(){
        return cost;
    }
    public Doctor getDoctor(){
        return doctor;
    }


}
