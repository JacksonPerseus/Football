import GLOOP.*;
class Player{
    GLQuader player;
    GLTastatur tas = new GLTastatur();
    public Player(double x, double y, double z){
        this.player = new GLQuader(x,y,z,100,500,50);
    }

    public void move(double x, double y, double z){ //player should move
        this.player.verschiebe(x, y, z);
    }
    
    public double getX(){
        return player.gibX();
    }
    
    public double getZ(){
        return player.gibZ();
    }
    
    public void setX(double x){
        player.setzePosition(x, 0, getZ());
    }
    
    public void setZ(double z){
        player.setzePosition(getX(), 0, z);
    }
    
    public void setRed(){
        player.setzeFarbe(1, 0, 0);
    }
    
    public void setGreen(){
        player.setzeFarbe(0, 1, 0);
    }
}