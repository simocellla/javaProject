import java.util.*;

public class Main {
	
	//Metodo main per testare il programma (gestioneAutomezzi):
		public static void main(String[] args) {
			
			Scanner c = new Scanner(System.in);
			String tg = "";
		
			GestioneAutomezzi parcoAuto = new GestioneAutomezzi("","","",0,0);
			ArrayList<Automezzo> parcoAutomezzi = new ArrayList<Automezzo>();
			
			do {
				System.out.println("Benvenuti,");
				System.out.println("Scegliere l'operazione da effettuare:");
				System.out.println("1 - Inserimento di un numero di automezzi arbitrario");
				System.out.println("2 - Inserimento di un automezzo");
				System.out.println("3 - Acquisto di un nuovo automezzo");
				System.out.println("4 - Cancellazione di un veicolo data la targa");
				System.out.println("5 - Visualizzazione dati veicolo data la targa");
				System.out.println("6 - Stampare dati veicoli con Anno revisione = anno di immatricolazione ed è antecedente di 4 anni rispetto all'anno corrente oppure ultima revisione antecedente di 2 anni rispetto all’anno corrente ");
				System.out.println("7 - Stampare tutti i modelli di automezzi presenti");
				System.out.println("8 - Trova il massimo prezzo tra tutti gli autoveicoli");
				System.out.println("9 - Trova il minimo prezzo tra tutti gli autoveicoli");
				System.out.println("10 - Stampa di tutti i veicoli in ordine di Prezzo CRESCENTE");
				System.out.println("11 - Stampa di tutti i veicoli in ordine di Prezzo DE-CRESCENTE");
				System.out.println("0 - Exit");
				int a = c.nextInt();
				switch (a) {
			    	case 1:
			    		parcoAuto.insertAuto();
			    		break;
			    	case 2:
			    		parcoAuto.inserimentoVeicolo();
			    		break;
			    	case 3:
			    		parcoAuto.inserimentoNewVeicolo();
			    		break;
			    	case 4:
			    		parcoAuto.deleteVeicolo();
			    		break;
			    	case 5:
			    		parcoAuto.printInfo();
			    		break;
			    	case 6:
			    		parcoAuto.printRev();
			    		break;
			    	case 7:
			    		parcoAuto.printModell();
			    		break;
			    	case 8:
			    		parcoAuto.findMax();
			    		break;
			    	case 9:
			    		parcoAuto.findMin();
			    		break;
			    	case 10:
			    		parcoAuto.printOrdered();
			    		break;
			    	case 11:
			    		parcoAuto.printUnordered();
			    		break;
			    	case 0:
			    		break;
				}
			
				System.out.println();
				System.out.println("Digitare 0 se si vuole uscire dal programma, 1 se si vuole effettuare un'altra operazione");
					int f = c.nextInt();
					if(f == 0)
						break;
			}while(true);
		}

}
