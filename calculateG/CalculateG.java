public class CalculateG { 


    public static double multiply (){
        double number2,number3;
        double multiplication;
        number2=4;
        number3=2.5;
        return multiplication= number2*number3;
    }
    
    public static Integer square (){
        Integer dog;
        dog=5;
        int square;
        return square =dog*dog;
    }
    public static Integer sum() {
    Integer books,pens,summation;
    books=10;
    pens=20;
    return summation=books+pens;
    
    }


public static void main(String[]args){ 
double gravity =-9.81; // Earth's gravity in m/s^2
Integer fallingTime = 30; 
double initialVelocity = 0.0; 
double finalVelocity ; 
double initialPosition = 0.0; 
double finalPosition ; 
// Add the formulas for position and velocity 

finalPosition=0.5*fallingTime*fallingTime +initialVelocity*fallingTime;
finalVelocity=gravity*initialVelocity;
System.out.println("The object's position after " + fallingTime + " seconds is " 
+ finalPosition + " m."); 

System.out.println("multipication: "+ multiply());
System.out.println("summation: "+ sum());
System.out.println("square: "+ square());
} 


} 