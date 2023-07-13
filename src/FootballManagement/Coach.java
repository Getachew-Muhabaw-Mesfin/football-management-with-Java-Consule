package FootballManagement;
import java.util.ArrayList;
import java.util.Scanner;
public class Coach {
	ExceptionHandler handler= new ExceptionHandler();
	private String experience;
	private String matchPlace;
	private String opponent;
	private String date;
	private String time;
	private float duration;
	private String compType;
	private String ground;
	private String Address;
	private String Stadium;
	private String tra_name;
	private String comment;
	private String tra_time;
	private String tra_date;
	private String arrDate;
	private int lc_num;
	private String tra_add;
	private float tra_dur;
	private String playerType;
	int ans=0;
   // player pl=null;
	Personal_Information pll =null;
	
	Scanner input=new Scanner(System.in);
	public void setCompType(String compType)
	{
		this.compType=compType;
	}
	public void setMatchPlace(String matchPlace)
	{
		this.matchPlace=matchPlace;
	}
	public void setDuration(float duration)
	{
		this.duration=duration;
	}
	public void setDate (String date)
	{
		this.date=date;
	}
	
	public void setTime(String time)
	{
		this.time=time;
	}
	public void setOpponent(String op)
	{
		opponent=op;
	}
	public void setGround(String gd)
	{
		ground=gd;
	}
	public void setStadium(String st)
	{
		Stadium=st;
	}
	public void setAddress(String ad) {
	    Address=ad;
		
	}
		public String getGround()
	{
		return ground;
	}
	public String getStadium()
	{
		return Stadium;
	}
	public String getAddress()
	{
		return Address;
	}
	public String getCompType() {
		return compType;
	}
	public String getOpponent()
	{
		return opponent;
	}
	public String getDate()
	{
		return date;
	}
	public String getTime()
	{
		return time;
	}
	public double getDuration()
	{
		return duration;
	}
	public String getmatchPlace() {
		return matchPlace;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getArrDate() {
		return arrDate;
	}
	public void setArrDate(String arrDate) {
		this.arrDate = arrDate;
	}
	public int getLc_num() {
		return lc_num;
	}
	public void setLc_num(int lc_num) {
		this.lc_num = lc_num;
	}
	public String getPlayerType() {
		return playerType;
	}
	public void setPlayerType(String playerType) {
		this.playerType = playerType;
	}
	
	public void displayMatch()
	{
		
		System.out.println("hello coach!");
		System.out.println("The following are the upcoming matches of the team");
		System.out.println("\n\t**************************************************************************************************************************************************************************************");
		System.out.format("%20s%20s%20s%20s%20s%20s%20s%20s%20s"," \t|Game place|","|Opponent|","|Date|","|Time|","|Duration|","|Competition|","|Ground|","|Stadium|","|Address|");
		System.out.format("\n%20s%20s%20s%20s%20s%20s%20s%20s%20s",getmatchPlace(),getOpponent(),getDate(),getTime(),getDuration(),getCompType(),getGround(),getStadium(),getAddress());
		System.out.println("\n\t**************************************************************************************************************************************************************************************");
	}
	public void creMatch()
	{	int ct,grwd;
		
		System.out.println("Choose the game place \n 1. Home team 2.Away team");
		int gP=handler.exp();
		if(gP==1)
		{		
			setMatchPlace("Home team");
			
		}
		else if(gP==2)
		{
			setMatchPlace("Away team");
		}
		System.out.print("Enter the opponents name: ");
		setOpponent(input.next());
		System.out.print("Enter the date: ");
		setDate(input.next());
		System.out.print("Enter the time: ");
		setTime(input.next());
		System.out.print("Enter the duration: ");
		setDuration(handler.floatCheck());
		System.out.println("Choose the competition type \n 1.Championship \n 2.Friendly  \n 3.Cup  \n 4.Dam  \n 5.tournament");
		ct=handler.exp5();
		if(ct==1)
		{
			setCompType("Championship");
		}
		else if(ct==2)
		{
			compType="Frinedly";
		}
		else if(ct==3)
		{
			compType="Cup";
		}
		else if(ct==4)
		{
			compType="Dam";
		}
		else if(ct==5)
		{
			compType="tournament";
		}
		System.out.println("Choose the ground type \n1.Grass \n2.Synthetic \n3.Clay \n4.Sand");
		grwd=handler.exp4();
		switch(grwd)
		{
		case 1:
			setGround("Grass");
			break;
		case 2:
			setGround("Synthetic");
			break;
		case 3:
			setGround("Clay");
			break;
		case 4:
			setGround("Sand");
			break;
		}
		System.out.print("Enter the name of the Stadium: ");
		setStadium(handler.expStSp());
		System.out.print("Enter the address of the stadium: ");
		setAddress(handler.expStSp());
			
	}

	public void creTraining() {
		System.out.print("Name: ");
		this.tra_name=handler.expStSp();
		System.out.print("Date: ");
		this.tra_date=input.nextLine();
		System.out.print("Time: ");
		this.tra_time=input.nextLine();	
		System.out.print("Duration: ");
		this.tra_dur=handler.floatCheck();
		System.out.print("Address: ");
		this.tra_add=handler.expStSp();
		System.out.print("Comment: ");
		this.comment=input.nextLine();		
	}
	public void displayTraining()
	{
		System.out.println("hello coach!");
		System.out.println("The following are the upcoming trainings of the team");
		System.out.println("\n\t**********************************************************************************************************************************************************************************");
		System.out.format("%30s%20s%20s%20s%20s%20s","|Name|","|Date|","|Time|","|Duration|","|Address|","|Comment|");
		System.out.format("\n%30s%20s%20s%20s%20s%20s",this.tra_name,this.tra_date,this.tra_time,this.tra_dur,this.tra_add,this.tra_add,this.comment);
		System.out.println("\n\t**********************************************************************************************************************************************************************************");
		
	}
	

}
