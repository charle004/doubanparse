package cn.cy.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * (FilmItem)实体类
 *
 * @author chenyu
 * @since 2020-11-22 11:45:51
 */

@Data
@TableName("film_item")
public class FilmItem implements Serializable {
    private static final long serialVersionUID = 265549552995824406L;

    @TableId(type = IdType.AUTO,value = "id")
    private Long id;
    /**
     * 片名
     */
    private String title;
    /**
     * 豆瓣链接
     */
    private String url;
    /**
     * 导演
     */
    private String directors;
    /**
     * 评分
     */
    private Float rate;
    /**
     * 主要演员
     */
    private String casts;
    /**
     * 封面图
     */
    private String cover;
    /**
     * 豆瓣id
     */
    private Long doubanId;

    private Integer star;

    private Integer coverX;

    private Integer coverY;

    private String reserved1;

    private String reserved2;


}