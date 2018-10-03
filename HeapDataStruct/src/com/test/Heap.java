package com.test;

import java.util.ArrayList;
import java.util.List;

public class Heap {
	private List<Integer> heapList = new ArrayList<>();

	public void insert(int i) {
		heapList.add(i);
		heapify(heapList.size() - 1);
	}

	private void heapify(int i) {
		int j = i;
		int element = heapList.get(i);
		while (j > 0 && heapList.get(parent(j)) < element) {
			swap(parent(j), j);
			element = heapList.get(parent(j));
			j = parent(j);

		}
		printHeap();

	}

	public int size() {
		return heapList.size();
	}

	private void heapifyDown(int i) {
		int child1 = i * 2 + 1;
		int child2 = i * 2 + 2;
		if (child1 > heapList.size() - 1) {
			return;
		}
		if (child2 > heapList.size() - 1) {
			if (heapList.get(i) < heapList.get(child1)) {
				swap(i, child1);
				return;
			}
			return;
		}
		if (heapList.get(i) > heapList.get(child1) && heapList.get(i) > heapList.get(child2)) {
			return;
		}
		if (heapList.get(child1) > heapList.get(child2)) {
			swap(i, child1);
			
			heapifyDown(child1);
		} else {
			swap(i, child2);
			heapifyDown(child2);
		}
		//printHeap();
	}

	public int extractMax() {
		int rv=heapList.get(0);
		if(heapList.size()>1) {
		heapList.set(0, heapList.remove(heapList.size()-1));
		heapifyDown(0);
		}
		//printHeap();
		return rv;

	}

	private void swap(int parent, int i) {
		// TODO Auto-generated method stub
		int temp = heapList.get(i);
		heapList.set(i, heapList.get(parent));
		heapList.set(parent, temp);

	}

	private int parent(int i) {
		if (i % 2 == 1) {
			return i / 2;
		}

		return (i - 1) / 2;
	}

	public void printHeap() {
		System.out.println("current state of heap");
		for (int i : heapList) {
			System.out.println(i);
		}
	}

}
