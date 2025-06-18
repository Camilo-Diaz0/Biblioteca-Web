<%-- 
    Document   : menu_admin
    Created on : 28/04/2025, 11:50:07 a. m.
    Author     : Esteb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="Controller.ServletMenuAdmin"%>
<%@page import ="Controller.ServletConsulta"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Panel de Administración</title>
        <link rel="stylesheet" href="<%= request.getContextPath()%>/View/CSS/menu_admin.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    </head>
    <body>
        <div class="container">
            <!-- Sidebar -->
            <div class="sidebar">
                <div class="sidebar-header">
                    <h3>Panel de Administración</h3>
                </div>

                <div class="sidebar-menu">
                    <div class="menu-category">Principal</div>
                    <button class="menu-btn" data-action="dashboard">
                        <i class="fas fa-tachometer-alt"></i>
                        <span>Dashboard</span>
                    </button>

                    <div class="menu-category">Contenido</div>
                    <button class="menu-btn" data-action="gestion-usuarios">
                        <i class="fas fa-users"></i>
                        <span>Gestión de Usuarios</span>
                    </button>
                    <button class="menu-btn" data-action="busqueda-avanzada">
                        <i class="fas fa-search"></i>
                        <span>Búsqueda Avanzada</span>
                    </button>
                    <button class="menu-btn" data-action="busqueda-general">
                        <i class="fas fa-search"></i>
                        <span>Búsqueda general</span>
                    </button>
                    <button class="menu-btn" data-action="actualizar">
                        <i class="fas fa-newspaper"></i>
                        <span>Actualizar</span>
                    </button>

                    <div class="menu-category">Ventas</div>
                    <button class="menu-btn" data-action="pedidos">
                        <i class="fas fa-shopping-cart"></i>
                        <span>Pedidos</span>
                    </button>
                    <button class="menu-btn" data-action="reportes">
                        <i class="fas fa-chart-line"></i>
                        <span>Reportes</span>
                    </button>

                    <div class="menu-category">Configuración</div>
                    <button class="menu-btn" data-action="ajustes">
                        <i class="fas fa-cog"></i>
                        <span>Ajustes del Sistema</span>
                    </button>
                    <button class="menu-btn btn-danger" data-action="cerrar-sesion">
                        <i class="fas fa-sign-out-alt"></i>
                        <span>Cerrar Sesión</span>
                    </button>
                </div>
            </div>
            <!-- Main Content -->
            <div class="main-content">
                <div class="header" id = "header">
                    <h2>Dashboard</h2>
                    <div class="user-info">
                        <img src="https://via.placeholder.com/40" alt="">
                        <span></span>
                        <button class="btn btn-icon btn-primary">
                            <i class="fas fa-bell"></i>
                        </button>
                        <button class="btn btn-icon btn-primary">
                            <i class="fas fa-envelope"></i>
                        </button>
                    </div>
                </div>
                
                <div class="quick-actions" id = "quick-actions">
                    <button class="btn btn-primary" onclick="window.location.href='<%= request.getContextPath()%>/View/HTML/formulario.jsp'">
                        <i class="fas fa-plus"></i> Nuevo Usuario
                    </button>
                    <button class="btn btn-success">
                        <i class="fas fa-file-export"></i> Generar Reporte
                    </button>
                    <button class="btn btn-primary">
                        <i class="fas fa-sync-alt"></i> Actualizar
                    </button>
                </div>
                
                <div class="dashboard-cards" id = "dashboard-cards">
                    <div class="card">
                        <h3>Usuarios Registrados</h3>
                        <p>1,245</p>
                        <button class="btn btn-sm btn-primary">Ver Detalles</button>
                    </div>
                    <div class="card">
                        <h3>Productos</h3>
                        <p>568</p>
                        <button class="btn btn-sm btn-primary">Ver Detalles</button>
                    </div>
                    <div class="card">
                        <h3>Ventas Hoy</h3>
                        <p>$12,450</p>
                        <button class="btn btn-sm btn-primary">Ver Detalles</button>
                    </div>
                </div>
                
                <div class="content-section" id = "content-section">
                    <div class="section-header">
                        <h3>Actividad Reciente</h3>
                        <div>
                            <button class="btn btn-sm btn-primary">
                                <i class="fas fa-filter"></i> Filtrar
                            </button>
                            <button class="btn btn-sm btn-primary">
                                <i class="fas fa-download"></i> Exportar
                            </button>
                        </div>
                    </div>
                    <div class="activity-list">
                        <!-- Lista de actividades -->
                        <div class="activity-item">
                            <p>Nuevo usuario registrado - Juan Pérez</p>
                            <button class="btn btn-sm btn-primary">Ver</button>
                        </div>
                        <div class="activity-item">
                            <p>Pedido completado #1245</p>
                            <button class="btn btn-sm btn-primary">Ver</button>
                        </div>
                    </div>
                </div>
            </div> 
                        
           <div class="search-content" id="searchPanel" 
                style="display: ${mostrarPanelBusqueda ? 'block' : 'none'};">
               <div class="search-panel">
                   <form action="${pageContext.request.contextPath}/ServletConsulta" method="GET">
                       <input type="text" class="search-input" name="search-input" 
                              placeholder="Ingrese el número de identidad..." 
                              value="${param['search-input']}"> <!-- Mantener el valor ingresado -->
                       <button class="btn btn-primary" name = "accion" value = "buscar" type="submit">
                           <i class="fas fa-search"></i> Buscar
                       </button>
                       <button class="btn btn-danger" name = "accion"  value = "cerrar" type="sumbit">
                           <i class="fas fa-times"></i> Cerrar
                       </button>
                   </form>
               </div>
           </div>        
        </div>  
                       
        <script src="<%= request.getContextPath()%>/View/Javascript/ControladorSideBar.js?v=2"></script>
        
    </body>
</html>