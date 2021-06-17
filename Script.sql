CREATE database db_estudiantes;
use db_estudiantes;

CREATE table estudiante (
id MEDIUMINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR (150) NOT NULL,
segundo_nombre VARCHAR (150),
apellido VARCHAR (150) NOT NULL,
segundo_apellido VARCHAR (150),
correo VARCHAR (150) NOT NULL,
estado VARCHAR (50) NOT NULL,
fecha_nacimiento DATE NOT NULL ,
curso  MEDIUMINT NOT NULL,
FOREIGN KEY (curso) REFERENCES curso (id_curso)
);


CREATE table curso (
id_curso MEDIUMINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR (150) NOT NULL,
estado VARCHAR (50) NOT NULL
);


SELECT * FROM curso;
SELECT * FROM estudiante;
DROP TABLE estudiante;
DROP TABLE curso;


