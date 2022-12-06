package com.yf.factory;

import com.yf.container.SimpleMessageListenerContainer;

public class SimpleRedisListenerContainerFactory extends AbstractRedisListenerContainerFactory<SimpleMessageListenerContainer> {

    @Override
    public SimpleMessageListenerContainer createContainerInstance() {
        return new SimpleMessageListenerContainer();
    }

}
