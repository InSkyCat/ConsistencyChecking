package com.calculate;

import java.util.Scanner;
/**
 * @author sunkun
 * 为了测试分数四则运算
 * */
public class TestCal {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 用户输入两分数和运算符
//		Scanner input = new Scanner(System.in);
//		System.out.println("请用户输入第一个分数(格式a/b)");
//		String data1 = input.next();
//		System.out.println("请用户输入要进行运算的运算符(+-*/)");
//		String operation = input.next();
//		System.out.println("请用户输入第二个分数(格式c/d)");
//		String data2 = input.next();
		String data1 = "12.3";
		String data2 ="2";
		String operation ="/";
			
		// 根据用户输入进行具体运算
		Calculator cal = new Calculator();
		System.out.println("运算结果为:");
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