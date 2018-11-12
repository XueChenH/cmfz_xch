

import com.baizhi.dao.AdminDao;
import com.baizhi.dao.AlbumDao;
import com.baizhi.dao.GuruDao;
import com.baizhi.entity.*;
import com.baizhi.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestAll {
    @Resource
    private AdminService AdminService;
    @Resource
    private AdminDao adminDao;
    @Resource
    private MenuService menuService;
    @Resource
    private SildeshowService sildeshowService;
    @Test
    public void testAdmin(){
        Admin Admin=new Admin();
        Admin.setId("001");
        Admin.setPassword("123456789");
        AdminService.update(Admin);
    }
   @Test
    public void testAdmin2(){
        Admin login = AdminService.login("123456","123456789");
        System.out.println(login);
    }
    @Test
    public void testAdmin3(){
        Admin login = adminDao.queryOne("123456","123456");

        System.out.println(login);
    }
    @Test
    public void testMenu(){
        List<Menu> list = menuService.showAll();

        for (Menu menu : list) {
            System.out.println(menu);
        }
    }
    @Test
    public void testS(){
        List<Sildeshow> list = sildeshowService.showAll();
        for (Sildeshow sildeshow : list) {
            System.out.println(sildeshow);
        }
    }
    @Test
    public void tests2(){
        Sildeshow sildeshow = sildeshowService.showOne("7ed6d934-acb2-4441-b839-dd90405a4b20");
        System.out.println(sildeshow);
    }
    @Test
    public void tests3(){
        Sildeshow sildeshow=new Sildeshow();
        sildeshow.setPath("das");
        sildeshow.setS_desc("达康书记年度会计师");
        sildeshow.setStatus("asdasd");
        sildeshow.setUpdatetime(new Date());
        sildeshowService.add(sildeshow);
    }
    @Test
    public void testS4(){
        sildeshowService.remove("001");
    }
    @Test
    public void testS5(){
        Sildeshow sildeshow=new Sildeshow();
        sildeshow.setId("4564");
        sildeshow.setPath("1");
        sildeshow.setS_desc("1");
        sildeshow.setStatus("1");
        sildeshow.setUpdatetime(new Date());
        sildeshowService.update(sildeshow);
    }
    @Test
    public void testS6(){
        long totals = sildeshowService.findTotals();
        System.out.println(totals);
    }
    @Autowired
    private AlbumService albumService;
    @Test
    public void testA(){
        List<Album> list = albumService.ShowAll();
        for (Album album : list) {
            System.out.println(album);
        }
    }
    @Test
    public void testA2(){
        Long totals = albumService.findTotals();
        System.out.println(totals);
    }
    @Test
    public void testA3(){
        Album album=new Album();
        album.setAlbumpath("1");
        album.settitle("1");
        album.setSet_count(1);
        album.setScore(1.1);
        album.setAuthor("1");
        album.setBroadcast("1");
        album.setBrief("1");
        albumService.add(album);
    }
    @Test
    public void testA4(){
        Album album = albumService.showOne("586dac75fd83");
        System.out.println(album);
    }
    @Test
    public void testA5(){
        albumService.remove("586dac75fd83");
    }
    @Test
    public void testA6(){
        List<Album> albums = albumService.ShowByPage(1, 122);
        for (Album album : albums) {
            System.out.println(album);

        }

    }
    @Test
    public void testA7(){
        Album album=new Album();
        album.setId("e0abd5a40a92");
        album.setBrief("5555555555");
        albumService.update(album);
    }

    @Autowired
    private GuruService guruService;
    @Test
    public void testG(){
        List<Guru> list = guruService.ShowByPage(1, 3);
        for (Guru guru : list) {
            System.out.println(guru);
        }
    }
    @Test
    public void testG2(){
        Guru guru=new Guru();
        guru.setHeadPic("123456");
        guru.setName("测试尼玛仁波切");
        guru.setStatus("Good");
        guruService.add(guru);
    }
    @Test
    public void testG3(){
        guruService.remove("001");
    }
    @Test
    public void testG4(){
        Guru guru=new Guru();
        guru.setName("无敌象拔蚌仁波切");
        guru.setStatus("yes");
        guru.setId("1120e8bd-4d99-449b-a249-08a159826d53");
        guruService.update(guru);
    }
    @Test
    public void testG5(){
        Guru guru = guruService.showOne("1120e8bd-4d99-449b-a249-08a159826d53");
        System.out.println(guru);
    }
    @Test
    public void testG6(){
        List<Guru> gurus = guruService.showAll();
        System.out.println(gurus);
    }
    @Autowired
    private ChaprerService chaprerService;
    @Test
    public void testC(){
        Chapter chapter=new Chapter();
        chapter.setId(UUID.randomUUID().toString());
        chaprerService.add(chapter);
    }
    @Autowired
    private CourseService courseService;
    @Test
    public void testCourse(){
        List<Course> courses = courseService.showByPage(1, 5);
        for (Course cours : courses) {
            System.out.println(cours);
        }
    }
    @Test
    public void testCourse2(){
        Course course=new Course();
        course.setTitle("美美美");
        course.setMarking("学学学");
        courseService.add(course);
    }
    @Test
    public void testCourse3(){
        Course course=new Course();
        course.setId("a8a48c09-60e3-439b-bbbd-ceeeed9a6404");
        course.setTitle("123");
        course.setMarking("321");
        courseService.update(course);
    }
    @Autowired
    private ArticleService articleService;
    @Test
    public void testArt(){
        List<Article> articles = articleService.showByPage(1, 5);
        for (Article article : articles) {
            System.out.println(article);
        }
    }
    @Test
    public void testArt2(){
        Article article=new Article();
        article.setId("");
    }
    @Autowired
    private UserService userService;
    @Test
    public void testU(){
        User user=new User();
        user.setPassword("123");
        userService.add(user);
    }
}
