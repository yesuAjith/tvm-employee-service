package com.tvmemployee.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tvmemployee.entity.EmployeeLoginInfo;
import com.tvmemployee.entity.TvmEmployee;
import com.tvmemployee.repositoty.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepos;

	public Optional<TvmEmployee> getEmployeeId(Integer id) {
		// TODO Auto-generated method stub
		return empRepos.findById(id);

	}

	public String deletWithID(Integer id) {

		empRepos.deleteById(id);

		return "Deleted Successfully";
	}

	public List<TvmEmployee> getAllemp(TvmEmployee emp) {

		return empRepos.findAll();
	}

	public TvmEmployee saveEmp(TvmEmployee emp) {
		
		return empRepos.save(emp);
	}

	

	public List<TvmEmployee> getEmpName(String emp) {
		
		return empRepos.getEmployeeByName(emp);
	}
	
	public List<TvmEmployee>getSalary(Long emp){
		return empRepos.getEmployeeBySalary(emp);
	}
	
	public List <TvmEmployee>getStateWithEmp(String state){
		return empRepos.getEmployeeState(state);
	}
	
	public List <TvmEmployee> getEmployeeYear(String passoutYear){
		return empRepos.getEmployeeDetailsByYearOfPassout(passoutYear);
	}

	public TvmEmployee updateEmployeeDetails(Integer id, TvmEmployee emp) {
		
		Optional<TvmEmployee> tvm = empRepos.findById(id);
		if(tvm.isPresent()) {
		TvmEmployee updateEmployee = tvm.get();
		updateEmployee.setEmployeefirstname(emp.getEmployeefirstname());
		updateEmployee.setEmployeelastname(emp.getEmployeelastname());
		updateEmployee.setEmployeephone(emp.getEmployeephone());
		updateEmployee.setEmployeeemail(emp.getEmployeeemail());
		updateEmployee.setEmployeesalary(emp.getEmployeesalary());
		updateEmployee.setEmployeeAddress(emp.getEmployeeAddress());
		updateEmployee.setEmployeeEducation(emp.getEmployeeEducation());
		return empRepos.save(updateEmployee);
		}
		return null;
	}
	
//	public List<EmployeeLoginInfo> getByLog(Integer empid){
//		return empRepos.getbyoutData(empid);
//	}
//	
	public List<TvmEmployee>getByEmpLoginInfo(Integer empid){
		return empRepos.getByLoginInfo(empid);
	}

}
