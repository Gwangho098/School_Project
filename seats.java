package seats;

import java.util.Arrays;
import java.util.Scanner;

public class seats {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("How many : ");
		Scanner input = new Scanner(System.in);
		int frontnum = input.nextInt();
		int [] frontarr = new int [frontnum];
		
		for(int i = 0; i < frontnum; i++) {
			System.out.print(i + 1 + " : ");
			input = new Scanner(System.in);
			frontarr [i] = input.nextInt();
		}
		int [] seats1 = new int [33];
		int [] seats2 = new int [33];
		for(int i = 1; i <= seats1.length; i++) {
			seats1 [i - 1] = i;
			seats2 [i - 1] = i;
		}
		int count = 0;
		boolean tf = false;
		String month = "";
		
		for(int i = 0; i < 11; i++) {
			while(tf == false) {
				count = 0;
				suffle(seats2);
				change(seats2, frontarr);
				
				for(int j = 0; j < seats1.length; j++) {
					if(seats2 [j] == seats1 [j]) {
						count++;
					}
				}
				if(count == 0) {
					tf = true;
				}
			}
			switch(i) {
			case 0 : month = "April";
			break;
			case 1 : month = "May";
			break;
			case 2 : month = "June";
			break;
			case 3 : month = "July";
			break;
			case 4 : month = "August";
			break;
			case 5 : month = "September";
			break;
			case 6 : month = "October";
			break;
			case 7 : month = "November";
			break; 
			case 8 : month = "December";
			break;
			case 9 : month = "January";
			break;
			case 10 : month = "February";
			break;
			}
			System.out.print(month + " " + Arrays.toString(seats2));
			System.out.println();
			for(int j = 0; j < 33; j++) {
				seats1[j] = seats2[j];
			}
			tf = false;
		}
		
		

	}
	public static void suffle(int [] ary) {
		int desk1 = (int)(Math.random()*ary.length), desk2 = (int)(Math.random()*ary.length);
		int std1 = ary [desk1], std2 = ary [desk2];
		for(int i = 0; i < 2 *ary.length; i++) {
			ary [desk1] = std2;
			ary [desk2] = std1;
			desk1 = (int)(Math.random()*ary.length);
			desk2 = (int)(Math.random()*ary.length);
			std1 = ary [desk1];
			std2 = ary [desk2];
			
		}
		
		
		
	}
	public static void change(int [] ary, int [] front) {
		int temp = 0;
		int j;
		int random;
		for(int i = 0; i < front.length; i++) {
			j = 0;
			while(front [i] != ary [j]) {
				j++;
			}
			random = (int)(Math.random()*15);
			temp = ary [j];
			ary [j] = ary[random];
			ary [random] = temp;
		}
	}

}
