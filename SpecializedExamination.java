public class SpecializedExamination extends Exam {
    private final double costIncreaseRate = 0.30;
    // ti thelei edw/./???? ->DataStorage εχω βαλει χαρακτηριστικο του Γιατρού.
    SpecializedExamination(int examID, String examName, String categoryName, int maxSlotsPerDay,double cost, Doctor doctor){
        super(examID, examName, categoryName, maxSlotsPerDay,cost, doctor);
    }


    @Override
    public double getCost(boolean fastResults) {
        double base = super.getCost();
        return fastResults ? base * (1 + costIncreaseRate) : base ; 
    }
}

