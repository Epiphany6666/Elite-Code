package cn.luoyan.elitecode.controller;

import cn.luoyan.elitecode.mapper.SysUserMapper;
import cn.luoyan.elitecode.model.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private SysUserMapper userMapper;

    @GetMapping("/hello")
    public String hello() {
        return "Hello, SpringBoot2!";
    }

    @GetMapping("/{userId}")
    public SysUser selectUserById(@PathVariable Long userId) {
        return userMapper.selectUserById(userId);
    }
}
