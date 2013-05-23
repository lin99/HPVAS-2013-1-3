/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.security.MessageDigest;

/**
 *
 * @author Omar Prieto
 */
public class ControllerSecurity {

    private static final char[] CONSTS_HEX = {'0', '1', '2', '3', '4', '5', '6',
        '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /**
     *
     * @param input
     * @return
     */
    public static String MD5(String input) {
        try {
            MessageDigest msgd = MessageDigest.getInstance("MD5");
            byte[] bytes = msgd.digest(input.getBytes());
            StringBuilder sbOutput = new StringBuilder(2 * bytes.length);
            for (int i = 0; i < bytes.length; i++) {
                int bajo = (int) (bytes[i] & 0x0f);
                int alto = (int) ((bytes[i] & 0xf0) >> 4);
                sbOutput.append(CONSTS_HEX[alto]);
                sbOutput.append(CONSTS_HEX[bajo]);
            }
            return sbOutput.toString();
        } catch (Exception e) {
            return "";
        }
    }
}
