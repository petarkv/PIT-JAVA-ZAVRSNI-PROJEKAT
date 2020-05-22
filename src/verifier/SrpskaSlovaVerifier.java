package verifier;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SrpskaSlovaVerifier extends InputVerifier {

	@Override
	public boolean verify(JComponent input) {
		Boolean ret = false;
		try {
			Pattern pattern = Pattern.compile("[a-zA-ZčČćĆžŽđĐšŠ\\s]+");
			Matcher matcher = pattern.matcher(((JTextField) input).getText());

			if (matcher.matches()) {
				ret = true;
			}
		} catch (Exception e) {
		}
		
		if(!ret)
		{
			JOptionPane.showMessageDialog(null, "Morate uneti slovo!");
		}
		return ret;
	}
}