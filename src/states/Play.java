package states;

import entity.Entity;
import entity.MyCircle;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import utilities.Vector;

import java.util.ArrayList;

public class Play extends BasicGameState {

    private ArrayList<Entity> entities = new ArrayList<>();

    private long fps = 0;
    private int frames = 0;

    Input input;
    private int mouseX = 0, mouseY = 0;

    private Entity selectedEntity = null;

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        container.getGraphics().setBackground(Color.white);
        for(int i = 0; i < 20; i++) {
            entities.add(new MyCircle(container, (int) (Math.random() * container.getWidth()),
                    (int) (Math.random() * container.getHeight()), MyCircle.DEFAULT_RADIUS));
        }
        input = container.getInput();
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
//        g.scale(.1F, .1F);
        g.setAntiAlias(true);
        for(int i = 0; i < entities.size(); i++) {
            entities.get(i).render();
        }
        g.setColor(Color.black);
        g.drawString("" + (int) (fps / (float) frames), 10, 10);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        for(int i = 0; i < entities.size(); i++) {
            entities.get(i).update();
            entities.get(i).resetBackground();
            for(int j = 0; j < entities.size(); j++) {
                if(i != j) {
                    Vector direction = Vector.sub(entities.get(i).getPosition(),
                            entities.get(j).getPosition());
                    float distance = direction.getDistance();
                    if(distance <= entities.get(i).getRadius() + entities.get(j).getRadius()) {
//                        float overlap = ;
                    }
                }
            }
        }
        fps += container.getFPS();
        frames ++;
        if (input.isMousePressed(0)) {
            moveEntity();
        } else if (input.isMousePressed(1)) {
            selectEntity();
        }
        if (container.getInput().isKeyPressed(Input.KEY_SPACE)) {

        }
    }

    private void selectEntity() {
        for(Entity entity : entities) {
            double distance = Math.sqrt(Math.pow(input.getMouseX()
                    - entity.getPosition().x, 2) + Math.pow(input.getMouseY()
                    - entity.getPosition().y, 2));
            if(distance <= entity.getRadius()) {

                if(selectedEntity != null) {
                    selectedEntity.setSelected(false);
                }
                selectedEntity = entity;
                selectedEntity.setSelected(true);
            }
        }
    }

    private void moveEntity() {
        if(selectedEntity != null) {
            selectedEntity.setDestination(input.getMouseX(), input.getMouseY());
        }
    }

    @Override
    public int getID() {
        return 0;
    }
}
