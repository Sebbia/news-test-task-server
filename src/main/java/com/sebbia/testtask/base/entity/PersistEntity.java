package com.sebbia.testtask.base.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public abstract class PersistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    public PersistEntity() {
    }

    public PersistEntity(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PersistEntity) {
            return id.equals(((PersistEntity) obj).getId());
        } else
            return false;
    }
}
