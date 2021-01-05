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
import br.com.rafael.beans.EmprestimoLivroBean;
import br.com.rafael.dao.LivroDao;
@WebServlet("/ViewIssuedBook")
public class ListaEmprestimoLivro extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Livros Emprestados</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navlibrarian.html").include(request, response);
		
		out.println("<div class='container'>");
		
		List<EmprestimoLivroBean> list=LivroDao.viewIssuedBooks();
		
		out.println("<table class='table table-bordered table-striped'>");
		out.println("<tr><th>Registro</th><th>Id do Estudante</th><th>Nome do Estudante</th><th>Telefone</th><th>Data de Empréstimo</th><th>Estatus do Retorno</th></tr>");
		for(EmprestimoLivroBean bean:list){
			out.println("<tr><td>"+bean.getRegistro()+"</td><td>"+bean.getEstudanteid()+"</td><td>"+bean.getEstudantenome()+"</td><td>"+bean.getEstudantetelefone()+"</td><td>"+bean.getEmprestimodata()+"</td><td>"+bean.getRetornostatus()+"</td></tr>");
		}
		out.println("</table>");
		
		out.println("</div>");
		
		
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}
}
