package springmybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springmybatis.Baseservice.BaseService;
import springmybatis.dao.ModuleMpper;
import springmybatis.model.Smodule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ModuleSerivce extends BaseService<Smodule> {

    @Autowired
    private ModuleMpper moduleMpper;


    public Map getmenu(Smodule record,List<Long> modelId) {
        List<Smodule> smodules = super.selectListByWhere(record);
        Map<Long, List<Smodule>> objectObjectHashMap = new HashMap<>();
        for(Long i:modelId)
        {
            List<Smodule> smoudule=new ArrayList<>();
            for(Smodule s:smodules)
            {
                if(i==s.getParentModuleId())
                {
                    smoudule.add(s);
                }
            }
            objectObjectHashMap.put(i,smoudule);
        }
        return objectObjectHashMap;
    }

    @Transactional(value="JpaTransactionManager")
   public List<String> getQuikMenu(){
        return moduleMpper.getQuikMenu();
    }

    @Transactional(value="JpaTransactionManager")
    public List<String> listCountMenu(Integer parentId, String uId){
        return moduleMpper.listCountMenu(parentId,uId);
    }
}
