CREATE TABLE IF NOT EXISTS audits (
    uuid UUID PRIMARY KEY,
    user VARCHAR(255) NOT NULL,
    text TEXT NOT NULL,
    type VARCHAR(50) NOT NULL,
    id VARCHAR(255) NOT NULL,
    dt_create TIMESTAMP NOT NULL,
    dt_update TIMESTAMP NOT NULL
);