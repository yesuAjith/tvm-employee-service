package com.tvmemployee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tvmemployee.entity.EmployeeLoginInfo;
import com.tvmemployee.entity.EmployeeLogofInfo;
import com.tvmemployee.entity.TvmEmployee;
import com.tvmemployee.repositoty.LogoutRepository;
import com.tvmemployee.repositoty.TimeSheetRepository;

@Service
public class TimeSheetService {

	@Autowired 
	private TimeSheetRepository timeSheet;
	
	@Autowired
	private LogoutRepository logoutRepo;
	
	public EmployeeLoginInfo logEmployeeLogin(EmployeeLoginInfo emp) {
		
        return timeSheet.save(emp);
    }

   public EmployeeLogofInfo logEmployeeLogout(EmployeeLogofInfo empl) {
	 
       return logoutRepo.save(empl);
   }
   
   public List<EmployeeLoginInfo> getEmpLogin() {
	   return timeSheet.findAll();
   }

   public List<EmployeeLogofInfo> getEmpLogout() {
	   return logoutRepo.findAll();
   }
   
   public List<EmployeeLoginInfo> getByLogOut(Integer id){
	   return timeSheet.getLoginInfoID(id);
   }
//   public List<EmployeeLoginInfo>getByDate(Date date){
//	   return timeSheet.getByDateWithPre(date);
//   }
   
   public List<Object[]>getByLogoutId(Integer empid){
	   return logoutRepo.getByempIdLogout(empid);
   }
   
   public Optional<EmployeeLogofInfo>getByIdWithLogout(Integer id){
	   return logoutRepo.findById(id);
   }
   
   public List<Object[]>getByloginUser(Integer id){
	   return timeSheet.findLoginAndLogoutInfoByEmployeeId(id);
   }
   
}
