package test;

import java.util.*;

public class player {

	static Scanner sc=new Scanner(System.in);
	private String name;
	private String sex;
	private int age;
	private int jersey;
	private float weight;
	private float height;
	static int i=-1;
	void setPlayer()
	{
		 System.out.print("\nName: ");
		 name=sc.next();
		 System.out.print("Sex: ");
		 sex=sc.next();
		 System.out.print("Age: ");
		 age=sc.nextInt();
		 System.out.print("Jersey Number: ");
		 jersey=sc.nextInt();
		 System.out.print("Weight: ");
		 weight=sc.nextFloat();
		 System.out.print("Height: ");
		 height=sc.nextFloat();
	}
	String getName()
	{
		return name;
	}
	String getSex()
	{
		return sex;
	}
	int getAge()
	{
		return age;
	}
	int getJersey()
	{
		return jersey;
	}
	float getWeight()
	{
		return weight;
	}
	float getHeight()
	{
		return height;
	}
	
	public static void main(String[] args) {
		ArrayList<player> ply = new ArrayList<>();
		String key;
		do {
		System.out.println("Welcome to player information center");
		System.out.println("\n\t1. To insert new player information \n\t2. To display the current player information \n\t3. To display all player information \n\t4. to search a player");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			System.out.println("Enter the number of players to insert");
			int n=sc.nextInt();
			for(int j=0; j<n; j++)
			{
			ply.add(new player());
			i++;
			ply.get(i).setPlayer();
			}
			break;
		case 2:
			System.out.println("\nName: "+ply.get(i).getName());
			 System.out.println("Sex: "+ply.get(i).getSex());
			 System.out.println("Age: "+ply.get(i).getAge());
			 System.out.println("Jersey Number: "+ply.get(i).getJersey());
			 System.out.println("Weight: "+ply.get(i).getWeight());
			 System.out.println("Height: "+ply.get(i).getHeight());
			 break;
		case 3:
			System.out.format("%10s%20s%15s%10s%15s%10s\n","|Name|","|Sex|","|Age|","|Jerser Number|","|Wight|","|Hight|");
			for(int j=0; j<=i; j++)
			{
				System.out.format("\n%-20s%-15s%-15s%-13s%-15s%-15s\n",ply.get(j).getName(),ply.get(i).getSex(),ply.get(i).getAge(),ply.get(i).getJersey(),ply.get(i).getWeight(),ply.get(i).getHeight());
			}
		case 4:
		  {
		    	String name;
		    	int count=0;
		    	System.out.println("\n\tIn which information do you want to find");
		    	System.out.println("\t1.Name \n\t2.Jersy Number \n->");
		    	int choice1=sc.nextInt();
		    	switch(choice1)
		    	{
		    	case 1: 
		    	    System.out.println("Enter the name you would like to find");
		    	    name=sc.next();
		    	    int j;
		    		for(j=0; j<=i; j++)
		    			if(name.compareToIgnoreCase(ply.get(j).getName())==0)
		    			{
		    				count++;
		    				System.out.println("\nName: "+ply.get(j).getName());
		    				 System.out.println("Sex: "+ply.get(j).getSex());
		    				 System.out.println("Age: "+ply.get(j).getAge());
		    				 System.out.println("Jersey Number: "+ply.get(j).getJersey());
		    				 System.out.println("Weight: "+ply.get(j).getWeight());
		    				 System.out.println("Height: "+ply.get(j).getHeight());
		    			}
		    		if(count==0)
		    			System.out.println("No match found");
		    		break;
		    	
		    	case 2:
		    		System.out.println("Enter the jersy Number you would like to search");
		    		int jersy=sc.nextInt();
		    		for(j=0; j<=i; j++)
		    			if(jersy==ply.get(j).getJersey())
		    			{
		    				count++;
		    				System.out.println("\nName: "+ply.get(i).getName());
		    				 System.out.println("Sex: "+ply.get(i).getSex());
		    				 System.out.println("Age: "+ply.get(i).getAge());
		    				 System.out.println("Jersey Number: "+ply.get(i).getJersey());
		    				 System.out.println("Weight: "+ply.get(i).getWeight());
		    				 System.out.println("Height: "+ply.get(i).getHeight());
		    			}
		    		if(count==0)
		    			System.out.println("No match found");
		    		break;
		    	}
		    	break;
		  }
		}
		System.out.println("enter 0 to terminate other key to use the program again");
		key=sc.next();
		}while((key.compareTo("0"))!=0);
		
		
	}

}