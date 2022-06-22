package com.studentmanagement.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentmanagement.studentmanagement.entity.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration,Long>{

	public Registration findByUsername(String userName);
}
