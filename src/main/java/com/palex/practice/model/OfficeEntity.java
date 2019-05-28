package com.palex.practice.model;

import javax.persistence.*;


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
    @Column (name="isActive")
    private Boolean isActive;

    /**
     * Принадлежность к организации
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "org_id", nullable = false)
    private OrganisationEntity organisation;

//    /**
//     * Множество пользователей, принадлежащих данному офису
//     */
//    @OneToMany(mappedBy = "office", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<UserEntity> users;


    public OfficeEntity(){

    }

    //public OfficeEntity(Map<String, String> params, OrganisationEntity organisationEntity) {
    //    this.organisation = organisationEntity;
    //    this.name = params.get("name");
    //    this.address = params.get("address");
    //    this.phone = params.get("phone");
    //    this.isActive = Boolean.parseBoolean(params.get("isActive"));
    //}

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

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public OrganisationEntity getOrganisation() {
        return organisation;
    }

    public void setOrganisation(OrganisationEntity organisation) {
        this.organisation = organisation;
    }

    //public Set<UserEntity> getUsers() {
    //    if(users == null){
    //        users = new HashSet<>();
    //    }
    //    return users;
    //}
//
    //public void setUsers(Set<UserEntity> users) {
    //    this.users = users;
    //}

}
