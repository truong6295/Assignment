package com.example.demo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentRepository;
import com.example.demo.entity.Student;
@Service
public class StudentService {
	@Autowired
	private StudentRepository studentrepository;
	//add student
	public Student add(Date dateOfLatestLogon,Date dateOfRegistration,String familyName,String loginName,String middleName,String otherDetails,String password,String personalName) {
		Student student=new Student(dateOfLatestLogon,dateOfRegistration,familyName,loginName,middleName,otherDetails,password,personalName);
		if(studentrepository.save(student) != null)
			return student;
		else
			return null;
	}
	//update student
	public boolean update(int id,Date dateOfLatestLogon,Date dateOfRegistration,String familyName,String loginName,String middleName,String otherDetails,String password,String personalName) {
		Student student=new Student(dateOfLatestLogon,dateOfRegistration,familyName,loginName,middleName,otherDetails,password,personalName);
		student.setStudentId(id);
		if(studentrepository.save(student)!=null)
			return true;
		else
			return false;
	}
	//delete
	public boolean delete(int id) {
		if(studentrepository.exists(id)) {
			studentrepository.delete(id);
			return true;	
		}
		return false;
	}

}
