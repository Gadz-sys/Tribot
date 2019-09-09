package scripts;

import org.tribot.api.input.Keyboard;
import org.tribot.api2007.Interfaces;

public class CreateCharacter {

    public void makeCharacter() {
        if (Interfaces.get(558, 11) != null && !Interfaces.get(558, 11).isHidden()) {//if the name selection screen is visible
            if (!Interfaces.get(558, 11).getText().isEmpty()) {//if there is currently text in the name bar
                if (Interfaces.get(558, 15) != null && !Interfaces.get(558, 15).isHidden()) {//if a suggested name is showing
                    Interfaces.get(558, 15).click();//choose that suggested name
                }
                else if (Interfaces.get(558, 18) != null && !Interfaces.get(558, 18).isHidden()) {//if the set name button is available
                    Interfaces.get(558, 18).click();//click the set name button
                }
            }
            else if (Interfaces.get(558, 11).getText().isEmpty()) {//if there is no text in the name bar
                if (Interfaces.get(162, 44) != null && !Interfaces.get(162, 44).isHidden()) {//if text box is open
                    Keyboard.typeString("5");//type 5
                    Keyboard.pressEnter();//press enter
                }
                else if (Interfaces.get(558, 7) != null && !Interfaces.get(558, 7).isHidden()) {//if text box is not open
                    Interfaces.get(558, 7).click();//open text box
                }
            }
        }
        else if (Interfaces.get(269, 100) != null && !Interfaces.get(269, 100).isHidden()) {
            Interfaces.get(269, 100).click();
        }
    }
}
