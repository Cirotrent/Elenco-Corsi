package Ciro.Corsi.Model;

public class Iscrizione {

	private int contCds;
	private String cds;

	public int getContCds() {
		return contCds;
	}

	public void setContCds(int contCds) {
		this.contCds = contCds;
	}

	public String getcds() {
		return cds;
	}

	public void setCds(String cds) {
		this.cds = cds;
	}

	public Iscrizione(int contCds, String cds) {
		super();
		this.contCds = contCds;
		this.cds = cds;
	}

	@Override
	public String toString() {
		return "Numero di iscritti=" + contCds + ", corso di studio=" + cds + "]";
	}

}
