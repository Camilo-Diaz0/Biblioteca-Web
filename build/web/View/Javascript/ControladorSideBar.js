controladorEventos = (event) => {
    const button = event.target.closest('.menu-btn');
    
    if(!button) {
        return;
    } else {
        const action = button.dataset.action;
        asignarEvento(action);
    }
    
};

function asignarEvento(action) {
    switch (action) {
        case 'dashboard':
            console.log('Dashboard clickeado');
            // window.location.href = 'ruta-del-dashboard';
            break;
        case 'gestion-usuarios':
            console.log('Gestión de Usuarios clickeado');
            window.location.href = '/BibliotecaWeb/View/HTML/menu_registrar.jsp';
            break;
        case 'busqueda-avanzada':
            console.log('Búsqueda Avanzada clickeado');
            onToggleBusquedaClick();
            break;
        case 'busqueda-general':
            console.log('Búsqueda General clickeado');
            window.location.href = '/BibliotecaWeb/View/HTML/consultaGeneral.jsp';
            break;
        case 'actualizar':
            console.log('Actualizar clickeado');
            window.location.href = '/BibliotecaWeb/View/HTML/menu_actualizar.jsp';
            break;
        case 'pedidos':
            console.log('Pedidos clickeado');
            break;
        case 'reportes':
            console.log('Reportes clickeado');
            break;
        case 'ajustes':
            console.log('Ajustes clickeado');
            break;
        case 'cerrar-sesion':
            console.log('Cerrar Sesión clickeado');
            window.location.href = '/BibliotecaWeb/View/HTML/login.jsp';
            break;
        default:
            console.warn('Acción no definida:', action);
    }
}

function asignarEventos(action) {
    const searchPanel = document.getElementById('searchPanel');

    if (action && searchPanel) {
        onToggleBusquedaClick();
    }

    if (action && searchPanel) {
        onCloseBusquedaClick();
    }

    if (action && searchInput) {
        onBuscarClick();
    }
}

// ----- Eventos -----

function onToggleBusquedaClick() {
    const searchPanel = document.getElementById('searchPanel');
    const seMostro = mostrarOcultarPanel(searchPanel);
    
    if (seMostro) {
        encenderPanelesBuscar();
    } else {
        apagarPanelesBuscar();
    }
}

function onCloseBusquedaClick() {
    const searchPanel = document.getElementById('searchPanel');
    ocultarPanel(searchPanel);
    encenderPaneles();
}

function onBuscarClick() {
    const searchInput = document.querySelector('.search-input');
    const searchTerm = searchInput.value.trim();

    if (searchTerm !== '') {
        performSearch(saerchTerm);
    } else {
        alert('Por favor ingrese un término de búsqueda');
    }
}

function performSearch(panel) {
    const searchResultsPanel = document.getElementById('search-results-panel');
    const oculto = searchResultsPanel.style.display === 'none' || panel.style.display === '';
    searchResultsPanel.style.display = oculto ? 'flex' : 'none';
    ejecutarConsulta();
}

function ejecutarConsulta() {
    const url = `ServletConsulta?search-input=${encodeURIComponent(codigo)}`;
}

// ----- Utilidades -----

function mostrarOcultarPanel(panel) {
    const oculto = panel.style.display === 'none' || panel.style.display === '';
    panel.style.display = oculto ? 'flex' : 'none';
    return oculto;
}

function ocultarPanel(panel) {
    panel.style.display = 'none';
}

function encenderPaneles() {
    const mainPanels = document.getElementsByClassName('main-content');
    for (const panel of mainPanels) {
        panel.style.display = 'flex';
    }
}

function apagarPaneles() {
    const mainPanels = document.getElementsByClassName('main-content');
    for (const panel of mainPanels) {
        panel.style.display = 'none';
    }
}

function encenderPanelesBuscar(){ 
    const searchContent = document.getElementsByClassName('search-content');
    for (const panel of searchContent) {
        panel.style.display = 'flex';
    }
}

function apagarPanelesBuscar() {
    const searchContent = document.getElementsByClassName('search-content');
    for (const panel of searchContent) {
        panel.style.display = 'none';
    }
}

/* global #sidebar */
const sideBar = document.querySelector('.sidebar-menu');
sideBar.addEventListener('click', controladorEventos);


