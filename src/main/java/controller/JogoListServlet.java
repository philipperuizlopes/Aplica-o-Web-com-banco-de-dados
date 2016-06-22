package main.java.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.dao.JogoDao;
import main.java.model.Jogo;

@WebServlet("/jogosList")
public class JogoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Jogo> list = null;
		list = JogoDao.listar();

		request.setAttribute("jogosList", list);

		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/jogo-list-view.jsp");
		dispatcher.forward(request, response);
	}
}
