/*
 * Model class for handling user queries based on ID and role.
 */
package Model;
import Model.Utilidades.MetodosSQL;

public class ModeloConsulta {
    private final long id;
    private final String rol;

    /**
     * Constructor to initialize ID and role.
     * @param id The user ID to query.
     * @param rol The user role (determines the table to query).
     */
    public ModeloConsulta(long id, String rol) {
        this.id = id;
        this.rol = rol;
    }

    /**
     * Performs a database query based on the user's role.
     * @return Object[] containing user data, or null if not found.
     * @throws IllegalArgumentException if the role is invalid.
     */
    public Object[] consulta() {
        MetodosSQL metodo = new MetodosSQL();
        String tableName = getTableNameByRole(rol);

        if (tableName == null) {
            throw new IllegalArgumentException("Invalid role: " + rol);
        }

        return metodo.consultaUsuario(id, tableName);
    }

    /**
     * Maps the role code to the corresponding database table name.
     * @param role The role code (e.g., "007", "010", "stu").
     * @return The table name, or null if the role is invalid.
     */
    private String getTableNameByRole(String role) {
        switch (role) {
            case "007":
                return "administrador";
            case "010":
                return "bibliotecario";
            case "stu":
                return "estudiante";
            default:
                return null;
        }
    }
}