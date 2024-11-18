DROP TABLE IF EXISTS users;
CREATE TABLE users(
    id  SERIAL PRIMARY KEY NOT NULL,
    email    TEXT    NOT NULL
);

DROP TABLE IF EXISTS configuration;
CREATE TABLE configuration(
    id  SERIAL PRIMARY KEY NOT NULL,
    email    TEXT    NOT NULL,
    description    TEXT    NOT NULL
);

DROP TABLE IF EXISTS category;
CREATE TABLE category(
	id  SERIAL PRIMARY KEY NOT NULL,
	name    TEXT    NOT NULL
);


DROP TABLE IF EXISTS assignment;
CREATE TABLE assignment(
	id  SERIAL PRIMARY KEY NOT NULL,
	student_id INTEGER REFERENCES users(id),
	teachers_id INTEGER REFERENCES users(id),
	configuration_id INTEGER REFERENCES configurations(id)
);


DROP TABLE IF EXISTS config_category;
CREATE TABLE category(
	id  SERIAL PRIMARY KEY NOT NULL,
	config_id INTEGER REFERENCES configuration(id),
	category_id INTEGER REFERENCES category(id)
);


DROP TABLE IF EXISTS category_specification;
CREATE TABLE configuration(
    id  SERIAL PRIMARY KEY NOT NULL,
    category_id INTEGER REFERENCES category(id),
    description    TEXT    NOT NULL,

);