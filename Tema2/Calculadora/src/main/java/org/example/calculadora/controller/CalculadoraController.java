package org.example.calculadora.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import lombok.val;
import org.example.calculadora.model.Cuenta;

import java.net.URL;
import java.util.ResourceBundle;

public class CalculadoraController implements Initializable {
    @FXML
    private Button botonBasica , botonPotencia, botonRaiz, botonPorcentaje, botonInverso ,botonCuadrado, botonCambioSigno;

    @FXML
    private Button botonCero;

    @FXML
    private Button botonCientifica;

    @FXML
    private Button botonCinco;

    @FXML
    private Button botonCuatro;

    @FXML
    private Button botonDividir;

    @FXML
    private Button botonDos;

    @FXML
    private Button botonIgual;

    @FXML
    private Button botonMenos;

    @FXML
    private Button botonMultiplicar;

    @FXML
    private Button botonNueve;

    @FXML
    private Button botonOcho;

    @FXML
    private Button botonPunto;

    @FXML
    private ToggleButton botonRegistro;

    @FXML
    private Button botonSeis;

    @FXML
    private Button botonSiete;

    @FXML
    private Button botonSuma;

    @FXML
    private Button botonTres;

    @FXML
    private Button botonUno , botonClear;

    @FXML
    private Label labelCuentas;

    @FXML
    private FlowPane panelCientifica;

    @FXML
    private BorderPane panelPrincipal;

    @FXML
    private GridPane panelRegistro;
    @FXML
    private ListView<Cuenta> listViewCuentas;

    private ObservableList<Cuenta> listaCuentas;



    private String operacionActual = "";
    private double ultimoResultado = 0.0;
    private String operadorPendiente = null;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acciones();
        initGUI();
        instancias();
        configurarBotonesNumericosYOperadores();
        configurarBotonesCientificos();
    }

    private void acciones(){
        botonRegistro.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (t1){
                    panelPrincipal.setLeft(panelRegistro);
                }else {
                    panelPrincipal.setLeft(null);
                }
            }
        });
        botonBasica.setOnAction(new ManejoAcciones());
        botonCientifica.setOnAction(new ManejoAcciones());
        botonClear.setOnAction(new ManejoAcciones());

    }

    private void initGUI(){
        if (botonRegistro.isSelected()){
            panelPrincipal.setLeft(panelRegistro);
        }else {
            panelPrincipal.setLeft(null);
        }

        panelPrincipal.setRight(null);
    }

    private void instancias() {
        labelCuentas.setText("");
        listaCuentas = FXCollections.observableArrayList();
        listViewCuentas.setItems(listaCuentas);
    }

    private void configurarBotonesNumericosYOperadores(){
        botonCero.setOnAction(this::manejarEntrada);
        botonUno.setOnAction(this::manejarEntrada);
        botonDos.setOnAction(this::manejarEntrada);
        botonTres.setOnAction(this::manejarEntrada);
        botonCuatro.setOnAction(this::manejarEntrada);
        botonCinco.setOnAction(this::manejarEntrada);
        botonSeis.setOnAction(this::manejarEntrada);
        botonSiete.setOnAction(this::manejarEntrada);
        botonOcho.setOnAction(this::manejarEntrada);
        botonNueve.setOnAction(this::manejarEntrada);
        botonPunto.setOnAction(this::manejarEntrada);


        botonSuma.setOnAction(this::manejarOperacion);
        botonMenos.setOnAction(this::manejarOperacion);
        botonMultiplicar.setOnAction(this::manejarOperacion);
        botonDividir.setOnAction(this::manejarOperacion);


        botonIgual.setOnAction(e -> calcularResultado());
    }

    private void configurarBotonesCientificos() {
        botonCuadrado.setOnAction(e -> aplicarOperacionCientifica("cuadrado"));
        botonRaiz.setOnAction(e -> aplicarOperacionCientifica("raiz"));
        botonPotencia.setOnAction(e -> aplicarOperacionCientifica("potencia"));
        botonPorcentaje.setOnAction(e -> aplicarOperacionCientifica("porcentaje"));
        botonInverso.setOnAction(e -> aplicarOperacionCientifica("inverso"));
        botonCambioSigno.setOnAction(e -> aplicarOperacionCientifica("signo"));
    }

    private void manejarEntrada(ActionEvent e){
        Button boton = (Button) e.getSource();
        String valor = boton.getText();
        operacionActual += valor;
        labelCuentas.setText(operacionActual);
    }

    private void manejarOperacion(ActionEvent e){
        Button boton = (Button) e.getSource();
        String op = boton.getText();

        if(!operacionActual.isEmpty()){
            try {
                ultimoResultado = Double.parseDouble(operacionActual);
                operadorPendiente = op;
                operacionActual = "";
                labelCuentas.setText(ultimoResultado + " " + op);
            } catch (NumberFormatException ex){
                labelCuentas.setText("Error");
                operacionActual = "";
            }
        }
    }

    private void calcularResultado() {
        if (operadorPendiente != null && !operacionActual.isEmpty()){
            try {
                double segundoValor = Double.parseDouble(operacionActual);
                double resultado =switch (operadorPendiente) {
                    case "+" -> ultimoResultado + segundoValor;
                    case "-" -> ultimoResultado - segundoValor;
                    case "x" -> ultimoResultado * segundoValor;
                    case "/" -> (segundoValor != 0) ? ultimoResultado / segundoValor : Double.NaN;
                    case "^" -> Math.pow(ultimoResultado, segundoValor);
                    default -> 0.0;
                };

                if ((Double.isNaN(resultado))) {
                    labelCuentas.setText("Error: div/0");
                }else {
                    labelCuentas.setText(String.valueOf(resultado));
                }
                String operacionFinal = String.format("%s %s %s",formatoNumero(ultimoResultado),operadorPendiente, operacionActual);
                Cuenta cuenta = new Cuenta(operacionFinal,resultado);
                listaCuentas.add(cuenta);

                operacionActual = String.valueOf(resultado);
                operadorPendiente = null;
                ultimoResultado = resultado;

            } catch (NumberFormatException ex){
                labelCuentas.setText("Error");
            }
        }
    }

    private String formatoNumero(double v){
        if(v == (long) v) return String.format("%d", (long) v);
        return String.format("%S", v);
    }

    private void aplicarOperacionCientifica(String tipo){
        if (operacionActual.isEmpty() && labelCuentas.getText().isEmpty()) return;

        try{
            double valor = (!operacionActual.isEmpty()) ? Double.parseDouble(operacionActual)
                    : ultimoResultado;
            double resultado = 0.0;

            switch (tipo){
                case "cuadrado" -> {
                    resultado = Math.pow(valor,2);
                    String operacionFinal = String.format("%s ^ 2",formatoNumero(valor));
                    Cuenta cuenta = new Cuenta(operacionFinal,resultado);
                    listaCuentas.add(cuenta);
                }
                case "raiz" -> {
                    resultado = Math.sqrt(valor);
                    String operacionFinal = String.format("√(%s)",formatoNumero(valor));
                    Cuenta cuenta = new Cuenta(operacionFinal,resultado);
                    listaCuentas.add(cuenta);
                }
                case "potencia" -> {
                    ultimoResultado = valor;
                    operadorPendiente = "^";
                    operacionActual = "";
                    labelCuentas.setText(ultimoResultado + " ^ ");
                    return;
                }
                case "porcentaje" -> {
                    resultado = valor / 100;
                    String operacionFinal = String.format("%s%%", formatoNumero(valor));
                    listaCuentas.add(new Cuenta(operacionFinal, resultado));
                }
                case "inverso" -> {
                    resultado = 1 / valor;
                    String operacionFinal = String.format("1 / %s", formatoNumero(valor));
                    listaCuentas.add(new Cuenta(operacionFinal, resultado));
                }
                case "signo" -> {
                    resultado = -valor;
                    String operacionFinal = String.format("-(%s)", formatoNumero(valor));
                    listaCuentas.add(new Cuenta(operacionFinal, resultado));
                }
            }

            labelCuentas.setText(String.valueOf(resultado));
            operacionActual = String.valueOf(resultado);
            ultimoResultado = resultado;
        } catch (NumberFormatException ex){
            labelCuentas.setText("Error");
        }
    }
    class ManejoAcciones implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == botonBasica){
                panelPrincipal.setRight(null);
            } else if (actionEvent.getSource() == botonCientifica) {
                panelPrincipal.setRight(panelCientifica);
            } else if (actionEvent.getSource() == botonClear) {
                operacionActual = "";
                operadorPendiente = null;
                ultimoResultado = 0.0;
                labelCuentas.setText("");
            }
        }
    }


}
