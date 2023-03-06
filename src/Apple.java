public class Apple implements Cloneable {
    int positionX;
    int positionY;
    int score;

    public Apple clone() throws CloneNotSupportedException {
        return (Apple) super.clone();
    }
}
