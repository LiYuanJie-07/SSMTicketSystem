package com.gdou.controller;

import com.gdou.domain.Menu;
import com.gdou.domain.MenuList;
import com.gdou.domain.User;
import com.gdou.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 登录Controller
 */
@Controller
@RequestMapping(value = "/loginController")
public class LoginController extends BasicController {
    //注入UserService
    @Autowired
    private UserService userService;

    /**
     * 登录方法
     *
     * @param username 用户名/邮箱/手机号
     * @param password 密码
     * @param request  请求
     * @return Msg
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Msg login(String username, String password, HttpServletRequest request) {
        //对密码进行MD5加密
        String md5Password = this.md5(password);
        //获取subject
        Subject currentUser = SecurityUtils.getSubject();

        if (!currentUser.isAuthenticated()) {
            // 把用户名和密码封装为UsernamePasswordToken对象
            UsernamePasswordToken token = new UsernamePasswordToken(username, md5Password);
            //rememberme
            token.setRememberMe(true);
            try {
                //执行登录 UserRealm
                currentUser.login(token);
            } catch (UnknownAccountException uae) {
                //用户名不存在
                return Msg.fail("用户名不存在！");
            } catch (IncorrectCredentialsException ice) {
                //密码错误
                return Msg.fail("密码错误！");
            }
            // 所有认证时异常的父类
            catch (AuthenticationException ae) {
                // unexpected condition? error?
                return Msg.fail("登陆失败，请重新登陆");
            }
        }
        User user = userService.getUserByUserNameOrEamilOrPhone(username);
        //更新最近一次登录时间
        user.setLogintime(this.getDateTime());
        userService.updateUser(user);
        //获取session
        HttpSession session = request.getSession();
        //把用户信息存入session
        session.setAttribute("user", user);
        return Msg.success("登陆成功");
    }

    /**
     * 校验注册用户名是否已经存在（已经被注册）
     *
     * @param username 用户名
     * @return Msg
     */
    @RequestMapping(value = "/checkUsername", method = RequestMethod.GET)
    @ResponseBody
    public Msg checkUsernameIsExist(String username) {
        //查询该用户名是否存在
        boolean exist = userService.checkUsername(username);
        if (exist) {
            return Msg.success("用户名可用");
        } else {
            return Msg.fail("用户名已存在");
        }
    }

    /**
     * 用户注册方法
     *
     * @param user 用户信息
     * @return Msg
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Msg register(User user) {
        // 对密码进行MD5加密
        user.setPassword(this.md5(user.getPassword()));
        //默认设置不是管理员
        user.setAdmin(0);
        //注册
        boolean reg = userService.addUser(user);
        if (reg) {
            return Msg.success("注册成功");
        } else {
            return Msg.fail("注册失败，请重新注册");
        }

    }


    /**
     * 退出登录由shiro提供的logout来进行
     * public String logout() {
     *     }
     */


    /**
     * 获取菜单
     *
     * @param request 请求
     * @return Msg
     */
    @RequestMapping(value = "/getMenu", method = RequestMethod.GET)
    @ResponseBody
    public Msg getMenu(HttpServletRequest request) {
        //获取session
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        //获取菜单
        List<Menu> allMenus = userService.getMenu(user.getAdmin());
        List<Menu> topMenus = new ArrayList<>();//一级菜单
        List<MenuList> menuLists = new ArrayList<>();//封装菜单
        if (allMenus == null || allMenus.size() == 0) {
            return Msg.fail("获取菜单失败，请重新登录！");
        } else {
            for (Menu topMenu : allMenus) {//循环遍历所有菜单将一级菜单取出
                if (topMenu.getParentid() == 0) {
                    topMenus.add(topMenu);
                }
            }

            for (Menu topMenu : topMenus) {//循环遍历一级菜单，将子菜单放入
                List<Menu> child = new ArrayList<>();
                for (Menu childMenu : allMenus) {//循环遍历所有菜单，将子菜单取出
                    if (childMenu.getParentid() == topMenu.getMenuid()) {
                        child.add(childMenu);//放入子菜单
                    }
                }
                MenuList menuList = new MenuList(topMenu.getMenuname(), child);//封装成固定格式
                menuLists.add(menuList);
            }
            session.setAttribute("menuLists", menuLists);
            return Msg.success("获取菜单成功！");
        }

    }


}
