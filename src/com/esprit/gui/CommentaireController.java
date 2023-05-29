package com.esprit.gui;

import com.esprit.entities.Commentaire;
import com.esprit.services.ServiceCommentaire;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

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

    public CommentaireController() {
    }

    public CommentaireController(Commentaire comment, ForumController forumController) {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("commentaire.fxml"));

        try {
            commentComponent = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        CommentaireController controller = fxmlLoader.getController();
        controller.initialize(comment, forumController);
    }

    private void initialize(Commentaire comment, ForumController forumController) {
        serviceCommentaire = new ServiceCommentaire();
        this.comment = comment;
        this.forumController = forumController;

        contentTextArea.setText(comment.getContenu());
    }

    @FXML
    private void editComment(ActionEvent event) throws IOException {
        if (contentTextArea.isEditable()) {
            String newContent = contentTextArea.getText();
            comment.setContenu(newContent);
            serviceCommentaire.modifier(comment);
            editButton.setText("Modifier");
            contentTextArea.setEditable(false);
            loadComments();

        } else {
            contentTextArea.setEditable(true);
            editButton.setText("Enregistrer");
        }

    }

    @FXML
    private void deleteComment(ActionEvent event) throws IOException {
        System.out.println("comment" + comment);
        System.out.println("servicecomment" + serviceCommentaire);
        serviceCommentaire.supprimer(comment);
        loadComments();
    }

    public VBox getCommentComponent() {
        return commentComponent;
    }

    public void setForumController(ForumController forumController) {
        this.forumController = forumController;
    }

    private void loadComments() {
        forumController.loadComments();
    }

}
