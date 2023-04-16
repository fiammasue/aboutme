package aboutme;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/today")
public class TodayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public TodayServlet() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.println("<head><title>현재시간</title></head>");
		out.println("<body onload=\"show_time()\">");
		out.println("<div style='margin-left: 20px;\r\n"
				+ "    background-color: rgb(53, 53, 132);\r\n"
				+ "    border: 1px solid gray;\r\n"
				+ "    height: 100px;\r\n"
				+ "    width: 250px;\r\n"
				+ "    float: left;\r\n"
				+ "    display: flex;\r\n"
				+ "    justify-content: center;\r\n"
				+ "    align-items: center;'>");
		out.println("<h1 style='margin-left: 30px;'><a style='text-decoration-line: none;\r\n"
				+ "    color:white;' href='/aboutme/index.html'>메인화면</a></h1></div>");
		String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm"));
		out.println("<h1 id='h1_2' style= 'position: absolute;\r\n"
				+ "  left: 50%;\r\n"
				+ "  top: 50%;\r\n"
				+ "  transform: translate(-50%, -50%);'></h1>");
		
		out.println("</body>");
		out.println("<script type=\"text/javascript\">\r\n"
				+ "        function show_time(){\r\n"
				+ "            var ontime= new Date();\r\n"
				+ "            var year = ontime.getFullYear()\r\n"
				+ "            var mon = ontime.getMonth()+1\r\n"
				+ "            var date = ontime.getDate()\r\n"
				+ "            var hour = ontime.getHours()\r\n"
				+ "            var min =ontime.getMinutes();\r\n"
				+ "            var sec = ontime.getSeconds();\r\n"
				+ "            document.getElementById('h1_2').innerHTML=\"현재시간 : \"+year +\"/\"+mon+\"/\"+date+\" \"+hour+\":\"+min+\":\"+sec;\r\n"
				+ "            var t = setTimeout(function(){show_time()},1000)\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "        }\r\n"
				+ "    </script>");
		out.println("</html>");
		}

	}
