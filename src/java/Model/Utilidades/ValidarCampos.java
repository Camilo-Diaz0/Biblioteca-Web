package Model.Utilidades;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 *
 * @author Esteb
 */
public class ValidarCampos {
    
    static long id = 0L;
    /**
    * Valida que un nombre contenga solo letras y espacios
    * @param nombre String a validar
    * @return true si el nombre es válido, false si contiene números o caracteres especiales
    */
    public static boolean validarFormatoNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            return false;
        }

        return nombre.matches("^[\\p{L} \\s']+$");
    }
    
    /**
    * Valida que un apellido contenga solo letras y espacios
    * @param apellido String a validar
    * @return true si el apellido es válido, false si contiene números o caracteres especiales
    */
    public static boolean validarFormatoApellido(String apellido) {
        if(apellido == null || apellido.isBlank()) {
            return false;
        }
        
        return apellido.matches("^[\\p{L} \\s']+$");  
    }
    
    /**
    * Valida que el código tenga un formato numérico válido
    * @param codigo String que representa el código a validar
    * @return true si el código es válido (numérico y no vacío), false en caso contrario
    * @throws IllegalArgumentException si el código es null o vacío
    */
    public static boolean validarFormatoCodigo(String codigo) {
       if (codigo == null || codigo.isBlank() || codigo.length() < 4) {
           return false;
       }
       try {
           id = Long.parseLong(codigo);
           return id >= 0;
       } catch (NumberFormatException e) {
           return false;
       }
   }
    
    public static long getCodigo() {
        return id;
    }
    
    /**
    * Valida el formato de un correo electrónico
    * @param correo Dirección de correo a validar
    * @return true si el formato es válido, false si no lo es
    * @throws IllegalArgumentException si el correo es null o vacío
    */
    public static boolean validarFormatoCorreo(String correo) {
        // Validación de entrada
        if (correo == null || correo.isBlank()) {
            throw new IllegalArgumentException("El correo electrónico no puede estar vacío");
        }

        // Expresión regular mejorada para validación de emails
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        // Validación del formato
        boolean esValido = Pattern.matches(regex, correo);

        return esValido;
    }
    
    public static boolean validarPassword(String password) {
        if (password == null || password.length() <= 8) {
            return false; 
        }
        return true ;
    }

    
    public static Map<String, String> validarTodosCampos(String nombre, String apellido, String codigo, String email, String password) {
            Map<String, String> errores = new HashMap<>(5);

            if (!validarFormatoNombre(nombre)) {
                errores.put("nombreError", "Formato de nombre inválido");
            }
            if (!validarFormatoApellido(apellido)) {
                errores.put("apellidoError", "Formato de apellido inválido");
            }
            if (!validarFormatoCodigo(codigo)) {
                errores.put("codigoError", "Formato de código inválido");
            }
            if (!validarFormatoCorreo(email)) {
                errores.put("emailError", "Formato de email inválido");
            }
            if (!validarPassword(password)) {
                errores.put("passwordError", "La contraseña debe tener al menos 8 caracteres");
            }
            return errores;
       }
    
}
