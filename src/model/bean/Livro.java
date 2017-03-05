package model.bean;

public class Livro {
	private String iSBNLivro;
	private String tituloLivro;
	private String editora;
	private String edicao;
	private String autor;
	
	public String getISBNLivro() {
		return iSBNLivro;
	}
	public void setISBNLivro(String newisbnlivro) {
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
	public String getEdicao() {
		return edicao;
	}
	public void setEdicao(String newedicao) {
		edicao = newedicao;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String newautor) {
		autor = newautor;
	}
}
