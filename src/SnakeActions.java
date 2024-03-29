import java.io.*;
import java.util.HashMap;

public class SnakeActions {
    public boolean isDead = false;
    public HashMap<Integer, Snake> currentSnake = new HashMap<>();
    public Apple currentApple = new Apple();
    private SNAKE_ACTION currentAction = SNAKE_ACTION.END;
    public int currentSnakeSpeed = 2000;

    public HashMap<Integer, Snake> create(HashMap<Integer, Snake> snake, GameField field) {
        int i = 0;
        while (snake.size() < 5) {
            Snake snakecell = new Snake();
            snakecell.positionY = field.size / 2;
            snakecell.positionX = (field.size / 2) - i;
            if (i == 0) snakecell.head = true;
            snake.put(i, snakecell);
            i++;
        }
        return snake;
    }

    public HashMap<Integer,Snake> repeat(GameField field) throws CloneNotSupportedException {
        return goAction(currentSnake,field,currentAction,currentApple);
    }

    public void changeActionUp(){
        currentAction = SNAKE_ACTION.UP;
    }

    public void changeActionLeft(){
        currentAction = SNAKE_ACTION.START;
    }

    public void changeActionRight(){
        currentAction = SNAKE_ACTION.END;
    }

    public void changeActionDown(){
        currentAction = SNAKE_ACTION.DOWN;
    }

    private HashMap<Integer, Snake> goAction(HashMap<Integer, Snake> snake, GameField field, SNAKE_ACTION action, Apple apple) throws CloneNotSupportedException {
        HashMap<Integer, Snake> result = new HashMap<>();
        Snake head = snake.get(0).clone();

        switch (action) {
            case DOWN, END -> {
                if (action == SNAKE_ACTION.END) {
                    head.positionX++;
                    if (head.positionX == field.size) {
                        head.positionX = 0;
                    }
                } else {
                    head.positionY++;
                    if (head.positionY == field.size) {
                        head.positionY = 0;
                    }
                }
            }
            case UP, START -> {
                if (action == SNAKE_ACTION.UP) {
                    head.positionY--;
                    if (head.positionY == -1) {
                        head.positionY = field.size - 1;
                    }
                } else {
                    head.positionX--;
                    if (head.positionX == -1) {
                        head.positionX = field.size - 1;
                    }
                }
            }
        }
        result.put(0, head);
        for (int i = 0; i < snake.size(); i++) {
            result.put(1 + i, snake.get(i));
        }
        snake = result;
        snake.get(1).head = false;
        if ((apple.positionY == head.positionY) && (apple.positionX == head.positionX)) {
            eatApple(snake, apple, field);
        } else snake.remove(snake.size() - 1);
        currentSnake = snake;
        currentApple = apple;
        return snake;
    }

    private void eatApple(HashMap<Integer, Snake> snake, Apple apple, GameField field) {
        apple.score++;
        field.addApple(snake, apple);
        currentSnakeSpeed -= 50;
    }

    public boolean isDead(HashMap<Integer, Snake> snake, Apple apple) throws CloneNotSupportedException {
        Snake head = snake.get(0).clone();
        head.head = false;
        HashMap<Integer, Snake> body = new HashMap<>(snake);
        body.remove(0);
        body.forEach((key,value) -> {
            if((value.positionX == head.positionX) && (value.positionY == head.positionY)) {
                printDeath(apple);
                isDead = true;
            }
        });
        return isDead;
    }

    private void printDeath(Apple apple){
        System.out.println();
        try {
            FileReader fileReader = new FileReader("./src/Death.txt");
            int c;
            while ((c = fileReader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("""
                
                
                                ИГРА ОКОНЧЕНА
                
                """
                + "           Ваш счёт: "
                + apple.score);
    }

    private enum SNAKE_ACTION {
        START, END, UP, DOWN
    }

}
