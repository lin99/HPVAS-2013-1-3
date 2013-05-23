/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author jiacontrerasp
 */
public class ControllerFormatting {

    public static boolean validateSSN(String ssn) {
    // validate format (no all zeroes, length 9
    String expression = "^\\d{3}[- ]?\\d{2}[- ]?\\d{4}$";
    CharSequence inputStr = ssn;
    Pattern pattern = Pattern.compile(expression);
    Matcher matcher = pattern.matcher(inputStr);
        
        if (!matcher.matches() || ssn.length()!=9) {
            return false;
        }
        else{
               //The SSA implemented the new assignment methodology on June 25, 2011.     
                // validate area number (1st 3 digits)
                    int area;
                    area = Integer.parseInt(ssn.substring(0, 3));
                //  standard      railroad numbers (pre-1963)
                     if (area>649 && !(area>=700 && area<=728)) {
                         return false;
                     }

                // disallow specific invalid number
                if ("078051120".equals(ssn) || "219099999".equals(ssn) || "123456789".equals(ssn) || "123121234".equals(ssn) || "321214321".equals(ssn) || "111111111".equals(ssn) || "222222222".equals(ssn) || "333333333".equals(ssn) || "444444444".equals(ssn) || "555555555".equals(ssn)) {
                    return false;
                }
                else {
                    return true;
                }
        }
}
 
  public static boolean validateDate(String date) {
   SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    try {
            format.parse(date);
            return true;
       }
       catch(ParseException e){
            return false;
       }
    }
    
}
