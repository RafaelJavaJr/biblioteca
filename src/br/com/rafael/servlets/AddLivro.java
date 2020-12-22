package br.com.rafael.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

import br.com.rafael.beans.LivroBean;
import br.com.rafael.dao.LivroDao;
@WebServlet("/AddLivro")
public class AddLivro extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Add Book Form</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navlibrarian.html").include(request, response);
		
		out.println("<div class='container'>");
		String registro=request.getParameter("registro");
		String nome=request.getParameter("nome");
		String autor=request.getParameter("autor");
		String editora=request.getParameter("editora");
		String squantidade=request.getParameter("quantidade");
		int quantidade=Integer.parseInt(squantidade);
		LivroBean bean=new LivroBean(registro,nome,autor,editora,quantidade);
		int i=LivroDao.save(bean);
		if(i>0){
			out.println("<h3>Book saved successfully</h3>");
		}
		request.getRequestDispatcher("addbookform.html").include(request, response);
		out.println("</div>");
		
		
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}

}
