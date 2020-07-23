package models;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads{
    private Connection connection;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Ad> all() {
        List<Ad> ads = new ArrayList<>();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String selectQuery = "SELECT * FROM ads";
            ResultSet rs = stmt.executeQuery(selectQuery);
            while(rs.next()) {
                ads.add(new Ad(rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getString("title"),
                        rs.getString("description")
                ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ads;
    }

    @Override
    public Long insert(Ad ad) {
        long lastInsertId = 0;
        String insertQuery = String.format(
                "INSERT INTO ads (user_id, title, description) VALUES ('%d', '%s', '%s')",
                ad.getUserId(),
                ad.getTitle(),
                ad.getDescription());
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(insertQuery, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()) {
                lastInsertId = rs.getLong(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lastInsertId;
    }

    public static void main(String[] args) {
        Ad myBike = new Ad(1, "My Bike", "please I need to get rid of this.");
        Ads adsDao = new MySQLAdsDao(new Config());
        System.out.println(adsDao.all());
        adsDao.insert(myBike);
    }
}
