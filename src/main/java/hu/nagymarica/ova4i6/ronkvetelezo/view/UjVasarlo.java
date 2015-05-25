package hu.nagymarica.ova4i6.ronkvetelezo.view;

import hu.nagymarica.ova4i6.ronkvetelezo.controller.Szamitas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;


import javax.swing.JButton;
import javax.swing.SwingConstants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Az alkalmazás grafikus felületét megvalósító osztály.
 */
public class UjVasarlo{
	
	/**
	 * Az osztályban használt logger.
	 * @see <a href="http://www.slf4j.org/api/org/slf4j/Logger.html">SLF4J API</a>
	 */
	private static Logger logger = LoggerFactory.getLogger(UjVasarlo.class);
	
	/**
	 * Az felületet megvalósító frame.
	 */
	private JFrame frame;

	/**
	 * A felület contentPane-je.
	 */
	private JPanel contentPane;
	
	/**
	 * A felület cimkéjit tartalmató panel.
	 */
	private JPanel cimkekPanel;
	
	/**
	 * A felület cimkéjit tartalmató panel.
	 */
	private JPanel mezokPanel;
	
	/**
	 * A felület gombjait tartalmazó panel.
	 */
	private JPanel gombokPanel;
	
	/**
	 * A cimkekPanel egy cimkéje, amely a "Szem. ig. szám:" feliratot jeleníti meg.
	 */
	private JLabel szemIgSzamCimke;
	/**
	 * A cimkekPanel egy cimkéje, amely a "Szem. ig. szám:" feliratot jeleníti meg.
	 */
	private JLabel nevCimke;
	/**
	 * A cimkekPanel egy cimkéje, amely a "Név:" feliratot jeleníti meg.
	 */
	private JLabel iranyitoszamCimke;
	/**
	 * A cimkekPanel egy cimkéje, amely a "Város:" feliratot jeleníti meg.
	 */
	private JLabel varosCimke;
	/**
	 * A cimkekPanel egy cimkéje, amely a "Utca:" feliratot jeleníti meg.
	 */
	private JLabel utcaCimke;
	/**
	 * A cimkekPanel egy cimkéje, amely a "Házszám:" feliratot jeleníti meg.
	 */
	private JLabel hazszamCimke;
	
	/**
	 * A személyigazolvány szám megadásához szükséges mező.
	 */
	private JTextField szemIgSzamMezo;
	/**
	 * A vásárló nevének megadásához szükséges mező.
	 */
	private JTextField nevMezo;
	/**
	 * Az irányítószám megadásához szükséges mező.
	 */
	private JTextField iranyitoszamMezo;
	/**
	 * A város megadásához szükséges mező.
	 */
	private JTextField varosMezo;
	/**
	 * Az utca nevének megadásához szükséges mező.
	 */
	private JTextField utcaMezo;
	/**
	 * A házszám megadásához szükséges mező.
	 */
	private JTextField hazszamMezo;
	
	/**
	 * A felület OK gombja.
	 */
	private JButton okGomb;
	/**
	 * A felület Mégse gombja.
	 */
	private JButton megseGomb;

	/**
	 * A felület OK gomját adja vissza.
	 * @return OK gomb
	 */
	public JButton getOkGomb() {
		return okGomb;
	}
	
	/**
	 * A felület Mégse gomját adja vissza.
	 * @return Mégse gomb
	 */
	public JButton getMegseGomb() {
		return megseGomb;
	}

	/**
	 * A felület frame-jét adja vissza.
	 * @return frame
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * A felület megjelenítését segítő metódus.
	 */
	public void ablakMegjelenites() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UjVasarlo.this.frame.setVisible(true);
					UjVasarlo.this.frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
					logger.error("Dob egy hibát.");
				}
			}
		});
	}

	/**
	 * Konstruktor a felület létrehozásához.
	 */
	public UjVasarlo(){
		logger.info("Készít egy UjVasarlo-t.");
		initialize();
	}
	
	/**
	 * Inizializál az új frame tartalmát.
	 */
	public void initialize() {
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		Ronkvetelezo.ujVasarloGomb.setEnabled(false);
		frame.setResizable(false);
		frame.setBounds(500, 350, 300, 230);
		
		frame.setTitle("Új vásárló");
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(5,5));
		frame.setContentPane(contentPane);
		
		cimkekPanel = new JPanel(new GridLayout(0, 1, 2, 2));
		mezokPanel = new JPanel(new GridLayout(0, 1, 2, 2));
		gombokPanel = new JPanel();
		
		szemIgSzamCimke = new JLabel("Szem. ig. szám (*):");
		nevCimke = new JLabel("Név (*):");
		iranyitoszamCimke = new JLabel("Irányitószám:");
		varosCimke = new JLabel("Város (*):");
		utcaCimke = new JLabel("Utca:");
		hazszamCimke = new JLabel("Házszám:");
		
		szemIgSzamCimke.setHorizontalAlignment(SwingConstants.RIGHT);
		nevCimke.setHorizontalAlignment(SwingConstants.RIGHT);
		iranyitoszamCimke.setHorizontalAlignment(SwingConstants.RIGHT);
		varosCimke.setHorizontalAlignment(SwingConstants.RIGHT);
		utcaCimke.setHorizontalAlignment(SwingConstants.RIGHT);
		hazszamCimke.setHorizontalAlignment(SwingConstants.RIGHT);

		cimkekPanel.add(szemIgSzamCimke);
		cimkekPanel.add(nevCimke);		
		cimkekPanel.add(iranyitoszamCimke);
		cimkekPanel.add(varosCimke);
		cimkekPanel.add(utcaCimke);
		cimkekPanel.add(hazszamCimke);
		
		szemIgSzamMezo = new JTextField();
		nevMezo = new JTextField();
		iranyitoszamMezo = new JTextField();
		varosMezo = new JTextField();
		utcaMezo = new JTextField();
		hazszamMezo = new JTextField();
		
		mezokPanel.add(szemIgSzamMezo);
		mezokPanel.add(nevMezo);
		mezokPanel.add(iranyitoszamMezo);
		mezokPanel.add(varosMezo);
		mezokPanel.add(utcaMezo);
		mezokPanel.add(hazszamMezo);
		
		szemIgSzamMezo.setColumns(15);
		nevMezo.setColumns(15);
		iranyitoszamMezo.setColumns(15);
		varosMezo.setColumns(15);
		utcaMezo.setColumns(15);
		hazszamMezo.setColumns(15);
		
		okGomb = new JButton("OK");
		okGomb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Szamitas.vasarloAdatokEllenorzes(szemIgSzamMezo.getText(), nevMezo.getText(), 
						iranyitoszamMezo.getText(), varosMezo.getText(), 
						utcaMezo.getText(), hazszamMezo.getText())==null){
					JOptionPane.showMessageDialog(null, "Adja meg a közetelező(*) adatokat!", "Hiányzó adat", 2);
					Ronkvetelezo.ujVasarloGomb.setEnabled(true);
				} else {
					Ronkvetelezo.v = Szamitas.vasarloAdatokEllenorzes(szemIgSzamMezo.getText(), nevMezo.getText(), 
														iranyitoszamMezo.getText(), varosMezo.getText(), 
														utcaMezo.getText(), hazszamMezo.getText());
					Ronkvetelezo.ujTetelGomb.setEnabled(true);
					Ronkvetelezo.ujVasarloGomb.setEnabled(false);
					Ronkvetelezo.vasarlasVegeGomb.setEnabled(true);
					logger.info("Sikeresen felvett egy új vásárló, akinek a neve: {} .", Ronkvetelezo.v.getNev());
					
					StringBuilder sb = new StringBuilder();
					sb.append("VÁSÁRLÓ ADATAI ").append("   Név: ").append(Ronkvetelezo.v.getNev())
						.append("   Sz.Ig.sz: ").append(Ronkvetelezo.v.getSzemIgSzam()).append("   Cím: ")
						.append(Ronkvetelezo.v.getVaros());
					if(Ronkvetelezo.v.getIranyitoszam()!= null)
						sb.append(" ").append(Ronkvetelezo.v.getIranyitoszam());
					if(Ronkvetelezo.v.getUtca()!= null)
						sb.append(" ").append(Ronkvetelezo.v.getUtca());
					if(Ronkvetelezo.v.getHazszam()!=0)
						sb.append(" ").append(Ronkvetelezo.v.getHazszam());
				
					Ronkvetelezo.vasarloAdataiCimke.setText(sb.toString());
				}
				frame.setVisible(false);
			}
		});
		megseGomb = new JButton("Mégse");
		megseGomb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Ronkvetelezo.ujVasarloGomb.setEnabled(true);
				logger.info("A felhasználó a Mégse gombra kattinott.");
			}
		});
		
		gombokPanel.add(okGomb);
		gombokPanel.add(megseGomb);
		
		contentPane.add(cimkekPanel, BorderLayout.CENTER);
		contentPane.add(mezokPanel, BorderLayout.EAST);
		contentPane.add(gombokPanel, BorderLayout.SOUTH);
		
	}
}
