package sk.kosickaakademia.mysql;

import java.sql.*;

public class Database {
    private String url="jdbc:mysql://itsovy.sk:3306/world_x";
    private String username = "mysqluser";
    private String password = "Kosice2021!";

    public void showCities(String country){
        String query = "SELECT city.Name , CountryCode " +
                "FROM city "+
                "INNER JOIN country ON country.code = city,CountryCode"
                "WHERE country.name LIKE ? ";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url,username,password);
            if(conn!=null){
                System.out.println("Success");
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1,country);
                System.out.println(ps);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    String city = rs.getString("Name");
                    String code = rs.getString("CountryCode");
                    System.out.println(city +" "+code);

                }
                conn.close();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
