-------* QUIX DATABASE *--------

-- Autori
INSERT INTO autore (id, nome, cognome, email, biografia, username, password)
VALUES (1, 'Lorenzo', 'Ricciardi', 'lorenzo1@gmail.com', 'La mia bio.', 'lorenzo', 'password'); 

INSERT INTO autore (id, nome, cognome, email, biografia, username, password)
VALUES (2, 'Michela', 'Sicuranza', 'sicmic@gmail.com', 'La mia bio.', 'sicmic', 'password');


-- Utenti
INSERT INTO utente (id, nome, cognome, email, username, password)
VALUES (1, 'FIlippo', 'Maialino', 'filor02@gmail.com', 'filo', 'password');


-- Categorie
INSERT INTO categoria (id, nome, descrizione)
VALUES (1, 'Scienze', '');

INSERT INTO categoria (id, nome, descrizione)
VALUES (2, 'Sport', '');

INSERT INTO categoria (id, nome, descrizione)
VALUES (3, 'Geografia', '');

INSERT INTO categoria (id, nome, descrizione)
VALUES (4, 'Cucina', '');

INSERT INTO categoria (id, nome, descrizione)
VALUES (5, 'Spettacolo', '');

-- Raccolta

INSERT INTO raccolta (id, nome, descrizione, categoria_id)
VALUES (1, 'Raccolta uno', 'Descrizione', 1);

-- Quiz

INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, raccolta_id)
VALUES (1, 'Quanti hanni ha Filippo', '20', '21', '19', '30', '2023-07-15', 1);
