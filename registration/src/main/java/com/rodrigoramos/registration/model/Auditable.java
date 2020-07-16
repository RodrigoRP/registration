package com.rodrigoramos.registration.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;


@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Auditable<U> {

    @JsonIgnore
    @CreatedBy
    private U createdBy;

    @JsonIgnore
    @CreatedDate
    @Temporal(TIMESTAMP)
    private Date createdDate;

    @JsonIgnore
    @LastModifiedBy
    private U lastModifiedBy;

    @JsonIgnore
    @LastModifiedDate
    @Temporal(TIMESTAMP)
    private Date lastModifiedDate;
}
