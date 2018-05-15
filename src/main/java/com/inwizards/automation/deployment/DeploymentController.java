package com.inwizards.automation.deployment;

import com.inwizards.automation.domain.Deployment;
import com.inwizards.automation.domain.DeploymentUnit;
import com.inwizards.automation.persistence.PersistenceManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value = "/deployment")
public class DeploymentController {

    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Deployment createDeployment(DeploymentRequest req) {
        Deployment d = new Deployment(req.getName());
        PersistenceManager.createDeployment(d);
        return d;
    }

    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Deployment deleteDeployment(DeploymentRequest req) {
        return PersistenceManager.deleteDeployment(req.getId());
    }

    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Deployment updateDeployment(DeploymentRequest req) {
        return PersistenceManager.updateDeployment(req.getId(), req.getName(), req.getDeploymentUnitId());
    }

    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/remove", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Deployment removeDeploymentUnit(DeploymentRequest req) {
        return PersistenceManager.removeDeploymentUnit(req.getId(), req.getDeploymentUnitId());
    }

    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<Deployment> getAllDeployments() {
        return PersistenceManager.getAllDeployments();
    }

    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/du", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<DeploymentUnit> getAllDeploymentUnits(DeploymentRequest req) {
        return PersistenceManager.getAllDeploymentUnitsOfADeployment(req.getId());
    }
}