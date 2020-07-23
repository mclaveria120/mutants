package mutants.detector;

public enum NitrogenousBaseType {

	DNA("ATCG");
	
	private final String name;
	
	private NitrogenousBaseType(String name){
		this.name=name;
	}

	public String getName() {
		return name;
	}
}
