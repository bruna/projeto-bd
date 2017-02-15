DROP SCHEMA IF EXISTS MiniSiga_FDB;
CREATE SCHEMA MiniSiga_FDB;
use MiniSiga_FDB;

Create Table ALUNO(
	CPF INTEGER,
    Nome VARCHAR(30),
    Curso VARCHAR(30),
    DataI DATE,
    
    PRIMARY KEY(CPF)
)DEFAULT CHARSET utf8;


Create Table DISCIPLINA(
	NumDiscipl INTEGER,
    Dnome VARCHAR(30),
    Depto VARCHAR(30),
    
    PRIMARY KEY(NumDiscipl)
)DEFAULT CHARSET utf8;

Create Table MATRICULA(
	CPF INTEGER,
    NumDiscipl INTEGER,
    Semestre VARCHAR(30),
    Nota INTEGER,
    
    PRIMARY KEY(Semestre),
    FOREIGN KEY (CPF) REFERENCES ALUNO(CPF)
		ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (NumDiscipl) REFERENCES DISCIPLINA(NumDiscipl)
		ON DELETE SET NULL
        ON UPDATE CASCADE
        
)DEFAULT CHARSET utf8;

Create Table LIVRO(
	ISBNLivro INTEGER,
    TituloLivro VARCHAR(30),
    Editora VARCHAR(30),
    Edicao INTEGER,
    Autor VARCHAR(30),
    
    PRIMARY KEY (ISBNLivro)
)DEFAULT CHARSET utf8;
    

Create Table LivroAdotado(
	NumDiscipl INTEGER,
    Semestre VARCHAR(30),
    ISBNLivro INTEGER,
    
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


    

        
    
    