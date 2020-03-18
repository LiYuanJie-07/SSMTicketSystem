package com.gdou.service.Impl;

import com.gdou.domain.Notice;
import com.gdou.domain.NoticeExample;
import com.gdou.mapper.NoticeMapper;
import com.gdou.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 公告Service 实现类
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    //注入NoticeMapper
    @Autowired
    private NoticeMapper noticeMapper;

    /**
     * 获取所有公告
     *
     * @return List<Notice>
     */
    @Override
    public List<Notice> getAllNotice() {
        NoticeExample example = new NoticeExample();
        List<Notice> notices = noticeMapper.selectByExampleWithBLOBs(example);
        return notices;
    }

    /**
     * 新增公告
     *
     * @param notice
     * @return true：新增公告成功  false：新增公告失败
     */
    @Override
    public boolean addNotice(Notice notice) {
        int count = noticeMapper.insert(notice);
        return count != 0;
    }

    /**
     * 修改公告
     *
     * @param notice
     * @return true：修改公告成功  false：修改公告失败
     */
    @Override
    public boolean updateNotice(Notice notice) {
        int count = noticeMapper.updateByPrimaryKeySelective(notice);
        System.out.println(count);
        return count != 0;
    }

    /**
     * 删除公告
     *
     * @param noticeid
     * @return true：删除公告成功  false：删除公告失败
     */
    @Override
    public boolean deleteNotice(Integer noticeid) {
        int count = noticeMapper.deleteByPrimaryKey(noticeid);
        return count != 0;
    }
}
