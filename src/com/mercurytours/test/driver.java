package com.mercurytours.test;

import java.awt.AWTException;
import java.io.IOException;

import org.sikuli.script.FindFailed;

import jxl.read.biff.BiffException;

public class driver {

	public static void main(String[] args) throws InterruptedException, AWTException, FindFailed, IOException, BiffException {
		// TODO Auto-generated method stub

		methods Dr =new methods();
		Dr.applaunch();
		//Dr.login();
		//Dr.flightfinder();
		//Dr.appclose();
		//Dr.actionlogin();
		//Dr.robotlogin();
		//Dr.flightfinder();
		//Dr.sikulilogin();
		//Dr.loginwithtestdata();
		//Dr.rightclick();
		//Dr.loginDataDrivenExcelSheet();
		//Dr.screenshot();
		Dr.autoTest();
	}

}
