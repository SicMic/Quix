const token = document.querySelector('meta[name="_csrf"]').getAttribute('content')
const header = document.querySelector('meta[name="_csrf_header"]').getAttribute('content')

let interruzioneCountdown = false

document.addEventListener('click', function (e) {
    if (e.target.nodeName == "BUTTON") {
        const path = window.location.pathname
        const idRaccolta = path.split('/')[2]
        const risposta = document.getElementById("answer").value
        let punteggio = 0
        interruzioneCountdown = true
        if (risposta == e.target.value) {
            document.getElementById("quiz-card").style.backgroundColor = "#38c859"
            document.getElementById("quiz-card").style.borderRadius = "14px"
        }
        else {
            document.getElementById("quiz-card").style.backgroundColor = "#f93f3f"
            document.getElementById("quiz-card").style.borderRadius = "14px"
        }
        if (e.target.value == risposta) punteggio = 10
        setTimeout(() => { sendAnswer(idRaccolta, punteggio) }, 1000)
    }
});


document.addEventListener("DOMContentLoaded", function () {
    let timeLeft = 30; // Imposta il tempo iniziale a 30 secondi
    const countdownElement = document.getElementById('countdown');
    const totalDuration = timeLeft * 1000; // Durata totale in millisecondi
    let intervalTime = 100; // Aggiorna ogni 100 millisecondi
    let elapsedTime = 0; // Tempo trascorso

    // Imposta la larghezza iniziale della barra
    countdownElement.style.width = "100%";

    const countdown = setInterval(() => {
        elapsedTime += intervalTime; // Incrementa il tempo trascorso

        if (elapsedTime >= totalDuration) {
            clearInterval(countdown); // Ferma il countdown quando raggiunge 0
            const path = window.location.pathname;
            sendAnswer(path.split('/')[2], 0);
        } else {
            if (!interruzioneCountdown) {
                const timeRemaining = totalDuration - elapsedTime; // Calcola il tempo rimanente
                const newWidth = (timeRemaining / totalDuration) * 100 + "%"; // Calcola la nuova larghezza
                countdownElement.style.transition = "width 0.1s linear"; // Aggiungi transizione per la larghezza
                countdownElement.style.width = newWidth; // Aggiorna la larghezza della barra
            }
        }
    }, intervalTime); // Aggiorna ogni 100 millisecondi
});



function sendAnswer(idRaccolta, punteggio) {
    idRaccolta = Number(idRaccolta)
    fetch('/quiz', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
            [header]: token
        },
        body: new URLSearchParams({
            'idRaccolta': idRaccolta,
            'punteggio': punteggio
        })
    })
        .then(response => response.text())
        .then(data => {
            console.log(data)
            window.location.reload()
        })
        .catch(error => console.error('Errore:', error));
}