-------* QUIX DATABASE *--------

-- Autori
INSERT INTO autore (id, nome, cognome, email, username, password, biografia, url_image) VALUES (10, 'Lorenzo', 'Ricciardi', 'lorenzo1@gmail.com', 'lorenzo', '1Password!', 'Ciao, sono Lorenzo, un`appassionato di educazione e tecnologia. Da anni creo quiz interattivi per aiutare gli studenti a imparare in modo divertente e coinvolgente. Credo che l`apprendimento debba essere un`esperienza stimolante e cerco sempre di innovare nei miei contenuti.', 'https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fres.cloudinary.com%2Fteepublic%2Fimage%2Fprivate%2Fs--xAPAsZWI--%2Ft_Preview%2Fb_rgb%3Ac8e0ec%2Cc_limit%2Cf_jpg%2Ch_630%2Cq_90%2Cw_630%2Fv1522894149%2Fproduction%2Fdesigns%2F2560124_0.jpg&f=1&nofb=1&ipt=3f717e8d9313e86bdef943c05fc5216bc2ba4cb902f41e06d8175aa80565c900'); 
INSERT INTO autore (id, nome, cognome, email, username, password, biografia, url_image) VALUES (2, 'Michela', 'Sicuranza', 'sicmic@gmail.com', 'sicmic', '2Password!', 'Salve, sono Michela, un esperta di gamification e creazione di contenuti. Mi dedico a progettare quiz che sfidano le persone a testare le loro conoscenze su vari argomenti, rendendo l`apprendimento un gioco. La mia missione è rendere l`educazione accessibile e divertente per tutti!', 'https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fpng.pngtree.com%2Fpng-clipart%2F20230405%2Foriginal%2Fpngtree-cat-cartoon-png-image_9029157.png&f=1&nofb=1&ipt=c8531a4dd100289a5b229a9344f2036dd412143a05aa738b9fac7a57eb554474');


-- Utenti
INSERT INTO utente (id, nome, cognome, email, username, password, url_image) VALUES (1, 'FIlippo', 'Maialino', 'filor02@gmail.com', 'filo', '1Filippo!');

-- Etichette
INSERT INTO etichetta (id, nome, descrizione) VALUES (1, 'Cultura generale', '');
INSERT INTO etichetta (id, nome, descrizione) VALUES (2, 'Spettacolo', '');
INSERT INTO etichetta (id, nome, descrizione) VALUES (3, 'Scienze', '');
INSERT INTO etichetta (id, nome, descrizione) VALUES (4, 'Cucina', '');

-- Categorie
INSERT INTO categoria (id, nome, descrizione) VALUES (1, 'Matematica', '');
INSERT INTO categoria (id, nome, descrizione) VALUES (2, 'Sport', '');
INSERT INTO categoria (id, nome, descrizione) VALUES (3, 'Geografia', '');
INSERT INTO categoria (id, nome, descrizione) VALUES (4, 'Cucina', '');
INSERT INTO categoria (id, nome, descrizione) VALUES (5, 'Cinema', '');
INSERT INTO categoria (id, nome, descrizione) VALUES (6, 'Chimica', '');
INSERT INTO categoria (id, nome, descrizione) VALUES (7, 'Fisica', '');
INSERT INTO categoria (id, nome, descrizione) VALUES (8, 'Informatica', '');

-- Raccolta
INSERT INTO raccolta (id, nome, descrizione, etichetta_id, autore_id, url_image) VALUES (1, 'Raccolta uno', 'Descrizione', 1, 10, 'https://plus.unsplash.com/premium_photo-1661432575489-b0400f4fea58?q=80&w=2072&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D');
INSERT INTO raccolta (id, nome, descrizione, etichetta_id, autore_id, url_image) VALUES (2, 'Raccolta due', 'Descrizione', 2, 10, 'https://images.unsplash.com/photo-1451187580459-43490279c0fa?q=80&w=2072&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D');
INSERT INTO raccolta (id, nome, descrizione, etichetta_id, autore_id, url_image) VALUES (3, 'Raccolta tre', 'Descrizione', 3, 10, 'https://images.unsplash.com/photo-1451187580459-43490279c0fa?q=80&w=2072&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D');
INSERT INTO raccolta (id, nome, descrizione, etichetta_id, autore_id, url_image) VALUES (4, 'Raccolta quattro', 'Descrizione', 1, 10, 'https://plus.unsplash.com/premium_photo-1661432575489-b0400f4fea58?q=80&w=2072&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D');
INSERT INTO raccolta (id, nome, descrizione, etichetta_id, autore_id, url_image) VALUES (5, 'Raccolta cinque', 'Descrizione', 2, 10, 'https://images.unsplash.com/photo-1451187580459-43490279c0fa?q=80&w=2072&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D');
INSERT INTO raccolta (id, nome, descrizione, etichetta_id, autore_id, url_image) VALUES (6, 'Raccolta sei', 'Descrizione', 3, 10, 'https://images.unsplash.com/photo-1451187580459-43490279c0fa?q=80&w=2072&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D');



-- Quiz
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (1, 'Qual è il risultato di 5 + 3?', '6', '7', '8', '9', '2023-07-15', 1, 1);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (2, 'Qual è il valore di π (pi greco)?', '3.14', '3.15', '3.16', '3.17', '2023-07-15', 1, 1);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (3, 'Qual è il risultato di 12 x 12?', '144', '124', '156', '132', '2023-07-15', 1, 1);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (4, 'Qual è la radice quadrata di 81?', '7', '8', '9', '10', '2023-07-15', 1, 1);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (5, 'Qual è il risultato di 15 - 6?', '7', '8', '9', '10', '2023-07-15', 1, 2);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (6, 'Qual è il numero di giocatori in una squadra di calcio?', '10', '11', '12', '13', '2023-07-15', 2, 2);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (7, 'In quale sport si usa una racchetta?', 'Calcio', 'Tennis', 'Basket', 'Pallavolo', '2023-07-15', 2, 2);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (8, 'Qual è il paese di origine del judo?', 'Cina', 'Giappone', 'Corea', 'Thailandia', '2023-07-15', 2, 2);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (9, 'Qual è il record di medaglie d` oro alle Olimpiadi?', 'Michael Phelps', 'Usain Bolt', 'Carl Lewis', 'Mark Spitz', '2023-07-15', 2, 2);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (10, 'In quale sport si gioca a "pallone"?', 'Calcio', 'Rugby', 'Basket', 'Hockey', '2023-07-15', 2, 2);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (11, 'Qual è la capitale della Francia?', 'Londra', 'Berlino', 'Parigi', 'Madrid', '2023-07-15', 3, 2);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (12, 'Qual è il fiume più lungo del mondo?', 'Nilo', 'Amazonas', 'Yangtze', 'Mississippi', '2023-07-15', 3, 3);
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
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id) VALUES (36, 'Qual è il linguaggio di programmazione utilizzato per lo sviluppo di applicazioni Android?', 'Java', 'C#', 'Python', 'Ruby', '2023-07-15', 8);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id) VALUES (37, 'Quale protocollo viene utilizzato per inviare email?', 'HTTP', 'FTP', 'SMTP', 'IMAP', '2023-07-15', 8);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id) VALUES (38, 'Qual è la funzione principale di un sistema operativo?', 'Gestire l’hardware', 'Eseguire applicazioni', 'Fornire sicurezza', 'Gestire la rete', '2023-07-15', 8);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id) VALUES (39, 'Cosa significa l` acronimo "HTML"?', 'HyperText Markup Language', 'HighText Machine Language', 'HyperText Markup Level', 'HighText Markup Language', '2023-07-15', 8);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id) VALUES (40, 'Qual è il principale scopo di un firewall?', 'Proteggere la rete', 'Accelerare la connessione', 'Monitorare il traffico', 'Archiviare dati', '2023-07-15', 8);


-- Raccolta_Quiz
INSERT INTO raccolta_elenco_quiz (elenco_quiz_id, raccolta_id) VALUES (1, 1);
INSERT INTO raccolta_elenco_quiz (elenco_quiz_id, raccolta_id) VALUES (2, 1);
INSERT INTO raccolta_elenco_quiz (elenco_quiz_id, raccolta_id) VALUES (3, 1);
INSERT INTO raccolta_elenco_quiz (elenco_quiz_id, raccolta_id) VALUES (4, 1);
INSERT INTO raccolta_elenco_quiz (elenco_quiz_id, raccolta_id) VALUES (5, 1);
INSERT INTO raccolta_elenco_quiz (elenco_quiz_id, raccolta_id) VALUES (6, 2);
INSERT INTO raccolta_elenco_quiz (elenco_quiz_id, raccolta_id) VALUES (7, 2);
INSERT INTO raccolta_elenco_quiz (elenco_quiz_id, raccolta_id) VALUES (8, 2);
INSERT INTO raccolta_elenco_quiz (elenco_quiz_id, raccolta_id) VALUES (9, 2);
INSERT INTO raccolta_elenco_quiz (elenco_quiz_id, raccolta_id) VALUES (10, 2);
INSERT INTO raccolta_elenco_quiz (elenco_quiz_id, raccolta_id) VALUES (11, 2);
INSERT INTO raccolta_elenco_quiz (elenco_quiz_id, raccolta_id) VALUES (12, 3);
INSERT INTO raccolta_elenco_quiz (elenco_quiz_id, raccolta_id) VALUES (13, 3);
INSERT INTO raccolta_elenco_quiz (elenco_quiz_id, raccolta_id) VALUES (14, 4);
INSERT INTO raccolta_elenco_quiz (elenco_quiz_id, raccolta_id) VALUES (11, 4);
INSERT INTO raccolta_elenco_quiz (elenco_quiz_id, raccolta_id) VALUES (12, 5);
INSERT INTO raccolta_elenco_quiz (elenco_quiz_id, raccolta_id) VALUES (13, 5);
INSERT INTO raccolta_elenco_quiz (elenco_quiz_id, raccolta_id) VALUES (14, 6);

--   FARE PER CIASCUNA TABELLA 
SELECT setval('quiz_seq', (SELECT MAX(id) FROM quiz));