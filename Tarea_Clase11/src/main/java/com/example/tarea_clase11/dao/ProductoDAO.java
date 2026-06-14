package com.example.tarea_clase11.dao;

import com.example.tarea_clase11.model.Producto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProductoDAO {

    private final ObservableList<Producto> lista =
            FXCollections.observableArrayList();

    public ProductoDAO() {

        lista.add(
                new Producto(
                        "P001",
                        "Zapato Deportivo",
                        "Calzado",
                        35,
                        20,
                        "Activo"));

        lista.add(
                new Producto(
                        "P002",
                        "Camisa Manga Larga",
                        "Ropa",
                        25,
                        15,
                        "Activo"));

        lista.add(
                new Producto(
                        "P003",
                        "Jean Clásico",
                        "Ropa",
                        40,
                        10,
                        "Activo"));
    }

    public ObservableList<Producto> obtenerProductos() {
        return lista;
    }

    public void guardar(Producto producto) {
        lista.add(producto);
    }

    public void eliminar(Producto producto) {
        lista.remove(producto);
    }
}