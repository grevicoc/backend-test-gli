DROP TABLE IF EXISTS breeds;
CREATE TABLE breeds (
    id number,
    breed varchar(20),
    PRIMARY KEY  (id)
);

DROP TABLE IF EXISTS sub_breeds;
CREATE TABLE sub_breeds (
    id number,
    sub_breed varchar(20),
    id_breed number,
    PRIMARY KEY (id),
    FOREIGN KEY (id_breed)
        REFERENCES breeds(id)
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS images;
CREATE TABLE images(
    id number,
    source varchar(255),
    id_breed number,
    PRIMARY KEY (id),
    FOREIGN KEY (id_breed)
        REFERENCES breeds(id)
        ON DELETE CASCADE
);