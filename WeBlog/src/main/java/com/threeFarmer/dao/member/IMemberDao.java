package com.threeFarmer.dao.member;

import com.threeFarmer.dao.common.IBaseDao;
import com.threeFarmer.model.member.Member;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 会员DAO接口
 */
public interface IMemberDao extends IBaseDao{

    Member login(Member member);

    int loginSuccess(@Param("id") Integer id);

    int register(Member member);

    Member manageLogin(Member member);

    Member findById(@Param("id") Integer id);

    Member findByName(@Param("name") String name);

    Member findByEmail(@Param("email") String email);

    Member findByNameAndEmail(@Param("name") String name, @Param("email") String email);

    /**
     * 修改密码
     * @param id
     * @param password
     * @return
     */
    int changepwd(@Param("id") Integer id, @Param("password") String password);



}