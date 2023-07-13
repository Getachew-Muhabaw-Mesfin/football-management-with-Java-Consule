package FootballManagement;
import java.util.*;

//this class is final this indicates that no other class inherits from this class it is final 
public final class Player extends Personal_Information {//this class is for the login type player with self accessibilty.
	 Scanner sc=new Scanner(System.in);
	 ExceptionHandler handler= new ExceptionHandler();
    private String Current_Club;
    private int Jersey_Number;
    private String Position;
    private String Second_Position;
    private String Foot;
    private int contract;
    private String userName;
    private String password;
    int choice,cL=0;
    int ans;//used when some task is finished to ask which operation do the user wants
    Address ad=new Address();//instantation for the aggregated class 
    MaritualStatus mary=new MaritualStatus();
    Nationality nat=new Nationality();
    PlayerCard card= new PlayerCard();
    PlayerStatics statics= new PlayerStatics();
    
    int checkLog(ArrayList<Player> plys,int i)//the players loggin information will be checked 
	{
		cL++;
		System.out.print("\nUser name: ");
		String user=sc.nextLine();
		System.out.print("Password: ");
		String pass=sc.nextLine();
		
		for(int j=0; j<=i; j++)
		{
		if ((plys.get(j).getUserName().compareToIgnoreCase(user)==0)&&(plys.get(j).getPassword().compareTo(pass))==0)
            return j;
		}
            System.out.println("Invalid User name or password");
            if(cL==3)
            {
            	System.out.println("You tried a lot");
            	System.exit(0);
             }
            checkLog(plys,i);
           
           return i;
	}
    
    //method to insert player information
    public void setPlayer(ArrayList<Player> plys,int i){
	super.setPersonal_Information();//calls the super class and access it
	mary.setMaritualStatus();
	
	System.out.println("Player explicit information \n");//title
	System.out.println("Position(Goal Keeper, Defence , Mid Filder, Attacker)");
	System.out.print("Your Prior Position: ");
    Position=handler.expPos();
    System.out.print("Your Second Position: ");
    Second_Position=handler.expPos();
    System.out.print("Your Jersey Number: ");
    Jersey_Number=handler.jerseyCheck(plys,i);
    System.out.print("On which foot do you play? \n 1. Right \n 2. Left \n 3. Both ");
    int f=handler.exp3();
    if(f==1)
    	Foot="Right";
    else if(f==2)
    	Foot="Left";
    else
    	Foot="Both";
    System.out.println("Contract years: ");
    contract=handler.intCheck();
    addressRel(plys);
}
    void editJersy()
	{
	System.out.print("Jersy Number: ");
	Jersey_Number=handler.intCheck();
	}
    void editPos()
	{
		System.out.print("Prior Position: ");
		 Position=handler.expPos();
	}
//access the player explicit informations which are encapsulated in the class
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
    
    public int getContract()
    {
    	return contract;
    }
    
    public void addressRel(ArrayList<Player> plys)
    {
    	System.out.println("\n\n\t\tAddress and related informations\n");
    	ad.setAddress();//accessing the aggregated class
    	nat.setNationality(plys);
    	user();
    	System.out.println("Congratulations you have successfully registerd!!! \n Enter any key to go to menu");
 		String key=sc.nextLine();
   }
    
    //to display the information of the player who is currently using the software
    void display(ArrayList<Player> plys, coachMain cm, President pre, int i )
    {
    	super.display();
        System.out.println("Jersey_Number: "+getJersey_Number());
        System.out.println("Contract: "+contract);
        System.out.println("Prior_Position: " +getPosition());
        System.out.println("Second_Position: " +getSecond_Position());
        System.out.println("Playing Foot: "+getFoot());
       
        System.out.println("\t\tFamily Informations\n");
        mary.displayMar();
        
        System.out.println("\n\n\t\tAddress and related informations\n");
        ad.displayAddress(); 
        nat.displayNation();
    	
        System.out.println("\n1. back \n2. to goto main menu");
    	ans=handler.exp();
		if(ans==1)
			profile(plys, cm, pre,i);
		else
			menu(plys,cm,pre,i);
    }
    
    void user()
    {
    	System.out.print("User name: ");
		userName=sc.nextLine();
		System.out.print("Password: ");
		password=sc.nextLine();
    }
    String getUserName()
    {
    	return userName;
    }
    String getPassword()
    {
    	return password;
    }
    //The player menu to discover any accessible information about the team and other bodies of the team  
    void menu(ArrayList<Player> plys, coachMain cm, President pre, int i )
	{ 
    	Team t= new Team();
		System.out.println("Welcome to the players's page \n Choose from the following menu");
		System.out.println("\n\t\t\t Enter your choice");
		System.out.println("\n\t\t1.Profile");
		System.out.println("\n\t\t2.Players Information");
		System.out.println("\n\t\t3.Coach Information");
		System.out.println("\n\t\t4.President Information");
		System.out.println("\n\t\t5.Team Information");
		System.out.println("\n\t\t6.Exit");
		choice=handler.exp6();
		switch(choice)
		{
		 case 1:
			   profile(plys,cm,pre,i);
			  break;
		 case 2:
			 playersInfo(plys, cm, pre,i);
			 break;
		 case 3:
			  cm.display();
			 System.out.println("enter any key to goto main menu");
		     String ans1=sc.nextLine();
			 menu(plys,cm,pre,i);
			 break;
		 case 4:
			 pre.display();
			 System.out.println("enter any key to goto main menu");
		     ans1=sc.nextLine();
			 menu(plys,cm,pre,i);
			 break;
		 case 5:
			 t.teamMenu();
		     menu(plys,cm,pre,i);
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
    	System.out.println(" 1.Diplay Profile \n 2.Edit Profile \n 3.Statics \n 4.Card information \n 5.Back to main menu \n 6.Log out");
    	choice=handler.exp6();
    	
    	switch(choice)
    	{
    	case 1:
    		display(plys,cm,pre,i);
    		break;
    	case 2:
    		editProfile(plys,cm,pre,i);
    		System.out.println("enter any key to goto back");
		     String ans1=sc.nextLine();
		     profile(plys,cm,pre,i);
    		break;
    	case 3:
    		statics.display();
    		System.out.println("enter any key to goto back");
		     ans1=sc.nextLine();
		     profile(plys,cm,pre,i);
    		break;
    	case 4:
    		card.display();
    		break;
    	case 5:
    		menu(plys,cm,pre,i);
    		break;
    	case 6:
    		main.mainCaller(plys, cm, pre,i);
    	}
    }
    
    //to edit player information
    void editProfile(ArrayList<Player> plys, coachMain cm, President pre, int i )
    {
    	do {
    		System.out.println("\n\t**************************************************************************************************************************************************************************************");
    		System.out.println("\t\t\t\t\t\t\t\tChoose the data you want to edit: \n\t\t\t\t 1. Name \n\t\t\t\t 2. Salary \n\t\t\t\t 3. Experience   \n\t\t\t\t 4. Prior Position  \n\t\t\t\t 5. Jersey Number  \n\t\t\t\t 6. Current City");
    		System.out.println("\n\t**************************************************************************************************************************************************************************************");
    		int choice=handler.exp6();
    		switch(choice)
    		{
    			case 1: 
    				editName();
    				break;
    				
    			case 2:
    				editSalary();
    				break;
    				
    			case 3:
    				editExp();
    				break;
    				
    			case 4:
    				editPos();
    				break;
    				
    			case 5:
    				editJersy();
    				break;
    				
    			case 6:
    				ad.editCity();
    				break;
    		}
    		System.out.print("Do you want to edit another information \n\t1.yes \n\t2.no");
    		ans=handler.exp();
    		
    		}while(ans==1);
    	
    	System.out.println("\n1. back \n2. to goto main menu");
    	ans=handler.exp();
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
    				break;
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
    			else
   				 menu(plys, cm, pre,i);
    			break;
    		case 2:
    			search(plys,cm,pre,i);
    			System.out.println("\n1. back \n2. to goto main menu");
    	    	ans=handler.exp();
    			if(ans==1)
    				playersInfo(plys, cm, pre,i);
    			else
    				menu(plys,cm,pre,i);
    			break;
    		case 3:
    			n=sort(plys,cm,pre,i);
    			if(n==1)
    			{
    				playersInfo(plys,cm,pre,i);
    			}
    			else
    				menu(plys,cm,pre,i);
    			break;
    		case 4:
    			menu(plys,cm,pre,i);
    			break;
    	}	
    	return n;
    }
    
    //if someone need to know all information of players in organized form it is displayed in this method 
    void tabularDisplay(ArrayList<Player> plys, coachMain cm, President pre, int i )
    {
	System.out.println("\n\t\t\tWelcome to players information page");
	System.out.println("\n********************************************************************************************************************************************************************************************************************************************************");
	System.out.format("%10s%20s%20s%15s%10s%10s%18s%15s%20s%20s%20s%20s%20s20s","|Role Number|","|Full Name|","|Sex|","|Blood Type|","|Wight|","|Hight|","|Experience|","|Salary|","|Jersey Number|","|Prior Position|","|Second Position|","|Playing Foot|","|Contract Years|","|Total Rate|");
	System.out.println("\n********************************************************************************************************************************************************************************************************************************************************");
    }
    void tabularDisplay2(ArrayList<Player> plys, coachMain cm, President pre, int i,int j )
    {
	System.out.format("\n%-17d%-32s%-10s%-13s%-10s%-15s%-15s%-17s%-20s%-20s%-20s%-20s%-20s-20s\n",(j+1),getfName()+" "+getmName()+" "+getlName(),getSex(),getBlood_type(),getWight(),getHight(),getExperience(),getSalary(),getJersey_Number(),getPosition(),getSecond_Position(),getFoot(),getContract(),statics.getTotalRate());
    }
    
    void DetTabularDisplay(ArrayList<Player> plys, coachMain cm, President pre, int i )
    {
	System.out.println("\n\t\t\tWelcome to players information page");
	System.out.println("\n*************************************************************************************************************************************************************************************************");
	System.out.format("%10s%20s%20s%20s%20s%20s%15s%20s%20s","|Role Number|","|Full Name|","|Nationality|","|House Number|","|Phone Number|","|Email Address|","|POBOX|","|Marritual Status|","|Childeren|");
	System.out.println("\n************************************************************************************************************************************************************************************************");
    }
    void DetTabularDisplay2(ArrayList<Player> plys, coachMain cm, President pre, int i,int j)
    {
	System.out.format("\n%-17d%-25s%-10s%-10s%-18d%-20d%-20s%-20d%-15s%-20d\n",(j+1),getfName()+" "+getmName()+" "+getlName(),nat.getNation(),ad.getHouseNo(),ad.getPhoneNo(),ad.getEmail(),ad.getPoBox(),mary.getMaried(),mary.getChildNo());
    }
   
    void search(ArrayList<Player> plys, coachMain cm, President pre, int i)//searching information with name and jersey number
    {
    	String name;
    	int count=0;
    	System.out.println("\n\tInsert in which information do you want to find");
    	System.out.println("\t1.Name \n\t2.Jersy Number \n->");
    	int choice=handler.exp();
    	switch(choice)
    	{
    	case 1: 
    	    System.out.println("Enter the name you would like to find");
    	    name=sc.next();
    	    int j;
    		for(j=0; j<=i; j++)
    			if(name.compareToIgnoreCase(plys.get(j).getfName())==0)
    			{
    				count++;
    				plys.get(i).tabularDisplay(plys,cm,pre,i);
    				plys.get(j).tabularDisplay2(plys,cm,pre,i,j);
    			}
    		if(count==0)
    			System.out.println("No match found");
    		break;
    	
    	case 2:
    		System.out.println("Enter the jersy Number you would like to search");
    		int jersy=handler.intCheck();
    		for(j=0; j<=i; j++)
    			if(jersy==plys.get(j).getJersey_Number())
    			{
    				count++;
    				plys.get(i).tabularDisplay(plys,cm,pre,i);
    				plys.get(j).tabularDisplay2(plys,cm,pre,i,j);
    			}
    		if(count==0)
    			System.out.println("No match found");
    		break;
    	}
    	
    }
    int sort(ArrayList<Player> plys, coachMain cm, President pre, int i)
    {
    	Player ply=new Player();
    	int n=0;
    	System.out.println("Sort in: \n1. Name \n2. Salary ");
    	int choice=handler.exp();
    	switch(choice)
    	{
    	case 1:
    		ArrayList<Player> plyList=new ArrayList<>();
    		for(int j=0; j<=i; j++)
    		{
    			plyList.add(new Player());
   		     plyList.set(j, plys.get(j));
    		}
    	  for(int j=0; j<=i; j++)
    	  {
    		  for(int k=1; k<=i; k++)
    		  {
    			  if((plyList.get(k).getfName().compareToIgnoreCase(plyList.get(k-1).getfName()))<0)
    			  {
    				  ply=plyList.get(k);
    				  plyList.set(k, plyList.get(k-1));
    				  plyList.set(k-1,ply);
    			  }
    		  }
    	  }
    	  if(i==-1)
			{
			System.out.println("No data found");
			break;
			}
		else
		{
		plyList.get(i).tabularDisplay(plys,cm,pre,i);
		for(int j=0; j<=i;j++)
		   plyList.get(j).tabularDisplay2(plys,cm,pre,i,j);
		}
		System.out.println("Enter   1. back \n\t2. main menu");
		n=handler.exp();
    		break;
    	
    	case 2:
    		ArrayList<Player> plyList2=new ArrayList<>();
    		for(int j=0; j<=i; j++)
    		{
    			plyList2.add(new Player());
    		     plyList2.set(j, plys.get(j));
    		}
    		for(int j=0; j<=i; j++)
      	  {
      		  for(int k=1; k<=i; k++)
      		  {
      			  if(plyList2.get(k).getSalary()<plyList2.get(k-1).getSalary())
      			  {
      				  ply=plyList2.get(k);
      				  plyList2.set(k, plyList2.get(k-1));
      				  plyList2.set(k-1,ply);
      			  }
      		  }
      	  }
      	  if(i==-1)
  			{
  			System.out.println("No data found");
  			break;
  			}
  		else
  		{
  		plyList2.get(i).tabularDisplay(plys,cm,pre,i);
  		for(int j=0; j<=i;j++)
  		   plyList2.get(j).tabularDisplay2(plys,cm,pre,i,j);
  		}
  		System.out.println("Enter   1. back \n\t2. main menu");
  		n=handler.exp();
    		break;
    	}
    	return n;
    }
}

//Address class is an aggregation class of father class Player
class Address
{
  ExceptionHandler handler= new ExceptionHandler();
	Scanner sc=new Scanner(System.in);
	//declaration
	private int phoneNo;
	private String currentCity;
	private int houseNo;
	private String email;
	private int poBox;
	
	//set player address
	void setAddress()
	{
		System.out.print("Current City: ");
		currentCity=handler.expStSp();
		System.out.print("Email Address: ");
		email=handler.expEmail();
		System.out.print("Phone Number: ");
		phoneNo=handler.expPhone();
		System.out.print("House Number: ");
		houseNo=handler.intCheck();
		System.out.print("Pobox: ");
		poBox=handler.intCheck();
	}
	void editCity()
	{
		System.out.print("Current City: ");
		currentCity=handler.expStSp();
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
	int getPoBox()
	{
		return poBox;
	}
	void displayAddress()//displaying address of the player
	{
		System.out.println("Phone Number: "+phoneNo);
		System.out.println("Current City: "+currentCity);
		System.out.println("House Number: "+houseNo);
		System.out.println("Email Address: "+email);
		System.out.println("Pobox: "+poBox);
	}
}
class Nationality{//ask for nationality
	  ExceptionHandler handler= new ExceptionHandler();
	private String nation;
	private final String currentNation="Ethiopia";
	private String passport;
	
	Scanner sc= new Scanner(System.in);
	void setNationality(ArrayList<Player> plys)
	{
		System.out.print("Nationality: ");
		nation=handler.expStSp();
		check(plys);

	}
	String getNation()
	{
		return nation;
	}
	void displayNation()
	{
		System.out.print("Nationality: "+nation);
	}
	void check(ArrayList<Player> plys)//check for nationality and if the player is foreigner prompt to fill some needed informations
	{
		if(currentNation.compareToIgnoreCase(getNation())!=0)
		{
			System.out.println("\nAs your information indicates you are from foreign country. \n So you should fill some forms");
			forms(plys);
		}
			
	}
	void forms(ArrayList<Player> plys)
	{
		double a=0.1;
		System.out.print("\n-> Passport Number: ");
		passport=sc.nextLine();
		System.out.println("\n-> As your information indicates you are legitimate player and as a foreign player the government has a responsiblity fo your safty, \n-> so you will pay a tax for your safty and other relavant things");

		
	}
}
class MaritualStatus{//insertion and displaying maritual status information of a player
	ExceptionHandler handler= new ExceptionHandler();
	private String maried=null;
	private int child;
	private int childNo=0;
	
	void setMaritualStatus()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("\t\tFamily Informations\n");
		System.out.println("Maried or Not");
		System.out.println("Enter \t1.Maried \n \t2.Not Maried \n");
		int a=handler.exp();
		if(a==1)
			maried="Maried";
		else
			maried="Not Maried";
		getMaried();
		System.out.println("Do you have children?");
		System.out.println("Enter \t1.Yes \n \t2.No \n");
		child=handler.exp();
		
		if(child==1)
		    {
			System.out.println("How many? \n");
			childNo=handler.intCheck();
			getChildNo();
		    }
	}
	String getMaried()
	{
		return maried;
	}
	int getChild()
	{
		return child;
	}
	int getChildNo()
	{
		return childNo;
	}
	void displayMar()
	{
		System.out.println("Maritual Status: "+maried);
		System.out.println("Childern: "+childNo);
	}
	
}
//collect number of cards for each player

class PlayerCard{
Scanner sc=new Scanner(System.in);
private int noOfCardsofR;
private int noOfCardsofY;
private String type;
private final int addCard=1;

//constructor
void setPlayerCard()
{
	System.out.println("\t\t\t\tCard"); 
	System.out.print("Number of red cards: ");
	noOfCardsofR=sc.nextInt();
	System.out.print("Number of yellow cards: ");
	noOfCardsofY=sc.nextInt();
}

// Getter method
int getrCard()
{
	return noOfCardsofR;
}

int getyCard()
{
	return noOfCardsofY;
}

void display()
{
	System.out.println("Number of red cards = "+noOfCardsofR);
	System.out.println("Number of yellow cards = "+noOfCardsofY);
}

}
class PlayerStatics{//class for statics information
	ExceptionHandler handler= new ExceptionHandler();
	private int physical;
	private int mental;
	private int attacking;
	private int speed;
	private int defending;
	private int technical;
	private int totalRate=(physical+mental+attacking+speed+defending+technical)/6;
	
	void setStatics()//insert statistic information
	{
		System.out.println("\n\tStatics");
		System.out.print("Physical: ");
		physical= handler.statCheck();
		System.out.print("Mental: ");
	    mental=handler.statCheck();
		System.out.print("Attacking: ");
		attacking= handler.statCheck();
		System.out.print("Speed: ");
	    speed=handler.statCheck();
		System.out.print("Defending: ");
		defending= handler.statCheck();
		System.out.print("Technical: ");
	    technical=handler.statCheck();
	}
	int getPhysical()
	{
		return physical;
	}
	int getMental()
	{
		return mental;
	}
	int getAttacking()
	{
		return attacking;
	}
	int  getSpeed()
	{
		return speed;
	}
	int getDefending()
	{
		return defending;
	}
	int getTechnical()
	{
		return technical;
	}
	int getTotalRate()
	{
		return totalRate;
	}
	
	void display()//to display statistic information of a player
	{
		if(physical==0)
		{
			System.out.println("The inforamtion is not inserted ");
		}
		else
		{
		System.out.println("Pysical: "+physical);
		System.out.println("Mental: "+mental);
		System.out.println("Attackng: "+attacking);
		System.out.println("Speed: "+speed);
		System.out.println("Defending: "+defending);
		System.out.println("Techincal: "+technical);
		System.out.println("\n->Total rating:"+totalRate);
		}
	}
	
}
