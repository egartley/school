import java.awt.Graphics;

/**
 * Modified version of https://github.com/egartley/beyond-origins/blob/indev/src/net/egartley/beyondorigins/gamestates/InGameState.java
 */
class InGameState extends GameState {

    InGameState() {
        identificationNumber = GameState.IN_GAME;
    }

    @Override
    public void render(Graphics graphics) {
        Field.render(graphics);
        UI.render(graphics);
    }

    @Override
    public void tick() {

    }

}