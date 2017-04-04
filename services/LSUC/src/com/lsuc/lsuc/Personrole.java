/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker-com*/
package com.lsuc.lsuc;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Personrole generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`PERSONROLE`", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"`PERSON_FK`", "`ROLE_FK`"})})
public class Personrole implements Serializable {

    private Integer pk;
    private int personFk;
    private Integer roleFk;
    private Person person;
    private Role role;

    @Id
    @Column(name = "`PK`", nullable = false, scale = 0, precision = 10)
    public Integer getPk() {
        return this.pk;
    }

    public void setPk(Integer pk) {
        this.pk = pk;
    }

    @Column(name = "`PERSON_FK`", nullable = false, scale = 0, precision = 10)
    public int getPersonFk() {
        return this.personFk;
    }

    public void setPersonFk(int personFk) {
        this.personFk = personFk;
    }

    @Column(name = "`ROLE_FK`", nullable = true, scale = 0, precision = 10)
    public Integer getRoleFk() {
        return this.roleFk;
    }

    public void setRoleFk(Integer roleFk) {
        this.roleFk = roleFk;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`PERSON_FK`", referencedColumnName = "`PK`", insertable = false, updatable = false)
    public Person getPerson() {
        return this.person;
    }

    public void setPerson(Person person) {
        if(person != null) {
            this.personFk = person.getPk();
        }

        this.person = person;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`ROLE_FK`", referencedColumnName = "`PK`", insertable = false, updatable = false)
    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        if(role != null) {
            this.roleFk = role.getPk();
        }

        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Personrole)) return false;
        final Personrole personrole = (Personrole) o;
        return Objects.equals(getPk(), personrole.getPk());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPk());
    }
}

