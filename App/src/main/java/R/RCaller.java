package R;

import com.github.rcaller.rstuff.RCode;

public class RCaller {

    com.github.rcaller.rstuff.RCaller caller = com.github.rcaller.rstuff.RCaller.create();
    RCode code = RCode.create();

    public void runR(String data_path, String target_var, Object[] chosen_vars) {
        StringBuilder x = new StringBuilder("c(");
        for (Object elem : chosen_vars) {
            x.append("\"").append(elem).append("\"").append(",");
        }
        x.deleteCharAt(x.length() - 1);
        x.append(")");

        code.addRCode("list_params <- list(" +
                "data_path = \"" + data_path + "\"," +
                "target_var = \"" + target_var + "\"," +
                "chosen_vars = " + x +
                ")");

        code.addRCode("run <- rmarkdown::render('./R/all_in_one.rmd', 'pdf_document' ,params = list_params)");
        caller.setRCode(code);
        caller.runAndReturnResult("run");

        System.out.println("java finished talking with R");
    }

}
