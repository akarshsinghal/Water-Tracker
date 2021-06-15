//all of the packages needed to operate the program
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.util.stream.*;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;

public class TestingFinal {
	/*Name: Akarsh Singhal
	 *Date: 1/10/2020
	 *Purpose: to create a program in which users will be able to track their water usage and receive feedback, points, and averages based on amount entered.
	 */

	//static variables declared to be used throughout program
	static Scanner input = new Scanner(System.in);
	static double points = 0;
	static String answer;
	static double[]allData; //this array gathers all of the water usages
	static {
	      allData = new double[7]; //sets the size for array
	      allData[0] = 0;
	      allData[1] = 0;
	      allData[2] = 0;
	      allData[3] = 0;
	      allData[4] = 0;
	      allData[5] = 0;
	      allData[6] = 0;
 	   }
	
	static String[]locationName; //gathers all of the location names
	static {
		locationName = new String[7];//sets the size for array
		locationName[0] = "Hose";
		locationName[1] = "Toilet";
		locationName[2] = "Sink";
		locationName[3] = "Shower";
		locationName[4] = "Laundry";
		locationName[5] = "Dishes";
		locationName[6] = "Faucet";
		
	}
	
	static int[]totalPoints; //gathers all of the points earned/lost
	static {
		totalPoints = new int[7]; //sets the size for array
		totalPoints[0] = 0;
		totalPoints[1] = 0;
		totalPoints[2] = 0;
		totalPoints[3] = 0;
		totalPoints[4] = 0;
		totalPoints[5] = 0;
		totalPoints[6] = 0;
	}
	
	
	public static void welcome() { //JFrame method in which user will have to register to use the app, a window will appear.
		//https://javatutorial.net/jframe-buttons-listeners-text-fields
		JFrame f = new JFrame("Resgister to use app!");
		// submit button
		JButton b = new JButton("Submit");
		b.setBounds(100, 150, 140, 40);
		// enter name label
		JLabel label = new JLabel();
		JLabel label4 = new JLabel();
		label.setText("Enter Name :");
		label.setBounds(10, 10, 100, 100); //setBounds moves and resizes this component
		label4.setText("Enter Password :");
		label4.setBounds(10, 10, 200, 200);
		// empty labels which will show event after button clicked
		final JLabel label1 = new JLabel();
		label1.setBounds(10, 170, 200, 100);
		// textfield to enter name
		JTextField textfield = new JTextField();
		textfield.setBounds(110, 50, 130, 30);
		JTextField textfield1 = new JTextField();
		textfield1.setBounds(110, 96, 130, 30);
		// add to frame to show the user
		f.add(label1);
		f.add(label4);//these add everything on to screen
		f.add(textfield);
		f.add(textfield1);
		f.add(label);
		f.add(b);
		f.setSize(300, 300); //sets size of window
		f.setLayout(null);
		f.setVisible(true); //shows window
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// action listener listens for any user interaction and runs
		b.addActionListener(new ActionListener() {

			@Override //method declaration is intended to override a method declaration in a supertype
			public void actionPerformed(ActionEvent arg0) {
				label1.setText("Welcome to Water Waste Monitor.");//displays message if user presses button
			}
		});
	}
	
	public static void main(String[] args) {
		welcome();
		//Asks users name again to add special effect of login
		System.out.println("Verify your name: ");
		String name = input.next();
		System.out.println("Veryifying......");
		int counter = 0;
		while (counter < 6) { //time stops for loading effect
			counter++;
			try {
				Thread.sleep(10000/10);
			} catch (InterruptedException e) { //used when using Thread.sleep(#)
				e.printStackTrace();
			}
			}
		title(name);
		do {  //do while loop; allows user to repeat program
		System.out.println("Would you like to track the water usage inside or outside?: ");
		String userLocation = input.next(); //first option 
		intro(userLocation); //runs first method and all the rest are within it
		
		System.out.println();
		
		//displays all data that has been collected using arrays
		System.out.println("Location   |   Usage Amount (gallons)   |   Points");
		System.out.println("..................................................");
		for (int i = 0; i < 7; i++) {
			System.out.println(locationName[i] + "\t" + "\t" + "\t" + allData[i]+ "\t" + "\t" + "\t" + totalPoints[i]);//formats data
		}
		
		//adds up total points and water to display below data
		int sumOfPoints = IntStream.of(totalPoints).sum();
		double sumOfWater = DoubleStream.of(allData).sum();
		System.out.println();
		System.out.println("Total"+ "\t" + "\t" + "\t"+sumOfWater+"\t" + "\t" + "\t"+sumOfPoints);
		
		//option to repeat
		System.out.println();
		System.out.println("Would you like to log another usage in (yes/no)?: ");
		answer = input.next();
		}while(answer.equalsIgnoreCase("yes"));
		website();
	}//main
	
	public static void website() {//open website at end for tips
		Desktop d = Desktop.getDesktop(); //allows java to open browser
		try { //url that will open
			d.browse(new URI("https://www.volusia.org/services/growth-and-resource-management/environmental-management/natural-resources/water-conservation/25-ways-to-save-water.stml"));
		} catch (IOException e) { //catch statement allows you to define a block of code to be executed if an error occurs in the try block
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) { //Checked exception thrown to indicate that a string could not be parsed as aURI reference
			// TODO Auto-generated catch block
			e.printStackTrace();//helps the programmer to understand where the actual problem occurred
		}
	}
	
	public static void title(String userName){// method talks about the issue and program
		System.out.println("*********************************");
		System.out.println("Welcome to the Water Tracking App");
		System.out.println("*********************************");
		System.out.println();
		System.out.println("Water is a vital source for surviving, unfortunately,");
		System.out.println("there is a limited amount of freshwater available on Earth.");
		System.out.println("According to National Geographic, 2.5 percent of our water");
		System.out.println("is fresh and out of that only 1 percent is accessible to us.");
		System.out.println();
		System.out.println("This is why you must help preserve water, you can do this by");
		System.out.println("tracking your water usage and observing how much water you use.");
		System.out.println("The Water Tracking App will give you feedback, tips, and points");
		System.out.println("based on your water usage.");
		System.out.println();
		//name of user is formated correctly to show respect
		System.out.println((userName.substring(0,1)).toUpperCase()+(userName.substring(1)).toLowerCase()+", to get started, simply log your water usages by following the options below."); //asks for user name
	}//title 
	
	public static void intro(String userLocation){ //asks for where user wants to track water
		if (userLocation.equals("inside")){
			System.out.println("Would you like to track the water usage of the kitchen, laundry, or washroom?: "); //asks the user location they want
			String userLocationInside = input.next();
			inside(userLocationInside); //runs 'inside' method
		}
		else if (userLocation.equals("outside")){
			System.out.println("How many minutes did you use the hose for?: ");
			double hoseMinutes = input.nextDouble();
			hose(hoseMinutes); //will run next method
		}
		else{ //if the input is wrong, this will run
			System.out.println("Invalid input!");
		}
	}//intro
	
	public static void inside(String userLocationInside){//asks for where user wants to track water in kitchen
		switch (userLocationInside){ //depending on the location picked by user, the corresponding option will run
		
		case "kitchen": System.out.println("Would you like to track the water usage of the dishwasher or faucet?:");
		String userLocationKitchen = input.next();
		kitchen(userLocationKitchen); //will run next method
		break;
		
		case "laundry": System.out.println("How many cycles did you run the washing machine?: ");
		int washingMachineCycles = input.nextInt();
		washingMachine(washingMachineCycles); //will run next method
		break;
		
		case "washroom": System.out.println("Would you like to track the water usage of the toilet, sink, or shower?:");
		String userLocationWashroom = input.next();
		washroom(userLocationWashroom); //will run next method
		break;
		
		default: //default is ran if input does not match any listed
			System.out.println("Invalid input!");
			break;
		}
	}//inside
	
	
	public static double hose(double hoseMinutes) { //collects and gives data if hose option picked
		double totalHose = 6 * hoseMinutes; //calculates total water usage
		allData[0] = totalHose;
		System.out.println("You used the hose for "+hoseMinutes+" minutes."); //tells user how much water they used 
		System.out.println("You have consumed "+totalHose+" gallons, assuming each minute takes 6 gallons.");
		if (totalHose<100) {
			System.out.println("Your water usage for the hose is EXCELLENT."); //indicates the level the got based on water usage
			points = points + 10;
			totalPoints[0] = 10;
			System.out.println("You earned "+10+" points."); //tells the user how many points earned
		}
		else if (totalHose>100 && totalHose<150){
			System.out.println("Your water usage for the hose is SATISFACTORY.");
			points = points + 5;
			totalPoints[0] = 5;
			System.out.println("You earned "+5+" points.");
			//message about why not to waste water and tips on how to save water
			System.out.println("It is very important to water your grass everyday on hot days, however, the time of day could become a big factor.");
			System.out.println("Watering your grass in the day time when its sunny is going to waste water because lots of it will evaporate.");
			System.out.println("Save water by watering your grass in the evening when it is less sunny so that the grass absorbs the water.");
		}
		else if (totalHose>150) {
			System.out.println("Your water usage for the hose is BAD.");
			points = points - 5;
			totalPoints[0] = -5;
			System.out.println("You lost "+5+" points."); //add points to user based on usage of water
			System.out.println("It is very important to water your grass everyday on hot days, however, the time of day could become a big factor.");
			System.out.println("Watering your grass in the day time when its sunny is going to waste water because lots of it will evaporate.");
			System.out.println("Save water by watering your grass in the evening when it is less sunny so that the grass absorbs the water.");
		}
		return totalHose;
	} //hose
	
	
	public static void kitchen(String userLocationKitchen){ //asks for location/object in kitchen
		switch (userLocationKitchen){ //asks location details further
		case "dishwasher": System.out.println("How many cycles did you run?: ");
		double dishwasherCycles = input.nextDouble(); //takes input from user and stores it
		dishwasher(dishwasherCycles);
		break;
		
		case "faucet": System.out.println("How many minutes did you use it?: ");
		double faucetMinutes = input.nextDouble(); 
		faucet(faucetMinutes); //runs next method
		break;

		default:
			System.out.println("Invalid input!"); //invalid if none of above selected
			break;
		}
	}//kitchen
	
	public static void washroom(String userLocationWashroom){//asks location in washroom
		switch (userLocationWashroom){
		case "toilet": System.out.println("How many times did you use the toilet?: ");
		int toiletFlush = input.nextInt(); //stores value entered to be used in a method
		toilet(toiletFlush);
		break;
		
		//many locations, therefore switch is used
		case "sink": System.out.println("How many minutes did you use the sink (include brushing teeth time)?: ");
		double sinkMinutes = input.nextDouble();
		sink(sinkMinutes);
		break;
		
		case "shower": System.out.println("How many minutes did you shower?: ");
		double showerMinutes = input.nextDouble();
		shower(showerMinutes); //runs next method
		break;
		
		default:
			System.out.println("Invalid input!");//invalid 
			break;
		}
	}//washroom
	
	public static double toilet(int toiletFlush) { //collects and gives data if toilet is picked
		double totalFlush = 1.6 * toiletFlush; //calculates total water usage
		allData[1] = totalFlush;
		System.out.println("You flushed the toilet "+toiletFlush+" times."); //tells user how much water they used 
		System.out.println("You have consumed "+totalFlush+" gallons, assuming each flush takes 1.6 gallons.");
		if (totalFlush<5.1) { //compares entered value with recommended amount
			System.out.println("Your water usage for the toilet is EXCELLENT."); //indicates the level the got based on water usage
			points = points + 10;
			totalPoints[1] = 10;
			System.out.println("You earned "+10+" points.");
		}
		else if (totalFlush>5.1 && totalFlush<11){
			System.out.println("Your water usage for the toilet is SATISFACTORY.");
			points = points + 5; //adds points to points and totalPoints array
			totalPoints[1] = 5;
			System.out.println("You earned "+5+" points.");
			//message about why not to waste water and tips on how to save water
			System.out.println("Flushing the toilet is something that most people do automatically without putting too much thought into it.");
			System.out.println("Flushing toilets is the largest single use of a household’s indoor water consumption, making up roughly 30% of indoor water consumed.");
			System.out.println("Save water by purchasing a low-flow toilet and if it is yellow let it mellow!");
		}
		else if (totalFlush>11) {
			System.out.println("Your water usage for the toilet is BAD.");
			points = points - 5;
			totalPoints[1] = -5; 
			//tells user why not to waste water and gives tips
			System.out.println("You lost "+5+" points."); //add points to user based on usage of water
			System.out.println("Flushing the toilet is something that most people do automatically without putting too much thought into it.");
			System.out.println("Flushing toilets is the largest single use of a household’s indoor water consumption, making up roughly 30% of indoor water consumed.");
			System.out.println("Save water by purchasing a low-flow toilet and if it is yellow let it mellow!");
		}
		return totalFlush;
	}//toilet
	
	public static double sink(double sinkMinutes) {
		double totalSink = 1.5 * sinkMinutes; //calculates total water usage
		allData[2] = totalSink;
		System.out.println("You used the sink for "+sinkMinutes+" minutes."); //tells user how much water they used 
		System.out.println("You have consumed "+totalSink+" gallons, assuming each minute takes 1.5 gallons.");
		if (totalSink<15.1) {
			System.out.println("Your water usage for the toilet is EXCELLENT."); //indicates the level the got based on water usage
			points = points + 10;
			totalPoints[2] = 10;
			System.out.println("You earned "+10+" points."); //add points to user based on usage of water
		}
		else if (totalSink>15.1 && totalSink<22.5){
			System.out.println("Your water usage for the toilet is SATISFACTORY.");
			points = points + 5;
			totalPoints[2] = 5;
			System.out.println("You earned "+5+" points.");
			//message about why not to waste water and tips on how to save water
			System.out.println("A Middlesex University Study done shows that 1 of the 3 People leave the tap running while brushing their teeth.");
			System.out.println("This is extremely detrimental for the environment since so much water is being wasted.");
			System.out.println("Save water by turning off the tap when you brush your teeth or apply soap to your hands.");
		}
		else if (totalSink>22.5) {
			System.out.println("Your water usage for the toilet is BAD.");
			points = points - 5;
			totalPoints[2] = -5; //subtracts points and updates array
			System.out.println("You lost "+5+" points.");
			System.out.println("A Middlesex University Study done shows that 1 of the 3 People leave the tap running while brushing their teeth.");
			System.out.println("This is extremely detrimental for the environment since so much water is being wasted.");
			System.out.println("Save water by turning off the tap when you brush your teeth or apply soap to your hands.");
		}
		return totalSink;
	}//sink
	
	public static double shower(double showerMinutes) {
		double totalShower = 2.1 * showerMinutes; //calculates total water usage
		allData[3] = totalShower;
		System.out.println("You used the shower for "+showerMinutes+" minutes."); //tells user how much water they used 
		System.out.println("You have consumed "+totalShower+" gallons, assuming each minute takes 2.1 gallons.");
		if (totalShower<11) {
			System.out.println("Your water usage for the shower is EXCELLENT."); //indicates the level the got based on water usage
			points = points + 10;
			totalPoints[3] = 10;
			System.out.println("You earned "+10+" points."); //tells user how many points earned
		}
		else if (totalShower>11 && totalShower<22){
			System.out.println("Your water usage for the shower is SATISFACTORY.");
			points = points + 5; //adds points to points static variable
			totalPoints[3] = 5;
			System.out.println("You earned "+5+" points."); //add points to user based on usage of water
			System.out.println("Showers are typically the third largest water use after toilets and clothes washers.");
			System.out.println("This is extremely detrimental for the environment since so much water is being wasted.");
			System.out.println("Save water by taking short showers and turning off the shower while applying soap.");
		}
		else if (totalShower>22) {
			System.out.println("Your water usage for the shower is BAD.");
			points = points - 5;
			totalPoints[3] = - 5;
			System.out.println("You lost "+5+" points.");
			//message about why not to waste water and tips on how to save water
			System.out.println("Showers are typically the third largest water use after toilets and clothes washers.");
			System.out.println("This is extremely detrimental for the environment since so much water is being wasted.");
			System.out.println("Save water by taking short showers and turning off the shower while applying soap.");
		}
		return totalShower;
	}//shower
	
	
	public static int washingMachine(int washingMachineCycles) {
		int totalWashingMachine = 20 * washingMachineCycles; //calculates total water usage
		allData[4] = totalWashingMachine;
		System.out.println("You ran the washing machine for "+washingMachineCycles+" cycles."); //tells user how much water they used 
		System.out.println("You have consumed "+totalWashingMachine+" gallons, assuming each cycle takes 20 gallons.");
		if (totalWashingMachine<21) {
			System.out.println("Your water usage for the dishwasher is EXCELLENT."); //indicates the level the got based on water usage
			points = points + 10;
			totalPoints[4] = 10; //adds points to array of points
			System.out.println("You earned "+10+" points.");
		}
		else if (totalWashingMachine>39 && totalWashingMachine<50){
			System.out.println("Your water usage for the dishwasher is SATISFACTORY.");
			points = points + 5; //adds points to variable points
			totalPoints[4] = 5;
			System.out.println("You earned "+5+" points."); //add points to user based on usage of water
			System.out.println("Washing laundry is a significant use of water in the average home; accounting for");
			System.out.println("15% to 40% of the overall water consumption inside the typical household of four persons.");
			System.out.println("Save more water by only running your washing machine when it is full.");
		}
		else if (totalWashingMachine>59) {
			System.out.println("Your water usage for the dishwasher is BAD."); 
			points = points - 5;
			totalPoints[4] = - 5;
			System.out.println("You lost "+5+" points.");
			//message about why not to waste water and tips on how to save water
			System.out.println("Washing laundry is a significant use of water in the average home; accounting for");
			System.out.println("15% to 40% of the overall water consumption inside the typical household of four persons.");
			System.out.println("Save more water by only running your washing machine when it is full.");
		}
		return totalWashingMachine;
	}//washingMachine 
	
	public static double dishwasher(double dishwasherCycles) {
		double totalDishwasher = 6 * dishwasherCycles; //calculates total water usage
		allData[5] = totalDishwasher;
		System.out.println("You ran the dishwasher for "+dishwasherCycles+" cycles."); //tells user how much water they used 
		System.out.println("You have consumed "+totalDishwasher+" gallons, assuming each cycle takes 6 gallons.");
		if (totalDishwasher<7) {
			System.out.println("Your water usage for the dishwasher is EXCELLENT."); //indicates the level the got based on water usage
			points = points + 10;
			totalPoints[5] = 10;
			System.out.println("You earned "+10+" points."); //add points to user based on usage of water
		}
		else if (totalDishwasher>11 && totalDishwasher<17){
			System.out.println("Your water usage for the dishwasher is SATISFACTORY.");
			points = points + 5;
			totalPoints[5] = 5;
			System.out.println("You earned "+5+" points.");
			//message about why not to waste water and tips on how to save water
			System.out.println("On a planet where water scarcity affects over 40% of the world's population, reducing unnecessary");
			System.out.println("water usage is imperative in order to save the water so that everyone can get access to it.");
			System.out.println("Save more water by limiting the number of dishwasher cycles you run to 1 per day.");
		}
		else if (totalDishwasher>17) {
			System.out.println("Your water usage for the dishwasher is BAD.");
			points = points - 5;
			totalPoints[5] = -5;
			System.out.println("You lost "+5+" points."); //tells user the loss of points
			//displays facts, tips
			System.out.println("On a planet where water scarcity affects over 40% of the world's population, reducing unnecessary");
			System.out.println("water usage is imperative in order to save the water so that everyone can get access to it.");
			System.out.println("Save more water by limiting the number of dishwasher cycles you run to 1 - 2 per day.");
		}
		return totalDishwasher;
	}//dishwasher
	
	public static double faucet(double faucetMinutes) {
		double totalFaucet = 2.2 * faucetMinutes; //calculates total water usage
		allData[6] = totalFaucet;
		System.out.println("You ran the faucet for "+faucetMinutes+" minutes."); //tells user how much water they used 
		System.out.println("You have consumed "+totalFaucet+" gallons, assuming each minute takes 2.2 gallons.");
		if (totalFaucet<15) {
			System.out.println("Your water usage for the faucet is EXCELLENT."); //indicates the level the got based on water usage
			points = points + 10;
			totalPoints[6] = 10;
			System.out.println("You earned "+10+" points.");
		}
		else if (totalFaucet>15 && totalFaucet<25){
			System.out.println("Your water usage for the faucet is SATISFACTORY.");
			points = points + 5;
			totalPoints[6] = 5;
			System.out.println("You earned "+5+" points.");
			//message about why not to waste water and tips on how to save water
			System.out.println("The water that is running off the surface of your kitchen sink is considered as waste water.");
			System.out.println("The amount of water we use is constantly growing. An average person uses 127% more water than in 1950.");
			System.out.println("Save the water of your kitchen faucet by using a dishwasher instead of washing dishes by hand.");
		}
		else if (totalFaucet>30) {
			System.out.println("Your water usage for the dishwasher is BAD.");
			points = points - 5;
			totalPoints[6] = -5;
			System.out.println("You lost "+5+" points."); //add points to user based on usage of water
			//displays the facts and tips based on usage
			System.out.println("The water that is running off the surface of your kitchen sink is considered as waste water.");
			System.out.println("The amount of water we use is constantly growing. An average person uses 127% more water than in 1950.");
			System.out.println("Save the water of your kitchen faucet by using a dishwasher instead of washing dishes by hand.");
			System.out.println("Save the water of your kitchen faucet by refrigerating water because it takes a long time for cold water to come.");
		}
		return totalFaucet;
	}//faucet
	
	
}
