package ule.edi.recursiveList;



import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.*;

import ule.edi.exceptions.EmptyCollectionException;



public class UnorderedLinkedListTests {

	

	private UnorderedLinkedListImpl<String> lS;
	private UnorderedLinkedListImpl<String> lSABC;
	

	@Before
	public void setUp() {
		this.lS = new UnorderedLinkedListImpl<String>();
		
		this.lSABC = new UnorderedLinkedListImpl<String>("A", "B", "C");
	}
	
   @Test
   public void constructorElemens(){
	   lS=new UnorderedLinkedListImpl<String>("A", "B", "C", "D");
	   Assert.assertEquals("(A B C D )", lS.toString());
   }

// TESTS DE addFirst
   @Test
   public void addFirstTest(){
	   
	   lS.addFirst("D");
	   Assert.assertEquals("(D )", lS.toString());
	   lS.addFirst("C");
	   Assert.assertEquals("(C D )", lS.toString());
	   lS.addFirst("B");
	   Assert.assertEquals("(B C D )", lS.toString());
	   lS.addFirst("A");
	   Assert.assertEquals("(A B C D )", lS.toString());
   }
   
   // TESTS DE addBefore
   
   @Test
   public void addBeforeTest(){
	   
	   lS.addFirst("D");
	   Assert.assertEquals("(D )", lS.toString());
	   lS.addBefore("C", "D");
	   Assert.assertEquals("(C D )", lS.toString());
	   lS.addBefore("A","C");
	   Assert.assertEquals("(A C D )", lS.toString());
	   lS.addBefore("B", "C");
	   Assert.assertEquals("(A B C D )", lS.toString());
	   lS.addBefore("X", "C");
	   Assert.assertEquals("(A B X C D )", lS.toString());
   }
   
   //Tests toStringReverse 
 
   @Test
   public void toStringReverse(){
	   lS=new UnorderedLinkedListImpl<String>("A", "B", "C", "D");
	   Assert.assertEquals("(A B C D )", lS.toString());
	   Assert.assertEquals("(D C B A )", lS.toStringReverse());
		  
   }
// Tests eliminar duplicados
	
   @Test
	public void testRemoveDuplicates() throws EmptyCollectionException{
	    UnorderedLinkedListImpl<String> lista=new UnorderedLinkedListImpl<String>("A", "A", "B", "C", "B", "A", "C"); 
		Assert.assertEquals(lista.removeDuplicates(),4); 
		Assert.assertEquals(lista.toString(), "(A B C )");
		Assert.assertEquals(lSABC.removeDuplicates(),0); // 0 repetids
		Assert.assertEquals(lSABC.toString(), "(A B C )");	
	
	}
  
   
   
// AÑADIR MAS TESTS para el resto de casos especiales y para el resto de métodos
 // de las clases AbstractLinkedListImpl y UnorderedLinkedListImpl
	
   @Test
   public void containsTest() {
	   Assert.assertTrue(lSABC.contains("A"));
	   Assert.assertTrue(lSABC.contains("B"));
	   Assert.assertTrue(lSABC.contains("C"));
	   Assert.assertFalse(lSABC.contains("X"));
	   
   }
   
   @Test(expected = NullPointerException.class)
   public void containsTestWrong() {
	   lSABC.contains(null);
   }
 
   @Test
   public void countTest() {
	   Assert.assertEquals(lSABC.count("B"), 1);
	   Assert.assertEquals(lS.count("B"), 0);

   }

   @Test
   public void getFirstTest() throws EmptyCollectionException {
	   Assert.assertEquals(lSABC.getFirst(), "A");
   }
   
   @Test(expected = EmptyCollectionException.class)
   public void getFirstTestWrong() throws EmptyCollectionException {
	  lS.getFirst();
   }
   
   @Test
   public void getLastTest() throws EmptyCollectionException{
	   Assert.assertEquals(lSABC.getLast(), "C");
   }
   
   @Test(expected = EmptyCollectionException.class)
   public void getLastTestWrong() throws EmptyCollectionException{
	   lS.getLast();
   }
   
   @Test
   public void sizeTest() {
	   Assert.assertEquals(lS.size(), 0);
	   Assert.assertEquals(lSABC.size(), 3);
	   lSABC.addLast("D");
	   Assert.assertEquals(lSABC.size(), 4);	   
   }
   
   @Test
   public void removeTest() throws EmptyCollectionException{
	   Assert.assertEquals(lSABC.remove("A"), "A");
	   Assert.assertEquals("(B C )", lSABC.toString());
	   lS=new UnorderedLinkedListImpl<String>("A", "B", "C", "D");
	   Assert.assertEquals(lS.remove("C"), "C");
	   Assert.assertEquals("(A B D )", lS.toString());
   }
   
   @Test
   public void removeLastRec() throws EmptyCollectionException {
	   lS=new UnorderedLinkedListImpl<String>("A", "B", "A", "D");
	   Assert.assertEquals(lS.removeLast("A"), "A");
	   Assert.assertEquals("(A B D )", lS.toString());

   }
   
   @Test
   public void toStringFromUntilTest() {
	   lS=new UnorderedLinkedListImpl<String>("A", "B", "A", "D");
	   Assert.assertEquals(lS.toStringFromUntil(2, 10), "(B A D )");
	   Assert.assertEquals(lS.toStringFromUntil(10, 15), "()");
	   lSABC.addLast("A");
	   lSABC.addLast("A");
	   lSABC.addLast("A");
	   Assert.assertEquals(lSABC.toStringFromUntil(3, 5), "(C A A )");
	   Assert.assertEquals(lSABC.toStringFromUntil(6, 6), "(A )");
	   lS=new UnorderedLinkedListImpl<String>();
	   Assert.assertEquals(lS.toStringFromUntil(1, 3), "()");

   }
   @Test(expected = EmptyCollectionException.class) 
   public void removeDuplicatesWrongTest() throws EmptyCollectionException {
	   lS.removeDuplicates();
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void StringFromUntilWrongTest() {
	   lSABC.toStringFromUntil(-5, 6);
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void StringFromUntilWrongTest3() {
	   lSABC.toStringFromUntil(8, 6);
   }

   
   @Test(expected=NullPointerException.class)
	public void removeLastWrongTest1() throws EmptyCollectionException{
		lSABC.removeLast(null);
	}
	
	@Test(expected=NoSuchElementException.class)
	public void removeLastWrongTest2() throws EmptyCollectionException{
		lSABC.removeLast("X");

	}
	@Test
	public void isOrderedTest() {
		UnorderedLinkedListImpl<Integer> lista = new UnorderedLinkedListImpl<Integer>(1,2,3);
		Assert.assertTrue(lista.isOrdered());
		UnorderedLinkedListImpl<Integer> lista1 = new UnorderedLinkedListImpl<Integer>(1,8,3);
		Assert.assertFalse(lista1.isOrdered());
		Assert.assertTrue(lS.isOrdered());

	}
	
	@Test
	public void iteratorTest() {
		Iterator<String> iterator = lSABC.iterator();
		Assert.assertTrue(iterator.hasNext());
		Assert.assertEquals(iterator.next(),"A");
		Assert.assertEquals(iterator.next(),"B");
		Assert.assertEquals(iterator.next(),"C");
		Assert.assertFalse(iterator.hasNext());
	}
	
	@Test(expected = NoSuchElementException.class)
	public void iteratorWrongTest1() {
		lS.addLast("A");
		Iterator<String> iterator = lS.iterator();
		Assert.assertTrue(iterator.hasNext());
		iterator.next();
		iterator.next();
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void iteratorWrongTest2() {
		Iterator<String> iterador = lSABC.iterator();
		iterador.remove();
	}
	@Test(expected = NullPointerException.class)
	public void removeWrongTest() throws EmptyCollectionException {
		lSABC.remove(null);
	}
	@Test(expected = NoSuchElementException.class)
	public void removeWrongTest2() throws EmptyCollectionException {
		lSABC.remove("X");
	}
	@Test(expected = NullPointerException.class)
	public void addFirstWrongTest() throws NullPointerException {
		lSABC.addFirst(null);
	}
	@Test(expected = NullPointerException.class)
	public void addLastWrongTest() throws NullPointerException {
		lSABC.addLast(null);
	}
	@Test(expected = NullPointerException.class)
	public void addBeforeWrongTest() throws NullPointerException {
		lSABC.addBefore(null, "B");
	}
	@Test(expected = NullPointerException.class)
	public void addBeforeWrongTest2() throws NullPointerException {
		lSABC.addBefore("B", null);
	}
	@Test(expected = NoSuchElementException.class)
	public void addBefore() throws EmptyCollectionException {
		lSABC.addBefore("A", "X");
	}
	@Test
	   public void toStringNodeTest() {
	        Assert.assertEquals("(A)", lSABC.front.toString());
	   }
}
