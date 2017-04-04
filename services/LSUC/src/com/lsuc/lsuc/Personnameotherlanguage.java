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
 * Personnameotherlanguage generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`PERSONNAMEOTHERLANGUAGE`", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"`PERSON_FK`", "`LANGUAGE_FK`"})})
public class Personnameotherlanguage implements Serializable {

    private Integer pk;
    private String name;
    private Integer personFk;
    private Integer languageFk;
    private Language language;
    private Person person;

    @Id
    @Column(name = "`PK`", nullable = false, scale = 0, precision = 10)
    public Integer getPk() {
        return this.pk;
    }

    public void setPk(Integer pk) {
        this.pk = pk;
    }

    @Column(name = "`NAME`", nullable = true, length = 100)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "`PERSON_FK`", nullable = true, scale = 0, precision = 10)
    public Integer getPersonFk() {
        return this.personFk;
    }

    public void setPersonFk(Integer personFk) {
        this.personFk = personFk;
    }

    @Column(name = "`LANGUAGE_FK`", nullable = true, scale = 0, precision = 10)
    public Integer getLanguageFk() {
        return this.languageFk;
    }

    public void setLanguageFk(Integer languageFk) {
        this.languageFk = languageFk;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`LANGUAGE_FK`", referencedColumnName = "`PK`", insertable = false, updatable = false)
    public Language getLanguage() {
        return this.language;
    }

    public void setLanguage(Language language) {
        if(language != null) {
            this.languageFk = language.getPk();
        }

        this.language = language;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Personnameotherlanguage)) return false;
        final Personnameotherlanguage personnameotherlanguage = (Personnameotherlanguage) o;
        return Objects.equals(getPk(), personnameotherlanguage.getPk());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPk());
    }
}

