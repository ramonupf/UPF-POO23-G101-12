public class TestAccount {
    public static void main(String[] args) {
    
    	// create an instance of BankAccount and test the methods
        BankAccount acc = new BankAccount("John", 100, AccountType.CHECKING);
        System.out.println(acc.getBalance());
        acc.deposit(100);
        System.out.println(acc.getBalance());
        acc.chargeInterest();
        System.out.println(acc.getBalance());

		// create another instance of BankAccount
        BankAccount ac2 = new BankAccount("Mary", 500, AccountType.CHECKING);

		// This code illustrates how to use static attributes and methods
		// Instead of a variable that contains an instance,
		//   static attributes and methods are accessed using the *class* name

        System.out.println(BankAccount.interestRate);

        System.out.println(Math.PI);

        System.out.println(Math.cos(1));
    }
    
}
