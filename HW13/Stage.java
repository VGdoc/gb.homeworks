package HW13;

public abstract class Stage {
    protected int length;
    protected String description;
    private boolean hasWinner;

    public String getDescription() {
        return description;
    }

    public abstract void go(Car c);

    public boolean isHasWinner() {
        return hasWinner;
    }

    public void setHasWinner(boolean hasWinner) {
        this.hasWinner = hasWinner;
    }
}
