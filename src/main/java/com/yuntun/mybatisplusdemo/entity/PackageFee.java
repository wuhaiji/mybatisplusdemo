package com.yuntun.mybatisplusdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
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
public class PackageFee implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "Id", type = IdType.AUTO)
    private Integer Id;

    /**
     * 套餐名称
     */
    @TableField("Name")
    private String Name;

    /**
     * 餐位费
     */
    @TableField("MealFee")
    private Integer MealFee;

    /**
     * 护理费
     */
    @TableField("NurseFee")
    private Integer NurseFee;

    /**
     * 床位费： 0 表示按实际房间定
     */
    @TableField("BedFee")
    private Integer BedFee;

    /**
     * 护理级别
     */
    @TableField("NurseLevel")
    private String NurseLevel;


}
