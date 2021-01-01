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
@WebServlet("/EditLibrarianForm")
public class EditPessoaForm extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Editar Bibliotecário</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		request.getRequestDispatcher("navadmin.html").include(request, response);
		out.println("<div class='container'>");
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		
		PessoaBean bean=PessoaDao.viewById(id);
		
		out.print("<form action='EditLibrarian' method='post' style='width:300px'>");
		out.print("<div class='form-group'>");
		out.print("<input type='hidden' name='id' value='"+bean.getId()+"'/>");
		out.print("<label for='name1'>Nome</label>");
		out.print("<input type='text' class='form-control' value='"+bean.getNome()+"' name='nome' id='nome' placeholder='Nome'/>");
		out.print("</div>");
		out.print("<div class='form-group'>");
		out.print("<label for='email1'>Email</label>");
		out.print("<input type='email' class='form-control' value='"+bean.getEmail()+"'  name='email' id='email' placeholder='Email'/>");
		out.print("</div>");
		out.print("<div class='form-group'>");
		out.print("<label for='senha'>Senha</label>");
		out.print("<input type='password' class='form-control' value='"+bean.getSenha()+"'  name='senha' id='senha' placeholder='Senha'/>");
		out.print("</div>  ");
		out.print("<div class='form-group'>");
		out.print("<label for='mobile1'>Telefone</label>");
		out.print("<input type='number' class='form-control' value='"+bean.getTelefone()+"'  name='telefone' id='telefone' placeholder='Telefone'/>");
		out.print("</div>");
		out.print("<button type='submit' class='btn btn-primary'>Atualizar</button>");
		out.print("</form>");
		
		out.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
		
	}
}
