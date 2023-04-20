package com.prova.dao.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import com.prova.modelo.Biblioteca;

public class BibliotecaDAO {
	private Connection connection;
	
	private void conectar() throws SQLException {
		if(connection == null || connection.isClosed()) {
			connection = Conexao.getConexao();
		}
	}
	
	private void desconectar() throws SQLException {
		if(connection != null && !connection.isClosed()) {
			connection.close();
		}
	}
	
	public Biblioteca inserirLivro(Biblioteca livro) throws SQLException {
		String sql = "insert into livro (titulo, autor, genero)"
				+ "values (?, ?, ?)";
		
		conectar();
		
		PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, livro.getTitulo());
		statement.setString(2, livro.getAutor());
		statement.setString(3, livro.getGenero());
		
		statement.executeUpdate();
		
		ResultSet result = statement.getGeneratedKeys();
		int id = 0;
		if(result.next()) {
			id = result.getInt("id");
		}
		statement.close();
		
		desconectar();
		
		livro.setId(id);
		return livro;
	}
	
	public List<Biblioteca> listarTodosLivros() throws SQLException{
		List<Biblioteca> listaLivros = new ArrayList<Biblioteca>();
		
		String sql = "select * from livro";
		
		conectar();
		
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(sql);
		
		while(result.next()) {
			int id = result.getInt("id");
			String titulo = result.getString("titulo");
			String autor = result.getString("autor");
			String genero = result.getString("genero");
			
			Biblioteca livro = new Biblioteca(titulo, autor, genero);
			livro.setId(id);
			listaLivros.add(livro);
		}
		
		result.close();
		statement.close();
		
		desconectar();
		
		return listaLivros;
	}
}
