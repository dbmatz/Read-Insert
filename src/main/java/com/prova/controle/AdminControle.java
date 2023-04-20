package com.prova.controle;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prova.dao.util.BibliotecaDAO;
import com.prova.modelo.Biblioteca;

/**
 * Servlet implementation class AdminControle
 */
@WebServlet("/auth/admin")
public class AdminControle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BibliotecaDAO bibliotecaDAO;
	
	public void init() {
		bibliotecaDAO = new BibliotecaDAO();
	}
	
    public AdminControle() {
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
			case "listar":
				listarLivros(request, response);
				break;
			}
		}catch (Exception ex) {
			throw new ServletException(ex);
		}
	}

	private void listarLivros(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		List<Biblioteca> livros = bibliotecaDAO.listarTodosLivros();
		
		request.setAttribute("listaLivros", livros);
		
		String path = request.getServletPath() + "/admin-listar-livros.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		
		dispatcher.forward(request, response);
	}

}
