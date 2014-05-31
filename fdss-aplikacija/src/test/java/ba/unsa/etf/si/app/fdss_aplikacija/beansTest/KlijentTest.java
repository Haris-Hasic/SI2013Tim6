package ba.unsa.etf.si.app.fdss_aplikacija.beansTest;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.*;

import ba.unsa.etf.si.app.fdss_aplikacija.beans.Klijent;
import ba.unsa.etf.si.app.fdss_aplikacija.beans.Uredjaj;
import ba.unsa.etf.si.app.fdss_aplikacija.beans.Zahtjev;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateKlijent;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateZahtjev;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.GeneralniException;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.Validacija;

public class KlijentTest {
	
	HibernateKlijent hk;
	Klijent k;
	
	@Before
	public void TestnePostavke () {
		try {
			k =  new Klijent("Firma", "1607991186528", "Dervisa Susica 2", "Brcko", "+38761579652", "ena_brcko@hotmail.com","firma.ba");
			hk = new HibernateKlijent();
		}
		
		catch (GeneralniException e)
		{
			Validacija v= new Validacija();
			v.poruka(e.getMessage());
		}
		
	}
	
@Test
public void testGetSetJib() {
		
		try {
	

			k.setJib("1607991186528");
			
			Assert.assertEquals("1607991186528", k.getJib());
		} 
		
		catch (GeneralniException e) {
			
			Assert.fail("Test neuspješan. Ne rade get i set metode za atribut Jib.");
		}
	}


@Test
public void testGetSetJibNeispravno() {
	
	Klijent k = new Klijent();
	
	try {
		

		k.setJib("1607");
		
		Assert.fail("Test neuspješan. Ne rade get i set metode za atribut jmbg.");
	} 
	
	catch (GeneralniException e) {
		
		Assert.assertEquals("1607991186528", k.getJib());
	}
}

@Test
public void testGetSetWebIspravno() {
	
	try {


		k.setWeb("firma.com");
		
		Assert.assertEquals("firma.com", k.getWeb());
	} 
	
	catch (GeneralniException e) {
		
		Assert.fail("Test neuspješan. Ne rade get i set metode za atribut Web .");
	}
}


@Test
public void testGetSetMjestoIspravno() {

	
		k.setMjesto("Sarajevo");
		
		Assert.assertEquals("Sarajevo", k.getMjesto());

}


@Test
 void testGetSetEmail() {
	
	 Klijent k = new Klijent();
	 
	try {
		
		k.setEmail("eganilovic1@etf.unsa.ba");
		
		Assert.assertEquals("eganilovic1@etf.unsa.ba", k.getEmail());
	} 
	
	catch (GeneralniException e) {
		
		Assert.fail("Test neuspješan. Ne rade get i set metode za atribut e-mail.");
	}
}

@Test
public void testUpdateKlijenta() {
	
	Klijent k = new Klijent();
	
	try {
		
		k.setAdresa("Trg djece Dobrinje");
		k.setMjesto("Sarajevo");
		k.setNaziv("Firma");
		k.setJib("2706992172174");
		k.setEmail("firma@hotmail.com");
		k.setTelefon("+38761503098");
		k.setWeb("firma.com");
	
		
		Boolean flag=false;
		if (k.getAdresa()=="Trg djece Dobrinje" && k.getMjesto()=="Sarajevo" && k.getNaziv()=="Firma"  && k.getJib()=="2706992172174" && k.getEmail()=="firma@hotmail.com" && k.getTelefon()=="+38761503098")
			flag=true;
		
		Assert.assertTrue(flag);
	} 
	
	catch (GeneralniException e) {
		
		Assert.fail("Test neuspješan. Ne radi update-ovanje klijenta.");
	}
}


@Test
public void testpostojiKlijent() {
	
	HibernateKlijent h  = new HibernateKlijent();
	
	Assert.assertTrue(h.postojiKlijent("1607991186528"));
	
}

@Test
public void testBrisanjeKlijenta() {
		long id = k.getId();
		hk.dodajKlijenta(k);
		hk.brisiKlijenta(k);
		
		Assert.assertFalse(hk.postojiKlijent(id));
}

@Test
public void testPretragaKlijenta() {
		long id = k.getId();
		hk.dodajKlijenta(k);
		
		Klijent k2 = hk.dajKlijenta(id);
		
		Assert.assertEquals(k, k2);
}


}
