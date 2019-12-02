package com.java.controller;

import com.java.mapper.ItemMapper;
import com.java.pojo.Item;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/test")
public class IndexController {

    @Autowired
    ItemMapper itemMapper;

    @Autowired
    SolrClient solrClient;
    @RequestMapping("/ni")
    @ResponseBody
    public String ni() {
        return "hello";
    }


    @RequestMapping("/toIndex")
    public String toIndex() {
        return "index";
    }


    @RequestMapping("/solr")
    public void solr(){
        try {
            List<Item> list = itemMapper.select();
            SolrInputDocument document = new SolrInputDocument();
            for (Item item:list){
                document.setField("id",item.getId());
                document.setField("item_title",item.getTitle());
                document.setField("item_sell_point",item.getSell_point());
                document.setField("item_price",item.getPrice());
                document.setField("item_category_name",item.getCategory_name());
                document.setField("item_desc",item.getItem_des());
                solrClient.add(document);
            }
            solrClient.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
