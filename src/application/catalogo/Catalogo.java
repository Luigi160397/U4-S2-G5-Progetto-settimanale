package application.catalogo;

import java.util.UUID;

public abstract class Catalogo {

	private UUID ISBN = UUID.randomUUID();
	private String titolo;
	private int annoPublicazione;
	private int nPagine;

	public Catalogo(String titolo, int annoPubblicazione, int nPagine) {
		setISBN(ISBN);
		setTitolo(titolo);
		setAnnoPublicazione(annoPubblicazione);
		setnPagine(nPagine);
	}

	public UUID getISBN() {
		return ISBN;
	}

	public void setISBN(UUID iSBN) {
		ISBN = iSBN;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getAnnoPublicazione() {
		return annoPublicazione;
	}

	public void setAnnoPublicazione(int annoPublicazione) {
		this.annoPublicazione = annoPublicazione;
	}

	public int getnPagine() {
		return nPagine;
	}

	public void setnPagine(int nPagine) {
		this.nPagine = nPagine;
	}

	@Override
	public abstract String toString();
}
