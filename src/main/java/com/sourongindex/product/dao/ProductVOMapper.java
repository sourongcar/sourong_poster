package com.sourongindex.product.dao;

import com.sourongindex.product.domain.ProductVO;
import com.sourongindex.product.domain.ProductVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductVOMapper {
    int countByExample(ProductVOExample example);

    int deleteByExample(ProductVOExample example);

    int deleteByPrimaryKey(Integer productid);

    int insert(ProductVO record);

    int insertSelective(ProductVO record);

    List<ProductVO> selectByExample(ProductVOExample example);

    ProductVO selectByPrimaryKey(Integer productid);

    int updateByExampleSelective(@Param("record") ProductVO record, @Param("example") ProductVOExample example);

    int updateByExample(@Param("record") ProductVO record, @Param("example") ProductVOExample example);

    int updateByPrimaryKeySelective(ProductVO record);

    int updateByPrimaryKey(ProductVO record);
}