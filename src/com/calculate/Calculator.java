package com.calculate;

import java.util.StringTokenizer;

/**
 * @author sunkun ������������
 */
public class Calculator {
	// �Ƿ��ӡ ����������
	public static boolean subFlag = false;
	int numerator; // ����
	int denominator; // ��ĸ

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

	void setNumeratorAndDenominator(int a, int b) { // ���÷��Ӻͷ�ĸ
		int c = f(Math.abs(a), Math.abs(b)); // �������Լ��
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

	int f(int a, int b) { // ��a��b�����Լ��
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

	Calculator add(Calculator r) { // �ӷ�����
		int a = r.getNumerator();
		int b = r.getDenominator();
		int newNumerator = numerator * b + denominator * a;
		int newDenominator = denominator * b;
		Calculator result = new Calculator(newNumerator, newDenominator);
		return result;
	}

	Calculator sub(Calculator r) { // ��������
		int a = r.getNumerator();
		int b = r.getDenominator();
		int newNumerator = numerator * b - denominator * a;
		int newDenominator = denominator * b;
		Calculator result = new Calculator(newNumerator, newDenominator);
		return result;
	}

	Calculator muti(Calculator r) { // �˷�����
		int a = r.getNumerator();
		int b = r.getDenominator();
		int newNumerator = numerator * a;
		int newDenominator = denominator * b;
		Calculator result = new Calculator(newNumerator, newDenominator);
		return result;
	}

	Calculator div(Calculator r) { // ��������
		int a = r.getNumerator();
		int b = r.getDenominator();
		int newNumerator = numerator * b;
		int newDenominator = denominator * a;
		Calculator result = new Calculator(newNumerator, newDenominator);
		return result;
	}

	// ��װ�˾������㣬��ҪΪ���������ת�����������װ
	public static String compute(String data1, String operation, String data2,int decLen){ 
		String dString=compute(  data1,   operation,   data2,  "double");
		decLen++;
		return String.valueOf((double) Math.round(Double.valueOf(dString)*Integer.valueOf(StringUtils.padLeft("1", decLen, '0'))) /
				Integer.valueOf(StringUtils.padLeft("1", decLen, '0')));
	}
		// ��װ�˾������㣬��ҪΪ���������ת�����������װ
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
	
	// ��װ�˾������㣬��ҪΪ���������ת�����������װ
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