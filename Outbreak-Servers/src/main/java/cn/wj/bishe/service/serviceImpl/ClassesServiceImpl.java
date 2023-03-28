package cn.wj.bishe.service.serviceImpl;

import cn.wj.bishe.entity.Classes;
import cn.wj.bishe.mapper.ClassMapper;
import cn.wj.bishe.service.ClassesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ClassesServiceImpl extends ServiceImpl<ClassMapper, Classes> implements ClassesService {
}
