package com.lubanresearch.lubanmall.searchservice.infrastructure.persistence.db.mapper;

import com.lubanresearch.lubanmall.searchservice.domain.Product;
import com.lubanresearch.lubanmall.searchservice.infrastructure.persistence.db.query.condition.ProductQueryCondition;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {
    long countByExample(ProductQueryCondition example);

    int deleteByExample(ProductQueryCondition example);

    int deleteByPrimaryKey(Long id);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductQueryCondition example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lb_product
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    List<Product> selectByExampleSelective(@Param("example") ProductQueryCondition example, @Param("selective") Product.Column ... selective);

    Product selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lb_product
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    Product selectByPrimaryKeySelective(@Param("id") Long id, @Param("selective") Product.Column ... selective);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductQueryCondition example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductQueryCondition example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lb_product
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int upsert(Product record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lb_product
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int upsertSelective(Product record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lb_product
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int upsertByExample(@Param("record") Product record, @Param("example") ProductQueryCondition example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lb_product
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int upsertByExampleSelective(@Param("record") Product record, @Param("example") ProductQueryCondition example);
}