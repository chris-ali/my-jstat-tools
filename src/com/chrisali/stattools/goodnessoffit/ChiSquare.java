package com.chrisali.stattools.goodnessoffit;

import org.apache.commons.math3.distribution.*;
import org.apache.commons.math3.stat.descriptive.*;

/*
ChiSquare.java
Chris Ali
11.11.2015

Arguments:
data - a 1xn array of data to analyze for goodness of fit
minClass - the lowest value for a class desired for the test
maxClass - the largest value for a class desired for the test
classes - the number of class "boxes" desired for the test

Outputs:
chiSquare - Chi Squared statistic used for goodness of fit test
O - 1xclasses size array of observed data in each class 
O - 1xclasses size array of expected data in each class 
*/

public class ChiSquare {
	public static double getChi(double[] data, double minClass, double maxClass, int classes) {
		DescriptiveStatistics stats = new DescriptiveStatistics(data);
		NormalDistribution normDist = new NormalDistribution(stats.getMean(), stats.getStandardDeviation());
		
		double[] E = new double[classes];
		double[] O = new double[classes];
		double chiSquare = 0;
		
		double classSize = (maxClass-minClass)/classes;
		double classMult = minClass/classSize;
	
		for(int i=0; i<classes; i++)
			E[i] = data.length*Math.abs(normDist.cumulativeProbability((classMult+i)*classSize)-normDist.cumulativeProbability((classMult+i+1)*classSize));
		
		for(int i=0; i<classes; i++)
			for(int j=0; j<data.length; j++)
				if (data[j] >= ((classMult+i)*classSize) && data[j] < ((classMult+i+1)*classSize))
					O[i]++;
		
		for (int i=0; i<E.length; i++)
			chiSquare = chiSquare + Math.pow((O[i]-E[i]), 2)/E[i];
			
		return chiSquare;
	}
//	public static String goodnessOfFitTest(int degOfFreedom, double chiSquare) {
//		
//		ChiSquaredDistribution chiCrit = new ChiSquaredDistribution(degOfFreedom);
//		
//		if (chiCrit. > chiSquare)
//			return "Reject Null Hypothesis!";
//		else
//			return "Fail to reject Null Hypothesis!";
//	}
}
