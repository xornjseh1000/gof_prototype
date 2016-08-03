package global;

import java.util.Comparator;

import video.VideoBigBean;

public class EpisodeAscSort implements Comparator<VideoBigBean> {

	@Override
	public int compare(VideoBigBean first, VideoBigBean second) {
		int result = 0;
		if(first.getEpisode() > second.getEpisode()){
			result = 1;
		}else{
			if(first.getEpisode() < second.getEpisode()){
				result = -1;
			}
		}
		return result;
	}

}
