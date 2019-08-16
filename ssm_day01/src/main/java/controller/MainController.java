package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pojo.*;
import service.*;
import utils.BalanceLessException;
import utils.StoLessException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.*;


/**
 * @author yk
 * @date 2019/8/8 - 14:46
 */
@Controller
@RequestMapping("/main")
public class MainController {

    /**
     * 默认关键字
     */
    private String kw = "";
    /**
     * 默认首页
     */
    private Integer cp=1;

    /**
     * 默认订单首页
     */
    private Integer order_cp = 1;


    private final IUserService userService;
    private final IBookService bookService;
    private final IStoService stoService;
    private final IAccountService accountService;
    private final IPayService payService;
    private final IOrderService orderService;
    private final IDetailsService detailsService;

    @Autowired
    public MainController(IUserService userService,IBookService bookService,IStoService stoService,IAccountService accountService,IPayService payService,IOrderService orderService,IDetailsService detailsService) {
        this.userService = userService;
        this.bookService = bookService;
        this.stoService = stoService;
        this.accountService = accountService;
        this.payService = payService;
        this.orderService = orderService;
        this.detailsService = detailsService;
    }

    /**
     * 登录
     * @param loginname
     * @param loginpwd
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("login")
    public String islogin(String loginname, String loginpwd, Model model,HttpServletRequest request){
        T_User t_user = userService.islogin(loginname,loginpwd);
        if(t_user==null){
            model.addAttribute("login_err","登录失败,账户或密码错误!");
            return "error";
        }
        request.getSession().setAttribute("myUser",t_user);
        //移除没有登录的提示
        request.getSession().removeAttribute("prompt");
        return "forward:allBook";
    }

    /**
     * 查询所有书籍
     * @param page
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("allBook")
    public String getAllBook(Integer page, Model model, HttpServletRequest request){
        /**
         * 默认行数
         */
        Integer ps=3;
        String kw = request.getParameter("kw");
        if(page!=null&&page>0){
            this.cp = page;
        }
        if(kw!=null&&!kw.equals("")){
            this.kw=kw;
        }
        Map<String,Object> map = new HashMap<>();
        map.put("book_name",this.kw);
        map.put("cp",(cp-1)*ps);
        map.put("ps",cp*ps);
        List<Book> allBook = bookService.getAllBook(map);
        int count = bookService.getCount();
        /**
         * 总页数
         */
        int totle = (int) Math.ceil(count * 1.0 / ps);
        model.addAttribute("allBook",allBook);
        model.addAttribute("page",cp);
        model.addAttribute("totle",totle);
        return "index";
    }

    /**
     * 注销
     * @param request
     * @return
     */
    @RequestMapping("out")
    @ResponseBody
    public Integer logout(HttpServletRequest request){
        //防止创建session
        HttpSession session = request.getSession(false);
        if(session==null){
            return 0;
        }
        session.removeAttribute("myUser");
        return 1;
    }

    /**
     * 查看书籍详细信息
     * @param bookName
     * @param page
     * @param model
     * @return
     */
    @RequestMapping("binfo")
    public String bookInfo(String bookName,int page,Model model){
        Book book = bookService.bookInfo(bookName);
        model.addAttribute("book",book);
        model.addAttribute("page",page);
        return "book_info";
    }

    /**
     * 添加书籍跳转
     * @return
     */
    @RequestMapping("add")
    public String addBook(){
        return "add_book";
    }

    /**
     * 添加书籍到数据库
     * @return
     */
    @RequestMapping(value="createBook",method = RequestMethod.POST)
    public String doCreateBook(Book book, Integer count, @RequestParam MultipartFile img, HttpServletRequest request,Model model){
        StoreHouse storeHouse = new StoreHouse();
        Book b = bookService.bookInfo(book.getBook_name());
        if(b!=null){//说明书籍存在,修改书籍的库存
            storeHouse.setBookid(b.getBookid());
            storeHouse.setBook_count(count+b.getStoreHouse().getBook_count());
            boolean flag_sto = stoService.updateBookSto(storeHouse);
            if(flag_sto){
                return "redirect:allBook";
            }
        }

        try {
            //获取io流
            InputStream is = img.getInputStream();
            //获取upload的绝对路径
            String realPath = request.getSession().getServletContext().getRealPath("/images");
            System.out.println(realPath);
            //随机生成图片名称
            String filename = UUID.randomUUID().toString();
            //获取文件后缀
            String suffname = img.getOriginalFilename().substring(img.getOriginalFilename().lastIndexOf("."));
            //创建输出流
            OutputStream os = new FileOutputStream(new File(realPath+"/"+filename+suffname));
            //工具类
            FileCopyUtils.copy(is,os);
            //把图片的相对路径保存至数据库
            book.setImg_path("images/"+filename+suffname);
            boolean flag_book = bookService.addBook(book);
            storeHouse.setBookid(book.getBookid());
            storeHouse.setBook_count(count);
            boolean flag_count = stoService.addCount(storeHouse);
            book.setStoreHouse(storeHouse);
            if(flag_count&&flag_book){
                return "redirect:allBook";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("add_err","添加失败!");
        return "error";
    }

    /**
     * 查看个人信息
     * @return
     */
    @RequestMapping("uinfo")
    public String userInfo(Integer uid,Model model){
        /**
         * 根据用户编号查询账户
         */
        List<T_Account> list_account = accountService.findAccountByUserid(uid);
        model.addAttribute("list_account",list_account);
        return "user_info";
    }

    /**
     * 用户账户余额
     * @param accid
     * @param page
     * @param model
     * @return
     */
    @RequestMapping("balance")
    @ResponseBody
    public Double balance(Integer accid,Integer page,Model model){
        Double balance = accountService.getBalanceByAccid(accid);
        model.addAttribute("page",page);
        return balance;
    }

    /**
     * 购买书籍链接
     * @return
     */
    @RequestMapping("buy")
    public String buyBook(Integer bookid,Model model){
        /**
         * 获取书籍信息,跳转到订单页面
         */
        Book book = bookService.findBookById(bookid);
        model.addAttribute("book",book);
        return "order_page";
    }

    /**
     * 付款
     * @param bookid    书籍编号
     * @return
     */
    @RequestMapping("pay")
    public String pay(Integer bookid,Integer accid,Integer detailsId,Model model){
        boolean flag;
        try {
            flag = payService.pay(bookid, accid,detailsId);
        } catch (StoLessException e) {
            //库存不足
            model.addAttribute("sto_err","库存不足");
            return "error";
        } catch (BalanceLessException e) {
            //余额不足
            model.addAttribute("bal_err","余额不足!");
            return "error";
        }
        if(flag){
            return "forward:allBook";
        }
        model.addAttribute("pay_err","付款失败!");
        return "error";
    }

    /**
     * 提交订单
     * @return
     */
    @RequestMapping("order")
    public String addOrder(Integer bookid,HttpServletRequest request,Model model){
        //获取书籍信息
        Book book = bookService.findBookById(bookid);
        //随机生成18位的订单号
        //随机生成一位整数
        int random = (int) (Math.random()*9+1);
        String valueOf = String.valueOf(random);
        //生成uuid的hashCode值
        int hashCode = UUID.randomUUID().toString().hashCode();
        //可能为负数
        if(hashCode<0){
            hashCode = -hashCode;
        }
        //订单号
        String orderId = valueOf + String.format("%017d", hashCode);
        T_User user = (T_User) request.getSession().getAttribute("myUser");
        Order o = new Order();
        o.setBookName(book.getBook_name());
        o.setUserId(user.getUserid());
        Details d = new Details();
        d.setBookName(book.getBook_name());
        d.setBookAuth(book.getBook_auth());
        d.setPublicDept(book.getPublic_dept());
        d.setCreateDate(new Date());
        d.setBookPrice(book.getBook_price());
        d.setImgPath(book.getImg_path());
        d.setSummary(book.getSummary());
        d.setOrderId(orderId);
        d.setOrderStatus(0);
        d.setBookId(book.getBookid());
        //添加订单,订单详情
        boolean flag_order = orderService.addOrderAndDetails(o,d);
        if(flag_order){
            List<T_Account> list_account = accountService.findAccountByUserid(user.getUserid());
            model.addAttribute("list_account",list_account);
            model.addAttribute("book",book);
            model.addAttribute("detailsId",d.getDetailsId());
            return "book_pay";
        }
        model.addAttribute("ord_err","添加订单失败!");
        return "error";
    }

    /**
     * 查看所有订单+分页
     * @return
     */
    @RequestMapping("allOrder")
    public String findAllOrder(Integer order_page,Model model,HttpServletRequest request){
        /**
         * 默认行数
         */
        Integer order_ps = 5;
        if(order_page!=null&&order_page>0){
            order_cp = order_page;
        }
        T_User u = (T_User) request.getSession().getAttribute("myUser");
        List<Order> allOrder = orderService.getAllOrder(u.getUserid(),(order_cp-1)*order_ps,order_cp*order_ps);
        model.addAttribute("allOrder",allOrder);
        return "order_info";
    }

    /**
     * 订单详情
     * @return
     */
    @RequestMapping("details")
    public String order_details(Integer orderId,Model model){
        //根据订单获取详情
        Details details = detailsService.findDetailsById(orderId);
        model.addAttribute("details",details);
        return "details_info";
    }

    /**
     * 进入订单详情直接购买
     * @return
     */
    @RequestMapping("detailsPay")
    public String details_pay(Integer bookid,Integer detailsid,Model model,HttpServletRequest request){
        //获取书籍信息
        Book book = bookService.findBookById(bookid);
        T_User user = (T_User) request.getSession().getAttribute("myUser");
        List<T_Account> list_account = accountService.findAccountByUserid(user.getUserid());
        //传递订单详情编号
        model.addAttribute("detailsid",detailsid);
        model.addAttribute("book",book);
        model.addAttribute("list_account",list_account);
        return "book_pay";
    }
}
