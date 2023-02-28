package com.harry.web.geberator.service.impl.profile;

import com.harry.web.geberator.entity.profile.Profile;
import com.harry.web.geberator.mapper.profile.ProfileMapper;
import com.harry.web.geberator.service.profile.ProfileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 人员配置表 服务实现类
 * </p>
 *
 * @author harry
 * @since 2023-02-28
 */
@Service
public class ProfileServiceImpl extends ServiceImpl<ProfileMapper, Profile> implements ProfileService {

}
