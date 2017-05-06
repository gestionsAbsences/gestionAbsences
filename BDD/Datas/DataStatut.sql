USE GestAbsences;

SET AUTOCOMMIT=0;
INSERT INTO statut VALUES (1,'Nouvelle demande', 0),
(2,'En attente de validation du Responsable', 1),
(3,'En attente de décision RH', 2),
(4,'Validé', 3),
(5,'Refusé par le Responsable', 4),
(6,'Refusé par le RH', 5);
COMMIT;
