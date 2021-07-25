import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import states.Play;

public class Main extends StateBasedGame {

    public Main(String name) {
        super(name);
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        addState(new Play());
        enterState(0);
    }

    public static void main(String[] args) {
        try {
            AppGameContainer app = new AppGameContainer(new Main("Game"));
            app.setTargetFrameRate(60);
            app.setShowFPS(false);
            app.setDisplayMode(1366, 768, false);
            app.start();
        } catch(SlickException e) {
            e.printStackTrace();
        }
    }
}
