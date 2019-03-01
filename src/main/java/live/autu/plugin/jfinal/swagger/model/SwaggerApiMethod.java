package live.autu.plugin.jfinal.swagger.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
*@author 作者:范文皓
*@createDate 创建时间：2019年2月27日-下午6:19:57 
*/
public class SwaggerApiMethod implements Cloneable {
 
    private String summary;
    private String description;
    private String operationId;
    private String[] consumes ;
    private String[] produces ;
    private List<SwaggerParameter> parameters = new ArrayList<>();
    private Map<String, SwaggerResponse> responses = new HashMap<>();
    private String[] tags;
    
    public SwaggerApiMethod() {
    
    }
    
    public SwaggerApiMethod(String summary, String description, String operationId) {
        this.summary = summary;
        this.description = description;
        this.operationId = operationId;
    }
    
  
    
    public SwaggerApiMethod addParameter(SwaggerParameter parameter) {
        parameters.add(parameter);
        return this;
    }
    
    public SwaggerApiMethod addResponse(String key, SwaggerResponse response) {
        responses.put(key, response);
        return this;
    }

    
    public String getSummary() {
        return summary;
    }
    
    public void setSummary(String summary) {
        this.summary = summary;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getOperationId() {
        return operationId;
    }
    
    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public String[] getConsumes() {
		return consumes;
	}

	public void setConsumes(String[] consumes) {
		this.consumes = consumes;
	}

	public String[] getProduces() {
		return produces;
	}

	public void setProduces(String[] produces) {
		this.produces = produces;
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	public List<SwaggerParameter> getParameters() {
        return parameters;
    }
    
    public void setParameters(List<SwaggerParameter> parameters) {
        this.parameters = parameters;
    }
    
    public Map<String, SwaggerResponse> getResponses() {
        return responses;
    }
    
    public void setResponses(Map<String, SwaggerResponse> responses) {
        this.responses = responses;
    }

	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
    
    
}
