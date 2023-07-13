package DorBitton.WinAppDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;


import io.appium.java_client.windows.WindowsDriver;
//import test.objects;



public class Calculator extends Objects{

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
        calSession = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
        System.out.println(calSession.getSessionId());
        calSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        SwitchMode("Standard Calculator");
        Click("One");
        Decimal();
        Click("Two");
        Delete();
        Click("Three");
        Clear();
        Click("Four");
        Delete();
        Click("Five");
        Clear();
        Click("Six");
        Delete();
        Click("Seven");
        Clear();
        Click("Eight");
        Delete();
        Click("Nine");
        Clear();
        Click("One");
        Plus();
        Click("Three");
        Equal();
        Clear();
        EnterInput("256");
        Clear();
        EnterInput("112.5");
        Clear();
        EnterInput("1+1");
        Clear();
        EnterInput("1+2*3/4.5-88");
        SwitchMode("Standard Calculator");
        SwitchMode("Scientific Calculator");
        SwitchMode("Graphing Calculator");
        SwitchMode("Programmer Calculator");
        SwitchMode("Date calculation Calculator");
        closeSession(calSession);
	}
	
	
}
