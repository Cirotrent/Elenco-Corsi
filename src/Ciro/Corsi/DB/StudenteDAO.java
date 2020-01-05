package Ciro.Corsi.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Ciro.Corsi.Model.Studente;

public class StudenteDAO {
	public Studente getNomeCognome(int matricola) {

		Studente result = null;

		String sql2 = "SELECT matricola, cognome, nome, CDS " + "FROM studente WHERE matricola=?";
		try {
			Connection conn = ConnectDB.getConnection();

			PreparedStatement st;

			st = conn.prepareStatement(sql2);
			st.setInt(1, matricola);
			ResultSet res = st.executeQuery();
			if (res.next()) {
				result = new Studente(matricola, res.getString("nome"), res.getString("cognome"), res.getString("CDS"));

			}

			st.close();

			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}

		return result;
	}
}
