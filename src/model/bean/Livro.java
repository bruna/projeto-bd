package model.bean;

public class Livro {
	private int iSBNLivro;
	private String tituloLivro;
	private String editora;
	private int edicao;
	private String autor;
	
	public int getISBNLivro() {
		return iSBNLivro;
	}
	public void setISBNLivro(int newisbnlivro) {
		iSBNLivro = newisbnlivro;
	}
	public String getTituloLivro() {
		return tituloLivro;
	}
	public void setTituloLivro(String newtituloLivro) {
		tituloLivro = newtituloLivro;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String neweditora) {
		editora = neweditora;
	}
	public int getEdicao() {
		return edicao;
	}
	public void setEdicao(int newedicao) {
		edicao = newedicao;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String newautor) {
		autor = newautor;
	}
	
	
	

}
