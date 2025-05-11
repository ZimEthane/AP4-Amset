/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.UserDAO;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JOptionPane;

import model.UsersListModel;

import view.AddUserDialog;
import view.MainView;
import view.UpdateUserDialog;

/**
 *
 * @author m.sage
 */
public class MainControl implements PropertyChangeListener {

    //atribue -------------------------------------------------------------------------------
    MainView view;
    private UsersListModel usersListModel;
    private UpdateUserDialog updateUserDialog;
    private AddUserDialog addUserDialog;

    // Constructeur -------------------------------------------------------------------------------
    public MainControl(MainView v) {
        this.usersListModel = new UsersListModel();

        this.view = v;
        this.view.addPropertyChangeListener(this);
        this.view.setTableModel(usersListModel);

        this.updateUserDialog = new UpdateUserDialog(this.view, true);
        this.updateUserDialog.addPropertyChangeListener(this);

        this.addUserDialog = new AddUserDialog(this.view, true);
        this.addUserDialog.addPropertyChangeListener(this);

    }

    // Methodes -------------------------------------------------------------------------------
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {

            case "MainViewNewUser":
                this.addUserDialog.setDefaultData();
                this.addUserDialog.setVisible(true);
                break;

            case "MainViewDeleteUser":
                int confirm = JOptionPane.showConfirmDialog(
                        this.view,
                        this.view.message("Voulez-vous supprimer cet utilisateur ?"), "Confirmation de suppression",
                        JOptionPane.YES_NO_OPTION
                );

                if (confirm == JOptionPane.YES_OPTION) {
                    try {
                        int selectedUserId = this.view.getSelectedId();
                        this.usersListModel.delete(selectedUserId);

                        JOptionPane.showMessageDialog(this.view, "Utilisateur supprimé avec succès.");
                    } catch (ArrayIndexOutOfBoundsException e) {
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this.view, "Aucun utilisateur sélectionné.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this.view, "Suppression annulée.");
                }
                break;

            // permet d'afficher les message de confirmation pour le modifier un user
            case "MainViewUpdateUser":
                updateUserDialog.setDefaultData();
                int retour = JOptionPane.showConfirmDialog(
                        this.view,
                        this.view.message("Êtes-vous sûr de modifier cet utilisateur ?"), "Confirmation de suppression",
                        JOptionPane.YES_NO_OPTION
                );
                if (retour == JOptionPane.YES_OPTION) {

                    // recuperation des information de l'utilisateur selectionner
                    this.updateUserDialog.setID(this.view.getSelectID());
                    this.updateUserDialog.setPrenom(this.view.getSelectPrenom());
                    this.updateUserDialog.setNom(this.view.getSelectNom());
                    this.updateUserDialog.setIdentifiant(this.view.getSelectIdentifiant());
                    this.updateUserDialog.setMotDePasse(this.view.getSelectMotDePasse());
                    this.updateUserDialog.setAdresseEmail(this.view.getSelectAdresseEmail());

                    //affiche la View updateUserDialog
                    this.updateUserDialog.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this.view, "Modification annuler");
                }
                break;

            // permet de verifier les modif
            case "validModifUser":
                switch (this.updateUserDialog.verifeFormulaire()) {
                    case 1:
                        this.updateUserDialog.erreurChamps();
                        break;
                    case 2:
                        this.updateUserDialog.erreurMDP();
                        break;
                    case 3:
                        this.updateUserDialog.erreurEmails();
                        break;
                    case 4:
                        usersListModel.update(
                                updateUserDialog.getId(),
                                updateUserDialog.getPrenom(),
                                updateUserDialog.getNom(),
                                updateUserDialog.getIdentifiant(),
                                updateUserDialog.getMotDePasse(),
                                updateUserDialog.getAdresseEmail());
                        updateUserDialog.setVisible(false);
                        break;
                }
                break;
            // permet de verifier l'ajout
            case "ValideAjoutUser":
                switch (this.addUserDialog.verifeFormulaire()) {
                    case 1:
                        this.addUserDialog.erreurChamps();
                        break;
                    case 2:
                        this.addUserDialog.erreurMDP();
                        break;
                    case 3:
                        this.addUserDialog.erreurEmails();
                        break;
                    case 4:
                        usersListModel.create(
                                addUserDialog.getPrenom(),
                                addUserDialog.getNom(),
                                addUserDialog.getIdentifiant(),
                                addUserDialog.getMotDePasse(),
                                addUserDialog.getAdresseEmail());
                        addUserDialog.setVisible(false);
                        break;
                }
                break;
        }
    }
}
