package co.edu.uniandes.csw.MarketplaceGroup.service.config;


import co.edu.uniandes.csw.MarketplaceGroup.cart.master.service.CartMasterService;
import co.edu.uniandes.csw.MarketplaceGroup.cart.service.CartService;
import co.edu.uniandes.csw.MarketplaceGroup.item.service.ItemService;
import co.edu.uniandes.csw.MarketplaceGroup.product.service.ProductService;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/webresources")
public class WebApp extends Application {
    
    @Override
    public Set<Class<?>> getClasses() {
        return new HashSet<Class<?>>(Arrays.asList(ProductService.class,ItemService.class, CartService.class,CartMasterService.class));
    }
    
//    private Set<Class<?>> classes;
//
//    @Override
//    public Set<Class<?>> getClasses() {
//        if (classes == null) {
//            try {
//                classes = new LinkedHashSet<Class<?>>();
//                ImmutableSet<ClassPath.ClassInfo> topLevelClasses = ClassPath.from(WebApp.class.getClassLoader()).getTopLevelClassesRecursive("co.edu.uniandes.csw.MarketplaceGroup");
//                for (ClassPath.ClassInfo classInfo : topLevelClasses) {
//                	if(classInfo.getSimpleName().endsWith("Service") && classInfo.getPackageName().contains("service")){
//                       classes.add(classInfo.load());
//					}                
//                }
//                
//                return classes;
//            } catch (IOException ex) {
//                Logger.getLogger(WebApp.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        return classes;
//    }

}