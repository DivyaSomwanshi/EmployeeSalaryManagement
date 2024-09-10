package Repo;

import java.util.ArrayList;
import java.util.HashMap;

import Model.Employee;

public class EmpRepo {
	static ArrayList EmployeeData=new ArrayList();
	
	public boolean isaddEmployee(Employee e) {
		return EmployeeData.add(e);
	}
	
	public ArrayList getEmployee() {
		return EmployeeData.size()>0?EmployeeData:null;
	}
	public void isaddmap(HashMap<String ,Integer> m, Employee e) {
	    for(int i=0;i<EmployeeData.size();i++) {
	    	Employee emp=(Employee)EmployeeData.get(i);
	    	if(e.getId()==emp.getId()){
	    		emp.getMap().putAll(m);
	    	}
	    }
	}
	public HashMap<String,Integer> getmap(Employee e){
		return e.getMap();
	}
}

