package com.teleportcall.util;

import java.sql.Timestamp;
import java.util.Calendar;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.teleportcall.model.AbstractEntity;

/**
 * Created by ssenthilkumar on 04/03/2016.
 */
public class PersistenceListener {

    @PrePersist
    void onPreCreate(Object entity) {
        AbstractEntity baseEntity = (AbstractEntity) entity;
        baseEntity.setCreated(new Timestamp(Calendar.getInstance().getTime().getTime()));
        baseEntity.setChanged(new Timestamp(Calendar.getInstance().getTime().getTime()));
        String createdBy = UtilityFunction.getCurrentLoggedinUser();
        baseEntity.setCreator(createdBy);
        baseEntity.setChanger(createdBy);
        if (baseEntity.getDeleted() == null) {
            baseEntity.setDeleted(false);
        }
    }

    @PreUpdate
    void onPreUpdate(Object entity) {
        AbstractEntity baseEntity = (AbstractEntity) entity;
        baseEntity.setChanged(new Timestamp(Calendar.getInstance().getTime().getTime()));
        String changedBy = UtilityFunction.getCurrentLoggedinUser();
        baseEntity.setChanger(changedBy);
        if (baseEntity.getDeleted() == null) {
            baseEntity.setDeleted(false);
        }
    }
}
