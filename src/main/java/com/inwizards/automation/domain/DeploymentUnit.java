package com.inwizards.automation.domain;

import com.inwizards.automation.base.BaseDeployment;

import java.util.HashSet;
import java.util.Set;

public class DeploymentUnit extends BaseDeployment {


    private Set<Process> process;

    public DeploymentUnit(String name) {
        super(name);
        process = new HashSet<>();
    }

    public Set<Process> getProcess() {
        return process;
    }

    public void setProcess(Set<Process> process) {
        this.process = process;
    }

    public void addProcess(Process p) {

        if(p == null)
            return;

        process.add(p);
    }

    public void remoceProcess(Process p) {
        if(p == null)
            return;

        process.remove(p);
    }
}
