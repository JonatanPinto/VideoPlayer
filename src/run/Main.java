package run;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.mp4.MP4Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp4.Mp4FileReader;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.mp4.Mp4FieldKey;
import org.jaudiotagger.tag.mp4.Mp4Tag;
import org.xml.sax.SAXException;

public class Main {

	public static void main(String[] args) {
		
		
		ArrayList<String> listapath = new ArrayList<>();
		listapath.add("D:\\Jonatán\\Videos\\Films\\Imagine Dragons It's Time.mp4");
		listapath.add("D:\\Jonatán\\Videos\\Films\\Avenged Sevenfold - So far away Sub Español.mp4");
		for (int i = 0; i < listapath.size(); i++) {
			try {
				FileInputStream inputStream;
				File file = new File(listapath.get(i));
				BodyContentHandler handler = new BodyContentHandler();
				Metadata metaData = new Metadata();
				inputStream = new FileInputStream(file);
				ParseContext pcontext = new ParseContext();
				MP4Parser mp4Parser = new MP4Parser();
				mp4Parser.parse(inputStream, handler, metaData);
				String[] metaDataNames = metaData.names();
				for (String name : metaDataNames) {
					System.out.println(name + ": " + metaData.get(name));
				}
				System.out.println(handler.toString());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TikaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}

		
		
	}
}
