package com.yf.factory;

import com.yf.container.AbstractMessageListenerContainer;
import com.yf.endpoint.RedisListenerEndpoint;

public interface RedisListenerContainerFactory<V extends AbstractMessageListenerContainer> {

    V createListenerContainer(RedisListenerEndpoint endpoint);

    /** 最大线程数 */
    int getMaxConsumer();

    /** 死信重试次数 */
    int getRetryTimes();
}
