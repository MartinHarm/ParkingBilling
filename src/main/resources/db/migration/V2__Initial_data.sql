--NB: THIS IS MOCK_DATA
INSERT INTO customer (customer_type, first_name, last_name)
VALUES ('PREMIUM', 'Mari', 'Maasikas'),
       ('REGULAR', 'Margus', 'Vaarikas'),
       ('PREMIUM', 'Toomas', 'Tomat');

--NB: THIS IS MOCK_DATA
INSERT INTO customer_car (reg_number, customer_id)
VALUES ('511BXX', 1),
       ('042TJW', 2),
       ('234BJM', 3);

--NB: THIS IS MOCK_DATA
INSERT INTO pricelist (cost, customer_type, fee_type, valid_from, valid_to)
VALUES (20.0, 'PREMIUM', 'MONTHLY', date_trunc('day', NOW() - interval '1 month'), NOW() + interval '1 months'),
       (1.0, 'PREMIUM', 'DAILY', date_trunc('day', NOW() - interval '1 month'), NOW() + interval '1 months'),
       (0.75, 'PREMIUM', 'NIGHTLY', date_trunc('day', NOW() - interval '1 month'), NOW() + interval '1 months'),
       (300, 'PREMIUM', 'MAXIMUM', date_trunc('day', NOW() - interval '1 month'), NOW() + interval '1 months'),
       (1.5, 'REGULAR', 'DAILY', date_trunc('day', NOW() - interval '1 month'), NOW() + interval '1 months'),
       (1.0, 'REGULAR', 'NIGHTLY', date_trunc('day', NOW() - interval '1 month'), NOW() + interval '1 months');

--NB: THIS IS MOCK_DATA
INSERT INTO report (id, customer_id, invoice_total, invoice_total_with_tax) VALUES (1, 1, 38.25, 45.90);
INSERT INTO report (id, customer_id, invoice_total, invoice_total_with_tax) VALUES (2, 2, 11, 13.20);
INSERT INTO report (id, customer_id, invoice_total, invoice_total_with_tax) VALUES (3, 3, 301.25, 361.50);

--NB: THIS IS MOCK_DATA
INSERT INTO report_row (id, cost, facility, reg_number, parking_ended, parking_started, report_id) VALUES (1, 6.00, 'EUROPARK ÜLEMISTE', '511BXX', '2022-06-26 10:45:00.000000', '2022-06-26 08:12:00.000000', 1);
INSERT INTO report_row (id, cost, facility, reg_number, parking_ended, parking_started, report_id) VALUES (2, 10.00, 'EUROPARK ÜLEMISTE', '511BXX', '2022-06-26 11:56:00.000000', '2022-06-26 07:02:00.000000', 1);
INSERT INTO report_row (id, cost, facility, reg_number, parking_ended, parking_started, report_id) VALUES (3, 0.75, 'EUROPARK ÜLEMISTE', '511BXX', '2022-06-26 22:35:00.000000', '2022-06-26 22:10:00.000000', 1);
INSERT INTO report_row (id, cost, facility, reg_number, parking_ended, parking_started, report_id) VALUES (4, 1.50, 'EUROPARK ÜLEMISTE', '511BXX', '2022-06-26 20:35:00.000000', '2022-06-26 19:40:00.000000', 1);

--NB: THIS IS MOCK_DATA
INSERT INTO report_row (id, cost, facility, reg_number, parking_ended, parking_started, report_id) VALUES (5, 9.00, 'EUROPARK ÜLEMISTE', '042TJW', '2022-06-26 10:45:00.000000', '2022-06-26 08:12:00.000000', 2);
INSERT INTO report_row (id, cost, facility, reg_number, parking_ended, parking_started, report_id) VALUES (6, 2.00, 'EUROPARK ÜLEMISTE', '042TJW', '2022-06-26 20:35:00.000000', '2022-06-26 19:40:00.000000', 2);

--NB: THIS IS MOCK_DATA
INSERT INTO report_row (id, cost, facility, reg_number, parking_ended, parking_started, report_id) VALUES (7, 290.00, 'EUROPARK ÜLEMISTE', '234BJM', '2022-06-23 10:20:00.000000', '2022-06-26 08:12:00.000000', 3);
INSERT INTO report_row (id, cost, facility, reg_number, parking_ended, parking_started, report_id) VALUES (8, 10.00, 'EUROPARK ÜLEMISTE', '234BJM', '2022-06-26 01:56:00.000000', '2022-06-26 19:02:00.000000', 3);
INSERT INTO report_row (id, cost, facility, reg_number, parking_ended, parking_started, report_id) VALUES (9, 1.25, 'EUROPARK ÜLEMISTE', '234BJM', '2022-06-28 22:35:00.000000', '2022-06-30 22:10:00.000000', 3);
