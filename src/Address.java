public class Address {
    private String streetname;
    private String town;
    private String city;
    private String country;

    public Address(String streetname, String town, String city,String country) {
        this.streetname = streetname;
        this.town = town;
        this.city = city;
        this.country = country;
    }

    public String getStreetname() {
        return streetname;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

	@Override
	public String toString() {
		return  streetname + "/" + town + "/" + city + "/" + country;
	}
    
}