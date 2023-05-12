package application;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import application.catalogo.Catalogo;
import application.catalogo.Libro;
import application.catalogo.Periodicita;
import application.catalogo.Rivista;

public class Application {

	public static void main(String[] args) {
		List<Catalogo> listaCataloghi = new ArrayList<>();
		Catalogo libro1 = new Libro("Harry Potter", 2023, 50, "JK Rowling", "Fantasy");
		Catalogo libro2 = new Libro("Harry Potter 2", 2020, 150, "JK Rowling", "Fantasy");
		Catalogo libro3 = new Libro("Harry Potter 3", 2015, 156, "JK Rowling", "Fantasy");
		Catalogo rivista1 = new Rivista("Time", 2023, 20, Periodicita.SETTIMANALE);
		Catalogo rivista2 = new Rivista("Famiglia Cristiana", 2023, 20, Periodicita.MENSILE);

		aggiungiCatalogo(listaCataloghi, libro1);
		aggiungiCatalogo(listaCataloghi, libro2);
		aggiungiCatalogo(listaCataloghi, libro3);
		aggiungiCatalogo(listaCataloghi, rivista1);
		aggiungiCatalogo(listaCataloghi, rivista2);

		rimuoviCatalogo(listaCataloghi, libro1.getISBN());

		System.out.println("----------------- Lista Cataloghi -----------------");
		System.out.println(listaCataloghi);

		System.out.println("");

		Catalogo daCercare = cercaISBN(listaCataloghi, rivista1.getISBN());
		if (daCercare != null) {
			System.out.println("Libro/Rivista trovato/a per ISBN:");
			System.out.println(daCercare);

		} else {
			System.out.println("Libro/Rivista non trovato per ISBN");
		}

		List<Catalogo> cercatoPerAnno = cercaPerAnno(listaCataloghi, 2020);

		if (cercatoPerAnno.size() > 0) {
			System.out.println("Libro/Rivista trovato/a per anno:");
			System.out.println(cercatoPerAnno);
		} else {
			System.out.println("Nessun Libro/Rivista trovato per anno.");
		}

		List<Libro> cercatoPerAutore = cercaPerAutore(listaCataloghi, "JK Rowling");

		if (cercatoPerAutore.size() > 0) {
			System.out.println();
			System.out.println("Libri trovati per autore:");
			System.out.println(cercatoPerAutore);
		} else {
			System.out.println("Nessun libro trovato.");
		}

	}

	public static void aggiungiCatalogo(List<Catalogo> lista, Catalogo c1) {
		lista.add(c1);
	}

	public static void rimuoviCatalogo(List<Catalogo> lista, UUID isbn) {
		Iterator<Catalogo> i = lista.iterator();
		while (i.hasNext()) {
			Catalogo current = i.next();
			if (current.getISBN().equals(isbn)) {
				i.remove();
			}

		}

	}

	public static Catalogo cercaISBN(List<Catalogo> lista, UUID isbn) {
		Catalogo c = lista.stream().filter(catalogo -> catalogo.getISBN().equals(isbn)).findAny().orElse(null);
		return c;
	}

	public static List<Catalogo> cercaPerAnno(List<Catalogo> lista, int anno) {
		List<Catalogo> lista2 = lista.stream().filter(catalogo -> catalogo.getAnnoPublicazione() == anno).toList();
		return lista2;
	}

	public static List<Libro> cercaPerAutore(List<Catalogo> lista, String autore) {
		List<Libro> listaFiltrata = lista.stream()
				.filter(catalogo -> catalogo instanceof Libro && ((Libro) catalogo).getAutore().equals(autore))
				.map(catalogo -> (Libro) catalogo).toList();
		return listaFiltrata;
	}
}
