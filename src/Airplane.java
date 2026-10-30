public class Airplane {
    private int idAirplane;
    private String model;
    private int capacity;
    private String status;

    public Airplane(int idAirplane, String model, int capacity, String status) {
        this.idAirplane = idAirplane;
        this.model = model;
        this.capacity = capacity;
        this.status = status;
    }

    public int getIdAirplane() { return idAirplane; }
    public String getModel() { return model; }
    public int getCapacity() { return capacity; }
    public String getStatus() { return status; }
}