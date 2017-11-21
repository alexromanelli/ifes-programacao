create table modalidade (
  codigo serial primary key,
  nome varchar(50) not null,
  descricao varchar(500) not null
);

create table tipoescola (
  codigo serial primary key,
  tipo varchar(20) not null
);

create table fase (
  codigo serial primary key,
  fase varchar(20) not null
);

create table linguagem (
  codigo serial primary key,
  linguagem varchar(20) not null
);

create table nivelcurso (
  codigo serial primary key,
  nivel varchar(30) not null
);

create table nivelmodalidade (
  codigo serial primary key,
  modalidade integer not null,
  nivel varchar(20) not null,
  eligibilidade varchar(200) not null,
  
  foreign key (modalidade) references modalidade(codigo)
);

create table escola (
  codigo serial primary key,
  nome varchar(100) not null,
  endereco varchar(200) not null,
  cidade varchar(50) not null,
  cep integer not null,
  ddd integer not null,
  telefone varchar(10) not null,
  tipoescola integer not null,
  
  foreign key (tipoescola) references tipoescola(codigo)
);

