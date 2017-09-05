package service;

import bean.Student;

public interface ServiceDao {
	
	public boolean login();
	public void query();
	public void  queryById(int a);
	public void add(Student s);
	public void change(Student s,int id);
	public void delById(int id);
	public void charge(int a);
}
