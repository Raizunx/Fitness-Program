package softwaresecurityproject;

/** 
 * @author Razan
 */

//Child class for SpecificFitnessPlan
//HIIT (High-Intensity Interval Training)
public class HIIT extends SpecificFitnessPlan{

    //Constractor
    public HIIT(int level, int illness, int surgery, int age){
        super( level,  illness,  surgery,  age);
        
        //specify the young and old age for practesing HIIT  
        super.setOldAge(65);
        super.setYoungAge(12);
        
        //print fitness objective
        printRecommendation("*HIIT (High-Intensity Interval Training) Plan: Objective -  mprove Cardiovascular Health*");
    
    }

    @Override
    protected void recommendBeginnerPlan() {
        
        //recomindaition based on illness
        if (illness == 5){ // no illness
            printRecommendation("As beginner you should reach the Advanced level to practis HIIT, "
                + "consult with a professional to determine how to achive that.");
        }else if (illness == 3) {// Lung illness
            printRecommendation("As Beginner you should reach the Advanced level to practis HIIT, "
                + "consult with a professional to determine how to achive that without affecting your Lung illness.");
        }else if (illness == 2) {// Joint illness
            printRecommendation("As Beginner you should reach the Advanced level to practis HIIT, "
                + "consult with a professional to determine how to achive that without affecting your Joint illness.");
        }else {// other illness
            printRecommendation("As Beginner you should reach the Advanced level to practis HIIT, "
                + "consult with a healthcare professional to determine a safe workout plan to achive that without affecting your illness.");
        }
        System.out.println("==========================================");
        }


    @Override
    protected void recommendIntermediatePlan() {
        
        //recomindaition based on illness
        if (illness == 5) {// no illness
            printRecommendation("As Intermediate you should reach the Advanced level to practis HIIT, "
                + "consult with a professional to determine how to achive that.");
        }else if (illness == 3) {// Lung illness
            printRecommendation("As Intermediate you should reach the Advanced level to practis HIIT, "
                + "consult with a professional to determine how to achive that without affecting your Lung illness.");
        }else if (illness == 2) {// Joint illness
            printRecommendation("As Intermediate you should reach the Advanced level to practis HIIT, "
                + "consult with a professional to determine how to achive that without affecting your Joint illness.");
        }else {//other illness
            printRecommendation("As Intermediate you should reach the Advanced level to practis HIIT, "
                + "consult with a healthcare professional to determine a safe workout plan to achive that without affecting your illness.");
        }
        System.out.println("==========================================");
        
    }

    @Override
    protected void recommendAdvancedPlan() {
        
        //recomindaition based on illness
        if (illness == 5){ // no illness
            printRecommendation("As Advanced perform high-intensity exercise sessions your recommended duration is 135 minutes per week.");
        }else if (illness == 3) {// Lung illness
            printRecommendation("As Advanced minimize the intensity and duration of the exercises based on respiratory function, your recommended duration is 90 minutes per week.");
        }else if (illness == 2) {// Joint illness
            printRecommendation("As Advanced perform lower-impact exercises and avoid high-impact movements your recommended duration is 90 minutes per week.");
        }else {// other illness
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
