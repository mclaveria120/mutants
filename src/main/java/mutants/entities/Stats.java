package mutants.entities;

public class Stats {

	private int numberOfMutants;
	private int numberOfHumans;
	
	public Stats(int numberOfMutants, int numberOfHumans) {
		this.numberOfMutants = numberOfMutants;
		this.numberOfHumans = numberOfHumans;
	}
	public Stats(){
	}
	
	public int getNumberOfMutants() {
		return numberOfMutants;
	}
	public void setNumberOfMutants(int numberOfMutants) {
		this.numberOfMutants = numberOfMutants;
	}
	public int getNumberOfHumans() {
		return numberOfHumans;
	}
	public void setNumberOfHumans(int numberOfHumans) {
		this.numberOfHumans = numberOfHumans;
	}
	
	
	
}
