package model.bean;

//import java.sql.Date;

public class Aluno {

	private int cpf;
	private String nome;
	private String curso;
	private String dataInicio;
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	
	/*public void setDataInicio(Date dataInicio){
		this.dataInicio = dataInicio;
	}
	public void getDataInicio(){
		return dataInicio;
	}*/
}
