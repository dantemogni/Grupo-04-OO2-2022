--DEPAPARTAMENTO--
INSERT INTO `departamento` VALUES (1, "Desarrollo Productivo y Tecnologico");

--ROLES--
INSERT INTO `bd_gestion_aulas`.`rol` VALUES (1, 'Administrador');
INSERT INTO `bd_gestion_aulas`.`rol` VALUES (2, 'Auditor');
INSERT INTO `bd_gestion_aulas`.`rol` VALUES (3, 'Asistente');
INSERT INTO `bd_gestion_aulas`.`rol` VALUES (4, 'Alumno');
INSERT INTO `bd_gestion_aulas`.`rol` VALUES (5, 'Profesor');

--USUARIOS--
INSERT INTO `usuario` (id, nombre, apellido, email, username, password, tipo_documento, nro_documento, id_role, enabled, id_departamento) VALUES (1, "Admin", "Test", "admin@unla.edu.ar", "admintest", "$2a$12$QvM5mvSxdVRyoY79LRGQ1uLw7s7yprsghnkiyrHKQr3pVR1kJbSOq" , "DNI", 123456789, 1, 1, 1);
