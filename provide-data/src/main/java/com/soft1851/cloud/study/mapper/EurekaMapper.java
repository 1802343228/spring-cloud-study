package com.soft1851.cloud.study.mapper;

import com.soft1851.cloud.study.entity.Eureka;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author crq
 */
public interface EurekaMapper {
    /**
     * 查询所有
     * @return List</Map>
     */
    @Select("SELECT * FROM t_eureka")
    @Results({
            @Result(id=true,property="id",column="id",javaType = String.class),
            @Result(property="name",column="name",javaType = String.class)
    })
    List<Eureka> selectAll();
}
