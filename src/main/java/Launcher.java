import ihm.TirageJFrame;
import model.ModeleDynamique;

public class Launcher {

	private static ModeleDynamique modele = new ModeleDynamique();
	
	public static void main(String[] args) {
		//System.out.println(modele.getValueAt(2, 0));
		System.out.println(modele.getValueAt(2, 1));
		System.out.println(modele.getValueAt(2, 2));
		System.out.println(modele.getValueAt(2, 3));
		System.out.println(modele.getValueAt(2, 4));
		System.out.println(modele.getValueAt(2, 5));
		System.out.println(modele.getValueAt(2, 6));
		System.out.println(modele.getValueAt(2, 7));
		
		final TirageJFrame f = new TirageJFrame();
		f.setVisible(true);
		
	}

}
