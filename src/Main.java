import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
/*
                              Добро пожаловать в мою каловую массу
                              Часов потрачено:
                                               Madseer:
                                                        04.03.2023 +-7 (да, я тупой)
                                                        05.03.2023
                              Нужно сделать:

                                        - Изменить голову змейки на Стринг,
                                        чтобы движения в стороны были красивее
                                        - Запретить движение в противоположную
                                        сторону
                                        - Подключить библиотеку для работы с
                                        цветом
                                        - Подключить игру в реальном времени
*/
public class Main {
    public static void main(String[] args) throws IOException, CloneNotSupportedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, Snake> snake = new HashMap<>();
        GameField gameField = new GameField();
        SnakeActions actions = new SnakeActions();
        Apple apple = new Apple();

        gameField.createOrRefreshGameField();
        snake = actions.create(snake, gameField);
        gameField.addSnake(snake);
        gameField.addApple(snake, apple);
        gameField.display(apple);

        boolean game = true;
        while (game) {
            String action = reader.readLine();
            switch (action) {
                case "w" -> snake = actions.movUp(snake, gameField, apple);
                case "a" -> snake = actions.movLeft(snake, gameField,apple);
                case "s" -> snake = actions.movDown(snake, gameField, apple);
                case "d" -> snake = actions.movRight(snake, gameField, apple);
                case "exit" -> game = false;
                default -> throw new IllegalStateException("Unexpected value: " + action);
            }
            gameField.createOrRefreshGameField();
            gameField.addSnake(snake);
            gameField.display(apple);
            actions.isDead(snake);
        }

    }
}