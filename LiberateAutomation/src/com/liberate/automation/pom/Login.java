package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.LiberateCommon;
import com.liberate.automation.core.TestActions;

public class Login {
	TestActions action = null;

	// Page Elements : Failure Queries
	By UserName = By.xpath("//*[@id='login:userName']");
	By PassWord = By.xpath("//*[@id='login:userPassword']");
	By LoginButton = By.xpath("//*[@id='login:loginButtonImg']");
	
	By Logout = By.xpath("//*[text()='Logout']");
	
	By LiberateFrame = By.xpath("//iframe[@id='liberate']");
	
	public Login(TestActions action) {
		this.action = action;
	}

	public boolean login(String username, String password) throws InterruptedException {
		boolean passed = false;

		if (action.countOf(LiberateCommon.LevelOne.Home) > 0)
			return true;

		passed = action.sendDataTo(UserName, username);
		passed = action.sendDataTo(PassWord, password);
		Thread.sleep(10);
		passed = action.clickOn(LoginButton);
		Thread.sleep(10);
		passed = action.waitFor(LoginButton, 60, false);
		
		if(action.countOf(LiberateFrame)>0)
		{
			action.switchToFrame(LiberateFrame);
		}
		
		passed = action.waitFor(LiberateCommon.LevelOne.Home, 60, true);
		
		return passed;
	}
	
	public boolean logout()
	{
		boolean passed = false;

		passed = action.waitFor(Logout, 4, true);
		passed = action.clickOn(Logout);
		passed = action.waitFor(Logout, 4, false);
		
		return passed;
	}
}
