package com.elice.project.ch1105.practice3.common.exception;

import com.elice.project.ch1105.practice3.common.enums.ErrorCode;

public class DataNotFoundException extends RootException {
    public DataNotFoundException() {
        super(ErrorCode.DATA_NOT_FOUND.getDetailMessage());
    }
}
