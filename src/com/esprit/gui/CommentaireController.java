package com.esprit.gui;

import com.esprit.entities.Commentaire;
import com.esprit.entities.React;
import com.esprit.services.ServiceCommentaire;
import com.esprit.services.ServiceReact;
import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javax.swing.JOptionPane;

public class CommentaireController {

    @FXML
    private VBox commentComponent;
    @FXML
    private TextArea contentTextArea;
    @FXML
    private Button editButton;
    @FXML
    private Button deleteButton;

    private Commentaire comment;
    private ServiceCommentaire serviceCommentaire;
    private ForumController forumController;
    private ServiceReact serviceReact;

    @FXML
    private Button likeButton;

    public CommentaireController() {
    }

    public CommentaireController(Commentaire comment, ForumController forumController) throws SQLException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("commentaire.fxml"));

        try {
            commentComponent = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        CommentaireController controller = fxmlLoader.getController();
        controller.initialize(comment, forumController);
    }

    private void initialize(Commentaire comment, ForumController forumController) throws SQLException {
        serviceCommentaire = new ServiceCommentaire();
        serviceReact = new ServiceReact();

        this.comment = comment;
        this.forumController = forumController;

        contentTextArea.setText(comment.getContenu());

        int id_react = serviceReact.getIdReactbyCommentAndUser(getCurrentUser(), comment.getId_commentaire());
        if (id_react != -1) {
            likeButton.setText("Aimé");
        }
    }

    @FXML
    private void editComment(ActionEvent event) throws IOException, SQLException {
        if (contentTextArea.isEditable()) {
            String newContent = contentTextArea.getText();
            comment.setContenu(newContent);
            serviceCommentaire.modifier(comment);
            editButton.setText("Modifier");
            contentTextArea.setEditable(false);
            loadComments();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succès");
            alert.setHeaderText(null);
            alert.setContentText("Commentaire modifé avec succès !");
            alert.showAndWait();
        } else {
            contentTextArea.setEditable(true);
            editButton.setText("Enregistrer");
        }

    }

    @FXML
    private void deleteComment(ActionEvent event) throws IOException, SQLException {
        if (JOptionPane.showConfirmDialog(null, "Voulez vous supprimer ?", "Confirmation", JOptionPane.YES_NO_CANCEL_OPTION) == 0) {
            serviceCommentaire.supprimer(comment);
            loadComments();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succès");
            alert.setHeaderText(null);
            alert.setContentText("Commentaire supprimé avec succès !");
            alert.showAndWait();
        }

    }

    public VBox getCommentComponent() {
        return commentComponent;
    }

    public void setForumController(ForumController forumController) {
        this.forumController = forumController;
    }

    private void loadComments() throws SQLException {
        forumController.loadComments();
    }

    @FXML
    private void likeComment(ActionEvent event) throws SQLException {
        int id_react = serviceReact.getIdReactbyCommentAndUser(getCurrentUser(), comment.getId_commentaire());
        if (id_react == -1) {
            serviceReact.ajouter(new React(true, comment.getId_commentaire(), getCurrentUser()));
        } else {
            React R = new React(id_react, true, comment.getId_commentaire(), getCurrentUser());
            serviceReact.supprimer(R);
        }
        loadComments();
    }

    public int getCurrentUser() {
        //function that return current user
        return 1;
    }
}
