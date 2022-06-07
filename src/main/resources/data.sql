-- DEPAPARTAMENTO--
INSERT INTO `departamento` VALUES (1, "Desarrollo Productivo y Tecnologico");

-- ROLES--
INSERT INTO `bd_gestion_aulas`.`rol` VALUES (1, 'ROLE_ADMIN');
INSERT INTO `bd_gestion_aulas`.`rol` VALUES (2, 'ROLE_AUDITOR');
INSERT INTO `bd_gestion_aulas`.`rol` VALUES (3, 'ROLE_ASISTENTE');
INSERT INTO `bd_gestion_aulas`.`rol` VALUES (4, 'ROLE_ALUMNO');
INSERT INTO `bd_gestion_aulas`.`rol` VALUES (5, 'ROLE_PROFESOR');

-- USUARIOS--
INSERT INTO `usuario` (id, nombre, apellido, email, username, password, tipo_documento, nro_documento, id_role, enabled) VALUES (1, "Admin", "Test", "admin@unla.edu.ar", "admintest", "$2a$12$QvM5mvSxdVRyoY79LRGQ1uLw7s7yprsghnkiyrHKQr3pVR1kJbSOq" , "dni", 123456789, 1, 1);
INSERT INTO `usuario` (id, nombre, apellido, email, username, password, tipo_documento, nro_documento, id_role, enabled) VALUES (2, "Auditor", "Test", "auditor@unla.edu.ar", "auditor", "$2a$12$QvM5mvSxdVRyoY79LRGQ1uLw7s7yprsghnkiyrHKQr3pVR1kJbSOq" , "dni", 123456789, 2, 1);
INSERT INTO `usuario` (id, nombre, apellido, email, username, password, tipo_documento, nro_documento, id_role, enabled) VALUES (3, "Profesor", "Test", "profe@unla.edu.ar", "profe", "$2a$12$QvM5mvSxdVRyoY79LRGQ1uLw7s7yprsghnkiyrHKQr3pVR1kJbSOq" , "dni", 123456789, 5, 1);

-- CARRERAS--
use bd_gestion_aulas;
INSERT INTO `carrera` (id, carrera, id_departamento) VALUES (1,"Gestion Ambiental",1);
INSERT INTO `carrera` (id, carrera, id_departamento) VALUES (2,"Economia Empresarial",1);
INSERT INTO `carrera` (id, carrera, id_departamento) VALUES (3,"Economia Política",1);
INSERT INTO `carrera` (id, carrera, id_departamento) VALUES (4,"Ciencia y tec. de alimentos",1);
INSERT INTO `carrera` (id, carrera, id_departamento) VALUES (5,"Lic.Turismo",1);
INSERT INTO `carrera` (id, carrera, id_departamento) VALUES (6,"Ciclo Lic. Turismo",1);
INSERT INTO `carrera` (id, carrera, id_departamento) VALUES (7,"Sistemas",1);
INSERT INTO `carrera` (id, carrera, id_departamento) VALUES (8,"Tec. Ferroviarias",1);
INSERT INTO `carrera` (id, carrera, id_departamento) VALUES (9,"Lic. Logistitca",1);
INSERT INTO `carrera` (id, carrera, id_departamento) VALUES (10,"Ciclo Lic. Logística",1);

-- MATERIAS --
INSERT INTO `materia` (id, codigo, nombre, id_carrera) VALUES (1, 8600, "Programación", 7);
INSERT INTO `materia` (id, codigo, nombre, id_carrera) VALUES (2, 8605, "Algoritmos", 7);
INSERT INTO `materia` (id, codigo, nombre, id_carrera) VALUES (3, 8601, "Org.Computadoras", 7);
INSERT INTO `materia` (id, codigo, nombre, id_carrera) VALUES (4, 8603, "Matemáticas", 7);
INSERT INTO `materia` (id, codigo, nombre, id_carrera) VALUES (5, 8602, "Arq.Computadoras", 7);
INSERT INTO `materia` (id, codigo, nombre, id_carrera) VALUES (6, 8606, "Pensamiento Científico", 7);
INSERT INTO `materia` (id, codigo, nombre, id_carrera) VALUES (7, 8604, "Matemáticas II", 7);

-- EDIFICIO --
INSERT INTO `edificio` (id, edificio) VALUES (1, "José Hernandez");
INSERT INTO `edificio` (id, edificio) VALUES (2, "Juana Manso");
INSERT INTO `edificio` (id, edificio) VALUES (3, "Irma Laciar de Carrica");
INSERT INTO `edificio` (id, edificio) VALUES (4, "Leonardo Werthein");
INSERT INTO `edificio` (id, edificio) VALUES (5, "Oscar Varsavsky");
INSERT INTO `edificio` (id, edificio) VALUES (6, "Macedonio Fernandez");
INSERT INTO `edificio` (id, edificio) VALUES (7, "Raúl Scalabrini Ortiz");
INSERT INTO `edificio` (id, edificio) VALUES (8, "Arturo Jauretche");
INSERT INTO `edificio` (id, edificio) VALUES (9, "Manuel Ugarte");
INSERT INTO `edificio` (id, edificio) VALUES (10, "Hoemero Manzi");
INSERT INTO `edificio` (id, edificio) VALUES (11, "Leopoldo Marechal");
INSERT INTO `edificio` (id, edificio) VALUES (12, "Juana Azurduy");
INSERT INTO `edificio` (id, edificio) VALUES (13, "Néstor Kirchner");

-- AULA --
INSERT INTO `aula` (id, numero, edificio_id) VALUES (1, 1, 1);
INSERT INTO `aula` (id, numero, edificio_id) VALUES (2, 2, 1);
INSERT INTO `aula` (id, numero, edificio_id) VALUES (3, 3, 1);
INSERT INTO `aula` (id, numero, edificio_id) VALUES (4, 4, 1);
INSERT INTO `aula` (id, numero, edificio_id) VALUES (5, 5, 1);
INSERT INTO `aula` (id, numero, edificio_id) VALUES (6, 6, 1);
INSERT INTO `aula` (id, numero, edificio_id) VALUES (7, 7, 1);
INSERT INTO `aula` (id, numero, edificio_id) VALUES (8, 8, 1);
INSERT INTO `aula` (id, numero, edificio_id) VALUES (9, 9, 1);
INSERT INTO `aula` (id, numero, edificio_id) VALUES (10, 1, 2);
INSERT INTO `aula` (id, numero, edificio_id) VALUES (11, 2, 2);
INSERT INTO `aula` (id, numero, edificio_id) VALUES (12, 3, 2);
INSERT INTO `aula` (id, numero, edificio_id) VALUES (13, 1, 3);
INSERT INTO `aula` (id, numero, edificio_id) VALUES (14, 2, 3);
INSERT INTO `aula` (id, numero, edificio_id) VALUES (15, 3, 3);
INSERT INTO `aula` (id, numero, edificio_id) VALUES (16, 1, 4);
INSERT INTO `aula` (id, numero, edificio_id) VALUES (17, 2, 4);
INSERT INTO `aula` (id, numero, edificio_id) VALUES (18, 3, 4);
INSERT INTO `aula` (id, numero, edificio_id) VALUES (19, 4, 4);
INSERT INTO `aula` (id, numero, edificio_id) VALUES (20, 1, 5);
INSERT INTO `aula` (id, numero, edificio_id) VALUES (21, 2, 5);
INSERT INTO `aula` (id, numero, edificio_id) VALUES (22, 3, 5);
INSERT INTO `aula` (id, numero, edificio_id) VALUES (23, 4, 5);
INSERT INTO `aula` (id, numero, edificio_id) VALUES (24, 1, 6);
INSERT INTO `aula` (id, numero, edificio_id) VALUES (25, 2, 6);
INSERT INTO `aula` (id, numero, edificio_id) VALUES (26, 1, 7);
INSERT INTO `aula` (id, numero, edificio_id) VALUES (27, 2, 7);
INSERT INTO `aula` (id, numero, edificio_id) VALUES (28, 1, 8);
INSERT INTO `aula` (id, numero, edificio_id) VALUES (29, 2, 8);
INSERT INTO `aula` (id, numero, edificio_id) VALUES (30, 3, 8);
INSERT INTO `aula` (id, numero, edificio_id) VALUES (31, 1, 9);
INSERT INTO `aula` (id, numero, edificio_id) VALUES (32, 2, 9);
INSERT INTO `aula` (id, numero, edificio_id) VALUES (33, 3, 9);
INSERT INTO `aula` (id, numero, edificio_id) VALUES (34, 4, 9);
INSERT INTO `aula` (id, numero, edificio_id) VALUES (35, 5, 9);
INSERT INTO `aula` (id, numero, edificio_id) VALUES (36, 6, 9);
INSERT INTO `aula` (id, numero, edificio_id) VALUES (37, 1, 10);
INSERT INTO `aula` (id, numero, edificio_id) VALUES (38, 2, 10);
INSERT INTO `aula` (id, numero, edificio_id) VALUES (39, 3, 10);
INSERT INTO `aula` (id, numero, edificio_id) VALUES (40, 4, 10);
INSERT INTO `aula` (id, numero, edificio_id) VALUES (41, 1, 11);
INSERT INTO `aula` (id, numero, edificio_id) VALUES (42, 2, 11);
INSERT INTO `aula` (id, numero, edificio_id) VALUES (43, 3, 11);
INSERT INTO `aula` (id, numero, edificio_id) VALUES (44, 4, 11);
INSERT INTO `aula` (id, numero, edificio_id) VALUES (45, 1, 12);
INSERT INTO `aula` (id, numero, edificio_id) VALUES (46, 2, 12);
INSERT INTO `aula` (id, numero, edificio_id) VALUES (47, 1, 13);
INSERT INTO `aula` (id, numero, edificio_id) VALUES (48, 2, 13);

-- AULA TRADICIONAL -- 
INSERT INTO `tradicional` (id, cant_bancos, pizarron, tiene_proyector) VALUES (1, 70, "Tiza", 0);
INSERT INTO `tradicional` (id, cant_bancos, pizarron, tiene_proyector) VALUES (2, 65, "Tiza", 1);
INSERT INTO `tradicional` (id, cant_bancos, pizarron, tiene_proyector) VALUES (3, 80, "Marcador", 0);
INSERT INTO `tradicional` (id, cant_bancos, pizarron, tiene_proyector) VALUES (4, 90, "Tiza", 0);
INSERT INTO `tradicional` (id, cant_bancos, pizarron, tiene_proyector) VALUES (5, 70, "Tiza", 1);
INSERT INTO `tradicional` (id, cant_bancos, pizarron, tiene_proyector) VALUES (6, 70, "Marcador", 0);
INSERT INTO `tradicional` (id, cant_bancos, pizarron, tiene_proyector) VALUES (7, 70, "Tiza", 0);
INSERT INTO `tradicional` (id, cant_bancos, pizarron, tiene_proyector) VALUES (8, 70, "Tiza", 0);
INSERT INTO `tradicional` (id, cant_bancos, pizarron, tiene_proyector) VALUES (10, 50, "Marcador", 1);
INSERT INTO `tradicional` (id, cant_bancos, pizarron, tiene_proyector) VALUES (11, 50, "Marcador", 1);
INSERT INTO `tradicional` (id, cant_bancos, pizarron, tiene_proyector) VALUES (12, 50, "Marcador", 1);
INSERT INTO `tradicional` (id, cant_bancos, pizarron, tiene_proyector) VALUES (13, 70, "Tiza", 0);
INSERT INTO `tradicional` (id, cant_bancos, pizarron, tiene_proyector) VALUES (14, 73, "Tiza", 0);
INSERT INTO `tradicional` (id, cant_bancos, pizarron, tiene_proyector) VALUES (15, 68, "Tiza", 0);
INSERT INTO `tradicional` (id, cant_bancos, pizarron, tiene_proyector) VALUES (20, 70, "Tiza", 1);
INSERT INTO `tradicional` (id, cant_bancos, pizarron, tiene_proyector) VALUES (21, 70, "Tiza", 0);
INSERT INTO `tradicional` (id, cant_bancos, pizarron, tiene_proyector) VALUES (23, 70, "Tiza", 1);
INSERT INTO `tradicional` (id, cant_bancos, pizarron, tiene_proyector) VALUES (24, 100, "Marcador", 1);
INSERT INTO `tradicional` (id, cant_bancos, pizarron, tiene_proyector) VALUES (25, 100, "Marcador", 1);
INSERT INTO `tradicional` (id, cant_bancos, pizarron, tiene_proyector) VALUES (28, 70, "Tiza", 0);
INSERT INTO `tradicional` (id, cant_bancos, pizarron, tiene_proyector) VALUES (29, 70, "Tiza", 0);
INSERT INTO `tradicional` (id, cant_bancos, pizarron, tiene_proyector) VALUES (30, 70, "Tiza", 0);
INSERT INTO `tradicional` (id, cant_bancos, pizarron, tiene_proyector) VALUES (31, 90, "Tiza", 0);
INSERT INTO `tradicional` (id, cant_bancos, pizarron, tiene_proyector) VALUES (32, 70, "Tiza", 1);
INSERT INTO `tradicional` (id, cant_bancos, pizarron, tiene_proyector) VALUES (33, 65, "Tiza", 0);
INSERT INTO `tradicional` (id, cant_bancos, pizarron, tiene_proyector) VALUES (34, 70, "Marcador", 0);
INSERT INTO `tradicional` (id, cant_bancos, pizarron, tiene_proyector) VALUES (35, 70, "Tiza", 1);
INSERT INTO `tradicional` (id, cant_bancos, pizarron, tiene_proyector) VALUES (37, 70, "Tiza", 0);
INSERT INTO `tradicional` (id, cant_bancos, pizarron, tiene_proyector) VALUES (38, 70, "Tiza", 0);
INSERT INTO `tradicional` (id, cant_bancos, pizarron, tiene_proyector) VALUES (39, 70, "Tiza", 0);
INSERT INTO `tradicional` (id, cant_bancos, pizarron, tiene_proyector) VALUES (40, 70, "Tiza", 1);
INSERT INTO `tradicional` (id, cant_bancos, pizarron, tiene_proyector) VALUES (41, 70, "Marcador", 1);
INSERT INTO `tradicional` (id, cant_bancos, pizarron, tiene_proyector) VALUES (42, 70, "Marcador", 1);
INSERT INTO `tradicional` (id, cant_bancos, pizarron, tiene_proyector) VALUES (43, 70, "Marcador", 1);
INSERT INTO `tradicional` (id, cant_bancos, pizarron, tiene_proyector) VALUES (44, 70, "Marcador", 1);
INSERT INTO `tradicional` (id, cant_bancos, pizarron, tiene_proyector) VALUES (47, 70, "Marcador", 1);

-- AULA LABORATORIO -- 
INSERT INTO `laboratorio` (id, cant_pc, cant_sillas) VALUES (9, 50, 65);
INSERT INTO `laboratorio` (id, cant_pc, cant_sillas) VALUES (16, 45, 50);
INSERT INTO `laboratorio` (id, cant_pc, cant_sillas) VALUES (17, 45, 50);
INSERT INTO `laboratorio` (id, cant_pc, cant_sillas) VALUES (18, 45, 50);
INSERT INTO `laboratorio` (id, cant_pc, cant_sillas) VALUES (19, 45, 50);
INSERT INTO `laboratorio` (id, cant_pc, cant_sillas) VALUES (22, 30, 30);
INSERT INTO `laboratorio` (id, cant_pc, cant_sillas) VALUES (26, 30, 30);
INSERT INTO `laboratorio` (id, cant_pc, cant_sillas) VALUES (27, 30, 30);
INSERT INTO `laboratorio` (id, cant_pc, cant_sillas) VALUES (36, 47, 50);
INSERT INTO `laboratorio` (id, cant_pc, cant_sillas) VALUES (45, 60, 60);
INSERT INTO `laboratorio` (id, cant_pc, cant_sillas) VALUES (46, 60, 60);
INSERT INTO `laboratorio` (id, cant_pc, cant_sillas) VALUES (48, 35, 39);