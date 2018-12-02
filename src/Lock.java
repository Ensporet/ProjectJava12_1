public class Lock {



    public Lock(String key , int id,String description){
        setId(id);
        setKey(key);
        setDescription(description);
    }
    public Lock(String key , int id){
        setId(id);
        setKey(key);
    }

    private String description = "";
    private void   setDescription(String s){if(s == null)description = ""; else description = s;}
    public  String getDescription(){return description;}

    private  String key ;
    private  void   setKey(String k){key = k;};
    public   String getKey(){return key;}

    private  int    id  ;
    private  void   setId(int i){if(i < 0)id = 0 ;else id = i;}
    public   int    getId(){return id;}

    public boolean Trues(String k){

        if(k == null || k.length() == 0 || k.indexOf(key) < 0)
            return false ;

            return true;


    }
}
