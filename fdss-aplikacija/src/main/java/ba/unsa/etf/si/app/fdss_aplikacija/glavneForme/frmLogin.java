package ba.unsa.etf.si.app.fdss_aplikacija.glavneForme;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class frmLogin extends JFrame {
	
	private JTextField userName_tb;
	private ImageIcon slika;
	
	private JPanel contentPane;
	private JPasswordField password_tb;
	public static frmLogin pocetna;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLogin frame = new frmLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
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

				if ( userName_tb.getText().compareTo("a") == 0 ) {
					
					frmAdministrator fa = new frmAdministrator();
					fa.setVisible(true);
					dispose();
				}
				
				else if ( userName_tb.getText().compareTo("m") == 0 ) {
					frmManager fm=new frmManager();
					fm.setVisible(true);
					setVisible(false);
			    }
				
				else if ( userName_tb.getText().compareTo("s") == 0 ) {
					frmServiser fs=new frmServiser();
					fs.setVisible(true);
					setVisible(false);
				}
				
				else if ( userName_tb.getText().compareTo("d") == 0 ) {
					
					frmDispatcher fd=new frmDispatcher();
					fd.setVisible(true);
					setVisible(false);
				}
				
				else {
					
				}
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
}
