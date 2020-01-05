package Ciro.Corsi.Model;

import java.util.HashMap;
import java.util.Map;

public class Statistica {
	private String insegnamento;
	Map <String,Integer> mappaCDS;
	
	public Statistica() {
		mappaCDS=new HashMap<>();
	}

	public Map<String, Integer> getMappaCDS() {
		return mappaCDS;
	}

	public void setMappaCDS(Map<String, Integer> mappaCDS) {
		this.mappaCDS = mappaCDS;
	}

	@Override
	public String toString() {
		return "Insegnamento: "+ insegnamento+"  ->  Statistica: \n"+ stampaMappa(mappaCDS);
	}

	

	public String getInsegnamento() {
		return insegnamento;
	}

	public void setInsegnamento(String insegnamento) {
		this.insegnamento = insegnamento;
	}
	
	public String stampaMappa( Map<String, Integer> m) {
		
		StringBuilder sb=new StringBuilder();
		for(String cds:getMappaCDS().keySet()) {
			sb.append(" - "+ cds +" -> "+getMappaCDS().get(cds)+"\n");
		}
		
		return sb.toString();
	}
	
}
