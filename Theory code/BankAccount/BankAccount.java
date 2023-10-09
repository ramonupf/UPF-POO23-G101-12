public class BankAccount {

	// normal private attributes (one per instance)
    private String holder;
    private double balance;
    private AccountType type;
    
    // static: belongs to the *class* rather than each instance
    // final: the value of the attribute is a *constant*
    public static final double interestRate = 0.01;

    public BankAccount(String h, double b, AccountType t) {
        holder = h;
        balance = b;
        type = t;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance = balance + amount;
    }

    public double withdraw(double amount) {
        if (amount <= balance) {
            balance = balance - amount;
            return amount;
        }
        else return 0;
    }

    public void chargeInterest() {
        double amount = balance * interestRate;
        deposit(amount);
    }

	// static: belongs to the *class* rather than each instance
	// can be called without having access to an instance!
    public static double getInterestRate() {
        return interestRate;
    }
}
