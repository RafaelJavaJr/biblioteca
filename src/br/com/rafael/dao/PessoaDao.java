package br.com.rafael.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.rafael.beans.PessoaBean;
import br.com.rafael.connection.DB;

public class PessoaDao {

	public static int save(PessoaBean bean){
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("insert into pessoa(nome,email,senha,telefone) values(?,?,?,?)");
			ps.setString(1,bean.getNome());
			ps.setString(2,bean.getEmail());
			ps.setString(3,bean.getSenha());
			ps.setLong(4,bean.getTelefone());
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	public static int update(PessoaBean bean){
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("update pessoa set nome=?,email=?,senha=?,telefone=? where id=?");
			ps.setString(1,bean.getNome());
			ps.setString(2,bean.getEmail());
			ps.setString(3,bean.getSenha());
			ps.setLong(4,bean.getTelefone());
			ps.setInt(5,bean.getId());
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	public static List<PessoaBean> view(){
		List<PessoaBean> list=new ArrayList<PessoaBean>();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from pessoa");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				PessoaBean bean=new PessoaBean();
				bean.setId(rs.getInt("id"));
				bean.setNome(rs.getString("nome"));
				bean.setEmail(rs.getString("email"));
				bean.setSenha(rs.getString("senha"));
				bean.setTelefone(rs.getLong("telefone"));
				list.add(bean);
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return list;
	}
	public static PessoaBean viewById(int id){
		PessoaBean bean=new PessoaBean();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from pessoa where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				bean.setId(rs.getInt(1));
				bean.setNome(rs.getString(2));
				bean.setSenha(rs.getString(3));
				bean.setEmail(rs.getString(4));
				bean.setTelefone(rs.getLong(5));
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return bean;
	}
	public static int delete(int id){
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("delete from pessoa where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}

	public static boolean authenticate(String email,String senha){
		boolean status=false;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from pessoa where email=? and senha=?");
			ps.setString(1,email);
			ps.setString(2,senha);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				status=true;
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
}
