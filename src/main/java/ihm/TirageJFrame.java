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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import model.*;

public class TirageJFrame extends JFrame {

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
		
		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(Color.BLACK);
		
		JButton generate = new JButton();
		generate.setBackground(Color.BLACK);
		generate.setForeground(Color.WHITE);
		
		buttonPane.add(generate);
		
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		tableau.setAutoCreateRowSorter(true);
		final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableau.getModel());
		tableau.setRowSorter(sorter);

		build();

		pack();
		setLocationRelativeTo(null);
	}
	
	private void build() {
		JMenuBar menuBar = new JMenuBar();

		/*
		// MENU 1
		JMenu menu1 = new JMenu("Fichier");
		
		JMenuItem test2 = new JMenuItem();
		menu1.add(test2);
		
		JMenuItem backMenu = new JMenuItem();
		menu1.add(backMenu);

		// MENU BAR
		menuBar.add(menu1);*/

		setJMenuBar(menuBar);
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
}
