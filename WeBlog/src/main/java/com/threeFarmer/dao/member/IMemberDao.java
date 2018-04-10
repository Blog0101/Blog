package com.threeFarmer.dao.member;

import com.threeFarmer.model.member.Member;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 会员DAO接口
 */
public interface IMemberDao {

    Member login(Member member);

    int loginSuccess(@Param("id") Integer id);

    Member findById(@Param("id") Integer id);

}