create table if not exists post (
    id serial primary key not null,
    name varchar,
    text varchar,
    link varchar UNIQUE,
    created date
)