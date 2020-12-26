package br.com.rafael.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rafael.beans.PessoaBean;
import br.com.rafael.dao.PessoaDao;
@WebServlet("/EditLibrarian")
public class EditPessoa extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		String name=request.getParameter("nome");
		String email=request.getParameter("email");
		String password=request.getParameter("senha");
		String smobile=request.getParameter("telefone");
		long telefone=Long.parseLong(smobile);
		PessoaBean bean=new PessoaBean(id,name, email, password, telefone);
		PessoaDao.update(bean);
		response.sendRedirect("ViewLibrarian");
	}

}
