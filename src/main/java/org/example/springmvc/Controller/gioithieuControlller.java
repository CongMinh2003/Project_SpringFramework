package org.example.springmvc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class gioithieuControlller {
    @GetMapping("/gioithieu")
    public String Showgioithieuform() {
        return "gioithieu";
    }
}
