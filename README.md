# Progetto Quix

## Indice
1. [Intro](#intro)
2. [Modello di dominio](#modello-di-dominio)
3. [Casi d'uso](#2-casi-duso)
    - [Casi d'uso dell'Autore](#casi-duso-dellautore)
        1. [Registrazione di un autore](#a-registrazione-di-un-autore)
        2. [Login di un autore](#b-login-di-un-autore)
        3. [Creazione di una raccolta](#c-creazione-di-una-raccolta)
        4. [Creazione di un quiz](#d-creazione-di-un-quiz)
        5. [Modifica di una raccolta](#e-modifica-di-una-raccolta)
        6. [Modifica di un quiz](#f-modifica-di-un-quiz)
    - [Casi d'uso del Giocatore](#casi-duso-delgiocatore)
        1. [Registrazione di un giocatore](#a-registrazione-di-un-giocatore)
        2. [Login di un giocatore](#b-login-di-un-giocatore)
4. [Contratti](#contratti)
5. [Diagramma di comunicazione](#diagramma-di-comunicazione)
6. [Diagramma delle classi](#diagramma-delle-classi)

## Intro
Quix è un sistema di quiz accessibile da internet e sviluppato usando tecnologie come:
- Java Springboot
- Thymeleaf
- Bootstrap 5

## Modello di dominio
Le classi concettuali evidenziate in questo progetto sono:
- **Quix:**
- **Autore:** classe che modella l'entità fisica della persona che si occupa di creare delleraccolte di quiz
- **Giocatore:** classe che modella l'entità fisica della persona che interagisce giocando le raccolte di quiz
- **Raccolta:** classe che modella dei contenitori che raccolgono uno o più quiz
- **Eticheta:** classe che modella le etichette assegnabili alle raccolte e che hanno il compito di catalogare per tiopologia le raccolte
- **Quiz:** classe che modella i quiz
- **Categoria:** classe che modella le categorie assegnabili ai quiz e che hanno il compito di catalogare per tiopologia i quiz


```mermaid
classDiagram

    class Quix {
    }

    class Autore {
        ID
        Nome
        Cognome
        Email
        Username
        Password
        Biografia
        Data di registrazione
        Immagine profilo
    }

    class Giocatore {
        ID
        Nome
        Cognome
        Email
        Username
        Password
        Biografia
        Data di registrazione
        Immagine profilo
    }

    class Raccolta {
        ID
        Nome
        Descrizione
        Copertina
    }

    class Quiz {
        ID
        Quesito
        Opzione uno
        Opzione due
        Opzione tre
        Opzione quattro
    }

    class Etichetta {
        ID
        Nome
        Descrizione
    }

    class Categoria {
        ID
        Nome
        Descrizione
    }

    Quix "1" -- "*" Autore : è registrato su
    Quix "1" -- "*" Giocatore : è registrato su
    Quix "1" -- "*" Etichetta : offre
    Quix "1" -- "*" Categoria : offre
    Autore "1" -- "*" Raccolta : ha creato
    Giocatore "*" -- "*" Raccolta : ha svolto
    Raccolta "*" -- "1" Etichetta : appartiene a
    Raccolta "1" *-- "*" Quiz : è composto da
    Categoria "1" -- "*" Quiz : appartiene a
```

## Casi d'uso
Seguono i principali casi d'uso delle due tipologie di utene: Autore e Giocatore.
### Casi d'uso dell'Autore
#### a. Registrazione di un autore
Operazione che indica la registrazione di un utente di tipo Autore o Giocatore

```mermaid
sequenceDiagram
    participant A as a : Autore
    participant S as : Sistema

    A->>S: iniziaRegistrazione()
    A->>S: inserisciCredenziali(nome, cognome, email, biografia, username, password)
    A->>S: confermaRegistrazione()
    S-->>A: Registrazione avvenuta con successo
```

#### b. Login di un autore
```mermaid
sequenceDiagram
    participant A as a : Autore
    participant S as Sistema

    A->>S: iniziaLogin()
    A->>S: inserisciCredenziali(username, password)
    A->>S: confermaLogin()
    S-->>A: Login avvenuto con successo
```

#### c. Creazione di una raccolta
```mermaid
sequenceDiagram
    participant A as Autore
    participant S as Sistema

    A->>S: iniziaCreazioneRaccolta(nome, etichetta, descrizione, copertina)

    loop Aggiungi quiz
        A->>S: inserisciQuiz(quesito, opzioneUno, opzioneDue, opzioneTre, opzioneQuattro, categoria)
    end

    A->>S: confermaCreazioneRaccolta()
    S-->>A: Creazione della raccolta avvenuta con successo
```


#### d. Creazione di un quiz
```mermaid
sequenceDiagram
    participant A as Autore
    participant S as Sistema

    A->>S: inserisciQuiz(nome, opzioneUno, opzioneDue, opzioneTre, opzioneQuattro, categoria)
    S-->>A: Creazione della raccolta avvenuta con successo
```

#### e. Modifica di una raccolta

```mermaid
sequenceDiagram
    participant A as Autore
    participant S as Sistema
    
    A->>S: slezionaRaccolta(nome, opzioneUno, opzioneDue, opzioneTre, opzioneQuattro, categoria)
    A->>S: inserisciQuiz(nome, opzioneUno, opzioneDue, opzioneTre, opzioneQuattro, categoria)
    S-->>A: Creazione della raccolta avvenuta con successo
```

#### f. Modifica di un quiz

```mermaid
sequenceDiagram
    participant A as Autore
    participant S as Sistema

    A->>S: login()
    A->>S: iniziaModificaQuiz(quesito, opzioneUno, opzioneDue, opzioneTre, opzioneQuattro, categoria)
    A->>S: confermaModificaQuiz()
    S-->>A: Messaggio di sistema
```
### Casi d'uso del Giocatore
#### a. Registrazione di un giocatore
Operazione che indica la registrazione di un utente di tipo Giocatore.

```mermaid
sequenceDiagram
    participant G as g : Giocatore
    participant S as : Sistema

    G->>S: iniziaRegistrazione()
    G->>S: inserisciCredenziali(nome, cognome, email, username, password)
    G->>S: confermaRegistrazione()
    S-->>G: Registrazione avvenuta con successo
```

#### b. Login di un giocatore
```mermaid
sequenceDiagram
    participant G as g : Giocatore
    participant S as Sistema

    G->>S: iniziaLogin()
    G->>S: inserisciCredenziali(username, password)
    G->>S: confermaLogin()
    S-->>G: Login avvenuto con successo
```

## Contratti
### Registrazione
#### operazione()
**pre-condizioni:**
- ...
- ...
**post-condizioni:**
- testo 


## Diagramma di comunicazione
### b. Login di un giocatore

```mermaid

flowchart LR
    O{" "}-->|"login(id, pwd)"| A
    A[: ACME Pizza] -->|"t = getTitolare(id)"| B
    B[: Pizza Delivery]-->|"t = find()"| C 
    C[titolari : Collection<'Titolare>]

    %% Commenti visibili
    subgraph Commenti
        direction TB
        C1["Commento: Inizio del flusso di login"]
        C2["Commento: Recupero del titolare"]
        C3["Commento: Ricerca dei titolari"]
    end

    %% Posizionamento dei commenti
    C1 --> O
    C2 --> A
    C3 --> B

```

## Diagramma delle classi

```mermaid

classDiagram

    class Autore {
        - ID: int
        - Nome: string
        - Cognome: string
        - Email: string
        - Username: string
        - Password: string
        - Biografia: string
        - DataDiRegistrazione: Date
        - ImmagineProfilo: string
        + getID(): int
        + setID(id: int)
        + getNome(): string
        + setNome(nome: string)
        + getCognome(): string
        + setCognome(cognome: string)
        + getEmail(): string
        + setEmail(email: string)
        + getUsername(): string
        + setUsername(username: string)
        + getPassword(): string
        + setPassword(password: string)
        + getBiografia(): string
        + setBiografia(biografia: string)
        + getDataDiRegistrazione(): Date
        + setDataDiRegistrazione(data: Date)
        + getImmagineProfilo(): string
        + setImmagineProfilo(immagine: string)
    }

    class Giocatore {
        - ID: int
        - Nome: string
        - Cognome: string
        - Email: string
        - Username: string
        - Password: string
        - Biografia: string
        - DataDiRegistrazione: Date
        - ImmagineProfilo: string
        + getID(): int
        + setID(id: int)
        + getNome(): string
        + setNome(nome: string)
        + getCognome(): string
        + setCognome(cognome: string)
        + getEmail(): string
        + setEmail(email: string)
        + getUsername(): string
        + setUsername(username: string)
        + getPassword(): string
        + setPassword(password: string)
        + getBiografia(): string
        + setBiografia(biografia: string)
        + getDataDiRegistrazione(): Date
        + setDataDiRegistrazione(data: Date)
        + getImmagineProfilo(): string
        + setImmagineProfilo(immagine: string)
    }

    class Raccolta {
        - ID: int
        - Nome: string
        - Descrizione: string
        - Copertina: string
        + getID(): int
        + setID(id: int)
        + getNome(): string
        + setNome(nome: string)
        + getDescrizione(): string
        + setDescrizione(descrizione: string)
        + getCopertina(): string
        + setCopertina(copertina: string)
    }

    class Quiz {
        - ID: int
        - Quesito: string
        - OpzioneUno: string
        - OpzioneDue: string
        - OpzioneTre: string
        - OpzioneQuattro: string
        + getID(): int
        + setID(id: int)
        + getQuesito(): string
        + setQuesito(quesito: string)
        + getOpzioneUno(): string
        + setOpzioneUno(opzione: string)
        + getOpzioneDue(): string
        + setOpzioneDue(opzione: string)
        + getOpzioneTre(): string
        + setOpzioneTre(opzione: string)
        + getOpzioneQuattro(): string
        + setOpzioneQuattro(opzione: string)
    }

    class Etichetta {
        - ID: int
        - Nome: string
        - Descrizione: string
        + getID(): int
        + setID(id: int)
        + getNome(): string
        + setNome(nome: string)
        + getDescrizione(): string
        + setDescrizione(descrizione: string)
    }

    class Categoria {
        - ID: int
        - Nome: string
        - Descrizione: string
        + getID(): int
        + setID(id: int)
        + getNome(): string
        + setNome(nome: string)
        + getDescrizione(): string
        + setDescrizione(descrizione: string)
    }


    Quix "1" -- "*" Autore : è registrato su
    Quix "1" -- "*" Giocatore : è registrato su
    Quix "1" -- "*" Etichetta : offre
    Quix "1" -- "*" Categoria : offre
    Autore "1" -- "*" Raccolta : ha creato
    Giocatore "*" -- "*" Raccolta : ha svolto
    Raccolta "*" -- "*" Etichetta : appartiene a
    Raccolta "1" *-- "*" Quiz : è composto da
    Categoria "1" -- "*" Quiz : appartiene a

```