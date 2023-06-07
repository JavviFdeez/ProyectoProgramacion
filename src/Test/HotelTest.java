import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HotelTest {
    private Hotel hotel;

    @Before
    public void setUp() {
        List<Habitación> habitaciones = new ArrayList<>();
        habitaciones.add(new Habitación(101, "Individual"));
        habitaciones.add(new Habitación(102, "Doble"));
        hotel = new Hotel(1, "Hotel ABC", "123 Main St", habitaciones);
    }

    @Test
    public void getId_ValorInicial_RetornaIdCorrecto() {
        int id = hotel.getId();
        Assert.assertEquals(1, id);
    }

    @Test
    public void setId_NuevoId_CambiaIdCorrectamente() {
        hotel.setId(2);
        int id = hotel.getId();
        Assert.assertEquals(2, id);
    }

    @Test
    public void getNombre_ValorInicial_RetornaNombreCorrecto() {
        String nombre = hotel.getNombre();
        Assert.assertEquals("Hotel ABC", nombre);
    }

    @Test
    public void setNombre_NuevoNombre_CambiaNombreCorrectamente() {
        hotel.setNombre("Nuevo Hotel");
        String nombre = hotel.getNombre();
        Assert.assertEquals("Nuevo Hotel", nombre);
    }

    @Test
    public void getDirección_ValorInicial_RetornaDirecciónCorrecta() {
        String dirección = hotel.getDirección();
        Assert.assertEquals("123 Main St", dirección);
    }

    @Test
    public void setDirección_NuevaDirección_CambiaDirecciónCorrectamente() {
        hotel.setDirección("456 Elm St");
        String dirección = hotel.getDirección();
        Assert.assertEquals("456 Elm St", dirección);
    }

    @Test
    public void getHabitaciones_ValorInicial_RetornaListaHabitacionesCorrecta() {
        List<Habitación> habitaciones = hotel.getHabitaciones();
        Assert.assertEquals(2, habitaciones.size());
        Assert.assertEquals(101, habitaciones.get(0).getNúmero());
        Assert.assertEquals("Individual", habitaciones.get(0).getTipo());
        Assert.assertEquals(102, habitaciones.get(1).getNúmero());
        Assert.assertEquals("Doble", habitaciones.get(1).getTipo());
    }

    @Test
    public void setHabitaciones_NuevaListaHabitaciones_CambiaHabitacionesCorrectamente() {
        List<Habitación> nuevasHabitaciones = new ArrayList<>();
        nuevasHabitaciones.add(new Habitación(201, "Suite"));
        nuevasHabitaciones.add(new Habitación(202, "Familiar"));

        hotel.setHabitaciones(nuevasHabitaciones);
        List<Habitación> habitaciones = hotel.getHabitaciones();
        Assert.assertEquals(2, habitaciones.size());
        Assert.assertEquals(201, habitaciones.get(0).getNúmero());
        Assert.assertEquals("Suite", habitaciones.get(0).getTipo());
        Assert.assertEquals(202, habitaciones.get(1).getNúmero());
        Assert.assertEquals("Familiar", habitaciones.get(1).getTipo());
    }

    @Test
    public void toString_ValoresIniciales_RetornaCadenaCorrecta() {
        String cadenaEsperada = "Hotel [id=1, nombre=Hotel ABC, dirección=123 Main St]";
        String cadenaObtenida = hotel.toString();
        Assert.assertEquals(cadenaEsperada, cadenaObtenida);
    }
}
