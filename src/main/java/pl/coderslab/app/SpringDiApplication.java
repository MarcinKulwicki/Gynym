package pl.coderslab.app;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class SpringDiApplication {

    public static void main(String[] args) {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(AppConfig.class);
        ctx.register(ConverterConfig.class);
    }

}
