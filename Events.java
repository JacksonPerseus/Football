import GLOOP.*;
import java.io.File;
class Events{
    GLTafel t;
    GLZylinder s1;
    GLZylinder s2;
    int scoreP1;
    int scoreP2;
    public Events(){

    }

    public void board(){
        t = new GLTafel(0, 1250, 350, 1000, 500);
        /*s1 = new GLZylinder(-400, 0, -2000, 20, 500);
        s1.drehe(90, 0, 0);
        s2 = new GLZylinder(400, 0, -2000, 20, 500);
        s2.drehe(90, 0, 0);*/
        t.setzeText("Test", 200);
    }

    public void out(Ball b, Player p1, Player p2 ){
        Player guilty = null;
        Player inno = null;
        if(Math.abs(p1.getX() - b.getX()) <= /*65.*/ 75.0){
            if(Math.abs(p1.getZ() - b.getZ()) <= /*40.0*/ 50.0){
                guilty = p1;
                inno = p2;
            }
        }
        if(Math.abs(p2.getX() - b.getX()) <= /*65.*/ 75.0){
            if(Math.abs(p2.getZ() - b.getZ()) <= /*40.0*/ 50.0){
                guilty = p2;
                inno = p1;
            }
        }
        if(guilty != null && inno != null){
            boolean isOut = false;
            if(b.getZ() <= -1500){ //north out
                isOut = true;
                guilty.setZ(-1500 + 1000);
                inno.setX(b.getX());
                inno.setZ(-1500 + 50);
                b.setZ(inno.getZ() + 70);
                Music music = new Music();
                File sound = new File("out2.WAV");
                music.playOutSound(sound);
            }
            if(b.getX() >= 2500){
                if(b.getZ() <= -1000 && b.getZ() >= -1500){
                    isOut = true;
                    guilty.setX(2500 - 1000);
                    inno.setZ(b.getZ());
                    inno.setX(2500 - 50);
                    b.setX(inno.getX() - 70);
                    Music music = new Music();
                    File sound = new File("out2.WAV");
                    music.playOutSound(sound);
                }
            }
            if(b.getZ() >= 500){ // south out
                isOut = true;
                guilty.setZ(-50);
                inno.setX(b.getX());
                inno.setZ(450 + 50);
                b.setZ(inno.getZ() - 70);
                Music music = new Music();
                File sound = new File("out2.WAV");
                music.playOutSound(sound);
            }
            if(b.getX() >= 2550){
                if(b.getZ() <= 500 && b.getZ() >= -100){
                    isOut = true;
                    guilty.setX(2500 - 1000);
                    inno.setZ(b.getZ());
                    inno.setX(2500 - 50);
                    b.setX(inno.getX() -70);
                    Music music = new Music();
                    File sound = new File("out2.WAV");
                    music.playOutSound(sound);
                }
            }
            if(b.getX() <= -2550){
                if(b.getZ() <= 500 && b.getZ() >= -100){
                    isOut = true;
                    guilty.setX(-2500 + 1000);
                    inno.setZ(b.getZ());
                    inno.setX(-2500 + 50);
                    b.setX(inno.getX() + 70);
                    Music music = new Music();
                    File sound = new File("out2.WAV");
                    music.playOutSound(sound);
                }
            }
            if(b.getX() <= -2550){
                if(b.getZ() <= -1000 && b.getZ() >= -1500){
                    isOut = true;
                    guilty.setX(-2500 + 1000);
                    inno.setZ(b.getZ());
                    inno.setX(-2500 + 50);
                    b.setX(inno.getX() + 70);
                    Music music = new Music();
                    File sound = new File("out2.WAV");
                    music.playOutSound(sound);
                }
            }
        }
    }

    public void goalWest(Ball ball, Player p1, Player p2){
        if(ball.getX() <= -2450.0){
            if(ball.getZ() >= -1000 && ball.getZ() <= -100){
                t.setzeFarbe(255, 0, 0);
                Music music = new Music();
                File sound = new File("GoalSound.WAV");
                music.playGoalSound(sound);
                scoreP1++;
                p1.setZ(0);
                p1.setX(-400);
                p2.setZ(0);
                p2.setX(400);
                ball.setX(0);
                ball.setZ(0);
                Sys.warte(4520);
            }
        }
    }

    public void goalEast(Ball ball, Player p1, Player p2){
        if(ball.getX() >= 2450.0){
            if(ball.getZ() >= -1000 && ball.getZ() <= -100){
                t.setzeFarbe(0, 255, 0);

                Music music = new Music();
                File sound = new File("GoalSound.WAV");
                music.playGoalSound(sound);
                scoreP2++;
                ball.setX(0);
                ball.setZ(0);
                p1.setZ(0);
                p1.setX(-400);
                p2.setZ(0);
                p2.setX(400);
                Sys.warte(4520);
            }
        }
    }

    public void score(){
        t.setzeText(scoreP2 + " : " + scoreP1, 200);
    }
}