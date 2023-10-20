import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class EMITestRun extends setup {
    @BeforeTest
    public void startEMICalc(){
        EmiScreen emiScreen=new EmiScreen(driver);
        emiScreen.btnStart.click();
    }
    @Test(priority = 1,dataProviderClass = Dataset.class, dataProvider = "data-provider")

    public void calculateEMI(int amount, double interest, int year, double processingFee, int mEMI, int tInterest, int pFee, int tPayment){

        EmiScreen emiScreen=new EmiScreen(driver);
        emiScreen.calculateEMI(amount, interest, year, processingFee);

        String actualmEMI= String.valueOf(Math.round(Double.parseDouble(emiScreen.lblMonthlyEMI.getText().replace(",", ""))));
        String actualtInterest= String.valueOf(Math.round(Double.parseDouble(emiScreen.lblTotalInterest.getText().replace(",", ""))));
        String actualtpFee= String.valueOf(Math.round(Double.parseDouble(emiScreen.lblProcessingFee.getText().replace(",", ""))));
        String actualtPayment= String.valueOf(Math.round(Double.parseDouble(emiScreen.lblTotalPayment.getText().replace(",", ""))));

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actualmEMI, String.valueOf(mEMI));
        softAssert.assertEquals(actualtInterest, String.valueOf(tInterest));
        softAssert.assertEquals(actualtpFee, String.valueOf(pFee));
        softAssert.assertEquals(actualtPayment, String.valueOf(tPayment));
        softAssert.assertAll();


        emiScreen.btnReset.click();
    }
}