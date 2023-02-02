import com.group4.Board;
import com.group4.Game;
import com.group4.GameStatus;
import com.group4.Player;
import com.group4.Spot;
import com.group4.player.HumanPlayer;

import java.util.Scanner;

public class tesMain {
    public static void main(String[] args) {
        Player p1 = new HumanPlayer(true);
        Player p2 = new HumanPlayer(false);
        Board board = new Board();
        Game game = new Game(board, p1, p2);
        game.setStatus(GameStatus.ACTIVE);
        Scanner sc = new Scanner(System.in);
        do {
            board.printBoard();
            System.out.println("=== === === === ===");
            // Check Turn
            if (game.getCurrentTurn().isWhite()) {
                System.out.println(" == White Turn == ");
            } else {
                System.out.println(" == Black Turn == ");
            }
            System.out.println("=== === === === ===");

            Spot start = null;
            do {
                System.out.println("SELECT PIECE TO MOVE ");
                System.out.println("ENTER COORDINATE");
                System.out.print("Enter X :");
                int x = sc.nextInt();
                System.out.print("Enter Y :");
                int y = sc.nextInt();
                start = board.getBox(x, y);
            } while (start.getPiece() == null || start.getPiece().isWhite() != game.getCurrentTurn().isWhite());

            Spot end = null;
            do {
                System.out.println("SELECT COORDINATE TO MOVE");
                System.out.println("ENTER COORDINATE");
                System.out.print("Enter X :");
                int x = sc.nextInt();
                System.out.print("Enter Y :");
                int y = sc.nextInt();
                end = board.getBox(x, y);
            } while (!start.getPiece().canMove(board, start, end));

            game.playerMove(game.getCurrentTurn(), start, end);
        } while (game.getStatus() == GameStatus.ACTIVE);
        if (game.isEnd()) {
            System.out.println();
            System.out.println("=== ========= ===");
            if (game.getStatus() == GameStatus.WHITE_WIN) {
                System.out.println("=== WHITE WIN ===");
            } else if (game.getStatus() == GameStatus.BLACK_WIN) {
                System.out.println("=== BLACK WIN ===");
            }
            System.out.println("=== ========= ===");
            System.out.println();
        }
    }
}
