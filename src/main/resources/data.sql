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