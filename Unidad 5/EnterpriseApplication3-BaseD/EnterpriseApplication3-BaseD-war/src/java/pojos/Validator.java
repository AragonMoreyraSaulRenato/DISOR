/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author drone
 */
public class Validator {
    Pattern p;
    Matcher m;
    public Validator(){
    
    }
    
    public boolean onlyLetters(String input){
        p = Pattern.compile("[a-zA-Z]");
        m = p.matcher(input);
        return m.find();
    }
    
    public boolean onlyNumbers(String input){
        p = Pattern.compile("[1-9]*");
        m = p.matcher(input);
        return m.find();
    }
}
