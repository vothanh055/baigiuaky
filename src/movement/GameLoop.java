package movement;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import baidemo.Demo;
import model.Nhanvat;
import model.Quai;

public class GameLoop implements Runnable{
    private boolean isRunning;
    private Demo demo;
    public static List<Quai> characters;
    private KinematicWandering kinematicWandering;
    public static Nhanvat nv;
    public static int timeReal;
    private int countQuai;


    public GameLoop(boolean isRunning, Demo demo) {
        super();
        this.isRunning = isRunning;
        this.demo = demo;
        this.timeReal = 0;
        countQuai=1;

        nv= new Nhanvat(new Vector2D(450, 300), 0, new Vector2D(0, 0), 0, Color.RED);
        kinematicWandering = new KinematicWandering(nv, 4, 2);
        
        this.characters = new ArrayList<Quai>();           
    }

    public boolean isRunning() {
            return isRunning;
    }

    public void setRunning(boolean isRunning) {
            this.isRunning = isRunning;
    }

    public Demo getDemo() {
            return demo;
    }

    public void setDemo(Demo demo) {
            this.demo = demo;
    }

    public int getTimeReal() {
        return timeReal;
    }

    public void setTimeReal(int timeReal) {
        this.timeReal = timeReal;
    }

    public int getCountQuai() {
        return countQuai;
    }

    public void setCountQuai(int countQuai) {
        this.countQuai = countQuai;
    }
    
    

    @Override
    public void run() {           
        while (true) {           
                       
//            this.characters.get(0).update(this.kinematicSeeks.get(0).generateKinematicOutput(), 2);
            //this.characters.get(0).render(this.demo.getGraphics());
//            this.characters.get(1).setPosition(new Vector2D(500, 500));
            //this.characters.get(1).render(this.demo.getGraphics());
            
            /*System.out.println(this.kinematicFlees.get(0).getCharacter().getPosition().toString());
            this.characters.get(0).update(this.kinematicFlees.get(0).generateKinematicOutput(), 5);
            this.characters.get(0).render(this.demo.getGraphics());
            this.characters.get(1).setPosition(new Vector2D(500, 500));
            this.characters.get(1).render(this.demo.getGraphics());*/    
            
            //nv.update(this.kinematicWandering.generateKinematicOutput(), 2); 
            //System.out.println(nv.getRotation());
            //System.out.println(nv.getOrientation());
            nv.update(2);
            int x= (int)nv.getPosition().getX()-30;
            int y = (int) nv.getPosition().getZ()-30;
            Quai q = new Quai(new Vector2D(
                x + 30 +(int) ( 60*Math.sin(nv.getOrientation()))
                , y + 30 + (int) ( 60*Math.cos(nv.getOrientation()))), 
                0, new Vector2D(0, 0), 0, Color.RED,36);
            this.characters.add(q);
            if(countQuai>=36){
                this.characters.remove(0);
            }
            demo.getGraphics().clearRect(0,  0,  demo.getWidth(), demo.getHeight());
            demo.getGraphics().fillRect(0,  0,  demo.getWidth(), demo.getHeight());
            nv.render(this.demo.getGraphics());
            for(Quai c: this.characters){
                if(c==null)break;    
                c.update(5,1);
                c.render(this.demo.getGraphics());
            }
            
            try {
                    Thread.sleep(200);
                    timeReal+=200;
                    if(countQuai<101){
                        countQuai++;
                    }
                    
            } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
        }
    }
}
