CREATE TABLE account (
    id SERIAL PRIMARY KEY,
    phone character varying(30) NOT NULL,
    email character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    password character varying(255) NOT NULL
);
