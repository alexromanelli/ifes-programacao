create table Lista_Comandos (
    id serial primary key,
    nome varchar(100) not null
);

create table Comando (
    id serial primary key,
    lista integer not null,
    sequencial integer not null,    
    tipo char(1) not null,
    angulo integer,
    coord_x integer,
    coord_y integer,
    coord_z integer,

    foreign key (lista) references Lista_Comandos(id),

    -- verificação de presença de ângulo ou coordenadas
    check (((angulo is null) and (
            (coord_x is not null) and (coord_y is not null) and (coord_z is not null))) or
           ((angulo is not null) and (
            (coord_x is null) and (coord_y is null) and (coord_z is null))))
);

insert into Lista_Comandos (nome)
values ('Pega caneta e marca ponto'), ('Quadrado');

insert into Comando (lista, sequencial, tipo, angulo)
values (1, 1, 'G', 140);
insert into Comando (lista, sequencial, tipo, coord_x, coord_y, coord_z)
values (1, 2, 'P', 30, 40, 70),
       (1, 3, 'P', 30, 40, 60),
       (1, 4, 'P', 30, 40, 50),
       (1, 5, 'P', 50, 50, 70);
insert into Comando (lista, sequencial, tipo, angulo)
values (1, 6, 'G', 150);







