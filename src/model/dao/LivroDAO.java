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
import model.bean.Livro;

public class LivroDAO {
	
	public void create(Livro l){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO LIVRO (ISBNLivro,TituloLivro,Editora,Edicao,Autor)"
					+ "VALUES(?,?,?,?,?);");
			stmt.setString(1,l.getISBNLivro());
			stmt.setString(2,l.getTituloLivro());
			stmt.setString(3,l.getEditora());
			stmt.setString(4,l.getEdicao());
			stmt.setString(5,l.getAutor());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Salvo com sucesso!");	
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
		}finally{
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public List<Livro> read(){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<Livro> livros = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM Livro");
			rs = stmt.executeQuery();
			
			while (rs.next()){
				
				Livro livro = new Livro();
				
				livro.setISBNLivro(rs.getString("ISBNLivro"));
				livro.setTituloLivro(rs.getString("TituloLivro"));
				livro.setEditora(rs.getString("Editora"));
				livro.setEdicao(rs.getString("Edicao"));
				livro.setAutor(rs.getString("Autor"));
				
				livros.add(livro);	
			}
			
		} catch (SQLException ex) {
			Logger.getLogger(LivroDAO.class.getName(), null).log(Level.SEVERE, null, ex);
		}finally{
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return livros;
		
	}

}
