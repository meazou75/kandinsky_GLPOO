import java.net.MalformedURLException;

import ihm.TirageJFrame;
import model.ModeleDynamique;

public class Launcher {

	private static ModeleDynamique modele = new ModeleDynamique();
	
	public static void main(String[] args) throws MalformedURLException {		
		final TirageJFrame f = new TirageJFrame();
		f.setVisible(true);	
	}

}
