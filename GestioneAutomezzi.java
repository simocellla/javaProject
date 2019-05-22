import java.util.*;

public class GestioneAutomezzi {
	
	//Attributi:
	Scanner in = new Scanner(System.in);
	String Targa,Modello,Marca = " ";
	int annoRev,annoImm,prezzoAuto = 0;
	
	Automezzo auto = new Automezzo(Marca,Modello,Targa,annoImm,annoRev,prezzoAuto);
	ArrayList<Automezzo> parcoAuto = new ArrayList<Automezzo>();
	
	public GestioneAutomezzi(String Marca, String Modello, String Targa, int AnnoImm, int AnnoRev) {	
	}
	
	//Funzioni:
	//1) inserimento di N automezzi nel parco:
		public void insertAuto() {
			int n_auto = 0;
			do {		
				System.out.println("Inserisci il numero di auto che si vogliono aggiungere al parco auto:");
				n_auto = in.nextInt();
			}while(n_auto < 0);
		
			for(int i = 0 ; i < n_auto; i++) {
				System.out.println("Inserire i dati del "+(i+1)+" veicolo");
				System.out.println("-----------------------------");
				
				System.out.println("Inserire la Marca del veicolo:");
				Marca = in.next();
				System.out.println("Inserire il Modello del veicolo:");
				Modello = in.next();
				System.out.println("Inserire la Targa del veicolo:");
				Targa = in.next();
				System.out.println("Inserire l'Anno di immatricolazione del veicolo:");
				annoImm = in.nextInt();
				System.out.println("Inserire l'anno dell'ultima revisione del veicolo:");
				annoRev = in.nextInt();
				
				System.out.println("Inserire il prezzo del veicolo:");
				prezzoAuto = in.nextInt();
				
				parcoAuto.add(new Automezzo(Marca,Modello,Targa,annoImm,annoRev,prezzoAuto));
			}
		}
	
	//2)Acquisto/Aggiunta di un NUOVO veicolo:
		public void inserimentoNewVeicolo() {
			int anno = Calendar.getInstance().get(Calendar.YEAR);
			System.out.println("Inserire i dati del nuovo veicolo che si vuole aggiungere al parcoAuto:");
			System.out.println("-----------------------------------");
			System.out.println("Inserire la Marca del veicolo:");
			Marca = in.next();
			System.out.println("Inserire il Modello del veicolo:");
			Modello = in.next();
			System.out.println("Inserire la Targa del veicolo:");
			Targa = in.next();
			//annoImm e annoRev sono uguali all'anno in corso.
			annoImm = annoRev = anno;
			System.out.println("Inserire il prezzo del veicolo:");
			prezzoAuto = in.nextInt();
		
			parcoAuto.add(new Automezzo(Marca,Modello,Targa,anno,anno,prezzoAuto));
		}
	
	//3)Acquisto/Aggiunta di un veicolo:
		public void inserimentoVeicolo() {
			System.out.println("Inserire i dati del veicolo che si vuole aggiungere al parcoAuto3:");
			System.out.println("-----------------------------------");
			
			System.out.println("Inserire la Marca del veicolo:");
			Marca = in.next();
			System.out.println("Inserire il Modello del veicolo:");
			Modello = in.next();
			System.out.println("Inserire la Targa del veicolo:");
			Targa = in.next();
			System.out.println("Inserire l'Anno di Immatricolazione del veicolo:");
			annoImm = in.nextInt();
			System.out.println("Inserire l'Anno dell'ultima Revisione del veicolo:");
			annoRev = in.nextInt();
			System.out.println("Inserire il prezzo del veicolo:");
			prezzoAuto = in.nextInt();
			
			parcoAuto.add(new Automezzo(Marca,Modello,Targa,annoImm,annoRev,prezzoAuto));
		}
		
	//4)Eliminazione data la targa:
		public void deleteVeicolo() {
			boolean check = true;
			System.out.println("Inserire la targa del veicolo che si desidera eliminare:");
			Targa = in.next();
			if(Targa != null) {
				for(int i = 0; i < parcoAuto.size(); i++) {
					if(Targa.equals(parcoAuto.get(i).getTarga())) {
						parcoAuto.remove(i);
						System.out.println("Veicolo targato ["+Targa+"] Rimosso con successo!");
						check = false;
					}
				}
				if(check)
					System.out.println("Errore, targa non trovata, si prega di riprovare.");
			}
			else
				System.out.println("Inserire la Targa!");
		}
	
	//5)Ricerca e Stampa di veicoli data la Targa:
		public void printInfo() {
			System.out.println("Inserire la Targa del veicolo del quale si vogliono le informazioni:");
			Targa = in.next();
			boolean err = true;
			for(int i = 0; i < parcoAuto.size(); i++) {
				if(Targa.equals(parcoAuto.get(i).getTarga())) {
					parcoAuto.get(i).printInfo();
					err = false;
				}
			}	
			if(err)
				System.out.println("Errore! Targa ["+Targa+"] non trovata!");
		}
	
	//6)Stampa di tutti i veicoli all'interno del parcoAuto:
		public void printModell() {
			ArrayList<String> modell = new ArrayList<String>();
			for(int i = 0; i < parcoAuto.size(); i++) 
				modell.add(parcoAuto.get(i).getModello());
			ArrayList<String> newModell = new ArrayList<String>(new HashSet<String>(modell));
			for(int i = 0; i < newModell.size(); i++) {
				System.out.println(newModell.get(i));
				//System.out.println();
			}
		}
		
	//7) Stampa di tutti veicoli con Anno di revisione = anno di immatricolazione e 
		// = anno corrente -4, oppure annoRev = annoImm = anno corrente -2.
		public void printRev() {
			int anno = Calendar.getInstance().get(Calendar.YEAR);
			for(int i = 0; i < parcoAuto.size(); i++) {
				if(parcoAuto.get(i).getAnnorev() == parcoAuto.get(i).getAnnoimm() && parcoAuto.get(i).getAnnoimm() == anno-4){
					parcoAuto.get(i).printInfo();
				}
					else if(parcoAuto.get(i).getAnnorev() == anno-2) {
						parcoAuto.get(i).printInfo();
					}
				break;}
							System.out.println("Errore,riprovare, nessuna targa trovata.");
			}
		
	//8) Stampa dei dati del veicolo più costoso:
		public void findMax() {
			int index = 0;
			int max = 0;
				for(int i = 0; i < parcoAuto.size(); i++) {
					if(parcoAuto.get(i).getPrezzoAuto() > max) {
						max = parcoAuto.get(i).getPrezzoAuto();
						index = i;
					}
				}
				parcoAuto.get(index).printInfo();
		}
		
	//9) Stampa dei dati del veicolo meno costoso:
		public void findMin() {
			int index = 0;
			int min = parcoAuto.get(0).getPrezzoAuto();
				for(int i = 0; i < parcoAuto.size(); i++) {
					if(parcoAuto.get(i).getPrezzoAuto() < min) {
						min = parcoAuto.get(i).getPrezzoAuto();
						index = i;
					}
				}
			parcoAuto.get(index).printInfo();
		}
	
	//10) Ordinamento veicoli per prezzo crescente e stampa a video:
		public void printOrdered(){
			Automezzo autotemp = new Automezzo("", "", "", 0, 0, 0);
			for(int k = 0; k < parcoAuto.size(); k++) {
				for(int i = 0; i < parcoAuto.size(); i++) {
					if(parcoAuto.get(k).getPrezzoAuto() < parcoAuto.get(i).getPrezzoAuto()) {
						autotemp = parcoAuto.get(k);
						parcoAuto.set(k,parcoAuto.get(i));
						parcoAuto.set(i,autotemp);
					}
				}
			}
			
				for(int i = 0; i < parcoAuto.size(); i++) {
					parcoAuto.get(i).printInfo();
			}
		}
		
	
	//11) Ordinamento veicoli per prezzo DE-crescente e stampa a video:
		public void printUnordered() {
			Automezzo autotemp = new Automezzo("","","",0,0,0);
			for(int k = 0; k < parcoAuto.size(); k++) {
				for(int i = 0; i < parcoAuto.size(); i++) {
					if(parcoAuto.get(k).getPrezzoAuto() > parcoAuto.get(i).getPrezzoAuto()) {
						autotemp = parcoAuto.get(k);
						parcoAuto.set(k, parcoAuto.get(i));
						parcoAuto.set(i,autotemp);
					}
				}	
			}
			
				for(int i = 0; i < parcoAuto.size(); i++) {
					parcoAuto.get(i).printInfo();
				}
		}




}