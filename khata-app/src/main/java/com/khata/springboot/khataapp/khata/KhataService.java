package com.khata.springboot.khataapp.khata;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class KhataService {
	private static List<Khata> khata= new ArrayList<>();
	private static int khataCount=0;
	static {
		khata.add(new Khata(++khataCount, "Shibhudhala1"));
		khata.add(new Khata(++khataCount, "Shibhudhala2"));
		khata.add(new Khata(++khataCount, "Shibhudhala3"));
	}
	public List<Khata> findByUsername(){
		return khata;
	}
	public List<Khata> addUser(String name){
		khata.add(new Khata(++khataCount, name));
		return khata;
	}
}
