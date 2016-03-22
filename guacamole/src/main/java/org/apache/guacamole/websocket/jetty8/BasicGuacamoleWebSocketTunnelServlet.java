/*
 * Copyright (C) 2013 Glyptodon LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package org.apache.guacamole.websocket.jetty8;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.apache.guacamole.GuacamoleException;
import org.apache.guacamole.net.GuacamoleTunnel;
import org.apache.guacamole.TunnelRequestService;
import org.apache.guacamole.TunnelRequest;

/**
 * Tunnel servlet implementation which uses WebSocket as a tunnel backend,
 * rather than HTTP, properly parsing connection IDs included in the connection
 * request.
 */
@Singleton
public class BasicGuacamoleWebSocketTunnelServlet extends GuacamoleWebSocketTunnelServlet {

    /**
     * Service for handling tunnel requests.
     */
    @Inject
    private TunnelRequestService tunnelRequestService;
 
    @Override
    protected GuacamoleTunnel doConnect(TunnelRequest request)
            throws GuacamoleException {
        return tunnelRequestService.createTunnel(request);
    }

}