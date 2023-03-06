public class Snake implements Cloneable {
    int positionX;
    int positionY;
    boolean head;

    public Snake clone() throws CloneNotSupportedException {
        return (Snake) super.clone();
    }
}
