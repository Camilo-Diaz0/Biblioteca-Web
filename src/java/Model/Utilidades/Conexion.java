package Model.Utilidades;



import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    public static Statement statement;
    public static Connection connection;
    
    static String mensaje;
    static String login = "root";
    static String password = "";
    static String host = "127.0.0.1";
    static String bd = "biblioteca_bd";

    public Conexion() {
        statement = null;
        connection = null;
    }
    
    public static boolean conectarMySQL() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            connection = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + bd, login, password);
        } catch (ClassNotFoundException e) {
            mensaje = "No se encuentra la referencia del conector de MySQL.<br/>";
            mostrarMensaje(mensaje);
            return false;
        } catch (SQLException ex) {
            mensaje = "Error al tratar de conectar con la base de datos '" + bd + "'.<br/>";
            mostrarMensaje(mensaje);
            return false;
        }
        return true;
    }

    public static void desconexion() {
        try {
            if(statement != null) {
                statement.close();
            }
            if(connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            String mensaje = "Database disconnection error";
            mostrarMensaje(mensaje);
        }
    }
    
    public static void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

}
