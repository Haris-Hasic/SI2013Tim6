package ba.unsa.etf.si.app.fdss_aplikacija.beansTest;

import ba.unsa.etf.si.app.fdss_aplikacija.beans.Klijent;
import ba.unsa.etf.si.app.fdss_aplikacija.beans.Uposlenik;

import org.junit.*;

import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateKlijent;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateUposlenik;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.GeneralniException;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.Validacija;

public class UposlenikTest {
	HibernateUposlenik hup;
	Uposlenik up;
	
	@Before
	public void TestnePostavke () {
		try {
			up =  new Uposlenik("Haris", "Hasic", "1504992173043", "Tuzlanska bb", "Olovo", "+38762380249", "haristd@hotmail.com", 1, "hhasic2", "harishasic21");
		}
		
		catch (GeneralniException e)
		{
			Validacija v= new Validacija();
			v.poruka(e.getMessage());
		}
		
		hup = new HibernateUposlenik();
	}
	
	@Test
	public void testGetSetNazivAdresa() {

		
			up.setAdresa("Radiceva 10");
			
			Assert.assertEquals("Radiceva 10", up.getAdresa());

	}

	@Test
	public void testGetSetJmbgIspravno() {
		
		try {
			
			Uposlenik u = new Uposlenik("Haris", "Hasic", "1504992173043", "Tuzlanska bb", "Olovo", "+38762380249", "haristd@hotmail.com", 1, "hhasic2", "harishasic21");
			u.setJmbg("1703965714205");
			
			Assert.assertEquals("1703965714205", u.getJmbg());
		} 
		
		catch (GeneralniException e) {
			
			Assert.fail("Test neuspješan. Ne rade get i set metode za atribut jmbg.");
		}
	}

	@Test
	public void testGetSetJmbgNeispravno() {
		
		try {
			up.setJmbg("1111");
			
			Assert.fail("Test neuspješan. Ne rade get i set metode za atribut jmbg.");
		} 
		
		catch (GeneralniException e) {
			
			Assert.assertEquals("1504992173043", up.getJmbg());
		}
	}

	@Test
	public void testGetSetTelefon() {
		
		try {
			
			Uposlenik u = new Uposlenik("Haris", "Hasic", "1504992173043", "Tuzlanska bb", "Olovo", "+38762380249", "haristd@hotmail.com", 1, "hhasic2", "harishasic21");
			u.setTelefon("+38762666666");
			
			Assert.assertEquals("+38762666666", u.getTelefon());
		} 
		
		catch (GeneralniException e) {
			
			Assert.fail("Test neuspješan. Ne rade get i set metode za atribut telefon.");
		}
	}

	@Test
	public void testGetSetEmail() {
		
		try {
			
			Uposlenik u = new Uposlenik("Haris", "Hasic", "1504992173043", "Tuzlanska bb", "Olovo", "+38762380249", "haristd@hotmail.com", 1, "hhasic2", "harishasic21");
			u.setEmail("hhasic2@etf.unsa.ba");
			
			Assert.assertEquals("hhasic2@etf.unsa.ba", u.getEmail());
		} 
		
		catch (GeneralniException e) {
			
			Assert.fail("Test neuspješan. Ne rade get i set metode za atribut e-mail.");
		}
	}
	
	@Test
	public void testUpdateUposlenika() {
		
		try {
		
			hup.dodajUposlenika(up);
			
			up.setAdresa("Trg djece Dobrinje");
			up.setMjesto("Sarajevo");
			up.setIme("Ajdin");
			up.setPrezime("Kahrovic");
			up.setJmbg("2706992172174");
			up.setEmail("kahrovic@hotmail.com");
			up.setTelefon("+38761503098");
			up.setUserName("akahrovic");
			up.setPassword("sifra123");
			up.setTip(2);
			hup.updateUposlenika(up);
			Uposlenik novi = hup.dajUposlenika("akahrovic");
			
			Boolean flag=false;
			if (novi.getAdresa()=="Trg djece Dobrinje" && novi.getMjesto()=="Sarajevo" && novi.getIme()=="Ajdin" && novi.getPrezime()=="Kahrovic" && novi.getJmbg()=="2706992172174" && novi.getEmail()=="kahrovic@hotmail.com" && novi.getPassword()=="sifra123" && novi.getTelefon()=="+38761503098" && novi.getUserName()=="akahrovic1" && novi.getTip()==2)
				flag=true;
			
			Assert.assertTrue(flag);
		} 
		
		catch (GeneralniException e) {
			
			Assert.fail("Test neuspješan. Ne radi update-ovanje uposlenika.");
		}
	}
	
	@Test
	public void testBrisanjeUposlenika() {
			long id = up.getId();
			hup.dodajUposlenika(up);
			hup.brisiUposlenika(up);
			
			Assert.assertFalse(hup.postojiUposlenik(id));
	}
	
	@Test
	public void testPretragaUposlenika() {
			long id = up.getId();
			hup.dodajUposlenika(up);
			
			Uposlenik up2 = hup.dajUposlenika(id);
			
			Assert.assertEquals(up, up2);
	}	

	

}
