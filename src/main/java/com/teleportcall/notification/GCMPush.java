package com.teleportcall.notification;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.teleportcall.model.GcmNotificationType;
import com.teleportcall.util.UserException;

/**
 * ssenthilkumar 03 march 2016.
 */
@Component
public class GCMPush {

    @Value("${gcm.url}")
    private String gcmUrl;

    @Async
    public Boolean pushToGcm(Object data, GcmNotificationType type, String apiKey) throws UserException {

        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost post = new HttpPost(gcmUrl);
        post.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        post.setHeader(HttpHeaders.AUTHORIZATION, "key=" + apiKey);
        post.setHeader("X-Message-Type", type.toString());
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(data);
            post.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
            HttpResponse response = httpClient.execute(post);
            String responseString = new String(generateBytes(response));
            System.out.println("Push JSON: " + json + " ####  Push JSON Response: " + responseString);
            HashMap<String, Object> result = mapper.readValue(responseString, HashMap.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new UserException(e.getMessage(), e.getMessage(), null, null);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new UserException(e.getMessage(), e.getMessage(), null, null);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            throw new UserException(e.getMessage(), e.getMessage(), null, null);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UserException(e.getMessage(), e.getMessage(), null, null);
        }
        return true;
    }

    private byte[] generateBytes(HttpResponse response)
            throws IllegalStateException, IOException {

        if ((null != response) && (null != response.getEntity())) {

            InputStream inputStream = response.getEntity().getContent();

            return org.apache.commons.io.IOUtils.toByteArray(inputStream);
        }

        throw new IOException();
    }
}
