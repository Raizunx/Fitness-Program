package softwaresecurityproject;

/**
 * @author Razan
 */

//Child class for FitnessPlan
 abstract class Yoga extends SpecificFitnessPlan {
     
    //Constractor
    public Yoga(int level, int illness, int surgery, int age) {
        super(level, illness, surgery, age);
        
        //print fitness objective
        printRecommendation("*Yoga Training Plan: Objective -  Stress Relief*");
    
    }

    @Override
    protected void recommendBeginnerPlan() {
            
        //if person have illness
        if (illness == 5) {
            System.out.println("As a beginner practitioner, focus on building flexibility and core strength."
                + " Gentle poses like Child's Pose and Downward Dog are great starting points.");

        }else {
            System.out.println("But depending on your illness plsease try to avoid strenuous poses to prevent discomfort.");
        }
        // add recomindaition regard the age
        ageNoteRecommendaition();
        }


    @Override
    protected void recommendIntermediatePlan() {
        
        //if person have illness
        if (illness == 5) {
            System.out.println("To maintain balance and flexibility to get intermediate level, "
                + "consider incorporating Chair Yoga and restorative poses into your routine.");

        }else {
            System.out.println("But depending on your illness plsease try to avoid strenuous poses to prevent discomfort.");
        }
        // add recomindaition regard the age
        ageNoteRecommendaition();
    }

    @Override
    protected void recommendAdvancedPlan() {
        
        //if person have illness
        if (illness != 5) {
            System.out.println("You're in a great position to explore a variety of yoga styles, "
                + "from gentle Hatha to more dynamic Vinyasa.");
        }
        
        else {
            System.out.println("But depending on your illness plsease try to avoid strenuous poses to prevent discomfort.");
        }
        // add recomindaition regard the age
        ageNoteRecommendaition();
    }

    @Override
    protected void ageNoteRecommendaition() {
        
        //general recomindaition
        printRecommendation("Note: Yoga is a fantastic choice for people of all ages and fitness levels.");
        System.out.println("The Recommended duration: 120 minutes per week.");

        System.out.println("==========================================");
        
    }

}
