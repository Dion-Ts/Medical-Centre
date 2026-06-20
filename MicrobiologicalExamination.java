public class MicrobiologicalExamination extends Exam {
    private String sampleType;
    private final double costIncreaseRate = 0.20;

    MicrobiologicalExamination(int examID, String examName, String categoryName, int maxSlotsPerDay, String sampleType, double cost, Doctor doctor){
        super(examID,examName,categoryName,maxSlotsPerDay,cost, doctor);
        setSampleType(sampleType);
    }

    public void setSampleType(String sampleType) {
        if (!sampleType.equals("Blood") && !sampleType.equals("Urine") && !sampleType.equals("Swab"))
            throw new IllegalArgumentException("Illegal type, you have to choose between Blood,Urine and Swab");
        this.sampleType = sampleType;
    }

    public String getSampleType(){
        return sampleType;
    }


    @Override
    public double getCost(boolean fastResults) {
        double base = super.getCost();
        return fastResults ? base * (1 + costIncreaseRate) : base ; 
    }
}
