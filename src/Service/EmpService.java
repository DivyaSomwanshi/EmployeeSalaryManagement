package Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import Model.Employee;
import Repo.EmpRepo;

public class EmpService {
	Repo.EmpRepo er=new EmpRepo();
	public boolean isaddEmployee(Employee e) {
		return er.isaddEmployee(e);
	}
	public ArrayList getEmployee() {
		return er.getEmployee();
	}
	public void isaddmap(HashMap<String ,Integer> m, Employee e) {
		er.isaddmap(m, e);
	}
	public HashMap<String,Integer> getmap(Employee e){
		return er.getmap(e);
	}
	public HashMap calculatesal(Employee e) {
		if(er.getmap(e).size()==0)
		{
			System.out.println("no data found");
		}
		else
		{
		HashMap<String,Integer>salarymap=new HashMap<>();
		salarymap.putAll(er.getmap(e));
		for(Entry<String, Integer> entry:salarymap.entrySet())
		{
			String month=entry.getKey();
			Integer days=entry.getValue();
			Integer sal=days*(e.getPerday_salarly());
			salarymap.put(month, sal);
		}
		   e.getSaleryMap().putAll(salarymap);
		}
		return e.getSaleryMap();
	}
}

