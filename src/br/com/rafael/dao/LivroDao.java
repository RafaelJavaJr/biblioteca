package br.com.rafael.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.rafael.beans.LivroBean;
import br.com.rafael.beans.EmprestimoLivroBean;
import br.com.rafael.beans.PessoaBean;
import br.com.rafael.connection.DB;

public class LivroDao {

	public static int save(LivroBean bean){
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("insert into livro values(?,?,?,?,?,?)");
			ps.setString(1,bean.getRegistro());
			ps.setString(2,bean.getNome());
			ps.setString(3,bean.getAutor());
			ps.setString(4,bean.getEditora());
			ps.setInt(5,bean.getQuantidade());
			ps.setInt(6,0);
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	public static List<LivroBean> view(){
		List<LivroBean> list=new ArrayList<LivroBean>();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from livro");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				LivroBean bean=new LivroBean();
				bean.setRegistro(rs.getString("registro"));
				bean.setNome(rs.getString("nome"));
				bean.setAutor(rs.getString("autor"));
				bean.setEditora(rs.getString("editora"));
				bean.setQuantidade(rs.getInt("quantidade"));
				bean.setEmprestimo(rs.getInt("emprestimo"));
				
				list.add(bean);
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return list;
	}
	public static int delete(String registro){
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("delete from livro where registro=?");
			ps.setString(1,registro);
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	public static int getIssued(String registro){
		int issued=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from livro where registro=?");
			ps.setString(1,registro);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				issued=rs.getInt("emprestimo");
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return issued;
	}
	public static boolean checkIssue(String registro){
		boolean status=false;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from livro where registro=? and quantidade>emprestimo");
			ps.setString(1,registro);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				status=true;
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	public static int issueBook(EmprestimoLivroBean bean){
		String registro=bean.getRegistro();
		boolean checkstatus=checkIssue(registro);
		System.out.println("Check status: "+checkstatus);
		if(checkstatus){
			int status=0;
			try{
				Connection con=DB.getCon();
				PreparedStatement ps=con.prepareStatement("insert into emprestimolivro values(?,?,?,?,?,?)");
				ps.setString(1,bean.getRegistro());
				ps.setString(2,bean.getEstudanteid());
				ps.setString(3,bean.getEstudantenome());
				ps.setLong(4,bean.getEstudantetelefone());
				java.sql.Date currentDate=new java.sql.Date(System.currentTimeMillis());
				ps.setDate(5,currentDate);
				ps.setString(6,"no");
				
				status=ps.executeUpdate();
				if(status>0){
					PreparedStatement ps2=con.prepareStatement("update livro set emprestimo=? where registro=?");
					ps2.setInt(1,getIssued(registro)+1);
					ps2.setString(2,registro);
					status=ps2.executeUpdate();
				}
				con.close();
				
			}catch(Exception e){System.out.println(e);}
			
			return status;
		}else{
			return 0;
		}
	}
	public static int returnBook(String registro,int estudanteid){
		int status=0;
			try{
				Connection con=DB.getCon();
				PreparedStatement ps=con.prepareStatement("update e_issuebook set returnstatus='yes' where registro=? and estudanteid=?");
				ps.setString(1,registro);
				ps.setInt(2,estudanteid);
				
				status=ps.executeUpdate();
				if(status>0){
					PreparedStatement ps2=con.prepareStatement("update e_book set issued=? where registro=?");
					ps2.setInt(1,getIssued(registro)-1);
					ps2.setString(2,registro);
					status=ps2.executeUpdate();
				}
				con.close();
				
			}catch(Exception e){System.out.println(e);}
			
			return status;
	}
	public static List<EmprestimoLivroBean> viewIssuedBooks(){
		List<EmprestimoLivroBean> list=new ArrayList<EmprestimoLivroBean>();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from e_issuebook order by issueddate desc");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				EmprestimoLivroBean bean=new EmprestimoLivroBean();
				bean.setRegistro(rs.getString("registro"));
				bean.setEstudanteid(rs.getString("estudanteid"));
				bean.setEstudantenome(rs.getString("estudantenome"));
				bean.setEstudantetelefone(rs.getLong("studentmobile"));
				bean.setEmprestimodata(rs.getDate("emprestimodata"));
				bean.setRetornostatus(rs.getString("retornostatus"));
				list.add(bean);
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return list;
	}
/*	public static int update(LibrarianBean bean){
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("update e_librarian set name=?,email=?,password=?,mobile=? where id=?");
			ps.setString(1,bean.getName());
			ps.setString(2,bean.getEmail());
			ps.setString(3,bean.getPassword());
			ps.setLong(4,bean.getMobile());
			ps.setInt(5,bean.getId());
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	public static LibrarianBean viewById(int id){
		LibrarianBean bean=new LibrarianBean();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from e_librarian where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setPassword(rs.getString(3));
				bean.setEmail(rs.getString(4));
				bean.setMobile(rs.getLong(5));
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return bean;
	}
*/
}
