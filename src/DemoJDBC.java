import java.sql.*;

public class DemoJDBC {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/demo";
        String uname = "postgres";
        String pass = "Zathura@1998";
        //For statement
//        String sql = "insert into student values (3, 'divyaprasath', 32);";
    //        For prepared statement
        String sql = "insert into student values (?,?,?)";

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url,uname,pass);
            System.out.println("Connection Established");
            //Normal Statment
//            Statement st = con.createStatement();
//              Prepared Statemennt
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,5);
            pst.setString(2, "Selva");
            pst.setInt(3, 20);


//            For fetching data
//            ResultSet rs = st.executeQuery(sql);
//            rs.next();
//            String name = rs.getString("sname");
//            System.out.println(name);
//            while(rs.next()){
//                System.out.print(rs.getInt(1) + " ");
//                System.out.print(rs.getString(2) + " ");
//                System.out.println(rs.getString(3)+ " ");
//            }

//            For Adding Data
            pst.execute();

            con.close();
            System.out.println("Connection Closed");

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);

        }

    }
}
