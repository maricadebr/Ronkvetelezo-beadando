package hu.nagymarica.ova4i6.ronkvetelezo.view;

import hu.nagymarica.ova4i6.ronkvetelezo.controller.Szamitas;
import  hu.nagymarica.ova4i6.ronkvetelezo.model.*;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.FlowLayout;
import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import java.awt.Dimension;

import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


/**
 * A főablak felületét reprezentáló osztáy.
 *
 */
public class Ronkvetelezo {
	
	/**
	 * Az osztályban használt logger.
	 * @see <a href="http://www.slf4j.org/api/org/slf4j/Logger.html">SLF4J API</a>
	 */
	private static Logger logger = LoggerFactory.getLogger(Ronkvetelezo.class);
	
	/**
	 * Egy vásárló, melyet a {@link hu.nagymarica.ova4i6.ronkvetelezo.model.Vasarlo} osztály valósít meg.
	 */
	static Vasarlo v;
	/**
	 * Egy vásárlás, melyet a {@link hu.nagymarica.ova4i6.ronkvetelezo.model.Vasarlas} osztály valósít meg.
	 */
	private Vasarlas vasarlas;
	/**
	 * Egy rönk, melyet a {@link hu.nagymarica.ova4i6.ronkvetelezo.model.Ronk} osztály valósít meg.
	 */
	private Ronk r;
	/**
	 * A vételezett rönköket tartalmazó lista.
	 */
	private List<Ronk> felvettRonkok = new ArrayList<Ronk>();
	
	/**
	 * Az főablak felületét megvalósító frame.
	 */
	private JFrame frame;

	/**
	 * A tetelKivalasztPanel egy cimkéje, amely a "Tétel kiválasztása:" feliratot jeleníti meg.
	 */
	private JLabel valasztasCimke;
	/**
	 * A kozepsoPanel egy cimkéje, amely a kiválasztott fafaj megnevezését jeleníti meg.
	 */
	private JLabel fafajCimke;
	/**
	 * A felvetelPanel egy cimkéje, amely a "Átmerő:" feliratot jeleníti meg.
	 */
	private JLabel atmeroCimke;
	/**
	 * A felvetelPanel egy cimkéje, amely a "Hossz:" feliratot jeleníti meg.
	 */
	private JLabel hosszCimke;
	/**
	 * A felvetelPanel egy cimkéje, amely a "Mennyiség:" feliratot jeleníti meg.
	 */
	private JLabel mennyisegCimke;
	/**
	 * A kozepsoPanel egy cimkéje, amely a "VÁSÁRLÓ ADATAI" feliratot jeleníti meg.
	 */
	static JLabel vasarloAdataiCimke;
	/**
	 * A alsoPanel egy cimkéje, amely a "Az összes térfogat:" feliratot jeleníti meg.
	 */
	private JLabel osszesTerfogatCimke1;
	/**
	 * A alsoPanel egy cimkéje, amely a vásárló által vételezett rönkök össztérfogatát jeleníti meg.
	 */
	private JLabel osszesTerfogatCimke2;
	/**
	 * A alsoPanel egy cimkéje, amely a "A fizetendő összeg:" feliratot jeleníti meg.
	 */
	private JLabel fizetendoOsszegCimke1;
	/**
	 * A alsoPanel egy cimkéje, amely a vásárló által vételezett rönkök költségét jeleníti meg.
	 */
	private JLabel fizetendoOsszegCimke2;
	
	/**
	 * Az rönk átmérőjének megadásához szükséges mező.
	 */
	private JTextField atmeroMezo;
	/**
	 * Az rönk hosszúságának megadásához szükséges mező.
	 */
	private JTextField hosszMezo;
	/**
	 * Az rönk darabszámának megadásához szükséges mező.
	 */
	private JTextField mennyisegMezo;
	
	/**
	 * A rönk fafajának kivalásztását segítő elem.
	 */
	private JComboBox<String> comboBox;
	
	/**
	 * A felület Új vásárló gombaja.
	 */
	static JButton ujVasarloGomb;
	/**
	 * A felület Új Tétel gombaja.
	 */
	static JButton ujTetelGomb;
	/**
	 * A felület Felvétel gombaja.
	 */
	private JButton felvetelGomb;
	/**
	 * A felület Tétel elvetése gombaja.
	 */
	private JButton tetelElveteseGomb;
	/**
	 * A felület Vételezés befejezése gombaja.
	 */
	private JButton vetelezesBefejezesGomb;
	/**
	 * A felület Vásárlás vége gombaja.
	 */
	static JButton vasarlasVegeGomb;
	
	/**
	 * A táblazat görgethetőségét megvalósító JScrollPane.
	 */
	private JScrollPane scrollPane;
	/**
	 * A vételezett rönköket tartalmazó táblázat.
	 */
	private JTable table;
	/**
	 * A JTable megvalósításást segítő TableModel.
	 */
	private DefaultTableModel dtm;
	
	
	/**
	 * A felület felsoPanel-je.
	 */
	private JPanel felsoPanel;
	/**
	 * A felület tetelKivalasztPanel-je.
	 */
	private JPanel tetelKivalasztPanel;
	/**
	 * A felület felvetelPanel-je.
	 */
	private JPanel felvetelPanel;
	/**
	 * A felület kozepsoPanel-je.
	 */
	private JPanel kozepsoPanel;
	/**
	 * A felület alsoPanel-je.
	 */
	private JPanel alsoPanel;
	/**
	 * A felület befejezPanel-je.
	 */
	private JPanel befejezPanel;
	
	/**
	 * A felsoPanel-ban található tetelKivalasztPanel-t és felvetelPanel-t tartalmazza.
	 */
	private JSplitPane splitPane;
	/**
	 * Az alsoPanel-ben található vetelezesBefejezesGomb-ot és vasarlasVegeGomb-ot tartalmazza.
	 */
	private JSplitPane splitPane_1;
	
	/**
	 * A felület Új Tétel gombaját adja vissza.
	 * @return Új Tétel gomb
	 */
	public JButton getUjTetelGomb() {
		return ujTetelGomb;
	}

	/**
	 * A felület megjelenítését segítő metódus.
	 */
	public void ablakMegjelenites() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Ronkvetelezo window = new Ronkvetelezo();
					Ronkvetelezo.this.frame.setVisible(true);
					Ronkvetelezo.this.frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
					logger.error("Hiba történt");
				}
			}
		});
	}

	/**
	 * Konstruktor a felület létrehozásához.
	 */
	public Ronkvetelezo() {
		logger.info("Készít egy Ronkvetelezo-t.");
		initialize();
	}
	
	/**
	 * Inizializál az új frame tartalmát.
	 */
	private void initialize() {
		JOptionPane.showMessageDialog(null, "Üdvözlöm! Kellemes vásárlást kívánok! :)", "Rönkvételező",-1);
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				Szamitas.kapcsolatBezarasa();
				logger.info("Adatbázis kapcsolat lezárása, a felhasználó kilépett az alkalmazásból");
			}
		});
		frame.setBounds(350, 150, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Rönkvételező");
		//-------------------------------------------------------------------
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		felsoPanel = new JPanel();
		kozepsoPanel = new JPanel();
		alsoPanel = new JPanel();
		
		frame.getContentPane().add(felsoPanel, BorderLayout.NORTH);
		frame.getContentPane().add(kozepsoPanel, BorderLayout.CENTER);
		frame.getContentPane().add(alsoPanel, BorderLayout.SOUTH);
		frame.getContentPane().add(Box.createHorizontalStrut(20), BorderLayout.WEST);
		frame.getContentPane().add(Box.createHorizontalStrut(20), BorderLayout.EAST);
		
		kozepsoPanel.setLayout(new BorderLayout(0, 0));
		alsoPanel.setLayout(new FlowLayout(FlowLayout.TRAILING, 5, 5));
		
		splitPane = new JSplitPane();
		splitPane.setDividerSize(0);
		splitPane.setBorder(null);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		felsoPanel.add(splitPane);
		
		felvetelPanel = new JPanel();
		tetelKivalasztPanel = new JPanel();
		splitPane.setRightComponent(felvetelPanel);
		splitPane.setLeftComponent(tetelKivalasztPanel);
		
		atmeroCimke = new JLabel("Átmérő:");
		atmeroMezo = new JTextField();
		atmeroMezo.setColumns(5);
		atmeroMezo.setEnabled(false);
		
		hosszCimke = new JLabel("Hossz:");
		hosszMezo = new JTextField();
		hosszMezo.setColumns(5);
		hosszMezo.setEnabled(false);
		
		mennyisegCimke = new JLabel("Mennyiség:");
		mennyisegMezo = new JTextField();
		mennyisegMezo.setColumns(5);
		mennyisegMezo.setEnabled(false);
		
		felvetelGomb = new JButton("Felvétel");
		felvetelGomb.setEnabled(false);
		
		felvetelPanel.add(atmeroCimke);
		felvetelPanel.add(atmeroMezo);
		felvetelPanel.add(Box.createHorizontalStrut(20));
		felvetelPanel.add(hosszCimke);
		felvetelPanel.add(hosszMezo);
		felvetelPanel.add(Box.createHorizontalStrut(20));
		felvetelPanel.add(mennyisegCimke);
		felvetelPanel.add(mennyisegMezo);
		felvetelPanel.add(Box.createHorizontalStrut(20));
		felvetelPanel.add(felvetelGomb);
		
		ujVasarloGomb = new JButton("Új vásárló");
		
		ujTetelGomb = new JButton("Új Tétel");
		ujTetelGomb.setEnabled(false);
		
		valasztasCimke = new JLabel("Tétel kiválasztása:");
		
		comboBox = new JComboBox(Szamitas.getFajok().toArray(new String[0]));
		comboBox.setBackground(Color.WHITE);
		comboBox.setPreferredSize(new Dimension(120, 20));
		comboBox.setEnabled(false);
		
		tetelElveteseGomb = new JButton("Tétel elvetése");
		tetelElveteseGomb.setEnabled(false);
		
		tetelKivalasztPanel.add(ujVasarloGomb);
		tetelKivalasztPanel.add(ujTetelGomb);
		tetelKivalasztPanel.add(Box.createHorizontalStrut(20));
		tetelKivalasztPanel.add(valasztasCimke);
		tetelKivalasztPanel.add(comboBox);
		tetelKivalasztPanel.add(Box.createHorizontalStrut(20));
		tetelKivalasztPanel.add(tetelElveteseGomb);
		
		vasarloAdataiCimke = new JLabel("VÁSÁRLÓ ADATAI - jelenleg nincs vásárló");
		
		fafajCimke = new JLabel("");
		fafajCimke.setFont(new Font("Tahoma", Font.BOLD, 17));
		fafajCimke.setPreferredSize(new Dimension(50, 25));
		fafajCimke.setHorizontalTextPosition(SwingConstants.CENTER);
		fafajCimke.setHorizontalAlignment(SwingConstants.CENTER);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setPreferredScrollableViewportSize(new Dimension(450, 400));
		
		dtm = new DefaultTableModel(){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}		
			
		};
	
		String[] fejlec = new String[]{"Átmerő (cm)","Hossz (m)","Térfogat (m3)",
				"Mennyiség (db)","Össztérfogat (m3)"};
		dtm.setColumnIdentifiers(fejlec);
		
		table.setModel(dtm);
		table.getTableHeader().setReorderingAllowed(false);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(550, 330));
		
		kozepsoPanel.add(vasarloAdataiCimke, BorderLayout.SOUTH);
		kozepsoPanel.add(fafajCimke, BorderLayout.NORTH);
		kozepsoPanel.add(scrollPane);
			
		osszesTerfogatCimke1 = new JLabel("Az összes térfogata:");
		osszesTerfogatCimke2 = new JLabel("0");
		fizetendoOsszegCimke1 = new JLabel("Fizetendő összeg:");
		fizetendoOsszegCimke2 = new JLabel("0");	
		befejezPanel = new JPanel();
		
		alsoPanel.add(osszesTerfogatCimke1);
		alsoPanel.add(osszesTerfogatCimke2);
		alsoPanel.add(Box.createHorizontalStrut(20));
		alsoPanel.add(fizetendoOsszegCimke1);
		alsoPanel.add(fizetendoOsszegCimke2);
		alsoPanel.add(Box.createHorizontalStrut(20));
		alsoPanel.add(befejezPanel);
		
		vetelezesBefejezesGomb = new JButton("Vételezés befejezése");
		vetelezesBefejezesGomb.setEnabled(false);
		
		vasarlasVegeGomb = new JButton("Vásárlás vége");
		vasarlasVegeGomb.setEnabled(false);
		
		splitPane_1 = new JSplitPane();
		splitPane_1.setBorder(null);
		splitPane_1.setDividerSize(0);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_1.setLeftComponent(vetelezesBefejezesGomb);
		splitPane_1.setRightComponent(vasarlasVegeGomb);
		befejezPanel.add(splitPane_1);
		
		
		
		ujVasarloGomb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v = new Vasarlo();
				UjVasarlo uj = new UjVasarlo();
				uj.ablakMegjelenites();
				vasarlas = new Vasarlas();
				
			}
		});
		
		ujTetelGomb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				vasarlasVegeGomb.setEnabled(false);
				comboBox.setEnabled(true);
				fafajCimke.setText("");
				int sorokSzama = dtm.getRowCount();
				for (int i = sorokSzama - 1; i >= 0; i--) {
					dtm.removeRow(i);
				}
				felvettRonkok.clear();
				
				dtm.fireTableDataChanged();
				
				osszesTerfogatCimke2.setText("0");
				fizetendoOsszegCimke2.setText("0");
				table.setEnabled(true);

				vasarlas.setVasarlas_azon(Szamitas.vasarolAzonKov());
				logger.info("A vásárló új tételt kíván felvenni.");
			}
		});
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox = (JComboBox<String>) e.getSource();
				String currentQuantity = (String) comboBox.getSelectedItem();
				
				r = new Ronk(Szamitas.getFajAzon(currentQuantity));
				
				vasarlas.setFaj_azon(r.getFajAzon());
				vasarlas.setVasarlo_azon(v.getSzemIgSzam());
				
				fafajCimke.setText(currentQuantity.toUpperCase());
				table.setFillsViewportHeight(true);
				
				atmeroMezo.setEnabled(true);
				hosszMezo.setEnabled(true);
				mennyisegMezo.setEnabled(true);
				
				felvetelGomb.setEnabled(true);
				comboBox.setEnabled(false);
				tetelElveteseGomb.setEnabled(true);
				ujTetelGomb.setEnabled(false);
				vetelezesBefejezesGomb.setEnabled(true);
				
				logger.info("A vásárló kíválasztott a fafajt: {}", r.getFajAzon());
				
			}
		});

		felvetelGomb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean rossz = true;
				String[] hibak = Szamitas.ronkAdatokEllenorzes(atmeroMezo.getText(), hosszMezo.getText(), mennyisegMezo.getText());
				
				if(hibak[0]==null && hibak[1]==null && hibak[2]==null && 
						hibak[3]==null && hibak[4]==null && hibak[5]==null && hibak[6]==null){
					rossz= true;
				} else {
					for (String s : hibak) {
						if (s!=null)
							JOptionPane.showMessageDialog(null,s,"Hiba!",2);
						rossz = false;
					}
				}
			
				if(rossz){
					Ronk r2 = new Ronk(r.getFajAzon());
					r2.setAtmero(Integer.parseInt(atmeroMezo.getText()));
					r2.setHossz(Szamitas.egytizedesJegyesKerekites(Double.parseDouble(hosszMezo.getText())));
					r2.setMennyiseg(Integer.parseInt(mennyisegMezo.getText()));
					
					double adottTerfogat = 
							Szamitas.getAdottRonkTerfogata(r2.getAtmero(), r2.getHossz(),
									Szamitas.melyikSE(r2.getFajAzon(), r2.getAtmero()));
					
					boolean volt = false;
					for (Ronk ronk : felvettRonkok) {
						if(ronk.equals(r2)){
							int regiMennyiseg = ronk.getMennyiseg();
							ronk.setMennyiseg(regiMennyiseg + r2.getMennyiseg());
							volt = true;
						}
					}
					
					if(!volt) {
						felvettRonkok.add(r2);
						
						dtm.addRow(new Object[]{r2.getAtmero()+" cm", r2.getHossz()+" m",
								adottTerfogat, r2.getMennyiseg(),
								Szamitas.getAdottRonkOsszTerfogata(Integer.parseInt(mennyisegMezo.getText()), adottTerfogat)});
						logger.info("Egy új sor hozzáfűzése a táblázathoz.");
					} else {
						for (int i = 0; i < dtm.getRowCount(); i++) {
							dtm.setValueAt(new Integer(felvettRonkok.get(i).getMennyiseg()), i, 3);
							dtm.setValueAt(new Double(
									Szamitas.getAdottRonkOsszTerfogata(
											(Integer) dtm.getValueAt(i, 3), 
											(Double) dtm.getValueAt(i, 2))
									), i, 4);
						}
						table.repaint();
						logger.info("A táblázat frissítése.");
					}
					
					List<Double> lista = new ArrayList<Double>();
					for (int i = 0; i < dtm.getRowCount(); i++) {
						lista.add((Double)dtm.getValueAt(i, 4));
					}
					
					Double terfogat = Szamitas.getOsszTerfogat(lista);
					osszesTerfogatCimke2.setText(terfogat.toString());
					logger.info("Frissült az össztérfogat értéke: {}", osszesTerfogatCimke2.getText());
					
					Integer fizetni = Szamitas.fizetendoOsszeg(
											Double.parseDouble(osszesTerfogatCimke2.getText()),
											r.getFajAzon());
					fizetendoOsszegCimke2.setText(fizetni.toString());
					logger.info("Frissült az fizetendő összeg értéke: {}", fizetendoOsszegCimke2.getText());		
				} 
			}
		
		});
		
		tetelElveteseGomb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atmeroMezo.setEnabled(false);
				atmeroMezo.setText("");
				hosszMezo.setEnabled(false);
				hosszMezo.setText("");
				mennyisegMezo.setEnabled(false);
				mennyisegMezo.setText("");
				felvetelGomb.setEnabled(false);
				ujTetelGomb.setEnabled(true);
				tetelElveteseGomb.setEnabled(false);
				fafajCimke.setText("");
				osszesTerfogatCimke2.setText("0");
				fizetendoOsszegCimke2.setText("0");
				
				int sorokSzama = dtm.getRowCount();
				for (int i = sorokSzama - 1; i >= 0; i--) {
					dtm.removeRow(i);
				}
				felvettRonkok.clear();
				
				dtm.fireTableDataChanged();
				
				vasarlas = new Vasarlas();
				
				logger.info("A vásárló elvetette a tételt.");
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					table = (JTable) e.getSource();
					int sorTorles = table.getSelectedRow();
					if(sorTorles > -1){
						dtm.removeRow(sorTorles);
						dtm.fireTableDataChanged();
					
						felvettRonkok.remove(sorTorles);
					}
										
					List<Double> lista = new ArrayList<Double>();
					for (int i = 0; i < dtm.getRowCount(); i++) {
						lista.add((Double)dtm.getValueAt(i, 4));
					}
					
					Double terfogat = Szamitas.getOsszTerfogat(lista);
					osszesTerfogatCimke2.setText(terfogat.toString());
					logger.info("Frissült az össztérfogat értéke: {}", osszesTerfogatCimke2.getText());
					
					Integer fizetni = Szamitas.fizetendoOsszeg(
											Double.parseDouble(osszesTerfogatCimke2.getText()),
											r.getFajAzon());
					fizetendoOsszegCimke2.setText(fizetni.toString());
					logger.info("Frissült az fizetendő összeg értéke: {}", fizetendoOsszegCimke2.getText());
				}
			}
			
		});
		
		vetelezesBefejezesGomb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				atmeroMezo.setEnabled(false);
				atmeroMezo.setText("");
				hosszMezo.setEnabled(false);
				hosszMezo.setText("");
				mennyisegMezo.setEnabled(false);
				mennyisegMezo.setText("");
				
				felvetelGomb.setEnabled(false);
				tetelElveteseGomb.setEnabled(false);
				ujTetelGomb.setEnabled(true);
				vetelezesBefejezesGomb.setEnabled(false);
				vasarlasVegeGomb.setEnabled(true);
				
				table.setEnabled(false);
				felvettRonkok.clear();
				
				vasarlas.setVasarolt_kobmeter(Double.parseDouble(osszesTerfogatCimke2.getText()));
				vasarlas.setFizetendo_osszeg(Szamitas.fizetendoOsszeg(Double.parseDouble(osszesTerfogatCimke2.getText()), 
						r.getFajAzon()));
				
				if(vasarlas.getVasarolt_kobmeter() > 0) {
					Szamitas.feltoltes(v, vasarlas);
				} 
				else {
					logger.info("Nincs lementhető tétel");
				}
			}
		});

		vasarlasVegeGomb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ujTetelGomb.setEnabled(false);
				ujVasarloGomb.setEnabled(true);
				vasarlasVegeGomb.setEnabled(false);
				
				vasarloAdataiCimke.setText("VÁSÁRLÓ ADATAI - jelenleg nincs vásárló");
				osszesTerfogatCimke2.setText("0");
				fizetendoOsszegCimke2.setText("0");
				fafajCimke.setText("");
				
				int sorokSzama = dtm.getRowCount();
				for (int i = sorokSzama - 1; i >= 0; i--) {
					dtm.removeRow(i);
				}
				felvettRonkok.clear();
				dtm.fireTableDataChanged();
				logger.info("A vásárló befejezte a vásárlást");
			}
		});
		
		
			
	}	
	
	

}
