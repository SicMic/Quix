-- CREDEZIALI
INSERT INTO credenziali (id, username, role, password) VALUES (1, 'lorenzo', 'AUTORE', '$2a$12$HtNgYhzZ0Gy.Si8DF9dHfOvTZBAc9E7c6rsqfBE90a3Mt21LZAkhi'); -- pw: "1Password!"
INSERT INTO credenziali (id, username, role, password) VALUES (2, 'michela','AUTORE', '$2a$12$HtNgYhzZ0Gy.Si8DF9dHfOvTZBAc9E7c6rsqfBE90a3Mt21LZAkhi');
INSERT INTO credenziali (id, username, role, password) VALUES (3, 'filippo', 'GIOCATORE', '$2a$12$HtNgYhzZ0Gy.Si8DF9dHfOvTZBAc9E7c6rsqfBE90a3Mt21LZAkhi');
INSERT INTO credenziali (id, username, role, password) VALUES (4, 'marco', 'GIOCATORE', '$2a$12$HtNgYhzZ0Gy.Si8DF9dHfOvTZBAc9E7c6rsqfBE90a3Mt21LZAkhi');
INSERT INTO credenziali (id, username, role, password) VALUES (5, 'mirco', 'GIOCATORE', '$2a$12$HtNgYhzZ0Gy.Si8DF9dHfOvTZBAc9E7c6rsqfBE90a3Mt21LZAkhi');

-- UTENTE
INSERT INTO utente (id, credenziali_id, nome, cognome, email, url_image) VALUES (1, 1, 'Lorenzo', 'Rossi', 'lorenzo@example.com', 'https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fres.cloudinary.com%2Fteepublic%2Fimage%2Fprivate%2Fs--xAPAsZWI--%2Ft_Preview%2Fb_rgb%3Ac8e0ec%2Cc_limit%2Cf_jpg%2Ch_630%2Cq_90%2Cw_630%2Fv1522894149%2Fproduction%2Fdesigns%2F2560124_0.jpg&f=1&nofb=1&ipt=3f717e8d9313e86bdef943c05fc5216bc2ba4cb902f41e06d8175aa80565c900');
INSERT INTO utente (id, credenziali_id, nome, cognome, email, url_image) VALUES (2, 2, 'Michela', 'Bianchi', '@example.com',  'https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fpng.pngtree.com%2Fpng-clipart%2F20230405%2Foriginal%2Fpngtree-cat-cartoon-png-image_9029157.png&f=1&nofb=1&ipt=c8531a4dd100289a5b229a9344f2036dd412143a05aa738b9fac7a57eb554474');
INSERT INTO utente (id, credenziali_id, nome, cognome, email, url_image) VALUES (3, 3, 'Filippo', 'Maialino', 'filippo@example.com', 'https://media.licdn.com/dms/image/v2/D4D03AQEHCIheojtWSw/profile-displayphoto-shrink_200_200/profile-displayphoto-shrink_200_200/0/1724238234684?e=2147483647&v=beta&t=w3L5dsK4axuQhPQMDrP8JRbJjJLFMvuvW3kaVesa3LY');
INSERT INTO utente (id, credenziali_id, nome, cognome, email, url_image) VALUES (4, 4, 'Marco', 'Chiodino', 'marco@example.com', 'https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fpngimg.com%2Fuploads%2Fflags%2Fflags_PNG14629.png&f=1&nofb=1&ipt=6018221fccb258f46e875a28897b0a4026756f78ab53705259e5d307cbf2edab');
INSERT INTO utente (id, credenziali_id, nome, cognome, email, url_image) VALUES (5, 5, 'Laura', 'Straccetti', 'laura@example.com', 'https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fpngimg.com%2Fuploads%2Fflags%2Fflags_PNG14629.png&f=1&nofb=1&ipt=6018221fccb258f46e875a28897b0a4026756f78ab53705259e5d307cbf2edab');

-- AUTORE (sottoclasse di UTENTE)
INSERT INTO autore (id, biografia) VALUES (1, 'Ciao, sono Lorenzo, un`appassionato di educazione e tecnologia. Da anni creo quiz interattivi per aiutare gli studenti a imparare in modo divertente e coinvolgente. Credo che l`apprendimento debba essere un`esperienza stimolante e cerco sempre di innovare nei miei contenuti.');
INSERT INTO autore (id, biografia) VALUES (2,  'Salve, sono Michela, un esperta di gamification e creazione di contenuti. Mi dedico a progettare quiz che sfidano le persone a testare le loro conoscenze su vari argomenti, rendendo l`apprendimento un gioco. La mia missione è rendere l`educazione accessibile e divertente per tutti!');

-- GIOCATORE (sottoclasse di UTENTE)
INSERT INTO giocatore (id) VALUES (3);
INSERT INTO giocatore (id) VALUES (4);
INSERT INTO giocatore (id) VALUES (5);

-- Etichette
INSERT INTO etichetta (id, nome, descrizione) VALUES (1, 'Cultura generale', '');
INSERT INTO etichetta (id, nome, descrizione) VALUES (2, 'Spettacolo', '');
INSERT INTO etichetta (id, nome, descrizione) VALUES (3, 'Scienze', '');
INSERT INTO etichetta (id, nome, descrizione) VALUES (4, 'Cucina', '');
INSERT INTO etichetta (id, nome, descrizione) VALUES (5, 'Natura', '');

-- Categorie
INSERT INTO categoria (id, nome, descrizione) VALUES (1, 'Matematica', '');
INSERT INTO categoria (id, nome, descrizione) VALUES (2, 'Sport', '');
INSERT INTO categoria (id, nome, descrizione) VALUES (3, 'Geografia', '');
INSERT INTO categoria (id, nome, descrizione) VALUES (4, 'Alimentazione', '');
INSERT INTO categoria (id, nome, descrizione) VALUES (5, 'Cinema', '');
INSERT INTO categoria (id, nome, descrizione) VALUES (6, 'Chimica', '');
INSERT INTO categoria (id, nome, descrizione) VALUES (7, 'Fisica', '');
INSERT INTO categoria (id, nome, descrizione) VALUES (8, 'Informatica', '');

-- Raccolta
INSERT INTO raccolta (id, nome, descrizione, etichetta_id, autore_id, url_image) VALUES (1, 'Raccolta uno', 'Descrizione', 1, 1, 'https://plus.unsplash.com/premium_photo-1661432575489-b0400f4fea58?q=80&w=2072&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D');
INSERT INTO raccolta (id, nome, descrizione, etichetta_id, autore_id, url_image) VALUES (2, 'Raccolta due', 'Descrizione', 3, 1, 'https://images.unsplash.com/photo-1451187580459-43490279c0fa?q=80&w=2072&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D');
INSERT INTO raccolta (id, nome, descrizione, etichetta_id, autore_id, url_image) VALUES (3, 'Raccolta tre', 'Descrizione', 5, 1, 'https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fimages.ctfassets.net%2Frt5zmd3ipxai%2F25pHfG94sGlRALOqbRvSxl%2F9f591d8263607fdf923b962cbfcde2a9%2FNVA-panda.jpg&f=1&nofb=1&ipt=cf2500d344cc765544f816d037cd99ac8bfa6af4d965366eafb4e82426c16bf3');
INSERT INTO raccolta (id, nome, descrizione, etichetta_id, autore_id, url_image) VALUES (4, 'Raccolta quattro', 'Descrizione', 5, 1, 'https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fcdn.pixabay.com%2Fphoto%2F2022%2F07%2F10%2F17%2F55%2Fsunflowers-7313486__480.jpg&f=1&nofb=1&ipt=b52eb28d8b9d0ae9c3fd57a1ff10f55df53d0814ad385deea235fcd13e8b01a5');
INSERT INTO raccolta (id, nome, descrizione, etichetta_id, autore_id, url_image) VALUES (5, 'Raccolta cinque', 'Descrizione', 4, 1, 'https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fquifinanza.it%2Fwp-content%2Fuploads%2Fsites%2F5%2F2023%2F02%2Fdati-spreco-alimentare-Italia.jpg&f=1&nofb=1&ipt=16f4864c2908f280f4d36e013de1e9963da9a9a49b8fe0b887f5d303e6df27bb');
INSERT INTO raccolta (id, nome, descrizione, etichetta_id, autore_id, url_image) VALUES (6, 'Raccolta uno', 'Descrizione', 2, 2, 'https://images.unsplash.com/photo-1451187580459-43490279c0fa?q=80&w=2072&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D');
INSERT INTO raccolta (id, nome, descrizione, etichetta_id, autore_id, url_image) VALUES (7, 'Raccolta forti', 'Descrizione', 2, 2, 'https://images.unsplash.com/photo-1451187580459-43490279c0fa?q=80&w=2072&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D');
INSERT INTO raccolta (id, nome, descrizione, etichetta_id, autore_id, url_image) VALUES (8, 'Raccolta pappapero', 'Descrizione', 2, 2, 'https://images.unsplash.com/photo-1451187580459-43490279c0fa?q=80&w=2072&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D');

-- Quiz
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (1, 'Qual è il risultato di 5 + 3?', '8', '6', '7', '9', '2023-07-15', 1, 1);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (2, 'Qual è il valore di π (pi greco)?', '3.14', '3.15', '3.16', '3.17', '2023-07-15', 1, 1);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (3, 'Qual è il risultato di 12 x 12?', '144', '124', '156', '132', '2023-07-15', 1, 1);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (4, 'Qual è la radice quadrata di 81?', '9', '7', '8', '10', '2023-07-15', 1, 1);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (5, 'Qual è il risultato di 15 - 6?', '9', '7', '8', '10', '2023-07-15', 1, 2);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (6, 'Qual è il numero di giocatori in una squadra di calcio?', '11', '10', '12', '13', '2023-07-15', 2, 2);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (7, 'In quale sport si usa una racchetta?', 'Tennis', 'Calcio', 'Basket', 'Pallavolo', '2023-07-15', 2, 2);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (8, 'Qual è il paese di origine del judo?', 'Giappone', 'Cina', 'Corea', 'Thailandia', '2023-07-15', 2, 2);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (9, 'Qual è il record di medaglie d` oro alle Olimpiadi?', 'Michael Phelps', 'Usain Bolt', 'Carl Lewis', 'Mark Spitz', '2023-07-15', 2, 2);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (10, 'In quale sport si gioca a "pallone"?', 'Calcio', 'Rugby', 'Basket', 'Hockey', '2023-07-15', 2, 2);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (11, 'Qual è la capitale della Francia?', 'Parigi', 'Londra', 'Berlino', 'Madrid', '2023-07-15', 3, 2);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (12, 'Qual è il fiume più lungo del mondo?', 'Nilo', 'Amazonas', 'Yangtze', 'Mississippi', '2023-07-15', 3, 3);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (13, 'Qual è il continente più grande?', 'Asia', 'Africa', 'America', 'Europa', '2023-07-15', 3, 4);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (14, 'Qual è la montagna più alta del mondo?', 'Everest', 'K2', 'Kangchenjunga', 'Lhotse', '2023-07-15', 3, 6);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (15, 'Qual è il mare che separa l` Europa dall` Africa?', 'Mar Mediterraneo', 'Mar Rosso', 'Oceano Atlantico', 'Oceano Indiano', '2023-07-15', 3, 4);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (16, 'Qual è l` ingrediente principale del risotto?', 'Riso', 'Pasta', 'Patate', 'Fagioli', '2023-07-15', 4, 6);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (17, 'Quale spezia è nota come oro rosso?', 'Zafferano', 'Pepe', 'Curcuma', 'Paprika', '2023-07-15', 4, 5);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (18, 'Qual è il piatto tipico della cucina giapponese a base di pesce crudo?', 'Sushi', 'Sashimi', 'Tempura', 'Ramen', '2023-07-15', 4, 5);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (19, 'Qual è il dolce italiano a base di mascarpone?', 'Tiramisu', 'Panna cotta', 'Cannoli', 'Zabaglione', '2023-07-15', 4, 5);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (20, 'Qual è il metodo di cottura che utilizza l` acqua bollente?', 'Bollitura', 'Frittura', 'Grigliatura', 'Cottura al forno', '2023-07-15', 4, 4);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (21, 'Chi ha vinto il Festival di Sanremo nel 2022?', 'Måneskin', 'Mahmood', 'Fedez', 'Gigi D`Alessio', '2023-07-15', 5, 1);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (22, 'Qual è il film con il maggior incasso di sempre?', 'Avatar', 'Titanic', 'Avengers: Endgame', 'Star Wars', '2023-07-15', 5, 1);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (23, 'Chi ha interpretato il ruolo di Jack in Titanic?', 'Leonardo DiCaprio', 'Brad Pitt', 'Johnny Depp', 'Tom Cruise', '2023-07-15', 5, 2);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (24, 'Qual è il nome della serie TV con i personaggi di "Friends"?', 'Friends', 'How I Met Your Mother', 'The Big Bang Theory', 'New Girl', '2023-07-15', 5, 2);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (25, 'Chi è il regista di "Inception"?', 'Christopher Nolan', 'Steven Spielberg', 'Martin Scorsese', 'Quentin Tarantino', '2023-07-15', 5, 3);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (26, 'Qual è il simbolo chimico dell` ossigeno?', 'O', 'O2', 'H', 'C', '2023-07-15', 6, 4);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (27, 'Qual è il pH neutro?', '7', '0', '14', '10', '2023-07-15', 6, 5);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (28, 'Qual è il composto chimico dell` acqua?', 'H2O', 'CO2', 'NaCl', 'C6H12O6', '2023-07-15', 6, 5);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (29, 'Qual è il gas più abbondante nell` atmosfera terrestre?', 'Azoto', 'Ossigeno', 'Anidride carbonica', 'Argon', '2023-07-15', 6, 4);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (30, 'Qual è il numero atomico del carbonio?', '6', '12', '8', '14', '2023-07-15', 6, 3);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (31, 'Qual è l` unità di misura della forza nel Sistema Internazionale?', 'Newton', 'Joule', 'Pascal', 'Watt', '2023-07-15', 7, 4);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (32, 'Qual è la legge di Newton che descrive il moto di un corpo?', 'Prima legge', 'Seconda legge', 'Terza legge', 'Legge di gravitazione universale', '2023-07-15', 7, 5);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (33, 'Qual è la velocità della luce nel vuoto?', '300.000 km/s', '150.000 km/s', '450.000 km/s', '600.000 km/s', '2023-07-15', 7, 6);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (34, 'Qual è il principio di Archimede?', 'Un corpo immerso in un fluido subisce una spinta verso l` alto', 'La forza è uguale alla massa per l` accelerazione', 'Ogni azione ha una reazione uguale e contraria', 'La pressione è uguale alla forza per l` area', '2023-07-15', 7, 6);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (35, 'Qual è l` unità di misura dell` energia nel Sistema Internazionale?', 'Joule', 'Newton', 'Watt', 'Pascal', '2023-07-15', 7, 7);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (36, 'Qual è il linguaggio di programmazione utilizzato per lo sviluppo di applicazioni Android?', 'Java', 'C#', 'Python', 'Ruby', '2023-07-15', 8, 7);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (37, 'Quale protocollo viene utilizzato per inviare email?', 'SMTP', 'HTTP', 'FTP', 'IMAP', '2023-07-15', 8, 8);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (38, 'Qual è la funzione principale di un sistema operativo?', 'Gestire l’hardware', 'Eseguire applicazioni', 'Fornire sicurezza', 'Gestire la rete', '2023-07-15', 8, 8);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (39, 'Cosa significa l` acronimo "HTML"?', 'HyperText Markup Language', 'HighText Machine Language', 'HyperText Markup Level', 'HighText Markup Language', '2023-07-15', 8, 6);
INSERT INTO quiz (id, quesito, opzione_uno, opzione_due, opzione_tre, opzione_quattro, data_creazione, categoria_id, raccolta_id) VALUES (40, 'Qual è il principale scopo di un firewall?', 'Proteggere la rete', 'Accelerare la connessione', 'Monitorare il traffico', 'Archiviare dati', '2023-07-15', 8, 6);

-- giocatore - Raccolte giocate
INSERT INTO giocatore_elenco_raccolte (giocatore_id, elenco_raccolte_id) VALUES(4,1);
INSERT INTO giocatore_elenco_raccolte (giocatore_id, elenco_raccolte_id) VALUES(4,2);
INSERT INTO giocatore_elenco_raccolte (giocatore_id, elenco_raccolte_id) VALUES(4,3);
INSERT INTO giocatore_elenco_raccolte (giocatore_id, elenco_raccolte_id) VALUES(4,4);
INSERT INTO giocatore_elenco_raccolte (giocatore_id, elenco_raccolte_id) VALUES(4,5);
INSERT INTO giocatore_elenco_raccolte (giocatore_id, elenco_raccolte_id) VALUES(4,1);
INSERT INTO giocatore_elenco_raccolte (giocatore_id, elenco_raccolte_id) VALUES(5,2);
INSERT INTO giocatore_elenco_raccolte (giocatore_id, elenco_raccolte_id) VALUES(5,6);
INSERT INTO giocatore_elenco_raccolte (giocatore_id, elenco_raccolte_id) VALUES(5,1);
INSERT INTO giocatore_elenco_raccolte (giocatore_id, elenco_raccolte_id) VALUES(5,3);
INSERT INTO giocatore_elenco_raccolte (giocatore_id, elenco_raccolte_id) VALUES(5,6);

-- Aggiorna il counter degli id delle varie tabelle
SELECT setval('credenziali_seq', (SELECT MAX(id) FROM credenziali));
SELECT setval('utente_seq', (SELECT MAX(id) FROM utente));
SELECT setval('autore_seq', (SELECT MAX(id) FROM autore));
SELECT setval('giocatore_seq', (SELECT MAX(id) FROM giocatore));
SELECT setval('etichetta_seq', (SELECT MAX(id) FROM etichetta));
SELECT setval('categoria_seq', (SELECT MAX(id) FROM categoria));
SELECT setval('raccolta_seq', (SELECT MAX(id) FROM raccolta));
SELECT setval('quiz_seq', (SELECT MAX(id) FROM quiz));

