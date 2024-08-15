create table if not exists products (
    id bigint auto_increment,
    name varchar(255),
    description varchar(500),
    image varchar(255),
    tag varchar(255),
    price number(7,2),
    primary key(id)
);