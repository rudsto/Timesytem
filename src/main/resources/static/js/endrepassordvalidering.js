function passordvalidering() {
    let gammelpassordElement = document.getElementById("gammeltpassord");
    let nyttpassordElement = document.getElementById("nyttpassord");
    let gjentattnyttpassordElement = document.getElementById("gjentattnyttpassord");
    
    if (!gammelpassordElement || !nyttpassordElement || !gjentattnyttpassordElement) {
        return;
    }
    
    gammelpassordElement.setCustomValidity("");
    gammelpassordElement.checkValidity();

    nyttpassordElement.setCustomValidity("");
    nyttpassordElement.checkValidity();
    
    gjentattnyttpassordElement.setCustomValidity("");
    gjentattnyttpassordElement.checkValidity();

	let gammeltpassord = gammelpassordElement.value;
    let nyttpassord = nyttpassordElement.value;
    let gjentattnyttpassord = gjentattnyttpassordElement.value;
    
    if(gammeltpassord == null) {
		gammeltpassordElement.setCustomValidity("Må skrive gammelt passord.");
	}

    if(nyttpassord == null || nyttpassord.length < 5) {
		nyttpassordElement.setCustomValidity("Passord må være minst 5 karakterer.");
	}
	
	if(nyttpassord !== gjentattnyttpassord) {
		gjentattnyttpassordElement.setCustomValidity("Gjentatt passord må være likt.");
	}
    
    gammelpassordElement.reportValidity();
    nyttpassordElement.reportValidity();
    gjentattnyttpassordElement.reportValidity();
}

let submitbtn = document.getElementById("submit-btn");
submitbtn.addEventListener("click", passordvalidering);