package FootballManagement;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public final class President extends Personal_Information {//this class is for the login type president with a lot of access personal informations are extended from class personal inforamtion.
	//member variable of the class
	int choice;
	int ans,cL=0;
	Sponsership sponser;
	private String qualification;
   //object creation 
	
	ExceptionHandler handler= new ExceptionHandler();
	Scanner sc=new Scanner(System.in);

	private String fName="Fikadu";
	private String mName="Mamo";
	private String lName="Endale";
	private String sex="Male";
	private String birth_date="19/07/1960";
	private String blood_type="O";
	private float wight=70;
	private float hight=2;
	private int experience=23;
	private float salary=89000;
	private String userName="Fikadu Buna";
	private String password="Fb1960";
	
	void checkLog()//the president loggin information will be checked 
	{
		cL++;
		System.out.println("\tHello Mr. Presidnt: ");
		System.out.print("User name: ");
		String user=sc.nextLine();
		System.out.print("Password: ");
		String pass=sc.nextLine();
		
		if ((userName.compareToIgnoreCase(user)==0)&&(password.compareTo(pass))==0)
            return;
        else
        {
            System.out.println("Invalid User name or password");
            if(cL==3)
            {
            	System.out.println("You tried a lot");
            	System.exit(0);
             }
            checkLog();
        }
        
	}
	
	//Display the information of  President
	void display()
	{
		 System.out.println("Name: "+fName+" "+mName+" "+lName);
		 System.out.println("Sex: "+sex);
		 System.out.println("Date of Brith: "+birth_date);
		 System.out.println("Blood type: "+blood_type);
		 System.out.println("Weight: "+wight);
		 System.out.println("Height: "+hight);
		 System.out.println("Experience: "+experience);
		 System.out.println("Salary: "+salary);
	}
	// menu of the president
	void menu(ArrayList<Player> plys, coachMain cm, President pre, int i )
	{
		Team t= new Team();
		System.out.println("Welcome to the presidents's page \n Choose from the following menu");
		System.out.println("\n\t\t\t Enter your choice");
		System.out.println("\n\t\t1.Profile");
		System.out.println("\n\t\t2.Players Information");
		System.out.println("\n\t\t3.Coach Information");
		System.out.println("\n\t\t4.Team Information");
		System.out.println("\n\t\t5.Exit");
		choice=handler.exp5();
		switch(choice)
		{
		 case 1:
			  profile(plys,cm,pre,i);
			  break;
		 case 2:
			 int n= playersInfo(plys,cm,pre,i);
			 if(n==2)
				 menu(plys,cm,pre,i);
			 break;
		 case 3:
			  cm.display();
			 break;
		 case 4:
			t.preTeamMenu();
		    menu(plys,cm,pre,i);
		 case 5:
			 System.exit(0);
		}
	}
	
	// profile of the  president
	
void profile(ArrayList<Player> plys, coachMain cm, President pre, int i )
{
	FootBallPlayerInformation main= new FootBallPlayerInformation();
	System.out.println("\n\t\t\tProfile\n");
	System.out.println(" 1.Diplay Profile \n 2.Edit Profile \n 3.Back to main menu \n 4.Log out");
	choice=handler.exp4();
	
	switch(choice)
	{
	case 1:
		display();
		break;
	case 2:
		editProfile(plys,cm,pre,i);
		break;
	case 3:
		menu(plys,cm,pre,i);
		break;
	case 4:
		main.mainCaller(plys,cm,pre,i);
	}
}

public void editProfile(ArrayList<Player> plys,coachMain cm,President pre,int i) {
	System.out.println("\n\t**************************************************************************************************************************************************************************************");
	System.out.println("\t\t\t\t\t\t\t\tChoose the data you want to edit: \n\t\t\t\t 1. Name \n\t\t\t\t 2. Sex \n\t\t\t\t 3. Salary   \n\t\t\t\t 4. Experience  \n \t\t\t\t 5. Birth date  ");
	System.out.println("\n\t**************************************************************************************************************************************************************************************");
	int choice=handler.exp5();
	switch(choice)
	{
	case 1: 
		System.out.print("First Name: ");
		 fName=sc.next();
		 System.out.print("Midle Name: ");
		 mName=sc.next();
		 System.out.print("Last Name: ");
		 lName=sc.next();
		break;
		
	case 2:
		System.out.print("Sex: ");
		 sex=sc.next();
		break;
		
	case 3:
		System.out.print("Salary: ");
		 salary=handler.floatCheck();
		break;
		
	case 4:
		System.out.print("Experience: ");
		 experience=handler.intCheck();
		break;
		
	case 5:
		System.out.print("Date of Brith: ");
		 birth_date=sc.next();
		break;

    }
     System.out.print("Do you want to edit another information \n\t1.yes \n\t2.no");
    int  ans=handler.exp();
     if(ans==1)
    	 editProfile(plys,cm,pre,i);

System.out.println("\n1. back \n2. to goto main menu");
ans=handler.exp();
if(ans==1)
    profile(plys,cm,pre,i);
else
    menu(plys,cm,pre,i);
   }

// president can the  see the players information
int playersInfo(ArrayList<Player> plys, coachMain cm, President pre, int i )
{
	Player ply= new Player();
	int n=0;
	System.out.println("\n\t**************************************************************************************************************************************************************************************");
	System.out.println("\t\t\t\t\t\t\t\twelcome to players information \n\t\t\t\t 1. Display all players informaton \n\t\t\t\t 2. Search \n\t\t\t\t 3. Sort \n\t\t\t\t 4. Card information \n\t\t\t\t 5. Transfer   \n\t\t\t\t 6. Delete   \n\t\t\t\t 7. Main menu  ");
	System.out.println("\n\t**************************************************************************************************************************************************************************************");
	
	int choice=handler.exp7();
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
			System.out.println("Enter   1. other more detial table \n\t2. main menu");
			n=handler.exp();
			if(n==1)
			{
				plys.get(i).DetTabularDisplay(plys,cm,pre,i);
    			for(int j=0; j<=i;j++)
    			   plys.get(j).DetTabularDisplay2(plys,cm,pre,i,j);
    			System.out.println("Enter any key to go back");
    			sc.next();
    			String s=sc.nextLine();
    			playersInfo(plys,cm,pre,i);
			}
			break ;
			
		case 2:
			ply.search(plys,cm,pre,i);
			System.out.println("\n1. back \n2. to goto main menu");
	    	ans=handler.exp();
			if(ans==1)
				playersInfo(plys, cm, pre,i);
			else
				menu(plys,cm,pre,i);
			break;
		
		case 3:
			n=ply.sort(plys,cm,pre,i);
			if(n==1)
			{
				playersInfo(plys,cm,pre,i);
			}
			else
				menu(plys,cm,pre,i);
			break;
			
		case 4:
			int count=0;
			System.out.println("Enter the name of the player ");
			String name=sc.nextLine();
			if(i==-1)
				System.out.println("No player inserted");
			else
			{
			for(int j=0; j<=i; j++)
			{
				if((plys.get(j).getfName().compareToIgnoreCase(name))==0)
				{
					count++;
					plys.get(j).card.setPlayerCard();
				}
			}
			    if(count==0)
			    	System.out.println("Name mismatch");
			}
			System.out.println("Enter any key to go back");
			String s=sc.nextLine();
			playersInfo(plys,cm,pre,i);
			break;
			
		case 5:
			transfer(plys,cm,pre,i);
			break;
			
		case 6:
			delete(plys,cm,pre,i);
			break;
			
		case 7:
			menu(plys, cm, pre, i);
			break;
	}
	return n;
}

void transfer(ArrayList<Player> plys, coachMain cm, President pre, int i)
{
	System.out.println("what do you want \n\t1. To Buy  \n\t2. To sell");
	ans=handler.exp();
	if(ans==1)
	{
		plys.add(new Player());
			i++;
			System.out.println("Please insert the infomation of the new player");
			plys.get(i).setPlayer(plys,i);
			System.out.println("You just need to check medical information ");
	}
	else
	{
	   int count=0;
		   System.out.println("Enter the name of the player you want to sell");
		  String  name=sc.nextLine();
	
		for(int j=0; j<=i; j++)
			if(name.compareToIgnoreCase(plys.get(j).getfName())==0)
			{
				count++;
				plys.get(i).tabularDisplay(plys,cm,pre,i);
				plys.get(j).tabularDisplay2(plys,cm,pre,i,j);
				System.out.println("Do you really want to sell this player \n\t1. yes \n\t2. no");
				ans=handler.exp();
				if(ans==1)
				{
					for(int k=j; k<i; k++)
					{
						plys.set(k, plys.get(k+1));
					}
					plys.set(i, null);
					i--;
					System.out.println("Player transfer finished successfully!!!\n");
				}
			}
		if(count==0)
			System.out.println("No match found");
	}
		System.out.println("\n1. To perform other transfer  \n2. to goto main menu");
 	ans=handler.exp();
 	if(ans==1)
 		transfer(plys,cm,pre,i);
 	else
 		menu(plys,cm,pre,i);
}
   void delete(ArrayList<Player> plys, coachMain cm, President pre, int i)
   {
	   int count=0;
		   System.out.println("Enter the name of the player you want to delete");
		  String  name=sc.nextLine();
	
		for(int j=0; j<=i; j++)
			if(name.compareToIgnoreCase(plys.get(j).getfName())==0)
			{
				count++;
				plys.get(i).tabularDisplay(plys,cm,pre,i);
				plys.get(j).tabularDisplay2(plys,cm,pre,i,j);
				System.out.println("Do you realy want to delete this player \n\t1. yes \n\t2. no");
				ans=handler.exp();
				if(ans==1)
				{
					for(int k=j; k<i; k++)
					{
						plys.set(k, plys.get(k+1));
					}
					plys.set(i, null);
					i--;
					System.out.println("Deleted successfully!!!\n");
				}
			}
		if(count==0)
			System.out.println("No match found");
		
		System.out.println("\n1. To delete other player  \n2. to goto main menu");
    	ans=handler.exp();
    	if(ans==1)
    		delete(plys,cm,pre,i);
    	else
    		menu(plys,cm,pre,i);
   }
   
}

class Sponsership{
	
}


