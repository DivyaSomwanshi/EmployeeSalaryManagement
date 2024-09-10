package Model;
import java.util.HashMap;

public class Employee {
	private int id,perday_salary;
	private String name,email,contact;
	HashMap<String,Integer>attendancemap=new HashMap<>();
	HashMap<String,Integer>salarymap=new HashMap<>();
	public HashMap getSaleryMap()
	{
	return salarymap;
	
	}
	public HashMap getMap() {
		return attendancemap;
	} 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPerday_salarly() {
		return perday_salary;
	}
	public void setPerday_salarly(int perday_salary) {
		this.perday_salary = perday_salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Employee(int id, int perday_salary, String name, String email, String contact) {
		super();
		this.id = id;
		this.perday_salary = perday_salary;
		this.name = name;
		this.email = email;
		this.contact = contact;
	}
	

}


