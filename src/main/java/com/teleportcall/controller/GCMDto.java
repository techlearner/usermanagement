package com.teleportcall.controller;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by ssenthilkumar 04 march 2016
 */
public class GCMDto {

    private String collapseKey;

    private Integer timeToLive = 108;

    private Boolean delayWhileIdle = true;

    private Object data;

    private List<String> registrationIds;

    @JsonProperty("collapse_key")
    public String getCollapseKey() {
        return collapseKey;
    }

    public void setCollapseKey(String collapseKey) {
        this.collapseKey = collapseKey;
    }

    @JsonProperty("time_to_live")
    public Integer getTimeToLive() {
        return timeToLive;
    }

    public void setTimeToLive(Integer timeToLive) {
        this.timeToLive = timeToLive;
    }

    @JsonProperty("delay_while_idle")
    public Boolean getDelayWhileIdle() {
        return delayWhileIdle;
    }

    public void setDelayWhileIdle(Boolean delayWhileIdle) {
        this.delayWhileIdle = delayWhileIdle;
    }

    @JsonProperty("data")
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @JsonProperty("registration_ids")
    public List<String> getRegistrationIds() {
        return registrationIds;
    }

    public void setRegistrationIds(List<String> registrationIds) {
        this.registrationIds = registrationIds;
    }
}
