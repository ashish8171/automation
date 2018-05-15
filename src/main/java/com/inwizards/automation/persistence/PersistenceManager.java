package com.inwizards.automation.persistence;

import com.inwizards.automation.domain.Deployment;
import com.inwizards.automation.domain.DeploymentUnit;
import org.springframework.util.StringUtils;

import java.util.*;

public class PersistenceManager {


    private static Map<UUID, Deployment> deployments = new HashMap<>();
    private static Map<UUID, DeploymentUnit> deploymentUnits = new HashMap<>();

    public static Set<Deployment> getAllDeployments() {
        return new HashSet<>(deployments.values());
    }

    public static void createDeployment(Deployment deployment) {
        deployments.put(deployment.getId(), deployment);
    }

    public static Deployment deleteDeployment(UUID id) {
        return deployments.remove(id);
    }

    public static Deployment updateDeployment(UUID deploymentId, String deploymentName, UUID deploymentUnitId) {
        Deployment d = deployments.get(deploymentId);

        if (d == null)
            return null;

        if (!StringUtils.isEmpty(deploymentName))
            d.setName(deploymentName);

        if (deploymentUnitId != null)
            d.addDeploumentUnit(deploymentUnits.get(deploymentUnitId));

        deployments.put(d.getId(), d);

        return d;
    }

    public static Deployment removeDeploymentUnit(UUID deploymentId, UUID deploymentUnitId) {
        Deployment deployment = deployments.get(deploymentId);

        if (deployment == null)
            return null;

        Optional.ofNullable(deployment.getDeploymentUnits()).ifPresent(du -> du.removeIf(d -> d.getId().equals(deploymentUnitId)));

        return deployment;
    }

    public static Set<DeploymentUnit> getAllDeploymentUnitsOfADeployment(UUID deploymentId) {

        Deployment d = deployments.get(deploymentId);

        return (d == null) ? null : d.getDeploymentUnits();
    }

  /////////////////////////////////////////////////////-----------Deployment Unit ------////////////////////////////////////////////////////////////////////////////

    public static Set<DeploymentUnit> getAllDeploymentUnits() {
        return new HashSet<>(deploymentUnits.values());
    }

    public static void createDeploymentUnit(DeploymentUnit unit) {
        deploymentUnits.put(unit.getId(), unit);
    }
}