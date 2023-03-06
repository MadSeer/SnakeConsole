import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

/*
                              Добро пожаловать в мою каловую массу
                              Часов потрачено:
                                               Madseer:
                                                        04.03.2023 +-7 (да, я тупой)
                                                        05.03.2023 5
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
        actions.currentSnake = snake;
        actions.currentApple = apple;
        gameField.addSnake(snake);
        gameField.addApple(snake, apple);
        gameField.display(apple);

        AtomicReference<HashMap<Integer, Snake>> newSnake = new AtomicReference<>(actions.repeat(actions.currentSnake, gameField, apple));

        Runnable r = () -> {
            while (true) {
                try {
                    newSnake.set(actions.repeat(actions.currentSnake, gameField, actions.currentApple));
                    gameField.createOrRefreshGameField();
                    gameField.addSnake(newSnake.get());
                    gameField.display(actions.currentApple);
                    actions.isDead(newSnake.get(), actions.currentApple);
                    Thread.sleep(actions.currentSnakeSpeed);
                    System.out.println("""
                            
                           ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
                            """);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (CloneNotSupportedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        new Thread(r, "thread").start();

        boolean game = true;
        while (game) {
            String action = reader.readLine();
            switch (action) {
                case "w" -> actions.changeActionUp();
                case "a" -> actions.changeActionLeft();
                case "s" -> actions.changeActionDown();
                case "d" -> actions.changeActionRight();
                case "exit" -> game = false;
                default -> System.out.println("input error");
            }
        }

    }
}