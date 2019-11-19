package com.assir.yassine.rest.client;

import com.assir.yassine.messenger.model.Message;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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

        Message newMessage = new Message(4, "My new message from JAX-RS client!", "assir");

        Response postResponse = messagesTarget
                .request()
                .post(Entity.json(newMessage));
        if (postResponse.getStatus() != 201) {
            System.out.println("Error");
        }
        Message createdMessage = postResponse.readEntity(Message.class);
        System.out.println(createdMessage.getMessage());
    }
}