package comdis_2_server;

import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * This class implements the remote interface HelloInterface.
 *
 * @author M. L. Liu
 */
public class MathImplementation extends UnicastRemoteObject implements MathInterface {

    public MathImplementation() throws RemoteException {
        super();
    }

    @Override
    public long validatePairs(Long pairs){
        long validated = 0;
        Random random = new Random(1102243);
        ArrayList<Double[]> pairsList = new ArrayList<Double[]>(pairs.intValue());
        Double[] aux = new Double[2];
        for (int j = 0; j < pairs; j++) {
            aux[0] = random.nextDouble();
            aux[1] = random.nextDouble();
            pairsList.add(aux.clone());
        }
        //Last iterat
        for (Double[] pair : pairsList) {
            if( (pair[0] * pair[0]) + (pair[1] * pair[1]) <= 1 )
                validated++;
        }
        return validated;
    }
} // end class
