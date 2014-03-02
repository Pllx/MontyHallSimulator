import java.util.Random;
import java.util.Scanner;


public class MontyHallSimulator {

	/*
	 * This program takes in the number of doors, and number of simulations to be run, and returns the probability of winning by switching doors and otherwise
	 */
	
	static boolean Door1 = false;
	static boolean Door2 = false;
	static boolean Door3 = false;
	
	static int stay= 0;
	static int change = 0;
	static float stayChance= 0;
	static float changeChance= 0;
	
	public static void main(String[] args) {
		
		print("Welcome to the Monty Hall Simulator. We will start with 3 doors. To select the number of simulations, please enter an integer:");
		Scanner s = new Scanner(System.in);
		int simulationNumber= s.nextInt();
		if(s!= null)
			s.close();
		
		print("You have chosen "+ simulationNumber+" simulations. Running...");
		
		for(int i=0; i<simulationNumber; i++){
			stay=Simulator();
		}
		
		change= simulationNumber-stay;
				
		stayChance= (stay*100f)/simulationNumber;
		changeChance= (change*100f)/simulationNumber;
		
		print("The probability of winning while keeping the original choice is "+ stayChance +"%." );
		print("The probability of winning while changing the original choice is "+ changeChance +"%." );

	}

	public static int Simulator(){
		int Winner;
		Random rand= new Random();
		Winner= rand.nextInt(3) + 1;
		
		if (Winner==1){
			Door1= true;
			Door2= false;
			Door3= false;
		}
		else if(Winner==2){
			Door1= false;
			Door2= true;
			Door3= false;
		}
		else{
			Door1= false;
			Door2= false;
			Door3= true;
		}
		
		//now choose picked door
		int Picked;
		Random rand1= new Random();
		Picked= rand1.nextInt(3) + 1;
		
		//now have the host eliminate one of the unchosen doors
		if (Picked==1){
			if (Door1==true)
				stay++;
			else
				change++;
		}
		
		else if (Picked==2){			
			if (Door2==true)
				stay++;
			else
				change++;
		}
		
		else if (Picked==3){
			if (Door3==true)
				stay++;
			else
				change++;
		}
		else
			print("caught the end of picked loop. something went wrong.");

		return stay;
	}
	
	public static void print(String sentence){
		System.out.println(sentence);
	}
}
