package Ciro.Corsi.Model;

import java.util.List;

import Ciro.Corsi.DB.CorsoDAO;
import Ciro.Corsi.DB.StatisticaDAO;
import Ciro.Corsi.DB.StudenteDAO;

public class Model {

	private CorsoDAO corsoDAO;
	private StudenteDAO studenteDAO;
	private StatisticaDAO statisticaDAO;

	public Model() {
		corsoDAO = new CorsoDAO();
		studenteDAO = new StudenteDAO();
		statisticaDAO = new StatisticaDAO();
	}

	public List<Corso> listaCorsiSemestre(int pd) {

		List<Corso> risultato2 = corsoDAO.listByPD(pd);
		return risultato2;
	}

	public String getNomeCognomeByMatricola(int matricola) {

		Studente result = studenteDAO.getNomeCognome(matricola);
		if (result != null) {
			return "Matricola: " + matricola + " " + result.toString() + "\n";
		} else
			return "Matricola non trovata";
	}

	public Statistica studentiIscrittiPerCorso(String cds) {

		Statistica result = statisticaDAO.getStatistica(cds);

		return result;
	}

}
