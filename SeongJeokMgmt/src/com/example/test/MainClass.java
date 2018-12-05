package com.example.test;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.example.dao.StudentDAO;
import com.example.vo.Student;

public class MainClass {
	private Scanner scan;
	public MainClass() {
		this.scan = new Scanner(System.in);
	}
	void insert(StudentDAO studentDAO){
		System.out.println("학번 : "); String hakbun = scan.next();
		System.out.println("이름 : "); String name = scan.next();
		System.out.println("국어 : "); int kor = scan.nextInt();
		System.out.println("영어 : "); int eng = scan.nextInt();
		System.out.println("수학 : "); int mat = scan.nextInt();
		System.out.println("전산 : "); int edp = scan.nextInt();
		Student s = new Student();
		s.setHakbun(hakbun); s.setName(name); s.setKor(kor);
		s.setEng(eng); s.setMat(mat); s.setEdp(edp);
		this.calc(s);
		int row = studentDAO.create(s);
		System.out.println(row ==1? "Insert Success" : "Insert Failure");
	}
	void update(StudentDAO studentDAO){
		System.out.println("수정할 학생의 학번 : "); String hakbun = scan.next();
		System.out.println("수정할 국어 : "); int kor = scan.nextInt();
		System.out.println("수정할 영어 : "); int eng = scan.nextInt();
		System.out.println("수정할 수학 : "); int mat = scan.nextInt();
		System.out.println("수정할 전산 : "); int edp = scan.nextInt();
		Student s = new Student();
		s.setHakbun(hakbun); s.setKor(kor);
		s.setEng(eng); s.setMat(mat); s.setEdp(edp);
		this.calc(s);
		int row = studentDAO.update(s);
		System.out.println(row ==1? "Insert Success" : "Insert Failure");
	}
	void delete(StudentDAO studentDAO){
		System.out.println("삭제할 학생의 학번 : "); String hakbun = this.scan.next();
		int row = studentDAO.delete(hakbun);
		System.out.println(row ==1? "Insert Success" : "Insert Failure");
	}
	void selectAll(StudentDAO studentDAO) {
		for(Student student : studentDAO.readAll()) {
			System.out.println(student);
		}
	}
	void selectSingle(StudentDAO studentDAO) {
		System.out.println("검색할 학생의 학번 : ");
		String hakbun = this.scan.next();
		Student student = studentDAO.read(hakbun);
		System.out.println(student);
	}
	
	public static void main(String[] args) {
		MainClass main = new MainClass();
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:beans.xml");
		ctx.refresh();//bean 올라감
		
		StudentDAO studentDAO = ctx.getBean("studentDAO",StudentDAO.class);
		//main.insert(studentDAO);
		//main.update(studentDAO);
		//main.delete(studentDAO);
		//main.selectAll(studentDAO);
		main.selectSingle(studentDAO);
		ctx.close();//bean 사라짐
	}
	
	private void calc(Student s) {
		int sum = s.getKor() + s.getEdp() + s.getEng() + s.getMat();
		double avg = sum/4.0;
		char grade = (avg <= 100 && avg >= 90) ? 'A' :
									(avg <= 90 && avg >= 80) ? 'B' :
										(avg <= 80 && avg >= 70) ? 'C' :
											(avg <= 70 && avg >= 60) ? 'D' : 'F';
		
		s.setSum(sum); s.setAvg(avg); s.setGrade(grade);
	}
}

//bean scope 4가지
//싱글톤 프로토타입 리퀘스트 세션