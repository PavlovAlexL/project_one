package com.palex.practice.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "Office")
public class OfficeEntity {

    /**
     * Уникальный идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * Служебное поле Hibernate
     */
    @Version
    @Column (name="version", nullable = false)
    private Integer version;

    /**
     * Наименование
     */
    @Column(name = "name", length = 50)
    private String name;

    /**
     * Адрес
     */
    @Column(name="address", length = 200)
    private String address;

    /**
     * Телефон
     */
    @Column (name="phone", length = 20)
    private String phone;

    /**
     * Статус
     */
    @Column (name="is_active")
    private Boolean is_active;

    /**
     * Принадлежность к организации
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "org_id", nullable = false)
    private OrganisationEntity organisation;

    /**
     * Множество пользователей, принадлежащих данному офису
     */
    @OneToMany(mappedBy = "office", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserEntity> users;


    public OfficeEntity(){

    }

    public OfficeEntity(Map<String, String> params, OrganisationEntity organisationEntity) {
        this.organisation = organisationEntity;
        this.name = params.get("name");
        this.address = params.get("address");
        this.phone = params.get("phone");
        this.is_active = Boolean.parseBoolean(params.get("is_active"));
    }

    public Long getId() {
        return id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }

    public OrganisationEntity getOrganisation() {
        return organisation;
    }

    public void setOrganisation(OrganisationEntity organisation) {
        this.organisation = organisation;
    }

    public Set<UserEntity> getUsers() {
        if(users == null){
            users = new HashSet<>();
        }
        return users;
    }

    public void setUsers(Set<UserEntity> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "OfficeEntity{" +
                "id=" + id +
                ", version=" + version +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", is_active=" + is_active +
                ", organisation=" + organisation +
                ", users=" + users +
                '}';
    }
}
