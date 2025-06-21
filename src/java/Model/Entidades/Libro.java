/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Entidades;

import java.util.Map;
import java.util.HashMap;
/**
 *
 * @author Esteb
 */
public class Libro {
    
    public Libro() {
        
    }
    
    /**
     * Validates all fields and returns a map of errors.
     * @param id
     * @param titulo
     * @param autor
     * @param materia
     * @param fecha
     * @param estado
     * @return Map containing field names and their respective error messages
     */
    public static Map<String, String> validarTodosCampos(String id, String titulo, String autor, String materia, String fecha, String estado) {
        Map<String, String> errores = new HashMap<>(6);

        if (!validateId(id)) {
            errores.put("idError", "ID must be a valid number and cannot be empty");
        }
        if (!validateTitulo(titulo)) {
            errores.put("tituloError", "Title cannot be empty, must not exceed 200 characters, and contain valid characters");
        }
        if (!validateAutor(autor)) {
            errores.put("autorError", "Author cannot be empty, must not exceed 100 characters, and contain valid characters");
        }
        if (!validateMateria(materia)) {
            errores.put("materiaError", "Subject cannot be empty, must not exceed 100 characters, and contain valid characters");
        }
        if (!validateFecha(fecha)) {
            errores.put("fechaError", "Date must be in YYYY-MM-DD format and valid");
        }
        if (!validateEstado(estado)) {
            errores.put("estadoError", "Status must be one of: AVAILABLE, BORROWED, RESERVED, LOST");
        }
        return errores;
    }
    
    /**
     * Validates the ID parameter.
     * @param id The ID to validate
     * @return true if valid, false otherwise
     */
    private static boolean validateId(String id) {
        if (id == null || id.trim().isEmpty()) {
            return false;
        }
        try {
            Long.parseLong(id);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    /**
     * Validates the title parameter.
     * @param titulo The title to validate
     * @return true if valid, false otherwise
     */
    private static boolean validateTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            return false;
        }
        if (titulo.length() > 200) {
            return false;
        }
        return titulo.matches("[a-zA-Z0-9\\s\\p{Punct}]+");
    }
    
    /**
     * Validates the author parameter.
     * @param autor The author to validate
     * @return true if valid, false otherwise
     */
    private static boolean validateAutor(String autor) {
        if (autor == null || autor.trim().isEmpty()) {
            return false;
        }
        if (autor.length() > 100) {
            return false;
        }
        return autor.matches("[a-zA-Z\\s\\.,-]+");
    }
    
    /**
     * Validates the subject parameter.
     * @param materia The subject to validate
     * @return true if valid, false otherwise
     */
    private static boolean validateMateria(String materia) {
        if (materia == null || materia.trim().isEmpty()) {
            return false;
        }
        if (materia.length() > 100) {
            return false;
        }
        return materia.matches("[a-zA-Z0-9\\s\\p{Punct}]+");
    }
    
    /**
     * Validates the publication date parameter.
     * @param fecha The date to validate
     * @return true if valid, false otherwise
     */
    private static boolean validateFecha(String fecha) {
        if (fecha == null || fecha.trim().isEmpty()) {
            return false;
        }
        if (!fecha.matches("\\d{4}-\\d{2}-\\d{2}")) {
            return false;
        }
        try {
            java.time.LocalDate.parse(fecha);
            return true;
        } catch (java.time.format.DateTimeParseException e) {
            return false;
        }
    }
    
    /**
     * Validates the status parameter.
     * @param estado The status to validate
     * @return true if valid, false otherwise
     */
    private static boolean validateEstado(String estado) {
        if (estado == null || estado.trim().isEmpty()) {
            return false;
        }
        String[] validStatuses = {"DISPONIBLE", "PRESTADO", "RESERVADO", "PERDIDO"};
        for (String validStatus : validStatuses) {
            if (validStatus.equalsIgnoreCase(estado)) {
                return true;
            }
        }
        return false;
    }
}
