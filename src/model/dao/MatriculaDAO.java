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
import model.bean.Matricula;

public class MatriculaDAO {
	
	public void create(Matricula m){
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO MATRICULA (CPF,NumDiscipl,Semestre,Nota)VALUES(?,?,?,?);");
			stmt.setString(1, m.getCPF());
			stmt.setString(2, m.getNumDiscipl());
			stmt.setString(3, m.getSemestre());
			stmt.setString(4, m.getNota());
			
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
			
		}catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
			
		}finally{
			ConnectionFactory.closeConnection(con, stmt);
		}
		
	}
	
	public List<Matricula> read(){
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<Matricula> matriculas = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM matricula");
			rs = stmt.executeQuery();
			
			while (rs.next()){
				
				Matricula matricula = new Matricula();
				
				matricula.setCPF(rs.getString("CPF"));
				matricula.setNumDiscipl(rs.getString("NumDiscipl"));
				matricula.setSemestre(rs.getString("Semestre"));
				matricula.setNota(rs.getString("Nota"));
				
				matriculas.add(matricula);	
			}
			
		} catch (SQLException ex) {
			Logger.getLogger(MatriculaDAO.class.getName(), null).log(Level.SEVERE, null, ex);
		}finally{
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		
		return matriculas;
		
		
	}

}
