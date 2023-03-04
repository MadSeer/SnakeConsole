public class Snake implements Cloneable {
    int positionx;
    int positiony;
    boolean head;

    public void snake(int positionx, int positiony) {
        this.positionx = positionx;
        this.positiony = positiony;
        this.head = head;
    }

    public Snake clone() throws CloneNotSupportedException {
        return (Snake) super.clone();
    }
}
