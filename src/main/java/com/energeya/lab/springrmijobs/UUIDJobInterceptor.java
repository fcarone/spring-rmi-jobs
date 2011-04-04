/*
 * Copyright (c) Openmind.  All rights reserved. http://www.openmindonline.it
 */
package com.energeya.lab.springrmijobs;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


/**
 * @author agagliardi
 * @version $Id: $
 */
public class UUIDJobInterceptor implements MethodInterceptor
{

    /**
     * {@inheritDoc}
     */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable
    {
        UUIDJobHolder.initUUIDJob();
        return invocation.proceed();
    }

}
