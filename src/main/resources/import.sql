-------* QUIX DATABASE *--------

-- Autori
INSERT INTO autore (id, nome, cognome, email, biografia, username, password) VALUES (1, 'Lorenzo', 'Ricciardi', 'lorenzo1@gmail.com', 'La mia bio.', 'lorenzo', 'password'); 
INSERT INTO autore (id, nome, cognome, email, biografia, username, password) VALUES (2, 'Michela', 'Sicuranza', 'sicmic@gmail.com', 'La mia bio.', 'sicmic', 'password');


-- Utenti
INSERT INTO utente (id, nome, cognome, email, username, password) VALUES (1, 'FIlippo', 'Maialino', 'filor02@gmail.com', 'filo', 'password');


-- Categorie
INSERT INTO categoria (id, nome, descrizione) VALUES (1, 'Matematica', '');
INSERT INTO categoria (id, nome, descrizione) VALUES (2, 'Sport', '');
INSERT INTO categoria (id, nome, descrizione) VALUES (3, 'Geografia', '');
INSERT INTO categoria (id, nome, descrizione) VALUES (4, 'Cucina', '');
INSERT INTO categoria (id, nome, descrizione) VALUES (5, 'Spettacolo', '');
INSERT INTO categoria (id, nome, descrizione) VALUES (6, 'Chimica', '');
INSERT INTO categoria (id, nome, descrizione) VALUES (7, 'Fisica', '');

-- Quiz

INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id) VALUES (1, 'Qual è il risultato di 5 + 3?', '6', '7', '8', '9', '2023-07-15', 1);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id) VALUES (2, 'Qual è il valore di π (pi greco)?', '3.14', '3.15', '3.16', '3.17', '2023-07-15', 1);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id) VALUES (3, 'Qual è il risultato di 12 x 12?', '144', '124', '156', '132', '2023-07-15', 1);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id) VALUES (4, 'Qual è la radice quadrata di 81?', '7', '8', '9', '10', '2023-07-15', 1);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id) VALUES (5, 'Qual è il risultato di 15 - 6?', '7', '8', '9', '10', '2023-07-15', 1);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id) VALUES (6, 'Qual è il numero di giocatori in una squadra di calcio?', '10', '11', '12', '13', '2023-07-15', 2);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id) VALUES (7, 'In quale sport si usa una racchetta?', 'Calcio', 'Tennis', 'Basket', 'Pallavolo', '2023-07-15', 2);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id) VALUES (8, 'Qual è il paese di origine del judo?', 'Cina', 'Giappone', 'Corea', 'Thailandia', '2023-07-15', 2);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id) VALUES (9, 'Qual è il record di medaglie d` oro alle Olimpiadi?', 'Michael Phelps', 'Usain Bolt', 'Carl Lewis', 'Mark Spitz', '2023-07-15', 2);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id) VALUES (10, 'In quale sport si gioca a "pallone"?', 'Calcio', 'Rugby', 'Basket', 'Hockey', '2023-07-15', 2);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id) VALUES (11, 'Qual è la capitale della Francia?', 'Londra', 'Berlino', 'Parigi', 'Madrid', '2023-07-15', 3);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id) VALUES (11, 'Qual è la capitale della Francia?', 'Londra', 'Berlino', 'Parigi', 'Madrid', '2023-07-15', 3);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id) VALUES (12, 'Qual è il fiume più lungo del mondo?', 'Nilo', 'Amazonas', 'Yangtze', 'Mississippi', '2023-07-15', 3);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id) VALUES (13, 'Qual è il continente più grande?', 'Africa', 'Asia', 'America', 'Europa', '2023-07-15', 3);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id) VALUES (14, 'Qual è la montagna più alta del mondo?', 'K2', 'Kangchenjunga', 'Everest', 'Lhotse', '2023-07-15', 3);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id) VALUES (15, 'Qual è il mare che separa l` Europa dall` Africa?', 'Mar Mediterraneo', 'Mar Rosso', 'Oceano Atlantico', 'Oceano Indiano', '2023-07-15', 3);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id) VALUES (16, 'Qual è l` ingrediente principale del risotto?', 'Riso', 'Pasta', 'Patate', 'Fagioli', '2023-07-15', 4);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id) VALUES (17, 'Quale spezia è nota come oro rosso?', 'Pepe', 'Zafferano', 'Curcuma', 'Paprika', '2023-07-15', 4);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id) VALUES (18, 'Qual è il piatto tipico della cucina giapponese a base di pesce crudo?', 'Sushi', 'Sashimi', 'Tempura', 'Ramen', '2023-07-15', 4);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id) VALUES (19, 'Qual è il dolce italiano a base di mascarpone?', 'Tiramisu', 'Panna cotta', 'Cannoli', 'Zabaglione', '2023-07-15', 4);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id) VALUES (20, 'Qual è il metodo di cottura che utilizza l` acqua bollente?', 'Frittura', 'Grigliatura', 'Bollitura', 'Cottura al forno', '2023-07-15', 4);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id) VALUES (21, 'Chi ha vinto il Festival di Sanremo nel 2022?', 'Måneskin', 'Mahmood', 'Fedez', 'Gigi D`Alessio', '2023-07-15', 5);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id) VALUES (22, 'Qual è il film con il maggior incasso di sempre?', 'Avatar', 'Titanic', 'Avengers: Endgame', 'Star Wars', '2023-07-15', 5);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id) VALUES (23, 'Chi ha interpretato il ruolo di Jack in Titanic?', 'Leonardo DiCaprio', 'Brad Pitt', 'Johnny Depp', 'Tom Cruise', '2023-07-15', 5);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id) VALUES (24, 'Qual è il nome della serie TV con i personaggi di "Friends"?', 'How I Met Your Mother', 'The Big Bang Theory', 'Friends', 'New Girl', '2023-07-15', 5);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id) VALUES (25, 'Chi è il regista di "Inception"?', 'Christopher Nolan', 'Steven Spielberg', 'Martin Scorsese', 'Quentin Tarantino', '2023-07-15', 5);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id) VALUES (26, 'Qual è il simbolo chimico dell` ossigeno?', 'O', 'O2', 'H', 'C', '2023-07-15', 6);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id) VALUES (27, 'Qual è il pH neutro?', '0', '7', '14', '10', '2023-07-15', 6);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id) VALUES (28, 'Qual è il composto chimico dell` acqua?', 'H2O', 'CO2', 'NaCl', 'C6H12O6', '2023-07-15', 6);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id) VALUES (29, 'Qual è il gas più abbondante nell` atmosfera terrestre?', 'Ossigeno', 'Azoto', 'Anidride carbonica', 'Argon', '2023-07-15', 6);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id) VALUES (30, 'Qual è il numero atomico del carbonio?', '6', '12', '8', '14', '2023-07-15', 6);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id) VALUES (31, 'Qual è l` unità di misura della forza nel Sistema Internazionale?', 'Newton', 'Joule', 'Pascal', 'Watt', '2023-07-15', 7);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id) VALUES (32, 'Qual è la legge di Newton che descrive il moto di un corpo?', 'Prima legge', 'Seconda legge', 'Terza legge', 'Legge di gravitazione universale', '2023-07-15', 7);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id) VALUES (33, 'Qual è la velocità della luce nel vuoto?', '300.000 km/s', '150.000 km/s', '450.000 km/s', '600.000 km/s', '2023-07-15', 7);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id) VALUES (34, 'Qual è il principio di Archimede?', 'Un corpo immerso in un fluido subisce una spinta verso l` alto', 'La forza è uguale alla massa per l` accelerazione', 'Ogni azione ha una reazione uguale e contraria', 'La pressione è uguale alla forza per l` area', '2023-07-15', 7);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id) VALUES (35, 'Qual è l` unità di misura dell` energia nel Sistema Internazionale?', 'Joule', 'Newton', 'Watt', 'Pascal', '2023-07-15', 7);


-- Raccolta

INSERT INTO raccolta (id, nome, descrizione, categoria_id, autore_id) VALUES (1, 'Raccolta uno', 'Descrizione', 1, 1);
INSERT INTO raccolta (id, nome, descrizione, categoria_id, autore_id) VALUES (2, 'Raccolta due', 'Descrizione', 2, 1);
INSERT INTO raccolta (id, nome, descrizione, categoria_id, autore_id) VALUES (3, 'Raccolta tre', 'Descrizione', 3, 2);

-- Raccolta_Quiz
INSERT INTO raccolta_elenco_quiz (elenco_quiz_id, raccolta_id) VALUES (1, 1);
INSERT INTO raccolta_elenco_quiz (elenco_quiz_id, raccolta_id) VALUES (2, 1);
INSERT INTO raccolta_elenco_quiz (elenco_quiz_id, raccolta_id) VALUES (3, 1);
INSERT INTO raccolta_elenco_quiz (elenco_quiz_id, raccolta_id) VALUES (4, 1);