package com.tom.db.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@ApiModel(description = "user資料")
@Data
@Entity
@Table(name = "userData")
public class UserData {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name="native", strategy="native")
    @ApiModelProperty(required=true, readOnly=true, position=0, value="流水号" )
    protected Long id;

    @ApiModelProperty(value="user name", required=true, position=1)
    @Column(nullable=false, length=10)
    protected String userName;
}
