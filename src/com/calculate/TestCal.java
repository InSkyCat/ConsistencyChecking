package com.calculate;

import java.util.Scanner;
/**
 * @author sunkun
 * Ϊ�˲��Է�����������
 * */
public class TestCal {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// �û������������������
//		Scanner input = new Scanner(System.in);
//		System.out.println("���û������һ������(��ʽa/b)");
//		String data1 = input.next();
//		System.out.println("���û�����Ҫ��������������(+-*/)");
//		String operation = input.next();
//		System.out.println("���û�����ڶ�������(��ʽc/d)");
//		String data2 = input.next();
		String data1 = "12.3";
		String data2 ="2";
		String operation ="/";
			
		// �����û�������о�������
		Calculator cal = new Calculator();
		System.out.println("������Ϊ:");
		cal.compute(data1, operation, data2);
		System.out.println("0.207+0.308+0.174+0.3 ="+(0.207+0.308+0.174+0.3) );
		System.out.println("0.103+0.154+0.174+0.2 ="+(0.103+0.154+0.174+0.2) );
		System.out.println("0.621+0.462+0.522+0.4 ="+(0.621+0.462+0.522+0.4) );
		System.out.println("0.069+0.077+0.13+0.1 ="+(0.069+0.077+0.13+0.1) ); 
		System.out.println(Double.valueOf(47)/125);

		System.out.println("0.106*0.23+0.59	*0.648+0.155*0.122  ="+(0.106*0.23+0.59	*0.648+0.155*0.122) ); 
		System.out.println("0.26*0.23+0.334	*0.648+0.069*0.122  ="+(0.26*0.23+0.334	*0.648+0.069*0.122) ); 
		System.out.println("0.634*0.23+0.076*0.648+0.776*0.122  ="+(0.634*0.23+0.076*0.648+0.776*0.122) ); 
		System.out.println("----------------------");
		System.out.println(30+50/(1+0.1)+20/((1+0.1)*(1+0.1))  );
		System.out.println(80/((1+0.1)*(1+0.1)*(1+0.1)) +90/((1+0.1)*(1+0.1)*(1+0.1)*(1+0.1))+100/((1+0.1)*(1+0.1)*(1+0.1)*(1+0.1)*(1+0.1))+110/((1+0.1)*(1+0.1)*(1+0.1)*(1+0.1)*(1+0.1)*(1+0.1))  );
		System.out.println(80+40/(1+0.1) );
		System.out.println(90/((1+0.1)*(1+0.1))+90/((1+0.1)*(1+0.1)*(1+0.1))+90/((1+0.1)*(1+0.1)*(1+0.1)*(1+0.1))+90/((1+0.1)*(1+0.1)*(1+0.1)*(1+0.1)*(1+0.1))   );
		System.out.println(50+50/(1+0.1)+50/((1+0.1)*(1+0.1))  );
		System.out.println(100/((1+0.1)*(1+0.1)*(1+0.1))+120/((1+0.1)*(1+0.1)*(1+0.1)*(1+0.1))+120/((1+0.1)*(1+0.1)*(1+0.1)*(1+0.1)*(1+0.1)) +120/((1+0.1)*(1+0.1)*(1+0.1)*(1+0.1)*(1+0.1)*(1+0.1)));

		
	}
}