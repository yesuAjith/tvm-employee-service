package com.tvmemployee.repositoty;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tvmemployee.entity.EmployeeLoginInfo;
import com.tvmemployee.entity.TvmEmployee;

public interface EmployeeRepository extends JpaRepository<TvmEmployee, Integer>{
	
	@Query(value="SELECT * FROM tvm_employee n WHERE n.employeefirstname=:employeefirstname",nativeQuery = true)
	public List <TvmEmployee> getEmployeeByName(String employeefirstname);
	
	@Query(value="SELECT * from tvm_employee n WHERE n.employeesalary>:employeesalary", nativeQuery = true)
	public List<TvmEmployee>getEmployeeBySalary(Long employeesalary );
	
	@Query(value="SELECT n.employeeid, n.employeefirstname, n.employeelastname, "
	        + "n.employeeemail, n.employeesalary, n.employeephone, b.addressid, "
	        + "b.street, b.city, b.state, c.qualificationid, c.employeequalification, "
	        + "c.yearofpassout, c.percentage, c.university FROM tvm_employee n "
	        + "LEFT JOIN employee_address b ON n.employeeid = b.employeeid "
	        + "LEFT JOIN employee_education c ON n.employeeid = c.employeeid "
	        + "WHERE b.state = :state", nativeQuery = true)
     public List<TvmEmployee>getEmployeeState(String state);
	
	@Query(value = "SELECT n.employeeid, n.employeefirstname, n.employeelastname, "
	        + "n.employeeemail, n.employeesalary, n.employeephone, c.qualificationid, "
	        + "c.employeequalification, c.yearofpassout, c.percentage, c.university "
	        + "FROM tvm_employee n LEFT JOIN employee_education c ON "
	        + "n.employeeid = c.employeeid WHERE c.yearofpassout = :yearofpassout", nativeQuery = true)
	public List<Object[]> getEmployeeDetailsByYearOfPassout(String yearofpassout);
	
//	@Query(value = "SELECT el.id, el.date, el.time, elo.id, elo.date, elo.time"
//			+ "el.emp_id,elo.emp_id " +
//	        "FROM employee_login_info el " +
//	        "LEFT JOIN employee_logof_info elo ON el.id = elo.id " +
//	        "WHERE el.id = :id", nativeQuery = true)
//	public List<EmployeeLoginInfo> getbyoutData(Integer emp_id);

	@Query(value = "SELECT te.employeeid, te.employeesalary, te.employeeemail, te.employeephone, te.employeefirstname, te.employeelastname, " +
	        "el.loginid, el.date, el.time, elo.logoutid, elo.logoutdate, elo.logouttime " +
	        "FROM tvm_employee te " +
	        "LEFT JOIN employee_login_info el ON te.employeeid = el.emp_id " +
	        "LEFT JOIN employee_logof_info elo ON te.employeeid = elo.employee_id " +
	        "WHERE el.loginid =:loginid", nativeQuery = true)
	public List<TvmEmployee>getByLoginInfo(Integer loginid);
	
	@Query(value="SELECT te.employeeid,te.employeefirstname,te.employeelastname,"
			+ "te.employeesalary,te.employeeemail,te.employeephone,el.loginid,el.date,"
			+ "el.time,elo.logoutid,elo.logoutdate,elo.logouttime FROM tvm_employee te"
			+ " LEFT JOIN employee_login_info el ON te.employeeid=el.emp_id "
			+ "LEFT JOIN employee_logof_info elo ON te.employeeid=elo.employee_id "
			+ "WHERE te.employeefirstname=:employeefirstname", nativeQuery = true)
	public List<Map<String, Object>> getByNameLoginDetails(String employeefirstname);
	
	@Query(value="SELECT te.employee id,te.employeefirstname,te.employeelastname,"
			+ "te.employeesalary,te.employeeemail,te.employeephone,el.loginid,el.date,"
			+ "el.time,elo.logoutid,elo.logoutdate,elo.logouttime FROM tvm_employee te"
			+ " LEFT JOIN employee_login_info el ON te.employeeid=el.emp_id "
			+ "LEFT JOIN employee_logof_info elo ON te.employeeid=elo.employee_id "
			+ "WHERE el.date=:date", nativeQuery = true)
	public List<Map<String, Object>>getByLoginDetailsWithDate(Date date);
	
	@Query(value="SELECT te.employeeid,te.employeefirstname,te.employeelastname,"
			+ "te.employeesalary,te.employeeemail,te.employeephone,el.loginid,el.date,"
			+ "el.time,elo.logoutid,elo.logoutdate,elo.logouttime FROM tvm_employee te"
			+ " LEFT JOIN employee_login_info el ON te.employeeid=el.emp_id "
			+ "LEFT JOIN employee_logof_info elo ON te.employeeid=elo.employee_id "
			+ "WHERE te.employeeid=:employeeid", nativeQuery = true)
	public List<Map<String, Object>> getByLoginDetailsWithEmpId(Integer employeeid);
	
}
 