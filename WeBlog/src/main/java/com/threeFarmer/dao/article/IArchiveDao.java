package com.threeFarmer.dao.article;

import com.threeFarmer.model.article.Archive;
import org.apache.ibatis.annotations.Param;

public interface IArchiveDao {
    Archive findByArchiveId(@Param("archiveId") Integer archiveId);

    /**
     * 更新阅读数
     * @param archiveId
     * @return
     */
    int updateViewCount(@Param("archiveId") int archiveId);

    int favor(@Param("archiveId") int archiveId, @Param("num") int num);

}
