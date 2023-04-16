package org.geekster;

public class Main {
    public static void main(String[] args) {

// prepare to send mail
        System.out.println("this Application is supposed to send mails");


    HandleMail mailer= new HandleMail();

       mailer.sendMail();
    }
}