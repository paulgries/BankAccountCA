public class Money {
    private int dollars;
    private int cents;

    // Constructor
    public Money(int dollars, int cents) {
        if (cents >= 100) {
            dollars += cents / 100;
            cents = cents % 100;
        }
        this.dollars = dollars;
        this.cents = cents;
    }

    // Getters
    public int getDollars() {
        return dollars;
    }

    public int getCents() {
        return cents;
    }

    // Convert Money to a single value in cents for easy arithmetic
    public int toCents() {
        return dollars * 100 + cents;
    }

    // Method to add money
    public Money add(Money other) {
        int totalCents = this.toCents() + other.toCents();
        return new Money(totalCents / 100, totalCents % 100);
    }

    // Method to subtract money
    public Money subtract(Money other) {
        int totalCents = this.toCents() - other.toCents();
        return new Money(totalCents / 100, totalCents % 100);
    }
}
