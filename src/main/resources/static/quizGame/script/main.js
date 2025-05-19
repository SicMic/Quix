let interruzioneCountdown = false

document.addEventListener('click', function(e) {
    if(e.target.nodeName == "BUTTON") {
        const path = window.location.pathname
        const idRaccolta = path.split('/')[2]
        const indiceQuiz = path.split('/')[3]
        const risposta = document.getElementById("answer").value
        let punteggio = parseInt(document.getElementById("score").innerText)
        interruzioneCountdown = true
        if(risposta == e.target.value)
            document.getElementById("quiz-card").style.backgroundColor = "green" 
        else
            document.getElementById("quiz-card").style.backgroundColor = "red"
        if(e.target.value == risposta) punteggio += 1
        setTimeout(()=> {sendAnswer(idRaccolta, indiceQuiz, punteggio)}, 1000) 
    }
});


document.addEventListener("DOMContentLoaded", function() {
    let timeLeft = 30; // Imposta il tempo iniziale a 30 secondi
    const countdownElement = document.getElementById('countdown');

    const countdown = setInterval(() => {
        if (timeLeft <= 0) {
            clearInterval(countdown); // Ferma il countdown quando raggiunge 0
            const path = window.location.pathname
            sendAnswer(null, path.split('/')[2], path.split('/')[3])
        } else {
            if (!interruzioneCountdown){
                timeLeft--; // Decrementa il tempo rimanente
                countdownElement.style.width = 100/30*timeLeft + "%"; // Aggiorna il contenuto con il tempo rimanente
            }

        }
    }, 1000); // Aggiorna ogni secondo (1000 millisecondi)
});


function sendAnswer(idRaccolta, indiceQuiz, punteggio) {
    fetch('/quiz', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: new URLSearchParams({
            'idRaccolta': idRaccolta,
            'indiceQuiz': indiceQuiz,
            'punteggio': punteggio
        })
    })
        .then(response => response.text())
        .then(data => {
            console.log(data)
            window.location.replace(data)
        })
        .catch(error => console.error('Errore:', error));
}