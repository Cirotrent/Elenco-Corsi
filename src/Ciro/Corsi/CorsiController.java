/**
 * Sample Skeleton for 'Corsi.fxml' Controller Class
 */

package Ciro.Corsi;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import Ciro.Corsi.Model.Corso;
import Ciro.Corsi.Model.Model;
import Ciro.Corsi.Model.Statistica;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CorsiController {

	// Model modello=new Model();
	private Model model;

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="txtSemestre"
	private TextField txtSemestre; // Value injected by FXMLLoader

	@FXML // fx:id="BottoneCerca"
	private Button BottoneCerca; // Value injected by FXMLLoader

	@FXML // fx:id="BtnCercaMatricola"
	private Button BtnCercaMatricola; // Value injected by FXMLLoader

	@FXML // fx:id="txtMatricola"
	private TextField txtMatricola; // Value injected by FXMLLoader

	@FXML // fx:id="txtArea"
	private TextArea txtArea; // Value injected by FXMLLoader

	@FXML // fx:id="txtCorsoDiStudi"
	private TextField txtCorsoDiStudi; // Value injected by FXMLLoader

	@FXML // fx:id="btnCercaIscritti"
	private Button btnCercaIscritti; // Value injected by FXMLLoader

	@FXML
	void btnCercaIscritti(ActionEvent event) {
		try {
			String codins = txtCorsoDiStudi.getText();

			Statistica statistica = model.studentiIscrittiPerCorso(codins);

			txtArea.appendText(statistica + "\n");

		} catch (Exception e) {
			txtArea.appendText("Inserimento non valido!");
		}
	}

	@FXML
	void MetodoCerca(ActionEvent event) {

		txtArea.clear();
		try {
			int pd = Integer.parseInt(txtSemestre.getText());
			if (pd != 1 && pd != 2) {
				txtArea.setText("Inserire un periodo didattico( 1 o 2)");
				return;
			}
			List<Corso> corsi = model.listaCorsiSemestre(pd);
			for (Corso c : corsi) {
				txtArea.appendText(c.toString() + "\n");
			}
		} catch (NumberFormatException e) {

			txtArea.setText("Inserire un periodo didattico( 1 o 2)");
		}
	}

	@FXML
	void btnCercaMatricola(ActionEvent event) {
		txtArea.clear();
		try {
			int matricola = Integer.parseInt(txtMatricola.getText());
			String studente = model.getNomeCognomeByMatricola(matricola);

			txtArea.appendText(studente);

		} catch (NumberFormatException e) {

			txtArea.setText("Inserire una matricola di 6 cifre intere\n");
		}

	}

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert txtSemestre != null : "fx:id=\"txtSemestre\" was not injected: check your FXML file 'Corsi.fxml'.";
		assert BottoneCerca != null : "fx:id=\"BottoneCerca\" was not injected: check your FXML file 'Corsi.fxml'.";
		assert txtArea != null : "fx:id=\"txtArea\" was not injected: check your FXML file 'Corsi.fxml'.";

	}

	public void setModel(Model model) {

		this.model = model;
	}
}
