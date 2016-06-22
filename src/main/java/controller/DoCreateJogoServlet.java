package main.java.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.dao.JogoDao;
import main.java.model.Jogo;

@WebServlet("/doCreateJogo")
public class DoCreateJogoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String nome = (String) request.getParameter("nome");
		String genero = (String) request.getParameter("genero");

		Jogo jogo = new Jogo(nome, genero);
		try {
			JogoDao.incluir(jogo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		response.sendRedirect(request.getContextPath() + "/jogosList");
	}
	

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
