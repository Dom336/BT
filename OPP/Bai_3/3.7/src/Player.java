public class Player {
    private int number;
    private float x;
    private float y;
    private float z = 0.0f;

    public Player(int number, float x, float y) {
        this.number = number;
        this.x = x;
        this.y = y;
    }

    public void move(float xDisp, float yDisp) {
        x += xDisp;
        y += yDisp;
        z = 0.0f;
    }

    public void jump(float zDisp) {
        z += zDisp;
    }

    public boolean near(Ball ball) {
        float distance = (float)Math.sqrt(
            Math.pow(x - ball.getX(), 2) + 
            Math.pow(y - ball.getY(), 2) + 
            Math.pow(z - ball.getZ(), 2));
        return distance < 8;
    }

    public void kick(Ball ball) {
        if (near(ball)) {
            float kickX = (float)(20 * Math.random() - 10);
            float kickY = (float)(20 * Math.random() - 10);
            ball.setXYZ(ball.getX() + kickX, ball.getY() + kickY, 0);
            System.out.println("Player " + number + " kicks the ball!");
        }
    }
}