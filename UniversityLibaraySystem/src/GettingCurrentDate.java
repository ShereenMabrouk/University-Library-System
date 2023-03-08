import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class GettingCurrentDate {
	public static String date() {
		// getting current date and time using Date class
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		Date dateobj = new Date();

		String date = df.format(dateobj);
		return date;
	}
}