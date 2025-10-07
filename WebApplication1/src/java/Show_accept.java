
import Model.Game;
import controller.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.HashMap;



@WebServlet(urlPatterns = {"/Show_accept"})
public class Show_accept extends HttpServlet {

    Game game = new Game();
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        try {
            foods(request,response);
        } catch (Exception ex) {
            System.getLogger(Show_accept.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    private void foods(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception{
       HttpSession session = request.getSession();
       session.setAttribute("toJsp",game);
       
       String gameName = request.getParameter("game");
       String gameId = request.getParameter("game_id");
       String gamePrice = request.getParameter("game_price"); 
       
       String gameBank = request.getParameter("bank");
       
       //////////////////////////////
       ///////////////////////////////
       ///
        System.out.println("[AddNewGame] params => game=" + gameName + ", game_id=" + gameId +
                       ", game_price=" + gamePrice + ", bank=" + gameBank);
       
       game.setGameName(gameName);
       game.setGameId(gameId);
       game.setGamePrice(gamePrice);
       game.setGameBank(gameBank);
       
        DBConnection dbConnection = new DBConnection();
        if (!dbConnection.insertNewGame(game)){
            System.out.println(">>> AddNewFoodMySQL ERROR");
            
       if(gamePrice.equals("")){ 
           game.setGamePrice("ไม่ได้ใส่ราคา");
       }else{
           game.setGamePrice(gamePrice);
       }
       

       request.getRequestDispatcher("/TermgameSuccess.jsp").forward(request, response);
       request.getRequestDispatcher("/updateGame.jsp").forward(request, response);

    }
}
}