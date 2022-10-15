package com.commons.studio.dao.studioclass;

import com.commons.studio.model.StudioClass;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@AllArgsConstructor
@Repository
public class StudioClassDaoImpl implements IStudioClassDAO {

    @Autowired
    IStudioClassJPA studioClassesJPA;

    @Override
    public List<StudioClass> getAlLStudioClasses() {
        return studioClassesJPA.findAll();
    }

    @Override
    public void createStudioClass(StudioClass studioClass) {
        studioClassesJPA.save(studioClass);
    }
}
