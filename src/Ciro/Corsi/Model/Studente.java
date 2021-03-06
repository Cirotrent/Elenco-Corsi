package Ciro.Corsi.Model;

public class Studente {
	
private int matricola;
private String nome;
private String cognome;
private String CDS;     //corso di studio
public int getMatricola() {
	return matricola;
}
public void setMatricola(int matricola) {
	this.matricola = matricola;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getCognome() {
	return cognome;
}
public void setCognome(String cognome) {
	this.cognome = cognome;
}
public String getCDS() {
	return CDS;
}
public void setCDS(String cDS) {
	CDS = cDS;
}
public Studente(int matricola, String nome, String cognome, String cDS) {
	super();
	this.matricola = matricola;
	this.nome = nome;
	this.cognome = cognome;
	CDS = cDS;
}
@Override
public String toString() {
	return "Studente [nome=" + nome + ", cognome=" + cognome + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + matricola;
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Studente other = (Studente) obj;
	if (matricola != other.matricola)
		return false;
	return true;
}



}
