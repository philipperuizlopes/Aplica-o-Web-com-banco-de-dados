package main.java.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.dao.JogoDao;
import main.java.model.Jogo;

@WebServlet("/doEditJogo")
public class DoEditJogoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Integer id = Integer.parseInt(request.getParameter("id"));
		String nome = (String) request.getParameter("nome");
		String genero = (String) request.getParameter("genero");

		Jogo jogo = new Jogo(id, nome, genero);
		try {
			JogoDao.alterar(jogo);
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
