import java.util.List;
// Comentario
// Comentario2
// Comentario3
public class Hotel {
    private int id; // Identificador único del hotel
    private String nombre; // Nombre del hotel
    private String dirección; // Dirección del hotel
    private List<Habitación> habitaciones; // Lista de habitaciones del hotel

    public Hotel(int id, String nombre, String dirección, List<Habitación> habitaciones) {
        this.id = id;
        this.nombre = nombre;
        this.dirección = dirección;
        this.habitaciones = habitaciones;
    }

    // Getter y Setter para el id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter y Setter para el nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter y Setter para la dirección
    public String getDirección() {
        return dirección;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }

    // Getter y Setter para la lista de habitaciones
    public List<Habitación> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(List<Habitación> habitaciones) {
        this.habitaciones = habitaciones;
    }

    // Otros métodos de la clase Hotel

    @Override
    public String toString() {
        return "Hotel [id=" + id + ", nombre=" + nombre + ", dirección=" + dirección + "]";
    }
}