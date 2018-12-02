import java.awt.*;

public class Pomade extends HumanObject {


    public Pomade(String name, Color color, int level) {
        super(name, color, level);
    }

    @Override
    public String getType() {
        return "Помада";
    }
}
