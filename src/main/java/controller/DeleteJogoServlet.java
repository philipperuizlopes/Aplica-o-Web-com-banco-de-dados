package main.java.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.dao.JogoDao;

@WebServlet("/deleteJogo")
public class DeleteJogoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteJogoServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Integer id = Integer.parseInt(request.getParameter("id"));
		
		JogoDao.excluirPorId(id);
		
		response.sendRedirect(request.getContextPath() + "/jogosList");
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
