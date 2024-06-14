package day13;

import java.text.DecimalFormat;

public class DecimalFormatEx01 {

	public static void main(String[] args) {

		int num1 = 123456789;
		DecimalFormat df1 = new DecimalFormat("0000000000");
		System.out.println(df1.format(num1));
		
		int num2 = 123456789;
		DecimalFormat df2 = new DecimalFormat("###,###");
		System.out.println(df2.format(num2));
		
		int num3 = 123456789;
		DecimalFormat df3 = new DecimalFormat("#.##%");
		System.out.println(df3.format(num3));
		
		DecimalFormat df4 = new DecimalFormat("\u00A4#");
		System.out.println(df4.format(num3));
		
		double num4 = 12.3456;
		DecimalFormat df5 = new DecimalFormat("#.##");
		System.out.println(df5.format(num4));
	}

}
