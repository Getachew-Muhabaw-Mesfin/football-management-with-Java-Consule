package projectMain;
import java.util.*;

//this class is final this indicates that no other class inherits from this class it is final 
public final class Player extends Personal_Information{
	 Scanner sc=new Scanner(System.in);
    private String Current_Club;
    private int Jersey_Number;
    private String Position;
    private String Second_Position;
    private String Foot;
    int choice;
    int ans;//used when some task is finished to ask which operation do the user wants
    Address ad=new Address();//instantation for the aggregated class 
    
    //method to insert player information
    public void setPlayer(){
	super.setPersonal_Information();//calls the super class and access it
    
	System.out.println("Player explicit information \n");
    System.out.print("Current_Club: ");
    Current_Club=sc.next();
    System.out.print("Your Jersey_Number: ");
    Jersey_Number=sc.nextInt();
    System.out.print("Your Prior_Position: ");
    Position=sc.next();
    System.out.print("Your Second_Position: ");
    Second_Position=sc.next();
    System.out.print("On which foot do you play? ");
    Foot=sc.next();
    addressRel();
}
    
//access the player explicit informations which are encapsulated in the class
    public String getCurrent_Club() {
        return Current_Club;
    }

    public int getJersey_Number() {
        return Jersey_Number;
    }

    public String getPosition() {
        return Position;
    }

    public String getSecond_Position() {
        return Second_Position;
    }

    public String getFoot() {
        return Foot;
    }
    
    public void addressRel()
    {
    	System.out.println("\t\tAddress and related informations\n\n");
    	ad.setAddress();//accessing the aggregated class
    	Nationality nat=new Nationality();
    }
    
    //to display the information of the player who is currently using the software
    void display(ArrayList<Player> plys, coachMain cm, President pre, int i )
    {
    	super.display();
    	System.out.println("Current_Club: " +plys.get(i).getCurrent_Club());
        System.out.println("Jersey_Number: "+getJersey_Number());
        System.out.println("Prior_Position: " +getPosition());
        System.out.println("Second_Position: " +getSecond_Position());
        System.out.println("Playing Foot: "+getFoot());
    
    	System.out.println("\n1. back \n2. to goto main menu");
    	ans=pre.exp();
		if(ans==1)
			profile(plys, cm, pre,i);
		else
			menu(plys,cm,pre,i);
    }
    
    //The player menu to discover any accessible information about the team and other bodies of the team  
    void menu(ArrayList<Player> plys, coachMain cm, President pre, int i )
	{ 
		System.out.println("Welcome to the players's page \n Choose from the following menu");
		System.out.println("\n\t\t\t Enter your choice");
		System.out.println("\n\t\t1.Profile");
		System.out.println("\n\t\t2.Players Information");
		System.out.println("\n\t\t3.Coach Information");
		System.out.println("\n\t\t4.President Information");
		System.out.println("\n\t\t5.Team Information");
		System.out.println("\n\t\t6.Exit");
		choice=pre.exp6();
		switch(choice)
		{
		 case 1:
			   profile(plys,cm,pre,i);
			  break;
		 case 2:
			 int n= playersInfo(plys, cm, pre,i);
			 if(n==1)
				 menu(plys, cm, pre,i);//detail information
			 else	 
				 menu(plys, cm, pre,i);
			 break;
		 case 3:
			  cm.display(cm,plys);
			 System.out.println("enter any key to goto main menu");
		     String ans1=sc.nextLine();
			 menu(plys,cm,pre,i);
			 break;
		 case 4:
			 pre.display();
			 break;
		 case 5:
			 //team
			 break;
		 case 6:
			 System.exit(0);
		}
	}
    
    //player can see his profile and even can edit some information in this method
    void profile(ArrayList<Player> plys, coachMain cm, President pre, int i )
    {
		FootBallPlayerInformation main= new FootBallPlayerInformation(); 
    	System.out.println("\n\t\t\tProfile\n");
    	System.out.println(" 1.Diplay Profile \n 2.Edit Profile \n 3.Back to main menu \n 4.Log out");
    	choice=pre.exp4();
    	
    	switch(choice)
    	{
    	case 1:
    		display(plys,cm,pre,i);
    		break;
    	case 2:
    		//display();
    		editProfile(plys,cm,pre,i);
    		break;
    	case 3:
    		menu(plys,cm,pre,i);
    		break;
    	case 4:
    		main.mainCaller(plys, cm, pre,i);
    	}
    }
    
    //to edit player information
    void editProfile(ArrayList<Player> plys, coachMain cm, President pre, int i )
    {
    	do {
    		System.out.println("\n\t**************************************************************************************************************************************************************************************");
    		System.out.println("\t\t\t\t\t\t\t\tChoose the data you want to edit: \n\t\t\t\t 1. Name \n\t\t\t\t 2. Sex \n\t\t\t\t 3. Salary   \n\t\t\t\t 4. Experience  \n \t\t\t\t 5. Birth date  ");
    		System.out.println("\n\t**************************************************************************************************************************************************************************************");
    		int choice=pre.exp5();
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
    		ans=pre.exp();
    		
    		}while(ans==1);
    	
    	System.out.println("\n1. back \n2. to goto main menu");
    	ans=pre.exp();
		if(ans==1)
			profile(plys, cm, pre,i);
		else
			menu(plys,cm,pre,i);
    }
    
    //to access player information
    int playersInfo(ArrayList<Player> plys, coachMain cm, President pre, int i )
    {
    	int n=0;
    	System.out.println("\n\t**************************************************************************************************************************************************************************************");
    	System.out.println("\t\t\t\t\t\t\t\twelcome to players information \n\t\t\t\t 1. Display all players informaton \n\t\t\t\t 2. Search \n\t\t\t\t 3. Back   \n \t\t\t\t 4. Main menu  ");
    	System.out.println("\n\t**************************************************************************************************************************************************************************************");
    	
    	int choice=pre.exp4();
    	switch(choice)
    	{
    		case 1:
    			plys.get(i).tabularDisplay(plys,cm,pre,i);
    			for(int j=0; j<=i;j++)
    			   plys.get(j).tabularDisplay2(plys,cm,pre,i,j);
    			System.out.println("Enter   1. other more detial table \n\t2. main menu");
    			n=pre.exp();
    			break;
    	}	
    	return n;
    }
    
    //if someone need to know all information of players in organized form it is displayed in this methode 
    void tabularDisplay(ArrayList<Player> plys, coachMain cm, President pre, int i )
    {
	System.out.println("\n\t\t\tWelcome to players information page");
	System.out.println("\n********************************************************************************************************************************************************************************************************************************************************");
	System.out.format("%10s%20s%20s%10s%15s%10s%10s%18s%15s%15s%25s%20s%20s%20s%20s","|Role Number|","|Full Name|","|Sex|","|Age|","|Blood Type|","|Wight|","|Hight|","|Experience|","|Salary|","|Role|","|Current Club|","|Jersey Number|","|Prior Position|","|Second Position|","|Playing Foot|");
	System.out.println("\n********************************************************************************************************************************************************************************************************************************************************");
    }
    void tabularDisplay2(ArrayList<Player> plys, coachMain cm, President pre, int i,int j )
    {
	System.out.format("\n%-17d%-32s%-10s%-10s%-13s%-10s%-15s%-15s%-17s%-18s%-20s%-20s%-20s%-20s%-20s\n",(j+1),getfName()+" "+getmName()+" "+getlName(),getSex(),getAge(),getBlood_type(),getWight(),getHight(),getExperience(),getSalary(),getRole(),getCurrent_Club(),getJersey_Number(),getPosition(),getSecond_Position(),getFoot());
    }
}

//Address class is an aggregation class of father class Player
class Address
{
	Scanner sc=new Scanner(System.in);
	//declaration
	private int phoneNo;
	private String currentCity;
	private int houseNo;
	private String email;
	private String fax;
	private String poBox;
	
	//set player address
	void setAddress()
	{
		System.out.print("Phone Number: ");
		String temp=sc.nextLine();
		phoneNo=Integer.parseInt(temp);
		System.out.print("Current City: ");
		currentCity=sc.nextLine();
		System.out.print("House Number: ");
		temp=sc.nextLine();
		houseNo=Integer.parseInt(temp);
		System.out.print("Email Address: ");
		email=sc.nextLine();
		System.out.print("Fax: ");
		fax=sc.nextLine();
		System.out.print("Pobox: ");
		poBox=sc.nextLine();
	}
	//getting encapsulated information from getter functions
	int getPhoneNo()
	{
		return phoneNo;
	}
	String getCurrentCity()
	{
		return currentCity;
	}
	int getHouseNo()
	{
		return houseNo;
	}
	String getEmail()
	{
		return email;
	}
	String getFax()
	{
		return fax;
	}
	String getPoBox()
	{
		return poBox;
	}
	void displayAddress()//displaying address of the player
	{
		System.out.print("Phone Number: "+phoneNo);
		System.out.print("Current City: "+currentCity);
		System.out.print("House Number: "+houseNo);
		System.out.print("Email Address: "+email);
		System.out.print("Fax: "+fax);
		System.out.print("Pobox: "+poBox);
	}
}
class Nationality{//ask for nationality
	private String nation;
	private final String currentNation="Ethiopia";
	Scanner sc= new Scanner(System.in);
	Nationality()
	{
		System.out.print("Nationality: ");
		nation=sc.nextLine();
		check();
		System.out.println("Congratulations you have successfully registerd!!! \n Enter any key to go to menu");
		String key=sc.nextLine();

	}
	String getNation()
	{
		return nation;
	}
	void check()//check for nationality and if the player is foreigner prompt to fill some needed informations
	{
		if(currentNation.equals(getNation()))
		{
		}
		else {
			System.out.println("As your information indicates you are from forign country. \n So you should fill some forms");
		}
			
	}
}