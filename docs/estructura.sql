-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema testTodo1
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `testTodo1` ;

-- -----------------------------------------------------
-- Schema testTodo1
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `testTodo1` DEFAULT CHARACTER SET latin1 ;
USE `testTodo1` ;

-- -----------------------------------------------------
-- Table `testTodo1`.`tbl_marcas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `testTodo1`.`tbl_marcas` ;

CREATE TABLE IF NOT EXISTS `testTodo1`.`tbl_marcas` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `codigo` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `codigo_UNIQUE` (`codigo` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `testTodo1`.`tbl_categorias`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `testTodo1`.`tbl_categorias` ;

CREATE TABLE IF NOT EXISTS `testTodo1`.`tbl_categorias` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `codigo` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `codigo_UNIQUE` (`codigo` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `testTodo1`.`tbl_articulos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `testTodo1`.`tbl_articulos` ;

CREATE TABLE IF NOT EXISTS `testTodo1`.`tbl_articulos` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `codigo` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `precio_compra` DOUBLE NOT NULL DEFAULT '0',
  `precio_venta` DOUBLE NOT NULL DEFAULT '0',
  `stock` INT(11) NOT NULL DEFAULT '0',
  `marca_id` INT(11) NULL,
  `categoria_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `codigo_UNIQUE` (`codigo` ASC),
  INDEX `fk_tbl_articulos_tbl_marcas1_idx` (`marca_id` ASC),
  INDEX `fk_tbl_articulos_tbl_categorias1_idx` (`categoria_id` ASC),
  CONSTRAINT `fk_tbl_articulos_tbl_marcas1`
    FOREIGN KEY (`marca_id`)
    REFERENCES `testTodo1`.`tbl_marcas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_articulos_tbl_categorias1`
    FOREIGN KEY (`categoria_id`)
    REFERENCES `testTodo1`.`tbl_categorias` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `testTodo1`.`tbl_m_compra`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `testTodo1`.`tbl_m_compra` ;

CREATE TABLE IF NOT EXISTS `testTodo1`.`tbl_m_compra` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `fecha` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `total` DOUBLE NOT NULL,
  `codigo_cliente` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `testTodo1`.`tbl_d_compra`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `testTodo1`.`tbl_d_compra` ;

CREATE TABLE IF NOT EXISTS `testTodo1`.`tbl_d_compra` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `articulo_id` INT(11) NOT NULL,
  `m_compra_id` INT(11) NOT NULL,
  `cantidad` INT(11) NOT NULL,
  `subtotal` DOUBLE NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_d_venta_producto` (`articulo_id` ASC),
  INDEX `fk_d_venta_m_compra` (`m_compra_id` ASC),
  CONSTRAINT `tbl_d_compra_ibfk_1`
    FOREIGN KEY (`articulo_id`)
    REFERENCES `testTodo1`.`tbl_articulos` (`id`)
    ON UPDATE CASCADE,
  CONSTRAINT `tbl_d_compra_ibfk_2`
    FOREIGN KEY (`m_compra_id`)
    REFERENCES `testTodo1`.`tbl_m_compra` (`id`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `testTodo1`.`tbl_m_venta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `testTodo1`.`tbl_m_venta` ;

CREATE TABLE IF NOT EXISTS `testTodo1`.`tbl_m_venta` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `fecha` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `total` DOUBLE NOT NULL,
  `codigo_cliente` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `testTodo1`.`tbl_d_venta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `testTodo1`.`tbl_d_venta` ;

CREATE TABLE IF NOT EXISTS `testTodo1`.`tbl_d_venta` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `articulo_id` INT(11) NOT NULL,
  `m_venta_id` INT(11) NOT NULL,
  `cantidad` INT(11) NOT NULL,
  `subtotal` DOUBLE NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_d_venta_producto` (`articulo_id` ASC),
  INDEX `fk_d_venta_m_venta` (`m_venta_id` ASC),
  CONSTRAINT `tbl_d_venta_ibfk_1`
    FOREIGN KEY (`articulo_id`)
    REFERENCES `testTodo1`.`tbl_articulos` (`id`)
    ON UPDATE CASCADE,
  CONSTRAINT `tbl_d_venta_ibfk_2`
    FOREIGN KEY (`m_venta_id`)
    REFERENCES `testTodo1`.`tbl_m_venta` (`id`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `testTodo1`.`tbl_kardex`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `testTodo1`.`tbl_kardex` ;

CREATE TABLE IF NOT EXISTS `testTodo1`.`tbl_kardex` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `fecha` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `movimiento` ENUM('ENTRADA', 'SALIDA') NOT NULL,
  `cantidad` INT(11) NOT NULL,
  `saldo` INT(11) NOT NULL,
  `articulo_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_kardex_articulos` (`articulo_id` ASC),
  CONSTRAINT `tbl_kardex_ibfk_1`
    FOREIGN KEY (`articulo_id`)
    REFERENCES `testTodo1`.`tbl_articulos` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
