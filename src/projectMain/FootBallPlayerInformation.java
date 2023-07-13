package projectMain;

import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;

public class FootBallPlayerInformation {
	static int i=-1;
	int choice;
	Scanner sc=new Scanner(System.in);
	President pre=new President();
	coachMain cm=new coachMain();
	
	ArrayList<Player> plys = new ArrayList<Player>();
	
	int check()
	{
	System.out.println("new user or not");
	System.out.println("1.new user \n2.not");
	int ch=pre.exp();
	return ch;
	}
	
	void mainCaller(ArrayList<Player> plys, coachMain cm, President pre, int i )
	{
		plys.add(new Player());
		System.out.println("\n\t\t\tuser type\n");
    	System.out.println(" 1.player \n 2.Coach \n 3.president \n 4.other user");
    	choice=pre.exp4();
    	
    	switch(choice)
    	{
    	case 1:
    		i++;
    		if(1==check())
    			plys.get(i).setPlayer();
    		plys.get(i).menu(plys,cm,pre,i);
    		break;
    	case 2:
    		if(1==check())
    		  cm.coachmain(plys,cm,pre,i);
    		break;
    	case 3:
    		if(1==check())
    		      pre.setPresident();
    		pre.menu(plys, cm, pre,i);
    		break;
    	case 4:
    		
    	}
	}
	public static void main(String[] args) {
	
		FootBallPlayerInformation main= new FootBallPlayerInformation(); 
		President pre=new President();
		coachMain cm=new coachMain();
		ArrayList<Player> plys = new ArrayList<Player>();
		
		main.mainCaller(plys,cm,pre,i);

}
}