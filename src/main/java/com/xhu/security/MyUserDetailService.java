package com.xhu.security;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xhu.entity.Manager;
import com.xhu.entity.Student;
import com.xhu.entity.Teacher;
import com.xhu.mapper.ManagerMapper;
import com.xhu.mapper.StudentMapper;
import com.xhu.mapper.TeacherMapper;
import com.xhu.security.pojo.AuthUser;
import com.xhu.security.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

public class MyUserDetailService implements UserDetailsService {

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    TeacherMapper teacherMapper;

    @Autowired
    ManagerMapper managerMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String prefix = String.valueOf(username.charAt(0));
        List<Role> roles = new ArrayList<>();
        roles.add(new Role(username, prefix));

        AuthUser user = new AuthUser()
                .setEnabled(true)
                .setAccountNonExpired(true)
                .setAccountNonLocked(true)
                .setCredentialsNonExpired(true)
                .setEnabled(true)
                .setRoles(roles);

        String notFound = "用户名不正确";
        switch (prefix) {
            case "S": {
                LambdaQueryWrapper<Student> wrapper = new LambdaQueryWrapper<>();
                wrapper.eq(true, Student::getStudentId, username);
                Student student = studentMapper.selectOne(wrapper);
                if (ObjectUtils.isEmpty(student)) {
                    throw new UsernameNotFoundException(notFound);
                }
                user.setUsername(student.getStudentId())
                        .setPassword(student.getPassword());
                break;
            }
            case "M": {

                LambdaQueryWrapper<Manager> wrapper = new LambdaQueryWrapper<>();
                wrapper.eq(true, Manager::getManagerId, username);
                Manager manager = managerMapper.selectOne(wrapper);
                if (ObjectUtils.isEmpty(manager)) {
                    throw new UsernameNotFoundException(notFound);
                }
                user.setUsername(manager.getManagerId())
                        .setPassword(manager.getPassword());
                break;
            }
            case "T": {
                LambdaQueryWrapper<Teacher> wrapper = new LambdaQueryWrapper<>();
                wrapper.eq(true, Teacher::getTeacherId, username);
                Teacher teacher = teacherMapper.selectOne(wrapper);
                if (ObjectUtils.isEmpty(teacher)) {
                    throw new UsernameNotFoundException(notFound);
                }
                user.setUsername(teacher.getTeacherId())
                        .setPassword(teacher.getPassword());
                break;

            }
            default:
                break;
        }
        return user;

    }



}
