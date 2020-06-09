import java.awt.*;
import javax.swing.*;

public class GUI extends JFrame{
	
	// Object to convert Japanese text to alphabet
	private SyllabaryToRomaji converter = new SyllabaryToRomaji();

	// Text to store the current word in romaji
	private String romajiText = "type this to start";
	
	// Initializes all of the text field
	private TextLabel KPM = new TextLabel(Color.white,"Japanese Typing Game");
	private TextLabel furigana = new TextLabel(Color.white,"");
	private TextLabel kanji = new TextLabel(Color.white,"");
	private TextLabel meaning = new TextLabel(Color.white,"Press 'esc' to exit");
	private TextLabel romajiDisplay = new TextLabel(new Color(100,100,100),romajiText);
	
 	GUI(String title) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel container = new JPanel();

		BoxLayout bl = new BoxLayout(container, BoxLayout.Y_AXIS);
		container.setLayout(bl);
		setSize(1024,768);
		
		container.setBackground(new Color(32,32,32));
		container.setFont(new Font("serif", Font.PLAIN, 36));
		kanji.setFont(new Font("serif", Font.PLAIN, 64));
		romajiDisplay.setFont(new Font("serif", Font.PLAIN, 64));
		
		// Creates an invisible box to create padding
		// Box height is determined by its total height
		container.add(Box.createRigidArea(new Dimension(0,(int) (getHeight() * 0.2))));	

		container.add(KPM);
		container.add(new SeparatorLine());
		container.add(furigana);
		container.add(kanji);
		container.add(meaning);
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
		return kanji.getText();
	}
	public void setKanji(String s) {
		kanji.setText(s);
	}
	
	public String getFuri() {
		return furigana.getText();
	}
	public void setFuri(String s) {
		furigana.setText(s);
	}
	
	public String getMeaning(){
		return meaning.getText();
	}
	public void setMeaning(String s) {
		meaning.setText(s);
	}
	
	public void setKPM(String s) {
		KPM.setText("KPM : " + s);
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
