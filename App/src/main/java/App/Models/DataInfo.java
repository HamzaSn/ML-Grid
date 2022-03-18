package App.Models;

import java.util.HashMap;

public class DataInfo {
    private static final DataInfo INSTANCE = new DataInfo();
    public static HashMap<String,Object> info = new HashMap<>();

   public static DataInfo getInstance(){
        return INSTANCE;
    }
}
