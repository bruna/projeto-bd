insert into ALUNO(CPF,Nome,Curso,DataI) values
	('65422566630', 'Jose','Fisica','15-05-2004'),
    ('55566977785', 'Maria', 'Biologia', '15-05-2005'),
    ('12255566633', 'Marcia', 'Administracao', '12-05-2015'),
    ('98777777744', 'Mario', 'Biologia', '22-05-2016');
    
insert into DISCIPLINA(NumDiscipl,Dnome,Depto) values
	('1','Calculo','Matematica'),
    ('2','Fisica','Ciencias'),
    ('3','Portugues','Linguas');
    
insert into MATRICULA(CPF,NumDiscipl,Semestre,Nota) values
	('55566977785','1','2016.1','9'),
   ('12255566633','2','2015.2','8'),
    ('98777777744','3','2015.1','10');
    
insert into LIVRO(ISBNLivro,TituloLivro,Editora,Edicao,Autor) values
	('10','Calculo a Varias Variaveis','Exatas','18','Claudio'),
    ('11','Gramatica','Moderna','2','Marcia'),
    ('12','Fisica 2','Menos','30','Boldrini');
    
insert into LivroAdotado(NumDiscipl,Semestre,ISBNLivro) values
	('1','2015.1','10'),
    ('2','2016.1','11'),
    ('3','2015.2','12');
