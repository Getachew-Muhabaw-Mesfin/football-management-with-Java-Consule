package FootballManagement;

import java.util.ArrayList;
import java.util.Scanner;
 class Statistics{//class for team statistics
	 Scanner sc=new Scanner(System.in);
	ExceptionHandler handler= new ExceptionHandler();
	 private int numMatches;
	 private int totWins;
	 private int totLoses;
	 private int totEqual;	 
	 private int totGols;
	 private int totPoints;
	 private int rank;	
	 Statistics(){
		 numMatches=12;
		 totWins=1;
		 totLoses=3;
		 totEqual=2;		 
		 totGols=5;	 
		 totPoints=6;
		 rank=9;
	 }
	 public void dispSatatics(){//displays needed team statistics
		 System.out.println();
		 System.out.println();
		 System.out.println("::::::::::::::::::::::::ETHIOPIA BUNNA GENERAL STATISTICS 2019/2020:::::::::::::::::::::::::::::::");
		 System.out.println();
		 System.out.printf("%10s%27s\n" ,"Status","Total");
		 System.out.println();
		 System.out.printf("%10s%20d\n","Number of Matchs",numMatches);
		 System.out.printf("%10s%21d\n","Number of Wins",totWins);
		 System.out.printf("%10s%20d\n","Number of Loses",totLoses);
		 System.out.printf("%10s%19d\n","Number of Equals",totEqual);
		 System.out.printf("%10s%20d\n","Number of Goals",totGols);
		 System.out.printf("%10s%19d\n","Number of Points",totPoints);
		 System.out.printf("%10s%18d\n","Rank of the clube",rank);
		 System.out.println("\nEnter any key to go back");
	     String any=sc.nextLine();
	     System.out.println("\n");
	 }
	 void updateinfo() {
		 System.out.println("Enter number of matchs:");
		 numMatches=handler.intCheck();
		 System.out.println("Enter number of Wins:");
		 totWins=handler.intCheck();
		 System.out.println("Enter number of Loses:");
		 totLoses=handler.intCheck();
		 System.out.println("Enter number of Equals:");
		 totEqual=handler.intCheck();
		 System.out.println("Enter number of Goals:");
		 totGols=handler.intCheck();
		 System.out.println("Enter number of Points:");
		 totPoints=handler.intCheck();
		 System.out.println("Enter number of Rank:");
		 rank=handler.intCheck();	 
	 }	 
 }
 

public class Team{//class for team information
	 static ArrayList<String> comments= new ArrayList<>();
	 ExceptionHandler handler=new ExceptionHandler();
	 Statistics stat=new Statistics();
	 Scanner sc=new Scanner(System.in);
	 static int s=0;
	 static int r=0;
	 
     private String name;
     private String Abreviation;
     private String nickName;
     private String fondDate;   
     private String country;
     private String city;
     private String league;     
     private String brand; 
     private double cost;
     private double budget;
     private String president;
     private String manager;   
     private String email;
     private String phone;   
     private String website ;
     private int numPlayers;
     private String stadiumName;
     private int stadiumCapacity;    
     private int numMembers;
 
     public void editinfo() {
    	 System.out.println("What infromation do you want to Edit");
    	 System.out.println("\t\t1.Name"+"\n\t\t2.Cost\n\t\t3.Budget\n\t\t4.Number of Fans\n\t\t5.Back\n\t\t6.Main menu");
    	 System.out.print("\n Option->");
    	 int choice=handler.exp6();
    	 switch(choice) {
    	 case 1:
    		 System.out.print("\nClub Name:");
    		 sc.next();
    		 this.name=handler.expSt();
    		 System.out.println("Nick Name:");
    		 this.nickName=handler.expSt();
    		 System.out.println("Abrivation:");
    		 this.Abreviation=handler.expSt();
    		 break;
    	 case 2:
    		 System.out.println("Cost:");
    		 this.cost=handler. floatCheck();
    		 break;
    	 case 3:
    		 System.out.println("Club Budget:");
    		 this.budget=handler. floatCheck();
    		 break;
    	 case 4:
    		 System.out.println("Enter Number of supporters:");
    		 this.numMembers=handler.intCheck();
    		 break;
    	 case 5:
    		 preTeamMenu();
    		break;
    	 case 6:
             break;
    	 }   	 
     }    
 public Team(){      	 
        name="Ethiopia Bunna FC";
        Abreviation="Buna";
        nickName="YeNigat Kokeb";
        fondDate="1976";        
        country="Ethiopia";
        city="Addis Ababa";  
        league="Ethiopian Premir League ";
        brand=" Ethopian Coffe Exporters ";         
        cost=45000000.00;   
        budget=40000000.00;
        president="Meto Aleka Fekade Mamo ";
        manager="Kasaye Arega ";        
        email="info@ethiopiabunna.org";         
        phone="0115453633";      
        website="www.bunaFC.com";
        numPlayers=25;
        numMembers=6000000; 
        stadiumName="Addis Ababa Stadium";
        stadiumCapacity=35000;
     }
 public void teamInfo() {
	    System.out.println();
	    System.out.println("==============================ETHIOPIA BUNNA CLUB INFORMATION======================");	    
    	System.out.printf("\n%8s%36s","Team Name" ,name);   	
    	System.out.printf("\n%10s%17s","Team Abrevation",Abreviation);    	
    	System.out.printf("\n%10s%27s","Team Nick Name",nickName);    	
    	System.out.printf("\n%8s%24s","Found on",fondDate);        	
    	System.out.printf("\n%10s%24s","Team Country",country);   	
    	System.out.printf("\n%8s%30s","Team City",city);   	
    	System.out.printf("\n%10s%41s","Team League",league);    	
    	System.out.printf("\n%10s%43s","Team Brand",brand);    	
    	System.out.printf("\n%10s%23f","Estimated Cost (US$)",cost);
    	System.out.printf("\n%10s%32f","Team Budget",budget);
    	System.out.printf("\n%10s%37s","Team President",president);
    	System.out.printf("\n%10s%29s","Team Manager",manager);   	
    	System.out.printf("\n%10s%40s","Team Email",email);
    	System.out.printf("\n%10s%28s","Team Phone",phone);
    	System.out.printf("\n%10s%30s","Team Website",website);
    	System.out.printf("\n%10s%8d","Team Number Of Players",numPlayers); 
    	System.out.printf("\n%10s%19d","Team Fan Members",numMembers);  
    	System.out.printf("\n%10s%32s","Name of Stadium",stadiumName);  
    	System.out.printf("\n%10s%14d","Capacity of Stadium",stadiumCapacity);
    	System.out.println("\nEnter any key to go back");
    	String any=sc.nextLine();
    	System.out.println("\n");
    	
 }
  

 public void teamMenu() {
	 System.out.println("\t\t\tWelcome to Team Information\n");
	 System.out.println("\t\t1.Team Information");
	 System.out.println("\t\t2.Statistics");
	 System.out.println("\t\t3.Comment");
	 System.out.println("\t\t4.Back");
	 System.out.println("\n Option->");
	 int choice=handler.exp4();
	 switch(choice) {
	 case 1:
		 teamInfo();
		 teamMenu();		
		 break;
		 
	 case 2:
		 stat.dispSatatics();
		 teamMenu();
		 break;

	 case 3:
		 System.out.println("Write your comment here!");
		 comments.add(sc.nextLine());
		 System.out.println("Thanks for your opinion");
		 teamMenu();
		 break;
	 
	 case 4:
		 return;
	 }
 } 
 public void preTeamMenu(){
	 System.out.println("\t\t\tWelcome to Team Information\n");
	 System.out.println("\t\t1.Display Team Information");
	 System.out.println("\t\t2.Edit ");
	 System.out.println("\t\t3.Statistics");
     System.out.println("\t\t4.View comments");
	 System.out.println("\t\t5.Main Manu");
	 int choice=handler.exp6();
	 switch(choice) {
	 case 1:
		 teamInfo();
		 preTeamMenu();
		 break;

	 case 2:
		 editinfo();
		 System.out.println("Enter any key To go back to Main Menu");
		 String back=handler.expSt();
		 preTeamMenu();
		 break;
	
	 case 3:
		 stat.dispSatatics();
		 preTeamMenu();
		 break;
	 case 4:
		 for(String j:comments)
			 System.out.println("-> "+j);
		 System.out.println("Enter any key to go back");
		 String key =sc.nextLine();
		 preTeamMenu();
		 break;
	 case 5:
		return;
	 } 	
  }
}
