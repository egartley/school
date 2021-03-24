/*  Evan Gartley
    CS 210
    3/21/2021
    Lab 8
    DeliveryInfo.java
*/

/**
 * Information about a delivery
 */
public class DeliveryInfo {

    /**
     * The ZIP code of the delivery
     */
    private String zip;
    /**
     * The address of the delivery
     */
    private String address;
    /**
     * Specific instructions for delivery
     */
    private String instructions;

    /**
     * The order associated with the delivery
     */
    private Order order;

    /**
     * Creates a new delivery with the provided information
     *
     * @param zip
     * @param address
     * @param instructions
     */
    public DeliveryInfo(String zip, String address, String instructions) {
        this.zip = zip;
        this.address = address;
        this.instructions = instructions;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

}
