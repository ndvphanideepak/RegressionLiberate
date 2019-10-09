package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.core.TestActions;

public class ComverseProducts 

{
	TestActions action = null;
	
	By comverseProducts_PanelHeader = By.xpath("//*[text()='Comverse Products']");
	
	By bundels_Select = By.xpath("//*[text()='Bundles:']//following::select[1]");
	By primaryOffers_Select = By.xpath("//*[text()='Primary Offers:']//following::select[1]");
	
	By details_offer = By.xpath("//*[text()='Balance Details']");
	
	By select_button = By.xpath("//*[@value='Select']");
	
	
	public ComverseProducts(TestActions action)
	{
		this.action = action;
	}
	
	
	public boolean selectingComverseProducts()
	{
		boolean passed = false;
		
		if (action.countOf(comverseProducts_PanelHeader) > 0)
		{
			if(action.countOf(primaryOffers_Select) > 0)
			{
				passed = action.waitFor(4);
				passed = action.selectBy(primaryOffers_Select, 1);
				passed = action.waitFor(select_button, 5, true);
				passed = action.waitFor(details_offer, 4, true);
				passed = action.clickOn(select_button);
				passed = action.waitFor(4);
			}
		}
		
		return passed;
	}
	
}
