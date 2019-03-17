package com.demo.utils;

import com.demo.exception.BadRequestException;
import com.demo.exception.EntityAlreadyExistsException;
import com.demo.exception.EntityNotFoundException;

public class ExceptionUtils {

  public static void throwEntityAlreadyExistsException(String message) {
    throw new EntityAlreadyExistsException(message);
  }

  public static void throwEntityNotFoundException(String message) {
    throw new EntityNotFoundException(message);
  }

  public static void throwBadRequestException(String message) {
    throw new BadRequestException(message);
  }
}
