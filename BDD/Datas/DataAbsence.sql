USE GestAbsences;

SET AUTOCOMMIT=0;
INSERT INTO absence VALUES 
(1,  '2017-02-10', '2017-02-10', 10, 2, 1, 1),
(2,  '2017-02-24', '2017-02-24', 10, 2, 1, 1),
(3,  '2017-03-28', '2017-03-30', 10, 3, 1, 1),
(4,  '2017-04-20', '2017-04-30', 10, 3, 1, 1),
(5,  '2017-05-09', '2017-06-01', 10, 1, 0, 1),
(6,  '2017-06-02', '2017-06-04', 10, 3, 0, 1),
(7,  '2017-06-06', '2017-06-09', 10, 1, 0, 1),
(8,  '2017-01-02', '2017-01-18', 11, 1, 1, 1),
(9,  '2017-01-25', '2017-01-26', 11, 4, 1, 1),
(10, '2017-02-05', '2017-02-05', 11, 2, 1, 1),
(11, '2017-03-15', '2017-03-30', 11, 1, 1, 1),
(12, '2017-04-09', '2017-04-14', 11, 4, 0, 1),
(13, '2017-06-06', '2017-06-09', 11, 1, 1, 1),
(14, '2017-06-12', '2017-06-16', 11, 2, 0, 1),
(15, '2017-01-11', '2017-01-12', 12, 3, 1, 1),
(16, '2017-01-22', '2017-01-26', 12, 2, 1, 1),
(17, '2017-03-01', '2017-03-22', 12, 1, 1, 1),
(18, '2017-04-24', '2017-04-28', 12, 3, 0, 1),
(19, '2017-05-01', '2017-05-22', 12, 1, 0, 1),
(20, '2017-06-02', '2017-06-02', 12, 4, 0, 1),
(21, '2017-06-12', '2017-06-16', 12, 2, 1, 1),
(22, '2017-06-17', '2017-06-23', 12, 3, 0, 1),
(23, '2017-04-25', '2017-05-07', 13, 1, 1, 1),
(24, '2017-06-17', '2017-06-23', 13, 3, 1, 1),
(25, '2017-06-24', '2017-06-30', 13, 4, 0, 1),
(26, '2017-06-24', '2017-06-30', 14, 4, 1, 1);
COMMIT;
