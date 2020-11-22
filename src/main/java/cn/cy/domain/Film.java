package cn.cy.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * (Film)实体类
 *
 * @author chenyu
 * @since 2020-11-21 23:41:40
 */
@TableName("film")
@Data
public class Film implements Serializable {
    private static final long serialVersionUID = -73561234813876566L;

    @TableId(type = IdType.AUTO,value = "id")
    private Long id;
    /**
     * 入库时间
     */
    private LocalDateTime createTime;
    /**
     * 片名
     */
    private String filmName;
    /**
     * 类型 '电影','电视剧','纪录片','综艺','短片','动漫'
     */
    private String filmType;
    /**
     * 评分
     */
    private Float rate;
    /**
     * 年份
     */
    private Integer year;
    /**
     * 类型，不同类型/分隔
     */
    private String category;
    /**
     * 国家地区
     */
    private String region;
    /**
     * 导演  以;分隔
     */
    private String directors;
    /**
     * 编剧 以;分隔
     */
    private String screenwriter;
    /**
     * 主要演员  以;分隔
     */
    private String casts;
    /**
     * 豆瓣id
     */
    private Long doubanId;
    /**
     * imdb编号
     */
    private String imdbId;
    /**
     * 豆瓣链接
     */
    private String doubanUrl;
    /**
     * 剧情简介
     */
    private String plot;
    /**
     * 封面图url
     */
    private String coverUrl;
    /**
     * 获奖情况
     */
    private String reward;
    /**
     * 评论数
     */
    private Integer reviewCount;
    /**
     * 热评，以<<$$review$$>>分隔
     */
    private String review;

    private String reserved1;

    private String reserved2;

    private String reserved3;

    private String reserved4;

}