package bean;

import java.sql.Date;
import java.util.Scanner;

import service.ServiceDaoImpl;

public class Test {

	public static void main(String[] args) {
		System.out.println("~~~~~~~~~��ӭ����ѧ������ϵͳ~~~~~~~~");
		ServiceDaoImpl im = new ServiceDaoImpl();
		System.out.println("���¼");
		if (im.login()) {
			System.out.println("1.��ѯȫ��   2.������ѯ  3.����   4.�޸�   5.ɾ��  6.�˳�    7.��ѯҳ" + "\n" + "��ѡ��");
			while (true) {
				Scanner scan = new Scanner(System.in);
				String str = scan.nextLine();
				switch (str) {
				case "1":
					im.query();
					break;
				case "2":
					System.out.println("������ID");
					String str1 = scan.nextLine();
					im.queryById(Integer.parseInt(str1));
					break;
				case "3":
					System.out.println("����������id");
					String stra = scan.nextLine();
					System.out.println("����������ѧ������");
					String strb = scan.nextLine();
					System.out.println("����������ѧ������");
					String strc = scan.nextLine();
					String[] sx = strc.split("-");
					Date date = new Date(Integer.parseInt(sx[0]) - 1900, Integer.parseInt(sx[1])-1,
							Integer.parseInt(sx[2]));
					Student stu = new Student(Integer.parseInt(stra), strb, date);
					im.add(stu);
					System.out.println("��ӳɹ�");
					break;
				case "4":
					System.out.println("������ԭ��ID");
					String strd = scan.nextLine();
					System.out.println("������ѧ������");
					String stre = scan.nextLine();
					System.out.println("������ѧ������");
					String strf = scan.nextLine();
					System.out.println("������ԭ��ID");
					int index = scan.nextInt();
					String[] sy = strf.split("-");
					Date date1 = new Date(Integer.parseInt(sy[0]) - 1900, Integer.parseInt(sy[1]) - 1,
							Integer.parseInt(sy[2]));
					Student stu1 = new Student(Integer.parseInt(strd), stre, date1);
					im.change(stu1, index);
					System.out.println("�޸ĳɹ�");
					break;
				case "5":
					System.out.println("������ɾ��ѧ����ID");
					int index1 = scan.nextInt();
					im.delById(index1);
					System.out.println("ɾ���ɹ�");
					break;
				case "6":
					if (scan != null) {
						scan.close();
					}
					System.exit(0);
				case"7":
					System.out.println("�������ѯ��ҳ��");
					int x=scan.nextInt();
					im.charge(x);
					break;
				}
			}
		}
	}

}
