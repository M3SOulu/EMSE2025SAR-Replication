DROP TABLE IF EXISTS students;
CREATE TABLE students(
    id  SERIAL PRIMARY KEY NOT NULL,
    email    TEXT    NOT NULL
);

DROP TABLE IF EXISTS teachers;
CREATE TABLE teachers(
    id  SERIAL PRIMARY KEY NOT NULL,
    email    TEXT    NOT NULL
);

DROP TABLE IF EXISTS category_groups;
CREATE TABLE category_groups(
    id  SERIAL PRIMARY KEY NOT NULL,
    level INTEGER NOT NULL,
	count INTEGER NOT NULL,
	category_id INTEGER NOT NULL
);

DROP TABLE IF EXISTS configurations;
CREATE TABLE configurations(
    id  SERIAL PRIMARY KEY NOT NULL,
    email    TEXT    NOT NULL
);

DROP TABLE IF EXISTS assignments;
CREATE TABLE assignments(
	id  SERIAL PRIMARY KEY NOT NULL,
	student_id INTEGER REFERENCES students(id),
	teachers_id INTEGER REFERENCES teachers(id),
	configuration_id INTEGER REFERENCES configurations(id)
);

DROP TABLE IF EXISTS tests;
CREATE TABLE tests(
	id  SERIAL PRIMARY KEY NOT NULL,
	assignment_id INTEGER REFERENCES assignments(id),
	wrong_answers INTEGER NOT NULL,
	right_answers INTEGER NOT NULL,
	question_ids INTEGER[] NOT NULL,
	answer_ids INTEGER[] NOT NULL,
	time_started TIMESTAMP NOT NULL,
	time_finished TIMESTAMP NOT NULL
);

DROP TABLE IF EXISTS answers;
CREATE TABLE answers(
    id  SERIAL PRIMARY KEY NOT NULL,
    test_id INTEGER REFERENCES tests(id),
	question_ids INTEGER[],
	choices_id INTEGER[]
);

