package com.company;

import java.util.concurrent.Callable;

import static util.Keyboard.*;

class CardBlockedException extends Exception {
    public CardBlockedException(String msj) {
        super(msj);
    }
}

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

class Atm {
    private String nameOfBank;
    private Card card;

    public Atm(String nameOfBank) {
        this.nameOfBank = nameOfBank;
    }

    public void insertCard(Card card) throws CardBlockedException {
        System.out.println("Card was inserted! \n\n");
        this.card = card;
        int input = 0;
        while (this.card.getAttempts() != 3 && card.getPin() != input) {
            System.out.print("Insert Pin Code: ");
            input = nextInt();
            if (input == card.getPin()) {
                System.out.println("Welcome \n" + card.getUser().getName() + "\n\n Acces to your Account \n\n *MENU* ");
                showMenu();
            } else {
                this.card.setAttempts(this.card.getAttempts() + 1);
                System.out.println("Acces denied! \n\n Try again.");
            }
        }
        if (this.card.getAttempts() == 3) {
            throw new CardBlockedException("Your card is blocked. Check your bank to unlock your credit Card!");
        }
    }

    private void showMenu() {
        int option = 0;
        while (option != 4) {
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit ");
            option = nextInt();

            switch (option) {
                case 1: {
                    System.out.println("***********************");
                    System.out.println("Enter sum for deposit");
                    int depositAmount = nextInt();
                    card.getAccount().deposit(depositAmount);
                    System.out.println("You added to account sum of " + depositAmount + " $");
                    System.out.println("***********************");
                    System.out.println("\n");
                    break;

                }
                case 2: {
                    System.out.println("***********************");
                    System.out.println("Enter sum for withdraw");
                    int withdrawAmount = nextInt();
                    try {
                        card.getAccount().withdraw(withdrawAmount);
                        System.out.println("You withdraw to your account sum of " + withdrawAmount + " $");
                        System.out.println("*******************");
                    } catch (EnoughtMoneyException e) {
                        System.out.println(e);
                    }
                    System.out.println("\n");
                    break;

                }
                case 3: {
                    System.out.println("***********************");
                    System.out.println("Your Balance is : " + card.getAccount().checkBalance());
                    System.out.println("***********************");
                    System.out.println("\n");
                    break;
                }
                case 4: {
                    System.out.println("-------------------------");
                    System.out.println("Operation ended \n Have a nice day!");
                    System.out.println("-------------------------");
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }
}

    public class Main {

        public static void main(String[] args) {


    }
}
