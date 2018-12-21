/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import movement.GameLoop;
import movement.KinematicFlee;
import movement.KinematicOutput;
import movement.KinematicSeek;
import movement.Vector2D;
/**
 *
 * @author IU
 */
public class Quai extends Charater{
    private int timeexist;
    private int timeupdate;
    private KinematicOutput output;
    public Quai(Vector2D position, double orientation, Vector2D velocity, double rotation, Color c, int timeexist){
        super(position, orientation, velocity, rotation, c);
        this.timeexist = timeexist;
        this.timeupdate = 0;
    }
    
    public void setTimeUdate(int time){
        this.timeupdate = time;
    }
    
    public void update(double time,int timeupdate){
        Random rd = new Random();
        this.color = new Color(rd.nextInt(255), rd.nextInt(255), rd.nextInt(255));
        this.timeupdate += timeupdate;
        if(this.timeupdate<(timeexist/2)+1){
            KinematicFlee flee = new KinematicFlee(this, GameLoop.nv, 2);
            output =flee.generateKinematicOutput();
        }else if(this.timeupdate<timeexist){
            KinematicSeek seek = new KinematicSeek(this, GameLoop.nv, 2);
            output = seek.generateKinematicOutput();
        }else{
            this.timeupdate=0;
        }
        this.update(output, time);
    }
    
    public void detroy(){
        GameLoop.characters.remove(this);
    }    
    @Override
    public void render(Graphics g) {
        g.setColor(this.color);
        int x=(int)this.position.getX()-25;
        int y = (int)this.position.getZ()-25;
        g.drawOval(x, y, 20, 20);
        g.drawLine(x + 10, 
                y + 10, 
                x + 10 +  (int) ( 10*Math.sin(this.orientation)),
                y + 10 +  (int) ( 10*Math.cos(this.orientation)));       
    }
}
