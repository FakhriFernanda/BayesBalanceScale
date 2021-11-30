 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg19710102_bi;

/**
 *
 * @author user
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double faktaLeft = new bayes().FaktaLeft();
        double faktaBalance = new bayes().FaktaBalance();
        double faktaRight = new bayes().FaktaRight();
        
        System.out.println("tip to the right : "+faktaLeft);
        System.out.println("Balance : "+faktaBalance);
        System.out.println("tip to the right : "+faktaRight);
    }
    
}
