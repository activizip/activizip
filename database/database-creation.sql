DROP SCHEMA IF EXISTS activizip;
CREATE SCHEMA activizip;

USE activizip;

DROP TABLE IF EXISTS activity;
CREATE TABLE activity (
	id INT NOT NULL,
	creator VARCHAR(255),
	date DATE,
	description VARCHAR(255),
	location VARCHAR(255),
	max_participants INT,
	name VARCHAR(255),
	price DOUBLE,
	time VARCHAR(255),
	PRIMARY KEY (id)
);

DROP TABLE IF EXISTS user;
CREATE TABLE user (
  id bigint NOT NULL,
  birthdate date DEFAULT NULL,
  email varchar(255) DEFAULT NULL,
  last_names varchar(255) DEFAULT NULL,
  name varchar(255) DEFAULT NULL,
  password varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
);
 
DROP TABLE IF EXISTS attendance;
CREATE TABLE attendance (
  id bigint NOT NULL,
  activity_id bigint DEFAULT NULL,
  user_id bigint DEFAULT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (activity_id) REFERENCES activity(id),
  FOREIGN KEY (user_id) REFERENCES user(id)
);

INSERT INTO user VALUES (1,'1994-04-14','lauragisellesilva@gmail.com','Silva','Laura Giselle','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3'),(10,'1994-03-13','costantino.fe@gmail.com','Costantino Cardu','Federico','ba7816bf8f01cfea414140de5dae2223b00361a396177a9cb410ff61f20015ad'),(12,'1993-06-03','lukopanizza@gmail.com','Panizza','Lucas','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3'),(14,'1996-12-25','martapanizza@hotmail.com','Panizza','Marta','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3');
INSERT INTO activity VALUES (2,'Laura Giselle Silva','2022-06-12','Pasamos la mañana caminando por casa de campo para disfrutar del enorme parque y su lago con sus hermosas vistas. ','Madrid, Casa de Campo',NULL,'Senderismo en Casa de Campo',0,'10:00'),(3,'Laura Giselle Silva','2022-06-09','Partido de pádel en el polideportivo del retiro, traer pala y pelotas.\nEl nivel es para las personas que sepan sacar y mantener el peloteo.','Madrid, El Retiro',4,'Partido de Padel (Nivel Medio)',8.5,'21:00'),(6,'Laura Giselle Silva','2022-06-12','Pasaremos la tarde disfrutando del calor, traer manta, bebida, protector solar y algún juego de mesa!','Madrid, Centro el Pilar',NULL,'Día de Piscina',2.5,'16:30'),(7,'Laura Giselle Silva','2022-06-19','Nos juntamos a pasar un rato divertido en un escape room.','Madrid, Ópera',12,'Terror Escape Room',20,'19:00'),(8,'Laura Giselle Silva','2022-08-03','','Parque El Retiro',NULL,'Picnic',0,'12:00');
INSERT INTO attendance VALUES (4,2,1),(5,3,1),(9,8,1),(11,3,10),(13,3,12),(15,3,14);