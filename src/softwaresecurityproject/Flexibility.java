package softwaresecurityproject;

/**
 * @author Razan
 */

//Child class for FitnessPlan
abstract class Flexibility extends SpecificFitnessPlan {

    //Constractor
    public Flexibility(int level, int illness, int surgery, int age){
        super( level,  illness,  surgery,  age);
        
        //specify the young and old age for practesing Flexibility  
        super.setOldAge(80);
        super.setYoungAge(5);
        
        //print fitness objective
        printRecommendation("*Flexibility Training Plan: Objective -  Improve Flexibility*");
    
    }

    @Override
    protected void recommendBeginnerPlan() {
        
        //recomindaition based on illness
        if (illness ==1 || illness ==3 || illness == 5){ //  Heart or Lung or no illness
            printRecommendation("As beginner your recommended duration in flexibility is 120 minutes per week");
        }else if ( illness == 2 ) {//  Joint illness
            printRecommendation("As beginner your recommended duration in flexibility is 110 minutes per week "
                + "but be careful and don't put pressure on your Joint");
        }else {// other illness
            printRecommendation("Consult with a healthcare professional to determine a safe workout plan without affecting your illness.");
        }
        // add recomindaition regard the age
        ageNoteRecommendaition();
        }


    @Override
    protected void recommendIntermediatePlan() {
        
        //recomindaition based on illness
        if (illness==1 || illness==3 || illness == 5){ //  Heart or Lung or no illness
            printRecommendation("As intermediate your recommended duration in flexibility is 110 minutes per week");
        }else if ( illness == 2 ){ //  Joint illness
            System.out.println("As intermediate your recommended duration in flexibility is 100 minutes per week"
                + "but don't put pressure on your Joint");
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
            printRecommendation("As advanced your recommended duration in flexibility is 100 minutes per week");
        }else if (illness == 1 || illness == 2 || illness == 3) {// Heart or Joint or Lung illness
            System.out.println("As advanced your recommended duration in flexibility is 90 minutes per week"
                + "but be careful and don't put pressure on your Joint");
        }else{ //other illness
            printRecommendation("Consult with a healthcare professional to determine a safe workout plan without affecting your illness.");
        }
        // add recomindaition regard the age
        ageNoteRecommendaition();
    }

    @Override
    protected void ageNoteRecommendaition() {
        
        //old people case
        if (age >= oldAge) {
            printRecommendation("Note: According to your age flexibility can negatively affect you.");
        }
        //young people case
        else if (age <= youngAge) {
            printRecommendation("Note: According to your age its recomened to focus on fun, engaging activities.");
        }
        System.out.println("==========================================");
        
    }
    
}

