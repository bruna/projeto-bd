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
import model.bean.Disciplina;

public class DisciplinaDAO {

	public void create(Disciplina d) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("INSERT INTO DISCIPLINA (numDiscipl, dnome, depto)VALUES(?,?,?);");
			stmt.setString(1, d.getNumDiscipl());
			stmt.setString(2, d.getDnome());
			stmt.setString(3, d.getDepto());

			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public List<Disciplina> read() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Disciplina> disciplinas = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT * FROM DISCIPLINA");
			rs = stmt.executeQuery();

			while (rs.next()) {

				Disciplina disciplina = new Disciplina();

				disciplina.setNumDiscipl(rs.getString("numdiscipl"));
				disciplina.setDnome(rs.getString("dnome"));
				disciplina.setDepto(rs.getString("depto"));

				disciplinas.add(disciplina);
			}

		} catch (SQLException ex) {
			Logger.getLogger(DisciplinaDAO.class.getName(), null).log(Level.SEVERE, null, ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return disciplinas;
	}

	public void update(Disciplina d) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(
					"UPDATE DISCIPLINA SET numDiscipl = ?, dnome = ?, depto = ? WHERE numDiscipl = ?");
			stmt.setString(1, d.getNumDiscipl());
			stmt.setString(2, d.getDnome());
			stmt.setString(3, d.getDepto());
			stmt.setString(4, d.getNumDiscipl());

			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public void delete(Disciplina d) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("DELETE FROM DISCIPLINA WHERE numDiscipl = ?");
			stmt.setString(1, d.getNumDiscipl());

			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
}
