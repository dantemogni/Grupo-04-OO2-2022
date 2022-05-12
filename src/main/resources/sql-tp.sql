-- MySQL Script generated by MySQL Workbench
-- Thu May 12 00:16:52 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema bd_gestion_aulas
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `bd_gestion_aulas` ;

-- -----------------------------------------------------
-- Schema bd_gestion_aulas
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bd_gestion_aulas` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Role` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Role` (
  `idRole` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idRole`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_gestion_aulas`.`Departamento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_gestion_aulas`.`Departamento` ;

CREATE TABLE IF NOT EXISTS `bd_gestion_aulas`.`Departamento` (
  `idDepartamento` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`idDepartamento`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Usuario` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Usuario` (
  `idUsuario` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `tipoDocumento` VARCHAR(45) NULL,
  `nroDocumento` DOUBLE NULL,
  `Role_idRole` INT NOT NULL,
  `apellido` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `username` VARCHAR(45) NULL,
  `contrasenia` VARCHAR(45) NULL,
  `Departamento_idDepartamento` INT NOT NULL,
  PRIMARY KEY (`idUsuario`, `Departamento_idDepartamento`),
  INDEX `fk_Usuario_Role_idx` (`Role_idRole` ASC) VISIBLE,
  INDEX `fk_Usuario_Departamento1_idx` (`Departamento_idDepartamento` ASC) VISIBLE,
  CONSTRAINT `fk_Usuario_Role`
    FOREIGN KEY (`Role_idRole`)
    REFERENCES `mydb`.`Role` (`idRole`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuario_Departamento1`
    FOREIGN KEY (`Departamento_idDepartamento`)
    REFERENCES `bd_gestion_aulas`.`Departamento` (`idDepartamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `bd_gestion_aulas` ;

-- -----------------------------------------------------
-- Table `bd_gestion_aulas`.`edificio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_gestion_aulas`.`edificio` ;

CREATE TABLE IF NOT EXISTS `bd_gestion_aulas`.`edificio` (
  `idEdificio` INT NOT NULL AUTO_INCREMENT,
  `edificio` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`idEdificio`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bd_gestion_aulas`.`aula`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_gestion_aulas`.`aula` ;

CREATE TABLE IF NOT EXISTS `bd_gestion_aulas`.`aula` (
  `idAula` INT NOT NULL AUTO_INCREMENT,
  `numero` INT NOT NULL,
  `idEdificio` INT NOT NULL,
  PRIMARY KEY (`idAula`),
  INDEX `fk_Aula_1_idx` (`idEdificio` ASC) VISIBLE,
  CONSTRAINT `fk_Aula_1`
    FOREIGN KEY (`idEdificio`)
    REFERENCES `bd_gestion_aulas`.`edificio` (`idEdificio`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bd_gestion_aulas`.`espacio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_gestion_aulas`.`espacio` ;

CREATE TABLE IF NOT EXISTS `bd_gestion_aulas`.`espacio` (
  `idEspacio` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `turno` CHAR(1) NOT NULL,
  `idAula` INT NOT NULL,
  `libre` TINYINT NOT NULL,
  PRIMARY KEY (`idEspacio`),
  INDEX `fk_Espacio_1_idx` (`idAula` ASC) VISIBLE,
  CONSTRAINT `fk_Espacio_1`
    FOREIGN KEY (`idAula`)
    REFERENCES `bd_gestion_aulas`.`aula` (`idAula`))
ENGINE = InnoDB
AUTO_INCREMENT = 64
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bd_gestion_aulas`.`laboratorio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_gestion_aulas`.`laboratorio` ;

CREATE TABLE IF NOT EXISTS `bd_gestion_aulas`.`laboratorio` (
  `idLaboratorio` INT NOT NULL,
  `cantSillas` INT NOT NULL,
  `cantPC` INT NOT NULL,
  PRIMARY KEY (`idLaboratorio`),
  CONSTRAINT `fk_Laboratorio_1`
    FOREIGN KEY (`idLaboratorio`)
    REFERENCES `bd_gestion_aulas`.`aula` (`idAula`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bd_gestion_aulas`.`tradicional`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_gestion_aulas`.`tradicional` ;

CREATE TABLE IF NOT EXISTS `bd_gestion_aulas`.`tradicional` (
  `idTradicional` INT NOT NULL,
  `cantBancos` INT NOT NULL,
  `pizarron` VARCHAR(10) NOT NULL,
  `tieneProyector` TINYINT NOT NULL,
  PRIMARY KEY (`idTradicional`),
  CONSTRAINT `fk_Tradicional_1`
    FOREIGN KEY (`idTradicional`)
    REFERENCES `bd_gestion_aulas`.`aula` (`idAula`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bd_gestion_aulas`.`Carrera`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_gestion_aulas`.`Carrera` ;

CREATE TABLE IF NOT EXISTS `bd_gestion_aulas`.`Carrera` (
  `idCarrera` INT NOT NULL,
  `carrera` VARCHAR(45) NULL,
  `Departamento_idDepartamento` INT NOT NULL,
  PRIMARY KEY (`idCarrera`, `Departamento_idDepartamento`),
  INDEX `fk_Carrera_Departamento1_idx` (`Departamento_idDepartamento` ASC) VISIBLE,
  CONSTRAINT `fk_Carrera_Departamento1`
    FOREIGN KEY (`Departamento_idDepartamento`)
    REFERENCES `bd_gestion_aulas`.`Departamento` (`idDepartamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_gestion_aulas`.`Materia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_gestion_aulas`.`Materia` ;

CREATE TABLE IF NOT EXISTS `bd_gestion_aulas`.`Materia` (
  `idMateria` INT NOT NULL,
  `codigo` INT(15) NULL,
  `nombre` VARCHAR(45) NULL,
  `Carrera_idCarrera` INT NOT NULL,
  PRIMARY KEY (`idMateria`, `Carrera_idCarrera`),
  INDEX `fk_Materia_Carrera1_idx` (`Carrera_idCarrera` ASC) VISIBLE,
  CONSTRAINT `fk_Materia_Carrera1`
    FOREIGN KEY (`Carrera_idCarrera`)
    REFERENCES `bd_gestion_aulas`.`Carrera` (`idCarrera`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_gestion_aulas`.`NotaPedido`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_gestion_aulas`.`NotaPedido` ;

CREATE TABLE IF NOT EXISTS `bd_gestion_aulas`.`NotaPedido` (
  `idNotaPedido` INT NOT NULL,
  `fecha` DATE NULL,
  `turno` CHAR NULL,
  `cantEstudiantes` VARCHAR(45) NULL,
  `observaciones` VARCHAR(45) NULL,
  `Carrera_idCarrera` INT NOT NULL,
  `aula_idAula` INT NOT NULL,
  `Materia_idMateria` INT NOT NULL,
  PRIMARY KEY (`idNotaPedido`, `Carrera_idCarrera`, `Materia_idMateria`),
  INDEX `fk_NotaPedido_Carrera1_idx` (`Carrera_idCarrera` ASC) VISIBLE,
  INDEX `fk_NotaPedido_aula1_idx` (`aula_idAula` ASC) VISIBLE,
  INDEX `fk_NotaPedido_Materia1_idx` (`Materia_idMateria` ASC) VISIBLE,
  CONSTRAINT `fk_NotaPedido_Carrera1`
    FOREIGN KEY (`Carrera_idCarrera`)
    REFERENCES `bd_gestion_aulas`.`Carrera` (`idCarrera`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_NotaPedido_aula1`
    FOREIGN KEY (`aula_idAula`)
    REFERENCES `bd_gestion_aulas`.`aula` (`idAula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_NotaPedido_Materia1`
    FOREIGN KEY (`Materia_idMateria`)
    REFERENCES `bd_gestion_aulas`.`Materia` (`idMateria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_gestion_aulas`.`Curso`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_gestion_aulas`.`Curso` ;

CREATE TABLE IF NOT EXISTS `bd_gestion_aulas`.`Curso` (
  `idCurso` INT NOT NULL,
  `codigo` VARCHAR(45) NULL,
  PRIMARY KEY (`idCurso`),
  CONSTRAINT `fk_Curso_NotaPedido1`
    FOREIGN KEY (`idCurso`)
    REFERENCES `bd_gestion_aulas`.`NotaPedido` (`idNotaPedido`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_gestion_aulas`.`Final`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_gestion_aulas`.`Final` ;

CREATE TABLE IF NOT EXISTS `bd_gestion_aulas`.`Final` (
  `idFinal` INT NOT NULL,
  `fechaeExamen` DATE NULL,
  PRIMARY KEY (`idFinal`),
  CONSTRAINT `fk_Final_1`
    FOREIGN KEY (`idFinal`)
    REFERENCES `bd_gestion_aulas`.`NotaPedido` (`idNotaPedido`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
