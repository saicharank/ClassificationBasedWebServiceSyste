/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;
import java.util.ArrayList;
import weka.classifiers.trees.J48;
import weka.classifiers.functions.Logistic;
import weka.classifiers.rules.NNge;
import weka.classifiers.meta.Vote;
import weka.*;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.core.Instances;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author saicharan
 */
public class WebServices {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        int seed=1;
        int folds = 10;
        
        BufferedReader reader = new BufferedReader(
                              new FileReader("C:\\Users\\saicharan\\Documents\\EGDownloads\\Media\\amazon\\train.arff"));
        
        Instances train = new Instances(reader);
        reader.close();
        
        BufferedReader reader1 = new BufferedReader(
                              new FileReader("C:\\Users\\saicharan\\Documents\\EGDownloads\\Media\\amazon\\test.arff"));
        
        Instances test = new Instances(reader1);
        reader1.close();
        
        train.setClassIndex(train.numAttributes()-1);
        J48 j = new J48();
        Logistic l= new Logistic();
        NNge n = new NNge();
        
        Vote v = new Vote();
        Classifier[] classifiers= { j  };
        
        System.out.println(args[0]);
        v.setClassifiers(classifiers);
        
        
        
        
        
        v.buildClassifier(train);
        
        
        Evaluation eval = new Evaluation(train);
        eval.evaluateModel(v, test);
        
      System.out.println(eval.toSummaryString("\nResults\n======\n", false));
       
    }
    
}
