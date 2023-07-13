package projectMain;

import java.util.ArrayList;

import java.util.Scanner;

//import java.time.LocalDate;

public abstract class Personal_Information {
	Scanner sc=new Scanner(System.in);
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
	private String role;
	
	public void setPersonal_Information()
	{
		
		System.out.print("First Name: ");
		 fName=sc.next();
		 System.out.print("Midle Name: ");
		 mName=sc.next();
		 System.out.print("Last Name: ");
		 lName=sc.next();
		 System.out.print("Sex: ");
		 sex=sc.next();
		 System.out.print("Age: ");
		 age=sc.nextInt();
		 System.out.print("Date of Brith: ");
		 birth_date=sc.next();
		 System.out.print("Blood type: ");
		 blood_type=sc.next();
		 System.out.print("Weight: ");
		 wight=sc.nextFloat();
		 System.out.print("Height: ");
		 hight=sc.nextFloat();
		 System.out.print("Experience: ");
		 experience=sc.nextInt();
		 System.out.print("Salary: ");
		 salary=sc.nextFloat();
		 System.out.print("Role: ");
		 role=sc.next();
		 MaritualStatus mary= new MaritualStatus();
	}
	void editName()
	{
		 System.out.print("First Name: ");
		 fName=sc.next();
		 System.out.print("Midle Name: ");
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
		 salary=sc.nextFloat();
	}
	void editExp()
	{
	System.out.print("Experience: ");
	 experience=sc.nextInt();
   }
	void editdob()
	{
	System.out.print("Date of Brith: ");
	 birth_date=sc.next();
	}
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
	String getRole()
	{
		return role;
	}
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
	public double calcNetSalary()
	{
		return salary-calcTax();
	}
	void display()
    {
    	 System.out.println("Name: "+getfName()+" "+getmName()+" "+getlName());
		 System.out.println("Sex: "+getSex());
		 System.out.println("Age: "+getAge());
		 System.out.println("Date of Brith: "+getBirth_date());
		 System.out.println("Blood type: "+getBlood_type());
		 System.out.println("Weight: "+getWight());
		 System.out.println("Height: "+getHight());
		 System.out.println("Experience: "+getExperience());
		 System.out.println("Salary: "+getSalary());
		 System.out.println("Role: "+getRole());
    }
}

class MaritualStatus{
	President pre=new President();
	private int maried;
	private int child;
	private int childNo;
	
	MaritualStatus()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("\t\tFamily Informations\n");
		System.out.println("Maried or Not");
		System.out.println("Enter \t1.Maried \n \t2.Not Maried \n");
		maried=pre.exp();
		
		System.out.println("Do you have children?");
		System.out.println("Enter \t1.Yes \n \t2.No \n");
		child=pre.exp();
		if(child==1)
		    {
			System.out.println("How many? \n");
			childNo=sc.nextInt();
		    }
	}
	int getMaried()
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
	
}

