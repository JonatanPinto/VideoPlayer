package model;

import java.util.Comparator;
import circleList.CirlceList;
import listaSimple.SimpleList;

public class ManagerVideo {
	
	private SimpleList<Video> completeList;
	private CirlceList<Video> topList;
	private int number;
	
	public ManagerVideo(int number) {
		completeList = new SimpleList<>(new Comparator<Video>() {
			@Override
			public int compare(Video o1, Video o2) {
				return o1.getClasifitation()>o2.getClasifitation()?-1:1;
			}
		});
		topList = new CirlceList<>();
		this.number = number;
	}
	//agrega ordenadamente de mayor a menor
	
	public void addVideo(Video video) {
		completeList.addSort(video);
	}
	
	public void generateRandomClasification() {
		for (int i = 0; i < completeList.size(); i++) {
			completeList.get(i).setClasifitation((int) (Math.random() * 10) + 1);
		}
	}
	
	public void generateTop() {
		generateRandomClasification();
		for (int i = 0; i <number; i++) {
			topList.addHead(completeList.get(i));
		}
	}

	public SimpleList<Video> getCompleteList() {
		return completeList;
	}

	public void setCompleteList(SimpleList<Video> completeList) {
		this.completeList = completeList;
	}

	public CirlceList<Video> getTopList() {
		return topList;
	}

	public void setTopList(CirlceList<Video> topList) {
		this.topList = topList;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public static void main(String[] args) {
		ManagerVideo m = new ManagerVideo(3);
		m.addVideo(new Video("Angie", "", 310, "jfskdlfj", "Rock"));
		m.addVideo(new Video("CESAR", "", 310, "jfskdlfj", "Rock"));
		m.addVideo(new Video("tobias", "", 310, "jfskdlfj", "Rock"));
		m.addVideo(new Video("karla", "", 310, "jfskdlfj", "Rock"));
		m.addVideo(new Video("pinto", "", 310, "jfskdlfj", "Rock"));
		m.addVideo(new Video("alejo", "", 310, "jfskdlfj", "Rock"));
		m.addVideo(new Video("nicolas", "", 310, "jfskdlfj", "Rock"));
		m.addVideo(new Video("fresy", "", 310, "jfskdlfj", "Rock"));
		m.generateTop();
	}
}
