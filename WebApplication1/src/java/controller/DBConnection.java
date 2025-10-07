
package controller;

import java.sql.*;
import java.util.Arrays;
import Model.Game;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class DBConnection {
  public boolean insertNewGame(Game game) throws Exception {
    Class.forName("com.mysql.cj.jdbc.Driver");
    String url = "jdbc:mysql://localhost:3306/game?zeroDateTimeBehavior=CONVERT_TO_NULL";
    String sql = "INSERT INTO termgame (game,game_id,game_price,bank) VALUES (?,?,?,?)";
    try (Connection conn = DriverManager.getConnection(url, "root", "1234");
         PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setString(1, game.getGameName());
      ps.setString(2, game.getGameId());
      ps.setString(3, game.getGamePrice());
      ps.setString(4, game.getGameBank());
      return ps.executeUpdate() > 0;
    }
  }

  public List<Game> retrieveAllGame() throws Exception {
    Class.forName("com.mysql.cj.jdbc.Driver");
    String url = "jdbc:mysql://localhost:3306/game?zeroDateTimeBehavior=CONVERT_TO_NULL";
    String sql = "SELECT `game`,`game_id`,`game_price`,`bank` FROM termgame ";
    List<Game> list = new java.util.ArrayList<>();
    try (Connection conn = DriverManager.getConnection(url, "root", "1234");
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
      while (rs.next()) {
        Game g = new Game();
        g.setGameName(rs.getString("game"));
        g.setGameId(rs.getString("game_id"));
        g.setGamePrice(rs.getString("game_price"));
        g.setGameBank(rs.getString("bank"));
        list.add(g);
      }
    }
    return list;
  }
}
