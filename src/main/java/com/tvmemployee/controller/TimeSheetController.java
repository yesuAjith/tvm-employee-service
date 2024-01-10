package com.tvmemployee.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tvmemployee.entity.EmployeeLoginInfo;
import com.tvmemployee.entity.EmployeeLogofInfo;
import com.tvmemployee.entity.TvmEmployee;
import com.tvmemployee.service.TimeSheetService;

@RestController
public class TimeSheetController {

	@Autowired 
	private TimeSheetService timesheetService;
	@PostMapping("/login")
    public ResponseEntity<String> logEmployeeLogin(@RequestBody EmployeeLoginInfo emplo) {
        EmployeeLoginInfo logged = timesheetService.logEmployeeLogin(emplo);
        if (logged != null) {
            return ResponseEntity.ok("Employee login logged successfully.");
        } else {
            return ResponseEntity.badRequest().body("Failed to log employee login.");
        }
        
    }
	
	@PostMapping("/logout")
    public ResponseEntity<String> logEmployeeLogout(@RequestBody EmployeeLogofInfo empLog) {
		EmployeeLogofInfo loggedOut = timesheetService.logEmployeeLogout(empLog);
        if (loggedOut != null) {
            return ResponseEntity.ok("Employee logout logged successfully.");
        } else {
            return ResponseEntity.badRequest().body("Failed to log employee logout.");
        }
    }
	
	@GetMapping("/getemplogin")
	public List<EmployeeLoginInfo> getLongin(EmployeeLoginInfo emp) {
		return timesheetService.getEmpLogin();
	}
	
	@GetMapping("/getemplogout")
	public List<EmployeeLogofInfo> getLongout(EmployeeLogofInfo emp) {
		return timesheetService.getEmpLogout();
	}
	
	@GetMapping("/getBylogoutInfo/{id}")
	public List<EmployeeLoginInfo> getByLogInfo(@PathVariable("id") Integer id){
		return timesheetService.getByLogOut(id);
	}
////	
//	@GetMapping("/getempdate/{date}")
//	public List<EmployeeLoginInfo> getByLogDate(@PathVariable("date") Date date) {
//		return timesheetService.getByDate(date);
//	}
	
	@GetMapping("/getempIdLogout/{id}")
	public List<Object[]>getLogoutWithEmployee(@PathVariable("id") Integer id){
		return timesheetService.getByLogoutId(id);
	}
	
	@GetMapping("/getIdWithLogout/{id}")
	public Optional<EmployeeLogofInfo>getById(@PathVariable("id") Integer id){
		return timesheetService.getByIdWithLogout(id);
	}
	
	@GetMapping("/getEmpId/{id}")
	public List<Map<String, Object>> getByLoginInfo(@PathVariable("id") Integer id){
		return timesheetService.getByloginUser(id);
	}
	   
	
	
}
