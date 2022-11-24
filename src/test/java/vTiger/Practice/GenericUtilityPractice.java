package vTiger.Practice;

import java.util.Random;

public class GenericUtilityPractice {

			public static void main(String[] args) { //calling/caller function
				
				Random ran = new Random();
				int random = ran.nextInt(300);
				System.out.println(random);
				
				int ran1 = ran.nextInt(100);
				System.out.println(ran1);
				
				int value1 = GenericUtilityPractice.add(random,20);
				System.out.println(value1);
			}

			private static int add(int a, int b) { //called function
				int c= a+b;
				return c;
			}

		}
