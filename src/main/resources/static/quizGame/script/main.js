document.addEventListener('click', function(e) {
    if(e.target.nodeName == "BUTTON") {
        const path = window.location.pathname
        sendAnswer(e.target.value, path.split('/')[2], path.split('/')[3])
    }
});

function sendAnswer(risposta, idRaccolta, indice) {
    fetch('/quiz', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: 'risposta=' + encodeURIComponent(risposta) +
          '&idRaccolta=' + encodeURIComponent(idRaccolta) +
          '&indice=' + encodeURIComponent(indice)
    })
    .then(response => response.text())
    .then(data => {        
        //Approccio molto precario [TEMPORANEO - DA RIVEDERE]
        console.log(data)
        const jsonObject = JSON.parse(data);
        const path = jsonObject.path; // "/1/2"
        const interi = path.split('/').slice(1); // ["1", "2"]
        window.location.replace("/quiz/" + interi[0] + "/" + interi[1]);
    })
    .catch(error => console.error('Errore:', error));
}