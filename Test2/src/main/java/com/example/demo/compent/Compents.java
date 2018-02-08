package com.example.demo.compent;

import java.util.Date;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.dao.CourseRepository;
import com.example.demo.dao.Course_Authors_and_TutorRepository;
import com.example.demo.dao.StudentRepository;
import com.example.demo.dao.Student_Course_EnrolmentRepository;
import com.example.demo.dao.SubjectRepository;
import com.example.demo.entity.Cours;
import com.example.demo.entity.Course_Authors_and_Tutor;
import com.example.demo.entity.Student;
import com.example.demo.entity.Student_Course_Enrolment;
import com.example.demo.entity.Subject;


@Component
public class Compents implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(Compents.class);
	@Autowired
	private StudentRepository studentrepository;
	@Autowired
	private Student_Course_EnrolmentRepository studentcourseenrolmentrepository;
	@Autowired
	private CourseRepository courserepository;
	@Autowired
	private SubjectRepository subjectrepository;
	@Autowired
	private Course_Authors_and_TutorRepository courseauthorsandtutorrepository;
	
	
	//------------------------add, update,delete
	
	
	//--------------------------
	@Transactional
	@Override
	public void run(String... args) throws Exception {
		logger.info("BAT DAU!");
		long millis = System.currentTimeMillis();
        Date date1 = new Date(millis);
        Date date2=new Date(millis);
		Student st1=new Student(date1,date2,"truong","truong","xuan","khong","123456","nguyen");
		studentrepository.save(st1);
		
		Subject sb1=new Subject("mot hai","tin hoc");
		
		//sb1.setSubjectName("tin hoc");
		//sb1.setEg_Database_Design("mot hai");
		subjectrepository.save(sb1);
		////////
		Course_Authors_and_Tutor tacgia=new Course_Authors_and_Tutor("ha noi","","","mot","nguyen","f","hai","xuan","khong","123456","truong");
		
		courseauthorsandtutorrepository.save(tacgia);
		////////////
		Cours course=new Cours();
		course.setSubject(sb1);
		course.setCourseAuthorsAndTutor(tacgia);
		course.setCourseName("tin hoc");
		course.setCourseDescription("hai ");
		course.setOtherDetails("bon");
		courserepository.save(course);
		//xoa theo id
		//subjectrepository.delete(1);
		//them studentcourseenrolment
		Student_Course_Enrolment sce=new Student_Course_Enrolment();
		sce.setCours(course);
		sce.setStudent(st1);
		sce.setDateOfEnrolment(date1);
		sce.setDateOfCompletion(date2);
		sce.setOtherDetails("hai");
		studentcourseenrolmentrepository.save(sce);
		//sua 
		Student st2=new Student(date1,date2,"trang","trang","linh","co","123456","nguyen");
		st2.setStudentId(9);
		studentrepository.save(st2);
		
		
	}
	
}
