CREATE TABLE IF NOT EXISTS user(
    id           INTEGER(10) PRIMARY KEY AUTO_INCREMENT,
    first_name   VARCHAR(50),
    last_name    VARCHAR(50),
    address      VARCHAR(50),
    zip          INTEGER(10),
    phone_number INTEGER(10),
    email        VARCHAR(50),
    cpr          INTEGER(10)
);

CREATE TABLE IF NOT EXISTS car(
    id            INTEGER(10) PRIMARY KEY AUTO_INCREMENT,
    brand         VARCHAR(50),
    model         VARCHAR(50),
    steel_price   INTEGER(10),
    tax           INTEGER(10),
    emission      INTEGER(10),
    color         VARCHAR(50),
    location      VARCHAR(50),
    damage_status BOOLEAN,
    image LONGBLOB
);

CREATE TABLE IF NOT EXISTS admin(
    username VARCHAR(55),
    password VARCHAR(55)
);

CREATE TABLE IF NOT EXISTS vehicle_report(
    id     INT(10) PRIMARY KEY AUTO_INCREMENT,
    car_id INT(10),
    FOREIGN KEY (car_id) REFERENCES car (id)
);

CREATE TABLE IF NOT EXISTS rental_contract(
    id                INT(10) PRIMARY KEY AUTO_INCREMENT,
    from_date_time    DATETIME,
    to_date_time      DATETIME,
    max_km            INT(10),
    unlimited         boolean,
    active            boolean,
    user_id           INT(10),
    car_id            INT(10),
    vehicle_report_id INT(10),
    FOREIGN KEY (user_id) REFERENCES user (id),
    FOREIGN KEY (car_id) REFERENCES car (id),
    FOREIGN KEY (vehicle_report_id) REFERENCES vehicle_report (id)
);

CREATE TABLE IF NOT EXISTS purchase_contract(
    id                INT(10) PRIMARY KEY AUTO_INCREMENT,
    price             INT(10),
    receive_date      DATETIME,
    user_id           INT(10),
    car_id            INT(10),
    vehicle_report_id INT(10),
    FOREIGN KEY (user_id) REFERENCES user (id),
    FOREIGN KEY (car_id) REFERENCES car (id),
    FOREIGN KEY (vehicle_report_id) REFERENCES vehicle_report (id)
);

CREATE TABLE IF NOT EXISTS damages(
    id                INT(10) PRIMARY KEY AUTO_INCREMENT,
    name              VARCHAR(55),
    price             INT(10),
    vehicle_report_id INT(10),
    FOREIGN KEY (vehicle_report_id) REFERENCES vehicle_report (id)
);

INSERT INTO car (brand, model, steel_price, tax, emission, color, location, damage_status)
VALUES
    ('Toyota', 'Corolla', 20000, 1500, 120, 'Red', 'MIDTJYLLAND', FALSE),
    ('Ford', 'Focus', 18000, 1200, 130, 'Blue', 'SJAELLAND', FALSE),
    ('BMW', 'X5', 50000, 4000, 200, 'Black', 'NORDJYLLAND', FALSE);


SELECT * FROM car;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS user, car, admin, vehicle_report, rental_contract, purchase_contract, damages;

