package br.com.rafael.servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rafael.beans.PessoaBean;
import br.com.rafael.dao.PessoaDao;
@WebServlet("/ViewLibrarian")
public class ListaPessoa extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>View Librarian</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		request.getRequestDispatcher("navadmin.html").include(request, response);
		out.println("<div class='container'>");
		
		List<PessoaBean> list=PessoaDao.view();
		
		out.println("<table class='table table-bordered table-striped'>");
		out.println("<tr><th>Id</th><th>Nome</th><th>Email</th><th>Senha</th><th>Telefone</th><th>Editar</th><th>Deletar</th></tr>");
		for(PessoaBean bean:list){
			out.println("<tr><td>"+bean.getId()+"</td><td>"+bean.getNome()+"</td><td>"+bean.getEmail()+"</td><td>"+bean.getSenha()+"</td><td>"+bean.getTelefone()+"</td><td><a href='EditLibrarianForm?id="+bean.getId()+"'>Editar</a></td><td><a href='DeleteLibrarian?id="+bean.getId()+"'>Deletar</a></td></tr>");
		}
		out.println("</table>");
		
		out.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
		
	}
}
