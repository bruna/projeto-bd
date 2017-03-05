package model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;//Atencao pacote diferente do import de Bruna
import javax.swing.JOptionPane;
import connection.ConnectionFactory;
import model.bean.Aluno;

public class AlunoDAO {
	
	public void create(Aluno a){
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO ALUNO (cpf, nome, curso, dataI)VALUES(?,?,?,?);");
			stmt.setString(1,a.getCpf());
			stmt.setString(2,a.getNome());
			stmt.setString(3,a.getCurso());
			stmt.setString(4, a.getDataInicio());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Salvo com sucesso!");	
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
		}finally{
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public List<Aluno> read(){
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<Aluno> alunos = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM ALUNO");
			rs = stmt.executeQuery();
			
			while (rs.next()){
				
				Aluno aluno = new Aluno();
				
				aluno.setCpf(rs.getString("cpf"));
				aluno.setNome(rs.getString("nome"));
				aluno.setCurso(rs.getString("curso"));
				aluno.setDataInicio(rs.getString("dataI"));
				alunos.add(aluno);	
			}
			
		} catch (SQLException ex) {
			Logger.getLogger(AlunoDAO.class.getName(), null).log(Level.SEVERE, null, ex);
		}finally{
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return alunos;
	}
	
public void update(Aluno a){
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("UPDATE ALUNO SET cpf = ?, nome = ?, curso = ?, dataI = ? WHERE cpf = ?");
			stmt.setString(1,a.getCpf());
			stmt.setString(2,a.getNome());
			stmt.setString(3,a.getCurso());
			stmt.setString(4, a.getDataInicio());
			stmt.setString(5,a.getCpf());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");	
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar: "+ex);
		}finally{
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
}
