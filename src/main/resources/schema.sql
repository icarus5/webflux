DROP TABLE IF EXISTS usuario;
CREATE TABLE IF NOT EXISTS usuario
(
    id
    INTEGER
    PRIMARY
    KEY
    AUTO_INCREMENT,
    name
    VARCHAR
(
    255
) ,
    fecha TIMESTAMP
    );

DROP TABLE IF EXISTS curso;
CREATE TABLE IF NOT EXISTS curso
(
    id
    INTEGER
    PRIMARY
    KEY
    AUTO_INCREMENT,
    name
    VARCHAR
(
    255
) ,
    nota INTEGER,
    idusuario INTEGER
    );