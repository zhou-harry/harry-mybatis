package com.harry.web.geberator.controller.profile;

import com.harry.web.util.ServletUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.harry.web.geberator.service.profile.ProfileService;
import com.harry.web.geberator.entity.profile.Profile;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 人员配置表 前端控制器
 * </p>
 *
 * @author harry
 * @since 2023-02-28
 */
@Controller
@RequestMapping("/profile")
public class ProfileAction {


    @Autowired
    private ProfileService profileService;

    @GetMapping(value = "/")
    public ResponseEntity<Page<Profile>> list() {
        Integer pageNum = ServletUtils.getParameterToInt("pageNum", 1);
        Integer pageSize = ServletUtils.getParameterToInt("pageSize", 10);
        Page<Profile> aPage = profileService.page(new Page<>(pageNum, pageSize));
        return new ResponseEntity<>(aPage, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Profile> getById(@PathVariable("id") String id) {
        return new ResponseEntity<>(profileService.getById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Object> create(@RequestBody Profile params) {
        profileService.save(params);
        return new ResponseEntity<>("created successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        profileService.removeById(id);
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<Object> delete(@RequestBody Profile params) {
        profileService.updateById(params);
        return new ResponseEntity<>("updated successfully", HttpStatus.OK);
    }
}
