package com.techment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

class Testing2 {

	Calculations calculation = new Calculations();	
	
	 @BeforeClass  
	    public static void setUpBeforeClass() throws Exception {  
	        System.out.println("before class");  
	    }  	
	
	  @Before  
	    public void setUp() throws Exception {  
	        System.out.println("before");  
	    }  
	 
	@Before
	void Test9()
	{
		System.out.println("before test 9");
		assertTrue(true);
	}
	
	@Test
	void testcube() {
		
		assertEquals(8,calculation.cube(2));
		System.out.println("test cube");
	}

	@Test
	void testcube2() {		
		assertEquals(6,calculation.cube(2));
		System.out.println("test cube2");
	}
	
	@Test  
    public void testFindMax(){  
        System.out.println("test case find max");  
        assertEquals(4,calculation.findMax(new int[]{1,3,4,2}));  
        assertEquals(-2,calculation.findMax(new int[]{-12,-3,-4,-2}));  
    }  
	
	@Test  
    public void testFindMax2(){  
        System.out.println("test case find max");  
        assertEquals(-2,calculation.findMax(new int[]{-12,-3,-4,-2}));
    }  
	
	
	@Test
	void TestArithmetic()
	{
		//var message ="something went ";
		assertThrows(ArithmeticException.class, ()-> {int a=1;int b=0;System.out.println(a/b);});
		 System.out.println("test 6");
	}
	
	
	
	
	
	  @After  
	    public void tearDown() throws Exception {  
	        System.out.println("after");  
	    }  
	
	  @AfterClass  
	    public static void tearDownAfterClass() throws Exception {  
	        System.out.println("after class");  
	    }  
	
}
