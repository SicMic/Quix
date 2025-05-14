if (window.location.pathname.includes("raccolta")) {
    const idRaccolta = document.getElementById("idRaccolta")
    idRaccolta.value = window.location.pathname.split("/")[2]
}

/***  Listener - START ***/

document.addEventListener("click", function (e) {

    //raccolte.html - start
    if (e.target.id.includes("showRaccoltaModal"))
        document.getElementById("newRaccoltaModal").style.display = "block"
    if (e.target.id.includes("hideRaccoltaModal"))
        document.getElementById("newRaccoltaModal").style.display = "none"
    //raccolte.html - end


    //elencoQuiz.html e raccolta.html - start
    if (e.target.id.includes("edit-quiz"))
        document.getElementById("editor-" + e.target.id.replace("edit-", "")).style.display = "block"
    if (e.target.id.includes("hide-editor"))
        document.getElementById(e.target.id.replace("hide-", "")).style.display = "none"
    if (e.target.id.includes("delete"))
        eliminazioneQuiz(e.target.id.replace("delete-quiz", ""))
    //elencoQuiz.html e raccolta.html - end

    //raccolta.html - start
    if (e.target.id.includes("showQuizModal"))
        document.getElementById("newQuizModal").style.display = "block"
    if (e.target.id.includes("hideQuizModal"))
        document.getElementById("newQuizModal").style.display = "none"
    //raccolta.html - end


    if (e.target.id.includes("save")) {
        const quesito = document.getElementById("quesito-quiz" + e.target.id.replace("save-quiz", ""))
        const opzioneUno = document.getElementById("opzioneUno-quiz" + e.target.id.replace("save-quiz", ""))
        const opzioneDue = document.getElementById("opzioneDue-quiz" + e.target.id.replace("save-quiz", ""))
        const opzioneTre = document.getElementById("opzioneTre-quiz" + e.target.id.replace("save-quiz", ""))
        const opzioneQuattro = document.getElementById("opzioneQuattro-quiz" + e.target.id.replace("save-quiz", ""))
        const categoria = document.getElementById("categoria-quiz" + e.target.id.replace("save-quiz", ""))
        aggiornamentoQuiz(e.target.id.replace("save-quiz", ""), quesito.innerText, opzioneUno.innerText, opzioneDue.innerText, opzioneTre.innerText, opzioneQuattro.innerText, categoria.value)
    }
})



// Topbar search input
document.addEventListener("keyup", function (e) {
    if (e.target.id == "searchInput") {
        const ricerca = e.target.value.toUpperCase()
        for (let contatore = 1; contatore <= 4; contatore++) {
            const quesito = document.getElementById("quesito" + contatore)
            console.log(quesito.innerText)
            if (quesito.innerText.toUpperCase().indexOf(ricerca) > -1)
                document.getElementById("quizRow" + contatore).style.display = "block"
            else
                document.getElementById("quizRow" + contatore).style.display = "none"
        }
    }

})
/***  Listener - END ***/



/***  Funzioni POST js - START ***/

function eliminazioneQuiz(idQuiz) {
    fetch('/eliminazioneQuiz/', {
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
            window.location.reload()
        })
        .catch(error => console.error('Errore:', error));
}

function aggiornamentoQuiz(idQuiz, quesito, opzioneUno, opzioneDue, opzioneTre, opzioneQuattro, categoria) {
    fetch('/aggiornamentoQuiz', {
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
            window.location.reload()
        })
        .catch(error => console.error('Errore:', error));
}

/***  Funzioni POST js - END ***/
