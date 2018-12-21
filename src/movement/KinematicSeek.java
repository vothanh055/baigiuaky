/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movement;
import model.Charater;
/**
 *
 * @author User
 */
public class KinematicSeek {
    
    Charater character;
    Charater target;
    float maxSpeed;

    public KinematicSeek() {
    }

    public KinematicSeek(Charater character, Charater target, float maxSpeed) {
        this.character = character;
        this.target = target;
        this.maxSpeed = maxSpeed;
    }

    public Charater getCharacter() {
        return character;
    }

    public void setCharacter(Charater character) {
        this.character = character;
    }

    public Charater getTarget() {
        return target;
    }

    public void setTarget(Charater target) {
        this.target = target;
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
    
    public KinematicOutput generateKinematicOutput(){
        Vector2D velocity = new Vector2D();
        //velocity = target.getPosition().subVector2D(character.getPosition());
        velocity = Vector2D.subVector2D(this.target.getPosition(), this.character.getPosition());
        velocity.normalize();
        velocity.mulConstant(maxSpeed);
        
        return new KinematicOutput(velocity, 0);
    }
    
    public static void main(String[] args) {
        /*int i= 9;
        int j = 1;
        Character character = new Character();
        Character target = new Character();
        character.setPosition(new Vector2D(2, 1));  
        while(true){
            target.setPosition(new Vector2D(i, j));
            
            i+=i;

            KinematicSeek kinematicSeek = new KinematicSeek(character, target, 1);
            KinematicOutput kinematicOutput = kinematicSeek.generateKinematicOutput();
            character.update(kinematicOutput, 1);
            character.applyNewOrientation();

            System.out.println(character.getPosition());
            System.out.println(character.getOrientation());
            //break;
        }*/
    }
}
