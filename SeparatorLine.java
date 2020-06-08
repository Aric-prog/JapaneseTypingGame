import java.awt.Dimension;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class SeparatorLine extends JSeparator{
	SeparatorLine(){
		super();
		setOrientation(SwingConstants.HORIZONTAL);
		Dimension d = getPreferredSize();
		d.width = getMaximumSize().width;
		setMaximumSize(d);
	}
}
