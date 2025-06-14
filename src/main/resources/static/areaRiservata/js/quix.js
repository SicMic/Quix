/*** - START ***/

// Creazione input hidden con valore idRaccolta
if (window.location.pathname.includes("raccolta")) {
    const idRaccolta = document.getElementById("idRaccolta")
    idRaccolta.value = window.location.pathname.split("/")[2]
}

// Imposta nel tag con id containerRows il numero di figli come attributo valore 
if (window.location.pathname.includes("elencoQuiz") || window.location.pathname.includes("raccolta") || window.location.pathname.includes("raccolte")) {
    const container = document.getElementById("containerRows")
    container.setAttribute("valore", container.childElementCount)
}

/*** - END ***/

/***  Listener - START ***/

document.addEventListener("click", function (e) {

    //raccolte.html - start
    if (window.location.pathname.includes("raccolte") || window.location.pathname.includes("dashboardAutore")) {
        if (e.target.id.includes("showRaccoltaModal"))
            document.getElementById("newRaccoltaModal").style.display = "block"
        if (e.target.id.includes("hideRaccoltaModal"))
            document.getElementById("newRaccoltaModal").style.display = "none"
        if (e.target.id.includes("edit-raccolta"))
            document.getElementById("editor-" + e.target.id.replace("edit-", "")).style.display = "block"
        if (e.target.id.includes("delete-raccolta"))
            eliminazioneRaccolta(e.target.id.replace("delete-raccolta", ""))
        if (e.target.id.includes("hide-editor"))
            document.getElementById(e.target.id.replace("hide-", "")).style.display = "none"
    }
    //raccolte.html - end


    //Modifica e Eliminazione quiz in elencoQuiz.html e raccolta.html - start
    if (window.location.pathname.includes("elencoQuiz") || window.location.pathname.includes("raccolta")) {
        if (e.target.id.includes("edit-quiz"))
            document.getElementById("editor-" + e.target.id.replace("edit-", "")).style.display = "block"
        if (e.target.id.includes("hide-editor"))
            document.getElementById(e.target.id.replace("hide-", "")).style.display = "none"
        if (e.target.id.includes("delete-quiz"))
            eliminazioneQuiz(e.target.id.replace("delete-quiz", ""))
    }
    if (e.target.id.includes("update-quiz")) {
        const quesito = document.getElementById("quesito-quiz" + e.target.id.replace("update-quiz", ""))
        const opzioneUno = document.getElementById("opzioneUno-quiz" + e.target.id.replace("update-quiz", ""))
        const opzioneDue = document.getElementById("opzioneDue-quiz" + e.target.id.replace("update-quiz", ""))
        const opzioneTre = document.getElementById("opzioneTre-quiz" + e.target.id.replace("update-quiz", ""))
        const opzioneQuattro = document.getElementById("opzioneQuattro-quiz" + e.target.id.replace("update-quiz", ""))
        const categoria = document.getElementById("categoria-quiz" + e.target.id.replace("update-quiz", ""))
        aggiornamentoQuiz(e.target.id.replace("update-quiz", ""), quesito.innerText, opzioneUno.innerText, opzioneDue.innerText, opzioneTre.innerText, opzioneQuattro.innerText, categoria.value)
    }
    //Modifica e Eliminazione quiz in elencoQuiz.html e raccolta.html - end

    //raccolta.html - start
    if (window.location.pathname.includes("elencoQuiz") || window.location.pathname.includes("raccolta")) {
        if (e.target.id.includes("showQuizModal"))
            document.getElementById("newQuizModal").style.display = "block"
        if (e.target.id.includes("hideQuizModal"))
            document.getElementById("newQuizModal").style.display = "none"
    }
    //raccolta.html - end

})

// Topbar search input
document.addEventListener("keyup", function (e) {
    const righe = document.getElementById("containerRows").getAttribute("valore")
    if (e.target.id == "searchInput")
        if (window.location.pathname.includes("elencoQuiz") || window.location.pathname.includes("raccolta")) {
            const ricerca = e.target.value.toUpperCase()
            for (let contatore = 0; contatore < righe; contatore++) {
                const quesito = document.getElementById("quesito" + contatore)
                if (quesito.innerText.toUpperCase().indexOf(ricerca) > -1)
                    document.getElementById("quizRow" + contatore).style.display = "block"
                else
                    document.getElementById("quizRow" + contatore).style.display = "none"
            }
        } else {
            if (window.location.pathname.includes("raccolte")) {
                const ricerca = e.target.value.toUpperCase()
                console.log(righe)
                for (let contatore = 0; contatore < righe; contatore++) {
                    const raccolta = document.getElementById("nomeRaccolta" + contatore)
                    if (raccolta.innerText.toUpperCase().indexOf(ricerca) > -1)
                        document.getElementById("raccoltaRow" + contatore).style.display = "block"
                    else
                        document.getElementById("raccoltaRow" + contatore).style.display = "none"
                }
            }
        }
})

/***  Listener - END ***/



/***  Funzioni POST js - START ***/

// function eliminazioneRaccolta(idRaccolta) {
//     console.log(idRaccolta)
//     fetch('/autore/eliminazioneRaccolta', {
//         method: 'POST',
//         headers: {
//             'Content-Type': 'application/x-www-form-urlencoded'
//         },
//         body: new URLSearchParams({
//             'idRaccolta': idRaccolta
//         })
//     })
//         .then(response => response.text())
//         .then(data => {
//             console.log(data)
//             //window.location.reload()
//         })
//         .catch(error => console.error('Errore:', error));
// }

function eliminazioneRaccolta(idRaccolta) {

    idRaccolta = (Number(idRaccolta))

    // Controlla se idRaccolta è valido
    if (!idRaccolta || idRaccolta <= 0) {
        console.error("ID raccolta non valido");
        return;
    }

    fetch('/autore/eliminazioneRaccolta', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: new URLSearchParams({
            'idRaccolta': idRaccolta
        })
    })
    .then(response => {
        if (!response.ok) {
            // Gestisci gli errori di risposta
            return response.json().then(errorData => {
                throw new Error(errorData.error || 'Errore sconosciuto');
            });
        }
        return response.json(); // Assumiamo che la risposta sia in formato JSON
    })
    .then(data => {
        console.log(data.message); // Mostra il messaggio di successo
        // Puoi anche aggiornare l'interfaccia utente qui, se necessario
        // window.location.reload(); // Ricarica la pagina se necessario
    })
    .catch(error => {
        console.error('Errore:', error.message); // Mostra l'errore in console
        // Puoi anche mostrare un messaggio di errore all'utente qui
    });
}


function eliminazioneQuiz(idQuiz) {
    fetch('/autore/eliminazioneQuiz', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: new URLSearchParams({
            'idQuiz': idQuiz
        })
    })
        .then(response => response.text())
        .then(data => {
            console.log(data)
            //window.location.reload()
        })
        .catch(error => console.error('Errore:', error));
}

function aggiornamentoRaccolta(idRaccolta, nome, descrizione, urlImage, etichetta) {
    fetch('/autore/aggiornamentoRaccolta', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: new URLSearchParams({
            'idQuiz': idQuiz,
            'quesito': quesito,
            'opzioneUno': opzioneUno,
            'opzioneDue': opzioneDue,
            'opzioneTre': opzioneTre,
            'opzioneQuattro': opzioneQuattro,
            'categoria': categoria
        })
    })
        .then(response => response.text())
        .then(data => {
            //window.location.reload()
        })
        .catch(error => console.error('Errore:', error));
}


function aggiornamentoQuiz(idQuiz, quesito, opzioneUno, opzioneDue, opzioneTre, opzioneQuattro, categoria) {
    fetch('/autore/aggiornamentoQuiz', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: new URLSearchParams({
            'idQuiz': idQuiz,
            'quesito': quesito,
            'opzioneUno': opzioneUno,
            'opzioneDue': opzioneDue,
            'opzioneTre': opzioneTre,
            'opzioneQuattro': opzioneQuattro,
            'categoria': categoria
        })
    })
        .then(response => response.text())
        .then(data => {
            //window.location.reload()
        })
        .catch(error => console.error('Errore:', error));
}

/***  Funzioni POST js - END ***/
