package Model.Utilidades;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import Model.Entidades.Admin;
import Model.Entidades.Bibliotecario;
import Model.Entidades.Estudiante;
import Model.Entidades.Usuario;
import Model.Utilidades.Conexion;
import static Model.Utilidades.Conexion.conectarMySQL;
import static Model.Utilidades.Conexion.connection;
import static Model.Utilidades.Conexion.desconexion;
import java.sql.ResultSetMetaData;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.Collections;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Esteb
 */
public class MetodosSQL extends Conexion {
    
    public List<Object> seleccionarTodo(String nombreTabla) throws SQLException {
        String sql = "SELECT * FROM " + nombreTabla;
        List<Object> resultado = new ArrayList<>();
        boolean conectar = conectarMySQL();
        
        if(conectar) {
            try {
                PreparedStatement pstmt = connection.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery(sql);
                ResultSetMetaData meta = (ResultSetMetaData) rs.getMetaData();
                int columnas = meta.getColumnCount();

                String[] nombreCol = new String[columnas];
                for (int i = 1; i <= columnas; i++) {
                    nombreCol[i - 1] = meta.getColumnName(i); 
                }


                while (rs.next()) {
                    HashMap<String, Object> fila = new HashMap<>(columnas);
                    for (int i = 1; i <= columnas; i++) {
                        Object valor = rs.getObject(i);
                        fila.put(nombreCol[i - 1], valor);
                    }
                    resultado.add(fila);
                }
            } finally {
                desconexion();
            } 
        }

        return resultado;
    }
    
    public List<Object> seleccionarTodoUsers(String nombreTabla) throws SQLException {
        String sql = "SELECT * FROM " + nombreTabla;
        List<Object> resultado = new ArrayList<>();
        boolean conectar = conectarMySQL();
        
        if(conectar) {
            try {
                PreparedStatement pstmt = connection.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery(sql);
                ResultSetMetaData meta = (ResultSetMetaData) rs.getMetaData();
                int columnas = 5;

                String[] nombreCol = new String[columnas];
                for (int i = 1; i <= columnas; i++) {
                    nombreCol[i - 1] = meta.getColumnName(i); 
                }


                while (rs.next()) {
                    HashMap<String, Object> fila = new HashMap<>(columnas);
                    for (int i = 1; i <= columnas; i++) {
                        Object valor = rs.getObject(i);
                        fila.put(nombreCol[i - 1], valor);
                    }
                    resultado.add(fila);
                }
            } finally {
                desconexion();
            } 
        }

        return resultado;
    }
    
    public void setParameter(PreparedStatement pstmt, int index, Object value) throws SQLException {
        if (value == null) {
            pstmt.setNull(index, 0);
        } else if (value instanceof String string) {
            pstmt.setString(index, string);
        } else if (value instanceof Integer integer) {
            pstmt.setInt(index, integer);
        } else if (value instanceof Double aDouble) {
            pstmt.setDouble(index, aDouble);
        } else if (value instanceof Boolean aValue) {
            pstmt.setBoolean(index, aValue);
        } else if (value instanceof Date date) {
            pstmt.setDate(index, new java.sql.Date(date.getTime()));
        } else if(value instanceof Long aLong) {
            pstmt.setLong(index, aLong);
        }
    }
    
    public boolean validacion(String tabla, ArrayList<Object> datos) {
        boolean correcto = true;
        
        // Validación de parámetros de entrada
        if (tabla == null || tabla.trim().isEmpty() || datos == null) {
            correcto = false;
        }
        // Validar nombre de tabla (prevención básica contra inyección)
        boolean match = tabla.matches("[a-zA-Z_][a-zA-Z0-9_]*");
        if (!match) {
            correcto = false;
        }
        return correcto;
    }
    
    public boolean validacion(String tabla, Map<String, Object> datos) {
        boolean correcto = true;
        
        // Validación de parámetros de entrada
        if (tabla == null || tabla.trim().isEmpty() || datos.isEmpty() || datos == null) {
            correcto = false;
        }
        // Validar nombre de tabla (prevención básica contra inyección)
        boolean match = tabla.matches("[a-zA-Z_][a-zA-Z0-9_]*");
        if (!match) {
            correcto = false;
        }
        return correcto;
    }
    
    public boolean insertar(String tabla, ArrayList<Object> datos)  {
        boolean valido = validacion(tabla, datos);
        boolean succesfull = conectarMySQL();
        
        if (succesfull && valido) {
            int n = datos.size();
            
            try {
                // Construir la parte de los placeholders (?, ?, ?...)
                List<String> collection = Collections.nCopies(n, "?");
                String placeholders = String.join(",", collection);

                // Usar PreparedStatement para prevenir inyección SQL
                String sql = "INSERT INTO " + tabla + " VALUES(" + placeholders + ")";
                try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                    for(int i = 0; i < n; i++) {
                        Object dato = datos.get(i);
                        setParameter(pstmt, i + 1, dato);
                    }
                    pstmt.executeUpdate();
                }
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
            } finally {
                desconexion();
            }
        }
        return false;
    }
    
    public boolean usuarioLogin(String tabla, ArrayList<Object> datos){ 
        boolean valido = validacion(tabla, datos);
        boolean succesfull = conectarMySQL();
        
        Object cedula = datos.get(0);
        Object pass = datos.get(1);
        
        if(valido && succesfull) {
            String sql = "SELECT * FROM " + tabla + " WHERE id = ? AND Password = ?";
            
            try {
              PreparedStatement pstmt = connection.prepareStatement(sql);
              pstmt.setLong(1, (long) cedula);
              pstmt.setString(2, (String) pass);
              ResultSet rs = pstmt.executeQuery();
              return rs.next();
            } catch(SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            } finally {
                desconexion();
            }
            
        }
        return false;
    }
    
    public Object[] consultaUsuario(long primaryKey, String tabla) {
        Object [] fila = {1, "", "", "", "", ""};
        boolean succesfull = conectarMySQL();
        
        if(succesfull) {
           String sql = "SELECT * FROM " + tabla +" WHERE id = ?";
           try {
               PreparedStatement pstmt = connection.prepareStatement(sql);
               pstmt.setLong(1, primaryKey);
               ResultSet rs = pstmt.executeQuery();
               boolean foundIt = rs.next();
               
               if(foundIt) {
                  fila[0] = rs.getLong("id");
                  fila[1] = rs.getString("Nombre");
                  fila[2] = rs.getString("Apellido");
                  fila[3] = rs.getString("Estado");
                  fila[4] = rs.getString("Correo");
                  fila[5] = rs.getString("Password");
                }
               
               rs.close();
               pstmt.close();
               
            } catch(SQLException e) {
               JOptionPane.showMessageDialog(null, e.getMessage());
            } finally {
                desconexion();
            } 
        }
        return fila;
    }
    
    public Usuario obtenerUsuario(long id, String tabla){
        Object[] consultaUsuario = consultaUsuario(id, tabla);
        Usuario usuario;
        String code = UserRole.getCodeByTableName(tabla);
        switch(code) {
            case "007": usuario = new Admin();
                        break;
            case "010": usuario = new Bibliotecario();
                        break;
            case "stu": usuario = new Estudiante();
                        break;
            default: 
                usuario = null;
                break;
        }
        if(usuario != null && consultaUsuario != null){
            usuario.setCodigo((long) consultaUsuario[0]);
            usuario.setNombre((String) consultaUsuario[1]);
            usuario.setApellido((String) consultaUsuario[2]);
            usuario.setEstado((String) consultaUsuario[3]);
            usuario.setEmail((String) consultaUsuario[4]);
            usuario.setPassword((String) consultaUsuario[5]);
        }
        return usuario;
    }    
    
    public int contarUsuarios(String nombreTabla) {
        int count = 0;
        boolean succesfull = conectarMySQL();
        
        if(succesfull) {
            String sql = "SELECT COUNT(*) FROM " + nombreTabla;
            try {
                PreparedStatement pstmt = connection.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
                boolean flag = rs.next();
                
                if(flag) {
                   count = rs.getInt(1); 
                }
                
            } catch(SQLException e) {
                
            } finally {
                desconexion();
            }
        }
        return count;
    }
    
    /**
     * Actualiza selectivamente los campos de un registro, ignorando valores vacíos o nulos
     * @param tabla Nombre de la tabla
     * @param id Valor de la clave primaria
     * @param campos Map con los campos a actualizar (solo los no vacíos/nulos se actualizarán)
     * @return true si la actualización fue exitosa
     */
    public boolean actualizarCamposSelectivos(String tabla, Object id, Map<String, Object> campos) {
        // Validación básica
        boolean valido = validacion(tabla, campos);
        if (valido || id == null) {
            return false;
        }

        // Filtrar campos: eliminar nulos, vacíos o que no deban actualizarse
        Map<String, Object> camposFiltrados = new HashMap<>();
        for (Map.Entry<String, Object> entry : campos.entrySet()) {
            Object valor = entry.getValue();
            // Solo incluir el campo si tiene un valor válido
            if (valor != null && !valor.toString().trim().isEmpty()) {
                camposFiltrados.put(entry.getKey(), valor);
            }
        }

        // Si no hay campos válidos para actualizar
        if (camposFiltrados.isEmpty()) {
            return false;
        }

        boolean success = false;
        boolean connected = conectarMySQL();

        if (connected) {
            try {
                // Construir la parte SET del SQL
                StringBuilder sqlBuilder = new StringBuilder("UPDATE ");
                sqlBuilder.append(tabla).append(" SET ");

                int fieldCount = 0;
                for (String campo : camposFiltrados.keySet()) {
                    if (fieldCount > 0) {
                        sqlBuilder.append(", ");
                    }
                    sqlBuilder.append(campo).append("=?");
                    fieldCount++;
                }

                // Agregar condición WHERE
                sqlBuilder.append(" WHERE id=?");

                // Preparar la sentencia
                String sql = sqlBuilder.toString();
                try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                    // Establecer valores para los campos
                    int paramIndex = 1;
                    for (Object valor : camposFiltrados.values()) {
                        setParameter(pstmt, paramIndex++, valor);
                    }

                    // Establecer valor para el ID
                    setParameter(pstmt, paramIndex, id);

                    // Ejecutar actualización
                    int rowsAffected = pstmt.executeUpdate();
                    success = (rowsAffected > 0);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al actualizar: " + e.getMessage());
            } finally {
                desconexion();
            }
        }

        return success;
    }
    
    public boolean update(String tabla, ArrayList<Object> datos)  {
        boolean valido = validacion(tabla, datos);
        boolean succesfull = conectarMySQL();
        if (succesfull && valido) {
            int n = datos.size();
            
            try {
                
                // Usar PreparedStatement para prevenir inyección SQL
                String sql = "UPDATE `" + tabla + "` SET Nombre = ?, Apellido = ?, Correo = ?, Password = ?, Estado = ? WHERE id = ?";
                try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                    
                    for(int i = 0; i < n; i++) {
                        Object dato = datos.get(i);
                        setParameter(pstmt, i + 1, dato);
                    }
                    
                    int updated = pstmt.executeUpdate();
                    return updated > 0;
                }
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
            } finally {
                desconexion();
            }
        }
        return false;
    }
}
