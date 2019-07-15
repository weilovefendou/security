package cn.edoclub.house.util;


import cn.edoclub.house.entity.WebBaseModel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.File;
import java.nio.file.Paths;

public class GeneratorCode {

    private static String packageName = "cn.edoclub.house";
    private static String outDir = "E:\\study\\house\\src\\main\\java";
    private static String entity = "entity";
    private static String mapper = "mapper";
    private static String service = "service";
    private static String impl = "service.impl";
    private static String controller = "controller";
    private static String xml = "mapper.xml";
    private static boolean isOverEntity = true;
    private static boolean isOverController = true;
    private static boolean isOverService = true;
    private static boolean isOverServiceImpl = true;
    private static boolean isOverMapper = true;
    private static boolean isOverXml = true;

    private static String entityVM = "/templates/entity.vm";
    private static String controllerVM = "/templates/controller.vm";
    private static String serviceVM = "/templates/service.vm";
    private static String serviceImplVM = "/templates/serviceImpl.vm";
    private static String mapperVM = "/templates/mapper.vm";
    private static String xmlVM = "";//"mapper_xml.vm";
    private static String superController="cn.edoclub.house.controller.BaseController";
    private static String superService="cn.edoclub.house.service.BaseService";
    private static String superServiceImpl="cn.edoclub.house.service.impl.BaseServiceImpl";

    private static String [] baseDir = {entity, mapper, service, impl, controller};
    public static void main(String[] args) {
        //user -> UserService, 设置成true: user -> IUserService
        boolean serviceNameStartWithI = true;
        generateByTables(serviceNameStartWithI, packageName, "house");
    }


    private static void generateByTables(boolean serviceNameStartWithI, String packageName, String... tableNames) {
        GlobalConfig config = new GlobalConfig();

        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        String dbUrl = "jdbc:mysql://localhost:3306/houses?useSSL=false&serverTimezone=GMT%2B8";
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername("root")
                .setPassword("123456")
                .setDriverName("com.mysql.cj.jdbc.Driver");


        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setCapitalMode(false)
                .setEntityLombokModel(true)
                .setRestControllerStyle(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .setSuperControllerClass(superController)
                .setSuperServiceClass(superService)
                .setSuperServiceImplClass(superServiceImpl)
//                .setSuperEntityClass("WebBaseModel")
                .setSuperEntityColumns("create_time","update_time","create_user_id","update_user_id","del_flag")
                //修改替换成你需要的表名，多个表名传数组
                .setInclude(tableNames);


        config.setAuthor("wang wei").setIdType(IdType.UUID)
                 .setActiveRecord(false)
                .setOutputDir(outDir)
                .setBaseResultMap(true)
                .setBaseColumnList(true)
                .setFileOverride(true)
                .setEnableCache(false)
                // XML ResultMap
                .setBaseResultMap(true)
                // XML columList;
                .setBaseColumnList(true);

        if (!serviceNameStartWithI) {
            config.setServiceName("%sService");
        }

        PackageConfig pcf = initPackage();

        TemplateConfig tc = initTemplateConfig(packageName);

        new AutoGenerator().setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(pcf)
                .setTemplate(tc)
                .execute();
    }

    /**
     * 根据自己的需要，修改哪些包下面的 要覆盖还是不覆盖
     * @param packageName
     */
    private static TemplateConfig initTemplateConfig(String packageName) {
        TemplateConfig tc = new TemplateConfig();
        for(String tmp : baseDir) {
            initVM(tc);
            File file = new File(Paths.get(outDir, String.join("/", packageName.split("\\.")), tmp).toString());
            String[] list = file.list();
            if(list != null && list.length > 0) {
                if(!isOverController) {
                    tc.setController(null);
                }
                if(!isOverService) {
                    tc.setService(null);
                }
                if(!isOverServiceImpl) {
                    tc.setServiceImpl(null);
                }
                if(!isOverEntity) {
                    tc.setEntity(null);
                }
                if(!isOverMapper) {
                    tc.setEntity(null);
                }
                if(!isOverXml) {
                    tc.setXml(null);
                }
            }
        }
        return tc;
    }

    private static void initVM(TemplateConfig tc) {
        if(stringIsNotNull(entityVM)) {
            tc.setEntity(entityVM);
        }
        if(stringIsNotNull(mapperVM)) {
            tc.setMapper(mapperVM);
        }
        if(stringIsNotNull(serviceImplVM)) {
            tc.setServiceImpl(serviceImplVM);
        }
        if(stringIsNotNull(serviceVM)) {
            tc.setService(serviceVM);
        }
        if(stringIsNotNull(xmlVM)) {
            tc.setXml(xmlVM);
        }
        if(stringIsNotNull(controllerVM)) {
            tc.setController(controllerVM);
        }
    }

    /**
     * 简单判断字符串是不是为空
     * @param s
     * @return
     */
    private static boolean stringIsNotNull(String s) {
        if(null != s && !s.equals("") && s.length() > 0 && s.trim().length() > 0) {
            return true;
        }
        return false;
    }

    /**
     * 初始化包目录配置
     * @return
     */
    private static PackageConfig initPackage() {
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent(packageName);
        packageConfig.setService(service);
        packageConfig.setServiceImpl(impl);
        packageConfig.setController(controller);
        packageConfig.setEntity(entity);
        packageConfig.setXml(xml);
        return packageConfig;
    }
}