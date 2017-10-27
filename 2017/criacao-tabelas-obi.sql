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

