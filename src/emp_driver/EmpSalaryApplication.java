package emp_driver;
import java.util.*;

import Model.Employee;
import Service.EmpService;
public class EmpSalaryApplication {

	public static void main(String[] args) {
		EmpService es=new EmpService();
		ArrayList al=new ArrayList();
		int choice;
		Scanner sc=new Scanner(System.in);
		do { 
			System.out.println("1.Add Employee and other operations on employee data");
			System.out.println("2.Take Attandance of emplyee");
			System.out.println("3.show attandace of employe by id");
			System.out.println("4.show employee salery by id");
			System.out.println("5.show all employee salery month wise");
			System.out.println("Enter your choice");
			choice=sc.nextInt();
			switch(choice) {
			case 1:{
				int choice1;
				do { 
						System.out.println("1.Add Employee");
						System.out.println("2.view Employee");
						System.out.println("3.Delete employee");
						System.out.println("4.Update employee");
						System.out.println("5.Search employee");
						System.out.println("6.Exit");
						System.out.println("Enter your choice");
						choice1=sc.nextInt();
						switch(choice1) {
						case 1:
						{
							System.out.println("Enter Employee id");
							int id=sc.nextInt();
							sc.nextLine();
							System.out.println("Enter Employee name");
							String name=sc.nextLine();
							System.out.println("Enter Employee Email");
							String email=sc.nextLine();
							System.out.println("Enter Employee contact");
							String contact=sc.nextLine();
							System.out.println("Enter Employee per day salary");
							int perday_salary=sc.nextInt();
							Employee e=new Employee(id,  perday_salary, name, email, contact);
							boolean flag=es.isaddEmployee(e);
							if(flag) {
								System.out.println("Employee add sucessfully!!!!!!!!!!!!!!!");
							}
							else {
								System.out.println("There is some problem to add employee");
							}
							break;
						}
						case 2:
						{
							al=es.getEmployee();
							if(al==null ||al.size()==0 ) {
								System.out.println("there is no employee data present ");
							}
							else {
								System.out.println("******************View All Employee*********************");
								for(Object obj:al) {
									Employee e=(Employee)obj;
									System.out.println("Employee id is: "+e.getId());
									System.out.println("Employee name is: "+e.getName());
									System.out.println("Employee Email is: "+e.getEmail());
									System.out.println("Employee contact is: "+e.getContact());

									System.out.println("Employee per day salary is: "+e.getPerday_salarly());

									System.out.println("___________________________________________________________________________________________");
								}
								
							}
							break;
						}
						case 3:
						{
							al=es.getEmployee();
							if(al==null|| al.size()==0) {
								System.out.println("there is no employee data present ");
							}
							else {
								System.out.println("Enter Employee id to delete employee data:");
								int empid=sc.nextInt();
								boolean flag=false;
								Iterator i=al.iterator();
								while(i.hasNext()) {
									Employee e=(Employee)i.next();
									if(empid==e.getId()) {
										i.remove();
										flag=true;
									}
								}
								if(flag) {
									System.out.println("Employee Deleted Successfully");
								}
								else {
									System.out.println("Employee Not found with this id");
								}
							}
							break;
						}
						
						case 4:
						{
						
							al=es.getEmployee();
							if(al==null|| al.size()==0) {
								System.out.println("there is no employee data present ");
							}
							else {
								System.out.println("Enter Employee id to update employee");
								int empid=sc.nextInt();
								boolean flag=false;
								for(int i=0;i<al.size();i++) {
									Employee e=(Employee)al.get(i);
										if(empid==e.getId()) {
											System.out.println("Enter update Employee id");
											int id=sc.nextInt();
											e.setId(id);
											sc.nextLine();
											System.out.println("Enter update Employee name");
											String name=sc.nextLine();
											e.setName(name);
											System.out.println("Enter update Employee Email");
											String email=sc.nextLine();
											e.setEmail(email);
											System.out.println("Enter update Employee contact");
											String contact=sc.nextLine();
											e.setContact(contact);
											System.out.println("Enter update Employee per day salary");
											int perday_salary=sc.nextInt();
											e.setPerday_salarly(perday_salary);
											flag=true;
										}
								}
								if(flag) {
									System.out.println("Employee updated sucessfully!!!!!!!!!!!");
								}
								else {
									System.out.println("Employee not found which you want to update");
								}
								
							}
							break;
						}
						case 5:
						{
							al=es.getEmployee();
							if(al==null|| al.size()==0) {
								System.out.println("there is no employee data present ");
							}
							else {
								System.out.println("Enter Employee id Which you want to search");
								int empid=sc.nextInt();
								boolean flag=true;
								for(int i=0;i<al.size();i++) {
									Employee e=(Employee)al.get(i);
										if(empid==e.getId()) {
											System.out.println("Employee id is: "+e.getId());
											System.out.println("Employee name is: "+e.getName());
											System.out.println("Employee Email is: "+e.getEmail());
											System.out.println("Employee contact is: "+e.getContact());
											System.out.println("Employee per day salary is: "+e.getPerday_salarly());
											System.out.println("___________________________________________________________________________________________");
											flag=false;
										}
								}
								if(flag) {
									System.out.println("Employee not fonud");
								}
								
							}
							break;
						}
					  }
					}
					while(choice1!=6);
				break;
				}
			    
			case 2:
			{
				al=es.getEmployee();
				if(al==null|| al.size()==0) {
					System.out.println("there is no employee data present ");
				}
				else
				{
					boolean flag=false;
					System.out.println("Enter id of employee: ");
					int empid=sc.nextInt();
					HashMap<String,Integer> hm=new HashMap<>();
					for(int i=0;i<al.size();i++) {
						Employee e=(Employee)al.get(i);
						if(empid==e.getId()) {
							flag=true;
							int choice2;
							do {
							System.out.println("Enter month which you want to take attandance");
							String Month=sc.next();
							System.out.println("Enter present day of month");
							int day=sc.nextInt();
							hm.putIfAbsent(Month, day);
							System.out.println("1.add more months attandance");
							System.out.println("2.stop");
							choice2 =sc.nextInt();
							}
							while(choice2!=2);
							es.isaddmap(hm, e);
						}
						if(flag==true)
							break;
						
					}
					if(flag) {
						System.out.println("add attandance successfuly!!!!!!");
					}
					else {
						System.out.println("Employee not found with this id");
					}
				}
				break;
			}
			case 3:
			{
				al=es.getEmployee();
				if(al==null|| al.size()==0) {
					System.out.println("there is no employee data present ");
				}
				else {
					System.out.println("Enter Employee id to show employee attendance");
					int empid=sc.nextInt();
					HashMap<String,Integer> hm=new HashMap<>();
					boolean flag=false;
					Iterator i=al.iterator();
					while(i.hasNext()) {
						Employee e=(Employee)i.next();
						if(empid==e.getId()) {
							flag=true;
							hm=es.getmap(e);
						    if(hm.size()!=0) {
							System.out.println(hm);
						    }
						    else {
							System.out.println("there no data found");
						      }
						    break;
						}
					}
					if(flag==false)
						System.out.println("no employee with this id found");
			}
				break;
			}
			case 4:
			{
				al=es.getEmployee();
				HashMap<String,Integer> hm=new HashMap<>();
				if(al==null|| al.size()==0) {
					System.out.println("there is no employee data present ");
				}
				else {
					System.out.println("Enter Employee id to show employee salery");
					int empid=sc.nextInt();
					boolean flag=true;
					Iterator i=al.iterator();
					Integer totalsal=0;
					while(i.hasNext()) {
						Employee e=(Employee)i.next();
						if(empid==e.getId())
						{
						  hm=es.calculatesal(e);
						  for(Map.Entry<String, Integer>entry:hm.entrySet())
							{
						      totalsal+=entry.getValue();
							}
						  flag=false;
						}
							if(flag==false)
							{
								System.out.println("employee total salery is-> "+totalsal);
								break;
							}
						}
					if(flag) {
						System.out.println("Employee not found");
					}
			     }
				break;
			}
			case 5:
			{
				al=es.getEmployee();
				HashMap<String,Integer> hm=new HashMap<>();
				if(al==null|| al.size()==0) {
					System.out.println("there is no employee data present ");
				}
				else 
				{
					Iterator i=al.iterator();
					while(i.hasNext()) {
						Employee e=(Employee)i.next();
						System.out.println("employee name-> "+e.getName());
						 hm=e.getSaleryMap();
						  System.out.println(hm);
				}
				}
				break;
			}
			
			case 6:
			{
				al=es.getEmployee();
				HashMap<String,Integer> hm=new HashMap<>();
				int maxsal=0;
				Employee emp=null;
				if(al==null|| al.size()==0) {
					System.out.println("there is no employee data present ");
				}
				else
				{
					Iterator i=al.iterator();
					Integer totalsal=0;
					while(i.hasNext()) {
						Employee e=(Employee)i.next();
						  hm=es.calculatesal(e);
						  for(Map.Entry<String, Integer>entry:hm.entrySet())
							{
						      totalsal+=entry.getValue();
							}
						  if(maxsal<totalsal)
						  {
							  maxsal=totalsal;
							  emp=e;
						  }
					}
					System.out.println("Employee id is: "+emp.getId());
					System.out.println("Employee name is: "+emp.getName());
					System.out.println("Max Salary of Employee is: "+maxsal);
					
				}
				
			}
	
			
			
			
			
			
		}
		}	
		while(true);
		
	}
	

}
