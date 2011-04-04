/*
 * Copyright (c) Energeya.  All rights reserved. http://www.energeya.com
 */
package com.energeya.lab.springrmijobs;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.remoting.support.RemoteInvocation;
import org.springframework.remoting.support.RemoteInvocationFactory;


/**
 * @author carone
 * @version $Id: $
 */
public class JobRemoteInvocationFactory implements RemoteInvocationFactory
{
    /**
     * {@inheritDoc}
     */
    @Override
	public RemoteInvocation createRemoteInvocation(MethodInvocation methodInvocation)
    {
        JobRemoteInvocation tlc = new JobRemoteInvocation(methodInvocation);
        return tlc;
    }
}
