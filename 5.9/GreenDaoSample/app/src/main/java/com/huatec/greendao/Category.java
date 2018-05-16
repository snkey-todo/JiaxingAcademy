package com.huatec.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by zhusheng on 2018/5/12.
 */

@Entity
public class Category{
    @Id
    private Long cat_id;  //商品分类id,可以设计为表的主键并自增长

    private String name; //分类名称，如酒、红酒、长城红酒都属于分类名称。
    private int parent_id; //父级id
    private String cat_path; //商品所属级别信息,比如长城红酒属于酒-->红酒这个级别
    private int goods_count; //商品数量
    private int sort; //排序信息
    private int type_id; //所属类别，比如红酒分类属于酒这个列别
    private int list_show; //是否显示该商品
    private String image; //商品图片
    @Generated(hash = 825816281)
    public Category(Long cat_id, String name, int parent_id, String cat_path,
            int goods_count, int sort, int type_id, int list_show, String image) {
        this.cat_id = cat_id;
        this.name = name;
        this.parent_id = parent_id;
        this.cat_path = cat_path;
        this.goods_count = goods_count;
        this.sort = sort;
        this.type_id = type_id;
        this.list_show = list_show;
        this.image = image;
    }
    @Generated(hash = 1150634039)
    public Category() {
    }

    public Category(String name ,int goods_count){
        this.name = name;
        this.goods_count = goods_count;
    }
    public Long getCat_id() {
        return this.cat_id;
    }
    public void setCat_id(Long cat_id) {
        this.cat_id = cat_id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getParent_id() {
        return this.parent_id;
    }
    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }
    public String getCat_path() {
        return this.cat_path;
    }
    public void setCat_path(String cat_path) {
        this.cat_path = cat_path;
    }
    public int getGoods_count() {
        return this.goods_count;
    }
    public void setGoods_count(int goods_count) {
        this.goods_count = goods_count;
    }
    public int getSort() {
        return this.sort;
    }
    public void setSort(int sort) {
        this.sort = sort;
    }
    public int getType_id() {
        return this.type_id;
    }
    public void setType_id(int type_id) {
        this.type_id = type_id;
    }
    public int getList_show() {
        return this.list_show;
    }
    public void setList_show(int list_show) {
        this.list_show = list_show;
    }
    public String getImage() {
        return this.image;
    }
    public void setImage(String image) {
        this.image = image;
    }
}
