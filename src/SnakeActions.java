import java.util.HashMap;

public class SnakeActions {
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

    public HashMap<Integer, Snake> movUp(HashMap<Integer, Snake> snake, GameField field) throws CloneNotSupportedException {
        return goAction(snake, field, SNAKE_ACTION.UP);
    }

    public HashMap<Integer, Snake> movLeft(HashMap<Integer, Snake> snake, GameField field) throws CloneNotSupportedException {
        return goAction(snake, field, SNAKE_ACTION.START);
    }

    public HashMap<Integer, Snake> movRight(HashMap<Integer, Snake> snake, GameField field) throws CloneNotSupportedException {
        return goAction(snake, field, SNAKE_ACTION.END);
    }

    public HashMap<Integer, Snake> movDown(HashMap<Integer, Snake> snake, GameField field) throws CloneNotSupportedException {
        return goAction(snake, field, SNAKE_ACTION.DOWN);
    }

    private HashMap<Integer, Snake> goAction(HashMap<Integer, Snake> snake, GameField field, SNAKE_ACTION action) throws CloneNotSupportedException{
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
        snake.remove(snake.size() - 1);
        return snake;
    }

    private void eatApple(HashMap<Integer, Snake> snake, Apple apple){

    }

    private enum SNAKE_ACTION {
        START, END, UP, DOWN
    }

}
