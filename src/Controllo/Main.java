package Controllo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Modello.Cocktail;
import Modello.Ingrediente;
import Persistenza.Archivio;
import Vista.VistaUtente;

public class Main {
	static Archivio archivio = new Archivio();
	static VistaUtente vistaUtente = new VistaUtente();
	static Scanner scanner= new Scanner(System.in);
	public static void main(String[] args) {
		
		while(true) {
			int scelta=vistaUtente.menu();
			if(scelta==1) {
				
				Cocktail cocktail=vistaUtente.leggiCocktail();
				if(archivio.containsCocktailByNome(cocktail.getNome())) {
					vistaUtente.stampaMessaggio("cocktail gia esitente");
					continue;
				}else {
					archivio.addCocktail(cocktail);
				}
				
				
			}else if(scelta==2) {
				
				Cocktail cocktailDaArchivio = archivio.findCocktailByNome(vistaUtente.insersciNomeSearch());
				if(cocktailDaArchivio==null) {
					vistaUtente.stampaMessaggio("il cocktail non esiste");
					continue;
				}
				vistaUtente.stampaMessaggio(cocktailDaArchivio.toString());
			
				Ingrediente ingrediente = vistaUtente.leggiIngrediente();
				if(cocktailDaArchivio.containsIngredienteByNome(ingrediente.getNome())) {
					vistaUtente.stampaMessaggio("l'ingrediente è gia presente");
					continue;
				}
				cocktailDaArchivio.addIngrediente(ingrediente);
					
					
			}else if(scelta==3) {
				Cocktail j = verificaCocktailAnalcolicoPiuCostoso(archivio);
				vistaUtente.stampaMessaggio("il cocktail piu costoso è "+ j.getNome()+"\n" +j.toString());
			
			}else if(scelta==4) {
				List<String> listaIngredientiUtente = vistaUtente.leggiListaIngredienti();
				List<Cocktail> listaDiCocktail = archivio.getListaCocktail();
				for(Cocktail c :listaDiCocktail) {
					if(c.isPreparabile(listaIngredientiUtente)) {
						vistaUtente.stampaMessaggio("il cocktail"+ c.getNome()+ " è preparabile");
					}else {
						vistaUtente.stampaMessaggio("il cocktail " + c.getNome() + "non è preparabile");
					}
				}
				
				
			}else if(scelta==0) {
				System.exit(0);
			}
			
		}
	}
	
	public static Cocktail verificaCocktailAnalcolicoPiuCostoso(Archivio archivio) {
		double prezzoMassimo= -1;
		Cocktail cocktailMassimo=null;
		for(Cocktail c : archivio.getListaCocktail()) {
			if(c.isAlcolico()==false) {
				if(c.getCosto()>prezzoMassimo) {
					cocktailMassimo = c;
					prezzoMassimo = c.getCosto();
				}
			}
		}
		return cocktailMassimo;
	}
	
	
	

}
