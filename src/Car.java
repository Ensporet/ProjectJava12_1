import java.awt.*;

public class Car extends HumanObject {


    public Car(String name, Color color, int level) {
        super(name, color, level);
    }

    @Override
    public String getType() {
        return "Машина";
    }
}
