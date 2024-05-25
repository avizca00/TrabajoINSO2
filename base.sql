-- MySQL Script generated by MySQL Workbench
-- Sat May 25 18:48:21 2024
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Banco
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Banco
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Banco` DEFAULT CHARACTER SET utf8 ;
USE `Banco` ;

-- -----------------------------------------------------
-- Table `Banco`.`Sucursales`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Banco`.`Sucursales` ;

CREATE TABLE IF NOT EXISTS `Banco`.`Sucursales` (
  `idSucursal` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `ubicacion` VARCHAR(255) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `correo_electronico` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idSucursal`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC) VISIBLE,
  UNIQUE INDEX `ubicacion_UNIQUE` (`ubicacion` ASC) VISIBLE,
  UNIQUE INDEX `Sucursalescol_UNIQUE` (`telefono` ASC) VISIBLE,
  UNIQUE INDEX `correo_electronico_UNIQUE` (`correo_electronico` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Banco`.`Usuarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Banco`.`Usuarios` ;

CREATE TABLE IF NOT EXISTS `Banco`.`Usuarios` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `dniUsuario` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `userName` VARCHAR(45) NOT NULL,
  `contrasenia` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `Sucursales_idSucursal` INT NOT NULL,
  PRIMARY KEY (`idUsuario`, `Sucursales_idSucursal`),
  UNIQUE INDEX `dniUsuario_UNIQUE` (`dniUsuario` ASC) VISIBLE,
  UNIQUE INDEX `userName_UNIQUE` (`userName` ASC) VISIBLE,
  INDEX `fk_Usuarios_Sucursales1_idx` (`Sucursales_idSucursal` ASC) VISIBLE,
  CONSTRAINT `fk_Usuarios_Sucursales1`
    FOREIGN KEY (`Sucursales_idSucursal`)
    REFERENCES `Banco`.`Sucursales` (`idSucursal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Banco`.`Clientes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Banco`.`Clientes` ;

CREATE TABLE IF NOT EXISTS `Banco`.`Clientes` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `Usuarios_idUsuario` INT NOT NULL,
  `fechaAlta` DATE NOT NULL,
  PRIMARY KEY (`idCliente`, `Usuarios_idUsuario`),
  INDEX `fk_Clientes_Usuarios_idx` (`Usuarios_idUsuario` ASC) VISIBLE,
  CONSTRAINT `fk_Clientes_Usuarios`
    FOREIGN KEY (`Usuarios_idUsuario`)
    REFERENCES `Banco`.`Usuarios` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Banco`.`Empleados`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Banco`.`Empleados` ;

CREATE TABLE IF NOT EXISTS `Banco`.`Empleados` (
  `idEmpleado` INT NOT NULL AUTO_INCREMENT,
  `Usuarios_idUsuario` INT NOT NULL,
  `fechaContratacion` DATE NOT NULL,
  PRIMARY KEY (`idEmpleado`, `Usuarios_idUsuario`),
  INDEX `fk_Empleados_Usuarios1_idx` (`Usuarios_idUsuario` ASC) VISIBLE,
  CONSTRAINT `fk_Empleados_Usuarios1`
    FOREIGN KEY (`Usuarios_idUsuario`)
    REFERENCES `Banco`.`Usuarios` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Banco`.`Cuentas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Banco`.`Cuentas` ;

CREATE TABLE IF NOT EXISTS `Banco`.`Cuentas` (
  `idCuenta` INT NOT NULL AUTO_INCREMENT,
  `tipoCuenta` VARCHAR(45) NOT NULL,
  `saldo` DECIMAL(15,2) NOT NULL,
  `fechaApertura` DATE NOT NULL,
  `tasaInteres` DECIMAL(5,2) NOT NULL,
  `limiteTransaccion` DECIMAL(15,2) NULL,
  `fechaUltimaTransaccion` TIMESTAMP(3) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `IBAN` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCuenta`),
  UNIQUE INDEX `IBAN_UNIQUE` (`IBAN` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Banco`.`TarjetasCredito`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Banco`.`TarjetasCredito` ;

CREATE TABLE IF NOT EXISTS `Banco`.`TarjetasCredito` (
  `idTarjetasCredito` INT NOT NULL AUTO_INCREMENT,
  `Cuentas_idCuenta` INT NOT NULL,
  `numeroTarjeta` VARCHAR(20) NOT NULL,
  `tipoTarjeta` VARCHAR(45) NOT NULL,
  `fechaVencimiento` VARCHAR(45) NOT NULL,
  `CVV` VARCHAR(4) NOT NULL,
  `saldoDisponible` DECIMAL(15,2) NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTarjetasCredito`, `Cuentas_idCuenta`),
  INDEX `fk_Tarjetas de Crédito_Cuentas1_idx` (`Cuentas_idCuenta` ASC) VISIBLE,
  UNIQUE INDEX `numeroTarjeta_UNIQUE` (`numeroTarjeta` ASC) VISIBLE,
  CONSTRAINT `fk_Tarjetas de Crédito_Cuentas1`
    FOREIGN KEY (`Cuentas_idCuenta`)
    REFERENCES `Banco`.`Cuentas` (`idCuenta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Banco`.`Promociones`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Banco`.`Promociones` ;

CREATE TABLE IF NOT EXISTS `Banco`.`Promociones` (
  `idPromociones` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(255) NOT NULL,
  `fechaInicio` DATE NOT NULL,
  `fechaFin` DATE NOT NULL,
  `descuento` DECIMAL(5,2) NOT NULL,
  PRIMARY KEY (`idPromociones`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Banco`.`Transferencias`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Banco`.`Transferencias` ;

CREATE TABLE IF NOT EXISTS `Banco`.`Transferencias` (
  `idTransferencias` INT NOT NULL AUTO_INCREMENT,
  `Cuentas_idCuentaPagador` INT NOT NULL,
  `Cuentas_idCuentaBeneficiario` INT NOT NULL,
  `fecha` DATE NOT NULL,
  `monto` DECIMAL(15,2) NOT NULL,
  `concepto` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`idTransferencias`, `Cuentas_idCuentaPagador`, `Cuentas_idCuentaBeneficiario`),
  INDEX `fk_Transferencias_Cuentas1_idx` (`Cuentas_idCuentaPagador` ASC) VISIBLE,
  INDEX `fk_Transferencias_Cuentas2_idx` (`Cuentas_idCuentaBeneficiario` ASC) VISIBLE,
  CONSTRAINT `fk_Transferencias_Cuentas1`
    FOREIGN KEY (`Cuentas_idCuentaPagador`)
    REFERENCES `Banco`.`Cuentas` (`idCuenta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Transferencias_Cuentas2`
    FOREIGN KEY (`Cuentas_idCuentaBeneficiario`)
    REFERENCES `Banco`.`Cuentas` (`idCuenta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Banco`.`RecibosDomiciliarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Banco`.`RecibosDomiciliarios` ;

CREATE TABLE IF NOT EXISTS `Banco`.`RecibosDomiciliarios` (
  `idRecibosDomiciliarios` INT NOT NULL AUTO_INCREMENT,
  `Cuentas_idCuenta` INT NOT NULL,
  `importe` DECIMAL(15,2) NOT NULL,
  `fechaEmision` DATE NOT NULL,
  `fechaVencimiento` DATE NOT NULL,
  `entidadPersona` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idRecibosDomiciliarios`, `Cuentas_idCuenta`),
  INDEX `fk_Recibos Domiciliarios_Cuentas1_idx` (`Cuentas_idCuenta` ASC) VISIBLE,
  CONSTRAINT `fk_Recibos Domiciliarios_Cuentas1`
    FOREIGN KEY (`Cuentas_idCuenta`)
    REFERENCES `Banco`.`Cuentas` (`idCuenta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Banco`.`Prestamos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Banco`.`Prestamos` ;

CREATE TABLE IF NOT EXISTS `Banco`.`Prestamos` (
  `idPrestamo` INT NOT NULL AUTO_INCREMENT,
  `Empleados_idEmpleado` INT NOT NULL,
  `fechaInicio` VARCHAR(45) NOT NULL,
  `estado` TINYINT NOT NULL,
  `plazoMeses` INT(2) NOT NULL,
  `tasaInteres` DECIMAL(5,2) NOT NULL,
  `montoPrestamo` DECIMAL(15,2) NOT NULL,
  `Cuentas_idCuenta` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPrestamo`, `Empleados_idEmpleado`, `Cuentas_idCuenta`),
  INDEX `fk_Clientes_has_Empleados_Empleados1_idx` (`Empleados_idEmpleado` ASC, `idPrestamo` ASC) VISIBLE,
  INDEX `fk_Prestamos_Cuentas1_idx` (`Cuentas_idCuenta` ASC) VISIBLE,
  CONSTRAINT `fk_Clientes_has_Empleados_Empleados1`
    FOREIGN KEY (`Empleados_idEmpleado` , `idPrestamo`)
    REFERENCES `Banco`.`Empleados` (`idEmpleado` , `Usuarios_idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Prestamos_Cuentas1`
    FOREIGN KEY (`Cuentas_idCuenta`)
    REFERENCES `Banco`.`Cuentas` (`idCuenta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Banco`.`NotificacionesRecibos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Banco`.`NotificacionesRecibos` ;

CREATE TABLE IF NOT EXISTS `Banco`.`NotificacionesRecibos` (
  `idNotificacionesRecibos` INT NOT NULL AUTO_INCREMENT,
  `Recibos Domiciliarios_idRecibos Domiciliarios` INT NOT NULL,
  `pagoRealizado` TINYINT NOT NULL,
  `descripcion` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idNotificacionesRecibos`, `Recibos Domiciliarios_idRecibos Domiciliarios`),
  INDEX `fk_Notificaciones de Recibos_Recibos Domiciliarios1_idx` (`Recibos Domiciliarios_idRecibos Domiciliarios` ASC) VISIBLE,
  CONSTRAINT `fk_Notificaciones de Recibos_Recibos Domiciliarios1`
    FOREIGN KEY (`Recibos Domiciliarios_idRecibos Domiciliarios`)
    REFERENCES `Banco`.`RecibosDomiciliarios` (`idRecibosDomiciliarios`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Banco`.`Operaciones`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Banco`.`Operaciones` ;

CREATE TABLE IF NOT EXISTS `Banco`.`Operaciones` (
  `idOperaciones` INT NOT NULL AUTO_INCREMENT,
  `fecha` TIMESTAMP(3) NOT NULL,
  `importe` DECIMAL(15,2) NOT NULL,
  `tipoOperacion` VARCHAR(45) NOT NULL,
  `estado` TINYINT NOT NULL,
  `Cuentas_idCuenta` INT NOT NULL,
  PRIMARY KEY (`idOperaciones`, `Cuentas_idCuenta`),
  INDEX `fk_Operaciones_Cuentas1_idx` (`Cuentas_idCuenta` ASC) VISIBLE,
  CONSTRAINT `fk_Operaciones_Cuentas1`
    FOREIGN KEY (`Cuentas_idCuenta`)
    REFERENCES `Banco`.`Cuentas` (`idCuenta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Banco`.`ClientesCuentas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Banco`.`ClientesCuentas` ;

CREATE TABLE IF NOT EXISTS `Banco`.`ClientesCuentas` (
  `idClientesCuentas` INT NOT NULL AUTO_INCREMENT,
  `Cuentas_idCuenta` INT NOT NULL,
  `Clientes_idCliente` INT NOT NULL,
  `Clientes_Usuarios_idUsuario` INT NOT NULL,
  PRIMARY KEY (`idClientesCuentas`, `Cuentas_idCuenta`, `Clientes_idCliente`, `Clientes_Usuarios_idUsuario`),
  INDEX `fk_ClientesCuentas_Cuentas1_idx` (`Cuentas_idCuenta` ASC) VISIBLE,
  INDEX `fk_ClientesCuentas_Clientes1_idx` (`Clientes_idCliente` ASC, `Clientes_Usuarios_idUsuario` ASC) VISIBLE,
  CONSTRAINT `fk_ClientesCuentas_Cuentas1`
    FOREIGN KEY (`Cuentas_idCuenta`)
    REFERENCES `Banco`.`Cuentas` (`idCuenta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ClientesCuentas_Clientes1`
    FOREIGN KEY (`Clientes_idCliente` , `Clientes_Usuarios_idUsuario`)
    REFERENCES `Banco`.`Clientes` (`idCliente` , `Usuarios_idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Banco`.`CuentasPromociones`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Banco`.`CuentasPromociones` ;

CREATE TABLE IF NOT EXISTS `Banco`.`CuentasPromociones` (
  `idCuentasPromociones` INT NOT NULL AUTO_INCREMENT,
  `Promociones_idPromociones` INT NOT NULL,
  `Cuentas_idCuenta` INT NOT NULL,
  PRIMARY KEY (`idCuentasPromociones`, `Promociones_idPromociones`, `Cuentas_idCuenta`),
  INDEX `fk_CuentasPromociones_Promociones1_idx` (`Promociones_idPromociones` ASC) VISIBLE,
  INDEX `fk_CuentasPromociones_Cuentas1_idx` (`Cuentas_idCuenta` ASC) VISIBLE,
  CONSTRAINT `fk_CuentasPromociones_Promociones1`
    FOREIGN KEY (`Promociones_idPromociones`)
    REFERENCES `Banco`.`Promociones` (`idPromociones`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CuentasPromociones_Cuentas1`
    FOREIGN KEY (`Cuentas_idCuenta`)
    REFERENCES `Banco`.`Cuentas` (`idCuenta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `Banco`.`Sucursales`
-- -----------------------------------------------------
START TRANSACTION;
USE `Banco`;
INSERT INTO `Banco`.`Sucursales` ( `nombre`, `ubicacion`, `telefono`, `correo_electronico`) VALUES ( 'Leon1', 'León Centro', '686938854', 'leondellLC@gmail.com');
INSERT INTO `Banco`.`Sucursales` ( `nombre`, `ubicacion`, `telefono`, `correo_electronico`) VALUES ( 'Leon2', 'León Sur', '968856954', 'leondellLS@gmail.com');
INSERT INTO `Banco`.`Sucursales` ( `nombre`, `ubicacion`, `telefono`, `correo_electronico`) VALUES ( 'Ponfe1', 'Ponfe Centro', '987654321', 'leondellPF@gmail.com');

COMMIT;

