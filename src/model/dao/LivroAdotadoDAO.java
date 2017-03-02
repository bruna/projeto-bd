package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.bean.LivroAdotado;

public class LivroAdotadoDAO {
	
	public void create(LivroAdotado la){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO LivroAdotado (NumDiscipl,Semestre,ISBNLivro)VALUES(?,?,?);");
			
			stmt.setString(1,la.getNumDiscipl());
			stmt.setString(2,la.getSemestre());
			stmt.setString(3,la.getISBNLivro());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Salvo com sucesso!");	
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
		}finally{
			ConnectionFactory.closeConnection(con, stmt);
		}
		
	}
	
public List<LivroAdotado> read(){
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<LivroAdotado> las = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM LivroAdotado");
			rs = stmt.executeQuery();
			
			while (rs.next()){
				
				LivroAdotado ladotado = new LivroAdotado();
				
				ladotado.setNumDiscipl(rs.getString("NumDiscipl"));
				ladotado.setSemestre(rs.getString("Semestre"));
				ladotado.setISBNLivro(rs.getString("ISBNLivro"));
				
				las.add(ladotado);	
			}
			
		} catch (SQLException ex) {
			Logger.getLogger(LivroAdotadoDAO.class.getName(), null).log(Level.SEVERE, null, ex);
		}finally{
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return las;
	}

}
