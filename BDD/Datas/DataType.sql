USE GestAbsences;

SET AUTOCOMMIT=0;
INSERT INTO type VALUES (1,'Congé payé'),
(2,'RTT'),
(3,'Repos compensateur'),
(4,'Congé maladie'),
(5,'Absence irrégulière'),
(6,'Autres absences');
COMMIT;
