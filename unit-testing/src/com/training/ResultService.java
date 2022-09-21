package com.training;

import java.util.Arrays;
import java.util.List;

public class ResultService {
	public String findResult(int mark){

		   String result =null;
		   if(mark<60)
		   {
		          result="B";
		   }
		   if(mark>60 && mark<80)
		   {
		        result ="C";
		   }
		   return result;

		   }
	public String findResult(String mark) throws NumberFormatException {
		String result="A";
		try {
		int markScored=Integer.parseInt(mark);
		if(markScored>=70) {
			result="0";
		}
		}catch (Exception e) {
			throw e;
		
		}
		return result;
	}
public List<String> getNames(){
		
		return Arrays.asList("Ramesh","Kumar","Suresh","Paul","Rajesh");
		
	}


}
