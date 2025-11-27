CREATE TABLE IF NOT EXISTS user(
    id           INTEGER(10) AUTO_INCREMENT,
    first_name   VARCHAR(50),
    last_name    VARCHAR(50),
    address      VARCHAR(50),
    zip          INTEGER(10),
    phone_number INTEGER(10),
    email        VARCHAR(50),
    cpr          INTEGER(10)
);

CREATE TABLE IF NOT EXISTS car(
    id            INTEGER(10) AUTO_INCREMENT,
    brand         VARCHAR(50),
    model         VARCHAR(50),
    steel_price   INTEGER(10),
    tax           INTEGER(10),
    emission      INTEGER(10),
    color         VARCHAR(50),
    location      ENUM ('NORDJYLLAND', 'MIDTJYLLAND', 'SOENDERJYLLAND', 'FYN', 'SJAELLAND'),
    damage_status BOOLEAN
);

CREATE TABLE IF NOT EXISTS admin(
    username VARCHAR(55),
    password VARCHAR(55)
);

CREATE TABLE IF NOT EXISTS rental_contract(
    id                INT(10) PRIMARY KEY AUTO_INCREMENT,
    from_date_time    DATE,
    to_date_time      DATE,
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
    receive_date      DATE,
    user_id           INT(10),
    car_id            INT(10),
    vehicle_report_id INT(10),
    FOREIGN KEY (user_id) REFERENCES user (id),
    FOREIGN KEY (car_id) REFERENCES car (id),
    FOREIGN KEY (vehicle_report_id) REFERENCES vehicle_report (id)
);



CREATE TABLE IF NOT EXISTS vehicle_report(
    id     INT(10) PRIMARY KEY AUTO_INCREMENT,
    car_id INT(10),
    FOREIGN KEY (car_id) REFERENCES car (id)
);



CREATE TABLE IF NOT EXISTS damages(
    id                INT(10) PRIMARY KEY AUTO_INCREMENT,
    name              VARCHAR(55),
    price             INT(10),
    vehicle_report_id INT(10),
    FOREIGN KEY (vehicle_report_id) REFERENCES vehicle_report (id)
);

