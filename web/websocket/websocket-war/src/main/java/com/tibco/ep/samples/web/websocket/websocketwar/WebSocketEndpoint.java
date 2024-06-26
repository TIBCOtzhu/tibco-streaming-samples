/* *****************************************************************************
 Copyright (c) 2020-2023 Cloud Software Group, Inc.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions are met:

 1. Redistributions of source code must retain the above copyright notice,
 this list of conditions and the following disclaimer.

 2. Redistributions in binary form must reproduce the above copyright notice,
 this list of conditions and the following disclaimer in the documentation
 and/or other materials provided with the distribution.

 3. Neither the name of the copyright holder nor the names of its contributors
 may be used to endorse or promote products derived from this software
 without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 POSSIBILITY OF SUCH DAMAGE.
 */

package com.tibco.ep.samples.web.websocket.websocketwar;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * Provides a simple sample of WebSocket endpoint
 */
@ServerEndpoint("/test")
public class WebSocketEndpoint {

    /**
     * When a user tries to initiated a new WebSocket connection, this method is invoked and sends a
     * response message saying "Connection Established".
     *
     * @param session current session
     */
    @OnOpen
    public void onOpen(Session session) throws IOException {
        session.getBasicRemote().sendText("Connection Established"); //$NON-NLS-1$
    }

    /**
     * When a user sends a message to the server, this method intercepts the message
     * as a String and sends a response message with "Received message:" prefix and
     * received message.
     *
     * @param message received message
     * @param session current session
     */
    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        session.getBasicRemote().sendText("Received message: " + message); //$NON-NLS-1$
    }

    /**
     * The user closes the connection.
     *
     * @param session current session
     */
    @OnClose
    public void onClose(Session session) throws IOException {
        session.getBasicRemote().sendText("Connection is close"); //$NON-NLS-1$
    }

    /**
     * Gets called when an error occurs on the WebSocket
     *
     * @param t throwable t
     */
    @OnError
    public void onError(Throwable t) throws Throwable {
        throw t;
    }
}

