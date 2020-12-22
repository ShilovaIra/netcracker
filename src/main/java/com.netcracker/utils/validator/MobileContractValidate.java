package com.netcracker.utils.validator;

import com.netcracker.contracts.Contract;
import com.netcracker.contracts.MobileContract;

/**
 * class for validating special info for Mobile contract
 */
public class MobileContractValidate implements Validator {

    /**
     * method for validate special mobile contract info
     * @param contract - contract which need to be validate
     * @return message about validation status
     */
    @Override
    public Message validate(Contract contract) {
        String field = "Special info for mobile contract";
        int sms = ((MobileContract) contract).getSmsNumber();
        int gb = ((MobileContract) contract).getGbNumber();
        int minutes = ((MobileContract) contract).getMinutesNumber();
        if (sms<0 || gb<0 || minutes<0)
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
        return MobileContract.class;
    }
}
