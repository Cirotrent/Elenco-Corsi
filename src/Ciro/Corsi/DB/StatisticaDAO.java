package Ciro.Corsi.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Ciro.Corsi.Model.Statistica;


public class StatisticaDAO {

	public Statistica getStatistica(String codins) {
		
		String sql="SELECT corso.nome, cds, COUNT(cds) " + 
				"FROM  corso , studente as s,iscrizione as i " + 
				"WHERE corso.codins=i.codins AND s.matricola=i.matricola AND i.codins=? AND cds <> \"\"  " + 
				"GROUP BY cds " ;
		
		Statistica stat=new Statistica();
		
		
		
		try {
			
			//Connection conn = DriverManager.getConnection(jdbcURL);
			//#semp
			Connection conn=ConnectDB.getConnection();
			
			PreparedStatement st= conn.prepareStatement(sql);
			
			st.setString(1, codins);
			ResultSet res = st.executeQuery();
			
			while(res.next()) {
				
				stat.getMappaCDS().put(res.getString("cds"), res.getInt("COUNT(cds)"));
				stat.setInsegnamento(res.getString("corso.nome"));
//				Iscrizione i=new Iscrizione(res.getInt("COUNT(cds)"), res.getString("cds"));
//				
//				result.add(i);
//				
			}
		
			st.close();
			
			conn.close();
			
		} catch (SQLException e) {
			
			System.out.println(e);
			return null;
		}
		return stat;
	}

}
