
package com.longjw.demo.dao;

import java.util.List;


import com.longjw.demo.bean.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDao extends JpaRepository<Users, Integer> {


	@Query(value = "select u from Users u where u.userName=?1")
	List<Users> findByUserName(String userName);


	List<Users> findByUserNameAndUserIp(String string, String string2);


	Page<Users> findByUserName(String userName, Pageable pageable);

}
