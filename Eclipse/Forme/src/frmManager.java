import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import paneli.panelDodajKlijenta;
import paneli.panelDodajUredjaj;
import paneli.panelPregledKlijenata;
import paneli.panelPregledUredjaja;
import paneli.panelTraziKlijenta;
import paneli.panelTraziUredjaj;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class frmManager extends JFrame {
	private JPanel contentPane;
	private JPanel centralniPanel;

	public frmManager() {
		setTitle("Prijavljen kao: Ime Prezime");
		setBounds(100, 100, 743, 550);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(1, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.WHITE));
		contentPane.add(panel_1, BorderLayout.WEST);
		
		JPanel panel = new JPanel();
		
		JPanel panel_2 = new JPanel();
		
		JPanel panel_4 = new JPanel();
		
		JPanel panel_5 = new JPanel();
		
		JButton btnIzvjetaji = new JButton("Izvje\u0161taji");
		btnIzvjetaji.setHorizontalAlignment(SwingConstants.LEFT);
		btnIzvjetaji.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JButton btnZadaci = new JButton("Zadaci");
		btnZadaci.setHorizontalAlignment(SwingConstants.LEFT);
		
		centralniPanel=new JPanel();
		contentPane.add(centralniPanel, BorderLayout.CENTER);
				
		JButton btnNewButton_1 = new JButton("Dodaj ure\u0111aj");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.remove(centralniPanel);
				centralniPanel = new panelDodajUredjaj();
				contentPane.add(centralniPanel, BorderLayout.CENTER);
				centralniPanel.revalidate();
				centralniPanel.updateUI();
			}
		});
		
		
		
		
		
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JButton btnPregledUreaja = new JButton("Pregled ure\u0111aja");
		btnPregledUreaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.remove(centralniPanel);
				centralniPanel = new panelPregledUredjaja(true);
				contentPane.add(centralniPanel, BorderLayout.CENTER);
				centralniPanel.revalidate();
				centralniPanel.updateUI();

			}
		});
		btnPregledUreaja.setHorizontalAlignment(SwingConstants.LEFT);
		btnPregledUreaja.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JButton btnPretragaUreaja = new JButton("Tra\u017Ei ure\u0111aj");
		btnPretragaUreaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.remove(centralniPanel);
				centralniPanel = new panelTraziUredjaj();
				contentPane.add(centralniPanel, BorderLayout.CENTER);
				centralniPanel.revalidate();
				centralniPanel.updateUI();
			}
		});
		btnPretragaUreaja.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnPretragaUreaja.setHorizontalAlignment(SwingConstants.LEFT);
		
		JButton btnDodajKlijenta = new JButton("Dodaj klijenta");
		btnDodajKlijenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane.remove(centralniPanel);
				centralniPanel = new panelDodajKlijenta();
				contentPane.add(centralniPanel, BorderLayout.CENTER);
				centralniPanel.revalidate();
				centralniPanel.updateUI();
			}
		});
		btnDodajKlijenta.setHorizontalAlignment(SwingConstants.LEFT);
		btnDodajKlijenta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JButton btnPregled = new JButton("Pregled klijenta");
		btnPregled.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(centralniPanel);
				centralniPanel = new panelPregledKlijenata(true);
				contentPane.add(centralniPanel, BorderLayout.CENTER);
				centralniPanel.revalidate();
				centralniPanel.updateUI();
			}
		});
		btnPregled.setHorizontalAlignment(SwingConstants.LEFT);
		btnPregled.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JButton btnPretraga = new JButton("Traži klijenta");
		btnPretraga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(centralniPanel);
				centralniPanel = new panelTraziKlijenta();
				contentPane.add(centralniPanel, BorderLayout.CENTER);
				centralniPanel.revalidate();
				centralniPanel.updateUI();
			}
		});
		btnPretraga.setHorizontalAlignment(SwingConstants.LEFT);
		btnPretraga.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JButton btnNewButton = new JButton("Odjavi se");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JButton btnZahtjevi = new JButton("Zahtjevi");
		btnZahtjevi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnZahtjevi.setHorizontalAlignment(SwingConstants.LEFT);
		btnZahtjevi.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		ImageIcon slika = new ImageIcon(getClass().getResource("NotifIcon.png"));
		Image sl=slika.getImage();
		Image temp=sl.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		slika=new ImageIcon(temp);
		
		slika=new ImageIcon(getClass().getResource("LogoutIcon.png"));
		sl=slika.getImage();
		temp=sl.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		btnNewButton.setIcon(new ImageIcon(temp));
		
		slika=new ImageIcon(getClass().getResource("AddUserIcon.png"));
		sl=slika.getImage();
		temp=sl.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		btnDodajKlijenta.setIcon(new ImageIcon(temp));
		
		slika=new ImageIcon(getClass().getResource("AddIcon.png"));
		sl=slika.getImage();
		temp=sl.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		btnNewButton_1.setIcon(new ImageIcon(temp));
		
		slika=new ImageIcon(getClass().getResource("NotifIcon.png"));
		sl=slika.getImage();
		temp=sl.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		btnZahtjevi.setIcon(new ImageIcon(temp));
		
		slika=new ImageIcon(getClass().getResource("SearchIcon.png"));
		sl=slika.getImage();
		temp=sl.getScaledInstance(20, 20
				, java.awt.Image.SCALE_SMOOTH);
		btnPretragaUreaja.setIcon(new ImageIcon(temp));
		
		slika=new ImageIcon(getClass().getResource("SearchUserIcon.png"));
		sl=slika.getImage();
		temp=sl.getScaledInstance(20, 20
				, java.awt.Image.SCALE_SMOOTH);
		btnPretraga.setIcon(new ImageIcon(temp));
		
		slika=new ImageIcon(getClass().getResource("RepoIcon.png"));
		sl=slika.getImage();
		temp=sl.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		btnIzvjetaji.setIcon(new ImageIcon(temp));
		
		slika=new ImageIcon(getClass().getResource("ViewIcon.png"));
		sl=slika.getImage();
		temp=sl.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		btnPregled.setIcon(new ImageIcon(temp));
		btnPregledUreaja.setIcon(new ImageIcon(temp));
		
		slika=new ImageIcon(getClass().getResource("GroupIcon.png"));
		sl=slika.getImage();
		temp=sl.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		btnPregled.setIcon(new ImageIcon(temp));
		
		slika=new ImageIcon(getClass().getResource("ZadaciIcon.png"));
		sl=slika.getImage();
		temp=sl.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		btnZadaci.setIcon(new ImageIcon(temp));
		btnZadaci.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Postavke");
		mnNewMenu.setForeground(new Color(0, 0, 0));
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmPromjenaifre = new JMenuItem("Promjena \u0161ifre");
		mnNewMenu.add(mntmPromjenaifre);
		
		panel.setBorder(BorderFactory.createTitledBorder("Klijenti:"));
		TitledBorder border=(TitledBorder)panel.getBorder();
		border.setTitleFont(new Font("Tahoma", Font.PLAIN, 11));
		
		panel_2.setBorder(BorderFactory.createTitledBorder("Ure\u0111aji:"));
		 border=(TitledBorder)panel_2.getBorder();
		border.setTitleFont(new Font("Tahoma", Font.PLAIN, 11));
		
		panel_4.setBorder(BorderFactory.createTitledBorder("Aktivnosti:"));
		border=(TitledBorder)panel_4.getBorder();
		border.setTitleFont(new Font("Tahoma", Font.PLAIN, 11));
		
		panel_5.setBorder(BorderFactory.createTitledBorder("Profil:"));
		border=(TitledBorder)panel_5.getBorder();
		border.setTitleFont(new Font("Tahoma", Font.PLAIN, 11));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(btnDodajKlijenta, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
				.addComponent(btnPregled, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
				.addComponent(btnPretraga, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(btnDodajKlijenta)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnPregled)
					.addGap(7)
					.addComponent(btnPretraga, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
				
			
		
		

		
				GroupLayout gl_panel_1 = new GroupLayout(panel_1);
				gl_panel_1.setHorizontalGroup(
					gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, 0, 0, Short.MAX_VALUE)
							.addGap(12))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(12)
							.addComponent(panel_2, 0, 0, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(12))
						.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
							.addContainerGap())
				);
				gl_panel_1.setVerticalGroup(
					gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
							.addComponent(btnNewButton)
							.addContainerGap())
				);
				
				
				
				GroupLayout gl_panel_5 = new GroupLayout(panel_5);
				gl_panel_5.setHorizontalGroup(
					gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addComponent(btnZahtjevi, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
				);
				gl_panel_5.setVerticalGroup(
					gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_5.createSequentialGroup()
							.addComponent(btnZahtjevi)
							.addContainerGap(22, Short.MAX_VALUE))
				);
				panel_5.setLayout(gl_panel_5);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
				.addComponent(btnPregledUreaja, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
				.addComponent(btnPretragaUreaja, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(4)
					.addComponent(btnNewButton_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnPregledUreaja)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnPretragaUreaja)
					.addGap(12))
		);
		panel_2.setLayout(gl_panel_2);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addComponent(btnIzvjetaji, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
				.addComponent(btnZadaci, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addComponent(btnIzvjetaji)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnZadaci)
					.addGap(35))
		);
		panel_4.setLayout(gl_panel_4);
		panel_1.setLayout(gl_panel_1);
		
		
		
		
	}
}
