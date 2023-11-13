public class Country {
	private String name;

    public Country(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public boolean equals(Object randomObject){
        boolean isEqual = false;
        if(randomObject instanceof Country){
            Country otherCountry = (Country) randomObject;
            if(name.equals(otherCountry.getName())){
                isEqual = true;
            }
        } 
        return isEqual;
    }
}