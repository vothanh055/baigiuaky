/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.awt.Color;
import java.awt.Graphics;
import movement.Vector2D;
/**
 *
 * @author IU
 */
public class Nhanvat extends Charater{
    public Nhanvat(){
        super();
    }
    public Nhanvat(Vector2D position, double orientation, Vector2D velocity, double rotation, Color c){
        super(position, orientation, velocity, rotation, c);
    }
    
    private double randomBinomial() {
        return Math.random() - Math.random();       
    }
    
    public void update(double time){
        this.rotation = randomBinomial()*2;
        this.orientation += this.rotation*time;
    }
    
    @Override
    public void render(Graphics g) {
        g.setColor(Color.blue);
        int x=(int)this.position.getX()-45;
        int y = (int)this.position.getZ()-45;
        g.fillOval(x
                , y
                , 60, 60);
        g.setColor(Color.yellow);
        g.drawLine(x + 30, 
                    y + 30, 
                    x + 30 +  (int) ( 30*Math.sin(this.orientation)),
                    y + 30 +  (int) ( 30*Math.cos(this.orientation)));
     }
}
