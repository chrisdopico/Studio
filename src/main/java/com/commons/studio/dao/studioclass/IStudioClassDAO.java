package com.commons.studio.dao.studioclass;

import com.commons.studio.model.StudioClass;

import java.util.List;

public interface IStudioClassDAO {
    List<StudioClass> getAlLStudioClasses();
    void createStudioClass(StudioClass studioClass);
}
