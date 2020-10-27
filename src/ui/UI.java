package ui;

import hand.StandardHand;

import java.util.List;

public interface UI {
    void publicShowHand(StandardHand hand);

    boolean getAnswer(String string);

    void ask()

}
