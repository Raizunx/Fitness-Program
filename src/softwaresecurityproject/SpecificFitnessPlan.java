package softwaresecurityproject;

/**
 * @author Razan
 */

public abstract class SpecificFitnessPlan extends FitnessPlan {

    int oldAge;
    int youngAge;
    
    //Constractor
    public SpecificFitnessPlan(int level, int illness, int age, int surgery) {
    super(level, illness, age, surgery);
    }
    
    public void setOldAge(int oldAge) {
        this.oldAge = oldAge;
    }
    
    public void setYoungAge(int youngAge) {
        this.youngAge = youngAge;
    }
    
    //condition to check age validity
    protected boolean isValidAgeForTraining() {
        //range of valid age
        return (age>= SoftwareSecurityProject.minAge && SoftwareSecurityProject.maxAge >=age);
    }
    
    //return true if user have not made surgery recently
    protected boolean isNoSurgery() {
        return (surgery == 2);
    }
    
    //depending on fittness level calling the recomended plan for it
    @Override
    public void recommendPlan() {
        if (isValidAgeForTraining()) {
            
            //no surgry have made recently
            if(isNoSurgery()){
                if (level == 1){ 
                    recommendBeginnerPlan();
                }else if (level == 2) {
                    recommendIntermediatePlan();
                }else if (level == 3)
                    recommendAdvancedPlan();
                else{
                    printRecommendation("Invalid Fitness Level Choice");  
                }
            }
            //surgry have made recently
            else{
                printRecommendation("Consult with a healthcare professional to determine "
                + "a safe workout plan that fits your surgery and support ur health.");
            }
        } 
        //age out of valid range
        else{
            printRecommendation("Your age is not qualified age for Training.");
        }
    }
    
    //abstract methods    
    protected abstract void recommendBeginnerPlan();
    protected abstract void recommendIntermediatePlan();
    protected abstract void recommendAdvancedPlan();
    protected abstract void ageNoteRecommendaition();

}
