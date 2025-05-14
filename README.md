# Progetto Quix

## Indice
1. [Intro](#intro)
2. [Modello di dominio](#1-modello-di-dominio)
3. [Operazioni di sistema](#2-operazioni-di-sistema)
    1. [Registrazione](#i-operazione-registrazione)
    2. [Creazione raccolta](#ii-operazione-creazione-raccolta)
    3. [Modifica quiz](#iii-operazione-modifica-quiz)
4. [Contratti](#3-contratti)
    - [Registrazione](#i-contratto-registrazione)
    - [Creazione raccolta](#ii-contratto-creazione-raccolta)
5. [Diagramma delle classi](#iii-diagramma-delle-classi)

## Intro
Quix è un sistema di quiz accessibile da internet e sviluppato usando telcolgie come:
- Java Springboot
- Thymeleaf
- Bootstrap 5

## 1. Modello di dominio

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

    class Utente {
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
    Quix "1" -- "*" Utente : è registrato su
    Quix "1" -- "*" Etichetta : offre
    Quix "1" -- "*" Categoria : offre
    Autore "1" -- "*" Raccolta : ha creato
    Utente "*" -- "*" Raccolta : ha svolto
    Raccolta "*" -- "*" Etichetta : appartiene a
    Raccolta "1" *-- "*" Quiz : è composto da
    Categoria "1" -- "*" Quiz : appartiene a
```

## 2. Operazioni di sistema
### i. Operazione Registrazione

```mermaid
sequenceDiagram
    participant U as Utente
    participant S as Sistema

    U->>S: iniziaRegistrazione()
    U->>S: inserisciCredenziali(nome, cognome, email, username, password)
    U->>S: confermaRegistrazioneOperazione()
    S-->>U: Messaggio di sistema
```

### ii. Operazione Creazione raccolta
```mermaid
sequenceDiagram
    participant A as Autore
    participant S as Sistema

    A->>S: login()
    A->>S: iniziaCreazioneRaccolta(nome, etichetta, descrizione, copertina)

    loop Aggiungi quiz
        A->>S: inserisciQuiz(quesito, opzioneUno, opzioneDue, opzioneTre, opzioneQuattro, categoria)
    end

    A->>S: confermaCreazioneRaccolta()
    S-->>A: Messaggio di sistema
```


### iii. Operazione Modifica quiz
```mermaid
sequenceDiagram
    participant A as Autore
    participant S as Sistema

    A->>S: login()
    A->>S: iniziaModificaQuiz(quesito, opzioneUno, opzioneDue, opzioneTre, opzioneQuattro, categoria)
    A->>S: confermaModificaQuiz()
    S-->>A: Messaggio di sistema
```


## Contratti
### Registrazione
#### operazione()
**pre-condizioni:**
- ...
- ...
**post-condizioni:**
- testo 

## 4. Diagramma delle classi

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

    class Utente {
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
    Quix "1" -- "*" Utente : è registrato su
    Quix "1" -- "*" Etichetta : offre
    Quix "1" -- "*" Categoria : offre
    Autore "1" -- "*" Raccolta : ha creato
    Utente "*" -- "*" Raccolta : ha svolto
    Raccolta "*" -- "*" Etichetta : appartiene a
    Raccolta "1" *-- "*" Quiz : è composto da
    Categoria "1" -- "*" Quiz : appartiene a

```