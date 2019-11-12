package com.yuntun.mybatisplusdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author whj
 * @since 2019-11-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PackageFeeCopy implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 套餐名称
     */
    private String name;

    /**
     * 餐位费
     */
    private Integer mealFee;

    /**
     * 护理费
     */
    private Integer nurseFee;

    /**
     * 床位费： 0 表示按实际房间定
     */
    private Integer bedFee;

    /**
     * 护理级别
     */
    private String nurseLevel;


}
