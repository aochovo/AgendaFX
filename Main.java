/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg001proyectohilos;


import java.util.ArrayList;
import javafx.application.Application;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
public class Main extends Application{
Label lbl_nombre, lbl_apellido, lbl_telefono;
TextField tf_nombre, tf_apellido, tf_telefono;
Button btn_enviar,btn_ventana;
String ruta="C:\\proyectosjava\\agendaContactos\\contactos.csv";
   public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		lbl_nombre=new Label("Nombre: ");
                lbl_apellido=new Label("Apellido: ");
                lbl_telefono=new Label("Teléfono: ");
                tf_nombre=new TextField();
                tf_apellido=new TextField();
                tf_telefono=new TextField();
                btn_enviar=new Button("Enviar...");
                btn_ventana=new Button("Mostrar Contactos");
                    EventHandler<ActionEvent> oyente1=new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                       String nombre=tf_nombre.getText();
                       String apellido=tf_apellido.getText();
                       String telefono=tf_telefono.getText();
                       Contacto c=new Contacto(nombre, apellido, telefono);
                       AccesoFichero.ingresarContacto(c, ruta);
                        }
                    };
                    EventHandler<ActionEvent> oyente2=new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                       ArrayList<Contacto> lista=AccesoFichero.leerContactos(ruta);
                       MiVentana.mostrarVentana("Lista Contactos", lista);
                        }
                    };
                btn_enviar.setOnAction(oyente1);
                btn_ventana.setOnAction(oyente2);
                VBox v=new VBox(20);
                v.getChildren().addAll(lbl_nombre, tf_nombre, lbl_apellido, tf_apellido, lbl_telefono, tf_telefono, btn_enviar,btn_ventana);  
                Scene scene=new Scene(v, 300, 500);
                primaryStage.setScene(scene);
                primaryStage.show();
	}
}
