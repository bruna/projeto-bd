DROP SCHEMA IF EXISTS MiniSiga_FDB;
CREATE SCHEMA MiniSiga_FDB;
use MiniSiga_FDB;

Create Table ALUNO(
	CPF INTEGER not null,
    Nome VARCHAR(30),
    Curso VARCHAR(30),
    DataI VARCHAR(30),
    
    PRIMARY KEY(CPF)
)DEFAULT CHARSET utf8;


Create Table DISCIPLINA(
	NumDiscipl INTEGER not null,
    Dnome VARCHAR(30),
    Depto VARCHAR(30),
    
    PRIMARY KEY(NumDiscipl)
)DEFAULT CHARSET utf8;

Create Table MATRICULA(
	CPF INTEGER not null,
    NumDiscipl INTEGER not null,
    Semestre VARCHAR(30) not null,
    Nota INTEGER,
    
    PRIMARY KEY(Semestre),
    FOREIGN KEY (CPF) REFERENCES ALUNO(CPF)
		ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (NumDiscipl) REFERENCES DISCIPLINA(NumDiscipl)
		ON DELETE CASCADE
        ON UPDATE CASCADE
        
)DEFAULT CHARSET utf8;

Create Table LIVRO(
	ISBNLivro INTEGER not null,
    TituloLivro VARCHAR(30),
    Editora VARCHAR(30),
    Edicao INTEGER,
    Autor VARCHAR(30),
    
    PRIMARY KEY (ISBNLivro)
)DEFAULT CHARSET utf8;
    

Create Table LivroAdotado(
	NumDiscipl INTEGER not null,
    Semestre VARCHAR(30) not null,
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


    

        
    
    