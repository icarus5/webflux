drop table usuario;
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

drop table curso;
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