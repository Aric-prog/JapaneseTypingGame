import java.awt.*;

import javax.swing.*;
public class GUI extends JFrame{
	
	// Object to convert Japanese text to alphabet
	private SyllabaryToRomaji converter = new SyllabaryToRomaji();

	// Text to store the current word in romaji
	private String romajiText = "type this to start";
	
	// Initializes all of the text field and it's colors
	private TextLabel Furigana = new TextLabel(Color.white,"");
	private TextLabel Kanji = new TextLabel(Color.white,"");
	private TextLabel Meaning = new TextLabel(Color.white,"Press 'esc' to exit");
	private TextLabel romajiDisplay = new TextLabel(new Color(100,100,100),romajiText);
	private TextLabel WPM = new TextLabel(Color.white,"KPM : 0");
	
 	GUI(String title) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel container = new JPanel();

		BoxLayout bl = new BoxLayout(container, BoxLayout.Y_AXIS);
		container.setLayout(bl);
		setSize(1024,768);
		
		container.setBackground(new Color(32,32,32));
		container.setFont(new Font("serif", Font.PLAIN, 64));
		WPM.setFont(new Font("serif", Font.PLAIN, 36));
		Meaning.setFont(new Font("serif", Font.PLAIN, 36));
		Furigana.setFont(new Font("serif", Font.PLAIN, 36));
		
		container.add(Box.createRigidArea(new Dimension(0,(int) (getHeight() * 0.2))));
		
		container.add(WPM);
		container.add(new SeparatorLine());
		container.add(Furigana);
		container.add(Kanji);
		container.add(Meaning);
		container.add(new SeparatorLine());

		container.add(Box.createRigidArea(new Dimension(0,(int) (getHeight() * 0.05))));

		container.add(romajiDisplay);
		
		add(container);
        setResizable(false);
        setVisible(true);
	}
	
	public String getRomaji() {
		return romajiText;
	}
	public void setRomaji(String s) {
		romajiText = s;
	}
	
	public void updateRomajiDisplay() {
		// Checks if the text is less than one word so that it doesn't cause IndexOutOfBounds
		if(this.romajiText.length() <= 1) {
			romajiDisplay.setText("<html><p style ='color : white'>" + this.romajiText);
		} else {
			// Changes the color of the first letter, and leaves the rest as default
			romajiDisplay.setText("<html>" +
					"<span style ='color : white'>" + this.romajiText.charAt(0)+"</span>" + this.romajiText.substring(1) +
					"</html>");	
			// Re-set the alignment as html will wrap to the left
			romajiDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		}
	}
	
	public String getKanji() {
		return Kanji.getText();
	}
	public void setKanji(String s) {
		Kanji.setText(s);
	}
	
	public String getFuri() {
		return Furigana.getText();
	}
	public void setFuri(String s) {
		Furigana.setText(s);
	}
	
	public String getMeaning(){
		return Meaning.getText();
	}
	public void setMeaning(String s) {
		Meaning.setText(s);
	}
	
	public void setWPM(String s) {
		WPM.setText("KPM : " + s);
	}
	
	public void setWord(Word newWord) {
//		Changes the romajiText and display the newly changed text
		setRomaji(converter.convert(newWord.getFuri()));
		updateRomajiDisplay();
		setKanji(newWord.getKanji());
		setFuri(newWord.getFuri());
		setMeaning(newWord.getMeanings());
	}
}
