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
	
	public List <Object[]> getEmployeeYear(String passoutYear){
		return empRepos.getEmployeeDetailsByYearOfPassout(passoutYear);
	}

//	public List<EmployeeLoginInfo> getByLog(Integer empid){
//		return empRepos.getbyoutData(empid);
//	}
//	
	public List<TvmEmployee>getByEmpLoginInfo(Integer empid){
		return empRepos.getByLoginInfo(empid);
	}
	
	public List<Map<String, Object>> getByNameWithLogin(String empName){
		return empRepos.getByNameLoginDetails(empName);
	}

	public List<Map<String, Object>> getWithDate(Date da){
		return empRepos.getByLoginDetailsWithDate(da);
	}
	
	public TvmEmployee updateInfo(Integer empid, TvmEmployee tvm) {
		
		Optional<TvmEmployee> emp=empRepos.findById(empid);
		TvmEmployee updateEmployee=emp.get();
		updateEmployee.setEmployeefirstname(tvm.getEmployeefirstname());
		updateEmployee.setEmployeelastname(tvm.getEmployeelastname());
		updateEmployee.setEmployeeemail(tvm.getEmployeeemail());
		updateEmployee.setEmployeesalary(tvm.getEmployeesalary());
		updateEmployee.setEmployeephone(tvm.getEmployeephone());
		updateEmployee.setEmployeeEducation(tvm.getEmployeeEducation());
		updateEmployee.setEmployeeAddress(tvm.getEmployeeAddress());
		updateEmployee.setEmployeeasset(tvm.getEmployeeasset());
		return empRepos.save(updateEmployee);
	}
	
	public List<Map<String, Object>> getByEmpIdLoginInfo(Integer id){
		return empRepos.getByLoginDetailsWithEmpId(id);
	}
}
