package br.com.rafael.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rafael.beans.LivroBean;
import br.com.rafael.beans.EmprestimoLivroBean;
import br.com.rafael.dao.LivroDao;
@WebServlet("/IssueBook")
public class EmprestimoLivro extends HttpServlet {
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
		String estudanteid=request.getParameter("estudanteid");
		String estudantenome=request.getParameter("estudantenome");
		String sestudantetelefone=request.getParameter("estudantetelefone");
		long estudantetelefone=Long.parseLong(sestudantetelefone);
		
		EmprestimoLivroBean bean=new EmprestimoLivroBean(registro,estudanteid,estudantenome,estudantetelefone);
		int i=LivroDao.issueBook(bean);
		if(i>0){
			out.println("<h3>Book issued successfully</h3>");
		}else{
			out.println("<h3>Sorry, unable to issue book.</h3><p>We may have sortage of books. Kindly visit later.</p>");
		}
		out.println("</div>");
		
		
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}

}
