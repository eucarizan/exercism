public class BankAccount {
    private int balance;
    private boolean isOpen;

    public BankAccount() {
        this.balance = 0;
        this.isOpen = false;
    }

    public void open() {
        this.isOpen = true;
    }

    public void close() {
        this.isOpen = false;
    }

    public synchronized void deposit(int amount) throws BankAccountActionInvalidException {
        if (!isOpen) {
            throw new BankAccountActionInvalidException("Account closed");
        }

        if (amount < 0) {
            throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
        }

        this.balance += amount;
    }

    public int getBalance() throws BankAccountActionInvalidException {
        if (!isOpen) {
            throw new BankAccountActionInvalidException("Account closed");
        }

        return this.balance;
    }

    public synchronized void withdraw(int amount) throws BankAccountActionInvalidException {
        if (!isOpen) {
            throw new BankAccountActionInvalidException("Account closed");
        }

        if (balance == 0) {
            throw new BankAccountActionInvalidException("Cannot withdraw money from an empty account");
        }

        if (amount < 0) {
            throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
        }

        if (amount > balance) {
            throw new BankAccountActionInvalidException("Cannot withdraw more money than is currently in the account");
        }

        this.balance -= amount;
    }
}