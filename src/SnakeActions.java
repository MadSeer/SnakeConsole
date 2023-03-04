import java.util.HashMap;

public class SnakeActions {
    public HashMap<Integer, Snake> create(HashMap<Integer, Snake> snake, GameField field) {
        int i = 0;
        while (snake.size() < 5) {
            Snake snakecell = new Snake();
            snakecell.positiony = field.size / 2;
            snakecell.positionx = (field.size / 2) - i;
            if (i == 0) snakecell.head = true;
            snake.put(i, snakecell);
            i++;
        }
        return snake;
    }

    public HashMap<Integer, Snake> movUp(HashMap<Integer, Snake> snake, GameField field) throws CloneNotSupportedException {
        HashMap<Integer, Snake> result = new HashMap<>();
        Snake cloned = snake.get(0);
        Snake head = cloned.clone();
        head.positiony--;
        if (head.positiony == -1) {
            head.positiony = field.size - 1;
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

    public HashMap<Integer, Snake> movDown(HashMap<Integer, Snake> snake, GameField field) throws CloneNotSupportedException {
        HashMap<Integer, Snake> result = new HashMap<>();
        Snake cloned = snake.get(0);
        Snake head = cloned.clone();
        head.positiony++;
        if (head.positiony == field.size) {
            head.positiony = 0;
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

    public HashMap<Integer, Snake> movLeft(HashMap<Integer, Snake> snake, GameField field) throws CloneNotSupportedException {
        HashMap<Integer, Snake> result = new HashMap<>();
        Snake cloned = snake.get(0);
        Snake head = cloned.clone();
        head.positionx--;
        if (head.positionx == -1) {
            head.positionx = field.size - 1;
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

    public HashMap<Integer, Snake> movRight(HashMap<Integer, Snake> snake, GameField field) throws CloneNotSupportedException {
        HashMap<Integer, Snake> result = new HashMap<>();
        Snake cloned = snake.get(0);
        Snake head = cloned.clone();
        head.positionx++;
        if (head.positionx == field.size) {
            head.positionx = 0;
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

}
