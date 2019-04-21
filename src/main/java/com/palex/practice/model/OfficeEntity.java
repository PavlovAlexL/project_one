package com.palex.practice.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Office")
public class OfficeEntity {

    /**
     * Уникальный идентификатор
     */
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * Служебное поле Hibernate
     */
    @Version
    private Integer version;

    /**
     * Связь Идентификатор организации, many_to_one
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name="org_id", nullable = false)
    private OrganisationEntity organisation;

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
    @Column(name="isActive")
    private Boolean isActive;

    /**
     * Множество пользователей, принадлежащих данному офису
     */
    @OneToMany(mappedBy = "Office", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserEntity> users;

    /**
     * Конструктор для Hibernate
     */
    public OfficeEntity(){

    }


    public OrganisationEntity getOrganisation(){
        return this.organisation;
    }

    public void setOrganisation(OrganisationEntity organisation){
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

    public void addUser(UserEntity user){
        getUsers().add(user);
    }

    public void removeUser(UserEntity user){
        getUsers().remove(user);
    }

    public Long getId() {
        return id;
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

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OfficeEntity)) return false;
        OfficeEntity that = (OfficeEntity) o;
        return id.equals(that.id) &&
                Objects.equals(version, that.version) &&
                Objects.equals(organisation, that.organisation) &&
                Objects.equals(name, that.name) &&
                Objects.equals(address, that.address) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(isActive, that.isActive) &&
                Objects.equals(users, that.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version, organisation, name, address, phone, isActive, users);
    }
}
