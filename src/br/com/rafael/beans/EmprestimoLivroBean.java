package br.com.rafael.beans;

import java.sql.Date;

public class EmprestimoLivroBean {

	private String registro,estudanteid,estudantenome;
	private long estudantetelefone;
	private Date emprestimodata;
	private String retornostatus;

	public EmprestimoLivroBean() {}
	public EmprestimoLivroBean(String registro, String estudanteid, String estudantenome, long estudantetelefone) {
		super();
		this.registro = registro;
		this.estudanteid = estudanteid;
		this.estudantenome = estudantenome;
		this.estudantetelefone = estudantetelefone;
	}
	public String getRegistro() {
		return registro;
	}
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	public String getEstudanteid() {
		return estudanteid;
	}
	public void setEstudanteid(String estudanteid) {
		this.estudanteid = estudanteid;
	}
	public String getEstudantenome() {
		return estudantenome;
	}
	public void setEstudantenome(String estudantenome) {
		this.estudantenome = estudantenome;
	}
	public long getEstudantetelefone() {
		return estudantetelefone;
	}
	public void setEstudantetelefone(long estudantetelefone) {
		this.estudantetelefone = estudantetelefone;
	}
	public Date getEmprestimodata() {
		return emprestimodata;
	}
	public void setEmprestimodata(Date emprestimodata) {
		this.emprestimodata = emprestimodata;
	}
	public String getRetornostatus() {
		return retornostatus;
	}
	public void setRetornostatus(String retornostatus) {
		this.retornostatus = retornostatus;
	}

}
