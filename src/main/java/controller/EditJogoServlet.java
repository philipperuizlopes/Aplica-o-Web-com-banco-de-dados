package main.java.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.dao.JogoDao;
import main.java.model.Jogo;

@WebServlet("/editJogo")
public class EditJogoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditJogoServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Integer id = Integer.parseInt(request.getParameter("id"));
		
		Jogo jogo = JogoDao.obterPorId(id);
		request.setAttribute("jogo", jogo);
		
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/edit-jogo-view.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
