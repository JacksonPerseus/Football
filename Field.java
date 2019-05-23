import GLOOP.*;
class Field{
    private GLKamera kamera;
    private GLLicht light;
    private GLHimmel sky;
    private GLBoden ground;
    private GLTastatur keyB;
    private GLQuader q1;
    private GLQuader q2;
    private GLQuader q3;
    private GLQuader q4;
    private GLZylinder z1;
    private GLZylinder z2;
    private GLZylinder z3;
    private GLZylinder z4;
    private GLZylinder z5;
    private GLZylinder z6;
    public Field(){
        kamera = new GLSchwenkkamera();

        kamera.setzePosition(0, 1000, 3000);
        kamera.setzeBlickpunkt(0, 0, 0);
        light = new GLLicht();
        sky = new GLHimmel("Himmel.jpg");
        ground = new GLBoden("Gras.jpg");

    }

    public void border(){
        q1 = new GLQuader(0, 0, -1500, 5000, 50, 100);
        q2 = new GLQuader(-2450, 0, -500, 2000, 50, 100);
        q2.drehe(0, 90, 0);
        q3 = new GLQuader(0, 0, 500, 5000, 50, 100);
        q4 = new GLQuader(2450, 0, -500, 2000, 50, 100);
        q4.drehe(0, 90, 0);
    }

    public void buildingGoals(){
        z1 = new GLZylinder(-2450, 0, -1000, 20, 1000);
        z1.drehe(90, 0, 0);
        z2 = new GLZylinder(-2450, 0, -100, 20, 1000);
        z2.drehe(90, 0, 0);
        z3 = new GLZylinder(-2450, 500, -550, 20, 900);
        z4 = new GLZylinder(2450, 0, -1000, 20, 1000);
        z4.drehe(90, 0, 0);
        z5 = new GLZylinder(2450, 0, -100, 20, 1000);
        z5.drehe(90, 0, 0);
        z6 = new GLZylinder(2450, 500, -550, 20, 900);
    }
}