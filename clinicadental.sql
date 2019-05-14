/**********************************/
/*SCRIPT BASE DATOS CLINICA DENTAL*/
/**********************************/

/*Crear base datos*/
DROP DATABASE IF EXISTS `clinicadental`;
CREATE DATABASE IF NOT EXISTS `clinicadental`;

/*Usar base datos*/
USE `clinicadental`;

/*Crear tabla usuario*/
DROP TABLE IF EXISTS `clinicadental`.`usuario`;
CREATE TABLE IF NOT EXISTS `clinicadental`.`usuario` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `nombre`VARCHAR(100) NOT NULL,
  `usuario` VARCHAR(100) NOT NULL,
  `contraseña` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_usuario`))
ENGINE = InnoDB;

/*Crear tabla especialidad*/
DROP TABLE IF EXISTS `clinicadental`.`especialidad`;
CREATE TABLE IF NOT EXISTS `clinicadental`.`especialidad` (
  `id_especialidad` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_especialidad`))
ENGINE = InnoDB;

/*Crear tabla tratamiento*/
CREATE TABLE IF NOT EXISTS `clinicadental`.`tratamiento` (
  `id_tratamiento` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `costo` INT NOT NULL,
  PRIMARY KEY (`id_tratamiento`))
ENGINE = InnoDB;

/*Crear tabla dentista*/
DROP TABLE IF EXISTS `clinicadental`.`dentista`;
CREATE TABLE IF NOT EXISTS `clinicadental`.`dentista` (
  `id_dentista` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) DEFAULT NULL,
  `apellido` VARCHAR(100) DEFAULT NULL,
  `especialidad` INT DEFAULT NULL,
  PRIMARY KEY (`id_dentista`),
  INDEX `especialidad_fk_idx` (`especialidad` ASC),
  CONSTRAINT `especialidad_fk`
    FOREIGN KEY (`especialidad`)
    REFERENCES `clinicadental`.`especialidad` (`id_especialidad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

/*Crear tabla paciente*/
DROP TABLE IF EXISTS `clinicadental`.`paciente`;
CREATE TABLE IF NOT EXISTS `clinicadental`.`paciente` (
  `id_paciente` INT NOT NULL AUTO_INCREMENT,
  `rut` VARCHAR(12) DEFAULT NULL,
  `nombre` VARCHAR(100) DEFAULT NULL,
  `apellido` VARCHAR(100) DEFAULT NULL,
  `direccion` VARCHAR(200) DEFAULT NULL,
  `telefono` INT DEFAULT NULL,
  `email` VARCHAR(200) DEFAULT NULL,
  PRIMARY KEY (`id_paciente`),
  UNIQUE INDEX `rut_UNIQUE` (`rut` ASC))
ENGINE = InnoDB;

/*Crear tabla atención*/
DROP TABLE IF EXISTS `clinicadental`.`atencion`;
CREATE TABLE IF NOT EXISTS `clinicadental`.`atencion` (
  `id_atencion` INT NOT NULL AUTO_INCREMENT,
  `fecha_registro` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dia` INT DEFAULT NULL,
  `mes` INT DEFAULT NULL,
  `anio` INT DEFAULT NULL,
  `paciente` INT DEFAULT NULL,
  `dentista` INT DEFAULT NULL,
  `tratamiento` INT DEFAULT NULL,
  `descripcion` VARCHAR(250) DEFAULT NULL,
  PRIMARY KEY (`id_atencion`),
  INDEX `paciente_fk_idx` (`paciente` ASC),
  INDEX `dentista_fk_idx` (`dentista` ASC),
  INDEX `tratamiento_fk_idx` (`tratamiento` ASC),
  CONSTRAINT `paciente_fk`
    FOREIGN KEY (`paciente`)
    REFERENCES `clinicadental`.`paciente` (`id_paciente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `dentista_fk`
    FOREIGN KEY (`dentista`)
    REFERENCES `clinicadental`.`dentista` (`id_dentista`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `tratamiento_fk`
    FOREIGN KEY (`tratamiento`)
    REFERENCES `clinicadental`.`tratamiento` (`id_tratamiento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

/*Insertar usuario admin*/
INSERT INTO `clinicadental`.`usuario` (nombre, usuario, contraseña)
VALUES ("Matias Barrenechea","matiasb@admin.cl","admin");

/*Insertar especialidades*/
INSERT INTO `clinicadental`.`especialidad` (nombre)
VALUES ("Odontología General");

INSERT INTO `clinicadental`.`especialidad` (nombre)
VALUES ("Endodoncia");

INSERT INTO `clinicadental`.`especialidad` (nombre)
VALUES ("Ortodoncia");

INSERT INTO `clinicadental`.`especialidad` (nombre)
VALUES ("Periodoncia");

INSERT INTO `clinicadental`.`especialidad` (nombre)
VALUES ("Odontopediatría");

INSERT INTO `clinicadental`.`especialidad` (nombre)
VALUES ("Implantología");

/*Insertar tratamientos*/
INSERT INTO `clinicadental`.`tratamiento` (nombre, costo)
VALUES ("Limpieza bucal",15000);

INSERT INTO `clinicadental`.`tratamiento` (nombre, costo)
VALUES ("Tapadura",25000);

INSERT INTO `clinicadental`.`tratamiento` (nombre, costo)
VALUES ("Endodoncia",120000);

INSERT INTO `clinicadental`.`tratamiento` (nombre, costo)
VALUES ("Ortodoncia",85000);

INSERT INTO `clinicadental`.`tratamiento` (nombre, costo)
VALUES ("Periodoncia",90000);

INSERT INTO `clinicadental`.`tratamiento` (nombre, costo)
VALUES ("Odontopediatría",140000);

INSERT INTO `clinicadental`.`tratamiento` (nombre, costo)
VALUES ("Implantología",110000);

/*Insertar dentistas*/
INSERT INTO `clinicadental`.`dentista` (nombre, apellido, especialidad)
VALUES ("Ignacio","Sepulveda",1);

INSERT INTO `clinicadental`.`dentista` (nombre, apellido, especialidad)
VALUES ("Natalia","Estrada",1);

INSERT INTO `clinicadental`.`dentista` (nombre, apellido, especialidad)
VALUES ("Alexandra","Perez",2);

INSERT INTO `clinicadental`.`dentista` (nombre, apellido, especialidad)
VALUES ("Esteban","Ulloa",3);

INSERT INTO `clinicadental`.`dentista` (nombre, apellido, especialidad)
VALUES ("Arturo","Castro",4);

INSERT INTO `clinicadental`.`dentista` (nombre, apellido, especialidad)
VALUES ("Elizabeth","Torres",5);

INSERT INTO `clinicadental`.`dentista` (nombre, apellido, especialidad)
VALUES ("Santiago","Meza",6);

/*Commit*/
COMMIT;