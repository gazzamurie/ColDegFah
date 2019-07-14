/*
 * Project Name: DegreeFahrenheit
 * Author: G Murie
 * Date: 17/11/14
 */

   import  java.io.*;
   import java.util.Scanner;
   
public class DegreeFahrenheit {
	
	private static Scanner option;
	private static BufferedReader bufRead;
	private static String inputTempStr;
	private static int selection;
	private static double inputTemp, convertedTemp;
	
  public static void main(String[] args) {
	  //Declare the input so that inputs are placed in bufRead
	  InputStreamReader istream = new InputStreamReader(System.in) ;
	  bufRead = new BufferedReader(istream) ;
	  option = new Scanner(System.in) ;
	  
	  //Use of a try/catch pair to ensure that input is captured, else an error is reported
	  System.out.println("Enter a temperature: ");
	  try{
		  inputTempStr = getString();
	  }catch (IOException e) {
		  e.printStackTrace();
	  }
	  
	  //Convert the string to a double value
	  inputTemp = (Double.valueOf(inputTempStr)).doubleValue();
	  
	  selection = 1 ; //Initilise the selection vairable to allow the menu to be printed.
	  
	  do{
		  
		  selection = displayMenu();
		  if (selection == 1){
			  //Selection 1 indicates a conversation from celsius to fahrenheit.
			  convertedTemp = convertInput(selection, inputTemp);
			  System.err.print("The input temperature was " + inputTemp + " celsius , equivalent to " );
			  System.err.printf("%2f Fahernheit\n\n", convertedTemp);
		  }
		  if (selection == 2) { 
			  //Selection 2 indicates a conversion from farenheit to celcius
			  convertedTemp = convertInput(selection, inputTemp);
			  System.err.print("The input temperature was " +inputTemp + " fahrenheit, equivalent to ");
			  System.err.printf("%2f Celsius\n\n", convertedTemp) ;
		  }
		  if (selection == 3){
			  //Use of a try/catch pair to ensure that input is captured, else an error is reported
			  System.out.println("\nEnter a temperature: ");
			  try{
				  inputTempStr = getString();
			  }catch (IOException e){
				  e.printStackTrace();
			  }
			  //Convert the string to a double value
			  inputTemp = (Double.valueOf(inputTempStr)).doubleValue();
			  }
		  if(selection == 0){
			  System.err.println("\nPROGRAM TERMINATED BY USR INPUT (0).");
		  }
	  } while (selection !=0);
	  
	  }
  // Method to handle display of the menu
  public static int displayMenu(){
	  
	  System.out.println("    Menu     ");
	  System.out.println("    ====     ");
	  System.out.println("         ");
	  System.out.println("1. Convert Celsius to Fahrenheit         ");
	  System.out.println("         ");
	  System.out.println("2. Convert Fahrenheit to Celsius         ");
	  System.out.println("         ");
	  System.out.println("3. Enter a new temperature value         ");
	  System.out.println("         ");
	  System.out.println("0. Exit         ");
	  System.out.println("         ");
	  System.out.println("Enter either 1,2,3 or 0.         ");
	  
	  selection = option.nextInt();
	  return selection ;
  }

  //Method to handle the temperature converstions
  public static double convertInput(int option, double temp){
	  //Convert celsius to fehrenheit
	  if (option == 1){
		  temp = temp*9/5 ; 
		  temp = temp +32 ;
	  }
	  //Convert fahrenheit to celsius
	  if (option == 2){
		  temp = temp - 32 ; 
		  temp = temp/9*5 ;
	  }
	  return temp;
  }
		  //This method is required to get a string from the keyboard
		  public static String getString() throws IOException{
			  return bufRead.readLine();
		  }
	  
  }
