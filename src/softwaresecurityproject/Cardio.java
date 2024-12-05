package softwaresecurityproject;

/**
 * @author Razan
 */

//Child class for SpecificFitnessPlan
abstract class Cardio extends SpecificFitnessPlan  {
    
    //Constractor
    public Cardio(int level, int illness, int surgery, int age){
        super( level,  illness,  surgery,  age);
        
        //specify the young and old age for practesing Cardio 
        super.setOldAge(70);
        super.setYoungAge(12);
        
        //print fitness objective
        printRecommendation("*Cardio Training Plan: Objective - Weight Loss*");
    }

    @Override
    protected void recommendBeginnerPlan() {
        
        //recomindaition based on illness
        if (illness == 5){ // no illness
            printRecommendation("beginner, your recommended cardio duration is 150 minutes per week.");
        }else if (illness == 1 || illness == 2 || illness == 3) { // Heart or Joint or Lung illness
            printRecommendation("As a beginner, start with 120 minutes of low-impact cardio, but be cautious.");
        }else { // other illness
            printRecommendation("Consult with a healthcare professional to determine a safe workout plan without affecting your illness.");
        }
        // add recomindaition regard the age
        ageNoteRecommendaition();
        }


    @Override
    protected void recommendIntermediatePlan() {
        
        //recomindaition based on illness
        if (illness == 5){ // no illness
            printRecommendation("As an intermediate, aim for 180 minutes per week with moderate intensity.");
        }else if (illness == 1 || illness == 2 || illness == 3) { // Heart or Joint or Lung illness
            printRecommendation("As an intermediate, reduce intensity to avoid strain and aim for 150 minutes.");
        }else {//other illness
            printRecommendation("Consult with a healthcare professional to determine a safe workout plan without affecting your illness.");
        }
        // add recomindaition regard the age
        ageNoteRecommendaition();
    }

    @Override
    protected void recommendAdvancedPlan() {
        
        //recomindaition based on illness
        if (illness == 5){ // no illness
            printRecommendation("As advanced, aim for 200 minutes of high-intensity cardio per week.");
        }else if (illness == 1 || illness == 2 || illness == 3) {// Heart or Joint or Lung illness
            printRecommendation("As advanced, aim for 180 minutes but adjust intensity to avoid injury.");
        }else {//other illness
            printRecommendation("Consult with a healthcare professional to determine a safe workout plan without affecting your illness.");
        }
        // add recomindaition regard the age
        ageNoteRecommendaition();
    }

    @Override
    protected void ageNoteRecommendaition() {
        
        //old people case
        if (age >= oldAge) {
            printRecommendation("Note: According to your age Please focus on low-impact exercises and be careful.");
        }
        //young people case
        else if (age <= youngAge) {
            printRecommendation("Note: According to your age its recomened to focus on fun, engaging activities like tag, or short bursts.");
        }
        System.out.println("==========================================");
        
    }
    
}