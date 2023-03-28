package cn.wj.bishe.service.serviceImpl;

import cn.wj.bishe.entity.Health;
import cn.wj.bishe.mapper.HealthMapper;
import cn.wj.bishe.service.HealthService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class HealthServiceImpl extends ServiceImpl<HealthMapper, Health> implements HealthService {
}
