package model;

import java.awt.Color;
import java.awt.Graphics;
import movement.KinematicOutput;
import movement.Vector2D;

public class Charater {
    protected Vector2D position;
    protected double orientation;
    protected Vector2D velocity;
    protected double rotation;
    protected Color color;

    // Getter
    // Setter
    public Vector2D getPosition() {
            return position;
    }

    public void setPosition(Vector2D position) {
            this.position = position;
    }

    public double getOrientation() {
            return orientation;
    }

    public void setOrientation(double orientation) {
            this.orientation = orientation;
    }

    public Vector2D getVelocity() {
            return velocity;
    }

    public void setVelocity(Vector2D velocity) {
            this.velocity = velocity;
    }

    public double getRotation() {
            return rotation;
    }

    public void setRotation(double rotation) {
            this.rotation = rotation;
    }

    public Charater() {
        super();
    }

    public Charater(Vector2D position, double orientation, Vector2D velocity, double rotation, Color c) {
            super();
            this.position = position;
            this.orientation = orientation;
            this.velocity = velocity;
            this.rotation = rotation;
            this.color = c;
    }

    @Override
    public String toString() {
            return "Charater [position=" + position + ", orientation=" + orientation + ", velocity=" + velocity
                            + ", rotation=" + rotation + "]";
    }

    public void update(KinematicOutput KinematicOutput, double time){
            this.velocity = KinematicOutput.getVelocity();
            this.rotation = KinematicOutput.getRotation();
            this.position.addVector2D(Vector2D.mulConstant(this.velocity, time));
            this.orientation += this.rotation*time;
    }


    public void applyNewOrientation(){
            if (this.velocity.getLength()>0){
                    this.orientation = Math.atan2(-this.velocity.getX(), this.velocity.getZ());
            }
    }

    public void render(Graphics g) {
        g.setColor(this.color);
        int x=(int)this.position.getX()-25;
        int y = (int)this.position.getZ()-25;
        g.drawOval(x, y, 50, 50);
        g.drawLine(x + 25, 
                y + 25, 
                x + 25 +  (int) ( 25*Math.sin(this.orientation)),
                y + 25 +  (int) ( 25*Math.cos(this.orientation)));     
    }
}	
