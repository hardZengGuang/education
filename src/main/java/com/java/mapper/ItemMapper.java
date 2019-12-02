package com.java.mapper;

import com.java.pojo.Item;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zengguang
 */

public interface ItemMapper {


    @Select("select * from tb_item a join tb_item_cat b on  a.id=b.id")
    List<Item> select() throws Exception;
}
