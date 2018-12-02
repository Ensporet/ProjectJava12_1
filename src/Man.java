import java.awt.*;
import java.util.Scanner;

public class Man extends Human<Car> {


    public Man(String newName, String newSurName) {
        super(newName, newSurName);
    }

    @Override
    public String addHumanObject() {



        String n = Human.paramString("Создание Машины : \n Введите имя ...");
            if(n == null)return null;
        Integer i = Human.paramInteger(" Выберите уровень...");
            if(n == null)return null;
        Color color = Human.paramColor(" Выберите цвет:");
            if(color == null)
                return null;

        this.getHumanObjects().add(new Car(n,color,i));
        System.out.println("Создана новая машина");
        this.setSelectHumanObject( (this.getHumanObjects().size() -1) );








        //Car car = new Car();



        return null;
    }

    @Override
    protected void setHumanObject_() {


        try {
            boolean bool = false;
            do{
            bool = false;
            switch (Human.paramInteger("Выберете параметр для изменения машины:" +
                    "\n[0] : Имя " + "(" + this.getHumanObjects().get(this.getSelectHumanObject()).getName() + ")" +
                    "\n[1] : Уровень" + "(" + this.getHumanObjects().get(this.getSelectHumanObject()).getLevel() + ")" +
                    "\n[2] : Цвет" + "(" + this.getHumanObjects().get(this.getSelectHumanObject()).getColor() + ")")) {

                case 0 :
                    String ns = Human.paramString("Новое имя...");
                        if(ns == null)return;
                    String olS = this.getHumanObjects().get(getSelectHumanObject()).getName();
                    this.getHumanObjects().get(this.getSelectHumanObject()).setName(ns);
                    System.out.println("Успех изменения ! [" +olS +"] >>> [" +this.getHumanObjects().get(getSelectHumanObject()).getName() +"]");
                        return;
                case 1 :
                    Integer i = Human.paramInteger(" Выберите новый уровень...");
                        if (i == null) return;
                    int olI = this.getHumanObjects().get(this.getSelectHumanObject()).getLevel();
                    this.getHumanObjects().get(this.getSelectHumanObject()).setLevel(i.intValue());
                    System.out.println("Успех изменения ! [" +olI +"] >>> [" +this.getHumanObjects().get(getSelectHumanObject()).getLevel() +"]");
                        return;
                case 2:
                    Color color = Human.paramColor(" Выберите новый цвет:");
                        if(color == null)return;
                    Color olC = this.getHumanObjects().get(this.getSelectHumanObject()).getColor();
                    this.getHumanObjects().get(this.getSelectHumanObject()).setColor(color);
                    System.out.println("Успех изменения ! [" +olC +"] >>> [" +this.getHumanObjects().get(getSelectHumanObject()).getColor() +"]");
                        return;

                default:
                    bool = true;
                    break;


            }}while (bool);
        } catch (NullPointerException e) {
            return;
        }
    }
    @Override
    public String toString() {
        return "Мужчина " + getName() +" " + getSurname() + "\n" + super.toString();
    }









}
