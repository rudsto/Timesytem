function validering() {
    validerFornavn();
    validerEtternavn();
    validerMobil();
    validerPassord();
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

let submitbtn = document.getElementById("submit-btn");
submitbtn.addEventListener("click", validering);
