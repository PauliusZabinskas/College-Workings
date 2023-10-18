

public class County {
	
	private String name;
	private int size;
	private int population;
	private int density;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public int getDensity() {
		return density;
	}

	public void setDensity(int density) {
		this.density = density;
	}

	public County(String name, int size, int population, int density) {
		this.name = name;
		this.size = size;
		this.population = population;
		this.density = density;
	}
	
	public String toString() {
		return String.format("%s%nPopulation: %d%nDensity:%d%nSize: %d%n", this.name, population, density, size);
	}
}
