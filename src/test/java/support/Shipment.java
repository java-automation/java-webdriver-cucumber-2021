package support;

import java.util.List;

public class Shipment {

    private String weight;
    private String type;
    private String description;
    private List<ShipmentEndpoint> shipmentEndpoints;

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ShipmentEndpoint> getShipmentEndpoints() {
        return shipmentEndpoints;
    }

    public void setShipmentEndpoints(List<ShipmentEndpoint> shipmentEndpoints) {
        this.shipmentEndpoints = shipmentEndpoints;
    }
}
