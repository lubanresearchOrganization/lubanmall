package com.lubanresearch.lubanmall.categoryservice.domain;

import com.lubanresearch.lubanmall.categoryservice.infrastructure.persistence.db.mapper.CategoryMapper;
import com.lubanresearch.lubanmall.categoryservice.infrastructure.persistence.db.query.condition.CategoryQueryCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


/**
 * Created by zyf on 2017/12/21
 */
@Repository
public class CategoryRepository {


    @Autowired
    CategoryMapper categoryMapper;


    public Category addCategory(Category category) {

        category.setCreateTime(new Date());
        category.setId(System.currentTimeMillis());
        categoryMapper.insertSelective(category);

        return category;
    }


    public Category getByName(String name) {
        CategoryQueryCondition categoryQueryCondition = new CategoryQueryCondition();
        categoryQueryCondition.createCriteria().andNameEqualTo(name);
        List<Category> categoryList = categoryMapper.selectByExample(categoryQueryCondition);
        if(categoryList.isEmpty()){
            return null;
        }
        return categoryList.get(0);
    }

    public Category getById(Long id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    public void update(Category category) {

        categoryMapper.updateByPrimaryKey(category);

    }

}
