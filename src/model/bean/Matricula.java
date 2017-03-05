package model.bean;

public class Matricula {
	
	private String CPF;
	private String NumDiscipl;
	private String Semestre;
	private float Nota;
	
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getNumDiscipl() {
		return NumDiscipl;
	}
	public void setNumDiscipl(String numDiscipl) {
		NumDiscipl = numDiscipl;
	}
	public String getSemestre() {
		return Semestre;
	}
	public void setSemestre(String semestre) {
		Semestre = semestre;
	}
	public float getNota() {
		return Nota;
	}
	public void setNota(float nota) {
		Nota = nota;
	}	
}
