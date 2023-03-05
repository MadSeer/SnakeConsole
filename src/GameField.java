import java.util.*;

public class GameField {
    private String[][] gameField;
    int size = GAME_FIELD_SIZE;

    private final static String HEAD_SYMBOL = "#";
    private final static String BODY_SYMBOL = "*";
    private final static String APPLE_SYMBOL = "A";
    private final static String GAME_FIELD_SYMBOL = ".";
    private final static int GAME_FIELD_SIZE = 25;

    public void createOrRefreshGameField() {
        if (gameField == null) this.gameField = new String[size][size];
        for (String[] strings : gameField) {
            Arrays.fill(strings, GAME_FIELD_SYMBOL);
        }
    }

    public void addSnake(Map<Integer, Snake> snake) {
        List<Snake> snakeModels = snake.values().stream().toList();
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                for (Snake model : snakeModels) {
                    if ((model.positionX == j) && (model.positionY == i)) {
                        if (model.head) {
                            gameField[i][j] = HEAD_SYMBOL;
                        } else if (!Objects.equals(gameField[i][j], HEAD_SYMBOL)) gameField[i][j] = BODY_SYMBOL;
                    }
                }
            }
        }
    }

    public void addApple(Map<Integer, Snake> snake) {
        List<Snake> snakeModels = snake.values().stream().toList();
        Random random = new Random();
        Apple apple = new Apple();
        boolean generate;
        do {
            generate = false;
            apple.positionX = random.nextInt(GAME_FIELD_SIZE);
            apple.positionY = random.nextInt(GAME_FIELD_SIZE);
                for (Snake model:
                     snakeModels) {
                    if ((apple.positionX == model.positionX) && (apple.positionY == model.positionY)) {
                        generate = true;
                        break;
                    }
                }
        } while(generate);
    }

    public void display() {
        for (String[] strings : gameField) {
            for (int j = 0; j < gameField.length; j++) {
                System.out.print(strings[j] + "  ");
            }
            System.out.print("\n");
        }
    }


}
