package ihm;

import org.apache.log4j.Logger;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


import model.*;

public class TirageJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(TirageJFrame.class);

	private ModeleDynamique modele = new ModeleDynamique();
	private final JTable tableau   = new JTable(modele);
	private final JSplitPane split;
	private JCanvas canvas;

	public TirageJFrame() throws MalformedURLException {

		super();
		/*JWindow window = new JWindow();
		window.getContentPane().add(
		    new JLabel("", new ImageIcon("231485.jpg"), SwingConstants.CENTER));
		window.setBounds(0, 0, 1068, 576);
		window.setVisible(true);
		try {
		    Thread.sleep(5000);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		window.setVisible(false);
		window.dispose();
		 */


		setTitle("Kandinsk'App");
		setPreferredSize(new Dimension(980,750));
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		tableau.setBackground(Color.WHITE);
		tableau.setForeground(Color.BLACK);
		tableau.setRowHeight(25);
		tableau.setFont(new Font("OCR A Extended", Font.PLAIN, 15));
		getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);


		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(Color.BLACK);

		JButton generate = new JButton();
		generate.setBackground(Color.WHITE);
		generate.setForeground(Color.WHITE);

		final JButton drawButton = new JButton(new DrawAction());
		final JButton saveButton = new JButton(new SaveAction());
		final JButton cleanButton = new JButton(new CleanAction());
		buttonPane.add(drawButton);
		buttonPane.add(saveButton);
		buttonPane.add(cleanButton);
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		tableau.setAutoCreateRowSorter(true);
		final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableau.getModel());
		tableau.setRowSorter(sorter);

		final JScrollPane scroll = new JScrollPane(tableau);
		canvas = new JCanvas();
		split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, canvas, scroll);
		split.setDividerLocation(480);
		split.setEnabled(false);
		getContentPane().add(split, BorderLayout.CENTER);
		ajoutDuMenu();


		pack();
		setLocationRelativeTo(null);
	}

	private void ajoutDuMenu() {
		final JMenuBar menuBar = new JMenuBar();

		// Menu Fichier
		final JMenu menuFichier = new JMenu("Fichier");
		menuBar.add(menuFichier);

		// Sous-menus
		final JMenuItem menuOuvrir = new JMenuItem(new OuvrirAction("Ouvrir"));
		menuFichier.add(menuOuvrir);
		menuFichier.addSeparator();
		final JMenuItem menuQuitter = new JMenuItem(new QuitterAction("Quitter"));
		menuFichier.add(menuQuitter);

		// Menu Edition
		final JMenu menuEdition = new JMenu("Edition");
		menuBar.add(menuEdition);
		final JMenuItem menuAjouter = new JMenuItem(new AjouterLigneAction());
		menuEdition.add(menuAjouter);

		// Menu ?
		final JMenu menuPointInterrogration = new JMenu("?");
		menuBar.add(menuPointInterrogration);
		final JMenuItem menuAPropos = new JMenuItem(new PreferencesAction("A propos"));
		menuPointInterrogration.add(menuAPropos);

		// Ajout a la fenetre
		setJMenuBar(menuBar);
	}

	private class QuitterAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public QuitterAction(String texte) {
			super(texte);
		}

		public void actionPerformed(ActionEvent e) {
			LOGGER.info("Au revoir");
			System.exit(0);
		}
	}

	private class BackAction extends AbstractAction{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private BackAction(String string) {
			super(string);
		}
		public void actionPerformed(ActionEvent arg0) {
			dispose();
			//WelcomeJFrame f = new WelcomeJFrame();
			//f.setVisible(true);
		}

	}
	private class OuvrirAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public OuvrirAction(String texte) {
			super(texte);
		}

		public void actionPerformed(ActionEvent e) {
			// TODO
		}
	}


	// Menu Affichage




	private class AjouterLigneAction extends AbstractAction {

		/**
		 * serialVersionUID
		 */
		private static final long serialVersionUID = 7183768497443802311L;

		private AjouterLigneAction() {
			super("Ajouter");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			LOGGER.debug("Click sur le bouton ajouter");

			final AjouterTirageActionHandler handler = new AjouterTirageActionHandler(modele);
			AjouterTirageJDialog popup = new AjouterTirageJDialog(handler);

			popup.setVisible(true);
		}
	}

	private class DrawAction extends AbstractAction {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public DrawAction() {
			super("Dessiner");
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			LOGGER.debug("Click sur le bouton Dessiner");
			final int[] rows = tableau.getSelectedRows();
			int b1 = 0;
			int b2 = 0;
			int b3 = 0;
			int b4 = 0;
			int b5 = 0;
			int e1 = 0;
			int e2 = 0;
			int fond = 0;
			for (int row : rows) {
				b1 = (b1 + (int)tableau.getValueAt(row, 1));
				b2 = (b2 + (int)tableau.getValueAt(row, 2));
				b3 = (b3 + (int)tableau.getValueAt(row, 3));
				b4 = (b4 + (int)tableau.getValueAt(row, 4));
				b5 = (b5 + (int)tableau.getValueAt(row, 5));
				e1 = (e1 + (int)tableau.getValueAt(row, 6));
				e2 = (e2 + (int)tableau.getValueAt(row, 7));
				fond = (e2 + (int)tableau.getValueAt(row, 7));
			}
			canvas.setB1(b1);
			canvas.setB2(b2);
			canvas.setB3(b3);
			canvas.setB4(b4);
			canvas.setB5(b5);
			canvas.setE1(e1);
			canvas.setE2(e2);
			canvas.repaint();
		}
	}

	private class SaveAction extends AbstractAction {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private SaveAction() {
			super("Sauver");
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			LOGGER.debug("Click sur le bouton Sauver");
			BufferedImage bufferedImage = new BufferedImage(canvas.getWidth(), canvas.getHeight(), BufferedImage.TYPE_INT_RGB);
			canvas.paint(bufferedImage.createGraphics());

			try {
				ImageIO.write(bufferedImage, "png", new File("Image.png"));
			} catch (Exception e) {
				System.out.println("Oups");
			}
		}

	}

	private class CleanAction extends AbstractAction {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public CleanAction() {
			super("Effacer");
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			LOGGER.debug("Click sur le bouton Effacer");
			canvas.setB1(0);
			canvas.setB2(0);
			canvas.setB3(0);
			canvas.setB4(0);
			canvas.setB5(0);
			canvas.setE1(0);
			canvas.setE2(0);
			canvas.repaint();
		}
	}

	private class PreferencesAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public PreferencesAction(String texte) {
			super(texte);
		}

		public void actionPerformed(ActionEvent e) {
			LOGGER.debug("Click sur le bouton préférences");
		}
	}

	private class AProposAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public AProposAction(String texte) {
			super(texte);
		}

		public void actionPerformed(ActionEvent e) {
			LOGGER.debug("Click sur le bouton à propos");
		}
	}
}
