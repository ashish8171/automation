package com.inwizards.automation.deploymentUnit;

import com.inwizards.automation.domain.DeploymentUnit;
import com.inwizards.automation.persistence.PersistenceManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value ="/du")
public class DeploymentUnitController {

    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public DeploymentUnit createDeploymentUnit(DeploymentUnitRequest req) {
        DeploymentUnit unit = new DeploymentUnit(req.getName());
        PersistenceManager.createDeploymentUnit(unit);
        return unit;
    }

    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<DeploymentUnit> getAllDeploymentUnits() {
        return PersistenceManager.getAllDeploymentUnits();
    }
}
