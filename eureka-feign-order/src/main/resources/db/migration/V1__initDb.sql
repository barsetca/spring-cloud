DROP TABLE IF EXISTS orders;

CREATE TABLE IF NOT EXISTS orders
(
    id       bigserial PRIMARY KEY,
    cost     INTEGER,
    quantity   INTEGER

);


