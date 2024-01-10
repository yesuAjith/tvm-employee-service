package com.tvmemployee.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tvmemployee.entity.EmployeeLoginInfo;
import com.tvmemployee.entity.TvmEmployee;
import com.tvmemployee.service.EmployeeService;

@RestController
@RequestMapping("/tvm")
public class EmployeeController {

	@Autowired
	private EmployeeService empservice;

	@GetMapping("getemp/{id}")
	public Optional<TvmEmployee> getById(@PathVariable("id") Integer emp) {
		return empservice.getEmployeeId(emp);
	}

	@DeleteMapping("/del/{id}")
	public String deleteById(@PathVariable("id") Integer id) {
		return empservice.deletWithID(id);
	}

	@GetMapping("/getAll")
	public List<TvmEmployee> getAllEmployee(TvmEmployee emp) {
		return empservice.getAllemp(emp);
	}

	@GetMapping("/getEmployeeName/{employeefirstname}")
	public List<TvmEmployee> getEmployeeName(@PathVariable("employeefirstname") String fname) {
		return empservice.getEmpName(fname);
	}

	@PostMapping("/saveEmployee")
	public TvmEmployee saveEmployee(@RequestBody TvmEmployee emp) {
		
		
		return empservice.saveEmp(emp);
	}

	@GetMapping("/salary/{employeesalary}")
	public List<TvmEmployee> getEmpSalary(@PathVariable("employeesalary") Long empsal) {
		return empservice.getSalary(empsal);

	}

	@GetMapping("/stateby/{state}")
	public List<TvmEmployee> getEmpState(@PathVariable("state") String state) {
		return empservice.getStateWithEmp(state);
	}

	@GetMapping("/passout/{yearofpassout}")
	public List<Object[]> getPassoutYear(@PathVariable("yearofpassout") String pass) {
		return empservice.getEmployeeYear(pass);

	}
	
//	@GetMapping("/getBylogInfo/{id}")
//	public List<EmployeeLoginInfo>getByInfoLogin(@PathVariable("id") Integer id){
//		return empservice.getByLog(id);
//	}
	
	@GetMapping("/getByLogin/{id}")
	public List<TvmEmployee> getByempLog(@PathVariable("id") Integer id){
		return empservice.getByEmpLoginInfo(id);
	}
	
	@GetMapping("/getBynameLogin/{employeefirstname}")
	public List<Map<String, Object>> getEmployeeNameWithInfoLogin(@PathVariable("employeefirstname") String empf){
		return empservice.getByNameWithLogin(empf);
	}
	
	@GetMapping("/getByDateLogin/{date}")
	public List<Map<String, Object>> getByDateLogin(@PathVariable("date")@DateTimeFormat(pattern = "yyyy-MM-dd")  Date loginDate){
		return empservice.getWithDate(loginDate);
	}
	
	@PutMapping("/updateInfo/{id}")
	public TvmEmployee updateTvmEmployee(@PathVariable("id") Integer empid, @RequestBody TvmEmployee tvm) {
		return empservice.updateInfo(empid, tvm);
	}
	
	
	@GetMapping("/getbyLoginEmId/{id}")
	public List<Map<String, Object>>getLoginInfoByEmpId(@PathVariable("id") Integer id){
		return empservice.getByEmpIdLoginInfo(id);
	}
	
	
	

}
