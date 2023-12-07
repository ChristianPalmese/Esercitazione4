package Persistenza;

import java.util.ArrayList;
import java.util.List;
import Modello.Cocktail;

public class Archivio {
	List<Cocktail> listaCocktail = new ArrayList<>();
	
	public void addCocktail(Cocktail i) {
		listaCocktail.add(i);
	}
	
	public boolean containsCocktailByNome(String nome) {
		for(Cocktail i :listaCocktail) {
			if(i.getNome().equalsIgnoreCase(nome)) {
				return true;
			}
		}
		return false;
	}
	
	public Cocktail findCocktailByNome(String nome) {
		for(Cocktail i :listaCocktail) {
			if(i.getNome().equalsIgnoreCase(nome)) {
				return i;
			}
		}
		return null;
	}

	public List<Cocktail> getListaCocktail() {
		return listaCocktail;
	}

	
	
	
	 
	
	
}
