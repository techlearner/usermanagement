package com.teleportcall.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import com.teleportcall.util.PersistenceListener;

import lombok.Data;

/**
 * Created by ssenthilkumar on 04/03/2016.
 */
@MappedSuperclass
@EntityListeners(value = {PersistenceListener.class})
public @Data class AbstractEntity implements IEntity {

    private static final long serialVersionUID = 7665388940974264209L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pkey")
    private Long pkey;
    
    @Column(name = "deleted")
    private Boolean deleted;
    
    @Column(name = "creator")
    private String creator;
    
    @Column(name = "created")
    private Timestamp created;
    
    @Column(name = "changer")
    private String changer;
    
    @Column(name = "changed")
    private Timestamp changed;
    
    @Column(name = "version")
    private Long version;

    @Override
    public boolean equals(Object o) {
        if (o instanceof IEntity && pkey != null)
            return pkey.equals(((IEntity) o).getPkey());
        else
            return false;
    }

    @Transient
    public Long getId() {
        return pkey;
    }

}
