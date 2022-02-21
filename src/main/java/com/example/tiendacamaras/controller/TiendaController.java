package com.example.tiendacamaras.controller;

import com.example.tiendacamaras.fachada.Tienda;
import com.example.tiendacamaras.model.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class TiendaController implements Initializable {
    @FXML
    private TextField nombreCliente;

    @FXML
    private ComboBox<String> tipoDocumentoCliente;

    @FXML
    private TextField numeroDocumentoCliente;

    @FXML
    private TextArea listaCliente;

    private Tienda tienda;

    ObservableList<String> comboDIContent=
            FXCollections.observableArrayList(
                    "C.C",
                    "C.E",
                    "T.I",
                    "PASAPORTE"
            );

    public void initialize(URL location, ResourceBundle resources) {
        tienda=new Tienda(2,2);
        tipoDocumentoCliente.setItems(comboDIContent);
    }


    public void registrarCliente() {
        Cliente cliente=new Cliente(nombreCliente.getText(),tipoDocumentoCliente.getValue(),numeroDocumentoCliente.getText());
        tienda.asignarClientes(cliente);
    }

    public void listarCliente(){
        listaCliente.setText(tienda.listarClientes());
    }
}