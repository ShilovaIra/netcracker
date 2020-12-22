package com.netcracker.utils.validator;

import com.netcracker.contracts.Contract;

/**
 * class for validating contract date
 */
public class ContractDateValidator implements Validator {
    /**
     * method for validate contract date
     * @param contract - contract than need to be validate
     * @return message about validation status
     */
    @Override
    public Message validate(Contract contract) {
        String field = "Contract date";
        if (contract.getStartingDate().isAfter(contract.getEndingDate())) {
            return new Message(field, Status.ERROR);
        } else
            return new Message(field, Status.OK);

    }

    /**
     * method for getting class
     * @return class of contract
     * @throws ClassNotFoundException in case when class not found
     */
    @Override
    public Class<?> getApplicableFor() throws ClassNotFoundException {
        return Contract.class;
    }
}
