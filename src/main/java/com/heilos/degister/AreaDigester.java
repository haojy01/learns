package com.heilos.degister;
import org.apache.commons.digester.Digester;

import java.io.File;
import java.lang.Exception;
public class AreaDigester {
    
    public ViewCache digester() throws Exception {
        Digester digester = new Digester();
        digester.setValidating(false);
        digester.addObjectCreate("viewcache/areas", ViewCache.class);
		// 指明匹配模式和要创建的类 
        digester.addObjectCreate("viewcache/areas/area", Area.class);
		// 设置对象属性,与xml文件对应,不设置则是默认
        digester.addBeanPropertySetter("viewcache/areas/area/id", "idbak");
        digester.addBeanPropertySetter("viewcache/areas/area/parentId");
        digester.addBeanPropertySetter("viewcache/areas/area/name", "name");
        digester.addBeanPropertySetter("viewcache/areas/area/areaType", "areaType");
        digester.addBeanPropertySetter("viewcache/areas/area/ordering");
        digester.addBeanPropertySetter("viewcache/areas/area/zip", "zip");
        digester.addBeanPropertySetter("viewcache/areas/area/phoneArea", "phoneArea");
        
        // addSetProperties 和  addCallMethod 可以互换
        // addCallParam(String rule, int  paraIndex,String attributeName) 该方法与addCallMethod配合使用 
        digester.addCallMethod("viewcache/areas/area", "setIdBak", 1);  //属性类型 注意
        digester.addCallParam("viewcache/areas/area",0, "idBak");  
        
       // digester.addSetProperties("viewcache/areas/area");
		// 当移动到下一个标签中时的动作
        digester.addSetNext("viewcache/areas/area", "addArea");
        
        ViewCache vc = null;
        try {
        	File xml = new File("/home/haojy/github/learns/src/main/java/com/heilos/degister/data.xml");
            vc = (ViewCache) digester.parse(xml);
        } catch (Exception e) {
            throw new Exception(e);
        }
        return vc;
    }
    
    public static void main(String[] args) {
    	AreaDigester d = new AreaDigester();
    	try {
			ViewCache digester = d.digester();
			System.out.println(digester);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
