import java.sql.*;

public class DemoJDBC {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/demo";
        String uname = "postgres";
        String pass = "Zathura@1998";
        String sql = "SELECT sname FROM public.student where sid=1";

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url,uname,pass);
            System.out.println("Connection Established");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            String name = rs.getString("sname");
            System.out.println(name);
            con.close();
            System.out.println("Connection Closed");

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
