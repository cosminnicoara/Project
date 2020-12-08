package com.company;

import java.util.concurrent.Callable;

import static util.Keyboard.*;



 class EnoughtMoneyException extends Exception{
     public EnoughtMoneyException(String msj){
         super(msj);
     }
 }
class User{
    private String name;
    public User(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
    public String toString(){
        return this.name;
    }
}
class Account{
    private double balance;

    public double checkBalance() {
        return balance;
    }
    public void deposit(int value){
        if (value <= 0){
            throw new IllegalArgumentException(" You don`t have enough money for deposit");
        }
        this.balance= balance+ value;
    }
    public void withdraw(int value) throws EnoughtMoneyException{
        if (this.balance < value){
            throw new EnoughtMoneyException("You wan`t to withdraw to much money and you don`t have it :)");
        }
        this.balance = balance - value;
    }
}
class Card{
     private User user;
     private Account account;
     private int pin;
     private int attempts;
    public Card(User user,Account account,int pin){
        this.user=user;
        this.account=account;
        this.pin=pin;
        this.attempts = 0;
    }

    public User getUser(){
        return this.user;
    }

    public Account getAccount() {
        return account;
    }
    public int getPin(){
        return this.pin;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }
}



    public class Main {

        public static void main(String[] args) {


    }
}
