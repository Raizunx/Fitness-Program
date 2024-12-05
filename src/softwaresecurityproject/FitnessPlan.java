package softwaresecurityproject;

/**
 * @author Razan
 */

//Parnet class of Fitness Categories
abstract public class FitnessPlan {
    
    int level; 
    int illness;    
    int age;           
    int surgery;
    
    //Constractor
    //initialize common fields
    public FitnessPlan(int level,int illness,int surgery,int age){
        this.level= level;
        this.illness= illness;
        this.surgery = surgery;
        this.age= age;
    }

    protected void printRecommendation(String recommendation) {
        System.out.println(recommendation);
    }
    
    //abstract method    
    protected abstract void recommendPlan();
}