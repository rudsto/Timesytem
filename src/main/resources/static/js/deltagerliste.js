"use strict";

function expandView(evt, tabName){
    // Variable for the current tab's content
    let tabcontent;

    // Get the element of the current tab content
    tabcontent = document.getElementById(tabName);

    // If the current tab is already displayed, hide it and remove "active" class
    if (tabcontent.style.display === "block") {
        tabcontent.style.display = "none";
        evt.currentTarget.classList.remove("active");
    } else {
        // Hide all other tabs
        hideAllTabs();

        // Show the current tab and add "active" class
        tabcontent.style.display = "block";
        evt.currentTarget.classList.add("active");
    }
}

function hideAllTabs(){
    let i, tabcontent, tablinks;

    // Get all elements with class="tabcontent" and hide them
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }

    // Get all elements with class="tablinks" and remove the class "active"
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].classList.remove("active");
    }

}