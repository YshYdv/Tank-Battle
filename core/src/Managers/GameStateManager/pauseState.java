package Managers.GameStateManager;

import Managers.InputManager.gameKeys;
import Objects.myShapeRenderer;
import Objects.myTextBoxManager;
import com.badlogic.gdx.graphics.Color;

public class pauseState {

    private play play;

    private myShapeRenderer msr;

    private myTextBoxManager mtb;

    private String[] options;
    private final int noOfOptions = 2;
    private int currentOption;

    public pauseState(play play) {

        this.play = play;

        msr = new myShapeRenderer();

        mtb = new myTextBoxManager("Exo-VariableFont_wght.ttf");

        options = new String[] {"RESUME","QUIT"};
        currentOption = 0;

    }

    public boolean update() {
        return handleInput();
    }

    public boolean handleInput() {

        if (gameKeys.isPressed(gameKeys.DOWN) && currentOption!=noOfOptions-1) currentOption++;
        else if (gameKeys.isPressed(gameKeys.UP) && currentOption!=0) currentOption--;
        else if (gameKeys.isPressed(gameKeys.ENTER)) {
            if (currentOption==0) {
                play.resume();
            }
            else if (currentOption==1) {
                play.quit();
            }
            else return false;
        }
        return true;

    }

    public void draw() {

        // Exit Background
        msr.roundedRect(100,100,500,300,10, Color.TEAL);

        // Option Boxes
        mtb.setTextBox(350,300,20,50,2,15,options,
                currentOption,Color.WHITE,Color.TEAL,Color.CYAN);

    }

}
