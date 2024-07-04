//dohvata html elemente tabele u koje se kupe iz servera i salje u front-end
function dohvatiBiblioteke(){
    let imenaKolonaBibliotekaTabele = document.getElementById("imenaKolonaBibloteke");
    let biblotekeHtml = document.getElementById("biblioteke");
    biblotekeHtml.innerHTML = "";

    fetch("http://localhost:8080/dohvatiBiblioteke").then(e=>e.json()).then(response =>{
        if (response.length > 0) {
            imenaKolonaBibliotekaTabele.display = '';
        }
        else {
            imenaKolonaBibliotekaTabele.display = 'none';
        }
        response.forEach(biblioteka => {
            document.getElementById("trenutnaBiblioteka").innerHTML = biblioteka.id
            biblotekeHtml.innerHTML += 
            `
             <tr>
                <td>${biblioteka.ime}</td>
                <td>${biblioteka.adresa}</td>
                <td><button onclick="ucitajKnjige(${biblioteka.id})">Izaberi</button></td>
            </tr>
            `
        });
    })
}

function registrujBiblioteku(){
    let ime = document.getElementById("imeBiblioteke").value
    let adresa = document.getElementById("adresaBiblioteke").value

    fetch("http://localhost:8080/registrujBiblioteku", {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({
            ime: ime,
            adresa: adresa
        })
    }).then(e=>dohvatiBiblioteke())
}

function ucitajKnjige(bibliotekaId){
    let imenaKolonaKnjiga = document.getElementById("imenaKolonaKnjiga");
    let knjigeElement = document.getElementById("knjige");
    knjigeElement.innerHTML = ""
    console.log(bibliotekaId)
    document.getElementById("trenutnaBiblioteka").innerHTML = bibliotekaId
    fetch("http://localhost:8080/dohvatiKnjige/" + bibliotekaId).then(e=>e.json()).then(response =>{
        let ukupnaCena = 0;

        if (response.length > 0) {
            imenaKolonaKnjiga.hidden = false;
        }
        else {
            imenaKolonaKnjiga.hidden = false;
        }

        response.forEach(knjiga=>{
            ukupnaCena += knjiga.cena;
            knjigeElement.innerHTML +=
            `
            <tr>
                <td>${knjiga.vremeDodavanja}</td>
                <td>${knjiga.ime}</td>
                <td>${knjiga.cena}</td>
            </tr>
            `
        })
        document.getElementById("ukupnaCena").innerHTML = ukupnaCena
    })

}

function dodajKnjigu(){
    let bibliotekaId = parseInt(document.getElementById("trenutnaBiblioteka").innerHTML);

    fetch("http://localhost:8080/dodajKnjigu", {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({
            ime: document.getElementById("imeKnjige").value,
            cena: parseFloat(document.getElementById("cenaKnjige").value),
            bibliotekaId: bibliotekaId
        })
    }).then(e=>ucitajKnjige(bibliotekaId))
}

