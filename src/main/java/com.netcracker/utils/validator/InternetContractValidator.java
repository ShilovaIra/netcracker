package com.netcracker.utils.validator;

import com.netcracker.contracts.Contract;
import com.netcracker.contracts.InternetContract;

/**
 * class for validating special contract info for Internet
 */
public class InternetContractValidator implements Validator {
    /**
     * method for validate special internet contract info
     * @param contract - contract which need to be validate
     * @return message about validation status
     */
    @Override
    public Message validate(Contract contract) {
        String field = "Special info for internet contract";
        int speed = ((InternetContract) contract).getSpeedConnection();
        if (speed <= 0 )
            return new Message(field, Status.ERROR);
        else
            return new Message(field, Status.OK);
    }

    /**
     * method for getting class
     * @return class of contract
     * @throws ClassNotFoundException in case when class not found
     */
    @Override
    public Class<?> getApplicableFor() throws ClassNotFoundException {
        return InternetContract.class;
    }
}
