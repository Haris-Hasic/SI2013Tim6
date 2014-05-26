package ba.unsa.etf.si.app.fdss_aplikacija.beans;

import java.io.Serializable;

import ba.unsa.etf.si.app.fdss_aplikacija.klase.GeneralniException;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.Validacija;

public class Uredjaj implements Serializable{
	
	long id;
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

	String jibProizvodaca;
	String tipUredaja;
	String ibfu;
	String ibfm;
	Klijent klijent;
	
	public Uredjaj() {
		
	}


	public Klijent getKlijent() {
		return klijent;
	}

	public void setKlijent(Klijent klijent) {
		this.klijent = klijent;
	}

	public String getJibProizvodaca() {
		return jibProizvodaca;
	}

	public void setJibProizvodaca(String jibProizvodaca) throws GeneralniException{
		if(new Validacija().validirajJMBG(jibProizvodaca))
		{
			this.jibProizvodaca = jibProizvodaca;
		}else throw new GeneralniException("Nepravilan JIB proizvođaća.");
	}

	public String getTipUredaja() {
		return tipUredaja;
	}

	public void setTipUredaja(String tipUredaja) {
		this.tipUredaja = tipUredaja;
	}

	public String getIbfu() {
		return ibfu;
	}

	public void setIbfu(String ibfu) throws GeneralniException {
		if(new Validacija().validirajIBFU(ibfu))
		{
			this.ibfu = ibfu;
		}else throw new GeneralniException("Nepravilan IBFU.");
	}

	public String getIbfm() {
		return ibfm;
	}

	public void setIbfm(String ibfm) throws GeneralniException{
		if(new Validacija().validirajIBFM(ibfm))
		{
			this.ibfm = ibfm;
		}else throw new GeneralniException("Nepravilan IBFM");
	}

	@Override
	public boolean equals(Object obj) {
		 if (this == obj)
	           return true;
	       if (obj == null)
	           return false;
	       if (getClass() != obj.getClass())
	           return false;
	       final Uredjaj other = (Uredjaj) obj;
	       if (ibfu != other.getIbfu())
	           return false;
	       return true;
	   }
	@Override
	public String toString()
	{
		return ibfu;
	}

}
