package DorBitton.WinAppDriver;

import io.appium.java_client.windows.WindowsDriver;

public class Objects {
	static WindowsDriver calSession;
	protected static void EnterInput(String input) {
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
            	switch(c) {
            		case'1':
            			Click("One");
            			break;
            		case'2':
            			Click("Two");
            			break;
            		case'3':
            			Click("Three");
            			break;
            		case'4':
            			Click("Four");
            			break;
            		case'5':
            			Click("Five");
            			break;
            		case'6':
            			Click("Six");
            			break;
            		case'7':
            			Click("Seven");
            			break;
            		case'8':
            			Click("Eight");
            			break;
            		case'9':
            			Click("Nine");
            			break;
            		default:
                        System.out.println(c + " number not exist");
            	}
            } else {
                switch (c) {
                    case '+':
                        Plus();
                        break;
                    case '-':
                        Minus();
                        break;
                    case '*':
                    	Multiple();
                        break;
                    case '/':
                    	Divide();
                        break;
                    case '.':
                    	Decimal();
                        break;
                    default:
                        System.out.println("Invalid action: " + c);
                }
            }
           
        }
        Equal();
    }
	
	protected static void Clear() {
		calSession.findElementByName("Clear entry").click();
	}
	
	protected static void Delete() {
		calSession.findElementByName("Backspace").click();
	}
	
	protected static void Plus() {
		calSession.findElementByName("Plus").click();
	}
	
	protected static void Minus() {
		calSession.findElementByName("Minus").click();
	}
	
	protected static void Multiple() {
		calSession.findElementByName("Multiply by").click();
	}
	
	protected static void Divide() {
		calSession.findElementByName("Divide by").click();
	}
	
	protected static void Decimal() {
		calSession.findElementByName("Decimal separator").click();
	}
	
	protected static void Equal() {
		calSession.findElementByName("Equals").click();
	}
	
	protected static void SwitchMode(String nameMode) {
		calSession.findElementByName("Open Navigation").click();
		calSession.findElementByName(nameMode).click();
	}
	
	protected static void Click(String str) {
		calSession.findElementByName(str).click();
	}
	
	protected static void closeSession(WindowsDriver calculatorSession) {
		while(calculatorSession != null) {
			calculatorSession.quit();
		}
	}
}
