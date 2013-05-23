/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Login;

/**
 *
 * @author Andrés Sarmiento Tobón <ansarmientoto at unal.edu.co>
 */
public class ControllerLogIn {

    /**
     *
     * @param user
     * @param pass
     * @return
     */
    public static boolean login(String user, String pass) {
        Login login = DAO.DAOLogin.read(user);
        pass = ControllerSecurity.MD5(pass);
        return pass.equals(login.getPasswordMD5());
    }
}
