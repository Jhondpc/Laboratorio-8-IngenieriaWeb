-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8mb3 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`clase`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`clase` (
  `idClase` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`idClase`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`enemigos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`enemigos` (
  `idEnemigos` INT NOT NULL AUTO_INCREMENT,
  `nombres` VARCHAR(45) NOT NULL,
  `genero` CHAR(1) NULL DEFAULT NULL,
  `experiencia_x_derrota` INT NOT NULL,
  `ataque` INT NOT NULL,
  `clase_idClase1` INT NOT NULL,
  PRIMARY KEY (`idEnemigos`),
  INDEX `fk_enemigos_clase1_idx` (`clase_idClase1` ASC) VISIBLE,
  CONSTRAINT `fk_enemigos_clase1`
    FOREIGN KEY (`clase_idClase1`)
    REFERENCES `mydb`.`clase` (`idClase`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`elementos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`elementos` (
  `idelementos` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idelementos`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`hechizo_magicos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`hechizo_magicos` (
  `idHechizoMagicos` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(15) NOT NULL,
  `potencia` INT NOT NULL,
  `precision` INT NOT NULL,
  `nivel_aprendizaje` INT NULL,
  `hechizo_base` INT NULL,
  `elementos_idelementos` INT NOT NULL,
  `hechizo_magicos_idHechizoMagicos` INT NOT NULL,
  PRIMARY KEY (`idHechizoMagicos`),
  INDEX `fk_hechizo_magicos_elementos1_idx` (`elementos_idelementos` ASC) VISIBLE,
  INDEX `fk_hechizo_magicos_hechizo_magicos1_idx` (`hechizo_magicos_idHechizoMagicos` ASC) VISIBLE,
  CONSTRAINT `fk_hechizo_magicos_elementos1`
    FOREIGN KEY (`elementos_idelementos`)
    REFERENCES `mydb`.`elementos` (`idelementos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_hechizo_magicos_hechizo_magicos1`
    FOREIGN KEY (`hechizo_magicos_idHechizoMagicos`)
    REFERENCES `mydb`.`hechizo_magicos` (`idHechizoMagicos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`inventarioobjetos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`inventarioobjetos` (
  `idInventarioObjetos` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `uso` VARCHAR(45) NOT NULL,
  `peso` INT NOT NULL,
  PRIMARY KEY (`idInventarioObjetos`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`elementos_has_clase`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`elementos_has_clase` (
  `elementos_idelementos` INT NOT NULL,
  `clase_idClase` INT NOT NULL,
  `debil_fortaleza` VARCHAR(45) NOT NULL,
  `porcentaje_dano_recib` FLOAT NOT NULL,
  PRIMARY KEY (`elementos_idelementos`, `clase_idClase`),
  INDEX `fk_elementos_has_clase_clase1_idx` (`clase_idClase` ASC) VISIBLE,
  INDEX `fk_elementos_has_clase_elementos1_idx` (`elementos_idelementos` ASC) VISIBLE,
  CONSTRAINT `fk_elementos_has_clase_elementos1`
    FOREIGN KEY (`elementos_idelementos`)
    REFERENCES `mydb`.`elementos` (`idelementos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_elementos_has_clase_clase1`
    FOREIGN KEY (`clase_idClase`)
    REFERENCES `mydb`.`clase` (`idClase`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`heroes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`heroes` (
  `idheroes` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(10) NOT NULL,
  `edad` INT NOT NULL,
  `genero` CHAR(1) NOT NULL,
  `nivel_inicial` INT NOT NULL,
  `ataque` INT NOT NULL,
  `id_pareja` INT NULL,
  `pts_x_experiencia` INT NOT NULL,
  `clase_idClase` INT NOT NULL,
  PRIMARY KEY (`idheroes`),
  INDEX `fk_heroes_heroes1_idx` (`id_pareja` ASC) VISIBLE,
  INDEX `fk_heroes_clase1_idx` (`clase_idClase` ASC) VISIBLE,
  CONSTRAINT `fk_heroes_heroes1`
    FOREIGN KEY (`id_pareja`)
    REFERENCES `mydb`.`heroes` (`idheroes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_heroes_clase1`
    FOREIGN KEY (`clase_idClase`)
    REFERENCES `mydb`.`clase` (`idClase`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`heroes_has_inventarioobjetos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`heroes_has_inventarioobjetos` (
  `heroes_idheroes` INT NOT NULL,
  `inventarioobjetos_idInventarioObjetos` INT NOT NULL,
  `cantidad_objetos` INT NOT NULL,
  PRIMARY KEY (`heroes_idheroes`, `inventarioobjetos_idInventarioObjetos`),
  INDEX `fk_heroes_has_inventarioobjetos_inventarioobjetos1_idx` (`inventarioobjetos_idInventarioObjetos` ASC) VISIBLE,
  INDEX `fk_heroes_has_inventarioobjetos_heroes1_idx` (`heroes_idheroes` ASC) VISIBLE,
  CONSTRAINT `fk_heroes_has_inventarioobjetos_heroes1`
    FOREIGN KEY (`heroes_idheroes`)
    REFERENCES `mydb`.`heroes` (`idheroes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_heroes_has_inventarioobjetos_inventarioobjetos1`
    FOREIGN KEY (`inventarioobjetos_idInventarioObjetos`)
    REFERENCES `mydb`.`inventarioobjetos` (`idInventarioObjetos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`objeto_dejado_x_derrota`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`objeto_dejado_x_derrota` (
  `idobjeto_dejado_x_derrota` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idobjeto_dejado_x_derrota`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`enemigos_has_objeto_dejado_x_derrota`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`enemigos_has_objeto_dejado_x_derrota` (
  `enemigos_idEnemigos` INT NOT NULL,
  `objeto_dejado_x_derrota_idobjeto_dejado_x_derrota` INT NOT NULL,
  `probabilidad_dejar_objeto` FLOAT NOT NULL,
  PRIMARY KEY (`enemigos_idEnemigos`, `objeto_dejado_x_derrota_idobjeto_dejado_x_derrota`),
  INDEX `fk_enemigos_has_objeto_dejado_x_derrota_objeto_dejado_x_der_idx` (`objeto_dejado_x_derrota_idobjeto_dejado_x_derrota` ASC) VISIBLE,
  INDEX `fk_enemigos_has_objeto_dejado_x_derrota_enemigos1_idx` (`enemigos_idEnemigos` ASC) VISIBLE,
  CONSTRAINT `fk_enemigos_has_objeto_dejado_x_derrota_enemigos1`
    FOREIGN KEY (`enemigos_idEnemigos`)
    REFERENCES `mydb`.`enemigos` (`idEnemigos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_enemigos_has_objeto_dejado_x_derrota_objeto_dejado_x_derro1`
    FOREIGN KEY (`objeto_dejado_x_derrota_idobjeto_dejado_x_derrota`)
    REFERENCES `mydb`.`objeto_dejado_x_derrota` (`idobjeto_dejado_x_derrota`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
