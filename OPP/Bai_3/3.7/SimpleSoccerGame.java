public class SimpleSoccerGame {
    public static void main(String[] args) {
        Ball ball = new Ball(50, 25, 0);
        
        Player[] teamA = {
            new Player(1, 10, 10),
            new Player(2, 30, 10),
            new Player(3, 50, 10)
        };
        
        Player[] teamB = {
            new Player(4, 10, 40),
            new Player(5, 30, 40),
            new Player(6, 50, 40)
        };

        for (int i = 0; i < 10; i++) {
            System.out.println("\n--- Action " + (i+1) + " ---");
            System.out.println("Ball position: " + ball);
            
            Player playerA = teamA[(int)(Math.random() * teamA.length)];
            playerA.move((float)(Math.random() * 5), (float)(Math.random() * 5));
            if (playerA.near(ball)) {
                playerA.kick(ball);
            }
            
            Player playerB = teamB[(int)(Math.random() * teamB.length)];
            playerB.move((float)(Math.random() * 5), (float)(Math.random() * 5));
            if (playerB.near(ball)) {
                playerB.kick(ball);
            }
            
            if (ball.getX() < 0) ball.setXYZ(0, ball.getY(), 0);
            if (ball.getX() > 100) ball.setXYZ(100, ball.getY(), 0);
            if (ball.getY() < 0) ball.setXYZ(ball.getX(), 0, 0);
            if (ball.getY() > 50) ball.setXYZ(ball.getX(), 50, 0);
        }
    }
}