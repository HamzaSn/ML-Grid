package App.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class IDEController {



    @FXML
    private ImageView imagePlaceHolder;
    @FXML
    private Button nNeighborsKNN;
    @FXML
    private Button leafSizeKNN;
    @FXML
    private Button catEncoderKNN;
    @FXML
    private Button numScalerKNN;
    @FXML
    private Button imputerKNN;
    @FXML
    private Button algorithmKNN;
    @FXML
    private Button weightKNN;
    @FXML
    private Button catEncoderRF;
    @FXML
    private Button numScalerRF;
    @FXML
    private Button imputerRF;
    @FXML
    private Button bootstrapRF;
    @FXML
    private Button maxFeaturesRF;
    @FXML
    private Button criterionRF;
    @FXML
    private Button nEstimatorsRF;
    @FXML
    private Button CLR;
    @FXML
    private Button catEncoderLR;
    @FXML
    private Button numScalerLR;
    @FXML
    private Button imputerLR;
    @FXML
    private Button solverLR;
    @FXML
    private Button multiclassLR;
    @FXML
    private Button solverNN;
    @FXML
    private Button learningRateNN;
    @FXML
    private Button activationNN;
    @FXML
    private Button hiddenLayerSizeNN;
    @FXML
    private Button catEncoderNN;
    @FXML
    private Button numScalerNN;
    @FXML
    private Button imputerNN;
    @FXML
    private Button imputerSVC;
    @FXML
    private Button CSVC;
    @FXML
    private Button gammaSVC;
    @FXML
    private Button kernelSVC;
    @FXML
    private Button coef0SVC;
    @FXML
    private Button catEncoderSVC;
    @FXML
    private Button numScalerSVC;
    @FXML
    private Button shrinkingSVC;
    @FXML
    private Button probabilitySVC;
    @FXML
    private Button bestParamsKNN;
    @FXML
    private Button bestParamsLR;
    @FXML
    private Button bestParamsRF;
    @FXML
    private Button bestParamsMLP;
    @FXML
    private Button bestParamsSVC;
    @FXML
    private Button bestParamsALL;
    @FXML
    private TextArea bestParamsPlaceHolder;


    private String getBestParams(String model) throws IOException {

        File file = new File(last_instance_path+"/models_params/"+ model +"_best_params.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        StringBuilder message = new StringBuilder();
        String curr_line = br.readLine() ;
        while (curr_line != null){
            curr_line = curr_line + "\n" ;
            message.append(curr_line);
            curr_line = br.readLine();
        }
        return  message.toString();
    }
    private Image getResultImage(String model, String name)  {

        File file = new File(last_instance_path+"/images/"+ model +"/"+name+".png");
        bestParamsPlaceHolder.setVisible(false);
        imagePlaceHolder.setVisible(true);
        return new Image(file.toURI().toString());
    }

    private ArrayList<Button> KNNButtons;
    private ArrayList<Button> RFButtons;
    private ArrayList<Button> LRButtons;
    private ArrayList<Button> NNButtons;
    private ArrayList<Button> SVCButtons;
    private ArrayList<Button> ALLButtons;
    private ArrayList<ArrayList<Button>> options;
    private String last_instance_path;
    @FXML
    private void initialize() throws IOException {
        File last_instance_file = new File("./last_instance.txt");
        BufferedReader br = new BufferedReader(new FileReader(last_instance_file));
        last_instance_path = br.readLine().replace("../","");
        ALLButtons = new ArrayList<>();
        ALLButtons.add(bestParamsALL);
        SVCButtons = new ArrayList<>(Arrays.asList(
                bestParamsSVC,
                imputerSVC,
                numScalerSVC,
                catEncoderSVC,
                gammaSVC,
                coef0SVC,
                kernelSVC,
                CSVC,
                shrinkingSVC,
                probabilitySVC
        ));
        KNNButtons = new ArrayList<>(Arrays.asList(
                bestParamsKNN,
                nNeighborsKNN,
                leafSizeKNN,
                catEncoderKNN,
                numScalerKNN,
                imputerKNN,
                algorithmKNN,
                weightKNN
        ));
        RFButtons = new ArrayList<>(Arrays.asList(
                bestParamsRF,
                catEncoderRF,
                numScalerRF,
                imputerRF,
                bootstrapRF,
                maxFeaturesRF,
                criterionRF,
                nEstimatorsRF
        ));
        LRButtons = new ArrayList<>(Arrays.asList(
                bestParamsLR,
                catEncoderLR,
                numScalerLR,
                imputerLR,
                CLR,
                solverLR,
                multiclassLR
        ));
        NNButtons = new ArrayList<>(Arrays.asList(
                bestParamsMLP,
                catEncoderNN,
                numScalerNN,
                imputerNN,
                activationNN,
                hiddenLayerSizeNN,
                learningRateNN,
                solverNN

        ));
        options = new ArrayList<>(Arrays.asList(
                ALLButtons,
                SVCButtons,
                KNNButtons,
                RFButtons,
                LRButtons,
                NNButtons));


    }

    @FXML
    private void KNN(){
        for(ArrayList<Button> list : options){
            if(list.get(0).isVisible()){
                list.forEach((element) -> element.setVisible(false));
                break;
            }
        }

        KNNButtons.forEach((k) -> k.setVisible(true));

    }
    @FXML
    private void RF(){

        for(ArrayList<Button> list : options){
            if(list.get(0).isVisible()){
                list.forEach((element) -> element.setVisible(false));
                break;
            }
        }

        RFButtons.forEach((k) -> k.setVisible(true));

    }

    @FXML
    private void LR(){
        for(ArrayList<Button> list : options){
            if(list.get(0).isVisible()){
                list.forEach((element) -> element.setVisible(false));
                break;
            }
        }

        LRButtons.forEach((k) -> k.setVisible(true));
    }

    @FXML
    private void NN(){
        for(ArrayList<Button> list : options){
            if(list.get(0).isVisible()){
                list.forEach((element) -> element.setVisible(false));
                break;
            }
        }

        NNButtons.forEach((k) -> k.setVisible(true));
    }
    @FXML
    private void SVC() {
        for(ArrayList<Button> list : options){
            if(list.get(0).isVisible()){
                list.forEach((element) -> element.setVisible(false));
                break;
            }
        }

        SVCButtons.forEach((k) -> k.setVisible(true));
    }

    @FXML
    private void ALL() {
        for(ArrayList<Button> list : options){
            if(list.get(0).isVisible()){
                list.forEach((element) -> element.setVisible(false));
                break;
            }
        }
        File file = new File(last_instance_path+"/images/allModels.png");
        Image image = new Image(file.toURI().toString());
        imagePlaceHolder.setImage(image);
        bestParamsALL.setVisible(true);
    }
    


    @FXML
    private void showNKNN(){
        imagePlaceHolder.setImage(
                getResultImage("knn","param_model__n_neighbors"));

    }


    @FXML
    private void showLeafSizeKNN() {
        imagePlaceHolder.setImage(
                getResultImage("knn","param_model__leaf_size"));
    }

    @FXML
    private void showCatEncoderKNN() {
        imagePlaceHolder.setImage(
                getResultImage("knn","param_preprocessor__cat__encoder"));
    }

    @FXML
    private void showNumScalerKNN() {
        imagePlaceHolder.setImage(
                getResultImage("knn","param_preprocessor__num__scaler"));
    }

    @FXML
    private void showImputerKNN() {
        imagePlaceHolder.setImage(
                getResultImage("knn","param_preprocessor__num__imputer"));
    }

    @FXML
    private void showAlgorithmKNN() {
        imagePlaceHolder.setImage(
                getResultImage("knn","param_model__algorithm"));
    }

    @FXML
    private void showWeightKNN() {
        imagePlaceHolder.setImage(
                getResultImage("knn","param_model__weights"));
    }



    @FXML
    private void showCatEncoderRF(){
        imagePlaceHolder.setImage(
                getResultImage("rf","param_preprocessor__cat__encoder"));
    }

    @FXML
    private void showNumScalerRF() {
        imagePlaceHolder.setImage(
                getResultImage("rf","param_preprocessor__num__scaler"));
    }


    @FXML
    private void showImputerRF() {
        imagePlaceHolder.setImage(
                getResultImage("rf","param_preprocessor__num__imputer"));
    }

    @FXML
    private void showBootstrapRF() {
        imagePlaceHolder.setImage(
                getResultImage("rf","param_model__bootstrap"));
    }

    @FXML
    private void showMaxFeaturesRF() {
        imagePlaceHolder.setImage(
                getResultImage("rf","param_model__max_features"));
    }

    @FXML
    private void showCriterionRF() {
        imagePlaceHolder.setImage(
                getResultImage("rf","param_model__criterion"));
    }

    @FXML
    private void showNEstimatorsRF() {
        imagePlaceHolder.setImage(
                getResultImage("rf","param_model__n_estimators"));
    }

    @FXML
    private void showCatEncoderLR() {
        imagePlaceHolder.setImage(
                getResultImage("lr","param_preprocessor__cat__encoder"));
    }

    @FXML
    private void showNumScalerLR() {
        imagePlaceHolder.setImage(
                getResultImage("lr","param_preprocessor__num__scaler"));
    }

    @FXML
    private void showImputerLR() {
        imagePlaceHolder.setImage(
                getResultImage("lr","param_preprocessor__num__imputer"));
    }

    @FXML
    private void showCLR() {
        imagePlaceHolder.setImage(
                getResultImage("lr","param_model__C"));
    }

    @FXML
    private void showSolverLR() {
        imagePlaceHolder.setImage(
                getResultImage("lr","param_model__solver"));
    }

    @FXML
    private void showMulticlassLR() {
        imagePlaceHolder.setImage(
                getResultImage("lr","param_model__solver"));
    }

    @FXML
    private void showSolverNN() {
        imagePlaceHolder.setImage(
                getResultImage("mlp","param_model__solver"));
    }

    @FXML
    private void showLearningRateNN() {
        imagePlaceHolder.setImage(
                getResultImage("mlp","param_model__learning_rate"));
    }

    @FXML
    private void showActivationNN() {
        imagePlaceHolder.setImage(
                getResultImage("mlp","param_model__learning_rate"));
    }

    @FXML
    private void showHiddenLayerSizeNN() {
        imagePlaceHolder.setImage(
                getResultImage("mlp","param_model__hidden_layer_sizes"));
    }

    @FXML
    private void showCatEncoderNN() {
        imagePlaceHolder.setImage(
                getResultImage("mlp","param_preprocessor__cat__encoder"));
    }

    @FXML
    private void showNumScalerNN() {
        imagePlaceHolder.setImage(
                getResultImage("mlp","param_preprocessor__num__scaler"));
    }

    @FXML
    private void showImputerNN() {
        imagePlaceHolder.setImage(
                getResultImage("mlp","param_preprocessor__num__imputer"));
    }


    @FXML
    private void showImputerSVC() {
        imagePlaceHolder.setImage(
                getResultImage("svc","param_preprocessor__num__imputer"));
    }

    @FXML
    private void showCatEncoderSVC() {
    }

    @FXML
    private void showNumScalerSVC() {
        imagePlaceHolder.setImage(
                getResultImage("svc","param_preprocessor__num__scaler"));
    }
    @FXML
    private void showCSVC() {
        imagePlaceHolder.setImage(
                getResultImage("svc","param_model__C"));
    }

    @FXML
    private void showGammaSVC() {
        imagePlaceHolder.setImage(
                getResultImage("svc","param_model__gamma"));
    }

    @FXML
    private void showKernelSVC() {
        imagePlaceHolder.setImage(
                getResultImage("svc","param_model__kernel"));
    }

    @FXML
    private void showCoef0SVC() {
        imagePlaceHolder.setImage(
                getResultImage("svc","param_model__coef0"));
    }

    @FXML
    private void showShrinkingSVC() {
        imagePlaceHolder.setImage(
                getResultImage("svc","param_model__shrinking"));
    }

    @FXML
    private void showProbabilitySVC() {
        imagePlaceHolder.setImage(
                getResultImage("svc","param_model__probability"));
    }

    @FXML
    private void showBestParamsKNN() throws IOException {
        imagePlaceHolder.setVisible(false);
        bestParamsPlaceHolder.setVisible(true);
        bestParamsPlaceHolder.setText(getBestParams("knn"));
    }

    @FXML
    private void showBestParamsLR() throws IOException {
        imagePlaceHolder.setVisible(false);
        bestParamsPlaceHolder.setVisible(true);
        bestParamsPlaceHolder.setText(getBestParams("lr"));
    }

    @FXML
    private void showBestParamsRF() throws IOException {
        imagePlaceHolder.setVisible(false);
        bestParamsPlaceHolder.setVisible(true);
        bestParamsPlaceHolder.setText(getBestParams("rf"));
    }

    @FXML
    private void showBestParamsMLP() throws IOException {
        imagePlaceHolder.setVisible(false);
        bestParamsPlaceHolder.setVisible(true);
        bestParamsPlaceHolder.setText(getBestParams("mlp"));
    }

    @FXML
    private void showBestParamsSVC() throws IOException {
        imagePlaceHolder.setVisible(false);
        bestParamsPlaceHolder.setVisible(true);
        bestParamsPlaceHolder.setText(getBestParams("svc"));
    }

    @FXML
    private void showBestParamsALL() throws IOException {
        imagePlaceHolder.setVisible(false);
        bestParamsPlaceHolder.setVisible(true);
        bestParamsPlaceHolder.setText(getBestParams("all"));
    }
}
