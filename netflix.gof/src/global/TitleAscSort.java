package global;

import java.util.Comparator;

import video.VideoBigBean;

public class TitleAscSort implements Comparator<VideoBigBean>{

	@Override
	public int compare(VideoBigBean first, VideoBigBean second) {
		
		return first.getTitle().compareTo(second.getTitle());
	}

}
