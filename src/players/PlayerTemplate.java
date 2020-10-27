package players;

import hand.Hand;
import ui.UI;

import java.util.UUID;

public abstract class PlayerTemplate {
    private UUID id;
    private String name;
    private Hand hand;

    public PlayerTemplate(String name, Hand hand)
    {
        this.id = UUID.randomUUID();
        this.name = name;
        this.hand = hand;
    }

    public UUID getId() {
        return id;
    }

}
