package day19.date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateEx {

	public static void main(String[] args) throws ParseException {
		Date now = new Date();
		System.out.println(now);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd(EE) HH:mm:ss");
		String str = format.format(now);
		System.out.println(str);
		
		str = "2023-06-27(화) 18:00:00";
		Date date = format.parse(str);
		System.out.println(date);
		
		date = new Date();
		DateTimeFormatter formatter = 
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss zzzz");
		
		ZoneId zoneId = ZoneId.systemDefault();
		
		ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(date.toInstant(), zoneId);
		
		String formattedDateTime = zonedDateTime.format(formatter);
		
		System.out.println(formattedDateTime);
	}

}
