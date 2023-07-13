package FootballManagement;
import java.util.ArrayList;
import java.util.Scanner;

public final class coachMain extends Personal_Information{
	Scanner input=new Scanner(System.in);
	private String fName="Kassaye";
	private String mName="Arage";
	private String lName="Ergete";
	private String sex="Male";
	private String birth_date="19/07/1965";
	private String blood_type="A";
	private float wight=65;
	private float hight=2;
	private int experience=16;
	private float salary=50000;
	private String userName="Kassaye Arage";
	private String password="Ka1965";
	
	int ch=0,count=0,n=0,count2=0,ans=0,cL=0;
    
	void checkLog()//the coachs loggin information will be checked 
	{
		cL++;
		System.out.println("\tHello coach: ");
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
	
	Coach c=new Coach();
	void display()//to display coaches personal information
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
	
	public void editProfile(ArrayList<Player> plys,coachMain cm,President pre,int i) {//the coach can edit his inforamtion
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
	     ans=handler.exp();
         if(ans==1)
        	 editProfile(plys,cm,pre,i);

	System.out.println("\n1. back \n2. to goto main menu");
	ans=handler.exp();
	if(ans==1)
	    profile(plys,cm,pre,i);
	else
	    coachmain(plys,cm,pre,i);
	   }
	
	public void coachmain(ArrayList<Player> plys, coachMain cm, President pre, int i ) {
		ExceptionHandler handler= new ExceptionHandler();
		Player ply= new Player();
		
		System.out.println("Welcome to the coach's page \n Choose from the following menu");
		System.out.println(" 1.Profile \n 2.Matches \n 3.Trainings \n 4.Statics \n 5.Players information\n 6.Exit ");
		int choice=handler.exp6();
		
		switch(choice)
		{ 
			case 1:
				  profile(plys,cm,pre,i);
				break;
			
			case 2:
				  match(plys,cm,pre,i);
				break;
			
			case 3:
				 training(plys,cm,pre,i);
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
						plys.get(j).statics.setStatics();
					}
				}
				    if(count==0)
				    	System.out.println("Name mismatch");
				}
				System.out.println("Enter any key to go back");
				String s=sc.nextLine();
				coachmain(plys,cm,pre,i);
				break;
			
			case 5:
				 playersInfo(plys,cm,pre,i);
				 coachmain(plys, cm, pre,i);
				break;
			
			case 6:
				System.exit(0);
			    break;
		}
}
		
	void profile(ArrayList<Player> plys, coachMain cm, President pre, int i)
	{
		FootBallPlayerInformation main= new FootBallPlayerInformation();
			System.out.println("\nChoose      \n 1. Display profile		\n 2. Edit profile		\n 3. Logout       \n 4. Main menu");
			ch=handler.exp4();
		switch(ch)
		{
		case 1:
				cm.display();
					System.out.println("\n1. back \n2. to goto main menu");
			    	ans=handler.exp();
			    	if(ans==1)
			    		profile(plys,cm,pre,i);
			    	else if(ans==2)
						coachmain(plys,cm,pre,i);//the program will go back to the the main menu of the coach
				break;

		case 2:
			    editProfile(plys,cm,pre,i);
			    break;
			    
		case 3:
			     main.mainCaller(plys,cm,pre,i);
		        break;
		
		case 4:
				coachmain(plys,cm,pre,i);
			
		}	
	}		
		void match(ArrayList<Player> plys, coachMain cm, President pre, int i)//the coach has access to set and display information
		{
			System.out.println("\nChoose      \n 1. Display match       \n 2. Add new match        \n 3. Main menu");
			ch=handler.exp4();
		switch(ch)
		{
	    case 1:
			if(count==0)
			  {
				System.out.println(".......No upcoming match........");
				System.out.println("\n1. back \n2. to goto main menu");
		    	ans=handler.exp();
				if(ans==2)
					coachmain(plys,cm,pre,i);

			   }
			else if (count>=1) {
				System.out.println("Enter the number of matches: ");
			   n=input.nextInt();
			  for(int j=0; j<n; j++);
				{
					c.displayMatch();
				}}
	    case 2:
			   System.out.println("Enter the number of matches: ");
				n=input.nextInt();
				for(int j=0;j<n;j++);
				{
					c.creMatch();
					count++;
				}
				System.out.println("\n Enter key to goto main menu");
				String ans=input.nextLine();
			    coachmain(plys,cm,pre,i);
				break;				
	    case 3:
			coachmain(plys,cm,pre,i);
			break;		
        }
	}		
		void training(ArrayList<Player> plys, coachMain cm, President pre, int i)//in this method the coach can set and display the training
		{
			System.out.println("Choose      \n 1. Display trainings       \n 2. Add new training       \n 3. Main menu");
			ch=handler.exp4();
			
			switch(ch)
			{
			case 1:
				System.out.println("Enter the number of trainings: ");
				n=input.nextInt();
					for(int j=0;j<n;j++);
					 {
						 c.displayTraining();
					 }
					 System.out.println("\n1. back \n2. to goto main menu");
				    	ans=handler.exp();
						if(ans==2)
							coachmain(plys,cm,pre,i);
				else if (count2==0)
				 {
					System.out.println("---------No upcoming training----------");
					System.out.println("\n1. back \n2. to goto main menu");
			    	ans=handler.exp();
					if(ans==2)
						coachmain(plys,cm,pre,i);
				 }
				break;				
			case 2:
					System.out.println("How many number of trainings do you want to add");
					n=input.nextInt();
					for(int j=0;j<n;j++)
					{
						c.creTraining();
						count2++;
					}
					System.out.println("\n Enter key to goto main menu");
					String ans=input.nextLine();
				    coachmain(plys,cm,pre,i);
				break;
			case 3:
				coachmain(plys,cm,pre,i);
				break;
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
    				System.out.println("Enter any key to go back");
        			sc.next();
    				break;
    				}
	    			plys.get(i).tabularDisplay(plys,cm,pre,i);
	    			for(int j=0; j<=i;j++)
	    			   plys.get(j).tabularDisplay2(plys,cm,pre,i,j);
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
	    			}
	    			break;
	    		case 2:
	    			ply.search(plys,cm,pre,i);
	    			System.out.println("\n1. back \n2. to goto main menu");
	    	    	int ans=handler.exp();
	    			if(ans==1)
	    				playersInfo(plys, cm, pre,i);
	    			else
	    				coachmain(plys,cm,pre,i);
	    			break;
	    		case 3:
	    			n=ply.sort(plys,cm,pre,i);
	    			if(n==1)
	    			{
	    				playersInfo(plys,cm,pre,i);
	    			}
	    			else
	    				coachmain(plys,cm,pre,i);
	    			break;
	    		case 4:
	    			coachmain(plys,cm,pre,i);
	    			break;
	    	}	
	    	return n;
	    }
}
