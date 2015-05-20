package us.absencemanager;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.FastDateFormat;



public class TimeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastDateFormat dtFormat = DateFormatUtils.ISO_TIME_NO_T_FORMAT;

		Date now = new Date( );
		Date nearestHour = DateUtils.round( now, Calendar.HOUR );
		Date nearestDay = DateUtils.round( now, Calendar.DAY_OF_MONTH );
		Date nearestYear = DateUtils.round( now, Calendar.YEAR );

		System.out.println( "Now: " + dtFormat.format( now ) );
		System.out.println( "Nearest Hour: " + dtFormat.format( nearestHour ) );
		System.out.println( "Nearest Day: " + dtFormat.format( nearestDay ) );
		System.out.println( "Nearest Year: " + dtFormat.format( nearestYear ));
	}

}
