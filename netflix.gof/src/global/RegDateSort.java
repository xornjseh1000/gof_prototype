package global;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

import video.VideoBigBean;

public class RegDateSort implements Comparator<VideoBigBean> {

	@Override
	public int compare(VideoBigBean first, VideoBigBean second) {
		int result =0;
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Date firstDate,secondDate;
		try {
			firstDate = format.parse(first.getRegDate());
			secondDate = format.parse(second.getRegDate());
			result = firstDate.compareTo(secondDate);
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return result;
	}
	
}
