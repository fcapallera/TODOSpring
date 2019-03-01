package org.udg.pds.springtodo.entity;

import lombok.Data;
import lombok.NonNull;

@Data
public class IdObject {

    @NonNull
    private Long id;

    public IdObject(Long _id){ id = _id; }

    public Long getId(){ return id; }

}
