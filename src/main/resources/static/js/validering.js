function validering() {
    validerFornavn();
    validerEtternavn();
    validerMobil();
    validerPassord();
    validerProsjektID();
    validerProsjektnavn();
}

function validerFornavn() {
    let fornavnElm = document.getElementById("fornavn");
    if (!fornavnElm) {
        return;
    }
    fornavnElm.setCustomValidity("");
    fornavnElm.checkValidity();
    let fornavn = fornavnElm.value;
    let fornavnRegex = /^[\p{L} -]+$/u;
    if (fornavn.length < 2 || fornavn.length > 20) {
        fornavnElm.setCustomValidity("Fornavn må være minst 2 tegn, og maks 20 tegn");
    } else if (!fornavnRegex.test(fornavn)) {
        fornavnElm.setCustomValidity("Fornavn kan kun inneholde bokstaver, bindestrek og mellomrom");
    }
}

function validerEtternavn() {
    let etternavnElm = document.getElementById("etternavn");
    if (!etternavnElm) {
        return;
    }
    etternavnElm.setCustomValidity("");
    etternavnElm.checkValidity();
    let etternavn = etternavnElm.value;
    let etternavnRegex = /^[\p{L}-]+$/u;
    if (etternavn.length < 2 || etternavn.length > 20) {
        etternavnElm.setCustomValidity("Etternavn må være minst 2 tegn, og maks 20 tegn");
    } else if (!etternavnRegex.test(etternavn)) {
        etternavnElm.setCustomValidity("Etternavn kan kun inneholde bokstaver og bindestrek");
    }
}

function validerMobil() {
    let mobilElm = document.getElementById("mobil");
    if (!mobilElm) {
        return;
    }
    mobilElm.setCustomValidity("");
    mobilElm.checkValidity();
    let mobil = mobilElm.value;
    let mobilRegex = /^[0-9]+$/;
    if (mobil.length !== 8) {
        mobilElm.setCustomValidity("Mobilnummer må være 8 siffer");

    } else if (!mobilRegex.test(mobil)) {
        mobilElm.setCustomValidity("Mobilnummer kan kun inneholde tall");
    }
}

function validerPassord() {
    let passordElm = document.getElementById("passord");
    if (!passordElm) {
        return;
    }
    passordElm.setCustomValidity("");
    passordElm.checkValidity();
    let passord = passordElm.value;
    if (passord.length < 5) {
        passordElm.setCustomValidity("Passord må være minst 5 tegn");
    }
    let passordRepetertElm = document.getElementById("passordRepetert");
    if (!passordRepetertElm) {
        return;
    }
    passordRepetertElm.setCustomValidity("");
    passordRepetertElm.checkValidity();
    let passordRepetert = passordRepetertElm.value;
    if (passord !== passordRepetert) {
        passordRepetertElm.setCustomValidity("Passordene må være like");
    }
}

function validerProsjektID() {
    let prosjekt_idElm = document.getElementById("prosjekt_id");
    if (!prosjekt_idElm) {
        return;
    }
    prosjekt_idElm.setCustomValidity("");
    prosjekt_idElm.checkValidity();
    let prosjekt_id = prosjekt_idElm.value;
    let prosjekt_idRegex = /^[0-9]+$/;
    if (prosjekt_id.length !== 6) {
        prosjekt_idElm.setCustomValidity("Prosjekt ID må være 6 siffer");

    } else if (!prosjekt_idRegex.test(prosjekt_id)) {
        prosjekt_idElm.setCustomValidity("Prosjekt ID kan kun inneholde tall");
    }
}

function validerProsjektnavn() {
    let prosjektnavnElm = document.getElementById("navn");
    if (!prosjektnavnElm) {
        return;
    }
    prosjektnavnElm.setCustomValidity("");
    prosjektnavnElm.checkValidity();
    let prosjektnavn = prosjektnavnElm.value;
    let prosjektnavnRegex = /^[\p{L} -]+$/u;
    if (prosjektnavn.length < 2 || prosjektnavn.length > 20) {
        prosjektnavnElm.setCustomValidity("Prosjektnavn må være minst 2 tegn, og maks 20 tegn");
    } else if (!prosjektnavnRegex.test(prosjektnavn)) {
        prosjektnavnElm.setCustomValidity("Prosjektnavn kan kun inneholde bokstaver, bindestrek og mellomrom");
    }
}

let submitbtn = document.getElementById("submit-btn");
submitbtn.addEventListener("click", validering);
