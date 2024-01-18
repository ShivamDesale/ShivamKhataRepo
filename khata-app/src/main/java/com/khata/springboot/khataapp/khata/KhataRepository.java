package com.khata.springboot.khataapp.khata;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface KhataRepository extends JpaRepository<Khata, Long>{ // <bean which is managing, wrapper class>
	List<Khata> findByName(String name);
}
