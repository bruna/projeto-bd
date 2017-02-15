insert into ALUNO(CPF,Nome,Curso,DataI) values
	('654', 'Jose','Fisica','2004-05-15'),
    ('555', 'Maria', 'Biologia', '2015-05-15'),
    ('122', 'Marcia', 'Administracao', '2015-05-12'),
    ('987', 'Mario', 'Biologia', '2015-05-20');
    
insert into DISCIPLINA(NumDiscipl,Dnome,Depto) values
	('1','Cauculo','Matematica'),
    ('2','Fisica','Ciencias'),
    ('3','Portugues','Linguas');
    
insert into MATRICULA(CPF,NumDiscipl,Semestre,Nota) values
	('555','1','2016.1','9'),
   ('122','2','2015.2','8'),
    ('987','3','2015.1','10');
    
insert into LIVRO(ISBNLivro,TituloLivro,Editora,Edicao,Autor) values
	('10','Cauculo a Varias Variaveis','Exatamente','18','Claudio'),
    ('11','Gramatica','Plus','2','Marcia'),
    ('12','Fisica 2','Menos','30','Vertel');
    
insert into LivroAdotado(NumDiscipl,Semestre,ISBNLivro) values
	('1','2015.1','10'),
    ('2','2016.1','11'),
    ('3','2015.2','12');
