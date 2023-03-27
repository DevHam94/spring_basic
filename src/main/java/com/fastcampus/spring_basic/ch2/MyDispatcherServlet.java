package com.fastcampus.spring_basic.ch2;

import org.springframework.ui.Model;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

@WebServlet("/myDispatcherServlet")
public class MyDispatcherServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
        Map map = request.getParameterMap();
        Model model = null;
        String viewName = "";
    }

    public static void main(String[] args) {
        String result = "";

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        // 1. 뷰의 내용을 한줄씩 읽어서 하나의 문자열로 만든다.
        Scanner sc = new Scanner(new File(getResolvedViewName(viewName)), "utf-8");

        while(sc.hasNextLine())
            result += sc.nextLine()+ System.lineSeparator();

        // 2. model을 map으로 변환
        Map map = model.asMap();

        // 3. Key를 하나씩 읽어서 template의 ${key}를 value바꾼다.
        Iterator it = map.keySet().iterator();

        while(it.hasNext()){
            String key = (String)it.next();

            // 4. replace()로 key를 value 치환한다.
            result = result.replace("${"+key+"}", map.get(key)+"");
        }

        // 5.렌더링 결과를 출력한다.
        out.println(result);
    }
}
