package Model.Utilidades;

public enum UserRole {
    ADMIN("007", "administrador"),
    LIBRARIAN("010", "bibliotecario"),
    STUDENT("stu", "estudiante");

    private final String rol;
    private final String tableName;
    
    UserRole(String rol, String tableName) {
        this.rol = rol;
        this.tableName = tableName;
    }

    public static String getTableNameByCode(String rol) {
        for (UserRole role : values()) {
            if (role.rol.equals(rol)) {
                return role.tableName;
            }
        }
        return null;
    }
    public static String getCodeByTableName(String rol) {
        for (UserRole role : values()) {
            if (role.tableName.equals(rol)) {
                return role.rol;
            }
        }
        return null;
    }
      
}
