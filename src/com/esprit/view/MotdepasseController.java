/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.view;

import com.esprit.entities.CodeGenerator;
import com.esprit.services.ServiceUser;
import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Anis
 */
public class MotdepasseController implements Initializable {

    @FXML
    private TextField login;
    @FXML
    private Button submit;
    @FXML
    private Button retour;
    @FXML
    private Label erreur;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
//    public void sendEmail() {
//    Email from = new Email("anis12315@live.fr");
//    String subject = "Code de vérification";
//    Email to = new Email(login.getText());
//    Content content = new Content("text/plain", "Votre code de réinitialisation de mot de passe est :" + CodeGenerator.generateCode());
//    Mail mail = new Mail(from, subject, to, content);
//
//    SendGrid sg = new SendGrid("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");
//    Request request = new Request();
//
//    try {
//        request.setMethod(Method.POST);
//        request.setEndpoint("mail/send");
//        request.setBody(mail.build());
//        Response response = sg.api(request);
//        System.out.println(response.getStatusCode());
//        System.out.println(response.getBody());
//        System.out.println(response.getHeaders());
//    } catch (IOException ex) {
//        ex.printStackTrace();
//    }
//}

    
    public void login(Event e){
        
        ServiceUser su = new ServiceUser();
    String loginText = login.getText();
    if (su.loginpasse(loginText)){
        try {
            String code = CodeGenerator.generateCode();
            JOptionPane.showMessageDialog(null, code);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("verificationcode.fxml"));
            Parent root = loader.load();
            VerificationcodeController vc = loader.getController();
            vc.setGeneratecode(code);
            vc.setId(loginText);
            Scene scene = new Scene(root);
            Stage stage = (Stage) login.getScene().getWindow(); // Récupère la fenêtre actuelle
            stage.setScene(scene); // Définit la nouvelle scène sur la fenêtre
            stage.show(); // Affiche la nouvelle scène
            //sendEmail();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    } else {
        erreur.setText("Nous n'avons trouvé aucun compte associé à" + " " + login.getText() + " " + "Veuillez essayer avec une adresse e-mail ou un numéro de téléphone alternatif.");
        erreur.setWrapText(true);
    }
        
    }
    
    public void retour(Event e){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) login.getScene().getWindow(); // Récupère la fenêtre actuelle
            stage.setScene(scene); // Définit la nouvelle scène sur la fenêtre
            stage.show(); // Affiche la nouvelle scène
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    @FXML
    private void genererCode(ActionEvent event) {
        // Générer le code ici
        
        
    
}
}
    
     
