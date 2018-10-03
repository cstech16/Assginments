package com.test;

import java.util.ArrayList;
import java.util.List;

public class HeapNode {
	public static void main(String[] args) {
		Heap heap=new Heap();
		heap.insert(55);
		heap.insert(67);
		heap.insert(25);
		heap.insert(47);
		heap.insert(18);
		heap.insert(69);
		heap.insert(52);
		heap.insert(68);
		//heap.printHeap();
		List<Integer>list= new ArrayList<>();
		int size=heap.size();
		for(int i=0;i<size;i++) {
			int x=heap.extractMax();
			System.out.println("i"+x);
			list.add(x);
		}
		/*for(int i:list) {
			System.out.print(i+",");
		}*/
		//heap.printHeap();
	}
}
