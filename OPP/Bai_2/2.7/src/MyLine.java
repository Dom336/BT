public class MyLine {
    private MyPoint begin;
    private MyPoint end;
    
    public MyLine(int x1, int y1, int x2, int y2) {
        this.begin = new MyPoint(x1, y1);
        this.end = new MyPoint(x2, y2);
    }
    
    public MyLine(MyPoint begin, MyPoint end) {
        this.begin = begin;
        this.end = end;
    }
    
    public MyPoint getBegin() {
        return begin;
    }
    
    public void setBegin(MyPoint begin) {
        this.begin = begin;
    }
    
    public MyPoint getEnd() {
        return end;
    }
    
    public void setEnd(MyPoint end) {
        this.end = end;
    }
    
    public int getBeginX() {
        return begin.getX();
    }
    
    public void setBeginX(int x) {
        begin.setX(x);
    }
    
    public int getBeginY() {
        return begin.getY();
    }
    
    public void setBeginY(int y) {
        begin.setY(y);
    }
    
    public int getEndX() {
        return end.getX();
    }
    
    public void setEndX(int x) {
        end.setX(x);
    }
    
    public int getEndY() {
        return end.getY();
    }
    
    public void setEndY(int y) {
        end.setY(y);
    }
    
    public int[] getBeginXY() {
        return begin.getXY();
    }
    
/*************  ✨ Codeium Command ⭐  *************/
    /**
     * Sets the coordinates of the begin point of the line to the given (x,y)
     * values.
     * @param x the x-coordinate of the begin point
     * @param y the y-coordinate of the begin point
     */

/******  9baa9b89-1b49-4757-b6c4-f72e1fc56aa4  *******/
    public void setBeginXY(int x, int y) {
        begin.setXY(x, y);
    }
    
    public int[] getEndXY() {
        return end.getXY();
    }
    
    public void setEndXY(int x, int y) {
        end.setXY(x, y);
    }
    
    public double getLength() {
        return begin.distance(end);
    }
    
    public double getGradient() {
        return Math.atan2(end.getY() - begin.getY(), end.getX() - begin.getX());
    }
    
    @Override
    public String toString() {
        return "MyLine[begin=" + begin + ",end=" + end + "]";
    }
}