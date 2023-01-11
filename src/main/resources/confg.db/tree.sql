create table tree
(
    idbase            int primary key,
    type_emplacement  varchar(20)  not null,
    domanialite       varchar(30)  not null,
    arrondissement    varchar(40)  not null,
    complement_adress varchar(100) not null,
    numero            varchar(10)  not null,
    address           varchar(150) not null,
    idemplacement     varchar(20),
    libell_francais   varchar(40),
    genre             varchar(25),
    espece            varchar(40)
);

