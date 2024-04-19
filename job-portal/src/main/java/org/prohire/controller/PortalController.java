package org.prohire.controller;

import org.prohire.dao.UserAuthentication;
import org.prohire.model.Credentials;

import java.util.Scanner;

public class PortalController {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the username : ");
        String username=sc.next();
        System.out.println("Enter  your password : ");
        String  password=sc.next();

        Credentials credentials=new Credentials();
        credentials.setUsername(username);
        credentials.setPassword(password);
        UserAuthentication ua=new UserAuthentication();
        System.out.println(ua.athenticate(credentials));


    }
}
