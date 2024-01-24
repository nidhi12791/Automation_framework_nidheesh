package contactsTests;

import org.junit.Assert;
import org.testng.annotations.Test;

public class Assertion_hard {
	@Test
public void sample() {

	System.out.println("step1");
	System.out.println("step2");
	Assert.assertEquals(false, true);/*//only line 10,11 will print step3 and 4 will not print
	/after assertion statmennt line will not execute------in hard assertion*/ 
	System.out.println("step3");
	System.out.println("step4");
	
}
	
	
}
