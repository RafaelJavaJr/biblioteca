package br.com.rafael.servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rafael.beans.LivroBean;
import br.com.rafael.beans.PessoaBean;
import br.com.rafael.dao.LivroDao;
import br.com.rafael.dao.PessoaDao;
@WebServlet("/ViewBook")
public class ListaLivro extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>View Book</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navlibrarian.html").include(request, response);
		
		out.println("<div class='container'>");
		
		List<LivroBean> list=LivroDao.view();
		
		out.println("<table class='table table-bordered table-striped'>");
		out.println("<tr><th>Callno</th><th>Name</th><th>Author</th><th>Publisher</th><th>Quantity</th><th>Issued</th><th>Delete</th></tr>");
		for(LivroBean bean:list){
			out.println("<tr><td>"+bean.getRegistro()+"</td><td>"+bean.getNome()+"</td><td>"+bean.getAutor()+"</td><td>"+bean.getEditora()+"</td><td>"+bean.getQuantidade()+"</td><td>"+bean.getEmprestimo()+"</td><td><a href='DeleteLivro?registro="+bean.getRegistro()+"'>Delete</a></td></tr>");
		}
		out.println("</table>");
		
		out.println("</div>");
		
		
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}
}
