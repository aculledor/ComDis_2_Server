/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comdis_2_server;

import java.rmi.Naming;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aculledor
 */
public class MathHilo extends Thread{
    
    private final Long pairs;
    private Long result;
    private final String registry;
    
    public MathHilo(String name, Long pairs, String registry){
        super(name);
        this.pairs = pairs;
        this.registry = registry;
        this.result = new Long(0);
    }
    
    @Override
    public void run(){
        MathInterface h;
        try {
            h = (MathInterface) Naming.lookup(this.registry);
            this.result = h.validatePairs(this.pairs);
            System.out.println("MathClient: " + this.result);
        } catch (Exception ex) {
            Logger.getLogger(MathHilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Long getResult() {
        return result;
    }
    
    
}
