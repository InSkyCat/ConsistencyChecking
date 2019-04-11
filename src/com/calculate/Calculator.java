package com.calculate;

import java.util.StringTokenizer;

/**
 * @author sunkun 分数四则运算
 */
public class Calculator {
	// 是否打印 子项计算过程
	public static boolean subFlag = false;
	int numerator; // 分子
	int denominator; // 分母

	Calculator() {
	}

	Calculator(int a, int b) {
		if (a == 0) {
			numerator = 0;
			denominator = 1;
		} else {
			setNumeratorAndDenominator(a, b);
		}
	}

	void setNumeratorAndDenominator(int a, int b) { // 设置分子和分母
		int c = f(Math.abs(a), Math.abs(b)); // 计算最大公约数
		numerator = a / c;
		denominator = b / c;
		if (numerator < 0 && denominator < 0) {
			numerator = -numerator;
			denominator = -denominator;
		}
	}

	int getNumerator() {
		return numerator;
	}

	int getDenominator() {
		return denominator;
	}

	int f(int a, int b) { // 求a和b的最大公约数
		if (a < b) {
			int c = a;
			a = b;
			b = c;
		}
		int r = a % b;
		while (r != 0) {
			a = b;
			b = r;
			;
			r = a % b;
		}
		return b;
	}

	Calculator add(Calculator r) { // 加法运算
		int a = r.getNumerator();
		int b = r.getDenominator();
		int newNumerator = numerator * b + denominator * a;
		int newDenominator = denominator * b;
		Calculator result = new Calculator(newNumerator, newDenominator);
		return result;
	}

	Calculator sub(Calculator r) { // 减法运算
		int a = r.getNumerator();
		int b = r.getDenominator();
		int newNumerator = numerator * b - denominator * a;
		int newDenominator = denominator * b;
		Calculator result = new Calculator(newNumerator, newDenominator);
		return result;
	}

	Calculator muti(Calculator r) { // 乘法运算
		int a = r.getNumerator();
		int b = r.getDenominator();
		int newNumerator = numerator * a;
		int newDenominator = denominator * b;
		Calculator result = new Calculator(newNumerator, newDenominator);
		return result;
	}

	Calculator div(Calculator r) { // 除法运算
		int a = r.getNumerator();
		int b = r.getDenominator();
		int newNumerator = numerator * b;
		int newDenominator = denominator * a;
		Calculator result = new Calculator(newNumerator, newDenominator);
		return result;
	}

	// 封装了具体运算，主要为对输入进行转换，对输出封装
	public static String compute(String data1, String operation, String data2,int decLen){ 
		String dString=compute(  data1,   operation,   data2,  "double");
		decLen++;
		return String.valueOf((double) Math.round(Double.valueOf(dString)*Integer.valueOf(StringUtils.padLeft("1", decLen, '0'))) /
				Integer.valueOf(StringUtils.padLeft("1", decLen, '0')));
	}
		// 封装了具体运算，主要为对输入进行转换，对输出封装
		public static String compute(String data1, String operation, String data2,String ftype){
		String result=compute(  data1,   operation,   data2);
		if(ftype=="double")
		{
			if(result.contains("/")){  
				StringTokenizer fenxi = new StringTokenizer(result, "/");
				int data1_1 = Integer.parseInt(fenxi.nextToken());
				int data1_2 = 1;
				if (fenxi.hasMoreTokens())
					data1_2 = Integer.parseInt(fenxi.nextToken());
				return String.valueOf(Double.valueOf(data1_1)/data1_2);
			}
		}
		return result;
	}
	
	// 封装了具体运算，主要为对输入进行转换，对输出封装
	public static String compute(String data1, String operation, String data2) {
		int data1_1 = 0;
		int data1_2 = 1;

		if (data1.contains(".")) {
			StringTokenizer fenxi = new StringTokenizer(data1, ".");
			String tempHeader = fenxi.nextToken();
			String secondr=fenxi.nextToken();
			data1_1 = Integer.parseInt(secondr );
			int padLen = String.valueOf(secondr).length() + 1;
			data1_1 = Integer.parseInt(tempHeader + StringUtils.padLeft("", padLen - 1, '0')) + data1_1;
			data1_2 = Integer.parseInt(StringUtils.padLeft("1", padLen, '0'));
		} else {
			StringTokenizer fenxi = new StringTokenizer(data1, "/");
			data1_1 = Integer.parseInt(fenxi.nextToken());
			data1_2 = 1;
			if (fenxi.hasMoreTokens())
				data1_2 = Integer.parseInt(fenxi.nextToken());
		}

		int data2_1 = 0;
		int data2_2 = 1;
		if (data2.contains(".")) {
			StringTokenizer fenxi = new StringTokenizer(data2, ".");
			String tempHeader = fenxi.nextToken(); 
			String secondr=fenxi.nextToken();
			data2_1 = Integer.parseInt(secondr );
			int padLen = String.valueOf(secondr).length() + 1; 
			data2_1 = Integer.parseInt(tempHeader + StringUtils.padLeft("", padLen - 1, '0')) + data2_1;
			data2_2 = Integer.parseInt(StringUtils.padLeft("1", padLen, '0'));
		} else {
			StringTokenizer fenxi = new StringTokenizer(data2, "/");
			data2_1 = Integer.parseInt(fenxi.nextToken());
			if (fenxi.hasMoreTokens())
				data2_2 = Integer.parseInt(fenxi.nextToken());
		}

		Calculator r1 = new Calculator(data1_1, data1_2);
		Calculator r2 = new Calculator(data2_1, data2_2);

		Calculator result;
		int a = 0, b = 1;
		if (operation.equals("+")) {
			result = r1.add(r2);
			a = result.getNumerator();
			b = result.getDenominator();
			if (subFlag)
				System.out.println(data1 + " " + operation + " " + data2 + " = " + a + (b == 1 ? "" : ("/" + b)));
		}

		if (operation.equals("-")) {
			result = r1.sub(r2);
			a = result.getNumerator();
			b = result.getDenominator();
			if (subFlag)
				System.out.println(data1 + " " + operation + " " + data2 + " = " + a + (b == 1 ? "" : ("/" + b)));
		}

		if (operation.equals("*")) {
			result = r1.muti(r2);
			a = result.getNumerator();
			b = result.getDenominator();
			if (subFlag)
				System.out.println(data1 + " " + operation + " " + data2 + " = " + a + (b == 1 ? "" : ("/" + b)));
		}

		if (operation.equals("/")) {
			result = r1.div(r2);
			a = result.getNumerator();
			b = result.getDenominator();
			if (subFlag)
				System.out.println(data1 + " " + operation + " " + data2 + " = " + a + (b == 1 ? "" : ("/" + b)));
		}
		return ("" + a + (b == 1 ? "" : ("/" + b)));
	}
}