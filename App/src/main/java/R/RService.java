package R;

import R.RTask;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class RService extends Service {

    @Override
    protected Task createTask() {
        RTask rTask = new RTask();
        return rTask;
    }
}
