package com.netcracker.utils.validator;

import com.netcracker.contracts.ChannelPackage;
import com.netcracker.contracts.Contract;
import com.netcracker.contracts.TelevisionContract;

/**
 * class for validating special info for TV contract
 */
public class TelevisionContractValidate implements Validator {
    /**
     * method for validate special TV contract info
     * @param contract - contract which need to be validate
     * @return message about validation status
     */
    @Override
    public Message validate(Contract contract) {
        String field = "Special info for TV contract";
        ChannelPackage channelPackage = ((TelevisionContract)contract).getChannelPackage();

        if (channelPackage.equals(ChannelPackage.NIGHT) || channelPackage.equals(ChannelPackage.BASE)
                || channelPackage.equals(ChannelPackage.CHILD) || channelPackage.equals(ChannelPackage.EXTRA)
                || channelPackage.equals(ChannelPackage.ULTRAHD)) {
            return new Message(field,Status.OK);
        } else {
            return new Message(field,Status.ERROR);
        }
    }

    /**
     * method for getting class
     * @return class of contract
     * @throws ClassNotFoundException in case when class not found
     */
    @Override
    public Class<?> getApplicableFor() throws ClassNotFoundException {
        return TelevisionContract.class;
    }
}
