package contactsTests;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Soft_ASSERTION {

public void sample1() {
	SoftAssert sa=new SoftAssert();
	System.out.println("step1");
	System.out.println("step2");
	Assert.assertTrue(true);
	System.out.println("step3");
	sa.assertEquals(1, 0);
	System.out.println("step4");
	sa.assertAll();
	
	
}
}
