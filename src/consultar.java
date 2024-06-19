import java.sql.*;

public class consultar {

    public static void main(String[] args) {
        Connection myConn = null;
        Statement myStat = null;
        ResultSet myRes = null;

        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            System.out.println("¡Genial, nos conectamos!");

            myStat = myConn.createStatement();
            myRes = myStat.executeQuery("SELECT * FROM employees");

          while (myRes.next()){
              String nombre = myRes.getString("first_name");
              String mail = myRes.getString("email");
              System.out.println(nombre + " : " +  mail);
          }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}



