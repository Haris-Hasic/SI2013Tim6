package ba.unsa.etf.si.app.fdss_aplikacija.klase;


public enum PrivilegijaUposlenika{
	
	ADMINISTRATOR("Administrator"), MENADZER("Menadzer"), SERVISER("Serviser"), DISPECER("Dispecer");
	private final String display;
    private PrivilegijaUposlenika(String s) {
        display = s;
    }
    
    @Override
    public String toString()
    {
    	return display;
    }
    
}
