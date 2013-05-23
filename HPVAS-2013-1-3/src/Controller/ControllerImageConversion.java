/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.Image;
import java.awt.Toolkit;


/**
 *
 * @author jiacontrerasp
 */
public class ControllerImageConversion {
    
    
static private Image parseImage( final byte[] bytes )
    {
        if( bytes.length == 0 ) {
            return null;
        }
        else{
            return Toolkit.getDefaultToolkit().createImage( bytes );
        }
    }
}
