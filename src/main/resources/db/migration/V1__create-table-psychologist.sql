create table psychologist (
    crp varchar(100) not null,
    name varchar(100) not null,
    email varchar(100) not null unique,
    street varchar(100) not null,
    neighborhood varchar(100) not null,
    zip varchar(9) not null,
    complement varchar(100),
    number varchar(20),
    state char(2) not null,
    city varchar(100) not null,
    telephone varchar(100) not null,
    health_insurance varchar(100) not null,
    active boolean,
    primary key(crp)
);