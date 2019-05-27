package com.palex.practice.view.Office;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OfficeListFilterView {

    @NotNull
    public Long orgId;

    @Size(max = 50)
    public String name;

    @Size(max = 20)
    public String phone;

    public String isActive;

    @Override
    public String toString() {
        return "OfficeListFilterView{" +
                "orgId=" + orgId +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", isActive='" + isActive + '\'' +
                '}';
    }
}
