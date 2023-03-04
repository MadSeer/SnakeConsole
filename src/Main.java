import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
/*
                              Добро пожаловать в мою каловую массу
                              Часов потрачено: +-7 (да, я тупой)
                              Нужно сделать:
                                        - Функция очитски поля, чтобы не
                                        создавать каждый раз новое ИЛИ
                                        переписать функцию добавления змейки
                                        на поле так, чтобы она удаляла преды-
                                        дущее местоположение
                                        - Изменить голову змейки на Стринг,
                                        чтобы движения в стороны были красивее
                                        - Запретить движение в противоположную
                                        сторону
                                        - Добавить функцию съедания хвоста
                                        - Добавить функцию съедания яблока и
                                        само яблоко
                                        - Подключить библиотеку для работы с
                                        цветом
*/
public class Main {
    public static void main(String[] args) throws IOException, CloneNotSupportedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        GameField gameField = new GameField();
        gameField.createGameField();
        SnakeActions actions = new SnakeActions();
        HashMap<Integer, Snake> snake = new HashMap();
        snake = actions.create(snake, gameField);
        gameField.addSnake(snake);
        gameField.display();
        boolean game = true;
        while (game) {
            String action = reader.readLine();
            switch (action) {
                case "w" -> {
                    snake = actions.movUp(snake, gameField);
                    gameField.createGameField();
                    gameField.addSnake(snake);
                    gameField.display();
                }
                case "a" -> {
                    snake = actions.movLeft(snake, gameField);
                    gameField.createGameField();
                    gameField.addSnake(snake);
                    gameField.display();
                }
                case "s" -> {
                    snake = actions.movDown(snake, gameField);
                    gameField.createGameField();
                    gameField.addSnake(snake);
                    gameField.display();
                }
                case "d" -> {
                    snake = actions.movRight(snake, gameField);
                    gameField.createGameField();
                    gameField.addSnake(snake);
                    gameField.display();
                }
                case "exit" -> game = false;
            }
        }

    }
}