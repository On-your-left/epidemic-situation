package cn.wj.bishe.mapper;

import cn.wj.bishe.entity.Leave;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;
@Mapper
public interface LeaveMapper extends BaseMapper<Leave> {
    int UpdLeaveInfo(Map<String,String> map);
}
