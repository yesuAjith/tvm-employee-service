package com.tvmemployee.repositoty;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tvmemployee.entity.EmployeeLoginInfo;


@Repository
public interface TimeSheetRepository extends JpaRepository<EmployeeLoginInfo, Integer> {

//	@Query(value = "SELECT el.id, el.date, el.time " +
//	        "FROM employee_login_info el WHERE el.emp_id = :id", nativeQuery = true)
//	public List<EmployeeLoginInfo> getbyoutData(Integer id);
//	
//	@Query(value="SELECT el.id,el.date,el.time,elo.id,elo.date,elo.time FROM employee_login_info el LEFT JOIN employee_logof_info elo ON el.id=elo.id WHERE el.date=:date", nativeQuery = true)
//	public List<EmployeeLoginInfo> getByDateWithPre(Date date);
	

	@Query(value = "SELECT el.loginid,el.date,el.time,"
			+ "el.emp_id,elo.logoutid,elo.logoutdate,elo.logouttime,"
			+ "elo.employee_id FROM employee_login_info el "
			+ "LEFT JOIN employee_logof_info elo ON el.emp_id=elo.employee_id "
			+ "WHERE el.loginid=:loginid", nativeQuery = true)
	public List<EmployeeLoginInfo>getLoginInfoID(Integer loginid);
	
}
