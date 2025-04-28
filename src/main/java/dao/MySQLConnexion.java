/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author m.sage
 */
public class MySQLConnexion {

    private static String url = "jdbc:mysql://localhost:3306/ap4user";
    private static String user = "root"; // utilisateur mysql ou de la BDD
    private static String pass = ""; // mot de passe mysql ou de la BDD
    private static Connection con = null;

    // Méthode static qui va créer la connexion entre le serveur et la BDD.
    public static Connection getConnexion() {
        if (con == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, user, pass);
            } catch (Exception ex) {
                Logger.getLogger(MySQLConnexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return con;
    }
}
