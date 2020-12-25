package br.com.rafael.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rafael.dao.LivroDao;
@WebServlet("/DeleteBook")
public class DeleteLivro extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LivroDao.delete(request.getParameter("registro"));
		response.sendRedirect("ViewBook");
	}
}
