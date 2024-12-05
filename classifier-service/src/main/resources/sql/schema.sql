CREATE TABLE IF NOT EXISTS currencies (
    uuid UUID PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    dt_create TIMESTAMP NOT NULL,
    dt_update TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS operation_categories (
    uuid UUID PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    dt_create TIMESTAMP NOT NULL,
    dt_update TIMESTAMP NOT NULL
);