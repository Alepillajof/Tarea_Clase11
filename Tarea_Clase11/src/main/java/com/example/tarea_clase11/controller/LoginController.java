package com.example.tarea_clase11.controller;

import com.example.tarea_clase11.model.Usuario;
import com.example.tarea_clase11.util.Sesion;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private ComboBox<String> cbRol;

    @FXML
    public void initialize() {

        cbRol.getItems().addAll(
                "Administrador",
                "Vendedor",
                "Cajero"
        );
    }

    @FXML
    private void ingresar() {

        String usuario = txtUsuario.getText();
        String password = txtPassword.getText();
        String rol = cbRol.getValue();

        if(usuario.isEmpty() ||
                password.isEmpty() ||
                rol == null){

            mostrarMensaje(
                    Alert.AlertType.WARNING,
                    "Complete todos los campos");

            return;
        }

        if(usuario.equals("admin")
                && password.equals("1234")){

            Usuario user =
                    new Usuario(
                            usuario,
                            password,
                            rol);

            Sesion.setUsuarioActual(user);

            abrirDashboard();

        }else{

            mostrarMensaje(
                    Alert.AlertType.ERROR,
                    "Credenciales incorrectas");
        }
    }

    private void abrirDashboard(){

        try{

            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource(
                                    "/com/example/tarea_clase11/dashboard.fxml"));

            Stage stage =
                    (Stage) txtUsuario
                            .getScene()
                            .getWindow();

            Scene scene =
                    new Scene(loader.load());

            stage.setScene(scene);
            stage.centerOnScreen();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void mostrarMensaje(
            Alert.AlertType tipo,
            String mensaje){

        Alert alert =
                new Alert(tipo);

        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}