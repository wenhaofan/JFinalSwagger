package live.autu.plugin.jfinal.swagger.config;

/** 
* @author 作者:范文皓
* @createDate 创建时间：2019年2月28日-下午2:31:37 
*/
public enum RequestMethod {

	GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE;

	private static RequestMethod[] all={GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE};
	
	public static RequestMethod[] all() {
		return all;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString().toLowerCase();
	}
	
}
