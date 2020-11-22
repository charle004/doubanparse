package cn.cy.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * (Celebrity)实体类
 *
 * @author chenyu
 * @since 2020-11-21 23:41:36
 */
@TableName("celebrity")
@Data
public class Celebrity implements Serializable {
    private static final long serialVersionUID = 900253065964864332L;

    @TableId(type = IdType.AUTO,value = "id")
    private Long id;
    /**
     * 入库时间
     */
    private LocalDateTime createTime;
    /**
     * 名字
     */
    private String name;
    /**
     * 生日
     */
    private LocalDate birthday;
    /**
     * 性别
     */
    private String sex;
    /**
     * 出生地
     */
    private String birthplace;
    /**
     * 星座
     */
    private String constellation;

    /**
     * 职业
     */
    private String profession;
    /**
     * 头像url
     */
    private String headpicUrl;
    /**
     * 获奖情况
     */
    private String reward;
    /**
     * 个人简介
     */
    private String introduction;
    /**
     * 影迷人数
     */
    private Integer fansCount;
    /**
     * imdb编号
     */
    private String imdbId;

    private String reserved1;

    private String reserved2;

    private String reserved3;



}