-- MySQL Script generated by MySQL Workbench
-- Sun Oct 10 10:57:41 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET
@OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET
@OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET
@OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema carona
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema carona
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `carona` DEFAULT CHARACTER SET utf8;
USE
`carona` ;

-- -----------------------------------------------------
-- Table `carona`.`tb_usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carona`.`tb_usuario`
(
    `id_usuario`
    INT
    NOT
    NULL,
    `email`
    VARCHAR
(
    30
) NOT NULL,
    `nome` VARCHAR
(
    30
) NOT NULL,
    `senha` VARCHAR
(
    45
) NOT NULL,
    `telefone` INT
(
    12
) NOT NULL,
    PRIMARY KEY
(
    `id_usuario`
),
    UNIQUE INDEX `id_usuario_UNIQUE`
(
    `id_usuario` ASC
) VISIBLE)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carona`.`tb_rota`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carona`.`tb_rota`
(
    `id_rota`
    INT
    NOT
    NULL,
    `origem`
    VARCHAR
(
    50
) NOT NULL,
    `destino` VARCHAR
(
    50
) NOT NULL,
    `horario` DATETIME NULL,
    `preco` DOUBLE NULL,
    `vagas` INT
(
    2
) NULL,
    `id_usuario` INT NOT NULL,
    PRIMARY KEY
(
    `id_rota`
),
    UNIQUE INDEX `id_rota_UNIQUE`
(
    `id_rota` ASC
) VISIBLE,
    INDEX `fk_tb_rota_tb_usuario_idx`
(
    `id_usuario` ASC
) VISIBLE,
    CONSTRAINT `fk_tb_rota_tb_usuario`
    FOREIGN KEY
(
    `id_usuario`
)
    REFERENCES `carona`.`tb_usuario`
(
    `id_usuario`
)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carona`.`tb_veiculo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carona`.`tb_veiculo`
(
    `id_veiculo`
    INT
    NOT
    NULL
    AUTO_INCREMENT,
    `capacidade`
    INT
(
    2
) NOT NULL,
    `modelo` VARCHAR
(
    45
) NULL,
    `ano` VARCHAR
(
    45
) NULL,
    `id_usuario` INT NOT NULL,
    PRIMARY KEY
(
    `id_veiculo`
),
    UNIQUE INDEX `id_veiculo_UNIQUE`
(
    `id_veiculo` ASC
) VISIBLE,
    INDEX `fk_tb_veiculo_tb_usuario1_idx`
(
    `id_usuario` ASC
) VISIBLE,
    CONSTRAINT `fk_tb_veiculo_tb_usuario1`
    FOREIGN KEY
(
    `id_usuario`
)
    REFERENCES `carona`.`tb_usuario`
(
    `id_usuario`
)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


SET
SQL_MODE=@OLD_SQL_MODE;
SET
FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET
UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;