package ule.edi.tree;


import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;





public class BinarySearchTreeTests {

   
	/*
	* 10
	* |  5
	* |  |  2
	* |  |  |  ∅
	* |  |  |  ∅
	* |  |  ∅
	* |  20
	* |  |  15
	* |  |  |  ∅
	* |  |  |  ∅
	* |  |  30
	* |  |  |  ∅
	* |  |  |  ∅
    */	
	private BinarySearchTreeImpl<Integer> ejemplo = null;
	
	
	/*
	* 10
	* |  5
	* |  |  2
	* |  |  |  ∅
	* |  |  |  ∅
	* |  |  ∅
	* |  20
	* |  |  15
	* |  |  |  12
	* |  |  |  |  ∅
	* |  |  |  |  ∅
	* |  |  ∅
  */
	private BinarySearchTreeImpl<Integer> other=null;
	private BinarySearchTreeImpl<Integer> nulo = null;
	private Set<Integer> collection = null;
	
	@Before
	public void setupBSTs() {
		
			
		ejemplo = new BinarySearchTreeImpl<Integer>();
		ejemplo.insert(10, 20, 5, 2, 15, 30);
		Assert.assertEquals(ejemplo.toString(), "{10, {5, {2, ∅, ∅}, ∅}, {20, {15, ∅, ∅}, {30, ∅, ∅}}}");
		
		
		other =new BinarySearchTreeImpl<Integer>();
		other.insert(10, 20, 5, 2, 15, 12);
		Assert.assertEquals(other.toString(), "{10, {5, {2, ∅, ∅}, ∅}, {20, {15, {12, ∅, ∅}, ∅}, ∅}}");
		
		nulo = new BinarySearchTreeImpl<Integer>();
		collection = new HashSet<Integer>();
		collection.add(40);
	    	}

	@Test
	public void testRemoveHoja() {
		ejemplo.remove(30);
		Assert.assertEquals("{10, {5, {2, ∅, ∅}, ∅}, {20, {15, ∅, ∅}, ∅}}",ejemplo.toString());
	}
	
	@Test
	public void testRemove1Hijo() {
		ejemplo.remove(5);
		Assert.assertEquals("{10, {2, ∅, ∅}, {20, {15, ∅, ∅}, {30, ∅, ∅}}}",ejemplo.toString());
	}
	
	@Test
	public void testRemove2Hijos() {
		ejemplo.remove(10);
		Assert.assertEquals("{15, {5, {2, ∅, ∅}, ∅}, {20, ∅, {30, ∅, ∅}}}",ejemplo.toString());
	}
	
		@Test
		public void testTagDecendentsEjemplo() {
			ejemplo.tagDecendents();
			ejemplo.filterTags("decendents");
			Assert.assertEquals("{10 [(decendents, 5)], {5 [(decendents, 1)], {2 [(decendents, 0)], ∅, ∅}, ∅}, {20 [(decendents, 2)], {15 [(decendents, 0)], ∅, ∅}, {30 [(decendents, 0)], ∅, ∅}}}",ejemplo.toString());
		}
		
		@Test
		public void testTagHeightEjemplo() {
			other.tagHeight();
			other.filterTags("height");
			Assert.assertEquals("{10 [(height, 1)], {5 [(height, 2)], {2 [(height, 3)], ∅, ∅}, ∅}, {20 [(height, 2)], {15 [(height, 3)], {12 [(height, 4)], ∅, ∅}, ∅}, ∅}}",other.toString());
		}
		
		
		@Test
		public void testTagOnlySonEjemplo() {
		
		Assert.assertEquals(other.toString(), "{10, {5, {2, ∅, ∅}, ∅}, {20, {15, {12, ∅, ∅}, ∅}, ∅}}");
		Assert.assertEquals(3,other.tagOnlySonInorder());
		other.filterTags("onlySon");
		Assert.assertEquals("{10, {5, {2 [(onlySon, 1)], ∅, ∅}, ∅}, {20, {15 [(onlySon, 3)], {12 [(onlySon, 2)], ∅, ∅}, ∅}, ∅}}",other.toString());

		}

	@Test
	public void containsTest() {
		Assert.assertTrue(ejemplo.contains(5));
		Assert.assertFalse(ejemplo.contains(90));

	}
	@Test
    public void multipleRemoveTest() {
		ejemplo.remove(10, 20);
        Assert.assertEquals("{15, {5, {2, ∅, ∅}, ∅}, {30, ∅, ∅}}",ejemplo.toString());
    }
	
	/*@Test
    public void multipleInsertTest() {
		Collection collection = new Collection<T>(90,25, 30);
		ejemplo.insert(collection);
        Assert.assertEquals("",ejemplo.toString());
    }*/
	
	@Test
    public void testIterator() {
        Iterator<Integer> iter = ejemplo.iteratorWidth();
        Assert.assertTrue(iter.hasNext());
        Assert.assertEquals((Object)10, iter.next());
        Assert.assertTrue(iter.hasNext());
        Assert.assertEquals((Object)5, iter.next());
        Assert.assertTrue(iter.hasNext());
        Assert.assertEquals((Object)20, iter.next());
        Assert.assertTrue(iter.hasNext());
        Assert.assertEquals((Object)2, iter.next());
        Assert.assertTrue(iter.hasNext());
        Assert.assertEquals((Object)15, iter.next());
        Assert.assertTrue(iter.hasNext());
        Assert.assertEquals((Object)30, iter.next());
        Assert.assertFalse(iter.hasNext());
    }
	
	@Test(expected = IllegalArgumentException.class)
	public void removeWrongTest1() throws IllegalArgumentException{
		ejemplo.remove(nulo.getContent());
	}
	

	@Test(expected = NoSuchElementException.class)
	public void removeWrongTest2() throws NoSuchElementException{
		ejemplo.remove(60);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void multipleRemoveWrongTest1() throws IllegalArgumentException{
		ejemplo.remove(nulo.getContent(), 5, 10);
	}

	@Test(expected = NoSuchElementException.class)
	public void multipleRemoveWrongTest2() throws NoSuchElementException{
		ejemplo.remove(60, 10, 55);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void insertWrongTest() throws IllegalArgumentException{
		ejemplo.insert(nulo.getContent());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void multipleInsertWrongTest() throws IllegalArgumentException{
		ejemplo.insert(nulo.getContent(), 5, 8);
	}
	
	@Test
	public void collectionInserTest() {
		nulo.insert(collection);
	}
	
}


