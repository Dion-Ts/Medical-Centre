public class ImagingExamination extends Exam{
    private String machineType;
    private final double costIncreaseRate = 0.10;

    ImagingExamination(int examID, String examName, String categoryName, int maxSlotsPerDay, String machineType, double cost, Doctor doctor){
        super(examID, examName, categoryName, maxSlotsPerDay,cost,doctor);
        setMachineType(machineType);
    }

    public void setMachineType(String machineType) {
        if (!machineType.equals("MRI") && !machineType.equals("CT") && !machineType.equals("X-Ray"))
            throw new IllegalArgumentException("Illegal type, you have to choose between MRI,CT and X-Ray");
        this.machineType = machineType;
    }
    
    
    public String getMachineType() {
        return machineType;
    }


    @Override
    public double getCost(boolean fastResults) {
        double base = super.getCost();
        return fastResults ? base * (1 + costIncreaseRate) : base ; 
    }
    
}
