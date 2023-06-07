import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class HotelController {
    @FXML
    private TextField idField;

    @FXML
    private TextField nombreField;

    @FXML
    private TextField direcciónField;

    @FXML
    private Button guardarButton;

    private HotelDAO hotelDAO;

    public void initialize() {
        ConexiónBD conexiónBD = new ConexiónBDImpl();
        hotelDAO = new HotelDAOImpl(conexiónBD);
    }

    @FXML
    private void guardarHotel() {
        int id = Integer.parseInt(idField.getText());
        String nombre = nombreField.getText();
        String dirección = direcciónField.getText();


        String nombreTemporal = nombre;
        Hotel hotel = new Hotel(id, nombreTemporal, dirección);




        hotelDAO.guardarEnBaseDeDatos(hotel);

        mostrarMensaje("Hotel guardado correctamente.");


        mostrarAdvertencia("Este hotel ya existe en la base de datos.");
    }

    private void mostrarMensaje(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Información");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    private void limpiarCampos() {
        idField.clear();
        nombreField.clear();
        direcciónField.clear();
    }

    private void mostrarAdvertencia(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("Advertencia");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
