package com.teleportcall.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.persistence.Version;

import com.teleportcall.util.PersistenceListener;

/**
 * Created by ssenthilkumar on 04/03/2016.
 */
@MappedSuperclass
@EntityListeners(value = {PersistenceListener.class})
public class AbstractEntity implements IEntity {

    private static final long serialVersionUID = 7665388940974264209L;

    private Long pkey;
    private Boolean deleted;
    private String creator;
    private Timestamp created;
    private String changer;
    private Timestamp changed;
    private Long version;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pkey")
    public Long getPkey() {
        return pkey;
    }

    public void setPkey(Long pkey) {
        this.pkey = pkey;
    }

    @Column(name = "deleted")
    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Column(name = "creator")
    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Column(name = "created")
    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @Column(name = "changer")
    public String getChanger() {
        return changer;
    }

    public void setChanger(String changer) {
        this.changer = changer;
    }

    @Column(name = "changed")
    public Timestamp getChanged() {
        return changed;
    }

    public void setChanged(Timestamp changed) {
        this.changed = changed;
    }

    @Column(name = "version")
    @Version
    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

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

    public void setId(Long id) {

    }


}
