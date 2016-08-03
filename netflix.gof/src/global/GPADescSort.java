package global;

import java.util.Comparator;

import video.VideoBigBean;

public class GPADescSort implements Comparator<VideoBigBean> {

	@Override
	public int compare(VideoBigBean first, VideoBigBean second) {
		int result = 0;
		if(first.getGpa() > second.getGpa()){
			result = 1;
		}else{
			if(second.getGpa() > first.getGpa()){
				result = -1;
			}
		}
		return result;
	}

}
