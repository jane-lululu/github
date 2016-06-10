package cn.jane.el.function;
public class MyFunction {
	public static boolean contains(String strs[],String str){
		boolean result = false;
		if(strs!=null&&strs.length>0){
			for(String s:strs){
				if(s.equals(str)){
					result=true;
					break;
				}
			}
		}
		return result;
	}
}