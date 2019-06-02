package com.palex.practice.view.Organisation;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * View для.
 */
public class OrganisationListFilterView {

    @NotEmpty
    @Size(min = 2, max = 50)
    public String name;

    public String inn;

    public String isActive;

    public void setInn(String inn) {
        if (inn.length() == 0) {
            this.inn = null;
        } else if (inn.matches("\\d{10}")) {
            this.inn = inn;
        } else throw new RuntimeException("Not valid inn");
    }

    public void setIsActive(String isActive) {
        if(isActive.length() == 0){
            this.isActive = null;
        } else {
            this.isActive = isActive;
        }
    }
}
