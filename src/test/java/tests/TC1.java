package tests;

import org.testng.annotations.Test;

import base.Base;
import base.Constants;
import reuse.BusinessFunctions;

/**
 * It's used to Run Test Cases
 * 
 *
 */

public class TC1 extends Base{

	@Test
	public void testScript() throws Exception {
		Base.childTest = Base.parentTest.createNode(Constants.node);
		BusinessFunctions fns = new BusinessFunctions();
		fns.gotoApplication();
		fns.homePageActions();
		fns.secondPage();
		fns.thirdPage();
	}
}
