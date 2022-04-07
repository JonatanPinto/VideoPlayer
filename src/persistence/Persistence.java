package persistence;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import circleList.CirlceList;
import circleList.NodeCircleList;
import model.ManagerVideo;
import model.Video;

public class Persistence {
	
	public static void writeFileTeacher(CirlceList<Video> listRead) throws Exception{
		CirlceList<Video> listVideos = listRead;
		JsonArray list = new JsonArray();
		for (int i = 0; i < listVideos.size(); i++) {
			NodeCircleList<Video> videoaux = listVideos.getHead();
			JsonObject obj = new JsonObject();
			obj.addProperty("NOMBRE",videoaux.getInfo().getNombre());
			obj.addProperty("URL", videoaux.getInfo().getUrl());
			obj.addProperty("DURACION", videoaux.getInfo().getDuration());
			obj.addProperty("ARTISTA", videoaux.getInfo().getArtist());
			obj.addProperty("GENERO", videoaux.getInfo().getGender());
			obj.addProperty("CLASIFICACION", videoaux.getInfo().getClasifitation());
			list.add(obj);
			videoaux = videoaux.getNext();
			
		}
		BufferedWriter bufferedWriter;
		try {
			bufferedWriter = new BufferedWriter(new FileWriter("src/data/angie.json"));
			bufferedWriter.write(list.toString());
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unused")
	private static CirlceList<Video> readStudent(JsonArray jsonArray) throws FileNotFoundException, IOException, ParseException{
		CirlceList<Video> listRead = new CirlceList<Video>();
		for (JsonElement jsonElement : jsonArray) {
			JsonObject objectStudent = jsonElement.getAsJsonObject();
			String nombre = objectStudent.get("NOMBRE").getAsString();
			String url = objectStudent.get("URL").getAsString();
			int duration = objectStudent.get("DURACION").getAsInt();
			String artist = objectStudent.get("ARTISTA").getAsString();
			String gender = objectStudent.get("GENERO").getAsString();
			int clasifiacion = objectStudent.get("CLASIFICACION").getAsInt();
			Video video = new Video(nombre, url, duration, artist, gender);
			video.setClasifitation(clasifiacion);
			listRead.addHead(video);
		}
		return listRead;
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
		
		try {
			Persistence.writeFileTeacher(m.getTopList());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
