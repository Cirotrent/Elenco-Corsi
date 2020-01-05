package Ciro.Corsi.Model;

public class TestModel {

	public static void main(String[] args) {

		Model m = new Model();

		Statistica statistica = m.studentiIscrittiPerCorso("01NBAPG");
		System.out.println(statistica);

	}

}
