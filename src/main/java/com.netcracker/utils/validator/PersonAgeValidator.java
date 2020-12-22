package com.netcracker.utils.validator;

import com.netcracker.contracts.Contract;

/**
 * class for validating contracts owner
 */
public class PersonAgeValidator implements Validator {

    /**
     * method for validate birthday on contract owner
     * @param contract - contract which owner need to be validate
     * @return message about validation status
     */
    @Override
    public Message validate(Contract contract) {
        String field = "Возраст";
        if ((contract.getStartingDate().getYear() - contract.getOwner().getBirthDay().getYear() > 18) ||
                (contract.getStartingDate().getYear() - contract.getOwner().getBirthDay().getYear() == 18 &&
                        ((contract.getOwner().getBirthDay().getMonthValue() < contract.getStartingDate().getMonthValue()) ||
                                (contract.getOwner().getBirthDay().getMonthValue() == contract.getStartingDate().getMonthValue() &&
                                        contract.getOwner().getBirthDay().getDayOfMonth() <= contract.getStartingDate().getDayOfMonth())))) {
                                    return new Message(field, Status.OK);
        }
        else {
            return new Message(field, Status.ERROR);
        }
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
