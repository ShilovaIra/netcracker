package com.netcracker.utils.validator;

import com.netcracker.contracts.Contract;

public interface Validator {
    public Message validate(Contract contract);
    public Class<?> getApplicableFor() throws ClassNotFoundException;
}
