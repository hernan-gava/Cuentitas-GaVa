package com.cuentitas.gava.mx.exceptions;

import org.apache.commons.lang.exception.NestableException;

public class InversionInicial extends NestableException{
    public InversionInicial(String msg) {
		super(msg);
	}
}
