package com.commons.studio.service.studioclass;

import com.commons.studio.model.StudioClass;

import java.util.List;

public interface IStudioClassService {
    List<StudioClass> getAlLStudioClasses();
    void createStudioClass(StudioClass studioClass);
}
