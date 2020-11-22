package cn.cy.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * (Top250)实体类
 *
 * @author chenyu
 * @since 2020-11-21 23:41:39
 */

@TableName("top250")
@Data
public class Top250 implements Serializable {

    private static final long serialVersionUID = 497463160204208908L;

    @TableId(type = IdType.AUTO,value = "id")
    private Long id;
    /**
     * 生成日期
     */
    private LocalDateTime createTime;
    /**
     * 排名
     */
    private Integer rankOf250;
    /**
     * 片名
     */
    private String filmName;
    /**
     * 评分
     */
    private Float rate;
    /**
     * 年份
     */
    private Integer year;
    /**
     * 地区
     */
    private String region;
    /**
     * 类型，不同类型/分隔
     */
    private String category;

    /**
     * 封面图片url
     */
    private String coverUrl;
    /**
     * 评价数目
     */
    private Integer reviewCount;
    /**
     * 一句话简介
     */
    private String description;
    /**
     * film表主键
     */
    private Long filmId;

    /**
     * 豆瓣链接
     */
    private String doubanUrl;

    private String reserved1;

    private String reserved2;



}