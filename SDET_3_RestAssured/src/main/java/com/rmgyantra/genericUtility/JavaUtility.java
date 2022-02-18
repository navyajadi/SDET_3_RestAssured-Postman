package com.rmgyantra.genericUtility;

import java.util.Random;

public class JavaUtility {
	
	
	/**
	 * This method is used to Generate RandomNumbers
	 * @return 
	 */
	public int generateRandom() {
		
		
		Random r=new Random();
		int randomNumber = r.nextInt(2000);
		return randomNumber;
		
		
	}

}
