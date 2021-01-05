package br.com.rafael.servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rafael.beans.EmprestimoLivroBean;
import br.com.rafael.dao.LivroDao;
@WebServlet("/ReturnBook")
public class DevolverLivro extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Devolver Livro</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navlibrarian.html").include(request, response);
		
		out.println("<div class='container'>");
		String registro=request.getParameter("registro");
		String sestudanteid=request.getParameter("estudanteid");
		int estudanteid=Integer.parseInt(sestudanteid);
		
		int i=LivroDao.returnBook(registro,estudanteid);
		if(i>0){
			out.println("<h3>Livro Devolvido com Sucesso!!!</h3>");
		}else{
			out.println("<h3>Desculpe, não foi possível devolver o livro.</h3><p>Por favor visite mais tarde.</p>");
		}
		out.println("</div>");
		
		
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}

}
