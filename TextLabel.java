import java.awt.Color;
import javax.swing.JLabel;

public class TextLabel extends JLabel {
	TextLabel(){
		super();
		setFont(null);
		setForeground(null);
		setAlignmentX(CENTER_ALIGNMENT);
	}
	TextLabel(Color c,String s){
		super(s);
		setFont(null);
		setForeground(c);
		setAlignmentX(CENTER_ALIGNMENT);
	}
	TextLabel(Color c,String s, int align){
		super(s,align);
		setFont(null);
		setForeground(c);
		setAlignmentX(CENTER_ALIGNMENT);
	}
}
