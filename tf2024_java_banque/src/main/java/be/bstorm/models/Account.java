package be.bstorm.models;

public abstract class Account {

    private String number;
    private double balance;
    private Person owner;
    private final double savingsInterest = 4.5;
    private final int currentInterestPos = 3;
    private final double currentInterestNeg = 9.75;

    public Account(String number, double balance, Person owner) {
        this.number = number;
        this.balance = balance;
        this.owner = owner;
    }

    public Account(String number, Person owner) {
        this(number, 0, owner);
    }

    public String getNumber() {
        return number;
    }

    private void setNumber(String number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    private void setBalance(double balance) {
        this.balance = balance;
    }

    public Person getOwner() {
        return owner;
    }

    private void setOwner(Person owner) {
        this.owner = owner;
    }

    public void deposit(double amount){
        if( amount < 0 )
            return;

        this.setBalance( this.getBalance() + amount );
    }

    public void withdraw(double amount){
        if( amount < 0 )
            return;

        this.setBalance( this.getBalance() - amount );
    }
    protected abstract double calculateInterest();

    public void applyInterest(){
        double toAdd = this.balance * (calculateInterest()/100);
        this.setBalance( this.getBalance() * toAdd);
    }
}
