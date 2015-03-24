package webapp.main;

import java.util.Scanner;
import java.util.StringTokenizer;

import webapp.escape.Screen;

public class CalendarTest {

	public static void printCalendar(int year, int month) {
		Screen.cursorPosition(3, 5);
		System.out.println("year=" + year + ", month="+month);
	}
	public static void main(String[] args) {
		Screen.clear();
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			
			boolean flag=true;
			String param="";
			do {
				flag = true;
				Screen.cursorPosition(20, 1);
				System.out.print("[yyyy/MM] : ");
				param = scan.nextLine();
				Screen.clear();
				System.out.println("param=" + param);
				
//				flag = param.matches("[1-9][0-9][0-9][0-9]/[0-9][0-9]");
				flag = param.matches("[1-9][0-9]{3}/[0-1][0-9]");
				
			} while(!flag);
			
			StringTokenizer tokens = new StringTokenizer(param, "/");
			int year = Integer.parseInt((String)tokens.nextElement()); 
			int month = Integer.parseInt((String)tokens.nextElement());
			
			if (month > 0 && month < 13)
				printCalendar(year, month);
		}

	}

}
