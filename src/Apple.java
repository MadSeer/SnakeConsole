public class Apple implements Cloneable {
    int positionX;
    int positionY;
    boolean head;
    int score;


    public void apple(int positionx, int positiony) {
        this.positionX = positionx;
        this.positionY = positiony;
        this.score = 0;
    }

    public Apple clone() throws CloneNotSupportedException {
        return (Apple) super.clone();
    }
}
