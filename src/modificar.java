import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class modificar {

    public static void main(String[] args) {

        Connection myConn = null;
        Statement myStat = null;
        ResultSet myRes = null;

        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            System.out.println("¡Genial, nos conectamos!");


            myStat = myConn.createStatement();


            //MODIFICAR UN EMPLEADO

            int rowsAffected = myStat.executeUpdate("UPDATE employees SET email = 'emily@example.com' WHERE first_name = 'Emily'");

            if (rowsAffected > 0) {
                System.out.println("Se ha actualizado el correo electrónico de Emily");
            }


            myRes = myStat.executeQuery("SELECT * FROM employees");
            while (myRes.next()) {
                String firstName = myRes.getString("first_name");
                String email = myRes.getString("email");
                System.out.println("Empleado: " + firstName + ", Email: " + email);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println();
        }

    }

}
