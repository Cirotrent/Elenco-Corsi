package Ciro.Corsi.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Ciro.Corsi.Model.Corso;

public class CorsoDAO {

	/**
	 * # opzione 2 Ritorna i corsi che hanno questo periodo didattico{@code pd}
	 * 
	 * @param pd
	 * @return
	 */
	public List<Corso> listByPD(int pd) {

		String sql = "SELECT codins, crediti, nome, pd " + "FROM corso WHERE pd = ?";

		List<Corso> result = new ArrayList<>();

		try {

			Connection conn = ConnectDB.getConnection();

			PreparedStatement st = conn.prepareStatement(sql);

			st.setInt(1, pd);
			ResultSet res = st.executeQuery();

			while (res.next()) {

				Corso c = new Corso(res.getString("codins"), res.getString("nome"), res.getInt("crediti"),
						res.getInt("pd"));

				result.add(c);

			}

			st.close();

			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}
		return result;
	}

	/**
	 * # opzione 1 Ritorna tutti gli elementi della tabella CORSO
	 * 
	 * @return
	 */
	public List<Corso> listAll() {

		String sql = "SELECT codins, crediti, nome, pd " + "FROM corso";
		List<Corso> result = new ArrayList<>();

		try {

			Connection conn = ConnectDB.getConnection();

			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet res = st.executeQuery();

			while (res.next()) {

				Corso c = new Corso(res.getString("codins"), res.getString("nome"), res.getInt("crediti"),
						res.getInt("pd"));

				result.add(c);

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
