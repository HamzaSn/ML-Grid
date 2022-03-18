package R;

import App.Models.DataInfo;
import javafx.concurrent.Task;
import javafx.scene.chart.PieChart;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class RTask extends Task {

    boolean success = false;

    @Override
    protected Object call() throws Exception {

        RCaller R = new RCaller();


        try{
            R.runR((String) DataInfo.info.get("dataPath"), (String) DataInfo.info.get("targetVar"),
                    (Object[]) DataInfo.info.get("chosen_vars"));
            success = true;

        } catch (Exception e){
            System.out.println("R or Python error");
            e.printStackTrace();
        }

        return success;
    }
}
