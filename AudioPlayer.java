import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioPlayer {
	void playAudio(String musicDir) {
		try {
			File musicPath = new File(musicDir);
			
			if(musicPath.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
			}
			else {
				System.out.println("File not found");
			}
			
		}
		catch(Exception ex) {
			System.out.println("Error occured");
		}
	}
}
