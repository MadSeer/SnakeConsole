public class Snake implements Cloneable {
    int positionX;
    int positionY;
    boolean head;

    public void snake(int positionx, int positiony) {
        this.positionX = positionx;
        this.positionY = positiony;
    }

    public Snake clone() throws CloneNotSupportedException {
        return (Snake) super.clone();
    }
}
