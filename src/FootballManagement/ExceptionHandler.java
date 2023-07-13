package FootballManagement;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandler {//In this class all methods needed for validation and exception handling are found we only need to call them.
	int choice;
	Scanner sc=new Scanner(System.in);
	int intCheck()//checks if the inserted data is an integer or not
	    {
		try {
			choice=sc.nextInt();
			if(choice<0)
				throw new Exception("");
		    }
		catch(InputMismatchException e)
		{
			sc.next();
			System.err.print("  Invalid entery \n   Please enter an integer: ");
			intCheck();
		}
		catch(Exception e)
		{
			System.err.print("  Can not be negative. \n  Enter an Positive integer: ");
			intCheck();
		}
		return choice;
	    }
	
	float floatCheck()//checks if the inserted data is an integer or not
    {
		float sal=0;
	try {
		sal=sc.nextFloat();
		if(sal<0)
			throw new Exception("");
	    }
	catch(InputMismatchException e)
	{
		sc.next();
		System.err.print("  Enter a Number: ");
		floatCheck();
	}
	catch(Exception e)
	{
		System.err.print("  Can not be negative. \n  Enter an Positive Number: ");
		floatCheck();
	}
	
	return sal;
    }

	int jerseyCheck(ArrayList<Player> plys,int i)//checks if the inserted jersey number is unique or not 
	{
		int jersey=intCheck();
		try
		{
			for(int j=0; j<i; j++)
				if(jersey==plys.get(j).getJersey_Number())
					throw new Exception("You insereted duplicate jersey number \nPlease insert other jersey number: ");
		}
		catch(Exception e)
		{
			System.err.print(e.getMessage());
			jerseyCheck(plys,i);
		}
		return jersey;
	}
	
	int statCheck()//checks if the inserted statistics information is beyond the limit
	{
		int stat=intCheck();
		try
		{
			if(stat>100)
				throw new Exception("You inserted beyond the limit");
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		return stat;
	}
	
	int exp()//check if the inserted number is only 1 and 2. Works for all choices with only two.
	{
		choice=intCheck();
		
		try {
			if(choice!=1 && choice!=2)
				throw new Exception("");
		}
		
		catch(Exception e)
		{
			System.err.print("  Choose only 1 and 2: ");
			exp();
		}
		return choice;
	}

	int exp3()//check if the inserted number is only between 1 and 3. Works for all choices with only three.
	{
		choice=intCheck();
		try {
			if(choice<1 || choice>3)
				throw new Exception("");
		}
		catch(Exception e)
		{
			System.err.print("   Choose only between 1 and 3:  ");
			exp3();
		}
		return choice;
	}
	
	int exp4()//check if the inserted number is only between 1 and 4. Works for all choices with four.
	{
		choice=intCheck();
		try {
			if(choice<1 || choice>4)
				throw new Exception("");
		}
		catch(Exception e)
		{
			System.err.print("   Choose only between 1 and 4:  ");
			exp4();
		}
		return choice;
	}
	
	int exp5()//check if the inserted number is only between 1 and 5. Works for all choices with five.
	{
		choice=intCheck();
		try {
			if(choice<1 || choice>5)
				throw new Exception("");
		}
		catch(Exception e)
		{
			System.err.print("  Choose only 1 and 5: ");
			exp5();
		}
		return choice;
	}

	int exp6()//check if the inserted number is only between 1 and 6. Works for all choices with six.
	{
		choice=intCheck();
		try {
			if(choice<1 || choice>6)
				throw new Exception("");
		}
		catch(Exception e)
		{
			System.err.print("   Choose only between 1 and 6:  ");
			exp6();
		}
		return choice;
	}
	
	int exp7()//check if the inserted number is only between 1 and 7. Works for all choices with seven.
	{
		choice=intCheck();
		try {
			if(choice<1 || choice>7)
				throw new Exception("");
		}
		catch(Exception e)
		{
			System.err.print("   Choose only between 1 and 7:  ");
			exp7();
		}
		return choice;
	}
	
	String string;
	
	String expSt()//checks if the inserted data is valid alphabetic character or not. No space is needed.
	{
		try {
			string=sc.nextLine();
			
			char arr[]=new char[string.length()];
			for(int j=0; j<string.length(); j++)
				{
				arr[j]=string.charAt(j);
			    int a=(int)arr[j];
			      if(a==32)
			    	  throw new Exception("   No space needed \n    Please enter again: ");
			      else if((a<65 || a>90)&&(a<97 || a>122))
				      throw new Exception("   invalid alphabetic information \n    Please enter again: ");
		       }
		}
		catch(Exception e)
		   {
			System.err.print(e.getMessage());
			expSt();
		   }
	
		return string;
	}
	String expStSp()//checks if the inserted data is valid alphabetic character or not. and space is allowed
	{
		try {
			string=sc.nextLine();
			
			char arr[]=new char[string.length()];
			for(int j=0; j<string.length(); j++)
				{
				arr[j]=string.charAt(j);
			    int a=(int)arr[j];
			      if((a<65 || a>90)&&(a<97 || a>122)&&(a!=32))
				      throw new Exception("  invalid alphabetic information \n   Please enter again: ");
		       }
		}
		catch(Exception e)
		   {
			System.err.print(e.getMessage());
			expStSp();
		   }
	
		return string;
	}
	String expSex()//checks if the inserted sex is valid.
	{
		
		try
		{
			string=expSt();
			if(string.compareToIgnoreCase("f")!=0 && string.compareToIgnoreCase("m")!=0 && string.compareToIgnoreCase("male")!=0 && string.compareToIgnoreCase("female")!=0)
				throw new Exception("    Please insert a valid sex: ");
		}
		catch(Exception e)
		{
			System.err.print(e.getMessage());
			expSex();
		}
		return string;
	}
	
	String expBl()//checks if the inserted blood type is valid.
	{
		string=expSt(); 
		try
		{
			if(string.compareToIgnoreCase("A")!=0 && string.compareToIgnoreCase("B")!=0 && string.compareToIgnoreCase("AB")!=0 && string.compareToIgnoreCase("O")!=0)
				throw new Exception("Please insert a valid Blood Type: ");
		}
		catch(Exception e)
		{
			System.err.print(e.getMessage());
			expBl();
		}
		return string;
	}
	
	String expPos()//checks if the inserted position is valid.
	{
		string=expStSp(); 
		try
		{
			if(string.compareToIgnoreCase("Goal Keeper")!=0 && string.compareToIgnoreCase("Defence")!=0 && string.compareToIgnoreCase("Mid Filder")!=0 && string.compareToIgnoreCase("Attacker")!=0)
				throw new Exception("Please insert a valid Position: ");
		}
		catch(Exception e)
		{
			System.err.print(e.getMessage());
			expPos();
		}
		return string;
	}
	
	int expPhone()//checks if the inserted phone number is valid.
	{
		int p=intCheck(); 
		try
		{
			if(p>=1000000000 || p<900000000)
				throw new Exception("Please insert a valid Phone number: ");
		}
		catch(Exception e)
		{
			System.err.print(e.getMessage());
			expPhone();
		}
		return p;
	}
	
    String expDate()
    {
    	int count=0, count2=0;
    	String d=sc.nextLine();
    	char arr[]=new char[d.length()];
    	try
    	{
			for(int j=0; j<d.length(); j++)
			{
				arr[j]=d.charAt(j);
			    if(arr[j]=='/')
			    	count++;
			    if(arr[j]=='-')
			    	count2++;
    		}
			if(count!=2 && count2!=2)
				throw new Exception("Insert valid Date: ");
    	}
    	catch(Exception e)
    	{
    		System.err.print(e.getMessage());
    		expDate();
    	}
    	return d;
    }
    
    String expEmail()
    {
    	int count=0, count2=0;
    	String d=sc.nextLine();
    	try
    	{
    		char arr[]=new char[d.length()];
			for(int j=0; j<d.length(); j++)
			{
				arr[j]=d.charAt(j);
			    if(arr[j]=='.')
			    	count++;
			    if(arr[j]=='@')
			    	count2++;
    		}
			if(count!=1 || count2!=1)
				throw new Exception("Insert valid Email address: ");
    	}
    	catch(Exception e)
    	{
    		System.err.print(e.getMessage());
    		expEmail();
    	}
    	return d;
    }


}
