package com.inwizards.automation.base;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

public class BaseRequest implements Serializable {
    private static final long serialVersionUID = 8775051980610064821L;

    private UUID id;
    @NotNull
    private String name;

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
}