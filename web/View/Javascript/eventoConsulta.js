/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
document.addEventListener('DOMContentLoaded', buscar);

function buscar(){ 
    const searchBtn = document.getElementById('searchBtn');
    const searchPanel = document.getElementById('searchPanel');
    const searchInput = document.querySelector('.search-input');
    const closeSearchBtn = document.getElementById('closeSearchBtn');
  
    if (closeSearchBtn && searchPanel) {
        closeSearchBtn.addEventListener('click', onCloseBusquedaClick);
    } 
    if (searchBtn && searchInput) {
        searchBtn.addEventListener('click', onBuscarClick);
    }
    
}

function onCloseBusquedaClick() {
    const searchPanel = document.getElementById('searchPanel');
    ocultarPanel(searchPanel);
    encenderPaneles();
}
