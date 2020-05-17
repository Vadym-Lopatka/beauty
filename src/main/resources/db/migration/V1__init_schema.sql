CREATE TABLE beauty_user (
    id SERIAL PRIMARY KEY,
    phone character varying(30) NOT NULL,
    email character varying(255) NOT NULL,
    activated boolean NOT NULL,
    name character varying(255) NOT NULL,
    password character varying(255) NOT NULL
);

CREATE TABLE authority (
    name PRIMARY KEY character varying(50) NOT NULL
);

CREATE TABLE user_authority (
    user_id bigint NOT NULL,
    authority_name character varying(50) NOT NULL,
    constraint `fk_authority_name` FOREIGN KEY (`authority_name`) REFERENCES (`authority`.`name`),
    constraint `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES (`beauty_user`.`id`)
);


