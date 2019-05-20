import GLOOP.*;
class Ball{
    GLKugel ball = new GLKugel(0,15,0,30);
    double a;
    double b;
    public Ball(){
    }
    public void kickedBy(Player p){ //Ball is bouncing when ball is touched by player
        /*double a = this.ball.gibZ() - p.getZ();
        double b = this.ball.gibX() - p.getX();
        double alpha = Math.atan(a / b);
        this.ball.verschiebe(Math.sin(alpha) * 50, 0, Math.cos(alpha) * 50);
        2. try (still do not work):
        double a = (p.getX() - this.ball.gibX()) / (p.getX() - this.ball.gibX()) * -1;
        double b = (p.getZ() - this.ball.gibZ()) / (p.getZ() - this.ball.gibZ()) * -1;
        this.ball.verschiebe(a, 0, b);*/
        
        double a = (p.getX() - this.ball.gibX()) * (-1);
        
        double b = (p.getZ() - this.ball.gibZ()) * (-1);
        
        double temp = Math.abs(a) + Math.abs(b);
        
        double x = a / temp;
        double z = b / temp;
        
        if (x < 0) {
            x -= 1;
        } else {
            x +=1;
        }
        
        if (z < 0) {
            z -= 1;
        } else {
            z +=1;
        }
        
        this.ball.verschiebe(x, 0, z);
        
    }
    public double getX(){
        return ball.gibX();
    }
    
    public double getZ(){
        return ball.gibZ();
    }
    
    public void setX(double x){
        ball.setzePosition(x, 0, getZ());
    }
    
    public void setZ(double z){
        ball.setzePosition(getX(), 0, z);
    }
}