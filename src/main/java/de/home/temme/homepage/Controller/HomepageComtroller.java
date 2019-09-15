package de.home.temme.homepage.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomepageComtroller {


    @GetMapping("/")
    public String homepage(HttpServletRequest request) {
        return "/index";
    }

    @GetMapping("/Privacy")
    public String privacy(HttpServletRequest request) {
        return "/Privacy";
    }

    @GetMapping("/Terms")
    public String terms(HttpServletRequest request) {
        return "/Terms";
    }

    @GetMapping("/robots.txt")
    public @ResponseBody
    String robots(HttpServletRequest request) {
        return "User-agent: *\r\nDisallow: /";
    }

    @GetMapping("/BroMessage/**")
    public RedirectView BroMessage(HttpServletRequest req) {
        String url = "https://bromessage.camaendir.de";
        if (!req.getRequestURI().startsWith("/")) {
            url = url + "/";
        }
        url = url + req.getRequestURI();
        url = url.replace("/BroMessage", "");
        url = url + "?value=" + req.getParameter("value");
        return new RedirectView(url);
    }

    @GetMapping("/Smart")
    public RedirectView smart(HttpServletRequest request) {
        return new RedirectView("smart.camaendir.de");
    }

    @GetMapping("/ToDo")
    public RedirectView todo(HttpServletRequest request) {
        return new RedirectView("todo.camaendir.de");
    }
}
