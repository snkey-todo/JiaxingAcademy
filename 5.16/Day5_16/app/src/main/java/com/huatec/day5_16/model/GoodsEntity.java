package com.huatec.day5_16.model;

/**
 * Created by think on 2018/5/16.
 */


public class GoodsEntity {

        private int goods_id;
        private String name;
        private String sn;
        private String brief;
        private String description;
        private int price;
        private int cost;
        private int mktprice;
        private int mkt_enable;
        private int cat_id;
        private int brand_id;
        private int weight;
        private String intro;
        private String params;
        private long creatime;
        private long last_modify;
        private int view_count;
        private int buy_count;
        private String thumbnail;
        private String big;
        private String small;
        private String original;
        private String briefGoodsCat1;
        private String briefGoodsCat2;
        private String briefBrand;
        private String gis;
        private String goodStore;

        public void setGoods_id(int goods_id) {
            this.goods_id = goods_id;
        }

        public int getGoods_id() {
            return goods_id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setSn(String sn) {
            this.sn = sn;
        }

        public String getSn() {
            return sn;
        }

        public void setBrief(String brief) {
            this.brief = brief;
        }

        public String getBrief() {
            return brief;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getPrice() {
            return price;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        public int getCost() {
            return cost;
        }

        public void setMktprice(int mktprice) {
            this.mktprice = mktprice;
        }

        public int getMktprice() {
            return mktprice;
        }

        public void setMkt_enable(int mkt_enable) {
            this.mkt_enable = mkt_enable;
        }

        public int getMkt_enable() {
            return mkt_enable;
        }

        public void setCat_id(int cat_id) {
            this.cat_id = cat_id;
        }

        public int getCat_id() {
            return cat_id;
        }

        public void setBrand_id(int brand_id) {
            this.brand_id = brand_id;
        }

        public int getBrand_id() {
            return brand_id;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public String getIntro() {
            return intro;
        }

        public void setParams(String params) {
            this.params = params;
        }

        public String getParams() {
            return params;
        }

        public void setCreatime(long creatime) {
            this.creatime = creatime;
        }

        public long getCreatime() {
            return creatime;
        }

        public void setLast_modify(long last_modify) {
            this.last_modify = last_modify;
        }

        public long getLast_modify() {
            return last_modify;
        }

        public void setView_count(int view_count) {
            this.view_count = view_count;
        }

        public int getView_count() {
            return view_count;
        }

        public void setBuy_count(int buy_count) {
            this.buy_count = buy_count;
        }

        public int getBuy_count() {
            return buy_count;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setBig(String big) {
            this.big = big;
        }

        public String getBig() {
            return big;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getSmall() {
            return small;
        }

        public void setOriginal(String original) {
            this.original = original;
        }

        public String getOriginal() {
            return original;
        }

        public void setBriefGoodsCat1(String briefGoodsCat1) {
            this.briefGoodsCat1 = briefGoodsCat1;
        }

        public String getBriefGoodsCat1() {
            return briefGoodsCat1;
        }

        public void setBriefGoodsCat2(String briefGoodsCat2) {
            this.briefGoodsCat2 = briefGoodsCat2;
        }

        public String getBriefGoodsCat2() {
            return briefGoodsCat2;
        }

        public void setBriefBrand(String briefBrand) {
            this.briefBrand = briefBrand;
        }

        public String getBriefBrand() {
            return briefBrand;
        }

        public void setGis(String gis) {
            this.gis = gis;
        }

        public String getGis() {
            return gis;
        }

        public void setGoodStore(String goodStore) {
            this.goodStore = goodStore;
        }

        public String getGoodStore() {
            return goodStore;
        }

    @Override
    public String toString() {
        return "GoodsEntity{" +
                "goods_id=" + goods_id +
                ", name='" + name + '\'' +
                ", sn='" + sn + '\'' +
                ", brief='" + brief + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", cost=" + cost +
                ", mktprice=" + mktprice +
                ", mkt_enable=" + mkt_enable +
                ", cat_id=" + cat_id +
                ", brand_id=" + brand_id +
                ", weight=" + weight +
                ", intro='" + intro + '\'' +
                ", params='" + params + '\'' +
                ", creatime=" + creatime +
                ", last_modify=" + last_modify +
                ", view_count=" + view_count +
                ", buy_count=" + buy_count +
                ", thumbnail='" + thumbnail + '\'' +
                ", big='" + big + '\'' +
                ", small='" + small + '\'' +
                ", original='" + original + '\'' +
                ", briefGoodsCat1='" + briefGoodsCat1 + '\'' +
                ", briefGoodsCat2='" + briefGoodsCat2 + '\'' +
                ", briefBrand='" + briefBrand + '\'' +
                ", gis='" + gis + '\'' +
                ", goodStore='" + goodStore + '\'' +
                '}';
    }
}

