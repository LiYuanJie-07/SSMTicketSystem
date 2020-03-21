package com.gdou.controller;

import com.gdou.domain.Notice;
import com.gdou.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 系统公告Controller
 */

@Controller
@RequestMapping(value = "/noticeController")
public class NoticeController extends BasicController {
    //注入NoticeService
    @Autowired
    private NoticeService noticeService;

    /**
     * 获取所有公告、刷新公告
     *
     * @return Msg
     */
    @RequestMapping(value = "/getAllNotice", method = RequestMethod.GET)
    @ResponseBody
    public Msg getAllNotice() {
        //获取所有公告
        List<Notice> notices = noticeService.getAllNotice();
        if (notices != null && notices.size() != 0) {//判断是否查询成功
            return Msg.success("公告已更新！").add("notices", notices);
        } else {
            return Msg.fail("公告更新失败！");
        }
    }

    /**
     * 新增公告
     *
     * @param notice 公告信息
     * @return Msg
     */
    @RequestMapping(value = "/addNotice", method = RequestMethod.POST)
    @ResponseBody
    public Msg addNotice(Notice notice) {
        //设置公告修改时间
        notice.setNoticetime(this.getDate());
        //转换公告格式，将富文本转换为html
        notice.setNoticetext(this.TextToHtml(notice.getNoticetext()));
        //新增公告
        boolean reg = noticeService.addNotice(notice);
        if (reg) {
            return Msg.success("公告已添加！");
        } else {
            return Msg.fail("公告添加失败！");
        }
    }

    /**
     * 修改公告
     *
     * @param notice 公告信息
     * @return Msg
     */
    @RequestMapping(value = "/editNotice", method = RequestMethod.POST)
    @ResponseBody
    public Msg editNotice(Notice notice) {
        //设置公告修改时间
        notice.setNoticetime(this.getDate());
        //转换公告格式，将富文本转换为html
        notice.setNoticetext(this.TextToHtml(notice.getNoticetext()));
        //修改公告
        boolean reg = noticeService.updateNotice(notice);
        if (reg) {
            return Msg.success("公告修改成功！");
        } else {
            return Msg.fail("公告修改失败！");
        }

    }

    /**
     * 删除公告
     *
     * @param noticeid 公告id
     * @return Msg
     */
    @RequestMapping(value = "/deleteNotice", method = RequestMethod.GET)
    @ResponseBody
    public Msg deleteNotice(Integer noticeid) {
        //删除公告
        boolean reg = noticeService.deleteNotice(noticeid);
        if (reg) {
            return Msg.success("公告已删除！");
        } else {
            return Msg.fail("公告删除失败！");
        }

    }

}
