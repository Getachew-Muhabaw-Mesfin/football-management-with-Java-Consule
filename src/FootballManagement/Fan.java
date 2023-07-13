package FootballManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class Fan {//this class is for the login type other users(open source).
	ExceptionHandler handler=new ExceptionHandler();
	Scanner sc=new Scanner(System.in);
	void fan(ArrayList<Player> plys, coachMain cm, President pre, int i)//other users can see informations
	{
		FootBallPlayerInformation main= new FootBallPlayerInformation(); 
		Player ply= new Player();
		Team t= new Team();
		System.out.println("\n\t\tWelcome to fans Page \n Choose from the following menu");
		System.out.println("\n\t\t\t Enter your choice");
		System.out.println("\n\t\t1.Players Information");
		System.out.println("\n\t\t2.Coach Information");
		System.out.println("\n\t\t3.President Information");
		System.out.println("\n\t\t4.Team Information");
		System.out.println("\n\t\t5. Log out");
		System.out.println("\n\t\t6.Exit");
		int choice=handler.exp6();
		switch(choice)
		{		 
		 case 1:
			int n=playersInfo(plys,cm,pre,i);
			if(n==2)
				fan(plys,cm,pre,i);
			 break;
		 case 2:
			  cm.display();
			 break;
		 case 3:
			 pre.profile(plys, cm, pre, i);
			 break;
		 case 4:
		         t.teamMenu();
				fan(plys,cm,pre,i);
		 case 5:
			 main.mainCaller(plys,cm,pre,i);
		 case 6:
			 System.exit(0);
		}
	}
	 int playersInfo(ArrayList<Player> plys, coachMain cm, President pre, int i )
	    {
		 Player ply= new Player();
	    	int n=0;
	    	System.out.println("\n\t**************************************************************************************************************************************************************************************");
	    	System.out.println("\t\t\t\t\t\t\t\twelcome to players information \n\t\t\t\t 1. Display all players informaton \n\t\t\t\t 2. Search \n\t\t\t\t 3. Sort   \n \t\t\t\t 4. Main menu  ");
	    	System.out.println("\n\t**************************************************************************************************************************************************************************************");
	    	System.out.print("\n-> ");
	    	int choice=handler.exp4();
	    	switch(choice)
	    	{
	    		case 1:
	    			if(i==-1)
    				{
    				System.out.println("No data found");
    				}
	    			else
	    			{
	    			plys.get(i).tabularDisplay(plys,cm,pre,i);
	    			for(int j=0; j<=i;j++)
	    			   plys.get(j).tabularDisplay2(plys,cm,pre,i,j);
	    			}
	    			System.out.println("Enter   1. back \n\t2. main menu");
	    			n=handler.exp();
	    			if(n==1)
	    			{
	    				playersInfo(plys,cm,pre,i);
	    			}
	    			break;
	    		case 2:
	    			if(i==-1)
    				{
    				System.out.println("No data found");
    				}
	    			else
	    			{
	    			ply.search(plys,cm,pre,i);
	    			}
	    			System.out.println("\n1. back \n2. to goto main menu");
	    	    	int ans=handler.exp();
	    			if(ans==1)
	    				playersInfo(plys, cm, pre,i);
	    			else
	    				fan(plys,cm,pre,i);
	    			break;
	    		case 3:
	    			n=ply.sort(plys,cm,pre,i);
	    			if(n==1)
	    			{
	    				playersInfo(plys,cm,pre,i);
	    			}
	    			else
	    				fan(plys,cm,pre,i);
	    			break;
	    		case 4:
	    			fan(plys,cm,pre,i);
	    			break;
	    	}	
	    	return n;
	    }
}
