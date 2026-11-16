create database cadastro_pessoa;
use cadastro_pessoa;

create table pessoa(
	id       INT AUTO_INCREMENT PRIMARY KEY,
    nome     VARCHAR(100) NOT NULL,
    endereco VARCHAR(100) NOT NULL,
    email    VARCHAR(100) NOT NULL);

create table pessoa_fisica(
	pessoa_id INT PRIMARY KEY,
    cpf       VARCHAR(14) NOT NULL,
    FOREIGN KEY(pessoa_id) REFERENCES 
     pessoa(id) ON DELETE CASCADE);
     
create table pessoa_juridica(
	pessoa_id     INT PRIMARY KEY,
    cnpj          VARCHAR(18) NOT NULL,
    nome_fantasia VARCHAR(100),
    FOREIGN KEY (pessoa_id) REFERENCES
     pessoa(id) ON DELETE CASCADE);
     
create table if not exists produto(
	id int auto_increment primary key,
    nome varchar(100) not null,
    preco decimal(10,2) not null,
    estoque int not null default 0,
    fornecedor_id int not null,
	check (preco > 0),
    check (estoque >= 0),
    foreign key (fornecedor_id) references pessoa_juridica(pessoa_id)
);

create table if not exists venda(
	id int auto_increment primary key,
    data_venda datetime not null default current_timestamp,
    cliente_id int not null,
    foreign key (cliente_id) references pessoa_fisica(pessoa_id)
);

create table if not exists item_venda(
	id int auto_increment primary key,
    venda_id int not null,
    produto_id int not null,
    quantidade int not null,
    valor_unitario decimal(10,2) not null,
    check (quantidade > 0),
    foreign key (venda_id) references venda(id) on delete cascade,
    foreign key (produto_id) references produto(id)
);

insert pessoa(nome, endereco, email)
 values('Pessoa1', 'end1','email1');
insert pessoa_fisica(pessoa_id, cpf)
 values(1,'11122233344');

insert pessoa(nome, endereco, email)
 values('Pessoa2', 'end2','email2');
 insert pessoa_juridica(pessoa_id, cnpj, 
   nome_fantasia)
   values(2,'0000000111','Nome fantasia');

select * from pessoa; 

SELECT 
 p.*, pf.cpf, pj.cnpj, pj.nome_fantasia
FROM pessoa p
 LEFT JOIN pessoa_fisica pf 
	ON p.id = pf.pessoa_id
 LEFT JOIN pessoa_juridica pj
    ON p.id = pj.pessoa_id
ORDER BY p.id;

select * from pessoa;
select * from pessoa_fisica;
select * from pessoa_juridica;

insert pessoa(nome, endereco, email)
  values('Pessoa3', 'end3','email3');

insert pessoa_fisica(pessoa_id, cpf)
 values(3,'33333333333');
 
 
 
 
 
 
 




