package com.maths.binomial;
import java.util.ArrayList;

import com.math.formula.Formula;

public class PascalTriangle {
	protected static Formula f = new Formula();
	
	public PascalTriangle() {
		
	}
	public static int binomial(int k,int n) {
		return (f.fact(n))/(f.fact(k)*f.fact(n-k));
	}
	public static void pascalTriangle() {
		ArrayList pascalList = new ArrayList();
		for(int i=1;i<10;i++) {
			pascalList.add(binomial(i,i));
		}
	}
	public static void main(String[] args) {
		
	}
	
	
}
