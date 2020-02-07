package test;
import data.DataHelper;
import page.CardChoicePage;
import lombok.*;
import page.CheckBalancePage;
import org.junit.jupiter.api.Test;
import page.LoginPage;
import page.TransferPage;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTransferTest {

    @Test
    void shouldTransferMoneyFromSecondCard() {
        val loginPage = new LoginPage();
        loginPage.openLoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);

        val transferPage = new TransferPage();
        val cardInfo = DataHelper.secondCardInfo();

        val transferDashboard = new CardChoicePage();
        transferDashboard.choiceFirstCardForTransfer();
        transferPage.putMoneyCard(cardInfo);

    }

    @Test
    void shouldTransferMoneyFromFirstCard() {
        val loginPage = new LoginPage();
        loginPage.openLoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);

        val transferPage = new TransferPage();
        val cardInfo = DataHelper.firstCardInfo();

        val transferDashboard = new CardChoicePage();
        transferDashboard.choiceSecondCardForTransfer();
        transferPage.putMoneyCard(cardInfo);

    }

    @Test
    void checkFirstCardBalance() {
        val loginPage = new LoginPage();
        loginPage.openLoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);

        val transferPage = new TransferPage();
        val cardInfo = DataHelper.secondCardInfo();

        val firstCardBalanceBeforeTransfer = new CardChoicePage();
        int actual = firstCardBalanceBeforeTransfer.checkFirstCardBalance();
        val transferDashboard = new CardChoicePage();
        transferDashboard.choiceFirstCardForTransfer();
        transferPage.putMoneyCard(cardInfo);
        val firstCardBalanceAfterTransfer = new CheckBalancePage();
        int expected = firstCardBalanceBeforeTransfer.checkFirstCardBalance();
        assertNotEquals(expected, actual);
    }

    @Test
    void checkSecondCardBalance() {
        val loginPage = new LoginPage();
        loginPage.openLoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);

        val transferPage = new TransferPage();
        val cardInfo = DataHelper.firstCardInfo();

        val secondCardBalanceBeforeTransfer = new CardChoicePage();
        int actual = secondCardBalanceBeforeTransfer.checkSecondCardBalance();
        val transferDashboard = new CardChoicePage();
        transferDashboard.choiceSecondCardForTransfer();
        transferPage.putMoneyCard(cardInfo);
        val secondCardBalanceAfterTransfer = new CheckBalancePage();
        int expected = secondCardBalanceAfterTransfer.checkSecondCardBalanceAfterTransfer();
        assertNotEquals(expected, actual);
    }

    @Test
    void checkSecondCardBalanceIfAmountDouble() {
        val loginPage = new LoginPage();
        loginPage.openLoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);

        val transferPage = new TransferPage();
        val cardInfo = DataHelper.firstCardInfoWhenAmountDouble();

        val transferDashboard = new CardChoicePage();
        transferDashboard.choiceSecondCardForTransfer();
        transferPage.putMoneyCard(cardInfo);
        val secondCardBalanceAfterTransfer = new CheckBalancePage();
        double expected = secondCardBalanceAfterTransfer.getSecondCardBalanceIfAmountDoubleAfterTransfer();
        assertTrue(expected % 1 == 0);

    }
}