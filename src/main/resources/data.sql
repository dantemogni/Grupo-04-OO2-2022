--DEPAPARTAMENTO--
INSERT INTO `departamento` VALUES (1, "Desarrollo Productivo y Tecnologico");

--ROLES--
INSERT INTO `bd_gestion_aulas`.`rol` VALUES (1, 'ROLE_ADMIN');
INSERT INTO `bd_gestion_aulas`.`rol` VALUES (2, 'ROLE_AUDITOR');
INSERT INTO `bd_gestion_aulas`.`rol` VALUES (3, 'ROLE_ASISTENTE');
INSERT INTO `bd_gestion_aulas`.`rol` VALUES (4, 'ROLE_ALUMNO');
INSERT INTO `bd_gestion_aulas`.`rol` VALUES (5, 'ROLE_PROFESOR');

--USUARIOS--
INSERT INTO `usuario` (id, nombre, apellido, email, username, password, tipo_documento, nro_documento, id_role, enabled) VALUES (1, "Admin", "Test", "admin@unla.edu.ar", "admintest", "$2a$12$QvM5mvSxdVRyoY79LRGQ1uLw7s7yprsghnkiyrHKQr3pVR1kJbSOq" , "dni", 123456789, 1, 1);
