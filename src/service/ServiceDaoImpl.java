package service;

import bean.Student;
import studentDao.StudentDaoImpl;

public class ServiceDaoImpl {
	StudentDaoImpl s1 = new StudentDaoImpl();
	public boolean login() {
		return s1.login();
	}
	public void query() {
		s1.query();
	}
	public void  queryById(int a) {
		s1.queryById(a);
	}
	public void add(Student s) {
		s1.add(s);
	}
	public void change(Student s,int id) {
		s1.change(s, id);
	}
	public void delById(int id) {
		s1.delById(id);
	}
	public void charge(int a) {
		s1.charge(a);
	}
}
