public class Host {
	protected String id, name, since, location, about, responseTime;
	// responseRate is the percentage of times that queries receive a response
	// acceptanceRate is the percentage of times that a request for an open lodging
	// is accepted.
	protected double responseRate, acceptanceRate;
	protected boolean isSuperHost;

	Host(String id, String name, String since, String location, String about, String responseTime, double responseRate,
			double acceptanceRate, boolean isSuperHost) {
		this.id = id;
		this.name = name;
		this.since = since;
		this.location = location;
		this.about = about;
		this.responseTime = responseTime;
		this.responseRate = responseRate;
		this.acceptanceRate = acceptanceRate;
		this.isSuperHost = isSuperHost;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSince() {
		return since;
	}

	public String getLocation() {
		return location;
	}

	public String getAbout() {
		return about;
	}

	public String getResponseTime() {
		return responseTime;
	}

	public double getResponseRate() {
		return responseRate;
	}

	public double getAcceptanceRate() {
		return acceptanceRate;
	}

	public boolean isSuperHost() {
		return isSuperHost;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSince(String since) {
		this.since = since;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public void setResponseTime(String responseTime) {
		this.responseTime = responseTime;
	}

	public void setResponseRate(double responseRate) {
		this.responseRate = responseRate;
	}

	public void setAcceptanceRate(double acceptanceRate) {
		this.acceptanceRate = acceptanceRate;
	}

	public void setIsSuperHost(boolean isSuperHost) {
		this.isSuperHost = isSuperHost;
	}

	@Override
	public String toString() {
		return id + " " + name;
	}

}
