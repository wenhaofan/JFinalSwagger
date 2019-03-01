package live.autu.plugin.jfinal.swagger.config;

import java.lang.annotation.Annotation;

import live.autu.plugin.jfinal.swagger.annotation.ApiOperation;

/** 
* @author 作者:范文皓
* @createDate 创建时间：2019年3月1日-上午9:58:01 
*/
public class SwaggerConstant {
	
	/**
	 * swagger api访问路径
	 */
	public static String docApiPath;
	
	public static String configPath="swagger.txt";
	
	public static ApiOperation defaultApiOperation = new ApiOperation() {

		@Override
		public Class<? extends Annotation> annotationType() {
			// TODO Auto-generated method stub
			return ApiOperation.class;
		}

		@Override
		public String value() {
			// TODO Auto-generated method stub
			return "";
		}

		@Override
		public String[] tags() {
			// TODO Auto-generated method stub
			return new String[] {};
		}

		@Override
		public String[] produces() {
			// TODO Auto-generated method stub
			return new String[] {};
		}

		@Override
		public RequestMethod[] methods() {
			// TODO Auto-generated method stub
			return new RequestMethod[] {};
		}

		@Override
		public boolean hidden() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public String description() {
			// TODO Auto-generated method stub
			return "";
		}

		@Override
		public String[] consumes() {
			// TODO Auto-generated method stub
			return new String[] {};
		}
	};

}
