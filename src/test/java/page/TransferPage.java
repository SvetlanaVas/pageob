package page;

        import com.codeborne.selenide.SelenideElement;
        import data.DataHelper;


        import static com.codeborne.selenide.Selenide.$;

public class TransferPage {
    private SelenideElement countField = $("[data-test-id='amount'] input");
    private SelenideElement cardNumberField = $("[data-test-id='from'] input");
    private SelenideElement putMoneyButton = $("[data-test-id='action-transfer']");

    public DashboardPage putMoneyCard(DataHelper.MoneyTransfer info) {
        countField.setValue(info.getAmount());
        cardNumberField.setValue(info.getCardNumber());
        putMoneyButton.click();
        return new DashboardPage();
    }

}
