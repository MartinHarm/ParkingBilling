create table customer
(
    id            SERIAL PRIMARY KEY,
    customer_type varchar(255),
    first_name    varchar(255),
    last_name     varchar(255)
);

alter table customer owner to postgres;

create table customer_car
(
    reg_number  varchar(255) not null
        constraint customer_car_pkey
            primary key,
    customer_id bigint
);

alter table customer_car owner to postgres;

create table parking_log
(
    id              SERIAL PRIMARY KEY,
    customer_id     bigint,
    facility        varchar(255),
    parking_ended   timestamp,
    parking_started timestamp,
    reg_number      varchar(255)
);

alter table parking_log owner to postgres;

create table pricelist
(
    id            SERIAL PRIMARY KEY,
    cost          numeric(19, 2),
    customer_type varchar(255),
    fee_type      varchar(255),
    valid_from    timestamp,
    valid_to      timestamp
);

alter table pricelist owner to postgres;

create table report
(
    id                     bigint not null
        constraint report_pkey
            primary key,
    customer_id            bigint
        constraint fk9gdgejq43wjsko8rtiuks82a4
            references customer,
    invoice_total          numeric(19, 2),
    invoice_total_with_tax numeric(19, 2)
);

alter table report owner to postgres;

create table report_row
(
    id              serial not null
        constraint report_row_pkey
            primary key,
    cost            numeric(19, 2),
    facility        varchar(255),
    reg_number      varchar(255),
    parking_ended   timestamp,
    parking_started timestamp,
    report_id       bigint
        constraint fkqrrqxjni5h0awfsk1ft83fk09
            references report
);

alter table report_row owner to postgres;

