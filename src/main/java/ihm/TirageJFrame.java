package ihm;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.net.MalformedURLException;
import java.net.URL;

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
	
	private ModeleDynamique modele = new ModeleDynamique();
	private final JTable tableau   = new JTable(modele);

	public TirageJFrame() throws MalformedURLException {

		super();
		JWindow window = new JWindow();
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
		
		
		
		setTitle("Liste des tirages");
		setPreferredSize(new Dimension(1068, 576));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		tableau.setBackground(Color.DARK_GRAY);
		tableau.setForeground(Color.WHITE);
		tableau.setRowHeight(25);
		tableau.setFont(new Font("OCR A Extended", Font.PLAIN, 15));
		getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		final JMenu menuFichier = new JMenu("Fichier");
		//menuFichier.addSeparator();
		
		final JMenuItem menuQuitter = new JMenuItem(new QuitterAction("Quitter"));
		menuFichier.add(menuQuitter);
		
		setJMenuBar(menuBar);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(Color.BLACK);
		
		JButton generate = new JButton();
		generate.setBackground(Color.BLACK);
		generate.setForeground(Color.WHITE);
		
		buttonPane.add(new JButton(new AjouterLigneAction()));
		
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		tableau.setAutoCreateRowSorter(true);
		final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableau.getModel());
		tableau.setRowSorter(sorter);
		
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
        final JMenuItem menuSauver = new JMenuItem(new SauverAction("Sauver"));
        menuFichier.add(menuSauver);
        menuFichier.addSeparator();
        final JMenuItem menuQuitter = new JMenuItem(new QuitterAction("Quitter"));
        menuFichier.add(menuQuitter);

        // Menu Edition
        final JMenu menuEdition = new JMenu("Edition");
        menuBar.add(menuEdition);
        final JMenuItem menuAjouter = new JMenuItem(new AjouterLigneAction());
        menuEdition.add(menuAjouter);

        // Menu Affichage
        final JMenu menuAffichage = new JMenu("Affichage");
        menuBar.add(menuAffichage);

        // Menu ?
        final JMenu menuPointInterrogration = new JMenu("?");
        menuBar.add(menuPointInterrogration);
        final JMenuItem menuPreferences = new JMenuItem(new PreferencesAction("Préférences"));
        menuPointInterrogration.add(menuPreferences);
        final JMenuItem menuAPropos = new JMenuItem(new PreferencesAction("A propos"));
        menuPointInterrogration.add(menuAPropos);

        // Ajout a la fenetre
        setJMenuBar(menuBar);
    }
	
	private class SauverAction extends AbstractAction {
        public SauverAction(String texte) {
            super(texte);
        }

        public void actionPerformed(ActionEvent e) {
            // TODO
        }
    }

    private class QuitterAction extends AbstractAction {
        public QuitterAction(String texte) {
            super(texte);
        }

        public void actionPerformed(ActionEvent e) {
            //LOGGER.info("Au revoir");
            System.exit(0);
        }
    }
	
	private class BackAction extends AbstractAction{
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
            //LOGGER.debug("Click sur le bouton ajouter");

            //final AjouterModifierChienActionHandler handler = new AjouterModifierChienActionHandler(modele);
            //AjouterModifierChienJDialog popup = new AjouterModifierChienJDialog(handler);

            //popup.setVisible(true);

            // final Chien idefix = new SimpleChien("Idefix", "Idefix", MALE, LABRADOR, new String[] { "blanc" }, 25.0);
            // modele.ajouterChien(idefix);
        }
    }

    private class PreferencesAction extends AbstractAction {
        public PreferencesAction(String texte) {
            super(texte);
        }

        public void actionPerformed(ActionEvent e) {
            // TODO
        }
    }

    private class AProposAction extends AbstractAction {
        public AProposAction(String texte) {
            super(texte);
        }

        public void actionPerformed(ActionEvent e) {
            // TODO
        }
    }
}
