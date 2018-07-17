package tests.com.valluri.datastrutures.dyanamicarray;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.valluri.datastructures.dynamicarray.DynamicArray;


public class DynamicArrayTest {
	
	@Test 
	public void testEmptyList() {
		DynamicArray<Integer> lst = new DynamicArray<Integer>();
		assertTrue(lst.isEmpty());
		
	}
	@Test(expected=Exception.class)
	public void testRemovingEmpty() {
		DynamicArray<Integer> lst = new DynamicArray<Integer>();
		lst.removeAt(0);
		
	}
	@Test(expected=Exception.class)
	public void testIndexOutofBounds()
	{
		DynamicArray<Integer> lst = new DynamicArray<Integer>();
		lst.add(-55);
		lst.add(-62);
		lst.add(-24);
		lst.removeAt(3);
	}
	@Test
	public void testRemoving() {
		DynamicArray<Integer> lst = new DynamicArray<Integer>();
		lst.add(12);
		lst.add(22);
		boolean ret = lst.remove(22);
		System.out.println(ret);
		assertTrue(ret);
		System.out.println(lst);
		ret = lst.remove(12);
		assertTrue(ret);
		
	}
	@Test
	public void testAddingElemengts() {
		
	}
	@Test
	public void testAddAndRemove() {
		
	}
	
	public void testSize() {
		DynamicArray<Integer> lst = new DynamicArray<Integer>();
		lst.add(1);
		lst.add(2);
		assertEquals(lst.size(), 3);
	}
}
