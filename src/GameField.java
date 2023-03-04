import java.util.List;
import java.util.Map;

public class GameField {
    String[][] gameField;
    int size;

    public void createGameField() {
        this.size = 25;
        this.gameField = new String[size][size];
        int i = 0;
        int j = 0;
        while (i < gameField.length) {
            while (j < gameField[0].length) {
                gameField[i][j] = ".";
                j++;
            }
            j = 0;
            i++;
        }
    }

    public void addSnake(Map<Integer, Snake> snake) {
        List<Snake> snakemodels;
        snakemodels = snake.values().stream().toList();
        int i = 0;
        int j = 0;
        while (i < gameField.length) {
            while (j < gameField[0].length) {
                for (Snake model : snakemodels) {
                    if ((model.positionx == j) && (model.positiony == i)) {
                        if (model.head) {
                            gameField[i][j] = "#";
                        } else gameField[i][j] = "*";
                    }
                }
                j++;
            }
            j = 0;
            i++;
        }
    }

    public void display() {
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField.length; j++) {
                System.out.print(gameField[i][j] + "  ");
            }
            System.out.print("\n");
        }
    }


}
