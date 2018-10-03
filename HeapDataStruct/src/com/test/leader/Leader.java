package com.test.leader;

import java.util.ArrayList;
import java.util.List;

public class Leader {

	static List<Integer> arr = null;

	public static void main(String[] args) {
		arr=new ArrayList<>();
		arr.add(16);
		arr.add(17);
		arr.add(2);
		arr.add(5);
		arr.add(3);
		arr.add(4);
		List<Integer>list=getLeader(arr.size()-1);
		for(int i:list) {
			System.out.println(i);
		}
	}

	public static List<Integer> getLeader(int index) {
		if (index == 0) {
			List<Integer> l= new ArrayList<Integer>();
			l.add(arr.get(index));
			return l;
		}
		List<Integer> list = getLeader(index - 1);
		if (list.get(list.size() - 1) > arr.get(index)) {
			list.add(arr.get(index));
		} else {
			list.set(list.size() - 1, arr.get(index));
		}
		return list;
	}
}
