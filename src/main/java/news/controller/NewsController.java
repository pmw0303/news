package news.controller;

import news.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@Controller
public class NewsController {

    @Autowired
    private NewsService newsService;


    @GetMapping("/")
    public String news(){
        return "news";
    }

    @GetMapping("/news")
    @ResponseBody
    public void getnews(HttpServletResponse response){
        try{
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            response.getWriter().print(newsService.getnews());
        }catch(Exception e){

        }

    }
}
