/**
 * 
 */
package model;

/**
 * @author
 *
 */
public class Video  {
	
	private String nombre;
	private String url;
	private int duration; // en seg
	private String artist;
	private String gender; 
	private int clasifitation; // 1 - 10
	
	public Video(String nombre, String url, int duration, String artist, String gender) {
		super();
		this.nombre = nombre;
		this.url = url;
		this.duration = duration;
		this.artist = artist;
		this.gender = gender;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getClasifitation() {
		return clasifitation;
	}

	public void setClasifitation(int clasifitation) {
		this.clasifitation = clasifitation;
	}

	@Override
	public String toString() {
		return "Video [nombre=" + nombre + ", url=" + url + ", duration=" + duration + ", artist=" + artist
				+ ", gender=" + gender + ", clasifitation=" + clasifitation + "]";
	}
	
}
