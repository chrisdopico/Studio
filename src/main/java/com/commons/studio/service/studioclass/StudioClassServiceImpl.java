package com.commons.studio.service.studioclass;

import com.commons.studio.dao.studioclass.IStudioClassDAO;
import com.commons.studio.model.StudioClass;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StudioClassServiceImpl implements IStudioClassService {

    @Autowired
    IStudioClassDAO studioClassesDAO;

    @Override
    public List<StudioClass> getAlLStudioClasses() {
        return studioClassesDAO.getAlLStudioClasses();
    }

    @Override
    public void createStudioClass(StudioClass studioClass) {
        studioClassesDAO.createStudioClass(studioClass);
    }
}
