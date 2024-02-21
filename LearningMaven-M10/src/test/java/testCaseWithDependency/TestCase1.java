package testCaseWithDependency;

import org.testng.Reporter;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class TestCase1 extends BaseClass{
	@Test
	public void demo() {
		Reporter.log("Maven is fun", true);
	}
}
