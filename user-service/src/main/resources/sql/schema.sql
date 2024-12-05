CREATE TABLE IF NOT EXISTS users (
    uuid UUID PRIMARY KEY,
    mail VARCHAR(255) UNIQUE NOT NULL,
    fio VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL,
    status VARCHAR(50) NOT NULL,
    dt_create TIMESTAMP NOT NULL,
    dt_update TIMESTAMP NOT NULL,
    verification_code VARCHAR(255),
    verification_code_expiry TIMESTAMP
);