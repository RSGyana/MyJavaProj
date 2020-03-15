package in.nit.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonUtil {
	
	public static Map<Integer,String> convert(List<Object[]> ob){
		
	
			Map<Integer,String> map=new HashMap<>();
			for(Object[] obs:ob) {
				map.put(Integer.valueOf(obs[0].toString()),obs[1].toString());
			}
			return map; 
		}
		
		
	}


