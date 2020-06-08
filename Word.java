
public class Word {
	private String JLPTLevel;
	private String kanji;
	private String furi;
	private String meanings;
		
	Word(String JLPTLevel, String kanji, String furi, String meanings){
		this.JLPTLevel = JLPTLevel;
		this.kanji = kanji;
		this.furi = furi;
		this.meanings = meanings;
	}
	
	public String getJLPTLevel() {
		return JLPTLevel;
	}
	public void setJLPTLevel(String JLPTLevel) {
		this.JLPTLevel = JLPTLevel;
	}
	
	public String getKanji() {
		return kanji;
	}
	public void setKanji(String kanji) {
		this.kanji = kanji;
	}
	
	public String getFuri() {
		return furi;
	}

	public void setFuri(String furi) {
		this.furi = furi;
	}

	public String getMeanings() {
		return meanings;
	}
	public void setMeanings(String meanings) {
		this.meanings = meanings;
	}
}
