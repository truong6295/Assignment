package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CourseRepository;
import com.example.demo.entity.Cours;
import com.example.demo.entity.Course_Authors_and_Tutor;
import com.example.demo.entity.Subject;
@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;
	//add 
	public Cours add(String courseDescription,String courseName,String otherDetails,Subject subject,Course_Authors_and_Tutor courseAuthorsAndTutor) {
		Cours course=new Cours(courseDescription, courseName, otherDetails, subject, courseAuthorsAndTutor);
		if(courseRepository.save(course)!=null)
			return course;
		return null;	
	}
	// update
	public boolean update(int id,String courseDescription,String courseName,String otherDetails,Subject subject,Course_Authors_and_Tutor courseAuthorsAndTutor) {
		Cours course=new Cours(courseDescription, courseName, otherDetails, subject, courseAuthorsAndTutor);
		course.setCourseId(id);
		if(courseRepository.save(course)!=null)
			return true;
		return false;	
	}
	// delete
	public boolean delete(int id) {
		if(courseRepository.exists(id)) {
			courseRepository.delete(id);
			return true;
		}
		return false;
	}
}
