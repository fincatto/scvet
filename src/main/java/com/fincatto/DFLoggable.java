package com.fincatto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface DFLoggable {

    default Logger getLogger() {
        return LoggerFactory.getLogger(getClass());
    }

    static Logger getLogger(Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }
}
