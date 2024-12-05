package softwaresecurityproject;

/**
 * @author Razan
 */

//Child class for SpecificFitnessPlan
 abstract class StrengthTraining extends SpecificFitnessPlan{
    
    //Constractor
    public StrengthTraining(int level, int illness, int surgery, int age){
        super( level,  illness,  surgery,  age);
        
        //specify the young and old age for practesing StrengthTraining  
        super.setOldAge(65);
        super.setYoungAge(12);
        
        //print fitness objective
        printRecommendation("*Strength Training Plan: Objective -  Muscle Building*");
            
    }

    @Override
    protected void recommendBeginnerPlan() {
        
        //recomindaition based on illness
        if (illness == 5){ // no illness
            printRecommendation("As beginner you should reach the intermediate level to build muscle "
                    + "consult with a professional to determine how to achive that.");
        }else if (illness == 1 || illness == 2 || illness == 3) { // Heart or Joint or Lung illness
            System.out.println("As beginner you should reach the intermediate level to build muscle "
                + "consult with a professional to determine how to achive that.");
        }else {// other illness 
            printRecommendation("As beginner you should reach the intermediate level to build muscle, "
                + "consult with a healthcare professional to determine a safe workout plan to achive that without affecting your illness.");
        }
        // add recomindaition regard the age
        ageNoteRecommendaition();
        }


    @Override
    protected void recommendIntermediatePlan() {
        
        //recomindaition based on illness
        if (illness == 5) {// no illness
            printRecommendation("As intermediate your recommended duration is 140 minutes per week.");
        }else if (illness == 1 || illness == 2 || illness == 3) {// Heart or Joint or Lung illness
            System.out.println("As intermediate your recommended duration is 120 minutes per week"
                + "but be careful and don't put pressure on yourself you may reduce the duration and do lower-impact exercises.");
        }else {//other illness
            printRecommendation("Consult with a healthcare professional to determine a safe workout plan without affecting your illness.");
        }
        // add recomindaition regard the age
        ageNoteRecommendaition();
    }

    @Override
    protected void recommendAdvancedPlan() {
        
        //recomindaition based on illness
        if (illness == 5) {// no illness
            printRecommendation("As advanced your recommended duration is 130 minutes per week.");
        }else if (illness == 1 || illness == 2 || illness == 3) {// Heart or Joint or Lung illness
            System.out.println("As advanced your recommended duration is 120 minutes per week"
                + "but be careful and don't put pressure on yourself you may reduce the duration and do lower-impact exercises.");
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
            printRecommendation("Note: According to your age Please applay the excerises slowly and it preferable to change the fitness plan.");
        }
        //young people case
        else if (age <= youngAge) {
            printRecommendation("Note: According to your age its recomened to focus on fun, engaging activities like tag, or short bursts, or carrying things.");
        }
        System.out.println("==========================================");
        
    }

}