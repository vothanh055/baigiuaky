package movement;
import model.Charater;

public class KinematicFlee {
	private Charater character;	
	private Charater target;	
	private double maxSpeed;	
	
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
	
	public double getMaxSpeed() {
		return maxSpeed;
	}
	
	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public KinematicFlee() {
		super();
	}

	public KinematicFlee(Charater character, Charater target, double maxSpeed) {
		this.character = character;
		this.target = target;
		this.maxSpeed = maxSpeed;
	}

	@Override
	public String toString() {
		return "KinematicSeek [character=" + character + ", target=" + target + ", maxSpeed=" + maxSpeed + "]";
	}

	public KinematicOutput generateKinematicOutput(){
            Vector2D velocity = new Vector2D();
            //velocity = this.target.getPosition().subVector2D(this.character.getPosition());
            velocity = Vector2D.subVector2D(this.character.getPosition(), this.target.getPosition());
            velocity.normalize();
            velocity.mulConstant(this.maxSpeed);         
            return new KinematicOutput(velocity, 0);
	}
	
	public static void main(String[] args) {
		/*Character charater = new Character();
		charater.setPosition(new Vector2D(2, 1));
		
		Character target = new Character();
		target.setPosition(new Vector2D(9, 1));
		
		KinematicFlee kinematicSeek = new KinematicFlee(charater, target, 3);
		KinematicOutput kinematicOutputFlee = kinematicSeek.generateKinematicOutput();
		
		charater.update(kinematicOutputFlee, 2);
		charater.applyNewOrientation();
		
		System.out.println(charater.getPosition());
		System.out.println(charater.getOrientation());*/
	}
}
