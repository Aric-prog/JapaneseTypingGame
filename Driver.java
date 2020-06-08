import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Driver{
	public static void main(String[] args){
		AudioPlayer audio = new AudioPlayer();
		KPM KPM = new KPM();
		
		// Initializes a list of word, with the directory as an argument 
		Vocabulary vb = new Vocabulary("src/data.csv");
		
		// Creates the gui, and sets the title 
		GUI ui = new GUI("Japanese Typing Game");
		
		// KeyListener is on main so that I can access Vocabulary and update the text accordingly
		ui.addKeyListener(
			new KeyListener() {

			// A thread that will receive input
			boolean started = false;
			@Override
			public void keyPressed(KeyEvent key) {
				// Checks if the key typed is equal to the first character of the romajiText
				if(Character.toLowerCase((char) key.getKeyCode()) == (int) ui.getRomaji().charAt(0)) {
					ui.setRomaji(ui.getRomaji().substring(1));
					ui.updateRomajiDisplay();
					if(started)	 {
						KPM.setWordTyped(1);							
					}
				}

				// 	Terminates program if the user press escape
				else if(key.getKeyCode() == KeyEvent.VK_ESCAPE) {
					System.exit(0);
				}
				
				// If the word has been typed to completion, update the KPM and change the word.
				if(ui.getRomaji().equals("")) {
					audio.playAudio("src/Jingle.wav");
					Word newWord = vb.getWordAt((int)(Math.random() * vb.size()));
					ui.setWord(newWord);
					
					if(!started) {
						// Starts the time when the user has fully typed the "type this to start"
						KPM.setStartTime(System.currentTimeMillis());
						started = true;
					} else {
						// Time is added to the total time, which will be calculated to get key per minute
						KPM.setTimeElapsed(System.currentTimeMillis());
						ui.setWPM(String.format("%.1f",KPM.getKPM()));
					}
				}
			}
			
			@Override
			// Unused method stubs
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
		});		
	}
	
}