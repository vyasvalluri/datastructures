package com.valluri.datastructures.dynamicarray;

import java.util.Iterator;
@SuppressWarnings(value = { "" })
public class DynamicArray<T> implements Iterable<T> {
	
	private T [] arr;
	private int len = 0;
	private int capacity = 0;
	
	public DynamicArray() {
		this(16);
	}
	public DynamicArray(int capacity) {
		if(capacity < 0) throw new IllegalArgumentException("");
		this.capacity = capacity;
		arr = (T[]) new Object[capacity];
	}
	
	public int size() {
		return len;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public T get(int index) {
		return arr[index];
	}
	
	public void set(int index, T obj) {
		arr[index] = obj;
	}
	
	public void clear() {
		for(int i = 0 ; i< len; i++) {
			arr[i] = null;
		len = 0;
		}
	}
	
	public void add(T elem) {
		
		if(len+1 >= capacity) {
			if(capacity == 0) capacity = 1;
			else capacity *= 2;
			T[] newarr = (T[]) new Object[capacity];
			for(int i =0; i<len; i++) {
				newarr[i] = arr[i];
			}
			arr = newarr;
		}
		arr[len++] = elem;
	}
	
	public T removeAt(int index) {
		if(index>len || index < 0 ) new ArrayIndexOutOfBoundsException();
		T data = arr[index];
		T[] newarr = (T[]) new Object[len-1];
		for(int i=0, j=0; i<len; i++, j++) {
			if(i == index)
				j--;
			else
				newarr[j]=arr[i];
		}
		arr = newarr;
		capacity = --len;
		
		return data;
	}

	public int indexOf(T obj) {
		for(int i =0; i<len; i++) {
			if(obj == null) {
				if(arr[i] == null)
					return i;
			}else {
				if(obj.equals(arr[i]))
					return i;
			}
		}
		return -1;
	}
	
	public boolean remove(T obj) {
		int i = indexOf(obj);
		if(i != -1) {
			removeAt(i);
			return true;
		} else return false;
	}
	
	public boolean contains(T obj) {
		return indexOf(obj) != -1;
	}
	@Override
	public Iterator<T> iterator() {
	final int index = 0;
		return new Iterator<T>() {

			@Override
			public boolean hasNext() {
				return index < len;
			}

			@Override
			public T next() {
				return arr[index];
			}
			
		};
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		if(len == 0) return "[]";
		else {
			sb.append("[");
			for(int i = 0; i<len-1; i++)
				sb.append(arr[i]+", ");
			sb.append(arr[len-1]+"]");
		}
		return sb.toString();
	}
}
