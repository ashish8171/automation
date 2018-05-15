package com.inwizards.automation.deployment;

import com.inwizards.automation.base.BaseRequest;

import java.util.UUID;

public class DeploymentRequest extends BaseRequest {

    private UUID deploymentUnitId;

    public UUID getDeploymentUnitId() {
        return deploymentUnitId;
    }

    public void setDeploymentUnitId(UUID deploymentUnitId) {
        this.deploymentUnitId = deploymentUnitId;
    }
}
