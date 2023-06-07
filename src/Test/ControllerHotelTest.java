import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

public class HotelControllerTest extends ApplicationTest {
    private HotelController hotelController;
    private TextField idField;
    private TextField nombreField;
    private TextField direcciónField;
    private Button guardarButton;
    private HotelDAO hotelDAO;
    private Alert lastAlert;

    @Before
    public void setUp() {
        hotelController = new HotelController();
        idField = new TextField();
        nombreField = new TextField();
        direcciónField = new TextField();
        guardarButton = new Button();
        hotelDAO = new HotelDAOImpl(null);
        hotelController.idField = idField;
        hotelController.nombreField = nombreField;
        hotelController.direcciónField = direcciónField;
        hotelController.guardarButton = guardarButton;
        hotelController.hotelDAO = hotelDAO;

        lastAlert = null;
        Alert.AlertType lastAlertType = null;

        // Mock de la función showAndWait() del Alert
        hotelController.setMostrarAlertCallback((alert, alertType) -> {
            lastAlert = alert;
            lastAlertType = alertType;
        });
    }

    @Test
    public void guardarHotel_CamposVacios_MuestraMensajeDeError() {
        idField.setText("");
        nombreField.setText("");
        direcciónField.setText("");

        guardarButton.fire();

        Assert.assertNotNull(lastAlert);
        Assert.assertEquals(Alert.AlertType.ERROR, lastAlertType);
        Assert.assertEquals("Error", lastAlert.getTitle());
        Assert.assertEquals("Todos los campos deben estar llenos.", lastAlert.getContentText());
    }

    @Test
    public void guardarHotel_CamposLlenos_GuardaHotelEnBD() {
        idField.setText("1");
        nombreField.setText("Hotel ABC");
        direcciónField.setText("123 Main St");

        guardarButton.fire();

        Hotel hotelGuardado = hotelDAO.getHotelById(1);
        Assert.assertNotNull(hotelGuardado);
        Assert.assertEquals(1, hotelGuardado.getId());
        Assert.assertEquals("Hotel ABC", hotelGuardado.getNombre());
        Assert.assertEquals("123 Main St", hotelGuardado.getDirección());
    }

    @Test
    public void guardarHotel_CamposLlenos_MuestraMensajeDeÉxito() {
        idField.setText("1");
        nombreField.setText("Hotel ABC");
        direcciónField.setText("123 Main St");

        guardarButton.fire();

        Assert.assertNotNull(lastAlert);
        Assert.assertEquals(Alert.AlertType.INFORMATION, lastAlertType);
        Assert.assertEquals("Información", lastAlert.getTitle());
        Assert.assertEquals("Hotel guardado correctamente.", lastAlert.getContentText());
    }

    @Test
    public void guardarHotel_CamposLlenos_LimpiaCamposDeEntrada() {
        idField.setText("1");
        nombreField.setText("Hotel ABC");
        direcciónField.setText("123 Main St");

        guardarButton.fire();

        Assert.assertEquals("", idField.getText());
        Assert.assertEquals("", nombreField.getText());
        Assert.assertEquals("", direcciónField.getText());
    }

    @Test
    public void mostrarMensaje_MensajePersonalizado_MuestraAlertaConMensajeCorrecto() {
        String mensaje = "Este es un mensaje personalizado.";

        hotelController.mostrarMensaje(mensaje);

        Assert.assertNotNull(lastAlert);
        Assert.assertEquals(Alert.AlertType.INFORMATION, lastAlertType);
        Assert.assertEquals("Información", lastAlert.getTitle());
        Assert.assertEquals(mensaje, lastAlert.getContentText());
    }

    @Test
    public void limpiarCampos_LimpiarCamposDeEntrada_LimpaLosCampos() {
        idField.setText("1");
        nombreField.setText("Hotel ABC");
        direcciónField.setText("123 Main St");

        hotelController.limpiarCampos();

        Assert.assertEquals("", idField.getText());
        Assert.assertEquals("", nombreField.getText());
        Assert.assertEquals("", direcciónField.getText());
    }

    @Test
    public void mostrarAdvertencia_MensajePersonalizado_MuestraAlertaDeAdvertenciaConMensajeCorrecto() {
        String mensaje = "Este es un mensaje de advertencia.";

        hotelController.mostrarAdvertencia(mensaje);

        Assert.assertNotNull(lastAlert);
        Assert.assertEquals(Alert.AlertType.WARNING, lastAlertType);
        Assert.assertEquals("Advertencia", lastAlert.getTitle());
        Assert.assertEquals(mensaje, lastAlert.getContentText());
    }
}
