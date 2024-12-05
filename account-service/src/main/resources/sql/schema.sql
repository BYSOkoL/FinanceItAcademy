CREATE TABLE IF NOT EXISTS accounts (
    uuid UUID PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    balance DOUBLE PRECISION NOT NULL,
    type VARCHAR(50) NOT NULL,
    currency VARCHAR(50) NOT NULL,
    dt_create TIMESTAMP NOT NULL,
    dt_update TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS operations (
    uuid UUID PRIMARY KEY,
    account_id UUID REFERENCES accounts(uuid),
    date TIMESTAMP NOT NULL,
    description TEXT,
    category VARCHAR(255) NOT NULL,
    value DOUBLE PRECISION NOT NULL,
    currency VARCHAR(50) NOT NULL,
    dt_create TIMESTAMP NOT NULL,
    dt_update TIMESTAMP NOT NULL
);