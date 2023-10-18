package enums;

public enum Dinosaur {
	APATOSAURUS(6,4,2,1),
	TYRANNOSAURUS_REX(6,4,9,9),
	VELOCIRAPTOR(1,9,10,9),
	TRICERATOPS(4,6,4,2),
	IGUANODON(5,5,6,3),
	STEGOSAURUS(4,3,3,2),
	PTERODACTYL(1,10,6,4),
	PLESIOSAUR(3,2,8,1);
		
	private final int size;
	private final int speed;
	private final int intelligence;
	private final int killerInstinct;
	
	Dinosaur(int size, int speed, int intelligence, int killerInstinct) {
		this.size = size;
		this.speed = speed;
		this.intelligence = intelligence;
		this.killerInstinct = killerInstinct;
	}
	
	public int size() {
		return this.size;
	}
	
	public int speed() {
		return this.speed;
	}
	
	public int intelligence() {
		return this.intelligence;
	}
	
	public int killerInstinct() {
		return this.killerInstinct;
	}
	
	public static Dinosaur compareCards(Attribute category, Dinosaur ... dinosaurs) {
		Dinosaur result = dinosaurs[0];
		switch(category) {
		case SIZE:
			for(Dinosaur d: dinosaurs) {
				if(d.size() > result.size())
					result = d;
			}
			return result;
		case SPEED:
			for(Dinosaur d: dinosaurs) {
				if(d.speed() > result.speed())
					result = d;
			}
			return result;
		case INTELLIGENCE:
			for(Dinosaur d: dinosaurs) {
				if(d.intelligence() > result.intelligence())
					result = d;
			}
			return result;
		case KILLERINSTINCT:
			for(Dinosaur d: dinosaurs) {
				if(d.killerInstinct() > result.killerInstinct())
					result = d;
			}
			return result;
		default:
			return dinosaurs[0];
		}
		
	}
	
	enum Attribute {
		SIZE, SPEED, INTELLIGENCE, KILLERINSTINCT;
	}
	
	public static void main(String [] args) {
		System.out.println(Dinosaur.compareCards(Dinosaur.Attribute.SPEED, PLESIOSAUR, STEGOSAURUS, TYRANNOSAURUS_REX, VELOCIRAPTOR));
	}
	
}
