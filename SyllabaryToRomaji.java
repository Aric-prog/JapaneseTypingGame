import java.util.HashMap;
import java.util.ArrayList;

public class SyllabaryToRomaji {
	HashMap<Character,String> syllabary = new HashMap<Character,String>();
	
	// Manual input of the hiragana set into the dictionary
	SyllabaryToRomaji(){
		syllabary.put('あ',"a");
		syllabary.put('ぁ',"a");
		syllabary.put('い',"i");
		syllabary.put('ぃ',"i");
		syllabary.put('う',"u");
		syllabary.put('ぅ',"u");
		syllabary.put('え',"e");
		syllabary.put('ぇ',"e");
		syllabary.put('お',"o");
		syllabary.put('ぉ',"o");
		syllabary.put('ゕ',"ka");
		syllabary.put('か',"ka");
		syllabary.put('が',"ga");
		syllabary.put('き',"ki");
		syllabary.put('ぎ',"gi");
		syllabary.put('く',"ku");
		syllabary.put('ぐ',"gu");
		syllabary.put('ゖ',"ke");
		syllabary.put('け',"ke");
		syllabary.put('げ',"ge");
		syllabary.put('こ',"ko");
		syllabary.put('ご',"go");
		syllabary.put('さ',"sa");
		syllabary.put('ざ',"za");
		syllabary.put('し',"shi");
		syllabary.put('じ',"ji");
		syllabary.put('す',"su");
		syllabary.put('ず',"zu");
		syllabary.put('せ',"se");
		syllabary.put('ぜ',"ze");
		syllabary.put('そ',"so");
		syllabary.put('ぞ',"zo");
		syllabary.put('た',"ta");
		syllabary.put('だ',"da");
		syllabary.put('ち',"chi");
		syllabary.put('ぢ',"ji");
		syllabary.put('つ',"tsu");
		syllabary.put('づ',"zu");
		syllabary.put('て',"te");
		syllabary.put('で',"de");
		syllabary.put('と',"to");
		syllabary.put('ど',"do");
		syllabary.put('な',"na");
		syllabary.put('に',"ni");
		syllabary.put('ぬ',"nu");
		syllabary.put('ね',"ne");
		syllabary.put('の',"no");
		syllabary.put('は',"ha");
		syllabary.put('ば',"ba");
		syllabary.put('ぱ',"pa");
		syllabary.put('ひ',"hi");
		syllabary.put('び',"bi");
		syllabary.put('ぴ',"pi");
		syllabary.put('ふ',"fu");
		syllabary.put('ぶ',"bu");
		syllabary.put('ぷ',"pu");
		syllabary.put('へ',"he");	
		syllabary.put('べ',"be");
		syllabary.put('ぺ',"pe");
		syllabary.put('ほ',"ho");
		syllabary.put('ぼ',"bo");
		syllabary.put('ぽ',"po");
		syllabary.put('ま',"ma");
		syllabary.put('み',"mi");
		syllabary.put('む',"mu");
		syllabary.put('め',"me");
		syllabary.put('も',"mo");
		syllabary.put('ゃ',"ya");
		syllabary.put('や',"ya");
		syllabary.put('ゅ',"yu");
		syllabary.put('ゆ',"yu");
		syllabary.put('ょ',"yo");
		syllabary.put('よ',"yo");
		syllabary.put('ら',"ra");
		syllabary.put('り',"ri");
		syllabary.put('る',"ru");
		syllabary.put('れ',"re");
		syllabary.put('ろ',"ro");
		syllabary.put('ゎ',"wa");
		syllabary.put('わ',"wa");	
		syllabary.put('を',"wo");	
		syllabary.put('ん',"n");
		syllabary.put('\u3094',"vu");
	}
	
//	Accepts katakana or hiragana, automatically detects which one
	public String convert(String JPText) {
		// If katakana
		if(JPText.charAt(0) > '\u309F') {
			return convertKata(JPText);
		} else {
			return convertHira(JPText);
		}
	}
	
	public String convertHira(String hiragana){
		String newString = "";
		ArrayList<Character> specialSyll = new ArrayList<Character>();
		
		// Adds several special symbols to the list, these symbols can be pronounced differently based on the letters before it.
		specialSyll.add('っ');
		specialSyll.add('ょ');
		specialSyll.add('ゅ');
		specialSyll.add('ゃ');
		specialSyll.add('ぃ');
		specialSyll.add('ー');
		
		// Loops through the hiragana
		for(int i = 0; i < hiragana.length(); i++) {
			if(specialSyll.contains(hiragana.charAt(i))) {
				if(hiragana.charAt(i) == 'っ') {
					// Gets the first letter of the next char
					newString += syllabary.get(hiragana.charAt(i + 1)).charAt(0);
				} 
				else if(hiragana.charAt(i) == 'ー'){
					newString += newString.charAt(newString.length() - 1);
				}
				else{
					if(hiragana.charAt(i - 1) == 'ち' || hiragana.charAt(i - 1) == 'し' || hiragana.charAt(i - 1) == 'じ')
						newString = newString.substring(0,newString.length() - 1) + syllabary.get(hiragana.charAt(i)).charAt(1);
					else
						newString = newString.substring(0,newString.length() - 1) + syllabary.get(hiragana.charAt(i));					
				}
			}
			else 
				newString += syllabary.get(hiragana.charAt(i));		
		}
		return newString;
	}
	public String convertKata(String kata){
		String newString = convertHira(convertKataToHira(kata));
		return newString;
	}
	
	public String convertKataToHira(String kata) {
		String hiragana = "";
		for(int i = 0; i < kata.length(); i++) {
			if(kata.charAt(i) == 'ー') {
				hiragana += kata.charAt(i);
			} else {	
				hiragana += ((char)(kata.charAt(i) - 96));				
			}
		}
		return hiragana;
	}
}
