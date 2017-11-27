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

create table delegado (
  codigo serial primary key,
  nome varchar(50) not null,
  email varchar(100) not null,
  ddd integer not null,
  telefone varchar(10) not null,
  escola integer not null,
  
  foreign key (escola) references escola(codigo)
);

create table aluno (
  codigo serial primary key,
  nome varchar(50) not null,
  datanascimento date not null,
  escola integer not null,
  anocurso integer not null,
  nivelcurso integer not null,
  nivelmodalidade integer not null,
  
  foreign key (escola) references escola(codigo),
  foreign key (nivelcurso) references nivelcurso(codigo),
  foreign key (nivelmodalidade) references nivelmodalidade(codigo)
);

create table prova (
  codigo serial primary key,
  fase integer not null,
  nivelmodalidade integer not null,
  dataprova date not null,
  horarioinicio time not null,
  horariotermino time not null,
  cadernoquestoes varchar(200) not null,
  totalpontos integer,
  
  foreign key (fase) references fase(codigo),
  foreign key (nivelmodalidade) references nivelmodalidade(codigo)
);

create table questaoprova (
  codigo serial primary key,
  prova integer not null,
  nomequestao varchar(50) not null,
  valor integer not null,
  
  foreign key (prova) references prova(codigo)
);

create table resposta (
  codigo serial primary key,
  aluno integer not null,
  prova integer not null,
  questaoprova integer not null,
  solucao varchar(200) not null,
  linguagem integer not null,
  pontos integer,
  
  foreign key (aluno) references aluno(codigo),
  foreign key (prova) references prova(codigo),
  foreign key (questaoprova) references questaoprova(codigo),
  foreign key (linguagem) references linguagem(codigo)
);

create table resultado (
  codigo serial primary key,
  aluno integer not null,
  prova integer not null,
  faseprova integer not null,
  pontosobtidos integer not null,
  totalpontos integer not null,
  nota integer not null,
  
  foreign key (aluno) references aluno(codigo),
  foreign key (prova) references prova(codigo),
  foreign key (faseprova) references fase(codigo)
);

create table classificacao (
  aluno integer primary key,
  notafaselocal integer not null,
  notafaseestadual integer not null,
  notafinal integer not null,
  
  foreign key (aluno) references aluno(codigo)
);
