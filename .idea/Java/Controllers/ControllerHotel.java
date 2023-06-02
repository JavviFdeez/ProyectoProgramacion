import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
// Comentario
// Comentario2
public class HotelController {
    @FXML
    private TextField idField;

    @FXML
    private TextField nombreField;

    @FXML
    private TextField direcciónField;

    @FXML
    private Button guardarButton;

    // Instancia del DAO de Hotel
    private HotelDAO hotelDAO;

    // Método de inicialización del controlador
    public void initialize() {
        // Crear una instancia del DAO de Hotel
        ConexiónBD conexiónBD = new ConexiónBDImpl();
        hotelDAO = new HotelDAOImpl(conexiónBD);
    }

    // Método de acción para el botón "Guardar"
    @FXML
    private void guardarHotel() {
        int id = Integer.parseInt(idField.getText());
        String nombre = nombreField.getText();
        String dirección = direcciónField.getText();

        // Crear una instancia de Hotel
        Hotel hotel = new Hotel(id, nombre, dirección);

        // Guardar el hotel en la base de datos
        hotelDAO.guardarHotel(hotel);

        // Mostrar un mensaje de éxito
        mostrarMensaje("Hotel guardado correctamente.");

        // Limpiar los campos de entrada
        limpiarCampos();
    }

    // Método para mostrar un mensaje de alerta
    private void mostrarMensaje(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Información");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    // Método para limpiar los campos de entrada
    private void limpiarCampos() {
        idField.clear();
        nombreField.clear();
        direcciónField.clear();
    }
}