package com.student.student_information_system.exception;

import org.springframework.dao.DataAccessException;

public class RepositoryException extends RuntimeException {
    public RepositoryException(final String message) {
        super(message);
    }

    public RepositoryException(final String message, final DataAccessException cause){
        super(message, cause);
    }

}
