import GLOOP.*;
import java.io.File;
class Main{
    
    private Main() {
        
    }
    
    public static void main(String[] args){
        GLTastatur tas = new GLTastatur();
        Field field = new Field();
        Player player1 = new Player(-400,0,0);
        Player player2 = new Player(400,0,0);
        Ball ball = new Ball();
        field.border();
        Events events = new Events();
        events.board();
        field.buildingGoals();
        //events.goalWest(ball);
        Music music = new Music();
        File sound = new File("StartSound.WAV");
        music.playStartSound(sound);
        
        
        player1.setRed();
        player2.setGreen();
        
        Sys.warte(9950);
        

        while(!tas.istGedrueckt('x')){
            double force = 1.5;
            
            if(tas.istGedrueckt('w')){
                player1.move(0, 0, -1 * force);
            }
            if(tas.istGedrueckt('d')){
                player1.move(force, 0, 0);
            }
            if(tas.istGedrueckt('a')){
                player1.move(-1 * force, 0, 0);
            }
            if(tas.istGedrueckt('s')){
                player1.move(0, 0, force);
            }
            if(tas.oben()){
                player2.move(0, 0, -1 * force);
            }
            if(tas.rechts()){
                player2.move(force, 0, 0);
            }
            if(tas.links()){
                player2.move(-1 * force, 0, 0);
            }
            if(tas.unten()){
                player2.move(0, 0, force);
            }
            if(Math.abs(player1.getX() - ball.getX()) <= 65.0){
                if(Math.abs(player1.getZ() - ball.getZ()) <= 40.0){
                    ball.kickedBy(player1);
                }
            }
            if(Math.abs(player2.getX() - ball.getX()) <= 65.0){
                if(Math.abs(player2.getZ() - ball.getZ()) <= 40.0){
                    ball.kickedBy(player2);
                }
            }
            events.out(ball, player1, player2);
            events.goalWest(ball, player1, player2);
            events.goalEast(ball, player1, player2);
            events.score();
            Sys.warte(4);
        }
    }
}