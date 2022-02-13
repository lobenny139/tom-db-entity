package com.tom.db.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@ApiModel(description = "庫存資料")
@Data
@Entity
@Table(name = "stockData")
public class StockData {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name="native", strategy="native")
    @ApiModelProperty(required=true, readOnly=true, position=0, value="流水号" )
    protected Long id;

    @ApiModelProperty(value="產品ID", required=true, position=1)
    @Column(nullable=false, length=10)
    protected String productId;

    @ApiModelProperty(value="庫存剩餘", required=true, position=2)
    @Column(nullable=false)
    protected int rest;

}
