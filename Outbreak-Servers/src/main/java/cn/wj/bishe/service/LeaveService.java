package cn.wj.bishe.service;

import cn.wj.bishe.common.Result;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.wj.bishe.entity.Leave;

public interface LeaveService extends IService<Leave> {
    //老师审核该假条
    Result UpdLeaveInfo(String leaveId, String leaveState, String leaveNo);
}
