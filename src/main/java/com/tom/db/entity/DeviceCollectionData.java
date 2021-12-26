package com.tom.db.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "設備彙集資料")
@Data
@Entity
@Table(name = "deviceCollectionData")
public class DeviceCollectionData implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name="native", strategy="native")
    @ApiModelProperty(required=true, readOnly=true, position=0, value="流水号" )
    protected Long id;

    @ApiModelProperty(value="收集資料的設備ID", required=true, position=1)
    @Column(nullable=false, length=30)
    protected String deviceId;

    @ApiModelProperty(value="資料Key", required=false, position=2)
    @Column(nullable=false, length=30)
    protected String dataKey;

    @ApiModelProperty(value="資料值", required=false, position=3)
    @Column(nullable=false, length=30)
    protected String dataValue;

    @ApiModelProperty(value="建立記錄日期", required=true, readOnly=true, position=4)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false,  updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    protected Date createDate;

    @ApiModelProperty(value="誰更新這筆記錄", readOnly=true, required=false, position=5)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = true, insertable = false, updatable = false, columnDefinition = "TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP")
    protected Date updateDate;

}
