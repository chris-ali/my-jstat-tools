package com.chrisali.stattools;
import com.chrisali.stattools.goodnessoffit.ChiSquare;

public class StatToolTest {

	public static void main(String[] args) {
		double[] data = {42, 48, 49, 50, 57, 58, 59};
		double maxClass = 60;
		double minClass = 40;
		int classes = 4;
		
		ChiSquare.getChi(data, minClass, maxClass, classes);
	}

}
