package ttt;
 
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.swing.JScrollBar;

import com.calculate.Calculator;
import com.calculate.StringUtils;

public class MapTest {
	
	
	public static void main(String[] args){
		
		boolean isDouble=true;
		
		
		String d1="1,2,1/3,3";
		String[] arrs=d1.split(",");

		ArrayList<ArrayList<String>> jz=new ArrayList<>();
		// 测试数据
//		jz.add(new ArrayList<String>(Arrays.asList("1","2","1/3","3"))) ;
//		jz.add(new ArrayList<String>(Arrays.asList("1/2","1","1/3","2"))) ;
//		jz.add(new ArrayList<String>(Arrays.asList("3","3","1","4"))) ;
//		jz.add(new ArrayList<String>(Arrays.asList("1/3","1/2","1/4","1"))) ;
 
//		jz.add(new ArrayList<String>(Arrays.asList("1","1/3","2"))) ;
//		jz.add(new ArrayList<String>(Arrays.asList("3","1","5"))) ;
//		jz.add(new ArrayList<String>(Arrays.asList("1/2","1/5","1"))) ; 
		 
//		jz.add(new ArrayList<String>(Arrays.asList("1","1/3","1/5"))) ;
//		jz.add(new ArrayList<String>(Arrays.asList("3","1","1/3"))) ;
//		jz.add(new ArrayList<String>(Arrays.asList("5","3","1"))) ; 
		 
//		jz.add(new ArrayList<String>(Arrays.asList("1","2","7"))) ;
//		jz.add(new ArrayList<String>(Arrays.asList("1/2","1","5"))) ;
//		jz.add(new ArrayList<String>(Arrays.asList("1/7","1/5","1"))) ; 
 		 
//		jz.add(new ArrayList<String>(Arrays.asList("1","3","1/7"))) ;
//		jz.add(new ArrayList<String>(Arrays.asList("1/3","1","1/9"))) ;
//		jz.add(new ArrayList<String>(Arrays.asList("7","9","1"))) ; 
		
//		jz.add(new ArrayList<String>(Arrays.asList("1","2","7"))) ;
//		jz.add(new ArrayList<String>(Arrays.asList("1/2","1","5"))) ;
//		jz.add(new ArrayList<String>(Arrays.asList("1/7","1/5","1"))) ;
		
		jz.add(new ArrayList<String>(Arrays.asList("1","1/3","2"))) ;
		jz.add(new ArrayList<String>(Arrays.asList("3","1","5"))) ;
		jz.add(new ArrayList<String>(Arrays.asList("1/2","1/5","1"))) ;
		
		
		
		System.out.println("输出 -----");
		PrintArr(jz);
		
		ArrayList<ArrayList<String>> jzResult=new ArrayList<>();
		for (int i = 0; i < jz.size(); i++) {  // 循环行
			ArrayList<String> subRow = jz.get(i);	
			ArrayList<String> subRowD = new ArrayList<>(); 			
			for (int j = 0; j < subRow.size(); j++) {   
				
				String itemStr=subRow.get(j); 
				
				ArrayList<String> itemHe=new ArrayList<>();
				String strHe="0";
				// 求列和
				for (int ij = 0; ij < jz.size(); ij++) {
					strHe=Calculator.compute(strHe, "+", jz.get(ij).get(j));
				} 
				
				Double tempDou= sDouble(itemStr) / sDouble(strHe);
				tempDou=(double)(Math.round(tempDou*1000)/Double.valueOf("1000"));
				 
				subRowD.add(
						isDouble ? String.valueOf(tempDou ): 
						Calculator.compute(itemStr, "/",    strHe));
			}  
			jzResult.add(subRowD);
		}

		System.out.println("---------------------------------");
		PrintArr(jzResult);
		
		System.out.println( "开始计算和值 1");
		List<String> heList=new ArrayList<>();
		// jzResult
		for (List<String> itemArr : jzResult) { 
			// 求和
			String he="0";
			for (String itemStr : itemArr) {
				he=Calculator.compute(he, "+", itemStr); 
			} 
			heList.add(doubleToStr(he, 3));
		}
		System.out.println(join((ArrayList<String>) heList, "\r\n")); 

		System.out.println( "计算和值 和值权重");
		
		// System.out.println(sDouble (Sum(heList)));
		List<String> wList=new ArrayList<>();
				
		for (String itemStr : heList) {
			String tempW=Calculator.compute(itemStr, "/", Sum(heList),3);
			wList.add(tempW);
			System.out.println(tempW );
		}

//		wList.clear();  
//		wList.addAll( Arrays.asList("0.25","0.16","0.51","0.09"));

		System.out.println( " 计算一致性检验 右侧数列为  ");  

		List<String> yList=new ArrayList<>();
		for (int i = 0; i < jz.size(); i++) {  // 循环行
			ArrayList<String> itemArr=jz.get(i);
			String he="0";
			for (int j = 0; j < itemArr.size(); j++) {
				he=Calculator.compute(he , "+", Calculator.compute( itemArr.get(j),"*",wList.get(j)) );
			} 
			yList.add(he);
			System.out.println(  "λ"+(i+1)+"*"+ doubleToStr(wList.get(i),3)  +"= "+doubleToStr(he, 3) + "   ,λ"+(i+1) +"= " +  Calculator.compute( he,"/",wList.get(i),3));
		
		}
		
		
		 
		
		
		
		
		
//		System.out.println(Runtime.getRuntime().availableProcessors());

//		ThreadPoolExecutor pool=new ThreadPoolExecutor(2, 4, 60, TimeUnit.SECONDS,
//				,new  BlockingDeque<String>() {
//				});
		//		try {
//			
//			
//			
//			// openofficeDemo.office2PDF("D:\\java 面试要点.docx", "D:\\111.pdf");
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	 System.out.println("结束了");
		
	}
	
	
	public static String Sum(List<String> list)
	{
		String result="0";
		for (String string : list) {
			result= Calculator.compute(result, "+", string);
		}
		return result;		
	}
	
	public static void PrintArr(ArrayList<ArrayList<String>> pp){
		
		for (ArrayList<String> arrayList : pp) { 
			 System.out.println( join(arrayList, "	")); 
		}
		
	}
	public static String join( ArrayList<String> o , String flag ){
	    StringBuffer str_buff = new StringBuffer();
	  
	    for(int i=0 , len=o.size() ; i<len ; i++){
	        str_buff.append( String.valueOf( o.get(i) ) );
	        if(i<len-1)str_buff.append( flag );
	    }
	 
	    return str_buff.toString(); 
	}

	public static String doubleToStr(String d1,int len){ 
		String dString=String.valueOf(sDouble(d1));
		int clen=len+1;
		return String.valueOf((double) Math.round(Double.valueOf(dString)*Integer.valueOf(StringUtils.padLeft("1", clen, '0'))) /
				Integer.valueOf(StringUtils.padLeft("1", clen, '0')));
	}
		public static Double sDouble(String d1){ 
		 String itemStr=d1;
		 double tempD=0;
		if(itemStr.contains("/"))
			tempD= Double.parseDouble( itemStr.split("/")[0])/Double.parseDouble( itemStr.split("/")[1]); 
		 else 
			 tempD=Double.parseDouble(itemStr);
		return tempD;
	}
	
	public static Integer toInt(Object obj, int defaultValue) {
		return 0;//StringUtility.isInteger(obj) ? Integer.parseInt(obj.toString()) : defaultValue;
	}
	
	public static boolean toBoolen(Object obj, boolean defaultValue) {
		return false;//StringUtility.isInteger(obj) ? Integer.parseInt(obj.toString()) : defaultValue;
	}


}
