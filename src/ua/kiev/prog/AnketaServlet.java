package ua.kiev.prog;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Luka on 30.01.2016.
 */
public class AnketaServlet extends HttpServlet {
    static final String TEMPLATE = "<html>" +
            "<head><title>Result</title></head>" +
            "<body><h1>%s</h1></body></html>";

    // private boolean fistanswer;
    // private boolean secondanswer;
    int[] answers = new int[4];

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String fistanswer = req.getParameter("group1");
        String secondanswer = req.getParameter("group2");
        String msg;

        if (fistanswer.equals("Yes")){answers[0]++;}else{answers[1]++;}
        if (secondanswer.equals("Yes")){answers[2]++;}else{answers[3]++;}


        msg = "All results: <br> Number of Java fans - "+answers[0]+"<br>" +
                "Number of Java haters - "+answers[1]+"<br>" +
                "Number of .Net fans - "+answers[2]+"<br>" +
                "Number of .Net haters - "+answers[3]+"<br>";

        resp.getWriter().println(String.format(TEMPLATE, msg));
    }
}
