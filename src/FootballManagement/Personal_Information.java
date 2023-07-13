// packege

package FootballManagement;

//class imported

import java.util.ArrayList;

import java.util.Scanner;

import java.time.LocalDate;

//abstract superclass
public abstract class Personal_Information {
	
	// object creation from sub classes
	
	ExceptionHandler handler= new ExceptionHandler();
	MaritualStatus mary= new MaritualStatus();
	Scanner sc=new Scanner(System.in);
	
	//member variables of the super class
	
	private String fName;
	private String mName;
	private String lName;
	private String sex;
	private int age;
	private String birth_date;
	private String blood_type;
	private float wight;
	private float hight;
	private int experience;
	private float salary;
	private double saftyTax=0;
	
	//Setter and  at the same time aske the needed information with their validty(call the ExeptionHandler class with handler)
	
	public void setPersonal_Information()
	{
		
		System.out.print("First Name: ");
		
		 fName=handler.expSt();
		 System.out.print("Middle Name: ");
		 mName=handler.expSt();
		 System.out.print("Last Name: ");
		 lName=handler.expSt();
		 System.out.print("Sex(m/f): ");
		 sex=handler.expSex();
		 System.out.print("Blood type(A /B /AB /O): ");
		 blood_type=handler.expBl();
		 System.out.print("Date of Brith: ");
		 birth_date=handler.expDate();
		 System.out.print("Weight: ");
		 wight=handler.floatCheck();
		 System.out.print("Height: ");
		 hight=handler.floatCheck();
		 System.out.print("Salary: ");
		 salary=handler.floatCheck();
		 System.out.print("Experience: ");
		 experience=handler.intCheck();
		 
	}
	
	//edit methods which overwrite the last information
	
	void editName()
	{
		 System.out.print("First Name: ");
		 fName=sc.next();
		 System.out.print("Middle Name: ");
		 mName=sc.next();
		 System.out.print("Last Name: ");
		 lName=sc.next();
	}
	void editSex()
	{
		System.out.print("Sex: ");
		 sex=sc.next();
	}
	void editSalary()
	{
		System.out.print("Salary: ");
		 salary=handler.floatCheck();
	}
	void editExp()
	{
	System.out.print("Experience: ");
	 experience=handler.intCheck();
   }
	void editdob()
	{
	System.out.print("Date of Brith: ");
	 birth_date=sc.next();
	}
	
	//Getters return the values
	
	String getfName()
	{
		return fName;
	}
	String getmName()
	{
		return mName;
	}
	String getlName()
	{
		return lName;
	}
	String getSex()
	{
		return sex;
	}
	int getAge()
	{
		return age;
	}
	String getBirth_date()
	{
		return birth_date;
	}
	String getBlood_type()
	{
		return blood_type;
	}
	float getWight()
	{
		return wight;
	}
	float getHight()
	{
		return hight;
	}
	int getExperience()
	{
		return experience;
	}
	float getSalary()
	{
		return salary;
	}
	
	// member method which calculate the tax based on tax rule
	
	public double calcTax()
	{
		double tax;
		     if(salary>=10000)
		    	 tax=salary*0.35;
		     else if(salary>=5000)
		    	 tax=salary*0.25;
		     else if(salary>=3000)
		    	 tax=salary*0.15;
		     else if(salary>=1500)
		    	 tax=salary*0.05;
		     else
		    	 tax=0;
		     return tax;
	}
	
	//method the calculate net salary 
	public double saftyTax(double saftyTax)
	{
		return salary*saftyTax;
	}
	public double calcNetSalary()
	{
		return salary-calcTax()-saftyTax(saftyTax);
	}
	
	// display the information that inserted before
	
	void display()
    {
    	 System.out.println("Name: "+getfName()+" "+getmName()+" "+getlName());
		 System.out.println("Sex: "+getSex());
		 System.out.println("Date of Brith: "+getBirth_date());
		 System.out.println("Blood type: "+getBlood_type());
		 System.out.println("Weight: "+getWight());
		 System.out.println("Height: "+getHight());
		 System.out.println("Experience: "+getExperience());
		 System.out.println("Salary: "+getSalary());
		 System.out.println("Tax : "+calcTax());
		 System.out.println("Net Salary: "+calcNetSalary());
    }
}



