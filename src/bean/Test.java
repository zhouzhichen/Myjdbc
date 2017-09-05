package bean;

import java.sql.Date;
import java.util.Scanner;

import service.ServiceDaoImpl;

public class Test {

	public static void main(String[] args) {
		System.out.println("~~~~~~~~~欢迎来到学生管理系统~~~~~~~~");
		ServiceDaoImpl im = new ServiceDaoImpl();
		System.out.println("请登录");
		if (im.login()) {
			System.out.println("1.查询全部   2.单例查询  3.新增   4.修改   5.删除  6.退出    7.查询页" + "\n" + "请选择");
			while (true) {
				Scanner scan = new Scanner(System.in);
				String str = scan.nextLine();
				switch (str) {
				case "1":
					im.query();
					break;
				case "2":
					System.out.println("请输入ID");
					String str1 = scan.nextLine();
					im.queryById(Integer.parseInt(str1));
					break;
				case "3":
					System.out.println("请输入新增id");
					String stra = scan.nextLine();
					System.out.println("请输入新增学生姓名");
					String strb = scan.nextLine();
					System.out.println("请输入新增学生生辰");
					String strc = scan.nextLine();
					String[] sx = strc.split("-");
					Date date = new Date(Integer.parseInt(sx[0]) - 1900, Integer.parseInt(sx[1])-1,
							Integer.parseInt(sx[2]));
					Student stu = new Student(Integer.parseInt(stra), strb, date);
					im.add(stu);
					System.out.println("添加成功");
					break;
				case "4":
					System.out.println("请输入原有ID");
					String strd = scan.nextLine();
					System.out.println("请输入学生姓名");
					String stre = scan.nextLine();
					System.out.println("请输入学生生辰");
					String strf = scan.nextLine();
					System.out.println("请输入原有ID");
					int index = scan.nextInt();
					String[] sy = strf.split("-");
					Date date1 = new Date(Integer.parseInt(sy[0]) - 1900, Integer.parseInt(sy[1]) - 1,
							Integer.parseInt(sy[2]));
					Student stu1 = new Student(Integer.parseInt(strd), stre, date1);
					im.change(stu1, index);
					System.out.println("修改成功");
					break;
				case "5":
					System.out.println("请输入删除学生的ID");
					int index1 = scan.nextInt();
					im.delById(index1);
					System.out.println("删除成功");
					break;
				case "6":
					if (scan != null) {
						scan.close();
					}
					System.exit(0);
				case"7":
					System.out.println("请输入查询的页数");
					int x=scan.nextInt();
					im.charge(x);
					break;
				}
			}
		}
	}

}
