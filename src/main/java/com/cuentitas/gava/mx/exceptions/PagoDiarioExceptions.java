package com.cuentitas.gava.mx.exceptions;

import org.apache.commons.lang.exception.NestableException;

public class PagoDiarioExceptions extends NestableException{
    public PagoDiarioExceptions(String msg) {
		super(msg);
	}
}
