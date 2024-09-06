package com.elice.project.ch1105.practice3;

public class DataNotFoundException extends RootException {
    public DataNotFoundException() {
        super(ErrorCode.DATA_NOT_FOUND.getDetailMessage());
    }
}
