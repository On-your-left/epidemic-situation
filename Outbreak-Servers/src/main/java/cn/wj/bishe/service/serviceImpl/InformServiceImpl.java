package cn.wj.bishe.service.serviceImpl;

import cn.wj.bishe.entity.Inform;
import cn.wj.bishe.mapper.InformMapper;
import cn.wj.bishe.service.InformService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class InformServiceImpl extends ServiceImpl<InformMapper, Inform> implements InformService {
}
