import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class  Human <T extends HumanObject >  {


    public Human(String newName , String newSurName ){

        this.setName(newName);
        this.setSurname(newSurName);

        
    }



 private ArrayList <T>  humanObjects = new ArrayList<>();
 public ArrayList <T> getHumanObjects(){return humanObjects;}


 public abstract String addHumanObject();

 protected abstract void setHumanObject_();

 public void setHumanObjects(){

     if(this.getHumanObjects().size() == 0) {
         System.out.println("Изменение невозможны ! (Нет обьектов для изменения)");
         return;
     }

     if(this.getSelectHumanObject() < 0)
         this.SelectHumanObject();

     if(this.getSelectHumanObject() >  -1)
         this.setHumanObject_();

 };
 public void deleteHumanObject(){

     if(this.getHumanObjects().size() == 0) {
         System.out.println("Удаление невозможно ! (Нет обьектов для удаления)");
         return;
     }

     if(this.getSelectHumanObject() < 0)
         this.SelectHumanObject();

     if(this.getSelectHumanObject() > -1){
         System.out.println("Обьект удален :" + this.getHumanObjects().get(this.getSelectHumanObject()));
         this.getHumanObjects().remove(this.getSelectHumanObject());
         this.selectHumanObject = -1;

     }


 };
 public void deleteAllHumanObject(){

     this.getHumanObjects().clear();
     this.selectHumanObject = -1;
     System.out.println("Все обьекты удалены");

 };
 public  void SelectHumanObject(){

         int size = this.getHumanObjects().size();

         if(size < 1)
             System.out.println("Обьектов для выбора нет");
         else{

             try {
                 this.setSelectHumanObject(Human.paramInteger("Выбрать обьект : \n" + this.getAllObjectString()).intValue());
             }catch (NullPointerException e){ return;}
         }

 };
 public  void InfoAllHumanObject(){

 if(this.getHumanObjects().size() < 1)
    System.out.println("Нет обьектов для отображения :(");
 else {

     System.out.println(this.getAllObjectString());

 }
 };


 public String getAllObjectString(){


     if(this.getHumanObjects().size() < 1){
         System.out.println("Нет обьектов для отображения");
         return null;
     }

     String ret = "";
    for(int i = 0; i < this.getHumanObjects().size() ; i++){

    if(i > 0)
        ret += "\n";
    ret += "[" + i + "]" + this.getHumanObjects().get(i).toString();

    }

    System.out.println(ret);

return ret;
 }


    private int  selectHumanObject = -1;
    protected int getSelectHumanObject(){return selectHumanObject;}
    protected void setSelectHumanObject(int newSelect){
        if(newSelect <= -1) {
            selectHumanObject = -1;
            System.out.println("Отмена выбора");
        }else
        if(newSelect >= this.getHumanObjects().size())
            selectHumanObject = (this.getHumanObjects().size() - 1);
        else selectHumanObject = newSelect;

        if (selectHumanObject > -1)
        System.out.println("Выбран обект №" + selectHumanObject + ":" + this.getHumanObjects().get(selectHumanObject).toString());
    }


    public static final int MAN   = 1 ,
                            WOMAN = 2 ;

    @Override
    public String toString() {
    String s = "";

        for(int i = 0; i < this.getHumanObjects().size() ; i++){

           if(i > 0)
               s += "\n";
           s += this.getHumanObjects().get(i).toString();

           if(this.getSelectHumanObject() > -1
           && this.getSelectHumanObject() == i)
               s += " <Выбран>" ;

        }

        return s;
    }

    private String name ;
    public  String getName(){if(name != null)return name; return "Без имени";}
    public  void   setName(String newName){ if (newName == null) name = "Default" ; else name = newName;}

    private String surname ;
    public  String getSurname(){if(surname != null)return surname; return "Без имени";};
    public  void   setSurname(String newSurname){
        if (newSurname == null) surname = "Default" ; else surname = newSurname;}



    public static Human buldHuman(){
    Scanner sc = new Scanner(System.in);



    System.out.println("Создаем персонажа \n Введите имя :");
    String n = sc.nextLine();
        if(n == null || n.length() == 0)
            n = "Безымянный" ;

    System.out.println("Хорошо " +
            "\n Теперь введите фамилию : ");
    String n2 = sc.nextLine() ;
        if(n2 == null || n2.length() ==0)
            n2 = "БезФамильный" ;


    String M[] = new String[]{"1","Муж","Парень","М","Мальчик","муж","парень","м","мальчик"},
           W[] = new String[]{"Девушка","Женщина","Девочка","девушка","женщина","девочка","Ж","ж","2"};
    int indWar = 0;
    String sss = "";

    while (true) {

        switch (indWar) {
            case 0:
                System.out.println("Ок  " + "\n Теперь пол : \n // Введите [Мужчина , М.. , 1] [Женщина , Ж.. , 2]");
                indWar++;
                break;
            case 1:
                System.out.println("Пожалуста введите коретный пол : \n" + Human.MasToString(M) + Human.MasToString(W));
                indWar++;
                break;
            default:
                indWar++;
                break;
        }




        if(indWar < 3)
            sss = sc.nextLine();


        if (sss != null && sss.length() > 0) {
            if (Human.TrueName(sss, M)) return new Man(n, n2);

            if (Human.TrueName(sss, W)) return new Woman(n, n2);
        }

        if(indWar > 2) {
            System.out.println("Хорошо , пол выбран по умолчанию - Мужчина");
            sss = "М";
        }
    }



    }


    public static boolean TrueName(String s , String Filter[]){

        for(String ss : Filter){
               if(s.indexOf(ss) > -1)return true;

        }

    return false;
    }

    public static String MasToString(String [] m , String sp){
    String ret = "[";

    if(m == null) return "[ null ]" ;
        else
            for(int i = 0 ; i < m.length ; i++){
                if(i != 0)
                    ret += sp;
                ret += m[i];

            }
    return ret + "]";
    }
    public static String MasToString(String [] m){
        return Human.MasToString(m,",");
    }


    public static String paramString(String form){

        if(form == null)form = "";
        System.out.println(form);
        String text = new Scanner(System.in).nextLine();

        if(text.equals(Main.CANCEL)){
            System.out.println("<...Отмена...>");
            return null;
        }
        return text;
    }


    public static Integer paramInteger(String form){

        String s = paramString(form);
            if(s == null)
                return null;

        Integer ret = null;

        try {return Integer.valueOf(Integer.decode(s));}
        catch (Exception e){
            System.out.println("Введите коректный номер");
            return Human.paramInteger(form);

        }

    }


    public static Color paramColor(String form){


        try {
            int in[] = new int[]{Human.paramInteger(form + "\n Выберите номер для цвета 1...").intValue(), Human.paramInteger(" Выберите номер для цвета 2...").intValue(), Human.paramInteger(" Выберите номер для цвета 3...").intValue()};
           return new Color(in[0],in[1],in[2]);
        }catch (NullPointerException e){
            return null;
        }catch (IllegalArgumentException e2){

            System.out.println("Ошибка ввода параметра цвета (Цвет вне диапазона значений)");
            return paramColor(form);

        }





    }







}
