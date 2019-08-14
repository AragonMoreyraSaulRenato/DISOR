/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author drone
 */

import java.sql.Connection;
import java.sql.SQLException;
import singleton.SingletonConnection;

public class Main {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws  SQLException, ClassNotFoundException {
        SingletonConnection s1 = SingletonConnection.getInstance();
        SingletonConnection s2 = SingletonConnection.getInstance();
        SingletonConnection s3 = SingletonConnection.getInstance();
        
        System.out.println(s1.toString());
        System.out.println(s2.toString());
        System.out.println(s3.toString());
     
    }
    
}
