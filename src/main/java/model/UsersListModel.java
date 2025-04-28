/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dao.UserDAO;
import dao.MySQLConnexion;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author m.sage
 */
public class UsersListModel extends AbstractTableModel {

    // Attribut
    private final String[] enteteTableauUser = {"ID", "PRENOM", "NOM", "IDENTIFIANT", "PASSWORD", "EMAIL"};
    private ArrayList<User> users = new ArrayList<User>();
    private UserDAO userDAO;

    // Contructeur
    public UsersListModel() {
        this.userDAO = new UserDAO();
        users = this.userDAO.findAll();
        this.fireTableDataChanged();
    }

    // Methodes
    public String getColumnName(int column) {
        return this.enteteTableauUser[column];
    }

    public int getRowCount() {
        return this.users.size();
    }

    public int getColumnCount() {
        return this.enteteTableauUser.length;
    }

    public void update(int id, String prenom, String nom, String identifiant, String mdp, String adresse_mail) {
        this.userDAO.UpdateUser(new User(id, prenom, nom, identifiant, mdp, adresse_mail));
        this.users = this.userDAO.findAll();
        this.fireTableDataChanged();
    }

    public void create(String prenom, String nom, String identifiant, String mdp, String adresse_mail) {
        this.userDAO.createUser(new User(prenom, nom, identifiant, mdp, adresse_mail));
        this.users = this.userDAO.findAll();
        this.fireTableDataChanged();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        User user = users.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return user.getId();
            case 1:
                return user.getPrenom();
            case 2:
                return user.getNom();
            case 3:
                return user.getIdentifiant();
            case 4:
                return user.getPassword();
            case 5:
                return user.getEmail();
            default:
                return null;
        }
    }
}
