package com.gdou.service;

import com.gdou.domain.Notice;

import java.util.List;

/**
 * 公告Service 业务层接口
 */
public interface NoticeService {

    /**
     * 获取所有公告（用于刷新公告）
     *
     * @return
     */
    List<Notice> getAllNotice();

    /**
     * 新增公告
     *
     * @param notice 公告信息
     * @return true：新增公告成功  false：新增公告失败
     */
    boolean addNotice(Notice notice);


    /**
     * 修改公告
     *
     * @param notice 公告信息
     * @return true：修改公告成功  false：修改公告失败
     */
    boolean updateNotice(Notice notice);


    /**
     * 删除公告
     *
     * @param noticeid 公告id
     * @return true：删除公告成功  false：删除公告失败
     */
    boolean deleteNotice(Integer noticeid);
}
