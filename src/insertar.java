import java.sql.*;

public class insertar {

    public static void main(String[] args) {

        Connection myConn = null;
        PreparedStatement myStat = null;
        ResultSet myRes = null;

        //las consultas preparadas las usamos ahora para insertar nuevo empleado

        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            System.out.println("¡Genial, nos conectamos!");


            String sql = ("INSERT INTO employees (first_name, pa_surname, email) VALUES (?, ?, ?)");

            myStat = myConn.prepareStatement(sql);
            myStat.setString(1, "Lidia");
            myStat.setString(2, "Garcia");
            myStat.setString(3, "lili@example.com");

            int rowsAffected = myStat.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Se ha creado un nuevo empleado");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
