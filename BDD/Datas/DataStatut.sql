USE GestAbsences;

SET AUTOCOMMIT=0;
INSERT INTO statut VALUES (1,'Nouvelle demande', 0),
(2,'En attente de validation du Responsable', 1),
(3,'En attente de d�cision RH', 2),
(4,'Valid�', 3),
(5,'Refus� par le Responsable', 4),
(6,'Refus� par le RH', 5);
COMMIT;
