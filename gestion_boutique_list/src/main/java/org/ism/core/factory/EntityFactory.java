package org.ism.core.factory;

import java.util.Map;

public abstract class EntityFactory {
    public abstract IEntity createEntity(String type, Map<String, Object> params);
}

