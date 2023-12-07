package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Controllo.Main;
import Modello.Cocktail;
import Modello.Ingrediente;
import Persistenza.Archivio;

class ProvaTest {

	@Test
	void testIsPreparabile() {
		Cocktail c = new Cocktail("gintonic", 22);
		Ingrediente gin = new Ingrediente("gin", 2, true);
		Ingrediente tonica = new Ingrediente("tonica", 2, false);
		c.addIngrediente(gin);
		c.addIngrediente(tonica);
		List<String> dispenza = new ArrayList<>();
		
		dispenza.add("gin");
		dispenza.add("tonica");
		dispenza.add("acqua");
		dispenza.add("ghiaccio");
		assertEquals(true, c.isPreparabile(dispenza));
		
		List<String> dispenza2 = new ArrayList<>();
		dispenza2.add("gin");
		assertEquals(false, c.isPreparabile(dispenza2));
		assertEquals(true, c.isAlcolico());
		
		
	}
	
	@Test
	void testCocktailPiuCostoso() {
		Archivio archivio = new Archivio();
		Cocktail cocktail1 = new Cocktail("gintonic",30);
		Cocktail cocktail2 = new Cocktail("acqua",2);
		Cocktail cocktail3 = new Cocktail("vino",5);
		archivio.addCocktail(cocktail1);
		archivio.addCocktail(cocktail2);
		archivio.addCocktail(cocktail3);
		
		Ingrediente ingrediente = new Ingrediente("gin",20,true);
		Ingrediente ingrediente1 = new Ingrediente("tonica",20,false);
		cocktail1.addIngrediente(ingrediente);
		cocktail1.addIngrediente(ingrediente1);
		
		Ingrediente ingrediente2= new Ingrediente("acqua",20,false);
		cocktail2.addIngrediente(ingrediente2);
		
		Ingrediente ingrediente3=new Ingrediente("vino",3,true);
		cocktail3.addIngrediente(ingrediente3);
		
		assertEquals(cocktail2, Main.verificaCocktailAnalcolicoPiuCostoso(archivio));
		
		
		
	}
	
	@BeforeEach
	void pulizia() {
		System.out.println("pulizia");
	}

	@AfterAll
	static void chiusura() {
		System.out.println("chiusura");
	}
}
