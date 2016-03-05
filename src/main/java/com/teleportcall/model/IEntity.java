package com.teleportcall.model;

/**
 * Created by sriramk on 10/14/2014.
 */
public interface IEntity {

    public Long getPkey();

    public void setPkey(Long pkey);

    public Boolean getDeleted();

    public void setDeleted(Boolean deleted);
}
