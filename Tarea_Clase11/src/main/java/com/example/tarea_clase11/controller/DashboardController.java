package com.example.tarea_clase11.controller;

import com.example.tarea_clase11.dao.ProductoDAO;
import com.example.tarea_clase11.model.Producto;
import com.example.tarea_clase11.util.Sesion;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class DashboardController {

    @FXML
    private Label lblUsuario;

    @FXML
    private Label lblRol;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtNombre;

    @FXML
    private ComboBox<String> cbCategoria;

    @FXML
    private TextField txtPrecio;

    @FXML
    private TextField txtStock;

    @FXML
    private ComboBox<String> cbEstado;

    @FXML
    private TextField txtBuscar;

    @FXML
    private TableView<Producto> tablaProductos;

    @FXML
    private TableColumn<Producto,String> colCodigo;

    @FXML
    private TableColumn<Producto,String> colNombre;

    @FXML
    private TableColumn<Producto,String> colCategoria;

    @FXML
    private TableColumn<Producto,Double> colPrecio;

    @FXML
    private TableColumn<Producto,Integer> colStock;

    @FXML
    private TableColumn<Producto,String> colEstado;

    private final ProductoDAO dao =
            new ProductoDAO();

    private Producto productoSeleccionado;

    @FXML
    public void initialize() {

        lblUsuario.setText(
                Sesion.getUsuarioActual()
                        .getUsuario());

        lblRol.setText(
                Sesion.getUsuarioActual()
                        .getRol());

        cbCategoria.getItems().addAll(
                "Calzado",
                "Ropa",
                "Accesorios",
                "Electrónica"
        );

        cbEstado.getItems().addAll(
                "Activo",
                "Inactivo"
        );

        colCodigo.setCellValueFactory(
                dato -> dato.getValue().codigoProperty());

        colNombre.setCellValueFactory(
                dato -> dato.getValue().nombreProperty());

        colCategoria.setCellValueFactory(
                dato -> dato.getValue().categoriaProperty());

        colPrecio.setCellValueFactory(
                dato -> dato.getValue()
                        .precioProperty()
                        .asObject());

        colStock.setCellValueFactory(
                dato -> dato.getValue()
                        .stockProperty()
                        .asObject());

        colEstado.setCellValueFactory(
                dato -> dato.getValue()
                        .estadoProperty());

        tablaProductos.setItems(
                dao.obtenerProductos());

        tablaProductos
                .getSelectionModel()
                .selectedItemProperty()
                .addListener(
                        (obs, oldValue, newValue) -> {

                            if(newValue != null){

                                productoSeleccionado =
                                        newValue;

                                cargarFormulario(
                                        newValue);
                            }
                        });
    }

    private void cargarFormulario(
            Producto producto){

        txtCodigo.setText(
                producto.getCodigo());

        txtNombre.setText(
                producto.getNombre());

        cbCategoria.setValue(
                producto.getCategoria());

        txtPrecio.setText(
                String.valueOf(
                        producto.getPrecio()));

        txtStock.setText(
                String.valueOf(
                        producto.getStock()));

        cbEstado.setValue(
                producto.getEstado());
    }

    @FXML
    private void nuevo(){

        limpiar();
    }

    @FXML
    private void guardar(){

        try{

            Producto producto =
                    new Producto(
                            txtCodigo.getText(),
                            txtNombre.getText(),
                            cbCategoria.getValue(),
                            Double.parseDouble(
                                    txtPrecio.getText()),
                            Integer.parseInt(
                                    txtStock.getText()),
                            cbEstado.getValue());

            dao.guardar(producto);

            limpiar();

        }catch(Exception e){

            mensaje(
                    Alert.AlertType.ERROR,
                    "Datos inválidos");
        }
    }

    @FXML
    private void actualizar(){

        if(productoSeleccionado == null){

            mensaje(
                    Alert.AlertType.WARNING,
                    "Seleccione un producto");

            return;
        }

        productoSeleccionado.setCodigo(
                txtCodigo.getText());

        productoSeleccionado.setNombre(
                txtNombre.getText());

        productoSeleccionado.setCategoria(
                cbCategoria.getValue());

        productoSeleccionado.setPrecio(
                Double.parseDouble(
                        txtPrecio.getText()));

        productoSeleccionado.setStock(
                Integer.parseInt(
                        txtStock.getText()));

        productoSeleccionado.setEstado(
                cbEstado.getValue());

        tablaProductos.refresh();

        mensaje(
                Alert.AlertType.INFORMATION,
                "Producto actualizado");
    }

    @FXML
    private void eliminar(){

        if(productoSeleccionado == null){

            mensaje(
                    Alert.AlertType.WARNING,
                    "Seleccione un producto");

            return;
        }

        dao.eliminar(
                productoSeleccionado);

        limpiar();

        productoSeleccionado = null;
    }

    @FXML
    private void limpiar(){

        txtCodigo.clear();
        txtNombre.clear();
        txtPrecio.clear();
        txtStock.clear();
        txtBuscar.clear();

        cbCategoria.setValue(null);
        cbEstado.setValue(null);

        tablaProductos
                .getSelectionModel()
                .clearSelection();
    }

    private void mensaje(
            Alert.AlertType tipo,
            String texto){

        Alert alert =
                new Alert(tipo);

        alert.setHeaderText(null);
        alert.setContentText(texto);
        alert.showAndWait();
    }
}