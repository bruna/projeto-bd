DROP SCHEMA IF EXISTS MiniSiga_FDB;
CREATE SCHEMA MiniSiga_FDB;
use MiniSiga_FDB;

Create Table ALUNO(
	CPF VARCHAR(11) not null,
    Nome VARCHAR(30),
    Curso VARCHAR(30),
    DataI VARCHAR(10),
    
    PRIMARY KEY(CPF)
)DEFAULT CHARSET utf8;


Create Table DISCIPLINA(
	NumDiscipl VARCHAR(5) not null,
    Dnome VARCHAR(30),
    Depto VARCHAR(30),
    
    PRIMARY KEY(NumDiscipl)
)DEFAULT CHARSET utf8;

Create Table MATRICULA(
	CPF VARCHAR(11) not null,
    NumDiscipl VARCHAR(5) not null,
    Semestre VARCHAR(30) not null,
    Nota FLOAT,
    
    PRIMARY KEY(Semestre),
    FOREIGN KEY (CPF) REFERENCES ALUNO(CPF)
		ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (NumDiscipl) REFERENCES DISCIPLINA(NumDiscipl)
		ON DELETE CASCADE
        ON UPDATE CASCADE
        
)DEFAULT CHARSET utf8;

Create Table LIVRO(
	ISBNLivro VARCHAR(10) not null,
    TituloLivro VARCHAR(30),
    Editora VARCHAR(30),
    Edicao VARCHAR(10),
    Autor VARCHAR(30),
    
    PRIMARY KEY (ISBNLivro)
)DEFAULT CHARSET utf8;
    

Create Table LivroAdotado(
	NumDiscipl VARCHAR(5) not null,
    Semestre VARCHAR(30) not null,
    ISBNLivro VARCHAR(10),
    
    FOREIGN KEY (NumDiscipl) REFERENCES DISCIPLINA(NumDiscipl)
		ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (Semestre) REFERENCES MATRICULA(Semestre)
		ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (ISBNLivro) REFERENCES LIVRO(ISBNLivro)
		ON DELETE CASCADE
        ON UPDATE CASCADE
        
)DEFAULT CHARSET utf8;


    

        
    
    