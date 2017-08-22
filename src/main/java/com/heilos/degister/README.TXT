haojy01
haojy512273389

1、digester.setValidating(false);设置SAX解析xml的DTD校验和schema校验，调用源码可参考Digester类的getFactory()和Digester类的getParser()；
2、digester.setRulesValidation(true);看源码中只和日志打印的功能相关，和逻辑功能无关，在后文的源码中可以看到。
3、digester.setFakeAttributes(fakeAttributes);设置需要过滤的属性，如果设置后在进行类初始化时，配置的属性不会赋值给实例化后的对象，具体功能和实现在下文中会有详细说明。

 digester.addObjectCreate("Server","org.apache.catalina.core.StandardServer","className");