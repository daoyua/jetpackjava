package com.example.jetpackjava;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;


public class WokerResponse implements Serializable {


    /**
     * result : 1
     * msg : 获取成功!
     * data : [{"cname":"清洁地坪","id":11,"detailUrl":"/upload/20181031/938c65d6-6925-47ec-b266-0e19ec714e1a.jpg,/upload/20181031/cb13d565-15c5-4086-886d-e14888dad09f.jpg,/upload/20181031/4eae014f-7b5a-4383-8ce4-a2eee2ddd96f.jpg,/upload/20181031/2fb5f95f-231c-43b7-8a28-aee588f011c2.jpg,/upload/20181031/91d82fc6-8cf9-4f3e-99bd-6c087acf2874.jpg,/upload/20181031/2c648980-3146-4ab2-9f5d-739d4d32fcf2.jpg,"},{"cname":"石材玉石","id":39,"detailUrl":"/upload/20181031/e542ed41-9722-4165-924f-7b7b69931b00.jpg,/upload/20181031/146ddf38-e6c8-4f57-a0e3-634283b9639b.jpg,/upload/20181031/9f790d92-ea36-4a68-be56-a03093d92e0e.jpg,/upload/20181031/5d7e6604-7ca0-4528-b968-f80e38aad576.jpg,/upload/20181031/113b2f4e-133d-4110-9bde-7e93647c3187.jpg,"},{"cname":"酒店用品","id":40,"detailUrl":"/upload/20181031/290c06d4-f9b6-4da9-9af8-ae064dce1c56.jpg,/upload/20181031/3fe6e59f-10d0-4350-82f6-993f0bf30523.jpg,/upload/20181031/77abad92-0e11-448f-9fc2-c3e6001fad9a.jpg,/upload/20181031/7e3def0e-d3ad-48f7-91dd-58ce950f2523.jpg,/upload/20181031/c8c0159b-5ad8-4522-9908-97de3c3d1edd.jpg,"},{"cname":"二手市场","id":14,"detailUrl":"/upload/20181031/4e3b7fdb-63a7-480f-89f5-3691d90674d8.jpg,/upload/20181031/97393bd8-1629-44c1-8b10-741ddc62ae94.jpg,/upload/20181031/6ad87f32-748d-4b7e-addf-64debc5bbccd.jpg,/upload/20181031/c07bc80d-2cac-46dd-8d58-01e7a18a7a28.jpg,/upload/20181031/6a51e32b-7359-4413-9e8d-8f023b5dec18.jpg,"},{"cname":"智能家电","id":32,"detailUrl":""},{"cname":"五金建材","id":13,"detailUrl":"/upload/20181028/fafdb2b6-0a87-4373-9cc0-d1de0c249c93.jpg,/upload/20181031/46ef36d1-f26b-45de-a33f-fede902cbe8b.jpg,/upload/20181031/5e7dce19-b471-43ee-bf3f-63498b4d161f.jpg,/upload/20181031/4d0e18ef-710b-4fe5-8fa4-0376ffe83b28.jpg,/upload/20181031/0cfd099d-902e-4076-bf78-2cb2d51c1def.jpg,"},{"cname":"文玩艺术","id":33,"detailUrl":""},{"cname":"家居布艺","id":16,"detailUrl":"/upload/20180927/2390e2e0-46b5-4c08-9792-69e3d738a5da.png,"},{"cname":"陶瓷洁具","id":17,"detailUrl":"/upload/20180927/f8f148e2-79ec-495d-99e1-156439fa5633.png,"},{"cname":"绿植园林","id":20,"detailUrl":"/upload/20180928/d6a7ee2f-00d2-40da-96e7-ef82e0e13fc4.jpg,"},{"cname":"生活百科","id":18,"detailUrl":"/upload/20180927/f5221ef1-6c41-4e0f-aa1a-2cc90bd2259e.jpg,/upload/20180927/87a2037b-053d-4be7-873e-2a8a7b4f21db.jpg,"},{"cname":"灯具灯饰","id":19,"detailUrl":""},{"cname":"汽车配饰","id":34,"detailUrl":""}]
     */

    @JSONField(name = "result")
    private Integer result;
    @JSONField(name = "msg")
    private String msg;
    @JSONField(name = "data")
    private List<DataDTO> data;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataDTO> getData() {
        return data;
    }

    public void setData(List<DataDTO> data) {
        this.data = data;
    }

    public static class DataDTO implements Serializable {
        /**
         * cname : 清洁地坪
         * id : 11
         * detailUrl : /upload/20181031/938c65d6-6925-47ec-b266-0e19ec714e1a.jpg,/upload/20181031/cb13d565-15c5-4086-886d-e14888dad09f.jpg,/upload/20181031/4eae014f-7b5a-4383-8ce4-a2eee2ddd96f.jpg,/upload/20181031/2fb5f95f-231c-43b7-8a28-aee588f011c2.jpg,/upload/20181031/91d82fc6-8cf9-4f3e-99bd-6c087acf2874.jpg,/upload/20181031/2c648980-3146-4ab2-9f5d-739d4d32fcf2.jpg,
         */

        @JSONField(name = "cname")
        private String cname;
        @JSONField(name = "id")
        private Integer id;
        @JSONField(name = "detailUrl")
        private String detailUrl;

        public String getCname() {
            return cname;
        }

        public void setCname(String cname) {
            this.cname = cname;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getDetailUrl() {
            return detailUrl;
        }

        public void setDetailUrl(String detailUrl) {
            this.detailUrl = detailUrl;
        }
    }
}
