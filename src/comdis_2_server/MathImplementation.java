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
        Random random = new Random();
        double k,w;
        for (int j = 0; j < pairs; j++) {
            k = random.nextDouble();
            w = random.nextDouble();
            if( (k * k) + (w * w) <= 1 )
                validated++;
        }
        return validated;
    }
} // end class
