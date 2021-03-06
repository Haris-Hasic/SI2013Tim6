package ba.unsa.etf.si.app.fdss_aplikacija.glavneForme;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import ba.unsa.etf.si.app.fdss_aplikacija.beans.Uposlenik;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateKlijent;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateUposlenik;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.TestPristupaBazi;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.Validacija;

public class frmLogin extends JFrame {
	
	private JTextField userName_tb;
	private ImageIcon slika;
	
	private JPanel contentPane;
	private JPasswordField password_tb;
	public static frmLogin pocetna;
	private static List<Uposlenik> uposlenici;
	private static HibernateUposlenik hu;
	private static HibernateKlijent hk;
	private static TestPristupaBazi tpb;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					
					tpb = new TestPristupaBazi();
					
					if(tpb.Testiraj()) {
						
						final frmSplashScreen fsp = new frmSplashScreen();
						fsp.setVisible(true);
	
						Timer timer = new Timer(1000, new ActionListener() {
							public void actionPerformed(ActionEvent e) {
	
								hu = new HibernateUposlenik();
								hk = new HibernateKlijent();
								uposlenici = hu.dajSveUposlenike();
								hk.dajSveKlijente();
	
								fsp.setVisible(false);
								fsp.dispose();
	
								final frmLogin frame = new frmLogin();
								frame.setVisible(true);
							}
						});
	
						timer.setRepeats(false);
						timer.start(); 
					}

				} catch (Exception e) {

					JOptionPane.showMessageDialog(null, "Konekcija na bazu nije uspjela. \nRazlog : \n" + e.getClass().getName()+": "+ e.getMessage());
					System.exit(1);
				}
			}
		});
	}

	public frmLogin() {
		
		pocetna = this;
		setResizable(false);
		setTitle("FDSS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 434, 247);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JLabel lblKorisnikoIme = new JLabel("Korisničko ime :");
		lblKorisnikoIme.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKorisnikoIme.setFont(new Font("Cambria", Font.PLAIN, 14));
		lblKorisnikoIme.setBounds(35, 102, 105, 20);
		getContentPane().add(lblKorisnikoIme);
		
		JLabel lblKorisnikaifra = new JLabel("Lozinka :");
		lblKorisnikaifra.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKorisnikaifra.setFont(new Font("Cambria", Font.PLAIN, 14));
		lblKorisnikaifra.setBounds(35, 136, 105, 14);
		getContentPane().add(lblKorisnikaifra);
		
		userName_tb = new JTextField();
		userName_tb.setBounds(150, 102, 228, 20);
		getContentPane().add(userName_tb);
		userName_tb.setColumns(10);
		
		JButton PrijaviSe_btn = new JButton("Prijavi se");
		PrijaviSe_btn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
					
					provjeriPodatke(userName_tb.getText(), password_tb.getText());	
			}
		});
		
		PrijaviSe_btn.setFont(new Font("Cambria", Font.PLAIN, 14));
		PrijaviSe_btn.setBounds(273, 164, 105, 30);
		getContentPane().add(PrijaviSe_btn);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(94, 11, 252, 85);
		getContentPane().add(lblNewLabel);
		
		slika = new ImageIcon(getClass().getResource("/FDSS Logo.jpg"));
		Image sl=slika.getImage();
		Image temp=sl.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), java.awt.Image.SCALE_SMOOTH);
		slika=new ImageIcon(temp);
		lblNewLabel.setIcon(slika);
		
		password_tb = new JPasswordField();
		password_tb.setBounds(150, 133, 228, 20);
		contentPane.add(password_tb);
	}
	
	private void provjeriPodatke(String userName,String password)
	{	
		if(new HibernateUposlenik().postojiUposlenik(userName))
		{
			Uposlenik up = hu.dajUposlenika(userName_tb.getText());			
			if(up.getPassword().compareTo(Validacija.HesirajMD5(Validacija.HesirajMD5(password_tb.getText()))) == 0) {

				switch(up.getPrivilegija())
				{
				
					case ADMINISTRATOR:
						frmAdministrator fa=new frmAdministrator(up);
						fa.setVisible(true);
						userName_tb.setText("");
						password_tb.setText("");
						dispose();
						break;
						
					case MENADZER:
						frmManager fm=new frmManager(up);
						fm.setVisible(true);
						userName_tb.setText("");
						password_tb.setText("");
						dispose();
						break;
						
					case DISPECER:
						frmDispatcher fd=new frmDispatcher(up);
						fd.setVisible(true);
						userName_tb.setText("");
						password_tb.setText("");
						dispose();
						break;
						
					case SERVISER:
						frmServiser fs=new frmServiser(up);
						fs.setVisible(true);
						userName_tb.setText("");
						password_tb.setText("");
						dispose();
						break;
				}
			}
			
			else
				new Validacija().poruka("Pogrešni login podaci !");
		}
		
		else 
			new Validacija().poruka("Pogrešni login podaci !");
	}
}
