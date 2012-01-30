/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2012, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.remoting3.security;

import java.io.IOException;
import java.security.Principal;
import java.util.Collection;

import javax.security.auth.callback.CallbackHandler;

/**
 * An extension so the CallbackHandler interface to allow for additional UserInfo to
 * be loaded to be associated with the current request.
 *
 * The AuthorizingCallbackHandler returned from the ServerAuthenticationProvider will be
 * retained with the connection and after the SASL based authentication has completed the
 * createUserInfo method will be called in the same instance.
 *
 * @author <a href="mailto:darran.lofthouse@jboss.com">Darran Lofthouse</a>
 */
public interface AuthorizingCallbackHandler extends CallbackHandler {

    /**
     * Create and return the UserInfo instance for the user identified by the
     * provided remoting principals.
     *
     * @param remotingPrincipals - The principals already created based on the authentication.
     * @return The new UserInfo instance.
     */
    public UserInfo createUserInfo(final Collection<Principal> remotingPrincipals) throws IOException;

}
