create table if not exists post (
    id serial primary key,
    name text,
    text text,
    link text UNIQUE,
    created date
)