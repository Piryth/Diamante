package com.math.formula;

public class Formula {
	public Formula(){}
	
	public int fact(int x) {
		int f=1;
		for(int i=1;i<=x;i++) {
			f*=i;
		}
		return f;
	}
}
