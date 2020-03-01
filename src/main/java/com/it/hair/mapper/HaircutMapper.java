package com.it.hair.mapper;

import com.it.hair.entity.Haircut;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yiyu
 * @since 2020-02-29
 */
@Mapper
public interface HaircutMapper extends BaseMapper<Haircut> {

}
