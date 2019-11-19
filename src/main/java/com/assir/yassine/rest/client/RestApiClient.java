package com.assir.yassine.rest.client;

import com.assir.yassine.messenger.model.Message;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class RestApiClient {

    public static void main(String[] args) {

        Client client = ClientBuilder.newClient();

        WebTarget baseTarget = client.target("http://localhost:8080/advanced-jaxrs-01/webapi/");
        WebTarget messagesTarget = baseTarget.path("messages");
        WebTarget singleMessageTarget = messagesTarget.path("{messagesId}");

        Message message1 = singleMessageTarget
                .resolveTemplate("messagesId", "1")
                .request(MediaType.APPLICATION_JSON)
                .get(Message.class);

        Message message2 = singleMessageTarget
                .resolveTemplate("messagesId", "2")
                .request(MediaType.APPLICATION_JSON)
                .get(Message.class);

        System.out.println(message1.getMessage());
        System.out.println(message2.getMessage());
    }
}