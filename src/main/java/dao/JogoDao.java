package main.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.java.dao.utils.ConnectionUtils;
import main.java.model.Jogo;

public class JogoDao {

	public static Jogo obterPorId(Integer id) {
		String sql = "Select nome, genero from jogo  " + " where id = ?";
		
		Connection conn;
		try {
			conn = ConnectionUtils.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			
			if (rs.next()) {
				String nome = rs.getString("nome");
				String genero = rs.getString("genero");
				return new Jogo(id, nome, genero);
			}
			ConnectionUtils.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Jogo obterPorNome(String nome) {
		String sql = "Select id, genero from jogo  " + " where nome = ?";

		Connection conn;
		try {
			conn = ConnectionUtils.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, nome);
			ResultSet rs = pstm.executeQuery();

			if (rs.next()) {
				Integer id = rs.getInt("id");
				String genero = rs.getString("genero");
				return new Jogo(id, nome, genero);
			}
			ConnectionUtils.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<Jogo> listar() {

		String sql = "Select id,nome,genero from jogo";

		Connection conn;
		try {
			conn = ConnectionUtils.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();

			List<Jogo> jogos = new ArrayList<Jogo>();
			while (rs.next()) {
				Integer id = rs.getInt("id");
				String nome = rs.getString("nome");
				String genero = rs.getString("genero");
				Jogo jogo = new Jogo(id, nome, genero);
				jogos.add(jogo);
			}
			ConnectionUtils.close(conn);
			return jogos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Boolean incluir(Jogo jogo) throws Exception {
		validarUnicidadeNome(jogo);
		String sql = "Insert into jogo(id, nome, genero) values(?,?,?) ";

		Connection conn;
		try {
			conn = ConnectionUtils.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);

			pstm.setInt(1, obterProximoId());
			pstm.setString(2, jogo.getNome());
			pstm.setString(3, jogo.getGenero());
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	private static Integer obterProximoId() {
		String sql = "Select max(id) as proxId from jogo";

		Connection conn;
		try {
			conn = ConnectionUtils.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();

			if (rs.next()) {
				Integer proxId = rs.getInt("proxId");
				return proxId + 1;
			}
			ConnectionUtils.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}

	public static Boolean alterar(Jogo jogo) throws Exception {
		validarUnicidadeNome(jogo);
		String sql = "Update jogo set nome = ?, genero = ? where id=? ";

		Connection conn;
		try {
			conn = ConnectionUtils.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);

			pstm.setString(1, jogo.getNome());
			pstm.setString(2, jogo.getGenero());
			pstm.setInt(3, jogo.getId());
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	private static void validarUnicidadeNome(Jogo jogo) throws Exception {
		String sql = "Select id from jogo  " + " where nome = ? ";
		if (jogo.getId() != null) {
			sql += "and id <> ?";
		}
		Connection conn;
		try {
			conn = ConnectionUtils.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, jogo.getNome());
			if (jogo.getId() != null) {
				pstm.setInt(2, jogo.getId());
			}
			ResultSet rs = pstm.executeQuery();

			if (rs.next()) {
				throw new Exception("Já existe um jogo com esse nome!");
			}
			ConnectionUtils.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Boolean excluirPorId(Integer id) {
		String sql = "Delete from jogo " + " where id = ? ";
		
		Connection conn;
		try {
			conn = ConnectionUtils.getConnection();
			
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);

			pstm.executeUpdate();
			ConnectionUtils.close(conn);
			return Boolean.TRUE;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Boolean.FALSE;
	}

}
