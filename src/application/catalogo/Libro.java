package application.catalogo;

public class Libro extends Catalogo {

	private String autore;
	private String genere;

	public Libro(String titolo, int annoPubblicazione, int nPagine, String autore, String genere) {
		super(titolo, annoPubblicazione, nPagine);
		setAutore(autore);
		setGenere(genere);

	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	@Override
	public String toString() {
		return "ISBN: " + getISBN() + ", Titolo: " + getTitolo() + ", Anno Pubblicazione " + getAnnoPublicazione()
				+ ", Numero pagine: " + getnPagine() + ", Autore: " + getAutore() + ", Genere: " + getGenere()
				+ System.lineSeparator();
	};

}
