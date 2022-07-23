package com.kr.poc.userservice.entity;

import lombok.Data;

//import javax.persistence.*;
import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

//import javax.persistence.Table;

//@Entity
@Table("USER")
@Data

public class User {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column("username")
    private String userName;

    @Column("usertype")
    private String userType;

    @Column("emailid")
    private String emailId;

    @Column("mobileNumber")
    private String mobileNumber;

    @Column("status")
    private String status;

   // @Column(name="createdTS")
    //@Temporal(TemporalType.TIMESTAMP)
    //private Date createdTS;

   // @Column(name="lastModifiedByTS")
    //@Temporal(TemporalType.TIMESTAMP)
    //private Date lastModifiedByTS;


}
