package com.kr.test;

public class Circle{
	public static double PI = 3.14;
	private double radius;
	
	public Circle(double radius) {
		this.radius = radius;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public void draw() {
		System.out.println("반지름"+ radius+"cm원");
	}
		
}
