import java.awt.*;

public abstract class HumanObject {

    public HumanObject(String name , Color color , int level){

        setName(name);
        setColor(color);
        setLevel(level);

    };



    public abstract String getType();


    @Override
    public String toString() {
        String s =" Name :" + getName() +","+ "Color:" + getColor()+"," + "Level:" +getLevel() + ")";



        return s;
    }

    private String name = "" ;
public String getName(){return name;}
public void setName(String newName){if(newName == null)name = ""; else name = newName ;}

private Color color;
public Color getColor(){return color;}
public void setColor(Color newColor){color = newColor;}

private int level ;
public int getLevel(){return level;};
public void setLevel(int newLevel){if(newLevel < 0)level = 0; else level = newLevel;}




}
