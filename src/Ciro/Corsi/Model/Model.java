package Ciro.Corsi.Model;


import java.util.List;

import Ciro.Corsi.DB.CorsoDAO;
import Ciro.Corsi.DB.StatisticaDAO;
import Ciro.Corsi.DB.StudenteDAO;

public class Model {
	
	private CorsoDAO corsoDAO;
	private StudenteDAO studenteDAO;
	private StatisticaDAO statisticaDAO;
	/**
	 * miglioramento
	 */
	public Model() {
		corsoDAO=new CorsoDAO();
		studenteDAO=new StudenteDAO();
		statisticaDAO=new StatisticaDAO();
	}

	//private List<Corso> corsi;
	
	public List<Corso> listaCorsiSemestre(int pd){
		
		//CorsoDAO dao=new CorsoDAO();      * miglioramento
		
	//opzione 1: leggo tutto e filtro io
		
//		this.corsi= dao.listAll();
//		
//		List<Corso> risultato=new ArrayList<>();
//		
//		for(Corso c: this.corsi) {
//			if(c.getPd()== pd) {
//				risultato.add(c);
//			}
//		}
//		return risultato;
		
	//opzione 2: faccio lavorare il database
		
		List<Corso> risultato2=corsoDAO.listByPD(pd);
		return risultato2;
	}

	public String getNomeCognomeByMatricola(int matricola) {
		
		
		Studente result=studenteDAO.getNomeCognome(matricola);
		if(result!=null) {
		return "Matricola: "+ matricola+" " +result.toString()+"\n";
		}else return "Matricola non trovata";
	}

	public Statistica studentiIscrittiPerCorso(String cds) {
		
		Statistica result=statisticaDAO.getStatistica(cds);
		
		return result;
	}

	
//	public String Stampa(List<Corso> risultato)  {
//		String messaggio="";
//		for(Corso c: risultato ) {
//			messaggio+= c.toString()+"\n";
//		}
//		return messaggio;
//		
//	}
	
	
	
}
