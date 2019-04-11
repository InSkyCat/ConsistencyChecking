package com.calculate;

public class StringUtils { 
	
	 /**
     * @×÷Õß Ò¢
     * @¹¦ÄÜ String×ó¶ÔÆë
     */
    public static String padLeft(String src, int len, char ch) {
        int diff = len - src.length();  
        if (diff <= 0) {
            return src;
        }

        char[] charr = new char[len];
        System.arraycopy(src.toCharArray(), 0, charr, 0, src.length());
        for (int i = src.length(); i < len; i++) {
            charr[i] = ch;
        }
        return new String(charr);
    }
    /**
     * @×÷Õß Ò¢
     * @¹¦ÄÜ StringÓÒ¶ÔÆë
     */
    public static String padRight(String src, int len, char ch) {
        int diff = len - src.length();
        if (diff <= 0) {
            return src;
        }

        char[] charr = new char[len];
        System.arraycopy(src.toCharArray(), 0, charr, diff, src.length());
        for (int i = 0; i < diff; i++) {
            charr[i] = ch;
        }
        return new String(charr);
    }

}
