CREATE TABLE IF NOT EXISTS user(
                                   id           INTEGER(10) PRIMARY KEY AUTO_INCREMENT,
    first_name   VARCHAR(50),
    last_name    VARCHAR(50),
    address      VARCHAR(50),
    zip          INTEGER(10),
    phone_number INTEGER(10),
    email        VARCHAR(50),
    cpr          VARCHAR(10)
    );

CREATE TABLE IF NOT EXISTS car
(
    id            INTEGER(10) PRIMARY KEY AUTO_INCREMENT,
    brand         VARCHAR(50),
    model         VARCHAR(50),
    steel_price   INTEGER(10),
    tax           INTEGER(10),
    emission      INTEGER(10),
    color         VARCHAR(50),
    location      VARCHAR(50),
    damage_status BOOLEAN,
    image         LONGBLOB,
    highlighted   BOOLEAN,
    monthly_price DOUBLE
    );

CREATE TABLE IF NOT EXISTS admin(
                                    username VARCHAR(55),
    password VARCHAR(55)
    );

CREATE TABLE IF NOT EXISTS vehicle_report(
                                             id                INT(10) PRIMARY KEY AUTO_INCREMENT,
    totalCost         DOUBLE
    );

CREATE TABLE IF NOT EXISTS rental_contract(
                                              id                INT(10) PRIMARY KEY AUTO_INCREMENT,
    from_date_time    DATETIME,
    to_date_time      DATETIME,
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


-- 1. Insert Users
INSERT INTO user (first_name, last_name, address, zip, phone_number, email, cpr)
VALUES
    ('Alice', 'Johnson', '123 Maple St', 10001, 5551234, 'alice@example.com', 1234567890),
    ('Bob', 'Smith', '456 Oak Ave', 10002, 5555678, 'bob@example.com', 1234123412),
    ('Charlie', 'Brown', '789 Pine Rd', 10003, 5559012, 'charlie@example.com', 1234512345);

-- 2. Insert Cars
INSERT INTO car (brand, model, steel_price, tax, emission, color, location, damage_status, image)
VALUES
    ('Toyota', 'Corolla', 20000, 1500, 120, 'Red', 'Garage A', FALSE, NULL),
    ('Honda', 'Civic', 22000, 1600, 110, 'Blue', 'Garage B', FALSE, NULL),
    ('Ford', 'Focus', 21000, 1550, 130, 'Black', 'Garage C', FALSE, NULL);

-- 3. Insert Vehicle Reports (linking to cars)
INSERT INTO vehicle_report (id) VALUES (1), (2), (3);

-- 4. Insert Rental Contracts (linking to users, cars, and vehicle reports)
INSERT INTO rental_contract
(from_date_time, to_date_time, active, user_id, car_id, vehicle_report_id)
VALUES
    ('2025-12-01 10:00:00', '2026-01-01 10:00:00',  TRUE, 1, 1, 1),
    ('2025-12-05 09:00:00', '2026-02-05 09:00:00',   TRUE, 2, 2, 2),
    ('2025-12-10 08:00:00', '2026-01-10 08:00:00', TRUE, 3, 3, 3);

-- 5. Insert Admin
INSERT INTO admin (username, password)
VALUES('Moskinen', 'moskinen');


UPDATE car
SET damage_status = TRUE
WHERE brand = 'Toyota' AND model = 'Corolla';


SELECT * FROM car;

SELECT * FROM user;

SELECT * FROM vehicle_report;
SELECT
    AVG(DATEDIFF(to_date_time, from_date_time)) AS avg_contract_length_days
FROM rental_contract;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS user, car, admin, vehicle_report, rental_contract, purchase_contract, damages;

