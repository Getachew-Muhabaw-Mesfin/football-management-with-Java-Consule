package projectMain;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public final class President extends Personal_Information {
	int choice;
	int ans;

	Scanner sc=new Scanner(System.in);
	private String qualification;
	Sponsership sponser;
	Market mar;
	PlayerCard card;
	Statics stat;
	Contract cont;
	
	public void setPresident()
	{
		super.setPersonal_Information();
		System.out.print("Qualification: ");
		qualification=sc.next();
	}
	
	String getQual()
	{
		return qualification;
	}
	
	void display(ArrayList<Player> plys, coachMain cm, President pre, int i )
	{
		if(getfName()==null)
    	{
    		System.out.println("---------No data inserted----------");
    	}
    	else
    	{
		super.display();
		System.out.println("Qualification: "+getQual());
    	}
		System.out.println("\n1. back \n2. to goto main menu");
    	ans=exp();
		if(ans==1)
			profile(plys, cm, pre,i);
		else
			menu(plys,cm,pre,i);
	}
	
	void menu(ArrayList<Player> plys, coachMain cm, President pre, int i )
	{
		System.out.println("Welcome to the players's page \n Choose from the following menu");
		System.out.println("\n\t\t\t Enter your choice");
		System.out.println("\n\t\t1.Profile");
		System.out.println("\n\t\t2.Players Information");
		System.out.println("\n\t\t3.Coach Information");
		System.out.println("\n\t\t4.Team Information");
		System.out.println("\n\t\t5.Exit");
		choice=exp5();
		switch(choice)
		{
		 case 1:
			  profile(plys,cm,pre,i);
			  break;
		 case 2:
			 int n= playersInfo(plys,cm,pre,i);
			 if(n==1)
				 menu(plys,cm,pre,i);
			 break;
		 case 3:
			  cm.display();
			 break;
		 case 4:
			 //team
		 case 5:
			 System.exit(0);
		}
	}
void profile(ArrayList<Player> plys, coachMain cm, President pre, int i )
{
	FootBallPlayerInformation main= new FootBallPlayerInformation();
	System.out.println("\n\t\t\tProfile\n");
	System.out.println(" 1.Diplay Profile \n 2.Edit Profile \n 3.Back to main menu \n 4.Log out");
	choice=exp4();
	
	switch(choice)
	{
	case 1:
		display(plys,cm,pre,i);
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
int playersInfo(ArrayList<Player> plys, coachMain cm, President pre, int i )
{
	int n=0;
	System.out.println("\n\t**************************************************************************************************************************************************************************************");
	System.out.println("\t\t\t\t\t\t\t\twelcome to players information \n\t\t\t\t 1. Display all players informaton \n\t\t\t\t 2. Search \n\t\t\t\t 3. Transfer   \n\t\t\t\t 4. Back   \n \t\t\t\t 5. Main menu  ");
	System.out.println("\n\t**************************************************************************************************************************************************************************************");
	
	int choice=exp5();//error
	switch(choice)
	{
		case 1: 
			plys.get(i).tabularDisplay(plys,cm,pre,i);
			for(int j=0; j<=i;j++)
			   plys.get(j).tabularDisplay2(plys,cm,pre,i,j);
			System.out.println("Enter 1. to go to other more detial table \n\t2. to go to main menu");
			n=exp();
			break ;
	}
	return n;
}
public void editProfile(ArrayList<Player> plys, coachMain cm, President pre, int i ) {
	do {
	System.out.println("\n\t**************************************************************************************************************************************************************************************");
	System.out.println("\t\t\t\t\t\t\t\tChoose the data you want to edit: \n\t\t\t\t 1. Name \n\t\t\t\t 2. Sex \n\t\t\t\t 3. Salary   \n\t\t\t\t 4. Experience  \n \t\t\t\t 5. Birth date  ");
	System.out.println("\n\t**************************************************************************************************************************************************************************************");
	int choice=exp5();
	switch(choice)
	{
	case 1: 
		editName();
		break;
		
	case 2:
		editSex();
		break;
		
	case 3:
		editSalary();
		break;
		
	case 4:
		editExp();
		break;
		
	case 5:
		editdob();
		break;
		
	default: 
			System.out.println("Choose a valid value");
			break;
    }
     System.out.print("Do you want to edit another information \n\t1.yes \n\t2.no");
     ans=exp();

    }while(ans==1);

System.out.println("\n1. back \n2. to goto main menu");
ans=exp();
if(ans==1)
    profile(plys, cm, pre,i);
else
    menu(plys,cm,pre,i);
   }


int exp()
{
	try {
		choice=sc.nextInt();
		if(choice!=1 && choice!=2)
			throw new Exception("");
	}
	catch(InputMismatchException e)
	{
		sc.next();
		System.out.print("Enter an integer: ");
		exp();
	}
	catch(Exception e)
	{
		//sc.next();
		System.out.print("Choose only 1 and 2");
		exp();
	}
	return choice;
}

int exp4()
{
	try {
		choice=sc.nextInt();
		if(choice<1 || choice>4)
			throw new Exception("");
	}
	catch(InputMismatchException e)
	{
		System.out.print("Enter an integer: ");
		sc.next();
		exp4();
	}
	catch(Exception e)
	{
		//sc.next();
		System.out.print("Choose only between 1 and 4:  ");
		exp4();
	}
	return choice;
}
int exp5()
{
	try {
		choice=sc.nextInt();
		if(choice<1 || choice>5)
			throw new Exception("");
	}
	catch(InputMismatchException e)
	{
		sc.next();
		System.out.print("Enter an integer: ");
		exp5();
	}
	catch(Exception e)
	{
		//sc.next();
		System.out.print("Choose only 1 and 2");
		exp5();
	}
	return choice;
}

int exp6()
{
	try {
		choice=sc.nextInt();
		if(choice<1 || choice>6)
			throw new Exception("");
	}
	catch(InputMismatchException e)
	{
		System.out.print("Enter an integer: ");
		sc.next();
		exp6();
	}
	catch(Exception e)
	{
		//sc.next();
		System.out.print("Choose only between 1 and 6:  ");
		exp6();
	}
	return choice;
}

}

class Sponsership{
	
}

class Market{
	
}

class PlayerCard{
	Scanner sc=new Scanner(System.in);
	private int noOfCardsofR;
	private int noOfCardsofY;
	private String type;
	private final int addCard=1;
	
	PlayerCard()
	{
		System.out.println("\t\t\t\tCard"); 
		System.out.print("Card Type");
		type=sc.next();
		noOfCardsofR=sc.nextInt();
		noOfCardsofY=sc.nextInt();
	}
	int getCard()
	{
		return noOfCardsofR;
	}
	String getType()
	{
		return type;
	}
	
}

class Statics{
	
}

class Contract
{
	
}
