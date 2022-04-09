CREATE TABLE IF NOT EXISTS BOARD (
    ID BIGINT NOT NULL AUTO_INCREMENT,
    TITLE VARCHAR2(50) NOT NULL,
    CONTENTS TEXT NOT NULL,
    REG_DT DATETIME NOT NULL,
    UPD_DT DATETIME,
    PRIMARY KEY (id)
);