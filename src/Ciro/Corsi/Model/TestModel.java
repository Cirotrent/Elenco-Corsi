package Ciro.Corsi.Model;





public class TestModel {

	public static void main(String[] args) {
		
	Model m =new Model();
	
//	List<Corso> corsi=m.listaCorsiSemestre(2);
//	
//	for(Corso c:corsi) {
//		System.out.println(c);
//	}
//	int matricola=146101;
//	String result= m.getNomeCognomeByMatricola(matricola);
//	System.out.println("Matricola: "+ matricola+" "+result);
	
	Statistica statistica=m.studentiIscrittiPerCorso("01NBAPG");
	System.out.println(statistica);
	
//	for(Iscrizione s:statistica) {
//		System.out.println(s);
//	}
	}

}
