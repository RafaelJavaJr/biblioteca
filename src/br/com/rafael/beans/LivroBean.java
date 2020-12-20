package br.com.rafael.beans;

public class LivroBean {

	private String registro,nome,autor,editora;
	private int quantidade,emprestimo;
	public LivroBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LivroBean(String registro, String nome, String autor, String editora, int quantidade) {
		super();
		this.registro = registro;
		this.nome = nome;
		this.autor = autor;
		this.editora = editora;
		this.quantidade = quantidade;
	}
	public String getRegistro() {
		return registro;
	}
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public int getEmprestimo() {
		return emprestimo;
	}
	public void setEmprestimo(int emprestimo) {
		this.emprestimo = emprestimo;
	}
	
}

