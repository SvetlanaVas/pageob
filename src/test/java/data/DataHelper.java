package data;
import lombok.Value;
import page.CardChoicePage;

import java.util.Random;

public class DataHelper {

    private DataHelper() {
    }

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo() {

        return new AuthInfo("vasya", "qwerty123");
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {

        return new VerificationCode("12345");
    }


    @Value

    public static class MoneyTransfer {
        private String amount;
        private String cardNumber;
    }

    public static MoneyTransfer firstCardInfo() {
        CardChoicePage balance = new CardChoicePage();
        int limit = balance.checkFirstCardBalance();
        String amount = Integer.toString(getRandomAmount(limit));
        return new MoneyTransfer(amount, "5559 0000 0000 0001");
    }

    public static MoneyTransfer secondCardInfo() {
        CardChoicePage balance = new CardChoicePage();
        int limit = balance.checkSecondCardBalance();
        String amount = Integer.toString(getRandomAmount(limit));
        return new MoneyTransfer(amount, "5559 0000 0000 0002");
    }
    public static MoneyTransfer firstCardInfoWhenAmountDouble() {
        CardChoicePage balance = new CardChoicePage();
        double limit = balance.getFirstCardBalanceIfAmountDoubleBeforeTransfer();
        String amount = Double.toString(getRandomDoubleAmount(limit));
        return new MoneyTransfer(amount, "5559 0000 0000 0001");
    }
    public static MoneyTransfer secondCardInfoWhenAmountDouble() {
        CardChoicePage balance = new CardChoicePage();
        double limit = balance.getSecondCardBalanceIfAmountDoubleBeforeTransfer();
        String amount = Double.toString(getRandomDoubleAmount(limit));
        return new MoneyTransfer(amount, "5559 0000 0000 0002");
    }


    public static int getRandomAmount(int max) {
        Random random = new Random();
        return random.nextInt(max);
    }

    public static double getRandomDoubleAmount(double max) {
        Random random = new Random();
        return random.nextDouble();
    }

    public static int getCardBalance(String str) {
        int balance = 0;
        String[] cardList = str.split(" ");
        for (int i = 0; i < cardList.length; i++) {
            balance = Integer.parseInt(cardList[6]);
        }
        return balance;
    }
    public static double getCardBalanceIfAmountDouble(String str) {
        double balance = 0;
        String[] cardList = str.split(" ");
        for (int i = 0; i < cardList.length; i++) {
            balance = Double.parseDouble(cardList[6]);
        }
        return balance;
    }
}


