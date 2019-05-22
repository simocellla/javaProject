public class Automezzo {
	
	//Attrubutes of the class:
	
	private String Marca;
	private String Modello;
	private String Targa;
	private int annoImm;
	private int annoRev;
	
	//Methods:
	//Set:
	public void setMarca(String Marca) {
		this.Marca = Marca;
	}
	public void setModello(String Modello) {
		this.Modello = Modello;
	}
	public void setTarga(String Targa) {
		this.Targa = Targa;
	}
	public void setAnnoimm(int annoImm) {
		this.annoImm = annoImm;
	}
	public void setAnnorev(int annoRev) {
		this.annoRev = annoRev;
	}
	
	//Get:
	public String getMarca(){
		return Marca;
	}
	public String getModello(){
		return Modello;
	}
	public String getTarga(){
		return Targa;
	}
	public int getAnnoimm(){
		return annoImm;
	}
	public int getAnnorev(){
		return annoRev;
	}
	
	//Costruttore per parametri:
	public Automezzo(String Marca, String Modello, String Targa, int annoImm, int annoRev){
		super();
		this.Marca = Marca;
		this.Modello = Modello;
		this.Targa = Targa;
		this.annoImm = annoImm;
		this.annoRev = annoRev;
	}
	
	//Metodo per stampa informazioni:
	public void printInfo(){
    	System.out.println("------------------------------");
    	System.out.println("Marca: "+Marca);
    	System.out.println("Modello: "+Modello);
    	System.out.println("Targa: "+Targa);
    	System.out.println("Anno d'immatricolazione: "+annoImm);
    	System.out.println("Anno ultima revisione: "+annoRev);
    	System.out.println("------------------------------");
		}
}
