package main.classes;

/**
 * Represents a credit/debit card with its associated information.
 * @author Daniel
 * @version 1.0
 */
public class Card {
    private String cardNumber;
    private String cvvCvc;
    private String cardHolderName;
    private String expirationMonth;
    private String expirationYear;

    /**
     * Constructs a new Card object with default values.
     */
    public Card() {
        this.cardNumber = "";
        this.cvvCvc = "";
        this.cardHolderName = "";
        this.expirationMonth = "";
        this.expirationYear = "";
    }

    /**
     * Constructs a new Card object with the specified card details.
     *
     * @param cardNumber       the card number
     * @param cvvCvc           the CVV/CVC code
     * @param cardHolderName   the name of the cardholder
     * @param expirationMonth  the expiration month
     * @param expirationYear   the expiration year
     */
    public Card(String cardNumber, String cvvCvc, String cardHolderName, String expirationMonth, String expirationYear) {
        this.cardNumber = cardNumber;
        this.cvvCvc = cvvCvc;
        this.cardHolderName = cardHolderName;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
    }

    /**
     * Returns the card number.
     *
     * @return the card number
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * Sets the card number.
     *
     * @param cardNumber the card number to set
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * Returns the CVV/CVC code.
     *
     * @return the CVV/CVC code
     */
    public String getCvvCvc() {
        return cvvCvc;
    }

    /**
     * Sets the CVV/CVC code.
     *
     * @param cvvCvc the CVV/CVC code to set
     */
    public void setCvvCvc(String cvvCvc) {
        this.cvvCvc = cvvCvc;
    }

    /**
     * Returns the name of the cardholder.
     *
     * @return the name of the cardholder
     */
    public String getCardHolderName() {
        return cardHolderName;
    }

    /**
     * Sets the name of the cardholder.
     *
     * @param cardHolderName the name of the cardholder to set
     */
    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    /**
     * Returns the expiration month.
     *
     * @return the expiration month
     */
    public String getExpirationMonth() {
        return expirationMonth;
    }

    /**
     * Sets the expiration month.
     *
     * @param expirationMonth the expiration month to set
     */
    public void setExpirationMonth(String expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    /**
     * Returns the expiration year.
     *
     * @return the expiration year
     */
    public String getExpirationYear() {
        return expirationYear;
    }

    /**
     * Sets the expiration year.
     *
     * @param expirationYear the expiration year to set
     */
    public void setExpirationYear(String expirationYear) {
        this.expirationYear = expirationYear;
    }
    /**
     * @deprecated
     * @return
     */
    public static Card createMockup() {
        String cardNumber = "1234567890123456";
        String cvvCvc = "123";
        String cardHolderName = "John Doe";
        String expirationMonth = "12";
        String expirationYear = "2025";

        Card mockup = new Card(cardNumber, cvvCvc, cardHolderName, expirationMonth, expirationYear);

        return mockup;
    }

}

