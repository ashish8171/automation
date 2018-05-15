package com.inwizards.automation.base;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class BaseDeployment implements Serializable {
    private static final long serialVersionUID = 2356435639435362768L;

    private UUID id = UUID.randomUUID();
    private String name;
    private Long createdOn = new Date().getTime();
    private Long updatedOn;

    public BaseDeployment(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Long createdOn) {
        this.createdOn = createdOn;
    }

    public Long getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Long updatedOn) {
        this.updatedOn = updatedOn;
    }
}