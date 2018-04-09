import java.net.MalformedURLException;
import org.apache.log4j.Logger;

import ihm.TirageJFrame;

public class Launcher {

	private static final Logger LOGGER = Logger.getLogger(Launcher.class);

	public static void main(String[] args) throws MalformedURLException {	
		LOGGER.debug("Projet GLPOO Kandins'App : DEBUT");
		final TirageJFrame f = new TirageJFrame();
		f.setVisible(true);	
		LOGGER.debug("Projet GLPOO Kandins'App : FIN");
	}

}
