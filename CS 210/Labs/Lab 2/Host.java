package lab2;

public class Host {

    private int id;
    private String name;
    private String startDate;
    private String Location;
    private String description;
    private String responseTime;
    private double responseRate;
    private double acceptanceRate;
    private boolean superHost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }

    public double getResponseRate() {
        return responseRate;
    }

    public void setResponseRate(double responseRate) {
        this.responseRate = responseRate;
    }

    public double getAcceptanceRate() {
        return acceptanceRate;
    }

    public void setAcceptanceRate(double acceptanceRate) {
        this.acceptanceRate = acceptanceRate;
    }

    public boolean isSuperHost() {
        return superHost;
    }

    public void setSuperHost(boolean superHost) {
        this.superHost = superHost;
    }

}
