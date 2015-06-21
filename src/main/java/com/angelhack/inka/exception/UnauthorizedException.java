package com.angelhack.inka.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Askhat_Shagirov on 21-Jun-15.
 */
@ResponseStatus(value= HttpStatus.UNAUTHORIZED, reason="Not authorized")
public class UnauthorizedException extends Exception {
}
