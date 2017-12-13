package persistence;

import java.io.IOException;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/example")
@Stateless
public class WSEndpoint {
	Logger log = Logger.getAnonymousLogger();
	@Resource
	ManagedExecutorService mes;

	@OnMessage
	public String receiveMessage(String message, Session session) {
		log.info("Received : " + message + ", session:" + session.getId());
		return "Response from the server";
	}

	@OnOpen
	public void open(Session session) {
		log.info("Open session:" + session.getId());
		final Session s = session;
		mes.execute(new Runnable() {
			@Override
			public void run() {
				try {
					for (int i = 0; i < 3; i++) {
						Thread.sleep(10000);
						s.getBasicRemote().sendText("Message from server");
					}
				} catch (InterruptedException | IOException e) {
					e.printStackTrace();
				}
			}
		});
	}

	@OnClose
	public void close(Session session, CloseReason c) {
		log.info("Closing:" + session.getId());
	}
}