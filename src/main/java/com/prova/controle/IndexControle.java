package com.prova.controle;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prova.dao.util.BibliotecaDAO;
import com.prova.modelo.Biblioteca;

/**
 * Servlet implementation class IndexControle
 */
@WebServlet("/com.prova.controle/IndexControle")
public class IndexControle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BibliotecaDAO bibliotecaDAO;
	
	public void init() {
		bibliotecaDAO = new BibliotecaDAO();
	}
	
    public IndexControle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processarRequisicao(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processarRequisicao(request, response);
	}

	private void processarRequisicao(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		String acao = request.getParameter("acao");
		
		try {
			switch(acao) {
			case "inserir":{
				gravarLivro(request, response);
				break;
			}
			}
		} catch(Exception ex) {
			throw new ServletException(ex);
		}
	}

	private void gravarLivro(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String titulo = request.getParameter("titulo");
		String autor = request.getParameter("autor");
		String genero = request.getParameter("genero");
		
		Biblioteca livro = new Biblioteca(titulo, autor, genero);
		
		bibliotecaDAO.inserirLivro(livro);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/auth/admin?acao=listar");
		dispatcher.forward(request, response);
	}

}
