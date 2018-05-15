package com.inwizards.automation.domain;

import com.inwizards.automation.base.BaseDeployment;
import com.inwizards.automation.constants.Action;
import com.inwizards.automation.constants.Status;

import java.util.HashSet;
import java.util.Set;

public class Deployment extends BaseDeployment {

    private Set<DeploymentUnit> deploymentUnits;
    private Status status;
    private Action action;

    public Deployment(String name) {
        super(name);
        deploymentUnits = new HashSet<>();
    }

    public Set<DeploymentUnit> getDeploymentUnits() {
        return deploymentUnits;
    }

    public void setDeploymentUnits(Set<DeploymentUnit> deploymentUnits) {
        this.deploymentUnits = deploymentUnits;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public void addDeploumentUnit(DeploymentUnit unit) {

        if (unit == null)
            return;

        deploymentUnits.add(unit);
    }

    public void removeDeploymentUnit(DeploymentUnit unit) {

        if (unit == null)
            return;

        deploymentUnits.remove(unit);
    }
}
