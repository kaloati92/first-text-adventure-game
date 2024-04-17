package class_fractured;

public class VisibilityManager {

    private UI ui;

    public VisibilityManager(UI userInterface){

        ui = userInterface;
    }

    public void showTitleScreen(){

        //Show the title screen
        ui.getTitleNamePanel().setVisible(true);
        ui.getStartButtonPanel().setVisible(true);

        //Hide game screen
        ui.getMainTextPanel().setVisible(false);
        ui.getChoiceButtonPanel().setVisible(false);
        ui.getPlayerPanel().setVisible(false);
    }
    public void titleToTown(){
        //Hide the title screen
        ui.getTitleNamePanel().setVisible(false);
        ui.getStartButtonPanel().setVisible(false);

        //Show game screen
        ui.getMainTextPanel().setVisible(true);
        ui.getChoiceButtonPanel().setVisible(true);
        ui.getPlayerPanel().setVisible(true);
    }
}
