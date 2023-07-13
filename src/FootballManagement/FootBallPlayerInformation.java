package FootballManagement;

// import necessary class
import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;

public class FootBallPlayerInformation {//the class with main method that calls all the methods in other classes
	static int i=-1;
	int choice;
	
	//object creation of the class
	
	Scanner sc=new Scanner(System.in);
	President pre=new President();
	coachMain cm=new coachMain();
	ExceptionHandler handler= new ExceptionHandler();
	ArrayList<Player> plys = new ArrayList<Player>();
	Fan f = new Fan();
	
	//member methods
	
	int check()//promts the user if he is new or not 
	{
	System.out.println("new user or not");
	System.out.println("1.new user \n2.not");
	int ch=handler.exp();
	return ch;
	}
	
	// member method  with   objects as  a parameter
	void mainCaller(ArrayList<Player> plys, coachMain cm, President pre, int i )//method that is called when the user logs out so that other user is able to log in
	{
		System.out.println("\n\t\t\tUser type\n");
    	System.out.println(" \t\t1.Player \n \t\t2.Coach \n \t\t3.President \n \t\t4.Other user");
    	choice=handler.exp4();
    	
    	// switch case and select from the given option
    	switch(choice)
    	{
    	case 1:
    		if(1==check())//checks if the player is new and if the player is new the program will ask him to insert his personal and related information
    		{
    			System.out.print("Enter the clubs secret code: ");
    			String code=sc.nextLine();
    			if(code.compareTo("1234")!=0)
    			{
    				System.out.println("Invalid secret code");
    				mainCaller(plys,cm,pre,i);
    			}
    			plys.add(new Player());//creating new object for the new player
    			i++;
    			plys.get(i).setPlayer(plys,i);// call the player class with arraylist object
    		}
    		if(i==-1)
    		{
    			System.out.println("No players data found");
    			mainCaller(plys,cm,pre,i);
    		}
    		int j=plys.get(i).checkLog(plys,i);
    		plys.get(j).menu(plys,cm,pre,i);
    		break;
    	
    	case 2:
    		     cm.checkLog();
    			// call the coachmain with coach object
    			 cm.coachmain(plys,cm,pre,i);
    		break;
    	
    	case 3:
    		pre.checkLog();
    			// call the presedent class and  set it the information 
    		pre.menu(plys, cm, pre,i);
    		break;
    	
    	case 4:
    		f.fan(plys,cm,pre,i);// call the fan class (supporter)
    	}
	}
	// Main 
	public static void main(String[] args) {
	  
		// object creation of the needed class and other class call other class
		FootBallPlayerInformation main= new FootBallPlayerInformation(); 
		President pre=new President();
		coachMain cm=new coachMain();
		ArrayList<Player> plys = new ArrayList<Player>();
		//call mainCaller method by  from FootBallPlayerinfromation  class(with object main)
		main.mainCaller(plys,cm,pre,i);

}
}