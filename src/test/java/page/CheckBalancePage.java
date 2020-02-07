package page;

import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import static com.codeborne.selenide.Selenide.$;
public class CheckBalancePage {
    private SelenideElement firstCardString = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']");
    private SelenideElement secondCardString = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']");
    private SelenideElement reloadButton = $("[data-test-id='action-reload']");

    public int checkFirstCardBalanceAfterTransfer() {
        String str = firstCardString.toString();
        return DataHelper.getCardBalance(str);
    }


    public int checkSecondCardBalanceAfterTransfer() {
        String str = secondCardString.toString();
        return DataHelper.getCardBalance(str);
    }
    public double getFirstCardBalanceIfAmountDoubleAfterTransfer() {
        String str = firstCardString.toString();
        return DataHelper.getCardBalanceIfAmountDouble(str);
    }
    public double getSecondCardBalanceIfAmountDoubleAfterTransfer() {
        String str = secondCardString.toString();
        return DataHelper.getCardBalanceIfAmountDouble(str);
    }
}
