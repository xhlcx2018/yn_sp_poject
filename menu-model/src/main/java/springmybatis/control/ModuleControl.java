package springmybatis.control;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springmybatis.model.Smodule;
import springmybatis.service.ModuleSerivce;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.Queue;

@RestController
@RequestMapping("/module")
public class ModuleControl {

    @Autowired
    private ModuleSerivce  moduleSerivce;

    @RequestMapping(value="/getmenu",method = RequestMethod.POST)
    public Map getmenu(@RequestParam ("modelId") List<Long> modelId)
    {
        Smodule smodule = new Smodule();
        smodule.setActiveFlag((byte) 1);
        Map smodules = moduleSerivce.getmenu(smodule,modelId);
        if(smodules!=null)
        {
            return smodules;
        }
        return  null;
    }

    @RequestMapping(value = "/getquickmenu",method=RequestMethod.GET)
    public List<String> getQuickMenu()
    {
        return moduleSerivce.getQuikMenu();
    }

    @RequestMapping(value = "/listcountmenu",method = RequestMethod.POST)
    public List<String> listCountMenu(
            HttpServletRequest request,HttpServletResponse response,
            @RequestParam("parentId") Integer parentId)
    {
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        return moduleSerivce.listCountMenu( parentId,  username);
    }
}
