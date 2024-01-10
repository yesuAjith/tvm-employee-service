package com.tvmemployee.repositoty;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tvmemployee.entity.EmployeeLogofInfo;

@Repository
public interface LogoutRepository extends JpaRepository<EmployeeLogofInfo, Integer> {

	@Query(value = "SELECT * FROM employee_logof_info WHERE logoutid=:logoutid",nativeQuery = true)
	public List<Object[]>getByempIdLogout(Integer logoutid);
}
