package com.prodapt.ReferTalents;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
		List<String> list2=new ArrayList<String>();
		
		list.add("test");
		list.add("abc");
		list.add("ppp");
		
		list2.add("test1");
		list2.add("abc");
		list2.add("ppp2");
		
		list.removeAll(list2);
		
		System.out.println(list);
		//System.out.println(list.removeAll(list2));
		
		
		
	}

}
