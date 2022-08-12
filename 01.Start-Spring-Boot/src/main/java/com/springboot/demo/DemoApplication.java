package com.springboot.demo;

import cn.smallbun.screw.core.Configuration;
import cn.smallbun.screw.core.engine.EngineConfig;
import cn.smallbun.screw.core.engine.EngineFileType;
import cn.smallbun.screw.core.engine.EngineTemplateType;
import cn.smallbun.screw.core.execute.DocumentationExecute;
import cn.smallbun.screw.core.process.ProcessConfig;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import freemarker.template.Template;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

@RestController
@SpringBootApplication
public class DemoApplication {

	@RequestMapping("/")
	String index() {
//		documentGeneration();
		return "hello spring boot";
	}

	/**
	 * 文档生成
	 */
	static void documentGeneration() {
		//数据源
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
		hikariConfig.setJdbcUrl("jdbc:mysql://xxx:3306/xxx");
		hikariConfig.setUsername("xxx");
		hikariConfig.setPassword("XJkMOjv2@");
		//设置可以获取tables remarks信息
		hikariConfig.addDataSourceProperty("useInformationSchema", "true");
		hikariConfig.setMinimumIdle(2);
		hikariConfig.setMaximumPoolSize(5);
		DataSource dataSource = new HikariDataSource(hikariConfig);
		//生成配置
		EngineConfig engineConfig = EngineConfig.builder()
				//生成文件路径
				.fileOutputDir("D://")
				//打开目录
				.openOutputDir(true)
				//文件类型
				.fileType(EngineFileType.HTML)
				//生成模板实现
				.produceType(EngineTemplateType.freemarker)
				//自定义文件名称
				.fileName("自定义文件名称").build();

		//忽略表
		ArrayList<String> ignoreTableName = new ArrayList<>();
		ignoreTableName.add("test_user");
		ignoreTableName.add("test_group");
		//忽略表前缀
		ArrayList<String> ignorePrefix = new ArrayList<>();
		ignorePrefix.add("test_");
		//忽略表后缀
		ArrayList<String> ignoreSuffix = new ArrayList<>();
		ignoreSuffix.add("_test");
		ProcessConfig processConfig = ProcessConfig.builder()
				//指定生成逻辑、当存在指定表、指定表前缀、指定表后缀时，将生成指定表，其余表不生成、并跳过忽略表配置
				//根据名称指定表生成
				.designatedTableName(new ArrayList<>())
				//根据表前缀生成
				.designatedTablePrefix(new ArrayList<>())
				//根据表后缀生成
				.designatedTableSuffix(new ArrayList<>())
				//忽略表名
				.ignoreTableName(ignoreTableName)
				//忽略表前缀
				.ignoreTablePrefix(ignorePrefix)
				//忽略表后缀
				.ignoreTableSuffix(ignoreSuffix).build();
		//配置
		Configuration config = Configuration.builder()
				//版本
				.version("1.0.0")
				//描述
				.description("数据库设计文档生成")
				//数据源
				.dataSource(dataSource)
				//生成配置
				.engineConfig(engineConfig)
				//生成配置
				.produceConfig(processConfig)
				.build();
		//执行生成
		new DocumentationExecute(config).execute();
	}

//	static String templatePath = "D:\\justforfun\\screw\\screw-core\\src\\main\\resources\\template\\freemarker\\";
//	static String templateName = "documentation_html.ftl";
//	static String targetHtmlPath = "D:\\part2.html";
//
//	public static void crateHTML(String templatePath, String templateName, String targetHtmlPath) {
//		FileWriter out = null;
//
//
//		try {
//			// 通过Configuration读取模版的配置文件
//			freemarker.template.Configuration freemarkerCfg = new freemarker.template.Configuration(Configuration.VERSION_2_3_23);
//			// 加载模版
//			// 设置要解析的模板所在的目录  这里面有三种设置的方式
//			// freemarkerCfg.setDirectoryForTemplateLoading(new File(templatePath));
//			// freemarkerCfg.setServletContextForTemplateLoading(servletContext, path);
//
//			freemarkerCfg.setClassForTemplateLoading(Pdf0020ftlToHtml.class, templatePath);
//			// 设置默认的编码格式
//			freemarkerCfg.setDefaultEncoding("utf-8");
//
//			// 指定模版路径,并且获取模版
//			Template template = freemarkerCfg.getTemplate(templateName, "utf-8");
//
//			// 设置html静态页面输出路径
//			File f = new File(targetHtmlPath);
//			if (!f.exists()) {
//				f.createNewFile();
//			}
//			out = new FileWriter(f);
//
//			template.process(p, out);
//			System.out.println("success");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static void main(String[] args) {
//		crateHTML(templatePath, templateName, targetHtmlPath);
//	}

	public static void main(String[] args) {
//		SpringApplication.run(DemoApplication.class, args);
		documentGeneration();
	}
}
