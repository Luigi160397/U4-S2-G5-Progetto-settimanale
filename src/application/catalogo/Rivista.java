package application.catalogo;

public class Rivista extends Catalogo {

	private Periodicita periodicita;

	public Rivista(String titolo, int annoPubblicazione, int nPagine, Periodicita period) {
		super(titolo, annoPubblicazione, nPagine);
		setPeriodicita(period);

	}

	public Periodicita getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(Periodicita periodicita) {
		this.periodicita = periodicita;
	}

	@Override
	public String toString() {
		return "ISBN: " + getISBN() + ", Titolo: " + getTitolo() + ", Anno Pubblicazione " + getAnnoPublicazione()
				+ ", Numero pagine: " + getnPagine() + ", Periodicità: " + getPeriodicita() + System.lineSeparator();
	};

}
