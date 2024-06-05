import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class eliminar {
    public static void main(String[] args) {

        Connection myConn = null;
        Statement myStat = null;
        ResultSet myRes = null;

        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            System.out.println("¡Genial, nos conectamos!");

            myStat = myConn.createStatement();

            int rowsAffected = myStat.executeUpdate("DELETE FROM employees WHERE first_name = 'Lidia'");

            if (rowsAffected > 0) {
                System.out.println("Se ha eliminado al empleado");
            }

            System.out.println("EMPLEADOS ACTUALES: ");
            myRes = myStat.executeQuery("SELECT * FROM employees");
            while (myRes.next()) {
                String firstName = myRes.getString("first_name");
                System.out.println("Empleado: " + firstName );
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println();
        }

    }
}
