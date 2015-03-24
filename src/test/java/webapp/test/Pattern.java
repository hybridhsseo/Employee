package webapp.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;

import org.junit.Test;

public class Pattern {

	@Test
	public void test() {
		String date = "한";
		boolean flag =  date.matches("[가-힣]{1,3}");
		
		System.out.println(flag);
		
	}
	

}
