function timevalidering() {
    let prosjekt_idElement = document.getElementById("prosjekt_id");
    let timerElement = document.getElementById("antallTimer");
    if (!prosjekt_idElement || !timerElement) {
        return;
    }
    prosjekt_idElement.setCustomValidity("");
    prosjekt_idElement.checkValidity();

    timerElement.setCustomValidity("");
    timerElement.checkValidity();

    let prosjekt_id = prosjekt_idElement.value;
    let prosjekt_idRegEx = /^[0-9]{6}$/;

    let timer = timerElement.value;
    let timerRegEx = /^[0-9]{1,2}$/

    if (!prosjekt_idRegEx.test(prosjekt_id)) {
        prosjekt_idElement.setCustomValidity("Prosjekt ID må være 6 siffer");
    }

    if (!timerRegEx.test(timer)) {
        timerElement.setCustomValidity("Tast inn antall timer arbeidet");
    }
}
let submitbtn = document.getElementById("submit-btn");
submitbtn.addEventListener("click", timevalidering);
